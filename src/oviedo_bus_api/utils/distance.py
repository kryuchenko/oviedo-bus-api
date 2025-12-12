"""
Distance calculation utilities for GPS coordinates.

Provides functions for calculating distances between coordinates and finding
nearest points using the Haversine formula.
"""

import math
from typing import List, Tuple, Dict


def haversine_distance(lat1: float, lon1: float, lat2: float, lon2: float) -> float:
    """
    Calculate the great circle distance between two points on Earth.

    Uses the Haversine formula to calculate distance in meters.

    Args:
        lat1: Latitude of first point (degrees)
        lon1: Longitude of first point (degrees)
        lat2: Latitude of second point (degrees)
        lon2: Longitude of second point (degrees)

    Returns:
        Distance in meters

    Example:
        >>> distance = haversine_distance(43.3623, -5.8497, 43.3641, -5.8660)
        >>> print(f"{distance:.0f} meters")
    """
    # Earth radius in meters
    R = 6371000

    # Convert degrees to radians
    lat1_rad = math.radians(lat1)
    lat2_rad = math.radians(lat2)
    delta_lat = math.radians(lat2 - lat1)
    delta_lon = math.radians(lon2 - lon1)

    # Haversine formula
    a = (
        math.sin(delta_lat / 2) ** 2
        + math.cos(lat1_rad) * math.cos(lat2_rad) * math.sin(delta_lon / 2) ** 2
    )
    c = 2 * math.atan2(math.sqrt(a), math.sqrt(1 - a))

    distance = R * c
    return distance


def find_nearest_points(
    target_lat: float,
    target_lon: float,
    points: List[Dict],
    max_distance: float = None,
    limit: int = None,
) -> List[Tuple[Dict, float]]:
    """
    Find nearest points to a target location.

    Args:
        target_lat: Target latitude (degrees)
        target_lon: Target longitude (degrees)
        points: List of points with 'latitude' and 'longitude' keys
        max_distance: Maximum distance in meters (optional)
        limit: Maximum number of results (optional)

    Returns:
        List of (point, distance) tuples sorted by distance

    Example:
        >>> stops = [
        ...     {'code': 1000, 'name': 'Stop A', 'latitude': 43.36, 'longitude': -5.84},
        ...     {'code': 1001, 'name': 'Stop B', 'latitude': 43.37, 'longitude': -5.85}
        ... ]
        >>> nearest = find_nearest_points(43.365, -5.845, stops, max_distance=500, limit=5)
    """
    results = []

    for point in points:
        # Skip points without GPS coordinates
        if "latitude" not in point or "longitude" not in point:
            continue

        distance = haversine_distance(
            target_lat, target_lon, point["latitude"], point["longitude"]
        )

        # Filter by max distance if specified
        if max_distance is not None and distance > max_distance:
            continue

        results.append((point, distance))

    # Sort by distance
    results.sort(key=lambda x: x[1])

    # Limit results if specified
    if limit is not None:
        results = results[:limit]

    return results


def format_distance(meters: float) -> str:
    """
    Format distance in human-readable format.

    Args:
        meters: Distance in meters

    Returns:
        Formatted string (e.g., "250 m" or "1.5 km")

    Example:
        >>> format_distance(250)
        '250 m'
        >>> format_distance(1500)
        '1.5 km'
    """
    if meters < 1000:
        return f"{meters:.0f} m"
    else:
        km = meters / 1000
        return f"{km:.1f} km"


def calculate_bearing(lat1: float, lon1: float, lat2: float, lon2: float) -> float:
    """
    Calculate the bearing (direction) from point 1 to point 2.

    Args:
        lat1: Latitude of first point (degrees)
        lon1: Longitude of first point (degrees)
        lat2: Latitude of second point (degrees)
        lon2: Longitude of second point (degrees)

    Returns:
        Bearing in degrees (0-360, where 0 is North)

    Example:
        >>> bearing = calculate_bearing(43.36, -5.84, 43.37, -5.85)
        >>> print(f"{bearing:.1f}° (North-West)")
    """
    lat1_rad = math.radians(lat1)
    lat2_rad = math.radians(lat2)
    delta_lon = math.radians(lon2 - lon1)

    x = math.sin(delta_lon) * math.cos(lat2_rad)
    y = math.cos(lat1_rad) * math.sin(lat2_rad) - math.sin(lat1_rad) * math.cos(
        lat2_rad
    ) * math.cos(delta_lon)

    bearing_rad = math.atan2(x, y)
    bearing_deg = math.degrees(bearing_rad)

    # Normalize to 0-360
    bearing_deg = (bearing_deg + 360) % 360

    return bearing_deg


def bearing_to_compass(bearing: float) -> str:
    """
    Convert bearing to compass direction.

    Args:
        bearing: Bearing in degrees (0-360)

    Returns:
        Compass direction (e.g., "N", "NE", "SW")

    Example:
        >>> bearing_to_compass(45)
        'NE'
        >>> bearing_to_compass(270)
        'W'
    """
    directions = ["N", "NE", "E", "SE", "S", "SW", "W", "NW"]
    index = round(bearing / 45) % 8
    return directions[index]
