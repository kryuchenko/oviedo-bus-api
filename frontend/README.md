# TUA Bus Map - Frontend

Real-time bus tracking map for Oviedo built with Svelte + Leaflet.

## Stack

- **Framework:** Svelte 4 + SvelteKit
- **Maps:** Leaflet 1.9.4
- **Package Manager:** Bun
- **Build Tool:** Vite

## Setup

```bash
# Install dependencies
bun install

# Start dev server (http://localhost:5173)
bun run dev

# Build for production
bun run build

# Preview production build
bun run preview
```

## Development

### Backend Required

Frontend expects backend running at `http://localhost:8080` with these endpoints:

- `GET /api/buses` - All active buses
- `GET /api/routes` - All routes with polylines
- `GET /api/stops` - All stops with GPS
- `GET /api/stops/{code}/arrivals` - Real-time arrivals

### Project Structure

```
src/
├── routes/
│   └── +page.svelte          # Main map page
├── lib/
│   ├── components/
│   │   ├── Map.svelte        # Leaflet map
│   │   ├── Controls.svelte   # Layer toggles
│   │   └── StopWidget.svelte # Stop info popup
│   ├── stores/
│   │   ├── buses.js          # Bus positions
│   │   ├── routes.js         # Routes
│   │   └── stops.js          # Stops
│   └── api/
│       └── client.js         # Backend API client
├── app.html                  # HTML template
└── app.css                   # Global styles
```

## Features

- ✅ Real-time bus positions (updates every 5s)
- ✅ Route polylines (color-coded by line)
- ✅ Stop markers (clickable)
- ✅ Stop arrivals widget
- ✅ Layer toggles (routes/stops/buses)
- ✅ Responsive design

## Configuration

### API URL

Edit `src/lib/api/client.js`:

```javascript
const API_BASE = import.meta.env.PROD
	? 'https://your-domain.com/api'
	: '/api';
```

### Map Center

Edit `src/lib/components/Map.svelte`:

```javascript
map = L.map(mapElement).setView([43.3619, -5.8494], 13);
//                                 ↑ lat    ↑ lng   ↑ zoom
```

## Build

```bash
# Production build
bun run build

# Output: build/ directory (static files)
```

## Docker

```bash
# Build image
docker build -t tua-bus-map .

# Run container
docker run -p 80:80 tua-bus-map
```

## License

MIT
