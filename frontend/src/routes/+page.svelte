<script>
    import '../app.css';
    import Map from '$lib/components/Map.svelte';
    import { TUA_ROUTES } from '$lib/data/tua_routes.js';
</script>

<svelte:head>
    <title>TUA Bus Map - Oviedo Real-time Tracking</title>
</svelte:head>

<div class="min-h-screen bg-slate-900 text-white font-sans">
    <!-- Header -->
    <header class="fixed top-0 w-full z-20 bg-slate-900/80 backdrop-blur-md border-b border-white/10">
        <div class="max-w-7xl mx-auto px-4 py-4 flex justify-between items-center">
            <h1 class="text-2xl font-bold bg-gradient-to-r from-blue-400 to-purple-400 bg-clip-text text-transparent">
                BusOviedo
            </h1>
            <nav>
                <a href="https://www.tua.es" target="_blank" class="text-sm text-slate-400 hover:text-white transition">Web Oficial TUA</a>
            </nav>
        </div>
    </header>

    <!-- Main Content -->
    <main class="pt-20 pb-10 px-4 max-w-7xl mx-auto space-y-8">
        
        <!-- Map Section -->
        <section class="rounded-3xl overflow-hidden shadow-2xl shadow-blue-900/20 border border-white/10 h-[500px] relative group">
            <Map />
            <div class="absolute inset-0 pointer-events-none border-4 border-white/5 rounded-3xl z-10"></div>
        </section>

        <!-- Routes Section -->
        <section>
            <h2 class="text-3xl font-bold mb-6 pl-2 border-l-4 border-blue-500">Líneas y Horarios</h2>
            <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                {#each TUA_ROUTES as route}
                    <a href={route.url} target="_blank" class="group block p-6 rounded-2xl bg-white/5 hover:bg-white/10 border border-white/5 hover:border-white/20 transition-all duration-300 hover:-translate-y-1 hover:shadow-lg hover:shadow-blue-500/10">
                        <div class="flex items-start justify-between mb-4">
                            <span class="flex items-center justify-center w-12 h-12 rounded-xl bg-gradient-to-br from-blue-500 to-purple-600 text-2xl font-bold shadow-lg shadow-blue-500/30 group-hover:scale-110 transition-transform">
                                {route.id.replace('BÚHO', 'N')}
                            </span>
                            <span class="text-xs font-mono text-slate-400 border border-white/10 px-2 py-1 rounded-full">
                                {route.variants.length} Variantes
                            </span>
                        </div>
                        <h3 class="text-xl font-semibold mb-2 text-slate-100 group-hover:text-blue-300 transition-colors">
                            {route.name}
                        </h3>
                        <div class="space-y-1">
                            {#each route.variants as variant}
                                <div class="text-sm text-slate-400 truncate flex items-center gap-2">
                                    <span class="w-1.5 h-1.5 rounded-full bg-slate-600 group-hover:bg-blue-400 transition-colors"></span>
                                    {variant.name}
                                </div>
                            {/each}
                        </div>
                    </a>
                {/each}
            </div>
        </section>

    </main>
</div>

<style>
    :global(body) {
        background-color: #0f172a; /* slate-900 */
    }
</style>
