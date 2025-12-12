"""
TUA Bus API Client - REST API wrapper for real-time bus arrivals.

This module provides a Python client for the TUA (Transportes Unidos de Asturias)
REST API to get real-time bus arrival estimates.
"""

from typing import Dict, List, Optional
import requests
import logging

logger = logging.getLogger(__name__)


class TUABusAPIError(Exception):
    """Base exception for TUA Bus API errors."""

    pass


class TUABusAPI:
    """
    Client for TUA Bus REST API.

    Provides access to real-time bus arrival estimates for bus stops in Oviedo.
    """

    BASE_URL = "https://www.tua.es/rest/estimaciones"

    def __init__(self, timeout: int = 10, session: Optional[requests.Session] = None):
        """
        Initialize TUA Bus API client.

        Args:
            timeout: Request timeout in seconds (default: 10)
            session: Optional custom requests.Session (for testing/mocking)
        """
        self.timeout = timeout

        if session is None:
            self.session = requests.Session()
            self.session.headers.update(
                {
                    "Accept": "application/json",
                    "Content-Type": "application/json",
                    "User-Agent": "TUA-Bus-SDK/3.1.0",
                }
            )
        else:
            self.session = session

    def get_arrivals(
        self, stop_code: int, raise_on_error: bool = False
    ) -> Optional[Dict]:
        """
        Get real-time bus arrival estimates for a specific stop.

        Args:
            stop_code: Bus stop code (e.g., 1000, 1001, 1332)
            raise_on_error: If True, raise exception on errors (default: False)

        Returns:
            Dictionary with arrival estimates or None if request fails

        Raises:
            TUABusAPIError: If raise_on_error=True and request fails

        Example:
            >>> api = TUABusAPI()
            >>> arrivals = api.get_arrivals(1000)
            >>> print(arrivals['paradas'][0]['lineas'])
        """
        try:
            url = f"{self.BASE_URL}/{stop_code}"
            response = self.session.get(url, timeout=self.timeout)
            response.raise_for_status()
            data = response.json()

            # Validate response structure
            if not isinstance(data, dict):
                raise TUABusAPIError(f"Invalid response format for stop {stop_code}")

            return data

        except requests.RequestException as e:
            logger.error(f"Error fetching arrivals for stop {stop_code}: {e}")
            if raise_on_error:
                raise TUABusAPIError(
                    f"Failed to fetch arrivals for stop {stop_code}: {e}"
                ) from e
            return None
        except (ValueError, KeyError) as e:
            logger.error(f"Error parsing response for stop {stop_code}: {e}")
            if raise_on_error:
                raise TUABusAPIError(
                    f"Invalid response data for stop {stop_code}: {e}"
                ) from e
            return None

    def get_lines_at_stop(self, stop_code: int) -> List[str]:
        """
        Get list of bus lines serving a specific stop.

        Args:
            stop_code: Bus stop code

        Returns:
            List of line names (e.g., ['A', 'D', 'E'])
        """
        data = self.get_arrivals(stop_code)
        if not data or "paradas" not in data:
            return []

        lines = set()
        for stop in data["paradas"]:
            for line in stop.get("lineas", []):
                lines.add(line["linea"])

        return sorted(list(lines))

    def get_next_bus(
        self, stop_code: int, line: Optional[str] = None
    ) -> Optional[Dict]:
        """
        Get the next bus arrival at a stop, optionally filtered by line.

        Args:
            stop_code: Bus stop code
            line: Optional line filter (e.g., 'A', 'F')

        Returns:
            Dictionary with next bus info or None
        """
        data = self.get_arrivals(stop_code)
        if not data or "paradas" not in data:
            return None

        for stop in data["paradas"]:
            for bus_line in stop.get("lineas", []):
                if line is None or bus_line["linea"] == line:
                    if bus_line.get("minutos") is not None:
                        return {
                            "line": bus_line["linea"],
                            "minutes": bus_line["minutos"],
                            "meters": bus_line.get("metros"),
                            "destination": stop.get("nombre", "Unknown"),
                        }

        return None

    def close(self):
        """Close the HTTP session."""
        self.session.close()

    def __enter__(self):
        """Context manager entry."""
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        """Context manager exit."""
        self.close()
