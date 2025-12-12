<script>
	import { onMount, onDestroy } from 'svelte';
	import { busStore } from '$lib/stores/buses';
	import { routeStore } from '$lib/stores/routes';
	import { stopStore } from '$lib/stores/stops';
	import Controls from './Controls.svelte';
	import StopWidget from './StopWidget.svelte';
	import RouteFilter from './RouteFilter.svelte';

	let L; // Leaflet instance
	let map;
	let mapElement;
	let busMarkers = new Map();
	let routeLayers = new Map();
	let stopMarkers = new Map();

	// Visibility toggles
	let showRoutes = true;
	let showStops = true;
	let showBuses = true;

	// Route filter - initialize with all lines selected
	let selectedLines = new Set(['A', 'B', 'BÚHO', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'O', 'U', 'V']);

	// Selected stop for widget
	let selectedStop = null;

	// Line colors mapping (from Firebase)
	const lineColors = {
		'A': '#ffee00',
		'B': '#f1bd00',
		'BÚHO': '#1a171c',
		'C': '#004595',
		'D': '#b49a3d',
		'E': '#ec743d',
		'F': '#7ecef1',
		'G': '#494a4b',
		'H': '#80427b',
		'J': '#08c370',
		'K': '#880558',
		'L': '#cd0c03',
		'M': '#f3bbcc',
		'O': '#73366d',
		'U': '#85cf7f',
		'V': '#0d3008'
	};

	onMount(async () => {
		// Dynamic import of Leaflet (browser-only)
		const leaflet = await import('leaflet');
		L = leaflet.default;

		// Initialize map centered on Oviedo
		map = L.map(mapElement).setView([43.3619, -5.8494], 13);

		// Add OpenStreetMap tiles
		L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
			attribution: '© OpenStreetMap contributors',
			maxZoom: 19
		}).addTo(map);

		// Add zoom event listener to scale markers
		map.on('zoomend', () => {
			updateMarkerSizes();
		});

		// Load static data
		await routeStore.load();
		await stopStore.load();

		// Start bus updates
		busStore.startUpdates();
	});

	onDestroy(() => {
		busStore.stopUpdates();
		if (map) {
			map.remove();
		}
	});

	// Subscribe to routes
	$: if ($routeStore.routes.length > 0 && L && map) {
		renderRoutes($routeStore.routes);
	}

	// Subscribe to stops
	$: if ($stopStore.stops.length > 0 && L && map) {
		renderStops($stopStore.stops);
	}

	// Subscribe to buses
	$: if ($busStore.buses.length > 0 && L && map) {
		renderBuses($busStore.buses);
	}

	// Helper to normalize line group (BUHO -> BÚHO)
	function getLineGroup(routeId) {
		let lineGroup = routeId.replace(/\d+$/, ''); // Extract line letter (A1 -> A, BUHO1 -> BUHO)
		if (lineGroup === 'BUHO') {
			lineGroup = 'BÚHO';
		}
		return lineGroup;
	}

	// Calculate stop marker radius based on zoom level
	function getStopRadius() {
		if (!map) return 5;
		const zoom = map.getZoom();
		// Scale radius: smaller at low zoom (far out), larger at high zoom (close in)
		// Zoom 10-11: radius 2-3 (very small when zoomed out)
		// Zoom 13: radius 5 (default)
		// Zoom 15+: radius 6-7 (slightly larger when zoomed in)
		if (zoom <= 11) return 2;
		if (zoom <= 12) return 3;
		if (zoom <= 13) return 5;
		if (zoom <= 14) return 6;
		return 7;
	}

	// Update all stop marker sizes when zoom changes
	function updateMarkerSizes() {
		const newRadius = getStopRadius();
		const newSize = newRadius * 2 + 2;

		stopMarkers.forEach(marker => {
			if (marker.setRadius) {
				// CircleMarker
				marker.setRadius(newRadius);
			} else if (marker.getElement) {
				// DivIcon marker - update SVG size
				const element = marker.getElement();
				if (element) {
					const svg = element.querySelector('svg');
					if (svg) {
						svg.setAttribute('width', newSize);
						svg.setAttribute('height', newSize);
						// Update all circle and path elements
						const circles = svg.querySelectorAll('circle');
						circles.forEach(circle => {
							circle.setAttribute('cx', newSize/2);
							circle.setAttribute('cy', newSize/2);
							circle.setAttribute('r', newSize/2);
						});
						// Re-render paths would be complex, so we'll just update the size for now
					}
				}
			}
		});
	}

	function renderRoutes(routes) {
		console.log('🚍 renderRoutes called:', routes.length, 'routes');

		// Remove old layers if hidden
		if (!showRoutes) {
			routeLayers.forEach(layer => map.removeLayer(layer));
			routeLayers.clear();
			return;
		}

		// Remove routes that are no longer selected
		for (const [routeId, layer] of routeLayers.entries()) {
			const lineGroup = getLineGroup(routeId);
			if (!selectedLines.has(lineGroup)) {
				map.removeLayer(layer);
				routeLayers.delete(routeId);
			}
		}

		// Add/update selected routes
		routes.forEach(route => {
			const lineGroup = getLineGroup(route.id);

			// Skip if line not selected
			if (!selectedLines.has(lineGroup)) {
				return;
			}

			if (routeLayers.has(route.id)) {
				return; // Already rendered
			}

			if (!route.polyline || route.polyline.length === 0) {
				console.warn('⚠️ Route has no polyline:', route.id);
				return;
			}

			console.log(`  ✅ Drawing route ${route.id}:`, route.polyline.length, 'points, color:', route.color);

			const coordinates = route.polyline.map(p => [p.lat, p.lng]);

			// Draw white outline first (underneath)
			const outline = L.polyline(coordinates, {
				color: '#ffffff',
				weight: 6,
				opacity: 0.8,
				smoothFactor: 1
			}).addTo(map);

			// Draw colored line on top
			const polyline = L.polyline(coordinates, {
				color: route.color || '#999999',
				weight: 4,
				opacity: 0.9,
				smoothFactor: 1
			}).addTo(map);

			polyline.bindPopup(`
				<strong>${route.name}</strong><br>
				Stops: ${route.stops.length}
			`);

			// Store both layers together
			const layerGroup = L.layerGroup([outline, polyline]);
			routeLayers.set(route.id, layerGroup);
		});

		console.log('  📍 Total route layers:', routeLayers.size);
	}

	function renderStops(stops) {
		// Remove old markers if hidden
		if (!showStops) {
			stopMarkers.forEach(marker => map.removeLayer(marker));
			stopMarkers.clear();
			return;
		}

		stops.forEach(stop => {
			if (stopMarkers.has(stop.code)) {
				return; // Already rendered
			}

			const numLines = stop.lines?.length || 0;
			let marker;

			if (numLines === 0 || numLines === 1) {
				// Single line or no lines: simple circle
				const lineColor = stop.lines && stop.lines.length > 0
					? (lineColors[stop.lines[0]] || '#999999')
					: '#999999';

				marker = L.circleMarker([stop.position.lat, stop.position.lng], {
					radius: getStopRadius(),
					fillColor: lineColor,
					color: '#ffffff',
					weight: 1,
					fillOpacity: 0.9
				}).addTo(map);
			} else {
				// Multiple lines: create pie chart marker
				const colors = stop.lines.map(line => lineColors[line] || '#999999');
				const size = getStopRadius() * 2 + 2;

				// Create SVG pie chart
				const svgParts = [];
				const angleStep = 360 / numLines;

				for (let i = 0; i < numLines; i++) {
					const startAngle = i * angleStep - 90;
					const endAngle = (i + 1) * angleStep - 90;
					const largeArc = angleStep > 180 ? 1 : 0;

					const x1 = size/2 + (size/2) * Math.cos(startAngle * Math.PI / 180);
					const y1 = size/2 + (size/2) * Math.sin(startAngle * Math.PI / 180);
					const x2 = size/2 + (size/2) * Math.cos(endAngle * Math.PI / 180);
					const y2 = size/2 + (size/2) * Math.sin(endAngle * Math.PI / 180);

					svgParts.push(`<path d="M ${size/2},${size/2} L ${x1},${y1} A ${size/2},${size/2} 0 ${largeArc},1 ${x2},${y2} Z" fill="${colors[i]}"/>`);
				}

				const svgIcon = `
					<svg width="${size}" height="${size}" xmlns="http://www.w3.org/2000/svg">
						<circle cx="${size/2}" cy="${size/2}" r="${size/2}" fill="white"/>
						${svgParts.join('')}
						<circle cx="${size/2}" cy="${size/2}" r="${size/2}" fill="none" stroke="white" stroke-width="1"/>
					</svg>
				`;

				const icon = L.divIcon({
					className: 'multi-line-stop',
					html: svgIcon,
					iconSize: [size, size],
					iconAnchor: [size/2, size/2]
				});

				marker = L.marker([stop.position.lat, stop.position.lng], { icon }).addTo(map);
			}

			marker.on('click', () => {
				selectedStop = stop;
			});

			marker.bindTooltip(stop.name, {
				permanent: false,
				direction: 'top'
			});

			stopMarkers.set(stop.code, marker);
		});
	}

	function renderBuses(buses) {
		// Remove buses that no longer exist
		const currentBusKeys = new Set(buses.map(getBusKey));
		busMarkers.forEach((marker, key) => {
			if (!currentBusKeys.has(key)) {
				map.removeLayer(marker);
				busMarkers.delete(key);
			}
		});

		// Hide all if toggle is off
		if (!showBuses) {
			busMarkers.forEach(marker => map.removeLayer(marker));
			busMarkers.clear();
			return;
		}

		buses.forEach(bus => {
			const key = getBusKey(bus);
			const color = lineColors[bus.line] || '#999999';

			if (busMarkers.has(key)) {
				// Update existing marker position
				busMarkers.get(key).setLatLng([bus.position.lat, bus.position.lng]);
			} else {
				// Create new marker
				const icon = L.divIcon({
					className: 'bus-marker',
					html: `<div style="background: ${color}">${bus.line}</div>`,
					iconSize: [30, 30]
				});

				const marker = L.marker([bus.position.lat, bus.position.lng], { icon })
					.addTo(map);

				const minutes = Math.round(bus.eta / 60);
				const distance = Math.round(bus.distance);

				marker.bindPopup(`
					<strong>Line ${bus.line}</strong><br>
					${bus.destination}<br>
					<hr style="margin: 4px 0">
					📍 ${distance}m<br>
					⏱️ ${minutes} min
				`);

				busMarkers.set(key, marker);
			}
		});
	}

	function getBusKey(bus) {
		return `${bus.line}:${bus.destination}:${bus.next_stop}`;
	}

	function handleToggleRoutes(e) {
		showRoutes = e.detail;
		if (!showRoutes) {
			routeLayers.forEach(layer => map.removeLayer(layer));
			routeLayers.clear();
		} else if ($routeStore.routes.length > 0) {
			renderRoutes($routeStore.routes);
		}
	}

	function handleToggleStops(e) {
		showStops = e.detail;
		if (!showStops) {
			stopMarkers.forEach(marker => map.removeLayer(marker));
			stopMarkers.clear();
		} else if ($stopStore.stops.length > 0) {
			renderStops($stopStore.stops);
		}
	}

	function handleToggleBuses(e) {
		showBuses = e.detail;
		if (!showBuses) {
			busMarkers.forEach(marker => map.removeLayer(marker));
			busMarkers.clear();
		} else if ($busStore.buses.length > 0) {
			renderBuses($busStore.buses);
		}
	}

	function handleFilterChange() {
		if ($routeStore.routes.length > 0 && L && map) {
			renderRoutes($routeStore.routes);
		}
	}
</script>

<div class="map-container">
	<div bind:this={mapElement} class="map"></div>

	<Controls
		{showRoutes}
		{showStops}
		{showBuses}
		busCount={$busStore.buses.length}
		on:toggleRoutes={handleToggleRoutes}
		on:toggleStops={handleToggleStops}
		on:toggleBuses={handleToggleBuses}
	/>

	<RouteFilter
		bind:selectedLines
		{lineColors}
		onFilterChange={handleFilterChange}
	/>

	{#if $busStore.loading}
		<div class="loading">
			Updating buses...
		</div>
	{/if}

	{#if $busStore.error}
		<div class="error">
			Error: {$busStore.error}
		</div>
	{/if}

	{#if selectedStop}
		<StopWidget
			stop={selectedStop}
			on:close={() => selectedStop = null}
		/>
	{/if}
</div>

<style>
	.map-container {
		position: relative;
		width: 100vw;
		height: 100vh;
	}

	.map {
		width: 100%;
		height: 100%;
	}

	/* Hide Leaflet attribution */
	:global(.leaflet-control-attribution) {
		display: none !important;
	}

	/* Multi-line stop markers */
	:global(.multi-line-stop) {
		background: none !important;
		border: none !important;
		cursor: pointer;
	}
</style>
