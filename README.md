# 🚌 Oviedo Bus API

Reverse-engineered Python client for Oviedo (Asturias, Spain) public bus data.

⚠️ **Unofficial** • Educational/research • Not affiliated with TUA/ALSA

[![Python](https://img.shields.io/badge/python-3.13+-blue.svg)](https://www.python.org/downloads/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

---

## 📖 Main Feature: OpenAPI 3.1.0 Specifications

Complete **Swagger/OpenAPI specs** ready to use in Swagger UI, Postman, or any API client:

### 1. REST API - Real-time Bus Arrivals
📄 **[docs/api/tua-api-swagger.yaml](docs/api/tua-api-swagger.yaml)**

Public endpoint (no auth required):
```
GET https://www.tua.es/rest/estimaciones/{stop_code}
```

Returns: Real-time bus arrivals with estimated minutes and meters

### 2. Firebase API - Static Bus Data
📄 **[docs/firebase/tua-firebase-api.yaml](docs/firebase/tua-firebase-api.yaml)**

Firebase Firestore REST API (reverse-engineered from APK):
- **553 stops** with GPS coordinates (100% coverage)
- **32 routes** with ordered stops
- **16 schedules** in HTML format

---

## 🚀 Quick Start

```bash
pip install oviedo-bus-api
```

**Read real-time data:**
Python client for public REST API - get arrivals, next bus times, lines at stop

**Read static data:**
Download Firebase data with included script, then query stops, routes, schedules

**Full documentation:** See [docs/](docs/) folder

---

## 📂 What's Included

### OpenAPI Documentation
- REST API Swagger spec (real-time data)
- Firebase API Swagger spec (static data)
- Complete endpoint documentation
- Request/response examples

### Python Clients
- `TUABusAPI` - REST API client (real-time arrivals)
- `TUAFirebaseClient` - Firebase client (static data with GPS)
- GPS utilities (distance calculations, nearest stops)

### Data Access Scripts
- Download Firebase data from Firestore
- Extract stops, routes, schedules
- 127 tests with 95% coverage

---

## 📊 Data Overview

**Public REST API:**
- Endpoint: `https://www.tua.es/rest/estimaciones/{stop_code}`
- No authentication required
- Real-time bus arrivals, estimated times, distances

**Firebase Firestore:**
- 553 bus stops with GPS (100% coverage, WGS84 datum)
- 32 routes with ordered stops
- 16 schedules in HTML format
- Line colors and accessibility info

**GPS Data:**
- Accuracy: ~5-10 meters
- Coverage: 100% of bus stops
- Verified against official TUA data

---

## 📜 Legal

⚠️ **Not affiliated with TUA or ALSA**

**Code**: MIT License (see [LICENSE](LICENSE))
**Data**: Belongs to TUA/ALSA (not redistributed in this repo)

Users must download Firebase data themselves using provided scripts.

Full details: [LEGAL_COMPLIANCE.md](LEGAL_COMPLIANCE.md)

---

## 🎯 Use Cases

**For Developers:** Build bus apps, integrate bus data, study API design
**For Researchers:** Analyze transport patterns, GPS coverage, scheduling
**For Students:** Learn reverse engineering, Python, API documentation

---

## 📞 Resources

- **TUA Website:** https://www.tua.es
- **Repository:** https://github.com/kryuchenko/oviedo-bus-api
- **Issues:** https://github.com/kryuchenko/oviedo-bus-api/issues
- **Import to Swagger UI:** https://editor.swagger.io

**v3.1.0** • Python 3.13+ • MIT License
