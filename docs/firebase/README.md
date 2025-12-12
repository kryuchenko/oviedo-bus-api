# Firebase Firestore Data Access

TUA stores static bus data in Firebase Firestore. This guide explains how to access it.

⚠️ **Educational purposes only** • Not affiliated with Google, Firebase, TUA, or ALSA

---

## Overview

**Project:** `alsa-tua`
**Database:** Firestore (default)
**Access:** REST API with API key

---

## What's Available

| Collection | Data | Count |
|------------|------|-------|
| `groups` | Bus line groups | 16 (A-V, BÚHO) |
| `lines` | Routes with ordered stops | 32 (2 per group) |
| `stops` | Stops with GPS coordinates | 553 (100% coverage) |
| `schedules` | HTML schedules | 16 |
| `prices` | Pricing info | Multiple |
| `accesibility` | Accessibility data | Multiple |

---

## Quick Start

### Download Data

```bash
python3 scripts/download_firebase_data.py
python3 scripts/analyze_firebase_data.py
```

### Using Python Client

```python
from oviedo_bus_api import TUAFirebaseClient

firebase = TUAFirebaseClient()

# Load stops
stops = firebase.load_stops()

# Get stop by code
stop = firebase.get_stop_by_code(1001)

# Search stops
results = firebase.search_stops("Casona")
```

---

## API Access

**Base URL:**
```
https://firestore.googleapis.com/v1/projects/alsa-tua/databases/(default)/documents
```

**Authentication:**
```
?key=AIzaSyA33UosvNZi3hlyjIV1jTCfUFrOjrZsR6M
```

**Example:**
```bash
curl "https://firestore.googleapis.com/v1/projects/alsa-tua/databases/(default)/documents/groups?key=AIzaSyA33UosvNZi3hlyjIV1jTCfUFrOjrZsR6M"
```

---

## Data Structure

### Groups
16 bus line groups with colors, schedules, accessibility info.

### Lines
Each group has 2 lines (directions): ida (outbound) and vuelta (return).

### Stops
Each stop contains:
- Code (integer)
- Name (string)
- GPS coordinates (latitude/longitude, 8 decimal precision)
- Line color
- Order in route

**GPS Coverage:** 100% (all 553 stops)

---

## Downloaded Data Files

After running scripts:

```
data/firebase/
├── tua_firebase_complete.json      # Full database (653 KB)
├── tua_firebase_stops_gps.json     # All stops with GPS (112 KB)
├── tua_firebase_routes.json        # 32 routes (176 KB)
├── tua_firebase_schedules.json     # 16 schedules (10 KB)
└── tua_firebase_stats.json         # Statistics (1.6 KB)
```

---

## OpenAPI Specification

Complete API documentation: **[tua-firebase-api.yaml](tua-firebase-api.yaml)**

Includes:
- All endpoints
- Request/response schemas
- Authentication
- Examples

Import to Swagger UI or Postman.

---

## Security & Legal

**API Key:** Firebase REST API key for TUA project

**Security Rules:** Allow anonymous read access with API key

**Legal:**
- ⚠️ Using API key may violate Firebase ToS
- ✅ Educational/research purposes only
- ❌ Not affiliated with Google, Firebase, TUA, or ALSA
- 📊 Data belongs to TUA/ALSA

**Best Practices:**
- Download once, cache locally
- Don't abuse API access
- Respect infrastructure costs

---

## Resources

- **[OpenAPI Spec](tua-firebase-api.yaml)** - Full API documentation
- **[Main README](../../README.md)** - Project overview
- **[Python Client](../../src/oviedo_bus_api/firebase/)** - Source code

---

**Note:** For real-time bus arrivals, use the [REST API](../api/) instead.
