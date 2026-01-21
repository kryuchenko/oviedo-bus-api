#!/bin/bash

# CTA API - Find Active Buses Script
# Searches for active buses and retrieves their GPS coordinates

BASE_URL="https://www.consorcioasturias.org/appcta/api"

# Colors
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
NC='\033[0m'

echo "🔍 Searching for active buses..."
echo ""

# Step 1: Get stops in Oviedo city center
echo -e "${BLUE}Step 1: Getting stops in Oviedo...${NC}"
STOPS_RESPONSE=$(curl -s "${BASE_URL}/StopsFis/-5.8447876/43.3622222/2000")
STOP_COUNT=$(echo "$STOPS_RESPONSE" | jq '. | length')
echo "Found $STOP_COUNT stops"
echo ""

# Step 2: Check first 10 stops for active buses
echo -e "${BLUE}Step 2: Checking stops for active buses...${NC}"
echo ""

FOUND_VEHICLE=false

for i in {0..9}; do
    STOP_ID=$(echo "$STOPS_RESPONSE" | jq -r ".[$i].id")
    STOP_NAME=$(echo "$STOPS_RESPONSE" | jq -r ".[$i].name" | head -c 60)

    if [ "$STOP_ID" != "null" ]; then
        echo -e "${YELLOW}Checking stop: $STOP_NAME (ID: $STOP_ID)${NC}"

        # Get arrival estimates
        ARRIVALS=$(curl -s "${BASE_URL}/StopsFis/${STOP_ID}/60/arrivalEstimates")

        # Check for active buses (vehicleId > 0)
        VEHICLE_ID=$(echo "$ARRIVALS" | jq -r '[.[] | select(.vehicleId > 0)] | .[0].vehicleId')

        if [ "$VEHICLE_ID" != "null" ] && [ "$VEHICLE_ID" != "" ]; then
            FOUND_VEHICLE=true
            LINE_DESC=$(echo "$ARRIVALS" | jq -r '[.[] | select(.vehicleId > 0)] | .[0].lineDesc')
            DIRECTION=$(echo "$ARRIVALS" | jq -r '[.[] | select(.vehicleId > 0)] | .[0].directionDesc')
            MINUTES=$(echo "$ARRIVALS" | jq -r '[.[] | select(.vehicleId > 0)] | .[0].minutes')

            echo -e "${GREEN}✓ Found active bus!${NC}"
            echo "  Vehicle ID: $VEHICLE_ID"
            echo "  Line: $LINE_DESC"
            echo "  Direction: $DIRECTION"
            echo "  Arrives in: $MINUTES minutes"
            echo ""

            # Step 3: Get GPS coordinates
            echo -e "${BLUE}Step 3: Getting GPS coordinates...${NC}"
            COORDS=$(curl -s "${BASE_URL}/Coordinates/VehicleCoordinates/${VEHICLE_ID}")

            if [ $? -eq 0 ]; then
                echo "$COORDS" | jq '.'

                # Extract key data
                LAT=$(echo "$COORDS" | jq -r '.latitude')
                LON=$(echo "$COORDS" | jq -r '.longitude')
                SPEED=$(echo "$COORDS" | jq -r '.speed')
                BEARING=$(echo "$COORDS" | jq -r '.bearing')

                if [ "$LAT" != "null" ]; then
                    echo ""
                    echo -e "${GREEN}📍 Bus Location:${NC}"
                    echo "  Coordinates: $LAT, $LON"

                    if [ "$SPEED" != "null" ]; then
                        SPEED_KMH=$(echo "$SPEED * 3.6" | bc -l | xargs printf "%.1f")
                        echo "  Speed: $SPEED m/s ($SPEED_KMH km/h)"
                    fi

                    if [ "$BEARING" != "null" ]; then
                        echo "  Bearing: $BEARING°"
                    fi

                    echo ""
                    echo "🗺️  Google Maps: https://www.google.com/maps?q=$LAT,$LON"
                fi
            fi

            break
        fi
    fi
done

if [ "$FOUND_VEHICLE" = false ]; then
    echo -e "${RED}No active buses found at this time.${NC}"
    echo ""
    echo "💡 Tip: Try running this script during peak hours (7-9 AM or 5-8 PM)"
fi

echo ""
echo "✅ Search completed!"
