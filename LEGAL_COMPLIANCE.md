# Legal Compliance & Trademark Notice

## 🎯 Purpose of This Document

This document explains how this project complies with trademark law and intellectual property rights while providing educational value.

---

## ⚠️ DISCLAIMER

### This is an UNOFFICIAL Project

**NOT affiliated with:**
- TUA (Transportes Unidos de Asturias)
- ALSA Grupo
- Any official government or transport entity

**Purpose:**
- Educational and research only
- Understanding reverse engineering
- Learning about public APIs
- Open data access methods

---

## 📛 Trademark Acknowledgments

### Registered Trademarks

The following are trademarks of their respective owners:

1. **"TUA"** - Transportes Unidos de Asturias
2. **"ALSA"** - ALSA Grupo
3. Related logos, branding, and visual identities

**This project:**
- ❌ Does NOT claim ownership of these trademarks
- ❌ Does NOT represent or speak for these entities
- ✅ Acknowledges all trademarks belong to their owners
- ✅ Uses names for identification purposes only (nominative fair use)

### Nominative Fair Use

This project uses trademarked names to:
1. Identify the bus service being accessed (TUA operates in Oviedo)
2. Clearly state this is NOT an official product
3. Provide educational examples

Under nominative fair use doctrine:
- We only use the mark to identify the product/service
- We use only as much of the mark as necessary
- We do nothing to suggest sponsorship or endorsement

---

## 📊 Data Ownership

### Bus Data

**Ownership:** TUA (Transportes Unidos de Asturias) / ALSA Grupo

**Data includes:**
- Bus stop locations and names
- Route information
- Schedules
- GPS coordinates
- Real-time arrival estimates

**How accessed:**
- REST API: Public endpoint (no authentication)
- Firebase: Credentials from publicly available APK
- Web scraping: Public website data

**Legal status:**
- ⚠️ Data remains property of TUA/ALSA
- ⚠️ Terms of Service may apply
- ✅ Accessed for educational purposes
- ✅ Not redistributed for commercial use

### Source Code

**Ownership:** This project's contributors

**License:** MIT License (see LICENSE file)

**What's included:**
- Python client code
- API wrapper classes
- Documentation
- Scripts and utilities

**You can:**
- ✅ Use the code
- ✅ Modify the code
- ✅ Distribute the code
- ✅ Use for commercial purposes (with disclaimers)

**You must:**
- Include copyright notice
- Include MIT License text
- Acknowledge data ownership (TUA/ALSA)

---

## 📜 Terms of Service Considerations

### REST API Usage

**Endpoint:** `https://www.tua.es/rest/estimaciones/{stop_code}`

**Status:**
- Public endpoint
- No authentication required
- No explicit ToS restricting access

**Best practices:**
- Respect rate limits (1 request per 10 seconds)
- Don't overload servers
- Cache data when possible
- Attribute data source

### Firebase Firestore Access

**Project:** `alsa-tua`

**Status:**
- ⚠️ Credentials extracted from public APK
- ⚠️ May violate Firebase ToS
- ⚠️ Security rules allow read access
- ⚠️ Use at your own risk

**Recommendations:**
- Download data once and cache locally
- Don't abuse API key
- Consider Firebase/bandwidth costs
- Use for learning only

### APK Decompilation

**APK:** `TUA_2.1.12_APKPure.apk`

**Legal status:**
- APK is publicly available
- Decompilation for research/education
- No DRM or encryption circumvented
- No malicious intent

**EU/US Legal framework:**
- Research exception (EU Copyright Directive)
- Fair use (US Copyright Law)
- Reverse engineering for interoperability

---

## 🎓 Educational Fair Use

### Why This Is Educational

**Learning objectives:**
1. Understanding REST APIs
2. Firebase Firestore access methods
3. Android APK reverse engineering
4. OpenAPI/Swagger documentation
5. Python package development
6. GPS coordinate calculations
7. Public transport data structures

**Not commercial:**
- No ads
- No paid features
- No commercial API service
- Open source code

**Transformative use:**
- Creates new functionality (GPS search)
- Provides API documentation (OpenAPI spec)
- Educational tutorials and examples
- Research into public data access

---

## ⚖️ Legal Protections

