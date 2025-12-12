<script>
	export let selectedLines = new Set();
	export let lineColors = {};
	export let onFilterChange = () => {};

	// Get all line groups from lineColors
	const allLines = Object.keys(lineColors).sort();

	// Toggle individual line
	function toggleLine(line) {
		if (selectedLines.has(line)) {
			selectedLines.delete(line);
		} else {
			selectedLines.add(line);
		}
		selectedLines = selectedLines; // Trigger reactivity
		onFilterChange();
	}

	// Select all lines
	function selectAll() {
		selectedLines = new Set(allLines);
		onFilterChange();
	}

	// Deselect all lines
	function deselectAll() {
		selectedLines = new Set();
		onFilterChange();
	}

	let isOpen = false;
</script>

<div class="route-filter">
	<button class="filter-toggle" on:click={() => isOpen = !isOpen}>
		🚍 Линии ({selectedLines.size}/{allLines.length})
	</button>

	{#if isOpen}
		<div class="filter-panel">
			<div class="filter-header">
				<button class="btn-small" on:click={selectAll}>Все</button>
				<button class="btn-small" on:click={deselectAll}>Очистить</button>
			</div>

			<div class="filter-list">
				{#each allLines as line}
					<label class="filter-item">
						<input
							type="checkbox"
							checked={selectedLines.has(line)}
							on:change={() => toggleLine(line)}
						/>
						<span class="line-badge" style="background-color: {lineColors[line]}">
							{line}
						</span>
					</label>
				{/each}
			</div>
		</div>
	{/if}
</div>

<style>
	.route-filter {
		position: absolute;
		top: 10px;
		right: 10px;
		z-index: 1000;
	}

	.filter-toggle {
		background: white;
		border: 2px solid rgba(0, 0, 0, 0.2);
		border-radius: 8px;
		padding: 8px 16px;
		font-size: 14px;
		font-weight: 600;
		cursor: pointer;
		box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
		transition: all 0.2s;
	}

	.filter-toggle:hover {
		background: #f8f8f8;
		box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
	}

	.filter-panel {
		position: absolute;
		top: 48px;
		right: 0;
		background: white;
		border-radius: 8px;
		box-shadow: 0 4px 16px rgba(0, 0, 0, 0.2);
		padding: 12px;
		min-width: 200px;
		max-height: 400px;
		overflow-y: auto;
	}

	.filter-header {
		display: flex;
		gap: 8px;
		margin-bottom: 12px;
		padding-bottom: 12px;
		border-bottom: 1px solid #e0e0e0;
	}

	.btn-small {
		flex: 1;
		padding: 6px 12px;
		background: #f0f0f0;
		border: 1px solid #ddd;
		border-radius: 4px;
		font-size: 12px;
		font-weight: 600;
		cursor: pointer;
		transition: all 0.2s;
	}

	.btn-small:hover {
		background: #e0e0e0;
	}

	.filter-list {
		display: flex;
		flex-direction: column;
		gap: 8px;
	}

	.filter-item {
		display: flex;
		align-items: center;
		gap: 8px;
		padding: 4px;
		cursor: pointer;
		border-radius: 4px;
		transition: background 0.2s;
	}

	.filter-item:hover {
		background: #f5f5f5;
	}

	.filter-item input[type="checkbox"] {
		width: 18px;
		height: 18px;
		cursor: pointer;
	}

	.line-badge {
		display: inline-block;
		padding: 4px 12px;
		border-radius: 12px;
		color: white;
		font-weight: bold;
		font-size: 14px;
		text-shadow: 0 1px 2px rgba(0, 0, 0, 0.3);
		min-width: 40px;
		text-align: center;
	}
</style>
