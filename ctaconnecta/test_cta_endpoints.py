#!/usr/bin/env python3
"""
Комплексное тестирование всех эндпоинтов CTA API
Проверяет что API возвращает реальные данные, а не пустоту
"""
import requests
import json
from datetime import datetime
from typing import Optional, Dict, Any

BASE_URL = "https://www.consorcioasturias.org/appcta/api"
HEADERS = {"User-Agent": "Mozilla/5.0"}

# Координаты центра Овьедо
OVIEDO_LAT = 43.3622222
OVIEDO_LON = -5.8447876

class Colors:
    GREEN = '\033[92m'
    RED = '\033[91m'
    YELLOW = '\033[93m'
    BLUE = '\033[94m'
    BOLD = '\033[1m'
    END = '\033[0m'

def print_header(text: str):
    print(f"\n{Colors.BOLD}{Colors.BLUE}{'=' * 70}{Colors.END}")
    print(f"{Colors.BOLD}{Colors.BLUE}{text}{Colors.END}")
    print(f"{Colors.BOLD}{Colors.BLUE}{'=' * 70}{Colors.END}\n")

def print_success(text: str):
    print(f"{Colors.GREEN}✅ {text}{Colors.END}")

def print_error(text: str):
    print(f"{Colors.RED}❌ {text}{Colors.END}")

def print_warning(text: str):
    print(f"{Colors.YELLOW}⚠️  {text}{Colors.END}")

def print_info(text: str):
    print(f"{Colors.BLUE}ℹ️  {text}{Colors.END}")

def test_endpoint(name: str, url: str, expected_type: type = list) -> Optional[Any]:
    """Тестирует эндпоинт и возвращает данные"""
    print(f"\n🔍 Тестирую: {name}")
    print(f"   URL: {url}")

    try:
        response = requests.get(url, headers=HEADERS, timeout=10)
        print(f"   Status: {response.status_code}")

        if response.status_code != 200:
            print_error(f"Ошибка HTTP: {response.status_code}")
            return None

        data = response.json()

        # Проверка типа данных
        if not isinstance(data, expected_type):
            print_error(f"Неожиданный тип данных: {type(data).__name__} (ожидалось: {expected_type.__name__})")
            return None

        # Проверка на пустоту
        if expected_type == list and len(data) == 0:
            print_warning("Массив пустой (нет данных)")
            return None

        # Вывод статистики
        if expected_type == list:
            print_success(f"Получено {len(data)} элемент(ов)")
            if len(data) > 0:
                print(f"   Первый элемент: {json.dumps(data[0], ensure_ascii=False, indent=2)[:200]}...")
        elif expected_type == dict:
            print_success(f"Получен объект с {len(data)} полями")
            print(f"   Ключи: {list(data.keys())}")
        elif expected_type == int:
            print_success(f"Получено значение: {data}")

        return data

    except requests.exceptions.Timeout:
        print_error("Timeout (сервер не ответил за 10 секунд)")
    except requests.exceptions.RequestException as e:
        print_error(f"Ошибка запроса: {e}")
    except json.JSONDecodeError:
        print_error("Ошибка парсинга JSON")
    except Exception as e:
        print_error(f"Неизвестная ошибка: {e}")

    return None

