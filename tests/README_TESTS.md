# 🧪 Автотесты TUA API

Автоматические тесты для API транспорта TUA (Oviedo, Spain).

## 📋 Что тестируется

### ✅ Функциональные тесты
- Доступность API
- Валидные и невалидные коды остановок
- Структура ответа JSON
- Схема данных (JSON Schema)
- Корреляция времени и расстояния
- Порядок автобусов (ближайший первым)

### ⚡ Тесты производительности
- Время ответа API
- Параллельные запросы

### 🔒 Тесты HTTP
- Заголовки ответа
- CORS поддержка

### 🎯 Граничные случаи
- Большие коды остановок
- Пустые остановки
- Несколько линий на одной остановке

---

## 🚀 Быстрый старт

### 1. Установка зависимостей

```bash
# Создать виртуальное окружение
python3 -m venv venv
source venv/bin/activate  # Linux/Mac
# или
venv\Scripts\activate  # Windows

# Установить зависимости
pip install -r requirements.txt
```

### 2. Запуск тестов

```bash
# Запустить все тесты
pytest

# С подробным выводом
pytest -v

# С coverage отчетом
pytest --cov=. --cov-report=html

# Параллельный запуск (быстрее)
pytest -n auto
```

---

## 📊 Способы запуска

### 🎯 По группам (markers)

```bash
# Только API тесты
pytest -m api

# Только smoke тесты
pytest -m smoke

# Только интеграционные
pytest -m integration

# Только тесты производительности
pytest -m performance
```

### 🔍 По именам

```bash
# Запустить конкретный тест
pytest tests/test_tua_api.py::TestTUAAPI::test_api_is_available

# Запустить тесты с определенным паттерном
pytest -k "test_valid"

# Запустить все тесты класса
pytest tests/test_tua_api.py::TestTUAAPI
```

### 📈 С отчетами

```bash
# HTML отчет
pytest --html=report.html --self-contained-html

# Coverage отчет
pytest --cov=. --cov-report=html
# Открыть htmlcov/index.html

# JUnit XML (для CI/CD)
pytest --junitxml=junit.xml

# Allure отчет
pytest --alluredir=allure-results
allure serve allure-results
```

### ⏱️ Управление временем

```bash
# Показать самые медленные тесты
pytest --durations=10

# С таймаутом
pytest --timeout=30

# Остановиться на первой ошибке
pytest -x

# Запустить только упавшие тесты
pytest --lf
```

---

## 🛠️ Скрипты запуска

### run_tests.sh

```bash
#!/bin/bash

echo "🧪 Запуск автотестов TUA API..."

# Активировать виртуальное окружение
source venv/bin/activate

# Запустить тесты с coverage
pytest -v \
    --cov=. \
    --cov-report=html \
    --cov-report=term \
    --html=report.html \
    --self-contained-html

echo "✅ Тесты завершены!"
echo "📊 HTML отчет: report.html"
echo "📈 Coverage отчет: htmlcov/index.html"
```

### Сделать исполняемым

```bash
chmod +x run_tests.sh
./run_tests.sh
```

---

## 📁 Структура проекта

```
tests/
├── README_TESTS.md          # Эта документация
├── requirements.txt         # Зависимости
├── pytest.ini              # Конфигурация pytest
├── conftest.py             # Общие fixtures
├── test_tua_api.py         # Основные тесты
├── report.html             # HTML отчет (генерируется)
├── htmlcov/                # Coverage отчет (генерируется)
└── venv/                   # Виртуальное окружение
```

---

## 🔧 Конфигурация

### pytest.ini

Основные настройки:
- Verbose output по умолчанию
- Таймаут 60 секунд
- Короткий traceback
- Цветной вывод

### conftest.py

Общие fixtures:
- `http_session` - HTTP сессия с retry
- `api_client` - Клиент для API
- `get_estimaciones` - Convenience функция
- `stop_code` - Параметризованные коды

---

## 📝 Примеры тестов

### Простой тест

```python
def test_api_is_available(get_estimaciones):
    """Проверка доступности API"""
    response = get_estimaciones(1)
    assert response.status_code == 200
```

### Параметризованный тест

```python
@pytest.mark.parametrize("stop_code", [1, 100, 200, 505])
def test_valid_stop_codes(get_estimaciones, stop_code):
    """Тест валидных кодов остановок"""
    response = get_estimaciones(stop_code)
    assert response.status_code == 200
    assert response.json()["estimaciones"]["value"] is not None
```

### Тест с JSON Schema

```python
from jsonschema import validate

def test_response_schema(get_estimaciones):
    """Валидация ответа по схеме"""
    response = get_estimaciones(505)
    data = response.json()

    validate(instance=data, schema=STOP_INFO_SCHEMA)
```

---

## 🐛 Отладка

### Запуск с отладкой

```bash
# С выводом print()
pytest -s

# С pdb при ошибке
pytest --pdb

# С логами
pytest --log-cli-level=DEBUG
```

### Повторный запуск упавших тестов

```bash
# Запустить только упавшие
pytest --lf

# Запустить упавшие и следующий тест
pytest --ff
```

### Reruns (повторы при падении)

```bash
# Повторить упавшие тесты 3 раза
pytest --reruns 3

# С задержкой
pytest --reruns 3 --reruns-delay 2
```

---

## 📊 CI/CD интеграция

### GitHub Actions

```yaml
name: API Tests

on: [push, pull_request]

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v3

    - name: Set up Python
      uses: actions/setup-python@v4
      with:
        python-version: '3.11'

    - name: Install dependencies
      run: |
        cd tests
        pip install -r requirements.txt

    - name: Run tests
      run: |
        cd tests
        pytest -v --junitxml=junit.xml --cov=.

    - name: Upload results
      uses: actions/upload-artifact@v3
      with:
        name: test-results
        path: tests/junit.xml
```

---

## 📈 Метрики качества

### Coverage цели

- Минимум: 80%
- Цель: 90%+

### Производительность

- Ответ API: < 15 секунд
- Все тесты: < 2 минуты

---

## ❓ FAQ

### Q: Как запустить только быстрые тесты?
```bash
pytest -m "not slow"
```

### Q: Как пропустить тесты производительности?
```bash
pytest -m "not performance"
```

### Q: Как запустить тесты параллельно?
```bash
pip install pytest-xdist
pytest -n auto  # автоопределение количества процессов
pytest -n 4     # 4 процесса
```

### Q: Как получить JSON отчет?
```bash
pytest --json-report --json-report-file=report.json
```

---

## 🔗 Полезные ссылки

- [pytest документация](https://docs.pytest.org/)
- [requests документация](https://docs.python-requests.org/)
- [JSON Schema](https://json-schema.org/)
- [TUA официальный сайт](https://www.tua.es)

---

## 📞 Поддержка

При возникновении проблем:
1. Проверьте, что все зависимости установлены
2. Убедитесь, что API доступен: `curl https://www.tua.es/rest/estimaciones/1`
3. Проверьте версию Python: `python --version` (требуется 3.8+)

---

**Автор тестов:** Claude
**Версия:** 1.0.0
**Дата:** 2025-12-11
