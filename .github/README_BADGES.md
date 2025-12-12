# GitHub Actions Badges

Add these badges to your `README.md` file (replace `yourusername` with your GitHub username):

```markdown
[![Tests](https://github.com/yourusername/oviedo-bus-api/actions/workflows/tests.yml/badge.svg)](https://github.com/yourusername/oviedo-bus-api/actions/workflows/tests.yml)
[![PR Checks](https://github.com/yourusername/oviedo-bus-api/actions/workflows/pr-checks.yml/badge.svg)](https://github.com/yourusername/oviedo-bus-api/actions/workflows/pr-checks.yml)
[![codecov](https://codecov.io/gh/yourusername/oviedo-bus-api/branch/main/graph/badge.svg)](https://codecov.io/gh/yourusername/oviedo-bus-api)
[![Python 3.9+](https://img.shields.io/badge/python-3.9+-blue.svg)](https://www.python.org/downloads/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
```

## Example placement in README.md:

```markdown
# Oviedo Bus API

[![Tests](https://github.com/yourusername/oviedo-bus-api/actions/workflows/tests.yml/badge.svg)](https://github.com/yourusername/oviedo-bus-api/actions/workflows/tests.yml)
[![PR Checks](https://github.com/yourusername/oviedo-bus-api/actions/workflows/pr-checks.yml/badge.svg)](https://github.com/yourusername/oviedo-bus-api/actions/workflows/pr-checks.yml)
[![Python 3.9+](https://img.shields.io/badge/python-3.9+-blue.svg)](https://www.python.org/downloads/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Unofficial Python client for Oviedo (Asturias, Spain) public bus data.
...
```

## Optional: Codecov Setup

If you want code coverage badges:

1. Go to https://codecov.io/
2. Sign in with GitHub
3. Enable your repository
4. The badge will automatically work with the workflow

No additional configuration needed - the workflow already uploads coverage reports!
