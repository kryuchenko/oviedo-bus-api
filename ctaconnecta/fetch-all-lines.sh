#!/bin/bash

# Fetch all unique bus lines from CTA API
# This script collects lines from multiple stops across Asturias

OUTPUT_FILE="all-lines.json"

echo "Fetching bus lines from CTA API..."

# Key locations in Asturias (lon,lat)
locations=(
  "-5.8447876,43.3622222"   # Oviedo centro
  "-5.6611,43.5322"         # Gijón centro
  "-5.9244,43.5567"         # Avilés centro
  "-5.7806,43.3867"         # Oviedo norte
  "-5.9000,43.3500"         # Oviedo oeste
  "-5.7000,43.5000"         # Entre Oviedo y Gijón
  "-5.8500,43.4500"         # Lugones area
  "-6.0000,43.5500"         # Pravia area
  "-5.5000,43.4500"         # Pola de Siero area
  "-5.6500,43.3500"         # Langreo area
)

# Temporary file to collect all responses
TEMP_FILE=$(mktemp)

total_stops=0

for loc in "${locations[@]}"; do
  lon=$(echo $loc | cut -d',' -f1)
  lat=$(echo $loc | cut -d',' -f2)

  echo "Scanning location: $lon, $lat"

  # Get 15 stops from each location (5km radius)
  stops=$(curl -s "https://www.consorcioasturias.org/appcta/api/StopsFis/${lon}/${lat}/5000" | jq -r '.[0:15] | .[].id' 2>/dev/null)

  for stop_id in $stops; do
    result=$(curl -s "https://www.consorcioasturias.org/appcta/api/StopsFis/${stop_id}/itineraries" 2>/dev/null)
    echo "$result" >> "$TEMP_FILE"
    total_stops=$((total_stops + 1))
    sleep 0.1  # Be nice to the API
  done
done

echo "Processed $total_stops stops"
echo "Extracting unique lines..."

# Process and deduplicate
cat "$TEMP_FILE" | \
  jq -s 'flatten | unique_by(.lineId) | sort_by(.lineId)' > "$OUTPUT_FILE" 2>/dev/null

# Count results
line_count=$(jq 'length' "$OUTPUT_FILE" 2>/dev/null)
company_count=$(jq '[.[].companyName] | unique | length' "$OUTPUT_FILE" 2>/dev/null)

echo ""
echo "Results saved to $OUTPUT_FILE"
echo "Total unique lines: $line_count"
echo "Total companies: $company_count"

# Show summary
echo ""
echo "Companies found:"
jq -r '[.[].companyName] | unique | .[]' "$OUTPUT_FILE" 2>/dev/null

# Cleanup
rm -f "$TEMP_FILE"

echo ""
echo "Done!"
