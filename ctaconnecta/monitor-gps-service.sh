#!/bin/bash

# Monitor when GPS service becomes available

BASE_URL="https://www.consorcioasturias.org/appcta/api"

# Colors
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
CYAN='\033[0;36m'
NC='\033[0m'

echo -e "${CYAN}🔍 Monitoring GPS Service Status${NC}"
echo "Checking every 2 minutes..."
echo "Press Ctrl+C to stop"
echo ""

CHECK_COUNT=0

while true; do
    CHECK_COUNT=$((CHECK_COUNT + 1))
    TIMESTAMP=$(date '+%Y-%m-%d %H:%M:%S')

    echo -e "${CYAN}[Check #$CHECK_COUNT] $TIMESTAMP${NC}"

    # Check a few random stops
    FOUND_ACTIVE=false

    for STOP_ID in 3614 3615 3620 3625 3630; do
        RESPONSE=$(curl -s "${BASE_URL}/StopsFis/${STOP_ID}/60/arrivalEstimates")

        # Check if any vehicle has vehicleId > 0
        ACTIVE_COUNT=$(echo "$RESPONSE" | jq '[.[] | select(.vehicleId > 0)] | length')

        if [ "$ACTIVE_COUNT" -gt 0 ]; then
            FOUND_ACTIVE=true

            echo ""
            echo -e "${GREEN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
            echo -e "${GREEN}✅ GPS SERVICE IS ACTIVE!${NC}"
            echo -e "${GREEN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
            echo -e "${GREEN}Stop ID: $STOP_ID${NC}"
            echo -e "${GREEN}Active buses: $ACTIVE_COUNT${NC}"
            echo ""

            # Show all active buses
            echo "$RESPONSE" | jq -r '.[] | select(.vehicleId > 0) |
                "  • Line \(.lineDesc) → \(.directionDesc)\n    Vehicle ID: \(.vehicleId), Arrives in: \(.minutes) min"'
            echo ""

            # Get GPS coordinates
            VEHICLE_ID=$(echo "$RESPONSE" | jq -r '[.[] | select(.vehicleId > 0)] | .[0].vehicleId')

            if [ "$VEHICLE_ID" != "null" ] && [ "$VEHICLE_ID" != "" ]; then
                echo -e "${YELLOW}Getting GPS coordinates for vehicle $VEHICLE_ID...${NC}"
                COORDS=$(curl -s "${BASE_URL}/Coordinates/VehicleCoordinates/${VEHICLE_ID}")

                LAT=$(echo "$COORDS" | jq -r '.latitude')
                LON=$(echo "$COORDS" | jq -r '.longitude')
                SPEED=$(echo "$COORDS" | jq -r '.speed')

                if [ "$LAT" != "null" ]; then
                    echo -e "📍 Position: $LAT, $LON"

                    if [ "$SPEED" != "null" ]; then
                        SPEED_KMH=$(echo "$SPEED * 3.6" | bc -l | xargs printf "%.1f")
                        echo -e "🚌 Speed: $SPEED_KMH km/h"
                    fi

                    echo -e "🗺️  Map: https://www.google.com/maps?q=$LAT,$LON"
                fi
            fi

            echo ""
            echo -e "${GREEN}✅ GPS service is now working!${NC}"
            echo -e "${YELLOW}Run ./check-all-stops.sh to find all active buses${NC}"

            # Notify (macOS only)
            if command -v osascript &> /dev/null; then
                osascript -e 'display notification "GPS tracking is now active!" with title "CTA Bus Tracker"'
            fi

            exit 0
        fi
    done

    if [ "$FOUND_ACTIVE" = false ]; then
        # Check service message
        MSG=$(curl -s "${BASE_URL}/StopsFis/3614/60/arrivalEstimates" | jq -r '.[0].directionDesc')
        echo -e "${RED}⏸  GPS still offline: ${MSG}${NC}"
    fi

    echo ""
    echo "Next check in 2 minutes..."
    echo ""

    sleep 120  # 2 minutes
done
