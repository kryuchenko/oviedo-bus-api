# 🧪 TUA API Automated Tests

Automated tests for TUA (Transportes Unidos de Asturias) public transport API in Oviedo, Spain.

## 📋 What's Tested

### ✅ Functional Tests
- API availability
- Valid and invalid stop codes
- JSON response structure
- Data schema (JSON Schema)
- Time and distance correlation
- Bus ordering (closest first)

### ⚡ Performance Tests
- API response time
- Concurrent requests

### 🔒 HTTP Tests
- Response headers
- CORS support

### 🎯 Edge Cases
- Large stop codes
- Empty stops
- Multiple lines at same stop

---

## 🚀 Quick Start

### 1. Install Dependencies

```bash
# Create virtual environment
python3 -m venv venv
source venv/bin/activate  # Linux/Mac
# or
venv\Scripts\activate  # Windows

# Install dependencies
pip install -r requirements.txt
```

### 2. Run Tests

```bash
# Run all tests
pytest

# Verbose output
pytest -v

# With coverage report
pytest --cov=. --cov-report=html

# Parallel execution (faster)
pytest -n auto
```

---

## 📊 Run Options

### 🎯 By Groups (markers)

```bash
# Only API tests
pytest -m api

# Only smoke tests
pytest -m smoke

# Only integration tests
pytest -m integration

# Only performance tests
pytest -m performance
```

### 🔍 By Names

```bash
# Run specific test
pytest tests/test_tua_api.py::TestTUAAPI::test_api_is_available

# Run tests matching pattern
pytest -k "test_valid"

# Run all tests in class
pytest tests/test_tua_api.py::TestTUAAPI
```

### 📈 With Reports

```bash
# HTML report
pytest --html=report.html --self-contained-html

# Coverage report
pytest --cov=. --cov-report=html
# Open htmlcov/index.html

# JUnit XML (for CI/CD)
pytest --junitxml=junit.xml

# Allure report
pytest --alluredir=allure-results
allure serve allure-results
```

### ⏱️ Time Management

```bash
# Show slowest tests
pytest --durations=10

# With timeout
pytest --timeout=30

# Stop on first failure
pytest -x

# Run only failed tests
pytest --lf
```

---

## 🛠️ Run Scripts

### run_tests.sh

```bash
#!/bin/bash

echo "🧪 Running TUA API automated tests..."

# Activate virtual environment
source venv/bin/activate

# Run tests with coverage
pytest -v \
    --cov=. \
    --cov-report=html \
    --cov-report=term \
    --html=report.html \
    --self-contained-html

echo "✅ Tests completed!"
echo "📊 HTML report: report.html"
echo "📈 Coverage report: htmlcov/index.html"
```

### Make Executable

```bash
chmod +x run_tests.sh
./run_tests.sh
```

---

## 📁 Project Structure

```
tests/
├── README.md               # This documentation
├── requirements.txt        # Dependencies
├── pytest.ini             # Pytest configuration
├── conftest.py            # Common fixtures
├── test_tua_api.py        # Main tests
├── report.html            # HTML report (generated)
├── htmlcov/               # Coverage report (generated)
└── venv/                  # Virtual environment
```

---

## 🔧 Configuration

### pytest.ini

Main settings:
- Verbose output by default
- 60 second timeout
- Short traceback
- Colored output

### conftest.py

Common fixtures:
- `http_session` - HTTP session with retry
- `api_client` - API client
- `get_estimaciones` - Convenience function
- `stop_code` - Parametrized codes

---

## 📝 Test Examples

### Simple Test

```python
def test_api_is_available(get_estimaciones):
    """Check API availability"""
    response = get_estimaciones(1)
    assert response.status_code == 200
```

### Parametrized Test

```python
@pytest.mark.parametrize("stop_code", [1, 100, 200, 505])
def test_valid_stop_codes(get_estimaciones, stop_code):
    """Test valid stop codes"""
    response = get_estimaciones(stop_code)
    assert response.status_code == 200
    assert response.json()["estimaciones"]["value"] is not None
```

### Test with JSON Schema

```python
from jsonschema import validate

def test_response_schema(get_estimaciones):
    """Validate response against schema"""
    response = get_estimaciones(505)
    data = response.json()

    validate(instance=data, schema=STOP_INFO_SCHEMA)
```

---

## 🐛 Debugging

### Run with Debugging

```bash
# With print() output
pytest -s

# With pdb on failure
pytest --pdb

# With logs
pytest --log-cli-level=DEBUG
```

### Rerun Failed Tests

```bash
# Run only failed tests
pytest --lf

# Run failed and next test
pytest --ff
```

### Reruns (on failure)

```bash
# Retry failed tests 3 times
pytest --reruns 3

# With delay
pytest --reruns 3 --reruns-delay 2
```

---

## 📊 CI/CD Integration

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

## 📈 Quality Metrics

### Coverage Goals

- Minimum: 80%
- Target: 90%+

### Performance

- API response: < 15 seconds
- All tests: < 2 minutes

---

## ❓ FAQ

### Q: How to run only fast tests?
```bash
pytest -m "not slow"
```

### Q: How to skip performance tests?
```bash
pytest -m "not performance"
```

### Q: How to run tests in parallel?
```bash
pip install pytest-xdist
pytest -n auto  # auto-detect number of processes
pytest -n 4     # 4 processes
```

### Q: How to get JSON report?
```bash
pytest --json-report --json-report-file=report.json
```

---

## 🔗 Useful Links

- [pytest documentation](https://docs.pytest.org/)
- [requests documentation](https://docs.python-requests.org/)
- [JSON Schema](https://json-schema.org/)
- [TUA official website](https://www.tua.es)

---

## 📞 Support

If you encounter issues:
1. Check that all dependencies are installed
2. Verify API is available: `curl https://www.tua.es/rest/estimaciones/1`
3. Check Python version: `python --version` (requires 3.8+)

---

**Author:** Claude
**Version:** 1.0.0
**Date:** 2025-12-11
