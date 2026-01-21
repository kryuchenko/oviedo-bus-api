#!/bin/bash

# Find which line a specific vehicleId belongs to (improved version)

if [ -z "$1" ]; then
    echo "Usage: ./find-vehicle-line-v2.sh <vehicleId>"
    echo "Example: ./find-vehicle-line-v2.sh 60726"
    exit 1
fi

VEHICLE_ID=$1
BASE_URL="https://www.consorcioasturias.org/appcta/api"

# Colors
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
CYAN='\033[0;36m'
NC='\033[0m'

echo -e "${CYAN}🔍 Searching for vehicle ID: ${VEHICLE_ID}${NC}"
echo ""

# Get vehicle coordinates first
echo "📍 Getting vehicle coordinates..."
COORDS=$(curl -s "${BASE_URL}/Coordinates/VehicleCoordinates/${VEHICLE_ID}")

# API returns array, get first element
LAT=$(echo "$COORDS" | jq -r '.[0].latitude // empty')
LON=$(echo "$COORDS" | jq -r '.[0].longitude // empty')
LOC_DATE=$(echo "$COORDS" | jq -r '.[0].locDate // empty')

if [ -n "$LAT" ]; then
    echo -e "${GREEN}✓ Vehicle found at: $LAT, $LON${NC}"
    echo "🕐 Last update: $LOC_DATE"
    echo "🗺️  Map: https://www.google.com/maps?q=$LAT,$LON"
    echo ""
    
    # Use vehicle's actual location to search nearby stops
    echo "🔍 Searching for this vehicle in nearby stops (2km radius from vehicle position)..."
    echo ""
    
    STOPS=$(curl -s "${BASE_URL}/StopsFis/${LON}/${LAT}/2000")
    STOP_COUNT=$(echo "$STOPS" | jq 'length')
    
    echo "Found $STOP_COUNT stops near vehicle"
    echo ""
    
    FOUND=false
    CHECKED=0
    
    for i in $(seq 0 $((STOP_COUNT - 1))); do
        STOP_ID=$(echo "$STOPS" | jq -r ".[$i].id")
        
        CHECKED=$((CHECKED + 1))
        
        # Progress indicator
        if [ $((CHECKED % 10)) -eq 0 ]; then
            echo -e "${CYAN}Checked $CHECKED/$STOP_COUNT stops...${NC}"
        fi
        
        # Check arrival estimates for this stop
        ARRIVALS=$(curl -s "${BASE_URL}/StopsFis/${STOP_ID}/60/arrivalEstimates")
        
        # Look for our vehicleId
        MATCH=$(echo "$ARRIVALS" | jq -r ".[] | select(.vehicleId == ${VEHICLE_ID})")
        
        if [ -n "$MATCH" ]; then
            FOUND=true
            
            STOP_NAME=$(echo "$STOPS" | jq -r ".[$i].name")
            LINE_DESC=$(echo "$MATCH" | jq -r '.lineDesc')
            DIRECTION=$(echo "$MATCH" | jq -r '.directionDesc')
            ITINERARY=$(echo "$MATCH" | jq -r '.itineraryDesc')
            MINUTES=$(echo "$MATCH" | jq -r '.minutes')
            COMPANY=$(echo "$MATCH" | jq -r '.companyName')
            LINE_ID=$(echo "$MATCH" | jq -r '.lineId')
            ITINERARY_ID=$(echo "$MATCH" | jq -r '.itineraryId')
            
            echo ""
            echo -e "${GREEN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
            echo -e "${GREEN}✓ VEHICLE FOUND!${NC}"
            echo -e "${GREEN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
            echo ""
            echo -e "${BLUE}🚌 Line: ${LINE_DESC}${NC}"
            echo -e "${BLUE}📍 Direction: ${DIRECTION}${NC}"
            echo -e "${BLUE}🛣️  Itinerary: ${ITINERARY}${NC}"
            echo -e "${BLUE}🏢 Company: ${COMPANY}${NC}"
            echo ""
            echo -e "${YELLOW}Next stop: ${STOP_NAME}${NC}"
            echo -e "${YELLOW}Arrives in: ${MINUTES} minutes${NC}"
            echo ""
            echo -e "${CYAN}IDs:${NC}"
            echo "  vehicleId: ${VEHICLE_ID}"
            echo "  lineId: ${LINE_ID}"
            echo "  itineraryId: ${ITINERARY_ID}"
            echo "  stopId: ${STOP_ID}"
            echo ""
            
            # Get all stops on this itinerary
            echo -e "${CYAN}Getting route information...${NC}"
            ROUTE_STOPS=$(curl -s "${BASE_URL}/Itineraries/${ITINERARY_ID}/stopitineraries")
            STOPS_COUNT=$(echo "$ROUTE_STOPS" | jq 'length')
            echo "📋 This route has ${STOPS_COUNT} stops"
            echo ""
            
            break
        fi
    done
    
    if [ "$FOUND" = false ]; then
        echo ""
        echo -e "${YELLOW}⚠ Vehicle ${VEHICLE_ID} not found in any arrival estimates near its location${NC}"
        echo ""
        echo "Possible reasons:"
        echo "  • Vehicle is between stops"
        echo "  • Vehicle recently completed its route"
        echo "  • Try again in a few seconds"
    fi
    
else
    echo -e "${YELLOW}⚠ Could not get coordinates for vehicle $VEHICLE_ID${NC}"
    echo ""
fi

echo ""
