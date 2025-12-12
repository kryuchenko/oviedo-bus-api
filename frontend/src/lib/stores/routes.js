import { writable } from 'svelte/store';
import { fetchRoutes } from '$lib/api/client';

function createRouteStore() {
	const { subscribe, set } = writable({
		routes: [],
		loading: false,
		error: null
	});

	return {
		subscribe,

		/**
		 * Load routes once (they're static)
		 */
		load: async () => {
			console.log('🗺️  Loading routes...');
			set({ routes: [], loading: true, error: null });

			try {
				const data = await fetchRoutes();
				console.log('✅ Loaded routes:', data.routes?.length || 0);

				if (data.routes && data.routes.length > 0) {
					console.log('   First route:', data.routes[0].id);
				}

				set({
					routes: data.routes || [],
					loading: false,
					error: null
				});
			} catch (error) {
				console.error('❌ Failed to fetch routes:', error);
				set({
					routes: [],
					loading: false,
					error: error.message
				});
			}
		}
	};
}

export const routeStore = createRouteStore();
