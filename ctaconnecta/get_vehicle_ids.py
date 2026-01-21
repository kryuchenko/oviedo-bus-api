#!/usr/bin/env python3
"""
Скрипт для получения ID автобусов (vehicleId) через CTA API
"""
import requests
import json
from datetime import datetime

BASE_URL = "https://www.consorcioasturias.org/appcta/api"

def get_stops_in_radius(lat, lon, radius_meters):
    """Получить остановки в радиусе"""
    url = f"{BASE_URL}/StopsFis/{lon}/{lat}/{radius_meters}"
    print(f"🔍 Поиск остановок в радиусе {radius_meters}м от ({lat}, {lon})...")
    
    response = requests.get(url, headers={"User-Agent": "Mozilla/5.0"})
    stops = response.json()
    print(f"   Найдено {len(stops)} остановок\n")
    return stops

def get_arrival_estimates(stop_id, minutes=60):
    """Получить прогноз прибытия для остановки"""
    url = f"{BASE_URL}/StopsFis/{stop_id}/{minutes}/arrivalEstimates"
    
    response = requests.get(url, headers={"User-Agent": "Mozilla/5.0"})
    estimates = response.json()
    return estimates

def get_vehicle_coordinates(vehicle_id):
    """Получить GPS-координаты автобуса"""
    url = f"{BASE_URL}/Coordinates/VehicleCoordinates/{vehicle_id}"
    
    try:
        response = requests.get(url, headers={"User-Agent": "Mozilla/5.0"}, timeout=5)
        if response.status_code == 200:
            return response.json()
    except:
        pass
    return None

def main():
    print("=" * 70)
    print("🚌 Поиск активных автобусов CTA")
    print("=" * 70)
    print()
    
    # Координаты центра Овьедо
    OVIEDO_LAT = 43.3622222
    OVIEDO_LON = -5.8447876
    RADIUS = 2000  # 2 км
    
    # 1. Получаем остановки
    stops = get_stops_in_radius(OVIEDO_LAT, OVIEDO_LON, RADIUS)
    
    # 2. Собираем все vehicleId из прогнозов прибытия
    all_vehicles = {}
    
    print("📍 Проверяем остановки на наличие автобусов...")
    for i, stop in enumerate(stops[:20], 1):  # Проверяем первые 20 остановок
        stop_id = stop['id']
        stop_name = stop['name']
        
        print(f"   [{i}/20] Остановка {stop_id}: {stop_name[:50]}...", end=" ")
        
        try:
            estimates = get_arrival_estimates(stop_id, minutes=60)
            
            vehicles_here = 0
            for est in estimates:
                vehicle_id = est.get('vehicleId', 0)
                if vehicle_id and vehicle_id != 0:
                    if vehicle_id not in all_vehicles:
                        all_vehicles[vehicle_id] = {
                            'line': est.get('lineDesc', ''),
                            'direction': est.get('directionDesc', ''),
                            'minutes': est.get('minutes', 0),
                            'stop_name': stop_name,
                            'itinerary_id': est.get('itineraryId', 0)
                        }
                        vehicles_here += 1
            
            if vehicles_here > 0:
                print(f"✅ {vehicles_here} автобус(ов)")
            else:
                print("⚪")
        except Exception as e:
            print(f"❌ Ошибка: {e}")
    
    print()
    print("=" * 70)
    print(f"📊 Найдено уникальных автобусов: {len(all_vehicles)}")
    print("=" * 70)
    print()
    
    if not all_vehicles:
        print("⚠️  Сейчас нет активных автобусов.")
        print("   Попробуйте запустить в рабочее время (утро/день в будни).")
        return
    
    # 3. Выводим список автобусов
    print("🚍 Список активных автобусов:\n")
    
    for vehicle_id, info in sorted(all_vehicles.items()):
        print(f"Vehicle ID: {vehicle_id}")
        print(f"  Линия:       {info['line']}")
        print(f"  Направление: {info['direction'][:60]}")
        print(f"  Прибытие:    через {info['minutes']} мин")
        print(f"  Остановка:   {info['stop_name'][:60]}")
        print(f"  Itinerary:   {info['itinerary_id']}")
        
        # Пробуем получить GPS-координаты
        coords = get_vehicle_coordinates(vehicle_id)
        if coords:
            lat = coords.get('latitude', 0)
            lon = coords.get('longitude', 0)
            speed = coords.get('speed', 0)
            speed_kmh = speed * 3.6
            print(f"  📍 GPS:      {lat:.6f}, {lon:.6f}")
            print(f"  🚀 Скорость: {speed:.2f} м/с ({speed_kmh:.1f} км/ч)")
        else:
            print(f"  ⚠️  GPS данных нет")
        
        print()
    
    print("=" * 70)
    print(f"⏰ Время запроса: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}")
    print("=" * 70)
    
    # 4. Сохраняем в файл
    output = {
        'timestamp': datetime.now().isoformat(),
        'total_vehicles': len(all_vehicles),
        'vehicles': all_vehicles
    }
    
    with open('vehicle_ids.json', 'w', encoding='utf-8') as f:
        json.dump(output, f, ensure_ascii=False, indent=2)
    
    print("\n💾 Результаты сохранены в: vehicle_ids.json")

if __name__ == "__main__":
    main()