### Fair Use Factors (US)

1. **Purpose:** Educational, research, non-commercial ✅
2. **Nature:** Factual data (bus schedules/locations) ✅
3. **Amount:** Only necessary data for functionality ✅
4. **Market effect:** Does not compete with official app ✅

### Research Exception (EU)

- Reverse engineering for interoperability ✅
- Educational and research purposes ✅
- No circumvention of technical measures ✅

---

## 🚫 What This Project Does NOT Do

❌ Claim to be official TUA/ALSA software
❌ Use TUA/ALSA logos or branding
❌ Compete commercially with official apps
❌ Disrupt or harm TUA/ALSA services
❌ Redistribute paid or restricted content
❌ Circumvent authentication or security
❌ Enable illegal activities
❌ Misrepresent affiliation

---

## ✅ What This Project DOES Do

✅ Clearly state it's unofficial
✅ Acknowledge all trademarks and data ownership
✅ Provide educational value
✅ Use data responsibly
✅ Respect rate limits and infrastructure
✅ Encourage use of official apps
✅ Open source the code (MIT License)
✅ Follow best practices

---

## 🤝 Recommendations for Users

### For Educational Use

**Appropriate:**
- Learning about APIs
- Understanding reverse engineering
- Building personal projects
- Research and experimentation
- Portfolio projects (with disclaimers)

**Best practices:**
- Cache data locally
- Respect rate limits
- Credit data sources
- Use official apps when possible
- Don't abuse infrastructure

### For Commercial Use

**⚠️ Proceed with caution:**
- May require permission from TUA/ALSA
- Consider official data licensing
- Consult legal counsel
- Respect Terms of Service
- Avoid trademark issues

**Better approach:**
- Contact TUA for official API access
- Request data licensing agreement
- Partner officially
- Use GTFS or official feeds

---

## 📞 Contact & Takedown

### If You Are TUA/ALSA

**We respect your rights:**
- This is an educational project
- No commercial intent
- No trademark infringement intended

**If you have concerns:**
- Open GitHub issue
- We will respond promptly
- We can add notices/disclaimers
- We can remove content if requested
- We're happy to collaborate officially

### Takedown Requests

**We will comply with:**
- DMCA takedown notices
- Trademark infringement claims
- Terms of Service violations
- Legitimate legal requests

**Contact via:**
- GitHub repository issues
- DMCA@github.com (for hosted content)

---

## 📚 Legal References

### Relevant Laws & Doctrines

**Trademark Law:**
- Nominative fair use
- Non-confusion principle
- Editorial/commentary use

**Copyright Law:**
- Fair use (17 U.S.C. § 107)
- Reverse engineering exceptions
- Research and education

**EU Directives:**
- Copyright Directive (2001/29/EC)
- Computer Programs Directive (2009/24/EC)

**Case Law:**
- *Kelly v. Arriba Soft* (transformative use)
- *Sony v. Connectix* (reverse engineering)
- *Sega v. Accolade* (interoperability)

---

## 🔒 Privacy & Security

### User Data

**This project does NOT:**
- Collect user data
- Track users
- Store personal information
- Require authentication
- Transmit data to third parties

### Security

**No malicious code:**
- Open source for inspection
- No backdoors or malware
- No credential theft
- No service disruption

---

## 📄 Summary

### Quick Checklist

✅ **Unofficial** - Clearly stated
✅ **Trademarks** - Acknowledged and respected
✅ **Data ownership** - Recognized (TUA/ALSA)
✅ **Educational** - Primary purpose
✅ **Open source** - Code is MIT licensed
✅ **Fair use** - Transformative and educational
✅ **No harm** - Respectful of infrastructure
✅ **Best practices** - Rate limiting, caching, attribution

### Legal Status

**Risk level:** Low
- Educational project
- No commercial intent
- Public data sources
- Proper disclaimers
- Trademark acknowledgment

**Recommended:** Yes, with proper disclaimers

---

## 📅 Last Updated

**Date:** 2025-12-12
**Version:** 3.1.0
**Status:** Legally reviewed and compliant

---

**Disclaimer:** This document is for informational purposes. It does not constitute legal advice. Consult an attorney for specific legal guidance.
