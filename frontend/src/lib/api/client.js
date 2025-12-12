import { mockBuses, mockStopArrivals } from './mock-data.js';

const API_BASE = import.meta.env.PROD
	? 'https://your-domain.com/api'
	: '/api';

const USE_STATIC_DATA = true; // Load routes/stops from static JSON files
const USE_MOCK_BUSES = true;  // Use mock buses until backend is ready

/**
 * Fetch all active buses with positions
 * @returns {Promise<{buses: Array, updated_at: string}>}
 */
export async function fetchBuses() {
	if (USE_MOCK_BUSES) {
		return Promise.resolve(mockBuses);
	}
	const response = await fetch(`${API_BASE}/buses`);
	if (!response.ok) {
		throw new Error(`Failed to fetch buses: ${response.statusText}`);
	}
	return response.json();
}

/**
 * Fetch buses for specific line
 * @param {string} line - Line letter (A-V, BÚHO)
 * @returns {Promise<{buses: Array}>}
 */
export async function fetchBusesByLine(line) {
	if (USE_MOCK_BUSES) {
		const filtered = mockBuses.buses.filter(b => b.line === line);
		return Promise.resolve({ buses: filtered });
	}
	const response = await fetch(`${API_BASE}/buses/${line}`);
	if (!response.ok) {
		throw new Error(`Failed to fetch buses for line ${line}`);
	}
	return response.json();
}

/**
 * Fetch all routes with polylines
 * @returns {Promise<{routes: Array}>}
 */
export async function fetchRoutes() {
	if (USE_STATIC_DATA) {
		const response = await fetch('/data/routes.json');
		if (!response.ok) {
			throw new Error(`Failed to fetch routes: ${response.statusText}`);
		}
		const routes = await response.json();
		return { routes };
	}
	const response = await fetch(`${API_BASE}/routes`);
	if (!response.ok) {
		throw new Error(`Failed to fetch routes: ${response.statusText}`);
	}
	return response.json();
}

/**
 * Fetch all stops with GPS coordinates
 * @returns {Promise<{stops: Array}>}
 */
export async function fetchStops() {
	if (USE_STATIC_DATA) {
		const response = await fetch('/data/stops.json');
		if (!response.ok) {
			throw new Error(`Failed to fetch stops: ${response.statusText}`);
		}
		const stops = await response.json();
		return { stops };
	}
	const response = await fetch(`${API_BASE}/stops`);
	if (!response.ok) {
		throw new Error(`Failed to fetch stops: ${response.statusText}`);
	}
	return response.json();
}

/**
 * Fetch real-time arrivals at specific stop
 * @param {number} stopCode - Stop code (e.g., 1001)
 * @returns {Promise<{estimaciones: {value: Array}}>}
 */
export async function fetchStopArrivals(stopCode) {
	if (USE_MOCK_BUSES) {
		return Promise.resolve(mockStopArrivals);
	}
	const response = await fetch(`${API_BASE}/stops/${stopCode}/arrivals`);
	if (!response.ok) {
		throw new Error(`Failed to fetch arrivals for stop ${stopCode}`);
	}
	return response.json();
}
