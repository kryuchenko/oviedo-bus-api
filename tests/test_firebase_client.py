"""
Unit tests for TUA Firebase client.

Tests the Firebase Firestore data client with mocked file loading.
"""

import pytest
from pathlib import Path
from unittest.mock import Mock
import json

from oviedo_bus_api.firebase.client import TUAFirebaseClient, TUAFirebaseError


class TestTUAFirebaseClientInit:
    """Test TUAFirebaseClient initialization."""

    def test_default_init(self, tmp_path):
        """Test default initialization."""
        client = TUAFirebaseClient(data_dir=str(tmp_path))

        assert client.data_dir == tmp_path
        assert client._stops is None
        assert client._routes is None
        assert client._schedules is None

    def test_custom_data_dir(self, tmp_path):
        """Test initialization with custom data directory."""
        custom_dir = tmp_path / "custom"
        custom_dir.mkdir()

        client = TUAFirebaseClient(data_dir=str(custom_dir))

        assert client.data_dir == custom_dir

    def test_custom_file_loader(self, tmp_path):
        """Test initialization with custom file loader (dependency injection)."""
        mock_loader = Mock(return_value={'test': 'data'})

        client = TUAFirebaseClient(data_dir=str(tmp_path), file_loader=mock_loader)

        assert client._file_loader is mock_loader


class TestLoadStops:
    """Test load_stops() method."""

    def test_successful_load(self, tmp_path):
        """Test successful loading of stops data."""
        stops_data = {
            'stops': [
                {
                    'code': 1000,
                    'name': 'Test Stop 1',
                    'gps': {'lat': 43.3623, 'lon': -5.8490},
                    'lines': ['A', 'D']
                },
                {
                    'code': 1001,
                    'name': 'Test Stop 2',
                    'gps': {'lat': 43.3624, 'lon': -5.8491},
                    'lines': ['F']
                }
            ]
        }

        # Create mock file
        stops_file = tmp_path / "tua_firebase_stops_gps.json"
        with open(stops_file, 'w', encoding='utf-8') as f:
            json.dump(stops_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))
        result = client.load_stops()

        assert result == stops_data
        assert len(result['stops']) == 2
        assert result['stops'][0]['code'] == 1000

    def test_file_not_found(self, tmp_path):
        """Test error when stops file doesn't exist."""
        client = TUAFirebaseClient(data_dir=str(tmp_path))

        with pytest.raises(TUAFirebaseError) as exc_info:
            client.load_stops()

        assert "Stops data not found" in str(exc_info.value)
        assert "download_firebase_data.py" in str(exc_info.value)

    def test_invalid_json(self, tmp_path):
        """Test error when JSON is invalid."""
        stops_file = tmp_path / "tua_firebase_stops_gps.json"
        with open(stops_file, 'w') as f:
            f.write("{ invalid json }")

        client = TUAFirebaseClient(data_dir=str(tmp_path))

        with pytest.raises(TUAFirebaseError) as exc_info:
            client.load_stops()

        assert "Failed to parse stops data" in str(exc_info.value)

    def test_invalid_format_not_dict(self, tmp_path):
        """Test error when data is not a dict."""
        stops_file = tmp_path / "tua_firebase_stops_gps.json"
        with open(stops_file, 'w') as f:
            json.dump(["not", "a", "dict"], f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))

        with pytest.raises(TUAFirebaseError) as exc_info:
            client.load_stops()

        assert "Invalid stops data format" in str(exc_info.value)

    def test_missing_stops_key(self, tmp_path):
        """Test error when 'stops' key is missing."""
        stops_file = tmp_path / "tua_firebase_stops_gps.json"
        with open(stops_file, 'w') as f:
            json.dump({'other': 'data'}, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))

        with pytest.raises(TUAFirebaseError) as exc_info:
            client.load_stops()

        assert "missing 'stops' key" in str(exc_info.value)

    def test_stops_not_list(self, tmp_path):
        """Test error when 'stops' is not a list."""
        stops_file = tmp_path / "tua_firebase_stops_gps.json"
        with open(stops_file, 'w') as f:
            json.dump({'stops': 'not a list'}, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))

        with pytest.raises(TUAFirebaseError) as exc_info:
            client.load_stops()

        assert "'stops' must be a list" in str(exc_info.value)

    def test_caching(self, tmp_path):
        """Test that stops are cached after first load."""
        stops_data = {'stops': [{'code': 1000}]}
        mock_loader = Mock(return_value=stops_data)

        # Create file so it passes exists() check
        stops_file = tmp_path / "tua_firebase_stops_gps.json"
        with open(stops_file, 'w') as f:
            json.dump(stops_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path), file_loader=mock_loader)

        # First call
        result1 = client.load_stops()
        # Second call
        result2 = client.load_stops()

        assert result1 == result2
        # File loader should only be called once (cached)
        mock_loader.assert_called_once()


