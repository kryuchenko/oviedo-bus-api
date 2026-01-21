# CTA API - Curl Examples

Collection of ready-to-use curl commands for testing all CTA API endpoints.

## Base URL
```bash
BASE_URL="https://www.consorcioasturias.org/appcta/api"
```

---

## 📍 STOPS Endpoints

### 1. Get stops within radius
Get all stops within specified radius from coordinates.

```bash
# Get stops within 1km from Oviedo city center
curl -s "${BASE_URL}/StopsFis/-5.8447876/43.3622222/1000" | jq '.'

# Get stops within 2km
curl -s "${BASE_URL}/StopsFis/-5.8447876/43.3622222/2000" | jq '.'
```

**Parameters:**
- longitude: -5.8447876 (WGS84)
- latitude: 43.3622222 (WGS84)
- radius: 1000 (meters)

---

### 2. Get routes for stop
Get all routes passing through specific stop.

```bash
# Get routes for stop 3614
curl -s "${BASE_URL}/StopsFis/3614/itineraries" | jq '.'

# Pretty print with key fields only
curl -s "${BASE_URL}/StopsFis/3614/itineraries" | jq '.[] | {lineDesc, directionDesc, minutes}'
```

---

### 3. Get arrival predictions
Get bus arrival predictions for next N minutes.

```bash
# Get arrivals for next 30 minutes
curl -s "${BASE_URL}/StopsFis/3614/30/arrivalEstimates" | jq '.'

# Get arrivals for next 60 minutes
curl -s "${BASE_URL}/StopsFis/3614/60/arrivalEstimates" | jq '.'

# Show only active buses (vehicleId > 0)
curl -s "${BASE_URL}/StopsFis/3614/60/arrivalEstimates" | jq '[.[] | select(.vehicleId > 0)]'

# Extract vehicle IDs
curl -s "${BASE_URL}/StopsFis/3614/60/arrivalEstimates" | jq -r '.[] | select(.vehicleId > 0) | .vehicleId'
```

**Response fields:**
- `vehicleId`: Bus ID for GPS tracking (0 if unavailable)
- `minutes`: Time until arrival in minutes (null if no prediction)
- `lineDesc`: Route number (e.g., "H")
- `directionDesc`: Direction of travel
- `itineraryId`: Route ID

---

### 4. Get stop by code
Get stop information by its code/name.

```bash
# Get stop by code (Note: This endpoint may return 404)
curl -s "${BASE_URL}/Stops/stops/CTA03614" | jq '.'
```

**Note:** This endpoint currently returns 404. Use `/StopsFis/{longitude}/{latitude}/{radius}` instead.

---

## 🗺️ ITINERARIES Endpoints

### 5. Get route stops
Get all stops on the route.

```bash
# Get stops for route 3581
curl -s "${BASE_URL}/Itineraries/3581/stopitineraries" | jq '.'

# Show stop names only
curl -s "${BASE_URL}/Itineraries/3581/stopitineraries" | jq '.[] | .stopName'
```

---

### 6. Get stops for specific bus
Get route stops for specific bus.

```bash
# Get stops for bus 12345 on route 3581
curl -s "${BASE_URL}/Itineraries/3581/12345/stopitineraries" | jq '.'
```

**Note:** Requires valid vehicleId from arrival estimates.

---

### 7. Get timetable
Get timetable for route on specified date.

```bash
# Get timetable for route 3581 on Dec 16, 2024
curl -s "${BASE_URL}/StopsItinerary/3581/2024-12-16/timetables" | jq '.'

# Get today's timetable
DATE=$(date +%Y-%m-%d)
curl -s "${BASE_URL}/StopsItinerary/3581/${DATE}/timetables" | jq '.'
```

---

## 📡 COORDINATES (GPS) Endpoints

### 8. Get GPS refresh interval
Get recommended GPS coordinates update interval in seconds.

```bash
# Get refresh interval (returns 60)
curl -s "${BASE_URL}/Coordinates/GapTimeRefresh"
```

**Response:** `60` (seconds)

---

### 9. Get object coordinates
Get GPS coordinates for specified ID.

```bash
# Get coordinates for object 12345
curl -s "${BASE_URL}/Coordinates/coordinates/12345" | jq '.'
```

---

### 10. Get bus coordinates
Get current GPS coordinates of specific bus in real-time.

```bash
# First, get vehicleId from arrival estimates
VEHICLE_ID=$(curl -s "${BASE_URL}/StopsFis/3614/60/arrivalEstimates" | jq -r '[.[] | select(.vehicleId > 0)] | .[0].vehicleId')

# Then get coordinates
if [ "$VEHICLE_ID" != "null" ] && [ "$VEHICLE_ID" != "" ]; then
    curl -s "${BASE_URL}/Coordinates/VehicleCoordinates/${VEHICLE_ID}" | jq '.'
else
    echo "No active buses found"
fi
```

**Response fields:**
- `latitude`, `longitude`: GPS coordinates (WGS84)
- `speed`: Speed in m/s (multiply by 3.6 for km/h)
- `bearing`: Direction relative to north (0-360°)
- `headingDegrees`: Bus course direction
- `speedAccuracyMetersPerSecond`: Speed accuracy
- `bearingAccuracyDegrees`: Bearing accuracy
- `headingErrorDegrees`: Heading error

---

### 11. Get all buses on route
Get GPS coordinates of all active buses on specified route.

```bash
# First, get itineraryId from arrival estimates
ITINERARY_ID=$(curl -s "${BASE_URL}/StopsFis/3614/60/arrivalEstimates" | jq -r '[.[] | select(.vehicleId > 0)] | .[0].itineraryId')

# Then get all buses on this route
if [ "$ITINERARY_ID" != "null" ] && [ "$ITINERARY_ID" != "" ]; then
    curl -s "${BASE_URL}/Coordinates/VehiclesCoordinates/${ITINERARY_ID}" | jq '.'
else
    echo "No active routes found"
fi
```

