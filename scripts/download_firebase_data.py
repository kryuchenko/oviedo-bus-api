#!/usr/bin/env python3
"""
Download all data from TUA Firebase Firestore.

Uses API key from decompiled APK to access Firebase REST API.
Downloads: groups, lines, stops, prices, accessibility data.

Success rate: We can read individual documents and collections!
"""

import requests
import json
import time
from typing import Dict, List, Any, Optional


class FirebaseDownloader:
    """Download data from Firebase Firestore using REST API."""

    def __init__(self):
        self.project_id = 'alsa-tua'
        self.api_key = 'AIzaSyA33UosvNZi3hlyjIV1jTCfUFrOjrZsR6M'
        self.base_url = f"https://firestore.googleapis.com/v1/projects/{self.project_id}/databases/(default)/documents"
        self.session = requests.Session()

    def _firestore_value_to_python(self, field_value: Dict) -> Any:
        """Convert Firestore field value to Python type."""
        if 'stringValue' in field_value:
            return field_value['stringValue']
        elif 'integerValue' in field_value:
            return int(field_value['integerValue'])
        elif 'doubleValue' in field_value:
            return float(field_value['doubleValue'])
        elif 'booleanValue' in field_value:
            return field_value['booleanValue']
        elif 'arrayValue' in field_value:
            values = field_value['arrayValue'].get('values', [])
            return [self._firestore_value_to_python(v) for v in values]
        elif 'mapValue' in field_value:
            fields = field_value['mapValue'].get('fields', {})
            return {k: self._firestore_value_to_python(v) for k, v in fields.items()}
        elif 'nullValue' in field_value:
            return None
        else:
            return field_value

    def _parse_document(self, doc: Dict) -> Dict:
        """Parse Firestore document into Python dict."""
        if 'fields' not in doc:
            return {}

        result = {}
        for field_name, field_value in doc['fields'].items():
            result[field_name] = self._firestore_value_to_python(field_value)

        # Add metadata
        if 'name' in doc:
            # Extract document ID from name
            doc_id = doc['name'].split('/')[-1]
            result['_id'] = doc_id

        if 'createTime' in doc:
            result['_createTime'] = doc['createTime']
        if 'updateTime' in doc:
            result['_updateTime'] = doc['updateTime']

        return result

    def get_collection(self, path: str) -> List[Dict]:
        """Get all documents from a collection."""
        url = f"{self.base_url}/{path}"
        params = {'key': self.api_key, 'pageSize': 300}

        print(f"📥 Fetching: {path}...")

        try:
            response = self.session.get(url, params=params, timeout=15)

            if response.status_code == 200:
                data = response.json()
                documents = data.get('documents', [])
                print(f"   ✅ Got {len(documents)} documents")

                return [self._parse_document(doc) for doc in documents]

            else:
                print(f"   ❌ Failed: {response.status_code}")
                print(f"   Response: {response.text[:200]}")
                return []

        except Exception as e:
            print(f"   ❌ Error: {e}")
            return []

    def get_document(self, path: str) -> Optional[Dict]:
        """Get a single document."""
        url = f"{self.base_url}/{path}"
        params = {'key': self.api_key}

        try:
            response = self.session.get(url, params=params, timeout=10)

            if response.status_code == 200:
                return self._parse_document(response.json())
            else:
                return None

        except Exception as e:
            print(f"   ❌ Error fetching {path}: {e}")
            return None

    def download_all_groups(self) -> List[Dict]:
        """Download all bus line groups (A, B, C, D, E, F, etc.)."""
        print("\n" + "="*60)
        print("DOWNLOADING GROUPS")
        print("="*60)

        groups = self.get_collection('groups')

        # For each group, get its lines
        for group in groups:
            group_name = group.get('name')
            if not group_name:
                continue

            print(f"\n📂 Group {group_name}:")

            # Get lines for this group
            lines = self.get_collection(f'groups/{group_name}/lines')
            group['lines'] = lines

            # For each line, get stops
            for line in lines:
                line_name = line.get('name')
                if not line_name:
                    continue

                print(f"   📍 Line: {line_name}")

                stops = self.get_collection(f'groups/{group_name}/lines/{line_name}/stops')
                line['stops'] = stops

                print(f"      ✅ {len(stops)} stops")

                # Small delay to avoid rate limiting
                time.sleep(0.1)

        return groups

    def download_prices(self) -> List[Dict]:
        """Download pricing information."""
        print("\n" + "="*60)
        print("DOWNLOADING PRICES")
        print("="*60)

        return self.get_collection('prices')

    def download_accessibility(self) -> List[Dict]:
        """Download accessibility information."""
        print("\n" + "="*60)
        print("DOWNLOADING ACCESSIBILITY")
        print("="*60)

        return self.get_collection('accesibility')

    def download_config(self) -> Optional[Dict]:
        """Download app configuration."""
        print("\n" + "="*60)
        print("DOWNLOADING CONFIG")
        print("="*60)

        config = self.get_document('config/android')
        if config:
            print(f"   ✅ Got config: {config}")
        return config

    def download_all(self) -> Dict:
        """Download everything from Firebase."""
        print("""
╔════════════════════════════════════════════════════════════╗
║         TUA Firebase Data Downloader                       ║
║  Using API Key from decompiled APK                         ║
╚════════════════════════════════════════════════════════════╝
        """)

        result = {
            'source': 'Firebase Firestore (alsa-tua)',
            'method': 'REST API with APK credentials',
            'downloaded_at': time.strftime('%Y-%m-%d %H:%M:%S'),
            'groups': [],
            'prices': [],
            'accessibility': [],
            'config': None,
        }

        # Download all data
        result['groups'] = self.download_all_groups()
        result['prices'] = self.download_prices()
        result['accessibility'] = self.download_accessibility()
        result['config'] = self.download_config()

        return result


