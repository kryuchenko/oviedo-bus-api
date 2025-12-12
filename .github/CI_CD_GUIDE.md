# CI/CD Guide

This document explains the GitHub Actions workflows configured for this project.

## Workflows

### 1. `tests.yml` - Main Test Suite

**Triggers:**
- Push to `main` or `develop` branches
- Pull requests to `main` or `develop` branches
- Manual trigger via GitHub UI

**Jobs:**

#### Unit Tests
- **Runs on:** Every push/PR
- **Python versions:** 3.9, 3.10, 3.11, 3.12, 3.13
- **Tests:** Unit tests only (fast, no external dependencies)
- **Coverage:** Generates coverage report and uploads to Codecov (Python 3.13 only)
- **Duration:** ~1-2 minutes

#### Integration Tests
- **Runs on:** Push to `main` branch or manual trigger only
- **Python version:** 3.13
- **Tests:** Integration tests that make real HTTP requests to TUA API
- **Failure handling:** Non-blocking (won't fail CI if external API is down)
- **Duration:** ~5-10 minutes

#### Code Quality (Linting)
- **Runs on:** Every push/PR
- **Python version:** 3.13
- **Checks:**
  - **flake8:** Python code linting (syntax errors, undefined names, etc.)
  - **black:** Code formatting verification
  - **mypy:** Type checking (non-blocking, for information only)
- **Duration:** ~30 seconds

### 2. `pr-checks.yml` - Pull Request Quick Checks

**Triggers:**
- When PR is opened, updated, or reopened

**Jobs:**

#### Quick Check
- **Python version:** 3.13 only (fastest check)
- **Tests:** Unit tests with coverage
- **Linting:** flake8 (strict, only critical errors)
- **Formatting:** black check
- **Duration:** ~1 minute

**Purpose:** Fast feedback for contributors before full CI runs

## Why Separate Unit and Integration Tests?

### Unit Tests (Fast, Reliable)
✅ Run on every commit
✅ Test with mocked dependencies
✅ No external API calls
✅ 100% reliable
✅ Fast (~10-20 seconds)

### Integration Tests (Slow, External Dependency)
⚠️ Run only on main branch or manually
⚠️ Make real HTTP requests to TUA API
⚠️ Can fail if API is down (not our fault)
⚠️ Slower (~5-10 minutes)
⚠️ Non-blocking (won't fail CI)

## Running Tests Locally

### Run unit tests only (recommended for development):
```bash
source venv/bin/activate
pytest tests/test_api_client.py tests/test_firebase_client.py tests/test_distance.py -v
```

### Run all tests including integration:
```bash
source venv/bin/activate
pytest tests/ -v
```

### Run with coverage:
```bash
source venv/bin/activate
pytest tests/test_api_client.py tests/test_firebase_client.py tests/test_distance.py \
  -v --cov=src/oviedo_bus_api --cov-report=html
# Open htmlcov/index.html
```

### Run linting:
```bash
source venv/bin/activate
flake8 src/
black --check src/
mypy src/oviedo_bus_api --ignore-missing-imports
```

### Auto-format code:
```bash
source venv/bin/activate
black src/ tests/
```

## Test Coverage

Current coverage: **~95%**

- `api/client.py`: 98%
- `firebase/client.py`: 92%
- `utils/distance.py`: 100%

Coverage reports are uploaded to Codecov on every push to main branch.

## Viewing Test Results

1. Go to your repository on GitHub
2. Click "Actions" tab
3. Select a workflow run
4. View detailed logs for each job

## Troubleshooting

### Tests fail on GitHub but pass locally

**Possible causes:**
1. **Python version mismatch** - GitHub uses Ubuntu, you might use macOS/Windows
2. **Dependencies** - Make sure `setup.py` and `requirements.txt` are in sync
3. **File paths** - Use `Path` objects, not hardcoded paths

**Solution:**
```bash
# Test with multiple Python versions locally using tox or docker
docker run -it python:3.13 bash
# ... install and test
```

### Integration tests fail

**Expected!** Integration tests make real HTTP requests and can fail if:
- TUA API is down
- Network issues
- Rate limiting

**Solution:** Integration tests are non-blocking - they won't fail the CI.

### Coverage decreased

**Action needed!** Write tests for new code before merging PR.

```bash
# Check which lines are not covered:
pytest tests/ --cov=src/oviedo_bus_api --cov-report=term-missing
```

## Best Practices

### Before Committing
```bash
# 1. Run tests
pytest tests/test_api_client.py tests/test_firebase_client.py tests/test_distance.py -v

# 2. Format code
black src/ tests/

# 3. Check linting
flake8 src/
```

### Before Creating PR
```bash
# Run full test suite
pytest tests/ -v --cov=src/oviedo_bus_api

# Verify all Python versions work (if needed)
tox  # or use docker
```

### After PR is Merged
- Check GitHub Actions to ensure all tests passed
- Monitor integration tests for API changes
- Review coverage reports on Codecov

## Maintenance

### Update Dependencies
```bash
# Update requirements
pip list --outdated
pip install --upgrade pytest pytest-cov black flake8 mypy

# Update in setup.py and requirements.txt
# Commit and push - CI will verify compatibility
```

### Add New Tests
1. Write test in appropriate file:
   - `tests/test_api_client.py` - for API client
   - `tests/test_firebase_client.py` - for Firebase client
   - `tests/test_distance.py` - for GPS utilities
   - `tests/test_tua_api.py` - for integration tests (real API calls)

2. Run locally:
   ```bash
   pytest tests/test_your_new_file.py -v
   ```

3. Commit - CI will automatically run the new tests

## Contact

For issues with CI/CD setup, please open an issue on GitHub.
