"""
Oviedo Bus API - Unofficial Python client for Oviedo public transport.

⚠️ DISCLAIMER: Unofficial project, not affiliated with TUA or ALSA.

Provides access to:
- Real-time bus arrivals via REST API
- Complete stop database with GPS coordinates (Firebase)
- Route information and schedules
- GPS-based proximity search

Educational and research purposes only.
"""

__version__ = "3.1.0"
__author__ = "Independent Developer"

from .api import TUABusAPI
from .firebase import TUAFirebaseClient

__all__ = ["TUABusAPI", "TUAFirebaseClient"]
