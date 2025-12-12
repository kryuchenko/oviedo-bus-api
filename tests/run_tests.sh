#!/bin/bash

echo "🧪 Running TUA API automated tests..."
echo "================================"
echo ""

cd "$(dirname "$0")"

# Check Python
if ! command -v python3 &> /dev/null; then
    echo "❌ Python3 not found!"
    exit 1
fi

# Create virtual environment if not exists
if [ ! -d "venv" ]; then
    echo "📦 Creating virtual environment..."
    python3 -m venv venv
fi

# Activate virtual environment
echo "🔧 Activating virtual environment..."
source venv/bin/activate

# Install dependencies
echo "📥 Installing dependencies..."
pip install -q --upgrade pip
pip install -q -r requirements.txt

echo ""
echo "================================"
echo "🚀 Running tests..."
echo "================================"
echo ""

# Run tests
pytest -v \
    --tb=short \
    --color=yes \
    --durations=10

# Status
STATUS=$?

echo ""
echo "================================"
if [ $STATUS -eq 0 ]; then
    echo "✅ All tests passed successfully!"
else
    echo "❌ Some tests failed (code: $STATUS)"
fi
echo "================================"

exit $STATUS
