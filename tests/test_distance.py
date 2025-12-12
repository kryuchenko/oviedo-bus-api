"""
Tests for GPS distance utilities.

Tests haversine distance calculations, nearest point finding,
and bearing calculations.
"""

import pytest
import math
from oviedo_bus_api.utils.distance import (
    haversine_distance,
    find_nearest_points,
    format_distance,
    calculate_bearing,
    bearing_to_compass
)


class TestHaversineDistance:
    """Tests for haversine_distance()"""

    def test_same_point_returns_zero(self):
        """Distance between same point should be 0"""
        distance = haversine_distance(43.36, -5.84, 43.36, -5.84)
        assert distance == 0.0

    def test_known_distance_oviedo_center_to_huca(self):
        """Test known distance: Oviedo center to HUCA"""
        # Oviedo center
        lat1, lon1 = 43.3614, -5.8493
        # HUCA (hospital)
        lat2, lon2 = 43.3555, -5.8620

        distance = haversine_distance(lat1, lon1, lat2, lon2)

        # Expected: ~1.2 km
        assert 1100 < distance < 1300, f"Distance {distance}m not in expected range"

    def test_short_distance(self):
        """Test short distance (~100m)"""
        # Two nearby points
        distance = haversine_distance(43.36264, -5.86597, 43.36354, -5.86597)

        # Should be ~100 meters
        assert 90 < distance < 110, f"Distance {distance}m not ~100m"

    def test_coordinates_order_matters(self):
        """Distance should be same regardless of point order"""
        lat1, lon1 = 43.36, -5.84
        lat2, lon2 = 43.37, -5.85

        dist1 = haversine_distance(lat1, lon1, lat2, lon2)
        dist2 = haversine_distance(lat2, lon2, lat1, lon1)

        assert dist1 == dist2

    def test_large_distance(self):
        """Test large distance (Oviedo to Madrid ~372km)"""
        # Oviedo
        lat1, lon1 = 43.36, -5.84
        # Madrid (approx)
        lat2, lon2 = 40.42, -3.70

        distance = haversine_distance(lat1, lon1, lat2, lon2)

        # Should be ~370-375 km
        assert 370000 < distance < 375000, f"Distance {distance}m not ~372km"

    @pytest.mark.parametrize("lat1,lon1,lat2,lon2", [
        (0, 0, 0, 0),           # Equator
        (90, 0, 90, 0),         # North pole
        (-90, 0, -90, 0),       # South pole
        (43.36, 180, 43.36, -180),  # Date line
    ])
    def test_edge_case_coordinates(self, lat1, lon1, lat2, lon2):
        """Test edge case coordinates"""
        distance = haversine_distance(lat1, lon1, lat2, lon2)
        assert distance >= 0, "Distance cannot be negative"