---

## 💳 CARDS Endpoints

### 12. Get card information
Get information about transport card.

```bash
# Get card info (requires real card serial number)
curl -s "${BASE_URL}/Card/1234567890" | jq '.'
```

---

### 13. Get card token
Get token for card.

```bash
# Get card token
curl -s "${BASE_URL}/CardToken/token123" | jq '.'
```

---

### 14. Check recharge possibility
Check if user can recharge the card.

```bash
# Check if user can recharge (requires real NIF)
curl -s "${BASE_URL}/UserCard/canRecharge/12345678A" | jq '.'
```

---

## 💰 RECHARGE Endpoints

### 15. Get online recharge info
Get information for online recharge.

```bash
# Get recharge info
curl -s "${BASE_URL}/OnlineRecharge/1234567890" | jq '.'
```

---

### 16. Recharge card by token
Execute card recharge using token.

```bash
# Recharge card
curl -s -X POST \
  -H "Content-Type: application/json" \
  -d '{"amount": 10.00, "paymentMethod": "credit_card"}' \
  "${BASE_URL}/CardTokenRecharge/1234567890/token123" | jq '.'
```

---

### 17. Get auto-recharge configuration
Get auto-recharge configuration.

```bash
# Get global config
curl -s "${BASE_URL}/AutomaticRechargeConfig" | jq '.'

# Get global settings
curl -s "${BASE_URL}/AutomaticRechargeConfig/global" | jq '.'

# Get config for specific card
curl -s "${BASE_URL}/AutomaticRechargeConfig/1234567890" | jq '.'
```

---

### 18. Change auto-recharge status
Change auto-recharge status.

```bash
# Enable auto-recharge
curl -s -X POST \
  -H "Content-Type: application/json" \
  -d '{"enabled": true}' \
  "${BASE_URL}/AutomaticRechargeConfig/changeStatus/1234567890" | jq '.'
```

---

## 💵 RATES Endpoints

### 19. Get pass rates
Get transport pass rates.

```bash
# Get pass rates
curl -s "${BASE_URL}/Rates/ctaPassRates/1234567890" | jq '.'
```

---

### 20. Get ten-pass travels
Get travel history for ten-pass.

```bash
# Get travel history
curl -s "${BASE_URL}/Rates/ctaTenPassTravels/1234567890" | jq '.'
```

---

## 🔐 AUTH Endpoints

### 21. Create user
Create new user.

```bash
# Create user
curl -s -X POST \
  -H "Content-Type: application/json" \
  -d '{
    "email": "user@example.com",
    "name": "John Doe",
    "nif": "12345678A",
    "dateOfBirth": "1990-01-01"
  }' \
  "${BASE_URL}/DoB" | jq '.'
```

---

### 22. Get user data
Get user data by transaction ID.

```bash
# Get user data
curl -s "${BASE_URL}/DoB/userData/transaction123" | jq '.'
```

---

## 🔄 Common Workflows

### Find active buses and get coordinates

```bash
#!/bin/bash
BASE_URL="https://www.consorcioasturias.org/appcta/api"

# 1. Get stops near Oviedo center
STOPS=$(curl -s "${BASE_URL}/StopsFis/-5.8447876/43.3622222/2000")

# 2. Get first stop ID
STOP_ID=$(echo "$STOPS" | jq -r '.[0].id')

# 3. Get arrival estimates
ARRIVALS=$(curl -s "${BASE_URL}/StopsFis/${STOP_ID}/60/arrivalEstimates")

# 4. Get first active vehicle ID
VEHICLE_ID=$(echo "$ARRIVALS" | jq -r '[.[] | select(.vehicleId > 0)] | .[0].vehicleId')

# 5. Get GPS coordinates
if [ "$VEHICLE_ID" != "null" ] && [ "$VEHICLE_ID" != "" ]; then
    echo "Getting coordinates for vehicle $VEHICLE_ID..."
    curl -s "${BASE_URL}/Coordinates/VehicleCoordinates/${VEHICLE_ID}" | jq '.'
else
    echo "No active buses found"
fi
```

---

### Monitor bus approaching stop

```bash
#!/bin/bash
BASE_URL="https://www.consorcioasturias.org/appcta/api"
STOP_ID=3614

while true; do
    clear
    echo "Monitoring stop $STOP_ID - $(date)"
    echo "================================"

    curl -s "${BASE_URL}/StopsFis/${STOP_ID}/60/arrivalEstimates" | \
        jq -r '.[] | select(.vehicleId > 0) |
        "Line \(.lineDesc) → \(.directionDesc): \(.minutes) min (Vehicle: \(.vehicleId))"'

    sleep 15
done
```

---

## 📝 Notes

1. **Rate Limiting**: Respect the API rate limits
   - GPS coordinates: max 1 request per 60 seconds per vehicleId
   - Arrival predictions: max 1 request per 15 seconds per stopId
   - Parallel requests: max 5 simultaneously

2. **VehicleId**: Can only be obtained from `/StopsFis/{id}/{minutes}/arrivalEstimates`

3. **Dynamic Polling**: Adjust polling interval based on arrival time:
   - Bus far away (>10 min): 60 seconds
   - Bus nearby (2-10 min): 30 seconds
   - Bus very close (<2 min): 15 seconds

4. **GPS Coordinates**: VehicleId = 0 means GPS data is unavailable for that bus

---

## 🛠️ Tools

Install `jq` for JSON parsing:
```bash
# macOS
brew install jq

# Ubuntu/Debian
sudo apt-get install jq

# Windows (via chocolatey)
choco install jq
```
