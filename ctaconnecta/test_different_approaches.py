#!/usr/bin/env python3
"""
Пробуем разные подходы к получению данных об автобусах
"""
import requests
import json

BASE_URL = "https://www.consorcioasturias.org/appcta/api"
HEADERS = {"User-Agent": "Mozilla/5.0"}

print("🔍 Попробуем разные подходы...\n")

# 1. Попробуем получить координаты напрямую с vehicleId = 1, 100, 1000 и т.д.
print("=" * 70)
print("TEST 1: Прямой запрос координат с разными vehicleId")
print("=" * 70)

for vid in [1, 10, 100, 1000, 12345]:
    url = f"{BASE_URL}/Coordinates/VehicleCoordinates/{vid}"
    try:
        response = requests.get(url, headers=HEADERS, timeout=5)
        print(f"\nVehicleId {vid}: Status {response.status_code}")
        if response.status_code == 200:
            data = response.json()
            print(f"✅ Данные получены!")
            print(json.dumps(data, ensure_ascii=False, indent=2)[:500])
        else:
            print(f"   Ответ: {response.text[:100]}")
    except Exception as e:
        print(f"   Ошибка: {e}")

# 2. Попробуем эндпоинт /Coordinates/coordinates/{id}
print("\n" + "=" * 70)
print("TEST 2: Эндпоинт /Coordinates/coordinates/{id}")
print("=" * 70)

for cid in [1, 100, 3614]:  # 3614 - это ID остановки
    url = f"{BASE_URL}/Coordinates/coordinates/{cid}"
    try:
        response = requests.get(url, headers=HEADERS, timeout=5)
        print(f"\nCoordinates ID {cid}: Status {response.status_code}")
        if response.status_code == 200:
            data = response.json()
            print(f"✅ Данные получены!")
            print(json.dumps(data, ensure_ascii=False, indent=2)[:500])
        else:
            print(f"   Ответ: {response.text[:100]}")
    except Exception as e:
        print(f"   Ошибка: {e}")

# 3. Попробуем получить itineraries напрямую
print("\n" + "=" * 70)
print("TEST 3: Координаты всех автобусов на маршруте")
print("=" * 70)

# Используем itineraryId из предыдущего теста
for itin_id in [3581, 1, 100]:
    url = f"{BASE_URL}/Coordinates/VehiclesCoordinates/{itin_id}"
    try:
        response = requests.get(url, headers=HEADERS, timeout=5)
        print(f"\nItinerary {itin_id}: Status {response.status_code}")
        if response.status_code == 200:
            data = response.json()
            print(f"✅ Данные получены! Тип: {type(data).__name__}")
            if isinstance(data, list):
                print(f"   Найдено автобусов: {len(data)}")
                if len(data) > 0:
                    print(f"   Первый автобус:")
                    print(json.dumps(data[0], ensure_ascii=False, indent=2)[:500])
            else:
                print(json.dumps(data, ensure_ascii=False, indent=2)[:500])
        else:
            print(f"   Ответ: {response.text[:100]}")
    except Exception as e:
        print(f"   Ошибка: {e}")

# 4. Попробуем разные временные окна для arrival estimates
print("\n" + "=" * 70)
print("TEST 4: Разные временные окна для arrival estimates")
print("=" * 70)

stop_id = 3614
for minutes in [10, 30, 60, 120]:
    url = f"{BASE_URL}/StopsFis/{stop_id}/{minutes}/arrivalEstimates"
    try:
        response = requests.get(url, headers=HEADERS, timeout=5)
        print(f"\nOkno {minutes} минут: Status {response.status_code}")
        if response.status_code == 200:
            estimates = response.json()
            print(f"   Найдено прогнозов: {len(estimates)}")
            
            # Проверяем vehicleId
            vehicles = [e for e in estimates if e.get('vehicleId', 0) != 0]
            if vehicles:
                print(f"   ✅ Автобусы с vehicleId: {len(vehicles)}")
                for v in vehicles[:3]:
                    print(f"      - vehicleId={v.get('vehicleId')}, line={v.get('lineDesc')}, minutes={v.get('minutes')}")
            else:
                print(f"   ⚪ Все vehicleId = 0")
                if len(estimates) > 0:
                    print(f"   Пример: {json.dumps(estimates[0], ensure_ascii=False)[:200]}")
    except Exception as e:
        print(f"   Ошибка: {e}")

# 5. Попробуем другие остановки
print("\n" + "=" * 70)
print("TEST 5: Проверяем другие остановки")
print("=" * 70)

# Получаем остановки
url = f"{BASE_URL}/StopsFis/{-5.8447876}/{43.3622222}/2000"
stops = requests.get(url, headers=HEADERS, timeout=10).json()

print(f"Проверяем первые 10 остановок из {len(stops)}...\n")

for i, stop in enumerate(stops[:10], 1):
    stop_id = stop['id']
    stop_name = stop['name'][:50]
    
    url = f"{BASE_URL}/StopsFis/{stop_id}/60/arrivalEstimates"
    try:
        estimates = requests.get(url, headers=HEADERS, timeout=3).json()
        vehicles = [e for e in estimates if e.get('vehicleId', 0) != 0]
        
        if vehicles:
            print(f"✅ [{i}] Остановка {stop_id}: {stop_name}")
            print(f"    Найдено {len(vehicles)} автобус(ов) с vehicleId!")
            for v in vehicles[:2]:
                print(f"    - vehicleId={v.get('vehicleId')}, line={v.get('lineDesc')}")
        else:
            print(f"⚪ [{i}] Остановка {stop_id}: нет автобусов")
    except Exception as e:
        print(f"❌ [{i}] Остановка {stop_id}: ошибка")

