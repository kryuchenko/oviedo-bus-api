#!/usr/bin/env python3
"""
Fix remaining Russian fragments in the English OpenAPI spec
"""

# Additional translations for remaining Russian text
additional_translations = {
    # Units and short words
    " мин": " min",
    "мин)": "min)",
    " сек": " sec",
    "сек": "sec",
    "secondsах": "seconds",
    "secondsу": "second",
    "seconds.": "seconds.",

    # Prepositions and common words
    "автобуса": "bus",
    " автобуса ": " bus ",
    "маршрута": "route",
    "для автобуса": "for the bus",
    "если нет данных": "if no data",
    "проездных": "passes",
    "пользователя": "user",
    "с ": " ",
    "см. ": "see ",
    "(см.": "(see",
    "из ": "from ",
    "в ": " ",
    "с @SerializedName": "with @SerializedName",

    # Genitive case phrases
    "List of stops маршрута": "List of route stops",
    "List of stops для автобуса": "List of stops for the bus",
    "Интервал в secondsах": "Interval in seconds",
    "Минимальный интервал между запросами GPS-координат в secondsах": "Minimum interval between GPS coordinate requests in seconds",
    "Fares проездных": "Pass rates",
    "Data пользователя": "User data",
    "GPS coordinates автобуса": "Bus GPS coordinates",
    "Bus ID (0 если нет данных)": "Bus ID (0 if no data)",
    "Bus ID for getting GPS coordinates (0 если нет данных)": "Bus ID for getting GPS coordinates (0 if no data)",

    # Mixed language phrases
    "Возвращает рекомендуемый интервал обновления GPS-координат в secondsах.": "Returns the recommended GPS coordinate update interval in seconds.",
    "Возвращает текущие GPS coordinates конкретного автобуса в реальном времени.": "Returns current GPS coordinates of a specific bus in real-time.",
    "GPS coordinates (latitude, longitude) в формате WGS84": "GPS coordinates (latitude, longitude) in WGS84 format",
    "НЕ запрашивать чаще 60 seconds": "DO NOT request more frequently than 60 seconds",
    "Не все автобусы передают GPS coordinates. Если vehicleId = 0": "Not all buses transmit GPS coordinates. If vehicleId = 0",
    "Bus ID (vehicleId из arrival estimates)": "Bus ID (vehicleId from arrival estimates)",
    "Возвращает GPS coordinates всех активных автобусов на указанном маршруте.": "Returns GPS coordinates of all active buses on the specified route.",
    "Route ID (itineraryId из arrival estimates)": "Route ID (itineraryId from arrival estimates)",
    "GPS coordinates автобуса в реальном времени с полной телеметрией.": "Real-time bus GPS coordinates with full telemetry.",
    "Обновляется каждые 60 seconds (см. /Coordinates/GapTimeRefresh).": "Updated every 60 seconds (see /Coordinates/GapTimeRefresh).",
    "Скорость движения автобуса в метрах в secondsу.": "Bus movement speed in meters per second.",
    "JSON: Gson с @SerializedName": "JSON: Gson with @SerializedName",
}

# Read the current file
input_file = "cta-api-openapi-en.yaml"
with open(input_file, "r", encoding="utf-8") as f:
    content = f.read()

# Perform translations
for russian, english in additional_translations.items():
    content = content.replace(russian, english)

# Write the fixed content
with open(input_file, "w", encoding="utf-8") as f:
    f.write(content)

print(f"✅ Fixed remaining Russian text!")
print(f"📄 File updated: {input_file}")
print(f"🔧 Additional fixes applied: {len(additional_translations)}")
