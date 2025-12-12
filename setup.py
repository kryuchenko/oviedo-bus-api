"""
Setup configuration for TUA Bus Oviedo package.
"""

from setuptools import setup, find_packages
from pathlib import Path

# Read README
this_directory = Path(__file__).parent
long_description = (this_directory / "README.md").read_text(encoding="utf-8")

setup(
    name="oviedo-bus-api",
    version="3.1.0",
    author="Independent Developer",
    author_email="",
    description="Unofficial Python client for Oviedo public bus data (educational project, not affiliated with TUA/ALSA)",
    long_description=long_description,
    long_description_content_type="text/markdown",
    url="https://github.com/kryuchenko/oviedo-bus-api",
    project_urls={
        "Bug Tracker": "https://github.com/kryuchenko/oviedo-bus-api/issues",
        "Documentation": "https://github.com/kryuchenko/oviedo-bus-api/blob/main/README.md",
        "Source Code": "https://github.com/kryuchenko/oviedo-bus-api",
    },
    packages=find_packages(where="src"),
    package_dir={"": "src"},
    classifiers=[
        "Development Status :: 4 - Beta",
        "Intended Audience :: Developers",
        "Topic :: Software Development :: Libraries :: Python Modules",
        "License :: OSI Approved :: MIT License",
        "Programming Language :: Python :: 3",
        "Programming Language :: Python :: 3.13",
        "Operating System :: OS Independent",
    ],
    python_requires=">=3.13",
    install_requires=[
        "requests>=2.32.0",
        "pyyaml>=6.0.2",
    ],
    extras_require={
        "dev": [
            "pytest>=8.4.0",
            "pytest-cov>=6.0.0",
            "black>=24.0.0",
            "flake8>=7.1.0",
            "mypy>=1.11.0",
            "jsonschema>=4.23.0",
        ],
        "scraping": [
            "beautifulsoup4>=4.12.0",
            "lxml>=5.3.0",
        ],
        "all": [
            "requests>=2.32.0",
            "pyyaml>=6.0.2",
            "pytest>=8.4.0",
            "beautifulsoup4>=4.12.0",
            "lxml>=5.3.0",
        ],
    },
    entry_points={
        "console_scripts": [
            "tua-download=scripts.download_firebase_data:main",
            "tua-analyze=scripts.analyze_firebase_data:main",
        ],
    },
    include_package_data=True,
    package_data={
        "": ["*.yaml", "*.json"],
    },
    keywords="oviedo bus public-transport api reverse-engineering firebase unofficial educational",
    zip_safe=False,
)
