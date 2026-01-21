# API Эндпоинты из CTA Usuario APK

## Базовые URL
- **RTM API**: `https://www.consorcioasturias.org/rtm/api/`
- **App CTA API**: `https://www.consorcioasturias.org/appcta/api/`
- **Auth Service**: `https://ms-service.identity.tecalis.com`
- **Payment**: `https://sis.redsys.es/sis/realizarPago`

## Остановки (Stops)
- `GET /appcta/api/Stops/stops/{codName}` - Получить остановку по коду
- `GET /appcta/api/StopsFis/{id}/itineraries` - Маршруты для остановки
- `GET /appcta/api/StopsFis/{longitud}/{latitud}/{radio}` - Остановки в радиусе
- `GET /appcta/api/StopsFis/{id}/{minutos}/arrivalEstimates` - Прогноз прибытия (в минутах)

## Маршруты (Itineraries)
- `GET /appcta/api/Itineraries/{id}/stopitineraries` - Остановки маршрута
- `GET /appcta/api/Itineraries/{id}/{vehicleId}/stopitineraries` - Остановки для конкретного транспорта
- `GET /appcta/api/StopsItinerary/{id}/{date}/timetables` - Расписание

## Координаты транспорта
- `GET /appcta/api/Coordinates/coordinates/{id}` - Координаты транспорта
- `GET /appcta/api/Coordinates/VehicleCoordinates/{id}` - Координаты автобуса
- `GET /appcta/api/Coordinates/VehiclesCoordinates/{id}` - Координаты нескольких автобусов
- `GET /appcta/api/Coordinates/GapTimeRefresh` - Интервал обновления координат

## Карты и пополнение
- `GET /appcta/api/Card/{cardSerialNumber}` - Информация о карте
- `GET /appcta/api/CardToken/{idCardToken}` - Токен карты
- `GET /appcta/api/OnlineRecharge/{cardNumber}` - Онлайн пополнение
- `GET /appcta/api/CardTokenRecharge/{cardNumber}/{idCardToken}` - Пополнение по токену
- `GET /appcta/api/UserCard/canRecharge/{nif}` - Проверка возможности пополнения
- `GET /appcta/api/ImpersonalPass/{cardSerialNumber}/{control}` - Безличный проездной

## Автоматическое пополнение
- `GET /appcta/api/AutomaticRechargeConfig` - Конфигурация автопополнения
- `GET /appcta/api/AutomaticRechargeConfig/global` - Глобальные настройки
- `GET /appcta/api/AutomaticRechargeConfig/{cardNumber}` - Настройки для карты
- `POST /appcta/api/AutomaticRechargeConfig/changeStatus/{cardNumber}` - Изменить статус
- `POST /appcta/api/AutomaticRechargeConfig/autorecharge/retry/{id}` - Повторить попытку

## Тарифы
- `GET /appcta/api/Rates/ctaPassRates/{cardSerialNumber}` - Тарифы проездных
- `GET /appcta/api/Rates/ctaTenPassTravels/{cardSerialNumber}` - Поездки по 10-билетному
- `GET /appcta/api/Rates/ctaTenPassRates/{cardSerialNumber}/{numViajes}` - Тарифы 10-билетного

## Семейные билеты
- `GET /appcta/api/NumFamily/HasTitle/{cardNumber}` - Есть ли семейный билет
- `GET /appcta/api/NumFamily/{cardNumber}/{titleCode}/` - Информация о семейном билете

## Билеты
- `GET /appcta/api/Title/{url}/{cardSerialNumber}` - Информация о билете

## Аутентификация (DoB - Date of Birth?)
- `POST /appcta/api/DoB` - Создать пользователя
- `GET /appcta/api/DoB/representative/{dni}` - Представитель по DNI
- `POST /appcta/api/DoB/copyRepresentative/{dni}` - Копировать представителя
- `GET /appcta/api/DoB/userData/{transactionId}` - Данные пользователя
- `POST /appcta/api/DoB/createUser/{transactionId}` - Создать пользователя
- `POST /appcta/api/DoB/new/{authUuid}/{isRepresentative}` - Новый пользователь

## Аутентификация (Auth Service)
- `POST /auth/api/Account/authenticate2fa` - Двухфакторная аутентификация
- `GET /auth/api/Account/recoverPwd/{nif}` - Восстановление пароля

## Push-уведомления
- `POST /appcta/api/NotificationDevices/UserToken` - Токен устройства
- `GET /appcta/api/NotificationDevices/{deviceToken}` - Устройство
- `GET /appcta/api/NotificationDevices/{deviceToken}/Itineraries` - Маршруты для уведомлений

## RTM (Пополнение карт)
- `https://www.consorcioasturias.org/rtm/api/RechargeCard/` - Пополнить карту через NFC

