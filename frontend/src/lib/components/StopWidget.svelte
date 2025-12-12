<script>
	import { onMount, createEventDispatcher } from 'svelte';
	import { fetchStopArrivals } from '$lib/api/client';

	export let stop;

	const dispatch = createEventDispatcher();

	let arrivals = [];
	let loading = true;
	let error = null;
	let updateInterval = null;

	onMount(() => {
		loadArrivals();
		updateInterval = setInterval(loadArrivals, 10000); // Update every 10s

		return () => {
			if (updateInterval) {
				clearInterval(updateInterval);
			}
		};
	});

	async function loadArrivals() {
		try {
			loading = true;
			error = null;
			const data = await fetchStopArrivals(stop.code);
			arrivals = data.estimaciones?.value || [];
		} catch (err) {
			console.error('Failed to load arrivals:', err);
			error = err.message;
		} finally {
			loading = false;
		}
	}

	function formatTime(seconds) {
		const minutes = Math.floor(seconds / 60);
		if (minutes === 0) return 'Arriving now';
		if (minutes === 1) return '1 min';
		return `${minutes} min`;
	}

	function formatDistance(meters) {
		if (meters < 1000) {
			return `${meters}m`;
		}
		return `${(meters / 1000).toFixed(1)}km`;
	}

	function close() {
		dispatch('close');
	}
</script>

<div class="widget">
	<div class="widget-header">
		<div>
			<h3>{stop.name}</h3>
			<p class="stop-code">Stop #{stop.code}</p>
		</div>
		<button class="close-btn" on:click={close}>×</button>
	</div>

	<div class="widget-content">
		{#if loading && arrivals.length === 0}
			<div class="loading-state">
				Loading arrivals...
			</div>
		{:else if error}
			<div class="error-state">
				{error}
			</div>
		{:else if arrivals.length === 0}
			<div class="empty-state">
				No buses arriving soon
			</div>
		{:else}
			<div class="arrivals">
				{#each arrivals as lineData}
					{#if lineData.vh_first}
						<div class="arrival-item">
							<div class="line-badge" style="background: {getLineColor(lineData.line)}">
								{lineData.line}
							</div>
							<div class="arrival-info">
								<div class="destination">{lineData.vh_first.destino}</div>
								<div class="timing">
									<span class="time">{formatTime(lineData.vh_first.seconds)}</span>
									<span class="distance">{formatDistance(lineData.vh_first.meters)}</span>
								</div>
							</div>
						</div>
					{/if}

					{#if lineData.vh_second}
						<div class="arrival-item secondary">
							<div class="line-badge" style="background: {getLineColor(lineData.line)}">
								{lineData.line}
							</div>
							<div class="arrival-info">
								<div class="destination">{lineData.vh_second.destino}</div>
								<div class="timing">
									<span class="time">{formatTime(lineData.vh_second.seconds)}</span>
									<span class="distance">{formatDistance(lineData.vh_second.meters)}</span>
								</div>
							</div>
						</div>
					{/if}

					{#if lineData.vh_third}
						<div class="arrival-item secondary">
							<div class="line-badge" style="background: {getLineColor(lineData.line)}">
								{lineData.line}
							</div>
							<div class="arrival-info">
								<div class="destination">{lineData.vh_third.destino}</div>
								<div class="timing">
									<span class="time">{formatTime(lineData.vh_third.seconds)}</span>
									<span class="distance">{formatDistance(lineData.vh_third.meters)}</span>
								</div>
							</div>
						</div>
					{/if}
				{/each}
			</div>
		{/if}
	</div>
</div>

<script context="module">
	const lineColors = {
		'A': '#ec743d', 'B': '#e91e63', 'C': '#9c27b0', 'D': '#673ab7',
		'E': '#3f51b5', 'F': '#2196f3', 'G': '#03a9f4', 'H': '#00bcd4',
		'J': '#009688', 'K': '#4caf50', 'L': '#8bc34a', 'M': '#cddc39',
		'O': '#ffeb3b', 'U': '#ffc107', 'V': '#ff9800', 'BÚHO': '#795548'
	};

	function getLineColor(line) {
		return lineColors[line] || '#999999';
	}
</script>

<style>
	.widget {
		position: fixed;
		bottom: 20px;
		left: 50%;
		transform: translateX(-50%);
		background: white;
		border-radius: 12px;
		box-shadow: 0 4px 16px rgba(0,0,0,0.3);
		max-width: 400px;
		width: 90%;
		max-height: 60vh;
		overflow: hidden;
		z-index: 1000;
	}

	.widget-header {
		display: flex;
		justify-content: space-between;
		align-items: flex-start;
		padding: 16px;
		border-bottom: 1px solid #eee;
	}

	.widget-header h3 {
		margin: 0;
		font-size: 18px;
		font-weight: 600;
	}

	.stop-code {
		margin: 4px 0 0 0;
		font-size: 12px;
		color: #666;
	}

	.close-btn {
		background: none;
		border: none;
		font-size: 28px;
		line-height: 1;
		cursor: pointer;
		color: #999;
		padding: 0;
		width: 28px;
		height: 28px;
		display: flex;
		align-items: center;
		justify-content: center;
	}

	.close-btn:hover {
		color: #333;
	}

	.widget-content {
		padding: 16px;
		max-height: calc(60vh - 80px);
		overflow-y: auto;
	}

	.loading-state,
	.error-state,
	.empty-state {
		text-align: center;
		padding: 20px;
		color: #666;
	}

	.error-state {
		color: #ff4444;
	}

	.arrivals {
		display: flex;
		flex-direction: column;
		gap: 12px;
	}

	.arrival-item {
		display: flex;
		gap: 12px;
		align-items: center;
		padding: 12px;
		background: #f5f5f5;
		border-radius: 8px;
	}

	.arrival-item.secondary {
		opacity: 0.7;
	}

	.line-badge {
		min-width: 40px;
		height: 40px;
		border-radius: 8px;
		display: flex;
		align-items: center;
		justify-content: center;
		color: white;
		font-weight: bold;
		font-size: 16px;
	}

	.arrival-info {
		flex: 1;
	}

	.destination {
		font-weight: 600;
		font-size: 14px;
		margin-bottom: 4px;
	}

	.timing {
		display: flex;
		gap: 12px;
		font-size: 12px;
		color: #666;
	}

	.time {
		font-weight: 600;
		color: #333;
	}
</style>