class TestFindNearestPoints:
    """Tests for find_nearest_points()"""

    @pytest.fixture
    def sample_stops(self):
        """Sample bus stops for testing"""
        return [
            {'code': 1001, 'name': 'Stop A', 'latitude': 43.3626, 'longitude': -5.8659},
            {'code': 1002, 'name': 'Stop B', 'latitude': 43.3614, 'longitude': -5.8493},
            {'code': 1003, 'name': 'Stop C', 'latitude': 43.3555, 'longitude': -5.8620},
            {'code': 1004, 'name': 'Stop D', 'latitude': 43.3700, 'longitude': -5.8500},
            {'code': 1005, 'name': 'Stop E', 'latitude': 43.3500, 'longitude': -5.8400},
        ]

    def test_find_all_points_no_filter(self, sample_stops):
        """Find all points without distance filter"""
        target_lat, target_lon = 43.36, -5.85

        results = find_nearest_points(target_lat, target_lon, sample_stops)

        assert len(results) == len(sample_stops)
        # Check sorted by distance
        distances = [dist for _, dist in results]
        assert distances == sorted(distances)

    def test_find_with_max_distance(self, sample_stops):
        """Find points within max distance"""
        target_lat, target_lon = 43.3626, -5.8659  # Near Stop A

        results = find_nearest_points(
            target_lat, target_lon,
            sample_stops,
            max_distance=1000  # 1 km
        )

        # Should find some but not all
        assert 0 < len(results) <= len(sample_stops)

        # All results should be within max_distance
        for _, dist in results:
            assert dist <= 1000

    def test_find_with_limit(self, sample_stops):
        """Find limited number of nearest points"""
        target_lat, target_lon = 43.36, -5.85

        results = find_nearest_points(
            target_lat, target_lon,
            sample_stops,
            limit=3
        )

        assert len(results) == 3
        # Should be 3 nearest
        distances = [dist for _, dist in results]
        assert distances == sorted(distances)[:3]

    def test_find_with_max_distance_and_limit(self, sample_stops):
        """Find with both max_distance and limit"""
        target_lat, target_lon = 43.3626, -5.8659

        results = find_nearest_points(
            target_lat, target_lon,
            sample_stops,
            max_distance=2000,
            limit=2
        )

        assert len(results) <= 2
        for _, dist in results:
            assert dist <= 2000

    def test_skip_points_without_coordinates(self):
        """Should skip points without GPS coordinates"""
        points = [
            {'code': 1, 'name': 'A', 'latitude': 43.36, 'longitude': -5.84},
            {'code': 2, 'name': 'B'},  # No coordinates
            {'code': 3, 'name': 'C', 'latitude': 43.37},  # Missing longitude
            {'code': 4, 'name': 'D', 'latitude': 43.38, 'longitude': -5.85},
        ]

        results = find_nearest_points(43.36, -5.84, points)

        # Should only find points with complete coordinates
        assert len(results) == 2

    def test_empty_list_returns_empty(self):
        """Empty input should return empty results"""
        results = find_nearest_points(43.36, -5.84, [])
        assert results == []

    def test_no_points_within_distance(self, sample_stops):
        """No points within very small distance"""
        target_lat, target_lon = 43.36, -5.84

        results = find_nearest_points(
            target_lat, target_lon,
            sample_stops,
            max_distance=1  # Only 1 meter
        )

        assert results == []

    def test_result_structure(self, sample_stops):
        """Check result structure is correct"""
        results = find_nearest_points(43.36, -5.84, sample_stops, limit=1)

        assert len(results) == 1
        point, distance = results[0]

        # Check point structure
        assert 'code' in point
        assert 'name' in point
        assert 'latitude' in point
        assert 'longitude' in point

        # Check distance type
        assert isinstance(distance, float)
        assert distance >= 0


class TestFormatDistance:
    """Tests for format_distance()"""

    @pytest.mark.parametrize("meters,expected", [
        (0, "0 m"),
        (1, "1 m"),
        (50, "50 m"),
        (250, "250 m"),
        (999, "999 m"),
        (1000, "1.0 km"),
        (1500, "1.5 km"),
        (2345, "2.3 km"),
        (10000, "10.0 km"),
        (12345, "12.3 km"),
    ])
    def test_format_various_distances(self, meters, expected):
        """Test formatting various distances"""
        result = format_distance(meters)
        assert result == expected

    def test_format_very_small_distance(self):
        """Test very small distance"""
        result = format_distance(0.5)
        assert result == "0 m" or result == "1 m"

    def test_format_very_large_distance(self):
        """Test very large distance"""
        result = format_distance(123456)
        assert "123" in result
        assert "km" in result


class TestCalculateBearing:
    """Tests for calculate_bearing()"""

    def test_north_bearing(self):
        """Bearing directly north should be ~0°"""
        bearing = calculate_bearing(43.36, -5.84, 43.37, -5.84)
        assert 0 <= bearing < 10 or bearing > 350

    def test_south_bearing(self):
        """Bearing directly south should be ~180°"""
        bearing = calculate_bearing(43.37, -5.84, 43.36, -5.84)
        assert 170 < bearing < 190

    def test_east_bearing(self):
        """Bearing directly east should be ~90°"""
        bearing = calculate_bearing(43.36, -5.84, 43.36, -5.83)
        assert 80 < bearing < 100

    def test_west_bearing(self):
        """Bearing directly west should be ~270°"""
        bearing = calculate_bearing(43.36, -5.83, 43.36, -5.84)
        assert 260 < bearing < 280

    def test_bearing_range(self):
        """Bearing should always be 0-360"""
        bearings = [
            calculate_bearing(43.36, -5.84, lat, lon)
            for lat in [43.35, 43.36, 43.37]
            for lon in [-5.85, -5.84, -5.83]
        ]

        for bearing in bearings:
            assert 0 <= bearing < 360

    def test_same_point_bearing(self):
        """Bearing from point to itself"""
        bearing = calculate_bearing(43.36, -5.84, 43.36, -5.84)
        assert isinstance(bearing, float)
        # Bearing is undefined but function should still return a value


