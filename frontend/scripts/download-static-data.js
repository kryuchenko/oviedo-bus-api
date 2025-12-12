#!/usr/bin/env node

/**
 * Download static data from Firebase Firestore
 * Saves to static/data/ for frontend use
 */

import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

const __dirname = path.dirname(fileURLToPath(import.meta.url));

const API_KEY = 'AIzaSyA33UosvNZi3hlyjIV1jTCfUFrOjrZsR6M';
const BASE_URL = 'https://firestore.googleapis.com/v1/projects/alsa-tua/databases/(default)/documents';

async function fetchFirebase(endpoint) {
	const url = `${BASE_URL}${endpoint}?key=${API_KEY}`;
	console.log(`Fetching: ${endpoint}`);

	const response = await fetch(url);
	if (!response.ok) {
		throw new Error(`HTTP ${response.status}: ${response.statusText}`);
	}

	return response.json();
}

function parseField(field) {
	if (field.stringValue !== undefined) return field.stringValue;
	if (field.integerValue !== undefined) return parseInt(field.integerValue);
	if (field.doubleValue !== undefined) return field.doubleValue;
	if (field.booleanValue !== undefined) return field.booleanValue;
	if (field.geoPointValue !== undefined) {
		return {
			lat: field.geoPointValue.latitude,
			lng: field.geoPointValue.longitude
		};
	}
	return null;
}

function parseDocument(doc) {
	const result = {};
	for (const [key, value] of Object.entries(doc.fields || {})) {
		result[key.toLowerCase()] = parseField(value);
	}
	return result;
}

async function downloadGroups() {
	console.log('\n📦 Downloading groups...');
	const data = await fetchFirebase('/groups');

	const groups = data.documents.map(doc => {
		const parsed = parseDocument(doc);
		const groupId = doc.name.split('/').pop();
		return {
			id: groupId,
			name: parsed.name || parsed.linea || groupId,
			color: parsed.color,
			accessibility: parsed.accessibility || parsed.accesibilidad
		};
	});

	console.log(`✅ Downloaded ${groups.length} groups`);
	return groups;
}

async function downloadLines(groupId) {
	const data = await fetchFirebase(`/groups/${groupId}/lines`);

	const lines = data.documents.map(doc => {
		const parsed = parseDocument(doc);
		const lineId = doc.name.split('/').pop();
		return {
			id: lineId,
			group: groupId,
			name: parsed.name || parsed.linea || lineId,
			origin: parsed.origin || parsed.origen,
			destination: parsed.destination || parsed.destino,
			color: parsed.color
		};
	});

	return lines;
}

async function downloadStops(groupId, lineId) {
	const data = await fetchFirebase(`/groups/${groupId}/lines/${lineId}/stops`);

	if (!data.documents) {
		return [];
	}

	const stops = data.documents.map(doc => {
		const parsed = parseDocument(doc);

		return {
			code: parsed.code,      // Firebase uses English lowercase
			name: parsed.name,
			position: parsed.location,  // "location" not "ubicacion"
			line: lineId,          // Use lineId from parameters
			color: parsed.color,
			order: parsed.order
		};
	}).filter(stop => stop.code); // Filter out stops without code

	return stops;
}

async function downloadAllData() {
	try {
		console.log('🚀 Starting Firebase data download...\n');

		// 1. Load scraped polylines if available
		let scrapedPolylines = {};
		try {
			const polylinesPath = path.join(__dirname, '..', 'static', 'data', 'polylines-scraped.json');
			if (fs.existsSync(polylinesPath)) {
				scrapedPolylines = JSON.parse(fs.readFileSync(polylinesPath, 'utf-8'));
				console.log(`✅ Loaded ${Object.keys(scrapedPolylines).length} scraped polylines\n`);
			}
		} catch (error) {
			console.warn('⚠️  Could not load scraped polylines, will use stop-based polylines\n');
		}

		// 2. Download groups
		const groups = await downloadGroups();

		// 2. Download all lines and stops
		const allLines = [];
		const allStops = new Map(); // Use Map to deduplicate by code
		const routeStops = new Map(); // Map route ID to ordered stops

		for (const group of groups) {
			console.log(`\n📍 Processing group ${group.id}...`);

			const lines = await downloadLines(group.id);
			console.log(`  ✅ ${lines.length} lines`);

			for (const line of lines) {
				allLines.push(line);

				const stops = await downloadStops(group.id, line.id);
				console.log(`  ✅ ${line.id}: ${stops.length} stops`);

				// Store ordered stops for this route
				routeStops.set(line.id, stops.sort((a, b) => a.order - b.order));

				// Add stops to map (deduplicate)
				for (const stop of stops) {
					if (!allStops.has(stop.code)) {
						allStops.set(stop.code, {
							code: stop.code,
							name: stop.name,
							position: stop.position,
							lines: [line.id.charAt(0)] // Extract line letter
						});
					} else {
						// Add line to existing stop
						const existing = allStops.get(stop.code);
						const lineLetter = line.id.charAt(0);
						if (!existing.lines.includes(lineLetter)) {
							existing.lines.push(lineLetter);
						}
					}
				}
			}
		}

		// 3. Create routes with ordered stops and polylines
		const routes = allLines.map(line => {
			const stops = routeStops.get(line.id) || [];

			// Get color from group
			const group = groups.find(g => g.id === line.group);
			const routeColor = line.color || group?.color || '#999999';

			// Use stop-based polyline for all routes (Firebase data is authoritative)
			const polyline = stops.map(stop => stop.position).filter(pos => pos);
			console.log(`  📍 Using stop-based polyline for ${line.id} (${polyline.length} points)`);

			return {
				id: line.id,
				name: `${line.id}-${line.destination}`,
				color: routeColor,
				origin: line.origin,
				destination: line.destination,
				polyline: polyline,
				stops: stops.map(s => s.code)
			};
		});

		// 4. Save to files
		const outputDir = path.join(__dirname, '..', 'static', 'data');
		fs.mkdirSync(outputDir, { recursive: true });

		const stopsArray = Array.from(allStops.values());

		fs.writeFileSync(
			path.join(outputDir, 'groups.json'),
			JSON.stringify(groups, null, 2)
		);
		console.log(`\n✅ Saved groups.json (${groups.length} groups)`);

		fs.writeFileSync(
			path.join(outputDir, 'routes.json'),
			JSON.stringify(routes, null, 2)
		);
		console.log(`✅ Saved routes.json (${routes.length} routes)`);

		fs.writeFileSync(
			path.join(outputDir, 'stops.json'),
			JSON.stringify(stopsArray, null, 2)
		);
		console.log(`✅ Saved stops.json (${stopsArray.length} stops)`);

		// 5. Summary
		console.log('\n📊 Summary:');
		console.log(`   Groups: ${groups.length}`);
		console.log(`   Routes: ${routes.length}`);
		console.log(`   Stops: ${stopsArray.length}`);
		console.log('\n✨ Done! Data saved to static/data/');

	} catch (error) {
		console.error('❌ Error:', error.message);
		process.exit(1);
	}
}

downloadAllData();
