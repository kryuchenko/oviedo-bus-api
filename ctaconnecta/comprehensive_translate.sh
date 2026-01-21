#!/bin/bash
# Comprehensive Russian to English translation for CTA API

sed -i '' '
# Main sections
s/Интервалы обновления/Polling Intervals/g
s/Технический стек/Technology Stack/g
s/Rate Limiting/Rate Limiting/g
s/Best Practices/Best Practices/g
s/Режимы работы/Operating Modes/g
s/Важные замечания/Important Notes/g

# Common words
s/Операции с/Operations with/g
s/остановками/stops/g
s/GPS-координаты/GPS coordinates/g
s/Получить/Get/g
s/Возвращает/Returns/g
s/список/list/g
s/всех/all/g
s/для/for/g
s/на/on/g
s/API использует/The API uses/g
s/разные интервалы обновления/different update intervals/g
s/типов данных/types of data/g
s/секунд/seconds/g
s/получается из/obtained from/g
s/Эндпоинты/Endpoints/g
s/Рекомендация/Recommendation/g
s/запрашивать чаще/request more frequently than/g
s/Динамический интервал/Dynamic interval/g
s/зависимости от времени до прибытия/depending on time until arrival/g
s/Автобус далеко/Bus far away/g
s/мин/min/g
s/Автобус близко/Bus nearby/g
s/Автобус очень близко/Bus very close/g
s/Эндпоинт/Endpoint/g
s/Статические данные/Static data/g
s/При загрузке экрана или по запросу/On screen load or on demand/g
s/Кешировать/Cache/g
s/часа/hours/g
s/Официальное приложение/The official app/g
s/CTA Usuario использует/CTA Usuario uses/g
s/HTTP-клиент/HTTP client/g
s/с/with/g
s/Firebase Performance мониторингом/Firebase Performance monitoring/g
s/JSON-парсинг/JSON parsing/g
s/аннотациями/annotations/g
s/Фоновые обновления/Background updates/g
s/Рекомендуемые лимиты/Recommended limits/g
s/предотвращения перегрузки сервера/to prevent server overload/g
s/Не чаще/No more than once per/g
s/Параллельные запросы/Parallel requests/g
s/Не более/No more than/g
s/одновременно/simultaneously/g
s/Глобальный лимит/Global limit/g
s/запросов в минуту/requests per minute per/g
s/рекомендуется/recommended/g
s/Адаптивный/Adaptive/g
s/polling/polling/g
s/Остановка при неактивности/Stop on inactivity/g
s/Останавливайте/Stop/g
s/через/after/g
s/минут неактивности пользователя/minutes of user inactivity/g
s/Возобновляйте при активности/Resume on activity/g
s/клик, скролл/click, scroll/g
s/Exponential Backoff при ошибках/Exponential Backoff on errors/g
s/При ошибке увеличивайте интервал/On error, increase interval/g
s/Сбрасывайте счётчик ошибок при успешном запросе/Reset error counter on successful request/g
s/Дедупликация запросов/Request deduplication/g
s/Не отправляйте повторные запросы/Don'\''t send duplicate requests/g
s/пока предыдущий не завершён/while previous one is not completed/g
s/Используйте debounce/Use debounce/g
s/пользовательских действий/for user actions/g
s/Активный режим/Active mode/g
s/приложение открыто/app open/g
s/каждые/every/g
s/динамически/dynamic/g
s/Фоновый режим/Background mode/g
s/приложение свёрнуто/app minimized/g
s/НЕ обновляются/NOT updated/g
s/Уведомления/Notifications/g
s/только через push от сервера/only via push from server/g
s/обновления/updates/g
s/Это/This is/g
s/неофициальная документация/unofficial documentation/g
s/полученная путём реверс-инжиниринга/obtained by reverse engineering/g
s/может измениться без предупреждения/may change without notice/g
s/Некоторые эндпоинты могут требовать аутентификации/Some endpoints may require authentication/g
s/Уважайте rate limits - не перегружайте сервер/Respect rate limits - don'\''t overload the server/g
s/можно получить только через/can only be obtained via/g
' cta-api-openapi-en.yaml

echo "✅ Comprehensive translation applied"
