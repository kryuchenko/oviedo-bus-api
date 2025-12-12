<script>
	import { createEventDispatcher } from 'svelte';

	export let showRoutes = true;
	export let showStops = true;
	export let showBuses = true;
	export let busCount = 0;

	const dispatch = createEventDispatcher();

	function handleRoutesToggle(e) {
		dispatch('toggleRoutes', e.target.checked);
	}

	function handleStopsToggle(e) {
		dispatch('toggleStops', e.target.checked);
	}

	function handleBusesToggle(e) {
		dispatch('toggleBuses', e.target.checked);
	}
</script>

<div class="controls">
	<h3>Map Layers</h3>

	<label>
		<input
			type="checkbox"
			checked={showRoutes}
			on:change={handleRoutesToggle}
		/>
		Show Routes
	</label>

	<label>
		<input
			type="checkbox"
			checked={showStops}
			on:change={handleStopsToggle}
		/>
		Show Stops
	</label>

	<label>
		<input
			type="checkbox"
			checked={showBuses}
			on:change={handleBusesToggle}
		/>
		Show Buses ({busCount})
	</label>
</div>
