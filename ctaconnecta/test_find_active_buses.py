#!/usr/bin/env python3
"""
Поиск активных автобусов с vehicleId в более широком радиусе
"""
import requests
import json

BASE_URL = "https://www.consorcioasturias.org/appcta/api"
HEADERS = {"User-Agent": "Mozilla/5.0"}

# Центр Овьедо
OVIEDO_LAT = 43.3622222
OVIEDO_LON = -5.8447876

print("🔍 Ищем активные автобусы в радиусе 5км от Овьедо...\n")

# Получаем остановки в большом радиусе
url = f"{BASE_URL}/StopsFis/{OVIEDO_LON}/{OVIEDO_LAT}/5000"
stops = requests.get(url, headers=HEADERS).json()

print(f"Найдено {len(stops)} остановок\n")

active_buses = []

for i, stop in enumerate(stops[:30], 1):  # Проверяем первые 30
    stop_id = stop['id']
    stop_name = stop['name']
    
    print(f"[{i}/30] Проверяю остановку {stop_id}...", end=" ")
    
    try:
        url = f"{BASE_URL}/StopsFis/{stop_id}/60/arrivalEstimates"
        estimates = requests.get(url, headers=HEADERS, timeout=5).json()
        
        buses_here = 0
        for est in estimates:
            vehicle_id = est.get('vehicleId', 0)
            if vehicle_id and vehicle_id != 0:
                active_buses.append({
                    'vehicleId': vehicle_id,
                    'stopId': stop_id,
                    'stopName': stop_name,
                    'line': est.get('lineDesc', ''),
                    'minutes': est.get('minutes'),
                    'itineraryId': est.get('itineraryId', 0)
                })
                buses_here += 1
        
        if buses_here > 0:
            print(f"✅ {buses_here} автобус(ов)")
        else:
            print("⚪")
    except:
        print("❌")

print(f"\n{'='*70}")
print(f"📊 Найдено активных автобусов: {len(active_buses)}")
print(f"{'='*70}\n")

if active_buses:
    for bus in active_buses[:5]:  # Первые 5
        print(f"VehicleId: {bus['vehicleId']}")
        print(f"  Линия: {bus['line']}")
        print(f"  Прибытие: {bus['minutes']} мин")
        print(f"  Остановка: {bus['stopName'][:60]}")
        print(f"  ItineraryId: {bus['itineraryId']}")
        print()
else:
    print("⚠️  Активных автобусов не найдено")
    print("Попробуйте запустить в рабочее время (7:00-22:00)")

