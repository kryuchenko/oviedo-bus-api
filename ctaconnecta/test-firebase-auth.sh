#!/bin/bash

# Test Firebase Anonymous Authentication

API_KEY="AIzaSyBGdiKAs8e_0EHbrZWrr_BW9m3ymVLHKTA"
PROJECT_ID="cta-usuarios-dev-248907"

echo "🔥 Testing Firebase Anonymous Authentication..."
echo ""

# Try anonymous sign-in
RESPONSE=$(curl -s -X POST \
  "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=${API_KEY}" \
  -H "Content-Type: application/json" \
  -d '{"returnSecureToken":true}')

echo "Response:"
echo "$RESPONSE" | jq '.'

# Extract ID token if successful
ID_TOKEN=$(echo "$RESPONSE" | jq -r '.idToken // empty')

if [ -n "$ID_TOKEN" ]; then
    echo ""
    echo "✅ Anonymous authentication successful!"
    echo "ID Token: ${ID_TOKEN:0:50}..."
    echo ""
    echo "🔍 Trying to access Firebase Database..."
    
    # Try to read from database
    DB_RESPONSE=$(curl -s "https://${PROJECT_ID}.firebaseio.com/.json?auth=${ID_TOKEN}")
    
    echo "Database response:"
    echo "$DB_RESPONSE" | jq '.'
else
    echo ""
    echo "❌ Authentication failed"
    ERROR=$(echo "$RESPONSE" | jq -r '.error.message // empty')
    if [ -n "$ERROR" ]; then
        echo "Error: $ERROR"
    fi
fi
