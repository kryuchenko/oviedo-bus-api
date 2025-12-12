#!/usr/bin/env python3
"""
Analyze downloaded Firebase data and create useful extracts.

This script processes the complete Firebase download and creates:
1. Clean stops database with GPS coordinates
2. Routes database with all lines
3. Schedules extract
4. Statistics report
"""

import json
from typing import Dict, List


def load_firebase_data() -> Dict:
    """Load the complete Firebase download."""
    with open('tua_firebase_complete.json', 'r', encoding='utf-8') as f:
        return json.load(f)


def extract_all_stops_with_gps(data: Dict) -> List[Dict]:
    """
    Extract all unique stops with GPS coordinates.
    Firebase data has GPS in 'location.geoPointValue' format.
    """
    stops_by_code = {}

    for group in data['groups']:
        for line in group.get('lines', []):
            for stop in line.get('stops', []):
                code = stop.get('code')
                if not code:
                    continue

                # Check if we already have this stop
                if code in stops_by_code:
                    continue

                # Extract GPS coordinates
                location = stop.get('location')
                if location and 'geoPointValue' in location:
                    gps = location['geoPointValue']
                    stops_by_code[code] = {
                        'code': code,
                        'name': stop.get('name', 'Unknown'),
                        'latitude': gps.get('latitude'),
                        'longitude': gps.get('longitude'),
                        'first_seen_on_line': line.get('name'),
                        'first_seen_in_group': group.get('name'),
                    }

    # Convert to sorted list
    stops_list = sorted(stops_by_code.values(), key=lambda x: x['code'])

    return stops_list


def extract_routes_database(data: Dict) -> List[Dict]:
    """Extract all routes (lines) with their stops."""
    routes = []

    for group in data['groups']:
        group_name = group.get('name')
        group_color = group.get('color')

        for line in group.get('lines', []):
            route = {
                'group': group_name,
                'line': line.get('name'),
                'color': group_color,
                'source': line.get('source'),
                'destination': line.get('destination'),
                'route_url': line.get('route'),
                'stops': []
            }

            # Add stops in order
            stops = sorted(line.get('stops', []), key=lambda x: x.get('order', 999))
            for stop in stops:
                location = stop.get('location')
                gps = None
                if location and 'geoPointValue' in location:
                    gps = location['geoPointValue']

                route['stops'].append({
                    'code': stop.get('code'),
                    'name': stop.get('name'),
                    'order': stop.get('order'),
                    'latitude': gps.get('latitude') if gps else None,
                    'longitude': gps.get('longitude') if gps else None,
                })

            routes.append(route)

    return routes


def extract_schedules(data: Dict) -> Dict[str, str]:
    """Extract schedules for all lines."""
    schedules = {}

    for group in data['groups']:
        group_name = group.get('name')
        schedule = group.get('schedule', '')

        if schedule:
            schedules[group_name] = schedule

    return schedules


def create_statistics(data: Dict) -> Dict:
    """Generate statistics about the dataset."""
    stats = {
        'total_groups': len(data['groups']),
        'total_lines': 0,
        'total_stops': 0,
        'stops_with_gps': 0,
        'stops_without_gps': 0,
        'unique_stops': set(),
        'groups_detail': []
    }

    for group in data['groups']:
        group_stats = {
            'name': group.get('name'),
            'color': group.get('color'),
            'lines': len(group.get('lines', [])),
            'stops': 0,
        }

        for line in group.get('lines', []):
            stats['total_lines'] += 1
            line_stops = line.get('stops', [])
            group_stats['stops'] += len(line_stops)
            stats['total_stops'] += len(line_stops)

            for stop in line_stops:
                code = stop.get('code')
                if code:
                    stats['unique_stops'].add(code)

                location = stop.get('location')
                if location and 'geoPointValue' in location:
                    stats['stops_with_gps'] += 1
                else:
                    stats['stops_without_gps'] += 1

        stats['groups_detail'].append(group_stats)

    stats['unique_stops_count'] = len(stats['unique_stops'])
    del stats['unique_stops']  # Remove set for JSON serialization

    return stats


