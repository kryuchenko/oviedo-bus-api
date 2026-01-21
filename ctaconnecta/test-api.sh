#!/bin/bash

# CTA API Test Script
# Tests all endpoints from the OpenAPI specification

BASE_URL="https://www.consorcioasturias.org/appcta/api"

# Colors for output
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo "🚌 CTA API Test Script"
echo "====================="
echo ""

# Function to make request and show result
test_endpoint() {
    local name="$1"
    local method="$2"
    local endpoint="$3"
    local data="$4"

    echo -e "${YELLOW}Testing: ${name}${NC}"
    echo "Request: $method $endpoint"

    if [ -z "$data" ]; then
        response=$(curl -s -w "\n%{http_code}" -X "$method" "${BASE_URL}${endpoint}")
    else
        response=$(curl -s -w "\n%{http_code}" -X "$method" -H "Content-Type: application/json" -d "$data" "${BASE_URL}${endpoint}")
    fi

    http_code=$(echo "$response" | tail -n1)
    body=$(echo "$response" | sed '$d')

    if [ "$http_code" -eq 200 ]; then
        echo -e "${GREEN}✓ Status: $http_code${NC}"
        echo "Response (first 500 chars):"
        echo "$body" | head -c 500
        echo ""
    else
        echo -e "${RED}✗ Status: $http_code${NC}"
        echo "Response:"
        echo "$body"
    fi
    echo ""
    echo "---"
    echo ""
}

# ============ STOPS ============
echo "📍 Testing STOPS endpoints..."
echo ""

# 1. Get stops within radius (Oviedo city center)
test_endpoint \
    "Get stops within 1km radius" \
    "GET" \
    "/StopsFis/-5.8447876/43.3622222/1000"

# 2. Get routes for specific stop
test_endpoint \
    "Get routes for stop 3614" \
    "GET" \
    "/StopsFis/3614/itineraries"

# 3. Get arrival estimates
test_endpoint \
    "Get arrival estimates for stop 3614 (next 30 min)" \
    "GET" \
    "/StopsFis/3614/30/arrivalEstimates"

# 4. Get stop by code
test_endpoint \
    "Get stop by code CTA03614" \
    "GET" \
    "/Stops/stops/CTA03614"

# ============ ITINERARIES ============
echo "🗺️  Testing ITINERARIES endpoints..."
echo ""

# 5. Get route stops
test_endpoint \
    "Get stops for route 3581" \
    "GET" \
    "/Itineraries/3581/stopitineraries"

# 6. Get timetable
test_endpoint \
    "Get timetable for route 3581" \
    "GET" \
    "/StopsItinerary/3581/2024-12-16/timetables"

# ============ COORDINATES (GPS) ============
echo "📡 Testing COORDINATES endpoints..."
echo ""

# 7. Get refresh interval
test_endpoint \
    "Get GPS refresh interval" \
    "GET" \
    "/Coordinates/GapTimeRefresh"

# 8. Get object coordinates (generic)
echo -e "${YELLOW}Note: VehicleCoordinates endpoints require active vehicleId from arrival estimates${NC}"
echo ""

# ============ CARDS ============
echo "💳 Testing CARDS endpoints..."
echo ""

# Note: Card endpoints require real card numbers
echo -e "${YELLOW}Skipping card endpoints - require real card serial numbers${NC}"
echo ""

# ============ RATES ============
echo "💰 Testing RATES endpoints..."
echo ""

echo -e "${YELLOW}Skipping rates endpoints - require real card serial numbers${NC}"
echo ""

# ============ Summary ============
echo ""
echo "====================="
echo "✅ Test completed!"
echo ""
echo "📝 Notes:"
echo "  - Some endpoints require real IDs obtained from other endpoints"
echo "  - VehicleId can only be obtained from /StopsFis/{id}/{minutes}/arrivalEstimates"
echo "  - Card/Rate endpoints require valid card serial numbers"
echo ""
echo "💡 Example workflow to get bus coordinates:"
echo "  1. GET /StopsFis/3614/30/arrivalEstimates  → Get vehicleId"
echo "  2. GET /Coordinates/VehicleCoordinates/{vehicleId}  → Get GPS coordinates"
echo ""