class TestLoadRoutes:
    """Test load_routes() method."""

    def test_successful_load(self, tmp_path):
        """Test successful loading of routes data."""
        routes_data = {
            'routes': [
                {
                    'line': 'A',
                    'direction': 'ida',
                    'stops': [1000, 1001, 1002]
                },
                {
                    'line': 'A',
                    'direction': 'vuelta',
                    'stops': [1002, 1001, 1000]
                }
            ]
        }

        routes_file = tmp_path / "tua_firebase_routes.json"
        with open(routes_file, 'w', encoding='utf-8') as f:
            json.dump(routes_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))
        result = client.load_routes()

        assert result == routes_data
        assert len(result['routes']) == 2

    def test_file_not_found(self, tmp_path):
        """Test error when routes file doesn't exist."""
        client = TUAFirebaseClient(data_dir=str(tmp_path))

        with pytest.raises(TUAFirebaseError) as exc_info:
            client.load_routes()

        assert "Routes data not found" in str(exc_info.value)

    def test_invalid_format(self, tmp_path):
        """Test error when routes data format is invalid."""
        routes_file = tmp_path / "tua_firebase_routes.json"
        with open(routes_file, 'w') as f:
            json.dump({'wrong': 'format'}, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))

        with pytest.raises(TUAFirebaseError) as exc_info:
            client.load_routes()

        assert "missing 'routes' key" in str(exc_info.value)


class TestLoadSchedules:
    """Test load_schedules() method."""

    def test_successful_load(self, tmp_path):
        """Test successful loading of schedules data."""
        schedules_data = {
            'schedules': [
                {
                    'line': 'A',
                    'html': '<table>...</table>'
                }
            ]
        }

        schedules_file = tmp_path / "tua_firebase_schedules.json"
        with open(schedules_file, 'w', encoding='utf-8') as f:
            json.dump(schedules_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))
        result = client.load_schedules()

        assert result == schedules_data
        assert len(result['schedules']) == 1

    def test_file_not_found(self, tmp_path):
        """Test error when schedules file doesn't exist."""
        client = TUAFirebaseClient(data_dir=str(tmp_path))

        with pytest.raises(TUAFirebaseError) as exc_info:
            client.load_schedules()

        assert "Schedules data not found" in str(exc_info.value)


class TestGetStopByCode:
    """Test get_stop_by_code() method."""

    def test_find_existing_stop(self, tmp_path):
        """Test finding an existing stop by code."""
        stops_data = {
            'stops': [
                {'code': 1000, 'name': 'Stop A'},
                {'code': 1001, 'name': 'Stop B'},
                {'code': 1332, 'name': 'Stop C'}
            ]
        }

        stops_file = tmp_path / "tua_firebase_stops_gps.json"
        with open(stops_file, 'w') as f:
            json.dump(stops_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))
        stop = client.get_stop_by_code(1332)

        assert stop is not None
        assert stop['code'] == 1332
        assert stop['name'] == 'Stop C'

    def test_stop_not_found(self, tmp_path):
        """Test returns None when stop not found."""
        stops_data = {'stops': [{'code': 1000, 'name': 'Stop A'}]}

        stops_file = tmp_path / "tua_firebase_stops_gps.json"
        with open(stops_file, 'w') as f:
            json.dump(stops_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))
        stop = client.get_stop_by_code(9999)

        assert stop is None


class TestGetStopsByLine:
    """Test get_stops_by_line() method."""

    def test_find_stops_by_line(self, tmp_path):
        """Test finding all stops for a specific line."""
        stops_data = {
            'stops': [
                {'code': 1000, 'name': 'Stop A', 'lines': ['A', 'D']},
                {'code': 1001, 'name': 'Stop B', 'lines': ['F']},
                {'code': 1002, 'name': 'Stop C', 'lines': ['A', 'E']}
            ]
        }

        stops_file = tmp_path / "tua_firebase_stops_gps.json"
        with open(stops_file, 'w') as f:
            json.dump(stops_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))
        stops = client.get_stops_by_line('A')

        assert len(stops) == 2
        assert stops[0]['code'] == 1000
        assert stops[1]['code'] == 1002

    def test_line_not_found(self, tmp_path):
        """Test returns empty list when line not found."""
        stops_data = {
            'stops': [
                {'code': 1000, 'name': 'Stop A', 'lines': ['A']}
            ]
        }

        stops_file = tmp_path / "tua_firebase_stops_gps.json"
        with open(stops_file, 'w') as f:
            json.dump(stops_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))
        stops = client.get_stops_by_line('Z')

        assert stops == []


