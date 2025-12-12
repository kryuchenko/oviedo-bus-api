// Mock data for testing frontend without backend

export const mockRoutes = {
	routes: [
		{
			id: 'E1',
			name: 'E1-LA MONXINA',
			color: '#3f51b5',
			polyline: [
				{ lat: 43.3619, lng: -5.8494 },
				{ lat: 43.3625, lng: -5.8500 },
				{ lat: 43.3630, lng: -5.8510 },
				{ lat: 43.3640, lng: -5.8520 },
				{ lat: 43.3650, lng: -5.8530 }
			],
			stops: [1001, 1002, 1003]
		},
		{
			id: 'E2',
			name: 'E2-LAS CAMPAS',
			color: '#3f51b5',
			polyline: [
				{ lat: 43.3650, lng: -5.8530 },
				{ lat: 43.3640, lng: -5.8520 },
				{ lat: 43.3630, lng: -5.8510 },
				{ lat: 43.3625, lng: -5.8500 },
				{ lat: 43.3619, lng: -5.8494 }
			],
			stops: [1003, 1002, 1001]
		},
		{
			id: 'D1',
			name: 'D1-TRUBIA',
			color: '#673ab7',
			polyline: [
				{ lat: 43.3619, lng: -5.8494 },
				{ lat: 43.3615, lng: -5.8480 },
				{ lat: 43.3610, lng: -5.8470 },
				{ lat: 43.3600, lng: -5.8460 }
			],
			stops: [1001, 1010, 1011]
		}
	]
};

export const mockStops = {
	stops: [
		{
			code: 1001,
			name: 'Aureliano San Román',
			position: { lat: 43.36264, lng: -5.86597 },
			lines: ['E', 'D', 'BÚHO']
		},
		{
			code: 1002,
			name: 'Plaza de América',
			position: { lat: 43.3630, lng: -5.8510 },
			lines: ['E']
		},
		{
			code: 1003,
			name: 'La Monxina',
			position: { lat: 43.3650, lng: -5.8530 },
			lines: ['E']
		},
		{
			code: 1010,
			name: 'Universidad',
			position: { lat: 43.3615, lng: -5.8480 },
			lines: ['D']
		},
		{
			code: 1011,
			name: 'Hospital',
			position: { lat: 43.3600, lng: -5.8460 },
			lines: ['D']
		}
	]
};

export const mockBuses = {
	buses: [
		{
			line: 'E',
			route_id: 'E2',
			destination: 'E2-LAS CAMPAS',
			position: { lat: 43.36264, lng: -5.86597 },
			next_stop: 1001,
			distance: 412,
			eta: 137,
			at_terminus: false,
			last_update: new Date().toISOString()
		},
		{
			line: 'D',
			route_id: 'D1',
			destination: 'D1-TRUBIA',
			position: { lat: 43.3615, lng: -5.8485 },
			next_stop: 1010,
			distance: 250,
			eta: 90,
			at_terminus: false,
			last_update: new Date().toISOString()
		}
	],
	updated_at: new Date().toISOString()
};

export const mockStopArrivals = {
	estimaciones: {
		value: [
			{
				line: 'E',
				line_names: [],
				vh_first: {
					cabecera: false,
					destination_names: [{ key: 'default', value: 'E2-LAS CAMPAS' }],
					destino: 'E2-LAS CAMPAS',
					meters: 412,
					seconds: 137
				},
				vh_second: {
					cabecera: false,
					destination_names: [{ key: 'default', value: 'E2-LAS CAMPAS' }],
					destino: 'E2-LAS CAMPAS',
					meters: 2341,
					seconds: 1170
				}
			},
			{
				line: 'D',
				line_names: [],
				vh_first: {
					cabecera: false,
					destination_names: [{ key: 'default', value: 'D1-TRUBIA' }],
					destino: 'D1-TRUBIA',
					meters: 3463,
					seconds: 1154
				}
			}
		]
	}
};
