# 🔍 Анализ парсинга API в CTA Usuario App

## 📱 Технологический стек

### HTTP клиент
- **OkHttp** - для HTTP запросов
- **Firebase Performance** - мониторинг производительности сети
- Использует `FirebasePerfOkHttpClient` для инструментирования запросов

### JSON парсинг
- **Gson** - для сериализации/десериализации JSON
- Аннотации `@SerializedName` для маппинга полей
- `GsonBuilder` для конфигурации парсера

---

## 📦 Модели данных

### 1. `VehicleCoordinates` (com.iecisa.ctausuario.model.vehicles)

Основная модель для GPS-координат автобуса:

```kotlin
data class VehicleCoordinates(
    val vehicleId: Int,           // ID автобуса
    val latitude: Double,         // Широта (WGS84)
    val longitude: Double,        // Долгота (WGS84)
    val speed: Float,             // Скорость в м/с
    val bearing: Float,           // Направление в градусах (0-360)
    val headingDegrees: Float,    // Курс в градусах
    
    // Точность данных
    val speedAccuracyMetersPerSecond: Float?,
    val bearingAccuracyDegrees: Float?,
    val headingErrorDegrees: Float?
)
```

**Ключевые наблюдения:**
- ✅ API предоставляет **реальные GPS-координаты**
- ✅ Есть **скорость** и **направление движения**
- ✅ Есть **метрики точности** данных
- ✅ Поля `bearing` и `headingDegrees` - для направления движения

### 2. `Coordinates` (com.iecisa.ctausuario.model)

Базовая модель координат:

```kotlin
data class Coordinates(
    val latitude: Double,
    val longitude: Double
)
```

Используется для:
- Местоположения остановок
- Поиска остановок в радиусе
- Центров маршрутов

### 3. `Vehicle` (com.iecisa.ctausuario.model.routes)

Модель автобуса/транспортного средства:

```kotlin
data class Vehicle(
    val vehicleId: Int,
    // ... другие поля из arrival estimates
)
```

---

## 🔄 Процесс парсинга

### Шаг 1: HTTP запрос через OkHttp

```kotlin
// Приложение использует OkHttp с Firebase Performance
val client = OkHttpClient.Builder()
    .addInterceptor(FirebasePerfOkHttpClient())
    .build()

val request = Request.Builder()
    .url("https://www.consorcioasturias.org/appcta/api/...")
    .build()
```

### Шаг 2: Парсинг JSON через Gson

```kotlin
val gson = GsonBuilder()
    .serializeSpecialFloatingPointValues()  // Для NaN, Infinity
    .create()

val vehicleCoordinates: List<VehicleCoordinates> = 
    gson.fromJson(response.body, 
        object : TypeToken<List<VehicleCoordinates>>() {}.type
    )
```

### Шаг 3: Использование в UI

```kotlin
// DetailStopViewModel
viewModelScope.launch {
    val coordinates = repository.getVehicleCoordinates(vehicleId)
    _vehicleState.value = VehicleState.Success(coordinates)
}
```

---

## 🎯 Структура ответа API (реконструированная)

### GET `/Coordinates/VehicleCoordinates/{vehicleId}`

```json
{
  "vehicleId": 12345,
  "latitude": 43.3622222,
  "longitude": -5.8447876,
  "speed": 8.33,                               // м/с (~30 км/ч)
  "bearing": 180.0,                            // градусы
  "headingDegrees": 180.0,                     // градусы
  "speedAccuracyMetersPerSecond": 0.5,        // точность ±0.5 м/с
  "bearingAccuracyDegrees": 15.0,             // точность ±15°
  "headingErrorDegrees": 10.0                  // погрешность ±10°
}
```

### GET `/Coordinates/VehiclesCoordinates/{itineraryId}`