class TestBearingToCompass:
    """Tests for bearing_to_compass()"""

    @pytest.mark.parametrize("bearing,expected", [
        (0, "N"),
        (22, "N"),
        (45, "NE"),
        (67, "NE"),
        (90, "E"),
        (112, "E"),
        (135, "SE"),
        (157, "SE"),
        (180, "S"),
        (202, "S"),
        (225, "SW"),
        (247, "SW"),
        (270, "W"),
        (292, "W"),
        (315, "NW"),
        (337, "NW"),
        (359, "N"),
    ])
    def test_compass_directions(self, bearing, expected):
        """Test compass direction conversion"""
        result = bearing_to_compass(bearing)
        assert result == expected

    def test_all_eight_directions(self):
        """Test all 8 compass directions"""
        directions = set()

        for bearing in range(0, 360, 10):
            direction = bearing_to_compass(bearing)
            directions.add(direction)

        # Should have found all 8 directions
        expected_directions = {'N', 'NE', 'E', 'SE', 'S', 'SW', 'W', 'NW'}
        assert directions == expected_directions

    def test_boundary_cases(self):
        """Test boundary cases between directions"""
        # Exact boundaries (45° increments)
        assert bearing_to_compass(0) == "N"
        assert bearing_to_compass(45) == "NE"
        assert bearing_to_compass(90) == "E"
        assert bearing_to_compass(180) == "S"
        assert bearing_to_compass(270) == "W"


class TestIntegration:
    """Integration tests combining multiple functions"""

    def test_find_and_format_distances(self):
        """Find nearest points and format their distances"""
        stops = [
            {'code': 1, 'name': 'A', 'latitude': 43.36, 'longitude': -5.84},
            {'code': 2, 'name': 'B', 'latitude': 43.37, 'longitude': -5.85},
        ]

        results = find_nearest_points(43.36, -5.84, stops, limit=2)

        for stop, distance in results:
            formatted = format_distance(distance)
            assert isinstance(formatted, str)
            assert 'm' in formatted or 'km' in formatted

    def test_calculate_bearing_and_compass(self):
        """Calculate bearing and convert to compass"""
        lat1, lon1 = 43.36, -5.84
        lat2, lon2 = 43.37, -5.84

        bearing = calculate_bearing(lat1, lon1, lat2, lon2)
        compass = bearing_to_compass(bearing)

        assert compass == "N"  # Going north

    def test_realistic_bus_stop_scenario(self):
        """Test realistic scenario: find nearest stop with direction"""
        # Your location
        my_lat, my_lon = 43.3614, -5.8493

        # Bus stops
        stops = [
            {'code': 1001, 'name': 'Aureliano', 'latitude': 43.36264, 'longitude': -5.86597},
            {'code': 1332, 'name': 'HUCA', 'latitude': 43.3555, 'longitude': -5.8620},
        ]

        # Find nearest
        nearest = find_nearest_points(my_lat, my_lon, stops, limit=1)

        assert len(nearest) == 1
        stop, distance = nearest[0]

        # Calculate direction
        bearing = calculate_bearing(my_lat, my_lon, stop['latitude'], stop['longitude'])
        direction = bearing_to_compass(bearing)

        # Format distance
        dist_str = format_distance(distance)

        # All operations completed successfully
        assert stop['code'] in [1001, 1332]
        assert 0 <= bearing < 360
        assert direction in ['N', 'NE', 'E', 'SE', 'S', 'SW', 'W', 'NW']
        assert 'm' in dist_str or 'km' in dist_str


# Mark all tests for distance utils
pytestmark = pytest.mark.distance