class TestGetRouteStops:
    """Test get_route_stops() method."""

    def test_find_route_stops(self, tmp_path):
        """Test finding ordered stops for a route."""
        routes_data = {
            'routes': [
                {
                    'line': 'A',
                    'direction': 'ida',
                    'stops': [
                        {'code': 1000, 'name': 'Stop 1'},
                        {'code': 1001, 'name': 'Stop 2'}
                    ]
                },
                {
                    'line': 'A',
                    'direction': 'vuelta',
                    'stops': [
                        {'code': 1001, 'name': 'Stop 2'},
                        {'code': 1000, 'name': 'Stop 1'}
                    ]
                }
            ]
        }

        routes_file = tmp_path / "tua_firebase_routes.json"
        with open(routes_file, 'w') as f:
            json.dump(routes_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))
        stops = client.get_route_stops('A', 'ida')

        assert len(stops) == 2
        assert stops[0]['code'] == 1000
        assert stops[1]['code'] == 1001

    def test_route_not_found(self, tmp_path):
        """Test returns empty list when route not found."""
        routes_data = {'routes': []}

        routes_file = tmp_path / "tua_firebase_routes.json"
        with open(routes_file, 'w') as f:
            json.dump(routes_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))
        stops = client.get_route_stops('Z', 'ida')

        assert stops == []


class TestGetSchedule:
    """Test get_schedule() method."""

    def test_find_schedule(self, tmp_path):
        """Test finding schedule for a line."""
        schedules_data = {
            'schedules': [
                {'line': 'A', 'html': '<table>Schedule A</table>'},
                {'line': 'F', 'html': '<table>Schedule F</table>'}
            ]
        }

        schedules_file = tmp_path / "tua_firebase_schedules.json"
        with open(schedules_file, 'w') as f:
            json.dump(schedules_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))
        schedule = client.get_schedule('F')

        assert schedule is not None
        assert schedule['line'] == 'F'
        assert 'Schedule F' in schedule['html']

    def test_schedule_not_found(self, tmp_path):
        """Test returns None when schedule not found."""
        schedules_data = {'schedules': []}

        schedules_file = tmp_path / "tua_firebase_schedules.json"
        with open(schedules_file, 'w') as f:
            json.dump(schedules_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))
        schedule = client.get_schedule('Z')

        assert schedule is None


class TestSearchStops:
    """Test search_stops() method."""

    def test_search_stops(self, tmp_path):
        """Test searching stops by name."""
        stops_data = {
            'stops': [
                {'code': 1000, 'name': 'Plaza de España'},
                {'code': 1001, 'name': 'Calle Uría'},
                {'code': 1002, 'name': 'Plaza del Ayuntamiento'}
            ]
        }

        stops_file = tmp_path / "tua_firebase_stops_gps.json"
        with open(stops_file, 'w') as f:
            json.dump(stops_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))
        results = client.search_stops('plaza')

        assert len(results) == 2
        assert results[0]['code'] == 1000
        assert results[1]['code'] == 1002

    def test_search_case_insensitive(self, tmp_path):
        """Test search is case-insensitive."""
        stops_data = {
            'stops': [
                {'code': 1000, 'name': 'OVIEDO Centro'}
            ]
        }

        stops_file = tmp_path / "tua_firebase_stops_gps.json"
        with open(stops_file, 'w') as f:
            json.dump(stops_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))
        results = client.search_stops('oviedo')

        assert len(results) == 1
        assert results[0]['code'] == 1000

    def test_no_results(self, tmp_path):
        """Test returns empty list when no matches."""
        stops_data = {
            'stops': [
                {'code': 1000, 'name': 'Stop A'}
            ]
        }

        stops_file = tmp_path / "tua_firebase_stops_gps.json"
        with open(stops_file, 'w') as f:
            json.dump(stops_data, f)

        client = TUAFirebaseClient(data_dir=str(tmp_path))
        results = client.search_stops('nonexistent')

        assert results == []
