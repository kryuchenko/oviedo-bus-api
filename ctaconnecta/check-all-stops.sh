#!/bin/bash

# Check ALL stops in Oviedo area for active buses

BASE_URL="https://www.consorcioasturias.org/appcta/api"

# Colors
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
CYAN='\033[0;36m'
NC='\033[0m'

echo "🔍 Checking ALL stops in Oviedo area for active buses..."
echo ""

# Oviedo city center coordinates
LAT="43.3622222"
LON="-5.8447876"
RADIUS="2000"  # 2km radius

echo -e "${BLUE}Getting all stops within ${RADIUS}m from Oviedo center...${NC}"
STOPS_RESPONSE=$(curl -s "${BASE_URL}/StopsFis/${LON}/${LAT}/${RADIUS}")
STOP_COUNT=$(echo "$STOPS_RESPONSE" | jq '. | length')

echo "Found $STOP_COUNT stops total"
echo ""

FOUND_COUNT=0
TOTAL_CHECKED=0

# Check each stop
for i in $(seq 0 $((STOP_COUNT - 1))); do
    STOP_ID=$(echo "$STOPS_RESPONSE" | jq -r ".[$i].id")
    STOP_NAME=$(echo "$STOPS_RESPONSE" | jq -r ".[$i].name")

    if [ "$STOP_ID" != "null" ] && [ "$STOP_ID" != "" ]; then
        TOTAL_CHECKED=$((TOTAL_CHECKED + 1))

        # Progress indicator every 10 stops
        if [ $((TOTAL_CHECKED % 10)) -eq 0 ]; then
            echo -e "${CYAN}Checked $TOTAL_CHECKED/$STOP_COUNT stops...${NC}"
        fi

        # Get arrival estimates
        ARRIVALS=$(curl -s "${BASE_URL}/StopsFis/${STOP_ID}/60/arrivalEstimates")

        # Count active buses (vehicleId > 0)
        ACTIVE_COUNT=$(echo "$ARRIVALS" | jq '[.[] | select(.vehicleId > 0)] | length')

        if [ "$ACTIVE_COUNT" -gt 0 ]; then
            FOUND_COUNT=$((FOUND_COUNT + 1))

            echo ""
            echo -e "${GREEN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
            echo -e "${GREEN}✓ FOUND ACTIVE BUSES!${NC}"
            echo -e "${GREEN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
            echo -e "${BLUE}Stop: ${STOP_NAME:0:60}${NC}"
            echo -e "${BLUE}Stop ID: $STOP_ID${NC}"
            echo -e "${GREEN}Active buses: $ACTIVE_COUNT${NC}"
            echo ""

            # Show all active buses
            echo "$ARRIVALS" | jq -r '.[] | select(.vehicleId > 0) |
                "  • Line \(.lineDesc) → \(.directionDesc)\n    Vehicle ID: \(.vehicleId), Arrives in: \(.minutes) min"'
            echo ""

            # Get coordinates of first active bus
            VEHICLE_ID=$(echo "$ARRIVALS" | jq -r '[.[] | select(.vehicleId > 0)] | .[0].vehicleId')

            if [ "$VEHICLE_ID" != "null" ] && [ "$VEHICLE_ID" != "" ]; then
                echo -e "${YELLOW}Getting GPS coordinates for vehicle $VEHICLE_ID...${NC}"
                COORDS=$(curl -s "${BASE_URL}/Coordinates/VehicleCoordinates/${VEHICLE_ID}")

                LAT_BUS=$(echo "$COORDS" | jq -r '.latitude')
                LON_BUS=$(echo "$COORDS" | jq -r '.longitude')
                SPEED=$(echo "$COORDS" | jq -r '.speed')

                if [ "$LAT_BUS" != "null" ]; then
                    echo -e "📍 Position: $LAT_BUS, $LON_BUS"

                    if [ "$SPEED" != "null" ]; then
                        SPEED_KMH=$(echo "$SPEED * 3.6" | bc -l | xargs printf "%.1f")
                        echo -e "🚌 Speed: $SPEED_KMH km/h"
                    fi

                    echo -e "🗺️  Map: https://www.google.com/maps?q=$LAT_BUS,$LON_BUS"
                fi
            fi
            echo ""
        fi

        # Small delay to avoid rate limiting
        sleep 0.2
    fi
done

echo ""
echo -e "${CYAN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
echo -e "${CYAN}Summary:${NC}"
echo -e "${CYAN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
echo "Total stops checked: $TOTAL_CHECKED"
echo "Stops with active buses: $FOUND_COUNT"

if [ "$FOUND_COUNT" -eq 0 ]; then
    echo ""
    echo -e "${RED}❌ No active buses found at any stop${NC}"
    echo ""
    echo "💡 This is likely because:"
    echo "  • It's currently night time in Spain (buses not running)"
    echo "  • Try again during peak hours: 7-9 AM, 1-3 PM, 5-8 PM"
fi

echo ""