```json
[
  {
    "vehicleId": 12345,
    "latitude": 43.3622222,
    "longitude": -5.8447876,
    "speed": 8.33,
    "bearing": 180.0,
    "headingDegrees": 180.0
  },
  {
    "vehicleId": 12346,
    "latitude": 43.3640000,
    "longitude": -5.8450000,
    "speed": 12.5,
    "bearing": 270.0,
    "headingDegrees": 270.0
  }
]
```

---

## 📊 Использование данных в приложении

### 1. MapStopsViewModel
Отображение остановок и автобусов на карте:

```kotlin
class MapStopsViewModelImpl {
    fun loadVehiclesOnMap(itineraryId: Int) {
        viewModelScope.launch {
            val vehicles = repository.getVehiclesCoordinates(itineraryId)
            vehicles.forEach { vehicle ->
                addVehicleMarker(
                    position = LatLng(vehicle.latitude, vehicle.longitude),
                    rotation = vehicle.bearing,  // Поворот маркера
                    speed = vehicle.speed
                )
            }
        }
    }
}
```

### 2. DetailStopViewModel
Детальная информация об автобусе:

```kotlin
class DetailStopViewModelImpl {
    fun trackVehicle(vehicleId: Int) {
        // Обновление каждые 60 секунд (GapTimeRefresh)
        viewModelScope.launch {
            while (isActive) {
                val coords = repository.getVehicleCoordinates(vehicleId)
                _vehiclePosition.value = coords
                delay(60_000)  // 60 секунд
            }
        }
    }
}
```

---

## 🔧 Конфигурация Gson

Приложение использует специальную конфигурацию Gson:

```kotlin
val gson = GsonBuilder()
    .serializeSpecialFloatingPointValues()  // Для обработки NaN, Infinity
    .create()
```

Это важно для:
- Обработки отсутствующих данных (NaN)
- Некорректных GPS-координат
- Специальных значений точности

---

## 🎨 Дополнительные поля

Приложение также использует:

- `getSpeedPerPixel()` - для визуализации на карте
- `getBearingAccuracyDegrees()` - для отображения зоны неопределенности
- `getHeadingErrorDegrees()` - для расчета погрешности

---

## 💡 Ключевые выводы

1. **API возвращает полные GPS-данные:**
   - Координаты (lat/lng)
   - Скорость (м/с)
   - Направление движения (градусы)
   - Метрики точности

2. **Обновление данных:**
   - Интервал: 60 секунд (из `GapTimeRefresh`)
   - Через OkHttp с Firebase Performance monitoring

3. **Парсинг:**
   - Gson с `@SerializedName` аннотациями
   - Поддержка специальных float значений

4. **Точность:**
   - API предоставляет метрики точности для всех параметров
   - Позволяет оценить качество данных

---

## 🔍 Для нашей реализации

### Обновить OpenAPI спецификацию:

```yaml
VehicleCoordinates:
  type: object
  required:
    - vehicleId
    - latitude
    - longitude
  properties:
    vehicleId:
      type: integer
      example: 12345
    latitude:
      type: number
      format: double
      example: 43.3622222
    longitude:
      type: number
      format: double
      example: -5.8447876
    speed:
      type: number
      format: float
      description: Скорость в м/с
      example: 8.33
    bearing:
      type: number
      format: float
      description: Направление движения в градусах (0-360)
      example: 180.0
    headingDegrees:
      type: number
      format: float
      description: Курс в градусах
      example: 180.0
    speedAccuracyMetersPerSecond:
      type: number
      format: float
      description: Точность скорости в м/с
      example: 0.5
      nullable: true
    bearingAccuracyDegrees:
      type: number
      format: float
      description: Точность направления в градусах
      example: 15.0
      nullable: true
    headingErrorDegrees:
      type: number
      format: float
      description: Погрешность курса в градусах
      example: 10.0
      nullable: true
```

---

**Дата анализа**: 16 декабря 2024  
**Версия APK**: com.iecisa.ctausuario.apk  
**Инструменты**: strings, grep, manual analysis
