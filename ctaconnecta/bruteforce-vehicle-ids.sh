#!/bin/bash

# Bruteforce vehicleId from 1 to 1000 to find active buses

BASE_URL="https://www.consorcioasturias.org/appcta/api"

# Colors
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
CYAN='\033[0;36m'
NC='\033[0m'

echo "🔍 Bruteforcing Vehicle IDs from 1 to 1000..."
echo ""

FOUND_COUNT=0
CHECKED_COUNT=0

for VEHICLE_ID in $(seq 1 1000); do
    CHECKED_COUNT=$((CHECKED_COUNT + 1))

    # Progress indicator every 50 IDs
    if [ $((CHECKED_COUNT % 50)) -eq 0 ]; then
        echo -e "${CYAN}Checked $CHECKED_COUNT/1000 vehicle IDs... (Found: $FOUND_COUNT)${NC}"
    fi

    # Get coordinates
    RESPONSE=$(curl -s -w "\n%{http_code}" "${BASE_URL}/Coordinates/VehicleCoordinates/${VEHICLE_ID}")

    HTTP_CODE=$(echo "$RESPONSE" | tail -n1)
    BODY=$(echo "$RESPONSE" | sed '$d')

    if [ "$HTTP_CODE" -eq 200 ]; then
        # Check if response is non-empty array
        ARRAY_LEN=$(echo "$BODY" | jq 'length')

        if [ "$ARRAY_LEN" -gt 0 ]; then
            # Get first element if it's an array
            LAT=$(echo "$BODY" | jq -r '.[0].latitude // .latitude // empty')
        else
            LAT=""
        fi

        if [ -n "$LAT" ] && [ "$LAT" != "null" ]; then
            FOUND_COUNT=$((FOUND_COUNT + 1))

            echo ""
            echo -e "${GREEN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
            echo -e "${GREEN}✓ FOUND ACTIVE BUS!${NC}"
            echo -e "${GREEN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
            echo -e "${BLUE}Vehicle ID: $VEHICLE_ID${NC}"
            echo ""

            # Parse and display data (handle both object and array responses)
            LON=$(echo "$BODY" | jq -r '.[0].longitude // .longitude')
            SPEED=$(echo "$BODY" | jq -r '.[0].speed // .speed // 0')
            BEARING=$(echo "$BODY" | jq -r '.[0].bearing // .bearing // "N/A"')
            TIMESTAMP=$(echo "$BODY" | jq -r '.[0].timestamp // .timestamp // "N/A"')

            echo "📍 Position: $LAT, $LON"

            if [ "$SPEED" != "null" ] && [ "$SPEED" != "0" ]; then
                SPEED_KMH=$(echo "$SPEED * 3.6" | bc -l | xargs printf "%.1f")
                echo "🚌 Speed: $SPEED_KMH km/h"
            else
                echo "🚌 Speed: 0 km/h (stopped)"
            fi

            if [ "$BEARING" != "N/A" ]; then
                echo "🧭 Bearing: $BEARING°"
            fi

            if [ "$TIMESTAMP" != "N/A" ]; then
                echo "🕐 Timestamp: $TIMESTAMP"
            fi

            echo "🗺️  Google Maps: https://www.google.com/maps?q=$LAT,$LON"
            echo ""

            # Full JSON
            echo -e "${YELLOW}Full data:${NC}"
            echo "$BODY" | jq '.'
            echo ""
        fi
    fi

    # Small delay to avoid rate limiting
    sleep 0.1
done

echo ""
echo -e "${CYAN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
echo -e "${CYAN}Bruteforce Complete${NC}"
echo -e "${CYAN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
echo "Total IDs checked: $CHECKED_COUNT"
echo "Active buses found: $FOUND_COUNT"

if [ "$FOUND_COUNT" -eq 0 ]; then
    echo ""
    echo -e "${RED}❌ No active buses found with vehicleId 1-1000${NC}"
    echo ""
    echo "💡 Possible reasons:"
    echo "  • Vehicle IDs might be in a different range (e.g., 10000+)"
    echo "  • GPS tracking system is offline"
    echo "  • VehicleIDs change dynamically and aren't sequential"
fi

echo ""
