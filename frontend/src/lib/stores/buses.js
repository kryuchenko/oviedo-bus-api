import { writable } from 'svelte/store';
import { fetchBuses } from '$lib/api/client';

function createBusStore() {
	const { subscribe, set, update } = writable({
		buses: [],
		loading: false,
		error: null,
		lastUpdate: null
	});

	let updateInterval = null;

	return {
		subscribe,

		/**
		 * Start automatic updates every 5 seconds
		 */
		startUpdates: () => {
			if (updateInterval) return;

			// Initial fetch
			busStore.update();

			// Set up interval
			updateInterval = setInterval(() => {
				busStore.update();
			}, 5000);
		},

		/**
		 * Stop automatic updates
		 */
		stopUpdates: () => {
			if (updateInterval) {
				clearInterval(updateInterval);
				updateInterval = null;
			}
		},

		/**
		 * Manually trigger an update
		 */
		update: async () => {
			update(state => ({ ...state, loading: true, error: null }));

			try {
				const data = await fetchBuses();
				set({
					buses: data.buses || [],
					loading: false,
					error: null,
					lastUpdate: data.updated_at
				});
			} catch (error) {
				console.error('Failed to fetch buses:', error);
				update(state => ({
					...state,
					loading: false,
					error: error.message
				}));
			}
		}
	};
}

export const busStore = createBusStore();
