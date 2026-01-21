#!/bin/bash

# Test hidden IP found in APK: 195.77.163.45

IP="195.77.163.45"

echo "🔍 Testing IP: $IP"
echo "Found in: network_security_config.xml"
echo ""

# Test common paths
PATHS=(
    "/"
    "/api"
    "/appcta"
    "/appcta/api"
    "/status"
    "/health"
    "/v1"
    "/admin"
    "/swagger"
    "/docs"
)

for PATH in "${PATHS[@]}"; do
    echo "Testing https://$IP$PATH"
    RESPONSE=$(curl -s -k -w "\n%{http_code}" "https://$IP$PATH" 2>&1)
    HTTP_CODE=$(echo "$RESPONSE" | tail -n1)
    BODY=$(echo "$RESPONSE" | sed '$d' | head -5)
    
    echo "  Status: $HTTP_CODE"
    if [ "$HTTP_CODE" != "403" ] && [ "$HTTP_CODE" != "404" ]; then
        echo "  Body: $BODY"
    fi
    echo ""
done

echo "Server info:"
curl -s -k -I "https://$IP" 2>&1 | grep -E "(Server|Date|X-|Via)"
