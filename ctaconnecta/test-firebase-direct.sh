#!/bin/bash

# Test direct Firebase Database access (no auth)

PROJECT_ID="cta-usuarios-dev-248907"
API_KEY1="AIzaSyBGdiKAs8e_0EHbrZWrr_BW9m3ymVLHKTA"
API_KEY2="AIzaSyCdHWdglXf90g08u2Zk-E6Wsn1rKiH48pM"

echo "🔥 Testing Firebase Database Direct Access..."
echo ""

echo "Test 1: No authentication"
RESPONSE1=$(curl -s "https://${PROJECT_ID}.firebaseio.com/.json")
echo "Response: $RESPONSE1"
echo ""

echo "Test 2: With API key 1"
RESPONSE2=$(curl -s "https://${PROJECT_ID}.firebaseio.com/.json?key=${API_KEY1}")
echo "Response: $RESPONSE2"
echo ""

echo "Test 3: With API key 2"
RESPONSE3=$(curl -s "https://${PROJECT_ID}.firebaseio.com/.json?key=${API_KEY2}")
echo "Response: $RESPONSE3"
echo ""

echo "Test 4: Check specific paths"
for PATH in "users" "config" "routes" "buses" "stops" "data" "app"; do
    echo "Trying /$PATH..."
    RESP=$(curl -s "https://${PROJECT_ID}.firebaseio.com/${PATH}.json")
    if [ "$RESP" != '{"error": "Permission denied"}' ] && [ "$RESP" != "" ]; then
        echo "  ✅ Found data at /$PATH: $RESP"
    else
        echo "  ❌ Permission denied or empty"
    fi
done

