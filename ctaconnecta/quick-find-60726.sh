#!/bin/bash
BASE_URL="https://www.consorcioasturias.org/appcta/api"
VEHICLE_ID=60726

echo "Searching for vehicle $VEHICLE_ID (checking first 50 stops in 20km radius)..."

STOPS=$(curl -s "${BASE_URL}/StopsFis/-5.8447876/43.3622222/20000")
STOP_COUNT=$(echo "$STOPS" | jq 'length')

echo "Found $STOP_COUNT stops total, checking first 50..."

for i in {0..49}; do
    STOP_ID=$(echo "$STOPS" | jq -r ".[$i].id")
    [ "$STOP_ID" = "null" ] && break
    
    ARRIVALS=$(curl -s "${BASE_URL}/StopsFis/${STOP_ID}/60/arrivalEstimates")
    MATCH=$(echo "$ARRIVALS" | jq ".[] | select(.vehicleId == ${VEHICLE_ID})")
    
    if [ -n "$MATCH" ]; then
        echo ""
        echo "✓ FOUND!"
        echo "$MATCH" | jq '{line: .lineDesc, direction: .directionDesc, company: .companyName, minutes: .minutes, lineId: .lineId, itineraryId: .itineraryId}'
        break
    fi
    
    [ $((i % 10)) -eq 0 ] && echo "Checked $i stops..."
done