def main():
    """Main analysis function."""
    print("="*60)
    print("TUA Firebase Data Analysis")
    print("="*60)

    print("\n📥 Loading Firebase data...")
    data = load_firebase_data()
    print("✅ Loaded!")

    # Extract stops with GPS
    print("\n📍 Extracting stops with GPS coordinates...")
    stops = extract_all_stops_with_gps(data)
    print(f"✅ Found {len(stops)} unique stops with GPS!")

    # Save stops
    stops_file = 'tua_firebase_stops_gps.json'
    with open(stops_file, 'w', encoding='utf-8') as f:
        json.dump({
            'source': 'Firebase Firestore',
            'total_stops': len(stops),
            'stops': stops
        }, f, indent=2, ensure_ascii=False)
    print(f"💾 Saved to: {stops_file}")

    # Extract routes
    print("\n🗺️  Extracting routes database...")
    routes = extract_routes_database(data)
    print(f"✅ Found {len(routes)} routes!")

    # Save routes
    routes_file = 'tua_firebase_routes.json'
    with open(routes_file, 'w', encoding='utf-8') as f:
        json.dump({
            'source': 'Firebase Firestore',
            'total_routes': len(routes),
            'routes': routes
        }, f, indent=2, ensure_ascii=False)
    print(f"💾 Saved to: {routes_file}")

    # Extract schedules
    print("\n📅 Extracting schedules...")
    schedules = extract_schedules(data)
    print(f"✅ Found {len(schedules)} schedules!")

    # Save schedules
    schedules_file = 'tua_firebase_schedules.json'
    with open(schedules_file, 'w', encoding='utf-8') as f:
        json.dump({
            'source': 'Firebase Firestore',
            'schedules': schedules
        }, f, indent=2, ensure_ascii=False)
    print(f"💾 Saved to: {schedules_file}")

    # Generate statistics
    print("\n📊 Generating statistics...")
    stats = create_statistics(data)

    # Save stats
    stats_file = 'tua_firebase_stats.json'
    with open(stats_file, 'w', encoding='utf-8') as f:
        json.dump(stats, f, indent=2, ensure_ascii=False)
    print(f"💾 Saved to: {stats_file}")

    # Print summary
    print("\n" + "="*60)
    print("SUMMARY")
    print("="*60)
    print(f"📊 Total groups: {stats['total_groups']}")
    print(f"📊 Total lines/routes: {stats['total_lines']}")
    print(f"📊 Total stop instances: {stats['total_stops']}")
    print(f"📊 Unique stops: {stats['unique_stops_count']}")
    print(f"📊 Stops with GPS: {stats['stops_with_gps']}")
    print(f"📊 Stops without GPS: {stats['stops_without_gps']}")

    gps_coverage = (stats['stops_with_gps'] / stats['total_stops'] * 100) if stats['total_stops'] > 0 else 0
    print(f"📊 GPS coverage: {gps_coverage:.1f}%")

    # Show some examples
    print("\n" + "="*60)
    print("EXAMPLES")
    print("="*60)

    if stops:
        print(f"\n📍 Example Stop (code {stops[0]['code']}):")
        print(f"   Name: {stops[0]['name']}")
        print(f"   Latitude: {stops[0]['latitude']}")
        print(f"   Longitude: {stops[0]['longitude']}")
        print(f"   Line: {stops[0]['first_seen_on_line']}")

    if routes:
        print(f"\n🗺️  Example Route ({routes[0]['line']}):")
        print(f"   Group: {routes[0]['group']}")
        print(f"   Color: {routes[0]['color']}")
        print(f"   From: {routes[0]['source']}")
        print(f"   To: {routes[0]['destination']}")
        print(f"   Stops: {len(routes[0]['stops'])}")

    if schedules:
        schedule_key = list(schedules.keys())[0]
        schedule_preview = schedules[schedule_key][:100]
        print(f"\n📅 Example Schedule ({schedule_key}):")
        print(f"   {schedule_preview}...")

    print("\n" + "="*60)
    print("FILES CREATED")
    print("="*60)
    print(f"✅ {stops_file} - All unique stops with GPS")
    print(f"✅ {routes_file} - All routes with ordered stops")
    print(f"✅ {schedules_file} - All schedules (HTML format)")
    print(f"✅ {stats_file} - Complete statistics")

    print("\n🎉 Analysis complete!")


if __name__ == '__main__':
    main()