def main():
    print_header("🚌 Тестирование CTA API")
    print(f"Время запуска: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}")
    print(f"Базовый URL: {BASE_URL}")

    results = {
        "timestamp": datetime.now().isoformat(),
        "tests": {},
        "summary": {}
    }

    # ============ TEST 1: Stops in Radius ============
    print_header("📍 TEST 1: Остановки в радиусе")

    url = f"{BASE_URL}/StopsFis/{OVIEDO_LON}/{OVIEDO_LAT}/1000"
    stops = test_endpoint("StopsFis (остановки в 1км)", url, list)

    if stops and len(stops) > 0:
        results["tests"]["stops_in_radius"] = "✅ PASS"
        print_info(f"Найдено остановок: {len(stops)}")
        print(f"\nПример остановки:")
        print(json.dumps(stops[0], ensure_ascii=False, indent=2))

        # Сохраним первую остановку для следующих тестов
        test_stop_id = stops[0]['id']
        test_stop_name = stops[0]['name']
        print_success(f"Используем остановку: {test_stop_id} - {test_stop_name[:50]}")
    else:
        results["tests"]["stops_in_radius"] = "❌ FAIL"
        print_error("Не удалось получить остановки. Дальнейшие тесты невозможны.")
        return results

    # ============ TEST 2: Gap Time Refresh ============
    print_header("⏱️  TEST 2: Интервал обновления")

    url = f"{BASE_URL}/Coordinates/GapTimeRefresh"
    gap_time = test_endpoint("GapTimeRefresh", url, int)

    if gap_time:
        results["tests"]["gap_time_refresh"] = "✅ PASS"
        print_success(f"Интервал обновления GPS: {gap_time} секунд")
    else:
        results["tests"]["gap_time_refresh"] = "❌ FAIL"

    # ============ TEST 3: Stop Itineraries ============
    print_header("🚌 TEST 3: Маршруты на остановке")

    url = f"{BASE_URL}/StopsFis/{test_stop_id}/itineraries"
    itineraries = test_endpoint(f"Itineraries для остановки {test_stop_id}", url, list)

    if itineraries and len(itineraries) > 0:
        results["tests"]["stop_itineraries"] = "✅ PASS"
        print_info(f"Найдено маршрутов: {len(itineraries)}")
        print("\nМаршруты на остановке:")
        for itin in itineraries[:5]:  # Первые 5
            line = itin.get('lineDesc', 'N/A')
            direction = itin.get('directionDesc', 'N/A')
            print(f"  - Линия {line}: {direction[:60]}")
    else:
        results["tests"]["stop_itineraries"] = "⚠️  WARN (нет маршрутов)"

    # ============ TEST 4: Arrival Estimates (КЛЮЧЕВОЙ ТЕСТ) ============
    print_header("🔑 TEST 4: Прогнозы прибытия (Arrival Estimates)")

    url = f"{BASE_URL}/StopsFis/{test_stop_id}/60/arrivalEstimates"
    estimates = test_endpoint(f"Arrival Estimates для остановки {test_stop_id}", url, list)

    vehicle_id = None
    itinerary_id = None

    if estimates and len(estimates) > 0:
        results["tests"]["arrival_estimates"] = "✅ PASS"
        print_info(f"Найдено прогнозов: {len(estimates)}")

        print("\n📊 Прогнозы прибытия:")
        for est in estimates[:10]:  # Первые 10
            line = est.get('lineDesc', 'N/A')
            direction = est.get('directionDesc', 'N/A')[:40]
            minutes = est.get('minutes')
            vid = est.get('vehicleId', 0)
            itin_id = est.get('itineraryId', 0)

            print(f"  - Линия {line}: {direction}")
            print(f"    Прибытие: {minutes} мин | vehicleId: {vid} | itineraryId: {itin_id}")

            # Ищем автобус с vehicleId != 0
            if vid and vid != 0 and not vehicle_id:
                vehicle_id = vid
                itinerary_id = itin_id
                print_success(f"    ✓ Найден активный автобус с vehicleId!")

        if vehicle_id:
            print_success(f"\nИспользуем для GPS-тестов: vehicleId={vehicle_id}, itineraryId={itinerary_id}")
        else:
            print_warning("Не найдено автобусов с vehicleId (все = 0)")
    else:
        results["tests"]["arrival_estimates"] = "❌ FAIL"
        print_error("Не удалось получить прогнозы прибытия")

    # ============ TEST 5: Vehicle GPS Coordinates ============
    if vehicle_id:
        print_header("📍 TEST 5: GPS-координаты автобуса")

        url = f"{BASE_URL}/Coordinates/VehicleCoordinates/{vehicle_id}"
        coords = test_endpoint(f"GPS для vehicleId={vehicle_id}", url, dict)

        if coords:
            results["tests"]["vehicle_coordinates"] = "✅ PASS"

            lat = coords.get('latitude', 0)
            lon = coords.get('longitude', 0)
            speed = coords.get('speed', 0)
            bearing = coords.get('bearing', 0)
            heading = coords.get('headingDegrees', 0)

            print_success("GPS-координаты получены!")
            print(f"\n📍 Данные автобуса vehicleId={vehicle_id}:")
            print(f"   Координаты: {lat:.6f}, {lon:.6f}")
            print(f"   Скорость: {speed:.2f} м/с ({speed * 3.6:.1f} км/ч)")
            print(f"   Направление (bearing): {bearing:.1f}°")
            print(f"   Курс (heading): {heading:.1f}°")

            if 'speedAccuracyMetersPerSecond' in coords:
                print(f"   Точность скорости: ±{coords['speedAccuracyMetersPerSecond']} м/с")
            if 'bearingAccuracyDegrees' in coords:
                print(f"   Точность направления: ±{coords['bearingAccuracyDegrees']}°")

            print("\nПолный ответ:")
            print(json.dumps(coords, ensure_ascii=False, indent=2))
        else:
            results["tests"]["vehicle_coordinates"] = "❌ FAIL"
    else:
        print_header("📍 TEST 5: GPS-координаты автобуса")
        print_warning("Пропущен (нет vehicleId)")
        results["tests"]["vehicle_coordinates"] = "⚠️  SKIP (нет vehicleId)"

    # ============ TEST 6: All Vehicles on Itinerary ============
    if itinerary_id:
        print_header("🗺️  TEST 6: Все автобусы на маршруте")

        url = f"{BASE_URL}/Coordinates/VehiclesCoordinates/{itinerary_id}"
        vehicles_coords = test_endpoint(f"GPS для itineraryId={itinerary_id}", url, list)

        if vehicles_coords and len(vehicles_coords) > 0:
            results["tests"]["vehicles_coordinates"] = "✅ PASS"
            print_success(f"Найдено {len(vehicles_coords)} автобус(ов) на маршруте")

            print("\n🚍 Автобусы на маршруте:")
            for vc in vehicles_coords:
                vid = vc.get('vehicleId', 'N/A')
                lat = vc.get('latitude', 0)
                lon = vc.get('longitude', 0)
                speed = vc.get('speed', 0)
                speed_kmh = speed * 3.6

                print(f"  - VehicleId {vid}:")
                print(f"    Позиция: {lat:.6f}, {lon:.6f}")
                print(f"    Скорость: {speed:.2f} м/с ({speed_kmh:.1f} км/ч)")
        else:
            results["tests"]["vehicles_coordinates"] = "⚠️  WARN (нет автобусов)"
    else:
        print_header("🗺️  TEST 6: Все автобусы на маршруте")
        print_warning("Пропущен (нет itineraryId)")
        results["tests"]["vehicles_coordinates"] = "⚠️  SKIP (нет itineraryId)"

    # ============ TEST 7: Stop by Code ============
    print_header("🔍 TEST 7: Остановка по коду")

    # Извлекаем код из названия остановки
    # Например: "[OVIEDO/UVIÉU] Adelantado de La Florida [CTA 03614]"
    import re
    code_match = re.search(r'CTA\s+(\d+)', test_stop_name)
    if code_match:
        stop_code = f"CTA{code_match.group(1)}"
        url = f"{BASE_URL}/Stops/stops/{stop_code}"
        stop_data = test_endpoint(f"Stop by code {stop_code}", url, dict)

        if stop_data:
            results["tests"]["stop_by_code"] = "✅ PASS"
        else:
            results["tests"]["stop_by_code"] = "❌ FAIL"
    else:
        print_warning("Не удалось извлечь код остановки из названия")
        results["tests"]["stop_by_code"] = "⚠️  SKIP"

    # ============ SUMMARY ============
    print_header("📊 ИТОГИ ТЕСТИРОВАНИЯ")

    passed = sum(1 for v in results["tests"].values() if "✅" in v)
    failed = sum(1 for v in results["tests"].values() if "❌" in v)
    warnings = sum(1 for v in results["tests"].values() if "⚠️" in v)
    total = len(results["tests"])

    results["summary"] = {
        "total": total,
        "passed": passed,
        "failed": failed,
        "warnings": warnings,
        "success_rate": f"{(passed / total * 100):.1f}%"
    }

    print(f"\nВсего тестов: {total}")
    print_success(f"Успешно: {passed}")
    print_error(f"Провалено: {failed}")
    print_warning(f"Предупреждения: {warnings}")
    print(f"\nУспешность: {results['summary']['success_rate']}")

    print("\n📋 Детальные результаты:")
    for test_name, result in results["tests"].items():
        print(f"  {result} {test_name}")

    # Сохраняем результаты
    output_file = "cta_api_test_results.json"
    with open(output_file, 'w', encoding='utf-8') as f:
        json.dump(results, f, ensure_ascii=False, indent=2)

    print(f"\n💾 Результаты сохранены в: {output_file}")

    # Финальная оценка
    print_header("🎯 ФИНАЛЬНАЯ ОЦЕНКА")

    if failed == 0 and passed >= 5:
        print_success("ОТЛИЧНО! Все критичные эндпоинты работают!")
        print_info("API готов к использованию")
    elif failed <= 2:
        print_warning("ХОРОШО. Большинство эндпоинтов работают")
        print_info("Некоторые функции могут быть недоступны")
    else:
        print_error("ПРОБЛЕМЫ. Много эндпоинтов не работают")
        print_warning("Требуется дополнительная проверка API")

    return results

if __name__ == "__main__":
    main()
