# 🚌 Oviedo Bus API

Python client + **OpenAPI (Swagger) schemas** for Oviedo (Asturias, Spain) public bus data.

- ✅ **Swagger/OpenAPI 3.1 specs** (REST + Firebase)
- ✅ **Fetch data** from the public REST API **and** Firebase (stops/routes/schedules)
- ⚠️ **Unofficial** • Educational/research • Not affiliated with TUA/ALSA

---

## 📚 OpenAPI / Swagger schemas

### 1) Real-time arrivals (REST)
Spec: **[`docs/api/tua-api-swagger.yaml`](docs/api/tua-api-swagger.yaml)**
Open in Swagger Editor:
https://editor.swagger.io/?url=https://raw.githubusercontent.com/kryuchenko/oviedo-bus-api/main/docs/api/tua-api-swagger.yaml

Endpoint (public, no auth):
`GET https://www.tua.es/rest/estimaciones/{stop_code}`

### 2) Static data (Firebase)
Spec: **[`docs/firebase/tua-firebase-api.yaml`](docs/firebase/tua-firebase-api.yaml)**
Open in Swagger Editor:
https://editor.swagger.io/?url=https://raw.githubusercontent.com/kryuchenko/oviedo-bus-api/main/docs/firebase/tua-firebase-api.yaml

---

## 🚀 Install
```bash
pip install oviedo-bus-api
```

---

## 🔌 What you can do

* **Fetch real-time arrivals** via REST API
* **Fetch static transport data** via Firebase
* Use the **OpenAPI specs** in Swagger UI / Postman / any generator

More details: see **[`docs/`](docs/)**

---

## ⚖️ Legal

Code: MIT (see `LICENSE`)
Data: owned by TUA/ALSA (not redistributed in this repo). See `LEGAL_COMPLIANCE.md`.
