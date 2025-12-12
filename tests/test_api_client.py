"""
Unit tests for TUA Bus API client.

Tests the REST API client with mocked HTTP requests.
"""

import pytest
from unittest.mock import Mock, MagicMock
import requests

from oviedo_bus_api.api.client import TUABusAPI, TUABusAPIError


class TestTUABusAPIInit:
    """Test TUABusAPI initialization."""

    def test_default_init(self):
        """Test default initialization creates session with headers."""
        api = TUABusAPI()

        assert api.timeout == 10
        assert api.session is not None
        assert api.session.headers['Accept'] == 'application/json'
        assert api.session.headers['Content-Type'] == 'application/json'
        assert api.session.headers['User-Agent'] == 'TUA-Bus-SDK/3.1.0'

    def test_custom_timeout(self):
        """Test initialization with custom timeout."""
        api = TUABusAPI(timeout=30)
        assert api.timeout == 30

    def test_custom_session(self):
        """Test initialization with custom session (dependency injection)."""
        mock_session = Mock(spec=requests.Session)
        api = TUABusAPI(session=mock_session)

        assert api.session is mock_session


class TestGetArrivals:
    """Test get_arrivals() method."""

    def test_successful_request(self):
        """Test successful API request."""
        mock_session = Mock(spec=requests.Session)
        mock_response = Mock()
        mock_response.json.return_value = {
            'paradas': [
                {
                    'codigo': 1000,
                    'nombre': 'Test Stop',
                    'lineas': [
                        {'linea': 'A', 'minutos': 5}
                    ]
                }
            ]
        }
        mock_session.get.return_value = mock_response

        api = TUABusAPI(session=mock_session)
        result = api.get_arrivals(1000)

        assert result is not None
        assert 'paradas' in result
        assert result['paradas'][0]['codigo'] == 1000
        mock_session.get.assert_called_once_with(
            'https://www.tua.es/rest/estimaciones/1000',
            timeout=10
        )

    def test_request_exception_without_raise(self):
        """Test request exception returns None when raise_on_error=False."""
        mock_session = Mock(spec=requests.Session)
        mock_session.get.side_effect = requests.RequestException("Network error")

        api = TUABusAPI(session=mock_session)
        result = api.get_arrivals(1000, raise_on_error=False)

        assert result is None

    def test_request_exception_with_raise(self):
        """Test request exception raises TUABusAPIError when raise_on_error=True."""
        mock_session = Mock(spec=requests.Session)
        mock_session.get.side_effect = requests.RequestException("Network error")

        api = TUABusAPI(session=mock_session)

        with pytest.raises(TUABusAPIError) as exc_info:
            api.get_arrivals(1000, raise_on_error=True)

        assert "Failed to fetch arrivals for stop 1000" in str(exc_info.value)

    def test_invalid_json_without_raise(self):
        """Test invalid JSON returns None when raise_on_error=False."""
        mock_session = Mock(spec=requests.Session)
        mock_response = Mock()
        mock_response.json.side_effect = ValueError("Invalid JSON")
        mock_session.get.return_value = mock_response

        api = TUABusAPI(session=mock_session)
        result = api.get_arrivals(1000, raise_on_error=False)

        assert result is None

    def test_invalid_json_with_raise(self):
        """Test invalid JSON raises TUABusAPIError when raise_on_error=True."""
        mock_session = Mock(spec=requests.Session)
        mock_response = Mock()
        mock_response.json.side_effect = ValueError("Invalid JSON")
        mock_session.get.return_value = mock_response

        api = TUABusAPI(session=mock_session)

        with pytest.raises(TUABusAPIError) as exc_info:
            api.get_arrivals(1000, raise_on_error=True)

        assert "Invalid response data for stop 1000" in str(exc_info.value)

    def test_invalid_response_format(self):
        """Test non-dict response format raises error."""
        mock_session = Mock(spec=requests.Session)
        mock_response = Mock()
        mock_response.json.return_value = ["invalid", "format"]  # List instead of dict
        mock_session.get.return_value = mock_response

        api = TUABusAPI(session=mock_session)

        with pytest.raises(TUABusAPIError) as exc_info:
            api.get_arrivals(1000, raise_on_error=True)

        assert "Invalid response format for stop 1000" in str(exc_info.value)

    def test_http_error(self):
        """Test HTTP error (404, 500, etc)."""
        mock_session = Mock(spec=requests.Session)
        mock_response = Mock()
        mock_response.raise_for_status.side_effect = requests.HTTPError("404 Not Found")
        mock_session.get.return_value = mock_response

        api = TUABusAPI(session=mock_session)
        result = api.get_arrivals(9999, raise_on_error=False)

        assert result is None


