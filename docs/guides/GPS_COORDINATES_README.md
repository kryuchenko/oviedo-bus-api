# GPS Coordinates Guide

Complete database of TUA bus stops with GPS coordinates for location-based features.

---

## Coverage

**Source:** Firebase Firestore

- **Total stops:** 553
- **With GPS:** 553 (100% coverage)
- **Precision:** 8 decimal places (~1 meter accuracy)

**Previous (web scraping):** 477/553 (86%)
**Current (Firebase):** 553/553 (100%) ✅

---

## Data Format

```json
{
  "code": 1001,
  "name": "Aureliano San Román",
  "latitude": 43.36264038085938,
  "longitude": -5.865974903106689,
  "lines": ["E", "D", "BÚHO"]
}
```

**Datum:** WGS84 (standard GPS)

---

## Getting Started

### Download Data

```bash
python3 scripts/download_firebase_data.py
python3 scripts/analyze_firebase_data.py
```

### Load in Python

```python
from oviedo_bus_api import TUAFirebaseClient

firebase = TUAFirebaseClient()
stops_data = firebase.load_stops()

# All stops with GPS
for stop in stops_data['stops']:
    print(f"{stop['name']}: {stop['latitude']}, {stop['longitude']}")
```

---

## Find Nearest Stops

```python
from oviedo_bus_api.utils import find_nearest_points

# Your location (Oviedo city center)
my_lat, my_lng = 43.3614, -5.8493

# Find stops within 300m
nearest = find_nearest_points(
    target_lat=my_lat,
    target_lon=my_lng,
    points=stops_data['stops'],
    max_distance=300,
    limit=5
)

for stop, distance in nearest:
    print(f"{stop['name']}: {distance:.0f}m away")
```

---

## Calculate Distance

```python
from oviedo_bus_api.utils import haversine_distance, format_distance

# Distance between two stops
stop1 = firebase.get_stop_by_code(1001)
stop2 = firebase.get_stop_by_code(1332)

distance = haversine_distance(
    stop1['latitude'], stop1['longitude'],
    stop2['latitude'], stop2['longitude']
)

print(f"Distance: {format_distance(distance)}")  # e.g., "1.2 km"
```

---

## Use Cases

### 1. Nearby Buses

Combine GPS search with real-time API:

```python
from oviedo_bus_api import TUABusAPI, TUAFirebaseClient
from oviedo_bus_api.utils import find_nearest_points

api = TUABusAPI()
firebase = TUAFirebaseClient()

# Find nearby stops
stops = firebase.load_stops()
nearby = find_nearest_points(43.3614, -5.8493, stops['stops'], 400)

# Get real-time arrivals
for stop, distance in nearby:
    arrivals = api.get_arrivals(stop['code'])
    # Process arrivals...
```

### 2. Map Visualization

Use GPS coordinates with:
- Leaflet.js
- Google Maps
- Mapbox
- OpenStreetMap

### 3. Mobile Apps

Integrate with React Native, Flutter, or native iOS/Android apps.

---

## Data Files

After running scripts:

```
data/firebase/
└── tua_firebase_stops_gps.json    # All 553 stops with GPS
```

Format:
```json
{
  "source": "Firebase Firestore (alsa-tua)",
  "downloaded_at": "2025-12-12",
  "total_stops": 553,
  "gps_coverage": "100%",
  "stops": [...]
}
```

---

## Resources

- **[Python Client](../../src/oviedo_bus_api/)** - GPS utilities source code
- **[Firebase Guide](../firebase/)** - How to access Firebase data
- **[Main README](../../README.md)** - Project overview

---

**Last updated:** 2025-12-12
**GPS coverage:** 100% (553/553)
**Source:** Firebase Firestore (alsa-tua)
