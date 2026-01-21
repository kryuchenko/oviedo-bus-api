#!/bin/bash

# Collect bus GPS tracks over time
# Run this script for a day to collect movement data
# Usage: ./collect-bus-tracks.sh [interval_seconds] [output_dir]

INTERVAL=${1:-30}  # Default: every 30 seconds
OUTPUT_DIR=${2:-"tracks_$(date +%Y%m%d)"}
VEHICLE_RANGE_START=60001
VEHICLE_RANGE_END=60850

mkdir -p "$OUTPUT_DIR"

# File to store all collected data
TRACKS_FILE="$OUTPUT_DIR/all_tracks.jsonl"
LOG_FILE="$OUTPUT_DIR/collect.log"

echo "Starting bus track collection..."
echo "Interval: ${INTERVAL}s"
echo "Output: $OUTPUT_DIR"
echo "Vehicle range: $VEHICLE_RANGE_START - $VEHICLE_RANGE_END"
echo ""
echo "Press Ctrl+C to stop"
echo ""

# Known vehicles with GPS (from our scan)
KNOWN_VEHICLES=(60003 60004 60005 60024 60027 60032 60034 60039 60049 60055 60057 60078 60081 60088 60091 60104 60105 60106 60108 60109 60114 60130 60139 60144 60165 60175 60184 60188 60199 60205 60208 60209 60211 60223 60225 60256 60264 60273 60278 60281 60285 60287 60289 60297 60299 60317 60323 60330 60340 60344 60347 60350 60355 60359 60360 60365 60377 60391 60397 60405 60410 60417 60423 60437 60439 60442 60446 60447 60449 60467 60469 60471 60485 60490 60492 60502 60504 60512 60514 60518 60526 60539 60540 60542 60543 60544 60550 60554 60555 60557 60560 60563 60569 60570 60572 60573 60574 60578 60589 60591 60598 60606 60607 60609 60610 60623 60624 60637 60650 60653 60657 60669 60681 60682 60683 60691 60693 60696 60705 60707 60709 60713 60718 60719 60723 60726 60727 60734 60745 60751 60756 60759 60766 60767 60768 60773 60776 60777 60778 60780 60785 60786 60789 60795 60797 60798 60799 60800 60801 60802 60803 60804 60805 60813 60815 60816 60817 60819 60823 60825 60828 60830 60831 60834 60835 60837)

collect_snapshot() {
    local timestamp=$(date -u +%Y-%m-%dT%H:%M:%SZ)
    local count=0

    for vehicle_id in "${KNOWN_VEHICLES[@]}"; do
        result=$(curl -s --connect-timeout 5 "https://www.consorcioasturias.org/appcta/api/Coordinates/VehicleCoordinates/$vehicle_id" 2>/dev/null)

        if [ -n "$result" ] && [ "$result" != "[]" ]; then
            lat=$(echo "$result" | jq -r '.[0].latitude // 0')
            lon=$(echo "$result" | jq -r '.[0].longitude // 0')
            locDate=$(echo "$result" | jq -r '.[0].locDate // ""')

            # Skip if coordinates are 0,0
            if [ "$lat" != "0" ] && [ "$lon" != "0" ]; then
                echo "{\"ts\":\"$timestamp\",\"id\":$vehicle_id,\"lat\":$lat,\"lon\":$lon,\"locDate\":\"$locDate\"}" >> "$TRACKS_FILE"
                count=$((count + 1))
            fi
        fi
    done

    echo "$(date '+%H:%M:%S') - Collected $count active buses" | tee -a "$LOG_FILE"
}

# Main loop
iteration=0
while true; do
    iteration=$((iteration + 1))
    echo "=== Iteration $iteration ===" >> "$LOG_FILE"

    collect_snapshot

    sleep "$INTERVAL"
done
