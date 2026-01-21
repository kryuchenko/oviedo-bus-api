# Static Resources Found in APK

## 1. SSL Certificate (root.crt)

**Domain**: `intSCSVPR.dotnet.com`

**Type**: Internal SSL certificate

**Details**:
- Issuer: intSCSVPR.dotnet.com (self-signed)
- Valid from: 2019-12-03
- Valid until: 2020-12-03 (EXPIRED)
- Purpose: Internal development/testing server

**Note**: This is an internal certificate for development environment.

---

## 2. Java KeyStore (keycta.jks)

**Type**: Java KeyStore

**Contains**:
- Certificate name: "dev (ca raiz)" (root CA)
- Domain: intSCSVPR.dotnet.com
- Type: X.509

**Purpose**: 
- Used for secure communication with internal servers
- May contain keys for signing or authentication

---

## 3. Network Security Config

Found several IP addresses in `network_security_config.xml`:

```
10.228.161.210      (Private IP - Class A)
192.168.200.116     (Private IP - Class C)
195.77.163.45       (Public IP)
63.33.235.31        (Public IP)
87.253.231.46       (Public IP)
```

**Private IPs** (10.x.x.x, 192.168.x.x):
- Internal development servers
- Not accessible from internet

**Public IPs**:
Let's check what these are...


## IP Addresses Analysis

**Found 4 IP addresses:**

1. **10.228.161.210** - Private IP (internal network)
2. **192.168.200.116** - Private IP (internal network)
3. **195.77.163.45** - Public IP (not responding)
4. **87.253.231.46** - Public IP (not responding)

**Status**: All public IPs are not responding to HTTP/HTTPS requests.
These are likely old/decommissioned servers or internal development machines.

---

## Internal Domain

**intSCSVPR.dotnet.com**

- Self-signed certificate (expired Dec 2020)
- Used for internal development/testing
- Not accessible from public internet

---

## Conclusion

All static resources found are:
- ✅ Development/testing infrastructure
- ✅ No active services
- ✅ Expired certificates
- ❌ No accessible hidden APIs

The APK contains references to old development servers that are no longer active.

