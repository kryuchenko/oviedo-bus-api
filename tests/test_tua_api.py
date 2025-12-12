"""
Automated tests for TUA Oviedo Bus API

Tests the /rest/estimaciones/{stop_code} endpoint
"""

import pytest
import requests
from typing import Dict, Any, Optional
from jsonschema import validate, ValidationError


# Constants
BASE_URL = "https://www.tua.es/rest"
TIMEOUT = 30  # seconds


# JSON Schema for response validation
ESTIMATION_SCHEMA = {
    "type": "object",
    "properties": {
        "destino": {"type": "string"},
        "meters": {"type": "integer", "minimum": 0},
        "seconds": {"type": "integer", "minimum": 0}
    },
    "required": ["destino", "meters", "seconds"]
}

LINE_ESTIMATION_SCHEMA = {
    "type": "object",
    "properties": {
        "line": {"type": "string"},
        "vh_first": {"oneOf": [ESTIMATION_SCHEMA, {"type": "null"}]},
        "vh_second": {"oneOf": [ESTIMATION_SCHEMA, {"type": "null"}]},
        "vh_third": {"oneOf": [ESTIMATION_SCHEMA, {"type": "null"}]}
    },
    "required": ["line"]
}

STOP_INFO_SCHEMA = {
    "type": "object",
    "properties": {
        "estimaciones": {
            "type": "object",
            "properties": {
                "value": {
                    "type": "array",
                    "items": LINE_ESTIMATION_SCHEMA
                }
            },
            "required": ["value"]
        }
    },
    "required": ["estimaciones"]
}


