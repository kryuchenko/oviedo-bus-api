#!/usr/bin/env python3
"""
Analyze collected bus tracks and generate GeoJSON for map visualization.

Usage:
    python analyze-tracks.py tracks_20251216/all_tracks.jsonl

Output:
    - tracks_by_bus.geojson - LineStrings for each bus
    - heatmap_points.geojson - All points for heatmap
    - stats.json - Statistics
"""

import json
import sys
from collections import defaultdict
from datetime import datetime

def load_tracks(filename):
    """Load tracks from JSONL file."""
    tracks = []
    with open(filename, 'r') as f:
        for line in f:
            line = line.strip()
            if line:
                try:
                    tracks.append(json.loads(line))
                except json.JSONDecodeError:
                    continue
    return tracks

def group_by_bus(tracks):
    """Group tracks by bus ID."""
    by_bus = defaultdict(list)
    for t in tracks:
        by_bus[t['id']].append(t)

    # Sort each bus's points by timestamp
    for bus_id in by_bus:
        by_bus[bus_id].sort(key=lambda x: x['ts'])

    return by_bus

def generate_geojson_tracks(tracks_by_bus):
    """Generate GeoJSON with LineString for each bus."""
    features = []

    for bus_id, points in tracks_by_bus.items():
        if len(points) < 2:
            continue

        coordinates = [[p['lon'], p['lat']] for p in points]

        feature = {
            "type": "Feature",
            "properties": {
                "bus_id": bus_id,
                "points_count": len(points),
                "start_time": points[0]['ts'],
                "end_time": points[-1]['ts']
            },
            "geometry": {
                "type": "LineString",
                "coordinates": coordinates
            }
        }
        features.append(feature)

    return {
        "type": "FeatureCollection",
        "features": features
    }

def generate_geojson_points(tracks):
    """Generate GeoJSON with all points for heatmap."""
    features = []

    for t in tracks:
        feature = {
            "type": "Feature",
            "properties": {
                "bus_id": t['id'],
                "timestamp": t['ts'],
                "locDate": t.get('locDate', '')
            },
            "geometry": {
                "type": "Point",
                "coordinates": [t['lon'], t['lat']]
            }
        }
        features.append(feature)

    return {
        "type": "FeatureCollection",
        "features": features
    }

def calculate_stats(tracks, tracks_by_bus):
    """Calculate statistics."""
    return {
        "total_points": len(tracks),
        "unique_buses": len(tracks_by_bus),
        "buses": {
            str(bus_id): {
                "points": len(points),
                "first_seen": points[0]['ts'],
                "last_seen": points[-1]['ts']
            }
            for bus_id, points in tracks_by_bus.items()
        },
        "time_range": {
            "start": min(t['ts'] for t in tracks) if tracks else None,
            "end": max(t['ts'] for t in tracks) if tracks else None
        }
    }

def main():
    if len(sys.argv) < 2:
        print("Usage: python analyze-tracks.py <tracks.jsonl>")
        print("Example: python analyze-tracks.py tracks_20251216/all_tracks.jsonl")
        sys.exit(1)

    input_file = sys.argv[1]
    output_prefix = input_file.rsplit('.', 1)[0]

    print(f"Loading tracks from {input_file}...")
    tracks = load_tracks(input_file)
    print(f"Loaded {len(tracks)} track points")

    if not tracks:
        print("No tracks found!")
        sys.exit(1)

    print("Grouping by bus...")
    tracks_by_bus = group_by_bus(tracks)
    print(f"Found {len(tracks_by_bus)} unique buses")

    # Generate outputs
    tracks_geojson = generate_geojson_tracks(tracks_by_bus)
    points_geojson = generate_geojson_points(tracks)
    stats = calculate_stats(tracks, tracks_by_bus)

    # Save files
    tracks_file = f"{output_prefix}_tracks.geojson"
    points_file = f"{output_prefix}_points.geojson"
    stats_file = f"{output_prefix}_stats.json"

    with open(tracks_file, 'w') as f:
        json.dump(tracks_geojson, f)
    print(f"Saved tracks to {tracks_file}")

    with open(points_file, 'w') as f:
        json.dump(points_geojson, f)
    print(f"Saved points to {points_file}")

    with open(stats_file, 'w') as f:
        json.dump(stats, f, indent=2)
    print(f"Saved stats to {stats_file}")

    # Print summary
    print("\n=== Summary ===")
    print(f"Total points: {stats['total_points']}")
    print(f"Unique buses: {stats['unique_buses']}")
    print(f"Time range: {stats['time_range']['start']} - {stats['time_range']['end']}")

    # Top buses by points
    top_buses = sorted(tracks_by_bus.items(), key=lambda x: len(x[1]), reverse=True)[:10]
    print("\nTop 10 buses by activity:")
    for bus_id, points in top_buses:
        print(f"  Bus {bus_id}: {len(points)} points")

if __name__ == "__main__":
    main()
