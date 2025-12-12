"""
Pytest configuration and common fixtures

This file is automatically loaded by pytest and contains
settings and fixtures for all tests.
"""

import pytest
import requests
from typing import Generator


# ============================================
# Hooks
# ============================================

def pytest_configure(config):
    """Configure pytest at startup"""
    # Add custom markers
    config.addinivalue_line(
        "markers",
        "api: mark test as API test"
    )
    config.addinivalue_line(
        "markers",
        "distance: mark test as distance utilities test"
    )


def pytest_collection_modifyitems(config, items):
    """Modify collected tests"""
    # Add 'api' marker to all tests
    for item in items:
        if "test_tua_api" in item.nodeid:
            item.add_marker(pytest.mark.api)


# ============================================
# Session-scoped fixtures
# ============================================

@pytest.fixture(scope="session")
def base_url():
    """Base URL for API"""
    return "https://www.tua.es/rest"


@pytest.fixture(scope="session")
def api_timeout():
    """Timeout for API requests"""
    return 30


@pytest.fixture(scope="session")
def http_session() -> Generator[requests.Session, None, None]:
    """
    HTTP session for all tests

    Uses connection pooling for better performance
    """
    session = requests.Session()
    session.headers.update({
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'User-Agent': 'TUA-API-Tests/1.0'
    })

    # Retry settings
    from requests.adapters import HTTPAdapter
    from requests.packages.urllib3.util.retry import Retry

    retry_strategy = Retry(
        total=3,
        backoff_factor=1,
        status_forcelist=[429, 500, 502, 503, 504],
    )
    adapter = HTTPAdapter(max_retries=retry_strategy)
    session.mount("http://", adapter)
    session.mount("https://", adapter)

    yield session
    session.close()


# ============================================
# Function-scoped fixtures
# ============================================

@pytest.fixture
def api_client(http_session, base_url, api_timeout):
    """
    API client for tests

    Returns a function to call API endpoints
    """
    def _call_api(endpoint: str, method: str = "GET", **kwargs):
        url = f"{base_url}/{endpoint}"
        kwargs.setdefault('timeout', api_timeout)
        return http_session.request(method, url, **kwargs)

    return _call_api


@pytest.fixture
def get_estimaciones(api_client):
    """
    Convenience fixture for getting estimaciones

    Usage:
        def test_something(get_estimaciones):
            response = get_estimaciones(505)
            assert response.status_code == 200
    """
    def _get(stop_code: int) -> requests.Response:
        return api_client(f"estimaciones/{stop_code}")

    return _get


# ============================================
# Parametrize fixtures
# ============================================

@pytest.fixture(params=[1, 100, 200, 505, 1000])
def stop_code(request):
    """Parametrized fixture for stop codes"""
    return request.param


@pytest.fixture(params=[0, -1, -100])
def invalid_stop_code(request):
    """Parametrized fixture for invalid codes"""
    return request.param
