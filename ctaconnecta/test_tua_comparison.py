#!/usr/bin/env python3
"""
Сравним TUA API и CTA API - TUA должен показывать автобусы сейчас
"""
import requests
import json
from datetime import datetime

print(f"🕐 Текущее время: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}")
print()

# 1. Проверим TUA API - городские автобусы Овьедо
print("=" * 70)
print("TEST 1: TUA API (городские автобусы Овьедо)")
print("=" * 70)

tua_url = "https://www.tua.es/rest/estimaciones/1"  # Остановка 1
try:
    response = requests.get(tua_url, timeout=10)
    print(f"Status: {response.status_code}")
    
    if response.status_code == 200:
        data = response.json()
        print(f"✅ TUA API работает!")
        print(f"Данные: {json.dumps(data, ensure_ascii=False, indent=2)[:500]}")
        
        # Проверяем есть ли автобусы
        if isinstance(data, dict) and 'lineas' in data:
            print(f"\nНайдено линий: {len(data.get('lineas', []))}")
            for linea in data.get('lineas', [])[:3]:
                print(f"  - Линия {linea.get('linea')}: {len(linea.get('paradas', []))} остановок")
    else:
        print(f"❌ Status {response.status_code}")
except Exception as e:
    print(f"❌ Ошибка: {e}")

# 2. Попробуем с разными headers
print("\n" + "=" * 70)
print("TEST 2: CTA API с разными headers")
print("=" * 70)

base_url = "https://www.consorcioasturias.org/appcta/api"

headers_variants = [
    {
        "User-Agent": "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36",
        "Accept": "application/json",
    },
    {
        "User-Agent": "Dalvik/2.1.0 (Linux; U; Android 10; SM-G960F Build/QP1A.190711.020)",
        "Accept": "application/json",
    },
    {
        "User-Agent": "okhttp/4.9.0",
        "Accept": "application/json",
    }
]

stop_id = 3614

for i, headers in enumerate(headers_variants, 1):
    print(f"\n[{i}] User-Agent: {headers['User-Agent'][:50]}...")
    url = f"{base_url}/StopsFis/{stop_id}/60/arrivalEstimates"
    
    try:
        response = requests.get(url, headers=headers, timeout=5)
        estimates = response.json()
        
        vehicles = [e for e in estimates if e.get('vehicleId', 0) != 0]
        if vehicles:
            print(f"  ✅ Найдено {len(vehicles)} автобусов с vehicleId!")
        else:
            print(f"  ⚪ vehicleId = 0 (прогнозов: {len(estimates)})")
            if estimates:
                print(f"     Сообщение: {estimates[0].get('directionDesc', '')[:50]}")
    except Exception as e:
        print(f"  ❌ Ошибка: {e}")

# 3. Проверим может быть другой базовый URL
print("\n" + "=" * 70)
print("TEST 3: Альтернативные URL")
print("=" * 70)

alt_urls = [
    "https://www.consorcioasturias.org/appcta/api",
    "https://www.consorcioasturias.org/rtm/api",  # Из APK
    "https://consorcioasturias.org/appcta/api",
    "https://api.consorcioasturias.org/appcta/api",
]

for url in alt_urls:
    print(f"\n🔍 {url}")
    test_url = f"{url}/Coordinates/GapTimeRefresh"
    
    try:
        response = requests.get(test_url, timeout=5, headers={"User-Agent": "Mozilla/5.0"})
        if response.status_code == 200:
            print(f"  ✅ Status 200, ответ: {response.text}")
        else:
            print(f"  ❌ Status {response.status_code}")
    except Exception as e:
        print(f"  ❌ Ошибка: {str(e)[:100]}")

