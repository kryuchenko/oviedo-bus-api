#!/usr/bin/env python3
"""
Тест CTA API для поиска активных автобусов
"""
import requests
import json

BASE_URL = "https://www.consorcioasturias.org/appcta/api"

# Координаты центра Овьедо
OVIEDO_LAT = 43.3622222
OVIEDO_LON = -5.8447876
RADIUS = 5000  # 5 км

print("🚍 Поиск активных автобусов CTA (метропольные линии)")
print("=" * 60)

# Получаем остановки вокруг Овьедо
print(f"\n1. Получаем остановки в радиусе {RADIUS}м от центра Овьедо...")
url = f"{BASE_URL}/StopsFis/{OVIEDO_LON}/{OVIEDO_LAT}/{RADIUS}"
response = requests.get(url, headers={"User-Agent": "Mozilla/5.0"})
stops = response.json()
print(f"   Найдено {len(stops)} остановок")

# Проверяем первые 10 остановок на наличие активных автобусов
print("\n2. Проверяем остановки на наличие прибывающих автобусов...")
active_buses = []

for stop in stops[:10]:  # Проверяем только первые 10 для скорости
    stop_id = stop['id']
    stop_name = stop['name']
    
    # Получаем прогноз прибытия
    url = f"{BASE_URL}/StopsFis/{stop_id}/60/arrivalEstimates"
    try:
        response = requests.get(url, headers={"User-Agent": "Mozilla/5.0"}, timeout=5)
        estimates = response.json()
        
        for est in estimates:
            if est.get('vehicleId') and est['vehicleId'] != 0:
                active_buses.append({
                    'stop_id': stop_id,
                    'stop_name': stop_name,
                    'line': est.get('lineDesc', ''),
                    'direction': est.get('directionDesc', ''),
                    'itinerary_id': est.get('itineraryId', 0),
                    'vehicle_id': est['vehicleId'],
                    'minutes': est.get('minutes', 0)
                })
    except:
        pass

print(f"\n3. Найдено активных автобусов: {len(active_buses)}")

if active_buses:
    print("\n📍 Активные автобусы:")
    for bus in active_buses[:20]:
        print(f"   Линия {bus['line']}: vehicleId={bus['vehicle_id']}, "
              f"прибытие через {bus['minutes']} мин, itinerary={bus['itinerary_id']}")
    
    # Пробуем получить координаты первого автобуса
    if active_buses:
        first_bus = active_buses[0]
        print(f"\n4. Пробуем получить координаты автобуса...")
        print(f"   Vehicle ID: {first_bus['vehicle_id']}")
        print(f"   Itinerary ID: {first_bus['itinerary_id']}")
        
        # Пробуем разные endpoint'ы
        for endpoint in [
            f"Coordinates/coordinates/{first_bus['vehicle_id']}",
            f"Coordinates/VehicleCoordinates/{first_bus['vehicle_id']}",
            f"Coordinates/VehiclesCoordinates/{first_bus['itinerary_id']}"
        ]:
            url = f"{BASE_URL}/{endpoint}"
            print(f"\n   Пробую: {endpoint}")
            try:
                response = requests.get(url, headers={"User-Agent": "Mozilla/5.0"}, timeout=5)
                data = response.json()
                print(f"   Ответ: {json.dumps(data, indent=2, ensure_ascii=False)[:200]}")
            except Exception as e:
                print(f"   Ошибка: {e}")
else:
    print("\n⚠️  Сейчас нет активных автобусов (возможно, поздно вечером)")
    print("   Этот API работает для метропольных маршрутов, которые ездят реже городских.")

