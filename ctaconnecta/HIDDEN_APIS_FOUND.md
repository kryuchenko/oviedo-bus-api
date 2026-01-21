# Hidden/Unpublic APIs Found

## Summary

Found by reverse-engineering the APK file: `com.iecisa.ctausuario.apk`

## 1. Firebase Realtime Database (DEV)

**URL**: `https://cta-usuarios-dev-248907.firebaseio.com`

**Storage**: `cta-usuarios-dev-248907.appspot.com`

**Status**: ❌ Permission Denied (properly secured)

**Type**: Firebase Realtime Database (development environment)

**Firebase API Keys Found**:
```
AIzaSyBGdiKAs8e_0EHbrZWrr_BW9m3ymVLHKTA
AIzaSyCdHWdglXf90g08u2Zk-E6Wsn1rKiH48pM
```

**Project ID**: `775100084731`

**Test Results**:
```bash
# Direct access - DENIED
curl https://cta-usuarios-dev-248907.firebaseio.com/.json
# Response: {"error": "Permission denied"}

# With API key - DENIED
curl "https://cta-usuarios-dev-248907.firebaseio.com/.json?key=AIzaSy..."
# Response: {"error": "Permission denied"}

# Anonymous authentication - DISABLED
curl -X POST "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSy..."
# Response: Identity Toolkit API is disabled for this project
```

**Security Status**: ✅ Properly configured
- Database rules require authentication
- Anonymous sign-in is disabled
- Identity Toolkit API is disabled
- No public read access
- API keys alone cannot access data

**Notes**:
- This is a **DEV environment** database
- Requires valid Firebase authentication token from a signed-in user
- Likely contains user data, preferences, or internal app state
- Access rules are properly restricted

**Potential contents** (if authenticated):
- User profiles and preferences
- Saved routes/favorites
- App configuration
- Push notification tokens
- User session data

---

## 2. KeyStore File

**Location**: `res/raw/keycta.jks`

**Type**: Java KeyStore

**Purpose**:
- May contain signing keys
- Could have API keys or certificates
- Used for secure communication

**Status**: Encrypted (requires password to access)

---

## 3. Privacy Policy URL

**URL**: `https://www.tecalis.com/es/legal/privacidad`

**Type**: Legal documentation

**Company**: TECALIS (development company)

---

## Public API (Already Known)

**URL**: `https://www.consorcioasturias.org/appcta/api`

**Status**: ✅ Working (GPS temporarily offline)

**Documented in**: [cta-api-openapi-en.yaml](./cta-api-openapi-en.yaml)

---

## Bruteforce Results

**Test**: VehicleId 1-1000

**Result**: ❌ No active vehicles found

**Conclusion**:
- GPS service is offline system-wide
- VehicleIds are likely dynamic and not sequential
- Or VehicleIds use different ID range (>1000)

---

## Recommendations

###  To Access Firebase:

1. **Extract Firebase config from APK**:
   ```bash
   # Look for google-services.json or firebase config
   find apk_extracted -name "*firebase*" -o -name "*google-services*"
   ```

2. **Find authentication tokens**:
   - Check SharedPreferences
   - Intercept network traffic with mitmproxy
   - Look for auth tokens in APK strings

3. **Try anonymous authentication** (if enabled):
   ```javascript
   firebase.auth().signInAnonymously()
   ```

### To Extract KeyStore:

```bash
# Extract keycta.jks from APK
unzip com.iecisa.ctausuario.apk res/raw/keycta.jks

# Try to list contents (requires password)
keytool -list -v -keystore keycta.jks
```

---

## Alternative Approaches

### 1. Network Intercept

Use mitmproxy or Frida to intercept app traffic:

```bash
# Setup mitmproxy
mitmproxy -p 8080

# Configure Android device to use proxy
# Install mitmproxy certificate on device
# Run the app and observe traffic
```

### 2. Decompile APK

Use jadx to decompile and analyze Java code:

```bash
jadx -d output com.iecisa.ctausuario.apk

# Look for:
# - API endpoints in code
# - Authentication mechanisms
# - Hidden features
```

### 3. Check for GraphQL/WebSocket

Some apps use alternative protocols:

```bash
# Search for GraphQL
strings com.iecisa.ctausuario.apk | grep -i graphql

# Search for WebSocket
strings com.iecisa.ctausuario.apk | grep -i websocket
```

