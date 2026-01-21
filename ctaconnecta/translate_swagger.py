#!/usr/bin/env python3
"""
Complete translation of CTA OpenAPI specification from Russian to English
"""

# Translation dictionary (Russian -> English)
translations = {
    # Tags
    "Операции с остановками": "Stop operations",
    "Маршруты и направления": "Routes and directions",
    "GPS-координаты автобусов": "Bus GPS coordinates",
    "Транспортные карты": "Transport cards",
    "Пополнение карт": "Card recharging",
    "Тарифы": "Fares",
    "Аутентификация": "Authentication",

    # Endpoints summaries
    "Получить остановки в радиусе": "Get stops within radius",
    "Возвращает список остановок в указанном радиусе от координаты": "Returns a list of stops within the specified radius from a coordinate",
    "Долгота (WGS84)": "Longitude (WGS84)",
    "Широта (WGS84)": "Latitude (WGS84)",
    "Радиус поиска в метрах": "Search radius in meters",
    "Список остановок": "List of stops",

    "Получить маршруты для остановки": "Get routes for stop",
    "Возвращает список всех маршрутов, проходящих через эту остановку": "Returns a list of all routes passing through this stop",
    "ID остановки": "Stop ID",
    "Список маршрутов": "List of routes",

    "Прогноз прибытия автобусов": "Bus arrival estimates",
    "Возвращает прогноз прибытия автобусов на остановку в ближайшие N минут.": "Returns bus arrival estimates for the stop in the next N minutes.",
    "Данные": "Data",
    "Для каждого автобуса возвращается:": "For each bus returns:",
    "ID автобуса для получения GPS-координат": "Bus ID for getting GPS coordinates",
    "время до прибытия в минутах (может быть null)": "Time until arrival in minutes (can be null)",
    "номер маршрута (например, \"H\")": "Route number (e.g., \"H\")",
    "направление движения": "Direction of travel",
    "ID маршрута для получения всех автобусов на линии": "Route ID for getting all buses on the line",

    "Динамический Polling": "Dynamic Polling",
    "Рекомендуется использовать адаптивный интервал в зависимости от времени до прибытия:": "Recommended to use adaptive interval depending on time until arrival:",
    "Автобус далеко": "Bus far",
    "обновлять каждые": "update every",
    "секунд": "seconds",
    "Автобус близко": "Bus nearby",
    "Автобус очень близко": "Bus very close",
    "Пример реализации:": "Implementation example:",

    "Получение VehicleId": "Getting VehicleId",
    "Это единственный эндпоинт, который возвращает": "This is the only endpoint that returns",
    "Используйте полученный vehicleId для запроса GPS-координат:": "Use the obtained vehicleId to request GPS coordinates:",
    "Получаем vehicleId:": "Get vehicleId:",
    "Получаем GPS-координаты автобуса": "Get bus GPS coordinates",
    "Важно": "Important",
    "Если vehicleId = 0, то GPS-данные для этого автобуса недоступны.": "If vehicleId = 0, then GPS data for this bus is unavailable.",

    "Использование в приложении": "App Usage",
    "Официальное приложение использует этот эндпоинт для:": "The official app uses this endpoint for:",
    "Отображения списка прибывающих автобусов на остановке": "Displaying list of arriving buses at the stop",
    "Получения vehicleId для отслеживания на карте": "Getting vehicleId for tracking on map",
    "Динамического обновления времени прибытия": "Dynamic update of arrival times",

    "Временное окно прогноза в минутах (рекомендуется 30-60)": "Forecast time window in minutes (recommended 30-60)",
    "Список прогнозов прибытия": "List of arrival estimates",

    "Получить остановку по коду": "Get stop by code",
    "Возвращает информацию об остановке по её коду/названию": "Returns information about a stop by its code/name",
    "Код или название остановки": "Stop code or name",
    "Информация об остановке": "Stop information",

    # Itineraries
    "Получить остановки маршрута": "Get route stops",
    "Возвращает список всех остановок на маршруте": "Returns a list of all stops on the route",
    "ID маршрута (itinerary)": "Route ID (itinerary)",
    "Список остановок маршрута": "List of route stops",

    "Получить остановки для конкретного автобуса": "Get stops for specific bus",
    "Возвращает остановки маршрута для конкретного автобуса": "Returns route stops for a specific bus",
    "ID маршрута": "Route ID",
    "ID автобуса": "Bus ID",
    "Список остановок для автобуса": "List of stops for the bus",

    "Получить расписание": "Get timetable",
    "Возвращает расписание для маршрута на указанную дату": "Returns the timetable for a route on the specified date",
    "Дата в формате YYYY-MM-DD": "Date in YYYY-MM-DD format",
    "Расписание": "Timetable",

    # Coordinates
    "Интервал обновления координат": "Coordinate update interval",
    "Возвращает рекомендуемый интервал обновления GPS-координат в секундах.": "Returns the recommended GPS coordinate update interval in seconds.",
    "Возвращаемое значение": "Returned value",
    "(секунд)": "(seconds)",
    "Используйте это значение как минимальный интервал между запросами к эндпоинтам:": "Use this value as the minimum interval between requests to endpoints:",
    "Не запрашивайте GPS-координаты чаще, чем указано в этом эндпоинте!": "Don't request GPS coordinates more frequently than specified in this endpoint!",
    "Интервал в секундах": "Interval in seconds",
    "Минимальный интервал между запросами GPS-координат в секундах": "Minimum interval between GPS coordinate requests in seconds",

    "Получить координаты объекта": "Get object coordinates",
    "Возвращает GPS-координаты для указанного ID": "Returns GPS coordinates for the specified ID",
    "ID объекта": "Object ID",
    "GPS-координаты": "GPS coordinates",

    "Получить координаты автобуса": "Get bus coordinates",
    "Возвращает текущие GPS-координаты конкретного автобуса в реальном времени.": "Returns current GPS coordinates of a specific bus in real-time.",
    "Эндпоинт возвращает:": "Endpoint returns:",
    "GPS-координаты (latitude, longitude) в формате WGS84": "GPS coordinates (latitude, longitude) in WGS84 format",
    "Скорость движения в м/с": "Speed of movement in m/s",
    "Направление движения (bearing) и курс (heading) в градусах": "Direction of movement (bearing) and heading in degrees",
    "Метрики точности для всех параметров": "Accuracy metrics for all parameters",

    "Интервал обновления": "Update interval",
    "(см. `/Coordinates/GapTimeRefresh`)": "(see `/Coordinates/GapTimeRefresh`)",
    "Рекомендация": "Recommendation",
    "НЕ запрашивать чаще 60 секунд": "DO NOT request more frequently than 60 seconds",
    "Rate limit": "Rate limit",
    "Не более 1 запроса в минуту на один vehicleId": "No more than 1 request per minute per vehicleId",

    "Как получить vehicleId?": "How to get vehicleId?",
    "VehicleId можно получить из эндпоинта": "VehicleId can be obtained from the endpoint",
    "в поле": "in the",
    "объекта прогноза прибытия.": "field of the arrival estimate object.",
    "Не все автобусы передают GPS-координаты. Если vehicleId = 0": "Not all buses transmit GPS coordinates. If vehicleId = 0",
    "в прогнозе прибытия, значит для этого автобуса GPS-данные недоступны.": "in the arrival estimate, it means GPS data is unavailable for this bus.",

    "Официальное приложение CTA Usuario использует этот эндпоинт для:": "The official CTA Usuario app uses this endpoint for:",
    "Отображения автобуса на карте в реальном времени": "Displaying bus on map in real-time",
    "Анимации движения маркера с поворотом (используя bearing)": "Animating marker movement with rotation (using bearing)",
    "Расчёта времени прибытия на основе скорости": "Calculating arrival time based on speed",

    "ID автобуса (vehicleId из arrival estimates)": "Bus ID (vehicleId from arrival estimates)",
    "GPS-координаты автобуса": "Bus GPS coordinates",
    "Автобус в движении": "Bus in motion",
    "Автобус на остановке": "Bus at stop",
    "Автобус не найден или не передаёт координаты": "Bus not found or not transmitting coordinates",

    "Получить координаты всех автобусов на маршруте": "Get coordinates of all buses on route",
    "Возвращает GPS-координаты всех активных автобусов на указанном маршруте.": "Returns GPS coordinates of all active buses on the specified route.",
    "Возвращает массив объектов VehicleCoordinates для всех автобусов,": "Returns an array of VehicleCoordinates objects for all buses",
    "которые сейчас выполняют рейс по данному маршруту (itinerary).": "currently operating on this route (itinerary).",

    "Использование": "Usage",
    "Этот эндпоинт удобен для отображения всех автобусов маршрута на карте.": "This endpoint is convenient for displaying all route buses on a map.",
    "Например, показать все автобусы линии \"H\" одновременно.": "For example, show all buses on line \"H\" simultaneously.",
    "Не более 1 запроса в минуту на один itineraryId": "No more than 1 request per minute per itineraryId",

    "Как получить itineraryId?": "How to get itineraryId?",
    "ItineraryId можно получить из:": "ItineraryId can be obtained from:",
    "поле": "field",
    "список всех маршрутов на остановке": "list of all routes at the stop",
    "Tip": "Tip",
    "Если нужно отслеживать только один конкретный автобус,": "If you need to track only one specific bus,",
    "используйте": "use",
    "это более эффективно и экономит трафик.": "it's more efficient and saves traffic.",

    "ID маршрута (itineraryId из arrival estimates)": "Route ID (itineraryId from arrival estimates)",
    "Список GPS-координат всех активных автобусов на маршруте": "List of GPS coordinates of all active buses on route",

    # Cards
    "Получить информацию о карте": "Get card information",
    "Возвращает информацию о транспортной карте": "Returns information about a transport card",
    "Серийный номер карты": "Card serial number",
    "Информация о карте": "Card information",

    "Получить токен карты": "Get card token",
    "Возвращает токен для карты": "Returns token for the card",
    "ID токена карты": "Card token ID",
    "Токен карты": "Card token",

    "Проверить возможность пополнения": "Check recharge eligibility",
    "Проверяет, может ли пользователь пополнить карту": "Checks if the user can recharge the card",
    "NIF пользователя (налоговый номер)": "User NIF (tax identification number)",
    "Результат проверки": "Check result",

    # Recharge
    "Онлайн пополнение карты": "Online card recharge",
    "Получить информацию для онлайн пополнения": "Get information for online recharge",
    "Номер карты": "Card number",
    "Информация о пополнении": "Recharge information",

    "Пополнить карту по токену": "Recharge card by token",
    "Выполнить пополнение карты используя токен": "Perform card recharge using token",
    "Результат пополнения": "Recharge result",

    "Получить конфигурацию автопополнения": "Get automatic recharge configuration",
    "Конфигурация": "Configuration",

    "Глобальные настройки автопополнения": "Global automatic recharge settings",
    "Глобальные настройки": "Global settings",

    "Настройки автопополнения для карты": "Card automatic recharge settings",
    "Настройки карты": "Card settings",

    "Изменить статус автопополнения": "Change automatic recharge status",
    "Статус изменён": "Status changed",

    # Rates
    "Тарифы проездных": "Pass rates",
    "Список тарифов": "List of rates",

    "Поездки по 10-билетному": "Ten-pass travels",
    "История поездок": "Travel history",

    # Auth
    "Создать пользователя": "Create user",
    "Пользователь создан": "User created",

    "Получить данные пользователя": "Get user data",
    "Данные пользователя": "User data",

    # Schemas
    "Остановка общественного транспорта": "Public transport stop",
    "Маршрут проходящий через остановку": "Route passing through stop",
    "Время до прибытия в минутах (null если нет данных)": "Time until arrival in minutes (null if no data)",
    "ID автобуса (0 если нет данных)": "Bus ID (0 if no data)",

    "Прогноз прибытия автобуса на остановку": "Bus arrival estimate at stop",
    "Время до прибытия в минутах (null если нет прогноза)": "Time until arrival in minutes (null if no estimate)",
    "ID автобуса для получения GPS-координат (0 если нет данных)": "Bus ID for getting GPS coordinates (0 if no data)",

    "GPS-координаты автобуса в реальном времени с полной телеметрией.": "Real-time bus GPS coordinates with full telemetry.",
    "Обновляется каждые 60 секунд (см. /Coordinates/GapTimeRefresh).": "Updated every 60 seconds (see /Coordinates/GapTimeRefresh).",
    "Структура получена путём реверс-инжиниринга официального приложения CTA Usuario.": "Structure obtained by reverse engineering the official CTA Usuario app.",

    "Уникальный идентификатор автобуса": "Unique bus identifier",
    "Широта в формате WGS84": "Latitude in WGS84 format",
    "Долгота в формате WGS84": "Longitude in WGS84 format",
    "Время фиксации координат (ISO 8601)": "Coordinate capture time (ISO 8601)",

    "Скорость движения автобуса в метрах в секунду.": "Bus movement speed in meters per second.",
    "Для конвертации в км/ч: speed * 3.6": "To convert to km/h: speed * 3.6",

    "Направление движения относительно севера (азимут) в градусах.": "Direction of movement relative to north (azimuth) in degrees.",
    "Север": "North",
    "Восток": "East",
    "Юг": "South",
    "Запад": "West",

    "Курс автобуса (направление, куда повёрнут нос) в градусах.": "Bus heading (direction the front is facing) in degrees.",
    "Может отличаться от bearing при боковом ветре или заносе.": "May differ from bearing in crosswind or skid conditions.",

    "Точность измерения скорости в м/с.": "Speed measurement accuracy in m/s.",
    "Например, если speed=8.33 и speedAccuracy=0.5,": "For example, if speed=8.33 and speedAccuracy=0.5,",
    "то реальная скорость находится в диапазоне 7.83-8.83 м/с.": "then real speed is in the range 7.83-8.83 m/s.",

    "Точность измерения направления движения в градусах.": "Direction of movement measurement accuracy in degrees.",
    "Диапазон погрешности: ±bearingAccuracy градусов.": "Error range: ±bearingAccuracy degrees.",

    "Погрешность измерения курса автобуса в градусах.": "Bus heading measurement error in degrees.",
    "Используется для отображения зоны неопределённости на карте.": "Used to display uncertainty zone on map.",

    "Остановка на маршруте": "Stop on route",
    "Порядковый номер остановки на маршруте": "Stop sequence number on route",
    "Расстояние от начала маршрута в метрах": "Distance from route start in meters",

    "Транспортная карта": "Transport card",
    "Порог баланса для автопополнения": "Balance threshold for automatic recharge",
    "Сумма автопополнения": "Automatic recharge amount",

    # External docs
    "Полная документация CTA API": "Complete CTA API Documentation",
    "Дополнительные материалы:": "Additional materials:",
    "Основная документация и быстрый старт": "Main documentation and quick start",
    "Детальный анализ частоты обновлений": "Detailed analysis of update frequencies",
    "Как приложение парсит JSON": "How the app parses JSON",
    "Скрипт для поиска активных автобусов": "Script to find active buses",
    "Интерактивный просмотр API": "Interactive API viewer",
    "Исходные файлы:": "Source files:",
    "Версия:": "Version:",
    "Дата реверс-инжиниринга:": "Reverse engineering date:",
    "16 декабря 2024": "December 16, 2024",
    "Технологии из APK:": "Technologies from APK:",
    "Фон:": "Background:",
}

# Read the current file
input_file = "cta-api-openapi-en.yaml"
with open(input_file, "r", encoding="utf-8") as f:
    content = f.read()

# Perform translations
for russian, english in translations.items():
    content = content.replace(russian, english)

# Write the translated content
with open(input_file, "w", encoding="utf-8") as f:
    f.write(content)

print(f"✅ Translation complete!")
print(f"📄 File updated: {input_file}")
print(f"🔤 Translations applied: {len(translations)}")
