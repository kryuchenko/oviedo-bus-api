# TUA Oviedo Bus REST API

**Unofficial documentation** for reverse-engineered TUA bus REST API.

⚠️ **DISCLAIMER:**
- This is **NOT official** documentation
- Reverse-engineered for educational purposes only
- Not affiliated with or endorsed by TUA or ALSA
- API belongs to TUA (Transportes Unidos de Asturias)

---

## Quick Start

### Testing with curl

```bash
# Get bus arrivals at stop 1001
curl "https://www.tua.es/rest/estimaciones/1001"

# Pretty print (requires jq)
curl -s "https://www.tua.es/rest/estimaciones/1001" | jq .
```

### View Interactive Documentation

```bash
# Open OpenAPI specification
open tua-api-swagger.yaml
```

---

## API Endpoint

### `GET /rest/estimaciones/{stop_code}`

Get real-time bus arrival estimates at a specific stop.

**Base URL:** `https://www.tua.es`

**Parameters:**
- `stop_code` (integer, required) - Bus stop code (e.g., 1001, 1332)

**Response 200 OK:**

```json
{
  "estimaciones": {
    "value": [
      {
        "line": "A",
        "line_names": [],
        "vh_first": {
          "cabecera": false,
          "destination_names": [
            {"key": "default", "value": "A1-PLAZA DE AMÉRICA"}
          ],
          "destino": "A1-PLAZA DE AMÉRICA",
          "meters": 412,
          "seconds": 137
        },
        "vh_second": {
          "destino": "A1-PLAZA DE AMÉRICA",
          "meters": 1245,
          "seconds": 389
        },
        "vh_third": null
      }
    ]
  },
  "paradas": [
    {
      "codigo": 1001,
      "lineas": [
        {
          "linea": "A",
          "minutos": 2,
          "metros": 412
        }
      ],
      "nombre": "Aureliano San Román"
    }
  ]
}
```

**Response Fields:**

| Field | Type | Description |
|-------|------|-------------|
| `line` | string | Line identifier (A-V, BÚHO) |
| `vh_first` | object | First (nearest) bus |
| `vh_second` | object | Second bus |
| `vh_third` | object | Third bus (if available) |
| `destino` | string | Bus destination |
| `meters` | integer | Distance from bus to stop (meters) |
| `seconds` | integer | Estimated time to arrival (seconds) |
| `minutos` | integer | Minutes to arrival (calculated from seconds) |

**Response 404:** Stop not found or no data available

---

## Code Examples

### Python

```python
import requests

def get_bus_arrivals(stop_code: int):
    url = f"https://www.tua.es/rest/estimaciones/{stop_code}"
    response = requests.get(url)
    response.raise_for_status()
    return response.json()

# Usage
data = get_bus_arrivals(1001)

for stop in data['paradas']:
    print(f"Stop: {stop['nombre']}")
    for line in stop['lineas']:
        print(f"  Line {line['linea']}: {line['minutos']} min ({line['metros']}m)")
```

### JavaScript

```javascript
async function getBusArrivals(stopCode) {
  const response = await fetch(
    `https://www.tua.es/rest/estimaciones/${stopCode}`
  );
  return await response.json();
}

// Usage
const data = await getBusArrivals(1001);
data.paradas.forEach(stop => {
  console.log(`Stop: ${stop.nombre}`);
  stop.lineas.forEach(line => {
    console.log(`  Line ${line.linea}: ${line.minutos} min`);
  });
});
```

### Using the Python Client

```python
from oviedo_bus_api import TUABusAPI

api = TUABusAPI()

# Get arrivals
arrivals = api.get_arrivals(1001)

# Get next bus for specific line
next_bus = api.get_next_bus(1001, line='A')
print(f"Next bus: {next_bus['minutes']} minutes")

# Get all lines at stop
lines = api.get_lines_at_stop(1001)
print(f"Lines: {', '.join(lines)}")
```

---

## Example Stop Codes

### City Center (1000-1999)

- **1000** - A.Casona - María P. Neira (Line F)
- **1001** - Aureliano San Román (Lines E, D, BÚHO)
- **1332** - HUCA Urgencias (Lines F, V)
- **1221** - Uria Sur (Lines H, L, E, D, A, G)

### Peripheral Areas (4000-4999)

- **4004** - Alejandro Casona (Line F)
- **4258** - Las Campas I (Line E)
- **4518** - Paseo La Florida (Line E)

**Find stops:** https://www.tua.es/es/lineas-y-horarios/

---

## Bus Lines

**Available lines:**
- Regular: A, B, C, D, E, F, G, H, J, K, L, M, O, U, V
- Night service: BÚHO

---

## API Characteristics

### Performance

- **Response time:** 10-30 seconds (typical)
- **Timeout:** Set 30-40 seconds recommended
- **Update frequency:** Data updates every ~10-30 seconds

### Rate Limiting

- No official rate limit documented
- **Recommended:** Max 1 request per 10 seconds
- Respect infrastructure, cache when possible

### CORS

- **Supported:** Yes
- **Headers:** `Access-Control-Allow-Origin: *`
- **Can call from browser:** Yes

---

## Limitations

| Limitation | Description |
|------------|-------------|
| ❌ **No bus GPS** | Only distance/time, no coordinates |
| ❌ **No historical data** | Real-time only |
| ❌ **No schedules** | Use Firebase data instead |
| ❌ **Empty responses** | Returns empty array if no buses |
| ⚠️ **Delays** | Data may be 10-30 seconds behind |

---

## Additional Resources

### Documentation

- **[OpenAPI Specification](tua-api-swagger.yaml)** - Complete API spec (OpenAPI 3.1.0)
- **[Firebase Guide](../firebase/FIREBASE_ACCESS_EXPLAINED.md)** - Access to stops/routes/schedules
- **[GPS Coordinates](../guides/GPS_COORDINATES_README.md)** - All 553 stops with GPS

### Tools

```bash
# Validate OpenAPI spec
npx @apidevtools/swagger-cli validate tua-api-swagger.yaml

# Generate client code
npx @openapitools/openapi-generator-cli generate \
  -i tua-api-swagger.yaml \
  -g python \
  -o ./generated
```

---

## Official Resources

- **TUA Website:** https://www.tua.es
- **Line Search:** https://www.tua.es/es/lineas-y-horarios/
- **Official App:** Available on Google Play & App Store

---

## License

**API:** Property of TUA (Transportes Unidos de Asturias)

**Documentation:** Educational purposes only

For the complete Python SDK, see the [main README](../../README.md).
