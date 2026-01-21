#!/usr/bin/env python3
"""
Final cleanup of remaining Russian text
"""
import re

# Final cleanup patterns
final_fixes = {
    # Specific lines that need fixing
    "description: List of stops для bus": "description: List of stops for the bus",
    "Возвращает рекомендуемый интервал обновления GPS-координат  seconds.": "Returns the recommended GPS coordinate update interval in seconds.",
    "description: Интервал  seconds": "description: Interval in seconds",
    "description: Минимальный интервал между запросами GPS-координат  seconds": "description: Minimum interval between GPS coordinate requests in seconds",
    "Возвращает текущие GPS coordinates конкретного bus  реальном времени.": "Returns current GPS coordinates of a specific bus in real-time.",
    "- GPS coordinates (latitude, longitude)  формате WGS84": "- GPS coordinates (latitude, longitude) in WGS84 format",
    "Возвращает GPS coordinates всех активных автобусо на указанном маршруте.": "Returns GPS coordinates of all active buses on the specified route.",
    "GPS coordinates bus  реальном времени  полной телеметрией.": "Real-time bus GPS coordinates with full telemetry.",
    "Обновляется каждые 60 seconds (see /Coordinates/GapTimeRefresh).": "Updated every 60 seconds (see /Coordinates/GapTimeRefresh).",
    "Скорость движения bus  метрах  second.": "Bus movement speed in meters per second.",

    # Common patterns
    " для ": " for ",
    " конкретного bus": " specific bus",
    " автобусов": " buses",
    "автобусо": "buses",
    " реальном времени": " real-time",
    " формате ": " format ",
    " на указанном маршруте": " on the specified route",
    " полной телеметрией": " full telemetry",
    " метрах": " meters",
    " каждые ": " every ",
    "Возвращает ": "Returns ",
}

# Read the file
input_file = "cta-api-openapi-en.yaml"
with open(input_file, "r", encoding="utf-8") as f:
    content = f.read()

# Apply fixes
for russian, english in final_fixes.items():
    content = content.replace(russian, english)

# Clean up double spaces
content = re.sub(r'  +', ' ', content)

# Write back
with open(input_file, "w", encoding="utf-8") as f:
    f.write(content)

print(f"✅ Final cleanup complete!")
print(f"📄 File updated: {input_file}")
print(f"🧹 Final fixes applied: {len(final_fixes)}")