def main():
    """Main function."""
    downloader = FirebaseDownloader()
    data = downloader.download_all()

    # Save to file
    output_file = 'tua_firebase_complete.json'
    print(f"\n💾 Saving to {output_file}...")

    with open(output_file, 'w', encoding='utf-8') as f:
        json.dump(data, f, indent=2, ensure_ascii=False)

    print(f"✅ Saved!")

    # Print summary
    print("\n" + "="*60)
    print("DOWNLOAD SUMMARY")
    print("="*60)

    groups_count = len(data['groups'])
    lines_count = sum(len(g.get('lines', [])) for g in data['groups'])
    stops_count = sum(
        len(line.get('stops', []))
        for group in data['groups']
        for line in group.get('lines', [])
    )

    print(f"📊 Groups: {groups_count}")
    print(f"📊 Lines: {lines_count}")
    print(f"📊 Stops: {stops_count}")
    print(f"📊 Prices: {len(data['prices'])}")
    print(f"📊 Accessibility: {len(data['accessibility'])}")
    print(f"📊 Config: {'✅' if data['config'] else '❌'}")

    # Show some examples
    if data['groups']:
        print(f"\n📋 Example Group (E):")
        group_e = next((g for g in data['groups'] if g.get('name') == 'E'), None)
        if group_e:
            print(f"   Name: {group_e.get('name')}")
            print(f"   Color: {group_e.get('color')}")
            print(f"   Lines: {len(group_e.get('lines', []))}")

            if group_e.get('lines'):
                line = group_e['lines'][0]
                print(f"\n   Example Line:")
                print(f"      Name: {line.get('name')}")
                print(f"      Route: {line.get('route', 'N/A')[:50]}...")
                print(f"      Stops: {len(line.get('stops', []))}")

    print(f"\n✅ Complete data saved to: {output_file}")
    print(f"📁 File size: {len(json.dumps(data))} bytes")


if __name__ == '__main__':
    main()
