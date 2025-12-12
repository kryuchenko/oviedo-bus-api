import { writable } from 'svelte/store';
import { fetchStops } from '$lib/api/client';

function createStopStore() {
	const { subscribe, set } = writable({
		stops: [],
		loading: false,
		error: null
	});

	return {
		subscribe,

		/**
		 * Load stops once (they're static)
		 */
		load: async () => {
			set({ stops: [], loading: true, error: null });

			try {
				const data = await fetchStops();
				set({
					stops: data.stops || [],
					loading: false,
					error: null
				});
			} catch (error) {
				console.error('Failed to fetch stops:', error);
				set({
					stops: [],
					loading: false,
					error: error.message
				});
			}
		}
	};
}

export const stopStore = createStopStore();