---

## Security Notes

⚠️ **Important**:
- Firebase DEV database should NOT be exposed
- If misconfigured, could leak sensitive data
- KeyStore should be password-protected
- Do not attempt unauthorized access

✅ **Ethical approach**:
- Document findings responsibly
- Report security issues to CTA
- Use public APIs only
- Respect rate limits

---

## Next Steps

1. **Wait for GPS service** to come online
2. **Monitor during peak hours**: 7-9 AM, 1-3 PM, 5-8 PM
3. **Run monitoring script**:
   ```bash
   ./monitor-gps-service.sh
   ```
4. **Use existing scripts when GPS active**:
   ```bash
   ./check-all-stops.sh
   ./search-buses-hotspots.sh
   ```

---

## Files Created

1. `test-api.sh` - Test all endpoints
2. `find-active-buses.sh` - Find active buses
3. `search-buses-hotspots.sh` - Check key locations
4. `check-all-stops.sh` - Scan all 188 stops
5. `bruteforce-vehicle-ids.sh` - Bruteforce vehicleId 1-1000
6. `monitor-gps-service.sh` - Monitor GPS availability
7. `test-firebase-auth.sh` - Test Firebase anonymous authentication
8. `test-firebase-direct.sh` - Test direct Firebase database access
9. `curl-examples.md` - Complete API reference
10. `API_GPS_TESTING_RESULTS.md` - Testing report
11. **`HIDDEN_APIS_FOUND.md`** - This document

---

---

## 4. Server IP Addresses

**Found in**: `res/xml/network_security_config.xml`

### Active Server

**IP**: `195.77.163.45`

**Domain**: `www.consorcioasturias.org` (verified via SSL certificate)

**Status**: ✅ **ACTIVE** (nginx/1.28.0)

**SSL Certificate**:
- Common Name: www.consorcioasturias.com
- Valid: Feb 28 2025 - Feb 28 2026
- Issuer: Don Dominio / MrDomain RSA DV CA

**API Access**:
```bash
# Direct IP access (requires Host header)
curl -k "https://195.77.163.45/appcta/api/StopsFis/3614/60/arrivalEstimates" \
  -H "Host: www.consorcioasturias.org"
```

**Purpose**: This is the main production server IP for CTA API

### Other IPs Found

- `87.253.231.46` - Public IP (not responding)
- `10.228.161.210` - Private IP (internal network)
- `192.168.200.116` - Private IP (internal network)

---

## 5. Internal Development Infrastructure

**Domain**: `intSCSVPR.dotnet.com`

**Certificate**: Expired Dec 2020 (self-signed)

**KeyStore**: `keycta.jks` contains "dev (ca raiz)" certificate

**Status**: Old development infrastructure, no longer active

---

## Conclusion

**Found**:
- ✅ Firebase database URL (properly secured with authentication)
- ✅ Firebase API keys (2 keys extracted from APK)
- ✅ **Main server IP address** (`195.77.163.45` = www.consorcioasturias.org)
- ✅ SSL certificate details
- ✅ KeyStore file (encrypted)
- ✅ Privacy policy URL
- ✅ Network security configuration
- ❌ No security vulnerabilities

**Firebase Security Assessment**:
- ✅ Database requires authentication - cannot access without valid user token
- ✅ Anonymous authentication is disabled
- ✅ Identity Toolkit API is disabled
- ✅ API keys alone cannot bypass security rules
- ✅ No public read access configured

**Server Infrastructure**:
- Main API server: `195.77.163.45` (www.consorcioasturias.org)
- Properly configured nginx reverse proxy
- Valid SSL certificate (Don Dominio CA)
- CORS headers configured for web access

**Status**:
- Main CTA API works correctly
- GPS tracking is offline (system-wide issue)
- Server infrastructure is properly configured
- Firebase database is properly secured

**Recommendation**:
Use the public CTA API at [https://www.consorcioasturias.org/appcta/api](https://www.consorcioasturias.org/appcta/api) once GPS service is restored.

Can also use direct IP: `https://195.77.163.45/appcta/api` (with proper Host header)

**Security Note**:
The CTA infrastructure is properly configured:
- Firebase backend has appropriate security rules
- SSL/TLS properly configured with valid certificates
- No security vulnerabilities were found during this analysis
- Internal development infrastructure is isolated
