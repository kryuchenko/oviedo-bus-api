#!/usr/bin/env python3
"""
Детальная проверка TUA API - может проблема везде?
"""
import requests
import json

print("🚌 Проверка TUA API (городские автобусы Овьедо)")
print("=" * 70)

# 1. Попробуем разные остановки
print("\nTEST 1: Разные остановки TUA")
print("-" * 70)

for stop_id in [1, 2, 3, 10, 100, 200]:
    url = f"https://www.tua.es/rest/estimaciones/{stop_id}"
    try:
        response = requests.get(url, timeout=5)
        if response.status_code == 200:
            data = response.json()
            estimations = data.get('estimaciones', {}).get('value', [])
            print(f"Остановка {stop_id:3d}: {len(estimations):2d} прогнозов", end="")
            if len(estimations) > 0:
                print(f" ✅ ЕСТЬ АВТОБУСЫ!")
                print(f"              {json.dumps(estimations[0], ensure_ascii=False)[:100]}")
            else:
                print()
    except Exception as e:
        print(f"Остановка {stop_id:3d}: ошибка")

# 2. Попробуем получить список всех остановок
print("\nTEST 2: Список остановок TUA")
print("-" * 70)

url = "https://www.tua.es/rest/paradas"
try:
    response = requests.get(url, timeout=10)
    if response.status_code == 200:
        stops = response.json()
        print(f"✅ Получено {len(stops)} остановок")
        
        # Проверим первые 10 остановок на наличие автобусов
        print("\nПроверяем первые 10 остановок...")
        for stop in stops[:10]:
            stop_id = stop.get('id')
            stop_name = stop.get('nombre', '')[:40]
            
            est_url = f"https://www.tua.es/rest/estimaciones/{stop_id}"
            try:
                est_response = requests.get(est_url, timeout=3)
                estimations = est_response.json().get('estimaciones', {}).get('value', [])
                
                if len(estimations) > 0:
                    print(f"  ✅ Остановка {stop_id} ({stop_name}): {len(estimations)} автобусов")
                else:
                    print(f"  ⚪ Остановка {stop_id} ({stop_name}): нет автобусов")
            except:
                print(f"  ❌ Остановка {stop_id}: ошибка")
    else:
        print(f"❌ Status {response.status_code}")
except Exception as e:
    print(f"❌ Ошибка: {e}")

# 3. Проверим линии
print("\nTEST 3: Линии TUA")
print("-" * 70)

url = "https://www.tua.es/rest/lineas"
try:
    response = requests.get(url, timeout=10)
    if response.status_code == 200:
        lines = response.json()
        print(f"✅ Получено {len(lines)} линий")
        for line in lines[:5]:
            print(f"  - Линия {line.get('linea', '')}: {line.get('destino', '')[:50]}")
    else:
        print(f"❌ Status {response.status_code}")
except Exception as e:
    print(f"❌ Ошибка: {e}")

