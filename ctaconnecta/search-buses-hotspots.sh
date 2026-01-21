#!/bin/bash

# Search for active buses in key locations around Oviedo

BASE_URL="https://www.consorcioasturias.org/appcta/api"

# Colors
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
CYAN='\033[0;36m'
NC='\033[0m'

echo "🔍 Searching for active buses in key Oviedo locations..."
echo ""

# Define key locations in Oviedo (name|lat,lon)
LOCATIONS=(
    "Bus Station (Estación de Autobuses)|43.3614,-5.8507"
    "Train Station (Estación de Renfe)|43.3669,-5.8678"
    "City Center (Plaza Mayor)|43.3623,-5.8447"
    "University Campus|43.3530,-5.8625"
    "Shopping Center El Corte Inglés|43.3642,-5.8510"
)

FOUND_ANY=false

# Check each location
for location_data in "${LOCATIONS[@]}"; do
    IFS='|' read -r location coords <<< "$location_data"
    IFS=',' read -r lat lon <<< "$coords"

    echo -e "${CYAN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
    echo -e "${BLUE}📍 Location: $location${NC}"
    echo -e "${CYAN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"

    # Get stops within 500m
    STOPS_RESPONSE=$(curl -s "${BASE_URL}/StopsFis/${lon}/${lat}/500")
    STOP_COUNT=$(echo "$STOPS_RESPONSE" | jq '. | length')

    echo "Found $STOP_COUNT stops within 500m"

    # Check first 5 stops for active buses
    for i in {0..4}; do
        STOP_ID=$(echo "$STOPS_RESPONSE" | jq -r ".[$i].id")
        STOP_NAME=$(echo "$STOPS_RESPONSE" | jq -r ".[$i].name" | head -c 50)

        if [ "$STOP_ID" != "null" ] && [ "$STOP_ID" != "" ]; then
            # Get arrival estimates
            ARRIVALS=$(curl -s "${BASE_URL}/StopsFis/${STOP_ID}/60/arrivalEstimates")

            # Count active buses (vehicleId > 0)
            ACTIVE_COUNT=$(echo "$ARRIVALS" | jq '[.[] | select(.vehicleId > 0)] | length')

            if [ "$ACTIVE_COUNT" -gt 0 ]; then
                FOUND_ANY=true
                echo -e "${GREEN}✓ Stop: $STOP_NAME (ID: $STOP_ID)${NC}"
                echo -e "${GREEN}  Active buses: $ACTIVE_COUNT${NC}"

                # Show all active buses at this stop
                echo "$ARRIVALS" | jq -r '.[] | select(.vehicleId > 0) |
                    "  • Line \(.lineDesc) → \(.directionDesc)\n    Vehicle ID: \(.vehicleId), Arrives in: \(.minutes) min"'

                # Get coordinates of first active bus
                VEHICLE_ID=$(echo "$ARRIVALS" | jq -r '[.[] | select(.vehicleId > 0)] | .[0].vehicleId')

                if [ "$VEHICLE_ID" != "null" ] && [ "$VEHICLE_ID" != "" ]; then
                    echo ""
                    echo -e "${YELLOW}  Getting GPS coordinates for vehicle $VEHICLE_ID...${NC}"
                    COORDS=$(curl -s "${BASE_URL}/Coordinates/VehicleCoordinates/${VEHICLE_ID}")

                    LAT=$(echo "$COORDS" | jq -r '.latitude')
                    LON=$(echo "$COORDS" | jq -r '.longitude')
                    SPEED=$(echo "$COORDS" | jq -r '.speed')

                    if [ "$LAT" != "null" ]; then
                        echo -e "  📍 Position: $LAT, $LON"

                        if [ "$SPEED" != "null" ]; then
                            SPEED_KMH=$(echo "$SPEED * 3.6" | bc -l | xargs printf "%.1f")
                            echo -e "  🚌 Speed: $SPEED_KMH km/h"
                        fi

                        echo -e "  🗺️  Map: https://www.google.com/maps?q=$LAT,$LON"
                    fi
                fi
                echo ""
            fi
        fi
    done

    echo ""
done

if [ "$FOUND_ANY" = false ]; then
    echo -e "${RED}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
    echo -e "${RED}❌ No active buses found at any location${NC}"
    echo -e "${RED}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
    echo ""
    echo "💡 Tips:"
    echo "  • Try during peak hours: 7-9 AM, 1-3 PM, 5-8 PM"
    echo "  • Buses may be less frequent on weekends"
    echo "  • Some buses may not have GPS tracking enabled"
else
    echo -e "${GREEN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
    echo -e "${GREEN}✅ Search completed - Active buses found!${NC}"
    echo -e "${GREEN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
fi

echo ""
