#!/usr/bin/env python3
"""
Comprehensive YAML-aware translation that preserves structure
"""
import re

# Complete translation dictionary
translations = [
    # Header - must come first
    ("# 🚌 CTA API - Документация", "# 🚌 CTA API - Documentation"),
    ("API для получения информации о метропольных автобусах Астурии в реальном времени.",
     "API for obtaining real-time information about Asturias metropolitan buses."),

    # API Capabilities section
    ("## 📊 Возможности API", "## 📊 API Capabilities"),
    ("Этот API предоставляет данные о:", "This API provides data about:"),
    ("- ✅ **Остановках** с GPS-координатами (WGS84)", "- ✅ **Stops** with GPS coordinates (WGS84)"),
    ("- ✅ **Маршрутах** и направлениях движения", "- ✅ **Routes** and directions"),
    ("- ✅ **Прогнозах прибытия** автобусов на остановки", "- ✅ **Arrival estimates** for buses at stops"),
    ("- ✅ **Real-time GPS-координатах** автобусов в движении с телеметрией",
     "- ✅ **Real-time GPS coordinates** of buses in motion with telemetry"),
    ("- ✅ **Расписаниях** движения", "- ✅ **Timetables** of operation"),
    ("- ✅ **Транспортных картах** и пополнении", "- ✅ **Transport cards** and recharging"),

    # Polling Intervals section
    ("## ⏱️ Интервалы обновления (Polling Intervals)", "## ⏱️ Polling Intervals"),
    ("API использует разные интервалы обновления для разных типов данных:",
     "The API uses different update intervals for different types of data:"),
    ("### GPS-координаты автобусов", "### Bus GPS coordinates"),
    ("- **Интервал**: 60 секунд (получается из `/Coordinates/GapTimeRefresh`)",
     "- **Interval**: 60 seconds (obtained from `/Coordinates/GapTimeRefresh`)"),
    ("- **Эндпоинты**: `/Coordinates/VehicleCoordinates/{id}`, `/Coordinates/VehiclesCoordinates/{id}`",
     "- **Endpoints**: `/Coordinates/VehicleCoordinates/{id}`, `/Coordinates/VehiclesCoordinates/{id}`"),
    ("- **Рекомендация**: НЕ запрашивать чаще 60 секунд", "- **Recommendation**: DO NOT request more frequently than 60 seconds"),

    ("### Прогнозы прибытия", "### Arrival estimates"),
    ("- **Динамический интервал** в зависимости от времени до прибытия:",
     "- **Dynamic interval** depending on time until arrival:"),
    ("- Автобус далеко (>10 мин): **60 секунд**", "- Bus far away (>10 min): **60 seconds**"),
    ("- Автобус близко (2-10 мин): **30 секунд**", "- Bus nearby (2-10 min): **30 seconds**"),
    ("- Автобус очень близко (<2 мин): **15 секунд**", "- Bus very close (<2 min): **15 seconds**"),

    ("### Статические данные", "### Static data"),
    ("- **Интервал**: При загрузке экрана или по запросу", "- **Interval**: On screen load or on demand"),
    ("- **Рекомендация**: Кешировать на 24 часа", "- **Recommendation**: Cache for 24 hours"),

    # Tech Stack
    ("## 🔧 Технический стек", "## 🔧 Technology Stack"),
    ("Официальное приложение CTA Usuario использует:", "The official CTA Usuario app uses:"),
    ("- **HTTP-клиент**: OkHttp с Firebase Performance мониторингом",
     "- **HTTP client**: OkHttp with Firebase Performance monitoring"),
    ("- **JSON-парсинг**: Gson с аннотациями `@SerializedName`",
     "- **JSON parsing**: Gson with `@SerializedName` annotations"),
    ("- **Фоновые обновления**: WorkManager (Android)", "- **Background updates**: WorkManager (Android)"),

    # Rate Limiting
    ("Рекомендуемые лимиты для предотвращения перегрузки сервера:",
     "Recommended limits to prevent server overload:"),
    ("- **GPS-координаты**: Не чаще 60 секунд на vehicleId",
     "- **GPS coordinates**: No more than once per 60 seconds per vehicleId"),
    ("- **Прогнозы прибытия**: Не чаще 15 секунд на stopId",
     "- **Arrival estimates**: No more than once per 15 seconds per stopId"),
    ("- **Параллельные запросы**: Не более 5 одновременно",
     "- **Parallel requests**: No more than 5 simultaneously"),
    ("- **Глобальный лимит**: 60 запросов в минуту на IP (рекомендуется)",
     "- **Global limit**: 60 requests per minute per IP (recommended)"),

    # Best Practices
    ("### 1. Адаптивный polling", "### 1. Adaptive polling"),
    ("// 15 сек", "// 15 sec"),
    ("// 30 сек", "// 30 sec"),
    ("// 60 сек", "// 60 sec"),

    ("### 2. Остановка при неактивности", "### 2. Stop on inactivity"),
    ("- Останавливайте polling через 5 минут неактивности пользователя",
     "- Stop polling after 5 minutes of user inactivity"),
    ("- Возобновляйте при активности (клик, скролл)", "- Resume on activity (click, scroll)"),

    ("### 3. Exponential Backoff при ошибках", "### 3. Exponential Backoff on errors"),
    ("- При ошибке увеличивайте интервал: 1s → 2s → 4s → 8s → max 60s",
     "- On error, increase interval: 1s → 2s → 4s → 8s → max 60s"),
    ("- Сбрасывайте счётчик ошибок при успешном запросе", "- Reset error counter on successful request"),

    ("### 4. Дедупликация запросов", "### 4. Request deduplication"),
    ("- Не отправляйте повторные запросы, пока предыдущий не завершён",
     "- Don't send duplicate requests while previous one is not completed"),
    ("- Используйте debounce для пользовательских действий", "- Use debounce for user actions"),

    # Operating Modes
    ("## 📱 Режимы работы", "## 📱 Operating Modes"),
    ("**Активный режим** (приложение открыто):", "**Active mode** (app open):"),
    ("- GPS-координаты: каждые 60 секунд", "- GPS coordinates: every 60 seconds"),
    ("- Прогнозы прибытия: каждые 15-60 секунд (динамически)",
     "- Arrival estimates: every 15-60 seconds (dynamic)"),

    ("**Фоновый режим** (приложение свёрнуто):", "**Background mode** (app minimized):"),
    ("- GPS-координаты: НЕ обновляются", "- GPS coordinates: NOT updated"),
    ("- Уведомления: только через push от сервера", "- Notifications: only via push from server"),
    ("- WorkManager: обновления каждые 15-30 минут (Android)",
     "- WorkManager: updates every 15-30 minutes (Android)"),

    # Important Notes
    ("## ⚠️ Важные замечания", "## ⚠️ Important Notes"),
    ("1. Это **неофициальная документация**, полученная путём реверс-инжиниринга APK",
     "1. This is **unofficial documentation**, obtained by reverse engineering the APK"),
    ("2. API может измениться без предупреждения", "2. API may change without notice"),
    ("3. Некоторые эндпоинты могут требовать аутентификации", "3. Some endpoints may require authentication"),
    ("4. Уважайте rate limits - не перегружайте сервер", "4. Respect rate limits - don't overload the server"),
    ("5. VehicleId можно получить только через `/StopsFis/{id}/{minutes}/arrivalEstimates`",
     "5. VehicleId can only be obtained via `/StopsFis/{id}/{minutes}/arrivalEstimates`"),
]

# Read input file
with open("cta-api-openapi-en.yaml", "r", encoding="utf-8") as f:
    content = f.read()

# Apply translations in order
for russian, english in translations:
    content = content.replace(russian, english)

# Write output
with open("cta-api-openapi-en.yaml", "w", encoding="utf-8") as f:
    f.write(content)

print(f"✅ Structural translation complete!")
print(f"📦 Applied {len(translations)} translations")