class TestGetLinesAtStop:
    """Test get_lines_at_stop() method."""

    def test_successful_get_lines(self):
        """Test getting lines at stop."""
        mock_session = Mock(spec=requests.Session)
        mock_response = Mock()
        mock_response.json.return_value = {
            'paradas': [
                {
                    'lineas': [
                        {'linea': 'A'},
                        {'linea': 'D'},
                        {'linea': 'E'}
                    ]
                }
            ]
        }
        mock_session.get.return_value = mock_response

        api = TUABusAPI(session=mock_session)
        lines = api.get_lines_at_stop(1000)

        assert lines == ['A', 'D', 'E']

    def test_no_data_returns_empty_list(self):
        """Test returns empty list when no data."""
        mock_session = Mock(spec=requests.Session)
        mock_session.get.side_effect = requests.RequestException()

        api = TUABusAPI(session=mock_session)
        lines = api.get_lines_at_stop(1000)

        assert lines == []

    def test_missing_paradas_key(self):
        """Test returns empty list when paradas key missing."""
        mock_session = Mock(spec=requests.Session)
        mock_response = Mock()
        mock_response.json.return_value = {'other': 'data'}
        mock_session.get.return_value = mock_response

        api = TUABusAPI(session=mock_session)
        lines = api.get_lines_at_stop(1000)

        assert lines == []

    def test_duplicate_lines_removed(self):
        """Test duplicate lines are removed and sorted."""
        mock_session = Mock(spec=requests.Session)
        mock_response = Mock()
        mock_response.json.return_value = {
            'paradas': [
                {
                    'lineas': [
                        {'linea': 'F'},
                        {'linea': 'A'},
                        {'linea': 'F'},  # Duplicate
                        {'linea': 'C'}
                    ]
                }
            ]
        }
        mock_session.get.return_value = mock_response

        api = TUABusAPI(session=mock_session)
        lines = api.get_lines_at_stop(1000)

        assert lines == ['A', 'C', 'F']  # Sorted, no duplicates


class TestGetNextBus:
    """Test get_next_bus() method."""

    def test_get_next_bus_any_line(self):
        """Test getting next bus without line filter."""
        mock_session = Mock(spec=requests.Session)
        mock_response = Mock()
        mock_response.json.return_value = {
            'paradas': [
                {
                    'nombre': 'Test Stop',
                    'lineas': [
                        {'linea': 'A', 'minutos': 5, 'metros': 500}
                    ]
                }
            ]
        }
        mock_session.get.return_value = mock_response

        api = TUABusAPI(session=mock_session)
        next_bus = api.get_next_bus(1000)

        assert next_bus is not None
        assert next_bus['line'] == 'A'
        assert next_bus['minutes'] == 5
        assert next_bus['meters'] == 500
        assert next_bus['destination'] == 'Test Stop'

    def test_get_next_bus_specific_line(self):
        """Test getting next bus for specific line."""
        mock_session = Mock(spec=requests.Session)
        mock_response = Mock()
        mock_response.json.return_value = {
            'paradas': [
                {
                    'nombre': 'Test Stop',
                    'lineas': [
                        {'linea': 'A', 'minutos': 3},
                        {'linea': 'F', 'minutos': 7}
                    ]
                }
            ]
        }
        mock_session.get.return_value = mock_response

        api = TUABusAPI(session=mock_session)
        next_bus = api.get_next_bus(1000, line='F')

        assert next_bus is not None
        assert next_bus['line'] == 'F'
        assert next_bus['minutes'] == 7

    def test_no_buses_returns_none(self):
        """Test returns None when no buses available."""
        mock_session = Mock(spec=requests.Session)
        mock_response = Mock()
        mock_response.json.return_value = {
            'paradas': [
                {
                    'nombre': 'Test Stop',
                    'lineas': []
                }
            ]
        }
        mock_session.get.return_value = mock_response

        api = TUABusAPI(session=mock_session)
        next_bus = api.get_next_bus(1000)

        assert next_bus is None

    def test_line_not_found_returns_none(self):
        """Test returns None when specific line not found."""
        mock_session = Mock(spec=requests.Session)
        mock_response = Mock()
        mock_response.json.return_value = {
            'paradas': [
                {
                    'nombre': 'Test Stop',
                    'lineas': [
                        {'linea': 'A', 'minutos': 5}
                    ]
                }
            ]
        }
        mock_session.get.return_value = mock_response

        api = TUABusAPI(session=mock_session)
        next_bus = api.get_next_bus(1000, line='Z')  # Line Z doesn't exist

        assert next_bus is None

    def test_skip_bus_without_minutes(self):
        """Test skips buses without minutes field."""
        mock_session = Mock(spec=requests.Session)
        mock_response = Mock()
        mock_response.json.return_value = {
            'paradas': [
                {
                    'nombre': 'Test Stop',
                    'lineas': [
                        {'linea': 'A', 'minutos': None},  # No estimate
                        {'linea': 'F', 'minutos': 7}       # Has estimate
                    ]
                }
            ]
        }
        mock_session.get.return_value = mock_response

        api = TUABusAPI(session=mock_session)
        next_bus = api.get_next_bus(1000)

        assert next_bus is not None
        assert next_bus['line'] == 'F'  # Should get the one with estimate


class TestContextManager:
    """Test context manager functionality."""

    def test_context_manager(self):
        """Test using TUABusAPI as context manager."""
        mock_session = Mock(spec=requests.Session)

        with TUABusAPI(session=mock_session) as api:
            assert api is not None

        # Verify session.close() was called
        mock_session.close.assert_called_once()

    def test_close_method(self):
        """Test close() method."""
        mock_session = Mock(spec=requests.Session)
        api = TUABusAPI(session=mock_session)

        api.close()

        mock_session.close.assert_called_once()
