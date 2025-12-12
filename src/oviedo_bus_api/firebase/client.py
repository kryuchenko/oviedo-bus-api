"""
TUA Firebase Client - Access to complete bus stop database with GPS coordinates.

This module provides access to the Firebase Firestore database containing:
- All 553 bus stops with GPS coordinates (100% coverage)
- 32 routes with ordered stops
- 16 schedules in HTML format
- Line colors and accessibility information
"""

from typing import Dict, List, Optional, Callable
import json
import os
from pathlib import Path
import logging

logger = logging.getLogger(__name__)


class TUAFirebaseError(Exception):
    """Base exception for TUA Firebase client errors."""

    pass


class TUAFirebaseClient:
    """
    Client for TUA Firebase Firestore data.

    Provides access to static data: stops with GPS, routes, schedules.
    """

    def __init__(
        self,
        data_dir: Optional[str] = None,
        file_loader: Optional[Callable[[Path], Dict]] = None,
    ):
        """
        Initialize Firebase client.

        Args:
            data_dir: Directory containing Firebase JSON files
                     (default: data/firebase/ relative to package)
            file_loader: Optional custom file loader function for testing
        """
        if data_dir is None:
            # Try to find data directory relative to package
            package_dir = Path(__file__).parent.parent.parent.parent
            data_dir = package_dir / "data" / "firebase"
        else:
            data_dir = Path(data_dir)

        self.data_dir = data_dir
        self._file_loader = file_loader or self._default_file_loader
        self._stops = None
        self._routes = None
        self._schedules = None
        self._complete = None

    @staticmethod
    def _default_file_loader(file_path: Path) -> Dict:
        """Default file loader implementation."""
        with open(file_path, "r", encoding="utf-8") as f:
            return json.load(f)

    def load_stops(self) -> Dict:
        """
        Load all bus stops with GPS coordinates.

        Returns:
            Dictionary with stops data (553 stops, 100% GPS coverage)

        Raises:
            TUAFirebaseError: If data file not found or invalid
        """
        if self._stops is None:
            stops_file = self.data_dir / "tua_firebase_stops_gps.json"
            if not stops_file.exists():
                raise TUAFirebaseError(
                    f"Stops data not found: {stops_file}\n"
                    "Run: python3 scripts/download_firebase_data.py"
                )

            try:
                self._stops = self._file_loader(stops_file)

                # Validate data structure
                if not isinstance(self._stops, dict):
                    raise TUAFirebaseError("Invalid stops data format: expected dict")
                if "stops" not in self._stops:
                    raise TUAFirebaseError("Invalid stops data: missing 'stops' key")
                if not isinstance(self._stops["stops"], list):
                    raise TUAFirebaseError("Invalid stops data: 'stops' must be a list")

                logger.info(
                    f"Loaded {len(self._stops['stops'])} stops from {stops_file}"
                )

            except (json.JSONDecodeError, KeyError) as e:
                raise TUAFirebaseError(f"Failed to parse stops data: {e}") from e

        return self._stops

    def load_routes(self) -> Dict:
        """
        Load all routes with ordered stops.

        Returns:
            Dictionary with 32 routes data

        Raises:
            TUAFirebaseError: If data file not found or invalid
        """
        if self._routes is None:
            routes_file = self.data_dir / "tua_firebase_routes.json"
            if not routes_file.exists():
                raise TUAFirebaseError(
                    f"Routes data not found: {routes_file}\n"
                    "Run: python3 scripts/analyze_firebase_data.py"
                )

            try:
                self._routes = self._file_loader(routes_file)

                # Validate data structure
                if not isinstance(self._routes, dict):
                    raise TUAFirebaseError("Invalid routes data format: expected dict")
                if "routes" not in self._routes:
                    raise TUAFirebaseError("Invalid routes data: missing 'routes' key")
                if not isinstance(self._routes["routes"], list):
                    raise TUAFirebaseError(
                        "Invalid routes data: 'routes' must be a list"
                    )

                logger.info(
                    f"Loaded {len(self._routes['routes'])} routes from {routes_file}"
                )

            except (json.JSONDecodeError, KeyError) as e:
                raise TUAFirebaseError(f"Failed to parse routes data: {e}") from e

        return self._routes

    def load_schedules(self) -> Dict:
        """
        Load all schedules in HTML format.

        Returns:
            Dictionary with 16 schedules

        Raises:
            TUAFirebaseError: If data file not found or invalid
        """
        if self._schedules is None:
            schedules_file = self.data_dir / "tua_firebase_schedules.json"
            if not schedules_file.exists():
                raise TUAFirebaseError(
                    f"Schedules data not found: {schedules_file}\n"
                    "Run: python3 scripts/analyze_firebase_data.py"
                )

            try:
                self._schedules = self._file_loader(schedules_file)

                # Validate data structure
                if not isinstance(self._schedules, dict):
                    raise TUAFirebaseError(
                        "Invalid schedules data format: expected dict"
                    )
                if "schedules" not in self._schedules:
                    raise TUAFirebaseError(
                        "Invalid schedules data: missing 'schedules' key"
                    )

                logger.info(f"Loaded schedules from {schedules_file}")

            except (json.JSONDecodeError, KeyError) as e:
                raise TUAFirebaseError(f"Failed to parse schedules data: {e}") from e

        return self._schedules

    def get_stop_by_code(self, code: int) -> Optional[Dict]:
        """
        Get stop information by stop code.

        Args:
            code: Stop code (e.g., 1000, 1332)

        Returns:
            Stop information with GPS coordinates or None
        """
        stops_data = self.load_stops()
        for stop in stops_data["stops"]:
            if stop["code"] == code:
                return stop
        return None

    def get_stops_by_line(self, line: str) -> List[Dict]:
        """
        Get all stops served by a specific line.

        Args:
            line: Line name (e.g., 'A', 'F', 'BÚHO')

        Returns:
            List of stops with GPS coordinates
        """
        stops_data = self.load_stops()
        result = []
        for stop in stops_data["stops"]:
            if line in stop.get("lines", []):
                result.append(stop)
        return result

    def get_route_stops(self, line: str, direction: str = "ida") -> List[Dict]:
        """
        Get ordered stops for a specific route.

        Args:
            line: Line name (e.g., 'A', 'F')
            direction: Route direction ('ida' or 'vuelta')

        Returns:
            List of stops in route order with GPS coordinates
        """
        routes_data = self.load_routes()

        for route in routes_data["routes"]:
            if route["line"] == line and route["direction"] == direction:
                return route["stops"]

        return []

    def get_schedule(self, line: str) -> Optional[Dict]:
        """
        Get schedule for a specific line.

        Args:
            line: Line name (e.g., 'A', 'F')

        Returns:
            Schedule information with HTML content or None
        """
        schedules_data = self.load_schedules()

        for schedule in schedules_data["schedules"]:
            if schedule["line"] == line:
                return schedule

        return None

    def search_stops(self, query: str) -> List[Dict]:
        """
        Search stops by name.

        Args:
            query: Search query (case-insensitive)

        Returns:
            List of matching stops
        """
        stops_data = self.load_stops()
        query = query.lower()

        results = []
        for stop in stops_data["stops"]:
            if query in stop["name"].lower():
                results.append(stop)

        return results