class TestTUAAPI:
    """Tests for TUA API"""

    @pytest.fixture(autouse=True)
    def setup(self):
        """Setup before each test"""
        self.session = requests.Session()
        self.session.headers.update({
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'User-Agent': 'TUA-API-Tests/1.0'
        })
        yield
        self.session.close()

    def get_estimaciones(self, stop_code: int) -> requests.Response:
        """
        Get bus arrival estimations

        Args:
            stop_code: Stop code

        Returns:
            Response object
        """
        url = f"{BASE_URL}/estimaciones/{stop_code}"
        return self.session.get(url, timeout=TIMEOUT)

    # ============================================
    # Basic functionality tests
    # ============================================

    def test_api_is_available(self):
        """Check API availability"""
        response = self.get_estimaciones(1)
        assert response.status_code in [200, 404], \
            f"API unavailable. Status: {response.status_code}"

    @pytest.mark.parametrize("stop_code", [1, 100, 200, 505, 1000])
    def test_valid_stop_codes(self, stop_code):
        """Test valid stop codes"""
        response = self.get_estimaciones(stop_code)

        assert response.status_code == 200, \
            f"Unexpected status code: {response.status_code}"

        # Check response is JSON
        assert response.headers.get('Content-Type') == 'application/json', \
            "Response must be JSON"

        # Check response is parseable
        try:
            data = response.json()
        except ValueError as e:
            pytest.fail(f"Response is not valid JSON: {e}")

    @pytest.mark.parametrize("stop_code", [0, -1, -100])
    def test_invalid_stop_codes(self, stop_code):
        """Test invalid stop codes"""
        response = self.get_estimaciones(stop_code)
        # API may return 200 with empty array or 404
        assert response.status_code in [200, 400, 404], \
            f"Unexpected status for invalid code: {response.status_code}"

    # ============================================
    # Data structure tests
    # ============================================

    def test_response_structure(self):
        """Check response structure"""
        response = self.get_estimaciones(1)
        data = response.json()

        # Check main fields
        assert "estimaciones" in data, "Missing 'estimaciones' field"
        assert "value" in data["estimaciones"], \
            "Missing 'value' field in estimaciones"
        assert isinstance(data["estimaciones"]["value"], list), \
            "'value' field must be an array"

    def test_response_schema_validation(self):
        """Validate response against JSON Schema"""
        response = self.get_estimaciones(1)
        data = response.json()

        try:
            validate(instance=data, schema=STOP_INFO_SCHEMA)
        except ValidationError as e:
            pytest.fail(f"Response doesn't match schema: {e.message}")

    def test_line_estimation_structure(self):
        """Check line estimation data structure"""
        # Try several stops until we find one with buses
        for stop_code in [1, 100, 200, 300, 400, 505, 1000]:
            response = self.get_estimaciones(stop_code)
            data = response.json()

            lines = data["estimaciones"]["value"]
            if lines:
                line = lines[0]

                # Check required field
                assert "line" in line, "Missing 'line' field"
                assert isinstance(line["line"], str), \
                    "'line' field must be a string"

                # If there are buses, check their structure
                for vehicle in ["vh_first", "vh_second", "vh_third"]:
                    if vehicle in line and line[vehicle] is not None:
                        self._validate_estimation(line[vehicle])
                        break
                break

    def _validate_estimation(self, estimation: Dict[str, Any]):
        """Validate Estimation structure"""
        assert "destino" in estimation, "Missing 'destino' field"
        assert "meters" in estimation, "Missing 'meters' field"
        assert "seconds" in estimation, "Missing 'seconds' field"

        assert isinstance(estimation["destino"], str), \
            "'destino' field must be a string"
        assert isinstance(estimation["meters"], int), \
            "'meters' field must be a number"
        assert isinstance(estimation["seconds"], int), \
            "'seconds' field must be a number"

        assert estimation["meters"] >= 0, \
            "Distance cannot be negative"
        assert estimation["seconds"] >= 0, \
            "Time cannot be negative"

    # ============================================
    # Data logic tests
    # ============================================

    def test_empty_stop_returns_empty_array(self):
        """Stop without buses returns empty array"""
        response = self.get_estimaciones(1)
        data = response.json()

        assert isinstance(data["estimaciones"]["value"], list), \
            "Must return an array even for empty stop"

    def test_time_and_distance_correlation(self):
        """Check time and distance correlation"""
        # Find a stop with buses
        for stop_code in range(1, 1001, 50):
            response = self.get_estimaciones(stop_code)
            data = response.json()

            for line in data["estimaciones"]["value"]:
                for vehicle_key in ["vh_first", "vh_second", "vh_third"]:
                    vehicle = line.get(vehicle_key)
                    if vehicle:
                        meters = vehicle["meters"]
                        seconds = vehicle["seconds"]

                        # Check data reasonableness
                        # Average bus speed: 5-20 m/s (18-72 km/h)
                        if seconds > 0:
                            speed = meters / seconds  # m/s
                            assert 0 < speed < 50, \
                                f"Implausible speed: {speed:.2f} m/s " \
                                f"(meters={meters}, seconds={seconds})"
                        return  # Test passed, exit

    def test_vehicles_order(self):
        """Check that buses are ordered (closest first)"""
        for stop_code in range(1, 1001, 50):
            response = self.get_estimaciones(stop_code)
            data = response.json()

            for line in data["estimaciones"]["value"]:
                vh_first = line.get("vh_first")
                vh_second = line.get("vh_second")
                vh_third = line.get("vh_third")

                # If there are multiple buses, check order
                if vh_first and vh_second:
                    assert vh_first["seconds"] <= vh_second["seconds"], \
                        "First bus should be closer than second"
                    assert vh_first["meters"] <= vh_second["meters"], \
                        "First bus should be closer by distance than second"

                if vh_second and vh_third:
                    assert vh_second["seconds"] <= vh_third["seconds"], \
                        "Second bus should be closer than third"
                    assert vh_second["meters"] <= vh_third["meters"], \
                        "Second bus should be closer by distance than third"

    # ============================================
    # Performance tests
    # ============================================

    def test_response_time(self):
        """Check API response time"""
        import time

        start = time.time()
        response = self.get_estimaciones(1)
        duration = time.time() - start

        assert response.status_code == 200, "API must return 200"
        assert duration < 15, \
            f"API responds too slowly: {duration:.2f}s"

    def test_concurrent_requests(self):
        """Test concurrent requests"""
        from concurrent.futures import ThreadPoolExecutor, as_completed

        stop_codes = [1, 100, 200, 300, 400, 505]

        with ThreadPoolExecutor(max_workers=5) as executor:
            futures = {
                executor.submit(self.get_estimaciones, code): code
                for code in stop_codes
            }

            for future in as_completed(futures):
                response = future.result()
                assert response.status_code == 200, \
                    f"Error in concurrent request: {response.status_code}"

    # ============================================
    # HTTP headers tests
    # ============================================

    def test_response_headers(self):
        """Check HTTP response headers"""
        response = self.get_estimaciones(1)

        # Check Content-Type
        assert 'Content-Type' in response.headers, \
            "Missing Content-Type header"
        assert 'application/json' in response.headers['Content-Type'], \
            "Content-Type must be application/json"

    def test_cors_headers(self):
        """Check CORS headers"""
        response = self.get_estimaciones(1)

        # Check that API supports CORS
        # (not required, but recommended)
        if 'Access-Control-Allow-Origin' in response.headers:
            assert response.headers['Access-Control-Allow-Origin'] in ['*', BASE_URL], \
                "CORS header has unexpected value"

    # ============================================
    # Edge case tests
    # ============================================

    @pytest.mark.parametrize("stop_code", [
        999999,  # Very large code
        2147483647,  # MAX INT32
    ])
    def test_large_stop_codes(self, stop_code):
        """Test large stop codes"""
        response = self.get_estimaciones(stop_code)
        # API should handle correctly or return error
        assert response.status_code in [200, 400, 404], \
            f"Unexpected status for large code: {response.status_code}"

    def test_multiple_lines_on_same_stop(self):
        """Check stop with multiple lines"""
        for stop_code in range(1, 1001, 50):
            response = self.get_estimaciones(stop_code)
            data = response.json()

            lines = data["estimaciones"]["value"]
            if len(lines) > 1:
                # Check line uniqueness
                line_numbers = [line["line"] for line in lines]
                assert len(line_numbers) == len(set(line_numbers)), \
                    "Lines must be unique"
                return  # Test passed


class TestAPIIntegration:
    """Integration tests"""

    def test_api_full_workflow(self):
        """Test complete API workflow"""
        session = requests.Session()

        # 1. Get stop data
        response = session.get(
            f"{BASE_URL}/estimaciones/505",
            timeout=TIMEOUT
        )
        assert response.status_code == 200

        # 2. Parse data
        data = response.json()
        assert "estimaciones" in data

        # 3. If there are buses, calculate arrival time
        lines = data["estimaciones"]["value"]
        if lines:
            for line in lines:
                if line.get("vh_first"):
                    seconds = line["vh_first"]["seconds"]
                    minutes = round(seconds / 60)

                    # Check reasonableness
                    assert 0 <= minutes < 120, \
                        f"Arrival time should be reasonable: {minutes} min"


# ============================================
# Fixtures
# ============================================

@pytest.fixture(scope="session")
def api_base_url():
    """API base URL"""
    return BASE_URL


@pytest.fixture(scope="session")
def sample_stop_codes():
    """Sample stop codes for testing"""
    return [1, 100, 200, 300, 400, 505, 1000]


# ============================================
# Markers
# ============================================

# pytest markers for test grouping:
# - pytest -m smoke       # quick smoke tests
# - pytest -m integration # integration tests
# - pytest -m performance # performance tests

pytestmark = pytest.mark.api
