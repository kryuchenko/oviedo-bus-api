package org.jnbis.internal.record;

import androidx.window.embedding.EmbeddingCompat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = EmbeddingCompat.DEBUG)
/* loaded from: classes6.dex */
public abstract class BaseVariableResolutionImageRecord extends BaseImageRecord {

    @JsonProperty("bits_per_pixel")
    private String bitsPerPixel;

    @JsonProperty("capture_date")
    private String captureDate;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("device_monitoring_mode")
    private String deviceMonitoringMode;

    @JsonProperty("horizontal_pixel_scale")
    private String horizontalPixelScale;

    @JsonProperty("impression_type")
    private String impressionType;

    @JsonProperty("scale_units")
    private String scaleUnits;

    @JsonProperty("scanned_horizontal_pixel_scale")
    private String scannedHorizontalPixelScale;

    @JsonProperty("scanned_vertical_pixel_scale")
    private String scannedVerticalPixelScale;

    @JsonProperty("source_agency")
    private String sourceAgency;

    @JsonProperty("vertical_pixel_scale")
    private String verticalPixelScale;

    public String getImpressionType() {
        return this.impressionType;
    }

    public void setImpressionType(String str) {
        this.impressionType = str;
    }

    public String getSourceAgency() {
        return this.sourceAgency;
    }

    public void setSourceAgency(String str) {
        this.sourceAgency = str;
    }

    public String getCaptureDate() {
        return this.captureDate;
    }

    public void setCaptureDate(String str) {
        this.captureDate = str;
    }

    public String getScaleUnits() {
        return this.scaleUnits;
    }

    public void setScaleUnits(String str) {
        this.scaleUnits = str;
    }

    public String getHorizontalPixelScale() {
        return this.horizontalPixelScale;
    }

    public void setHorizontalPixelScale(String str) {
        this.horizontalPixelScale = str;
    }

    public String getVerticalPixelScale() {
        return this.verticalPixelScale;
    }

    public void setVerticalPixelScale(String str) {
        this.verticalPixelScale = str;
    }

    public String getBitsPerPixel() {
        return this.bitsPerPixel;
    }

    public void setBitsPerPixel(String str) {
        this.bitsPerPixel = str;
    }

    public String getScannedHorizontalPixelScale() {
        return this.scannedHorizontalPixelScale;
    }

    public void setScannedHorizontalPixelScale(String str) {
        this.scannedHorizontalPixelScale = str;
    }

    public String getScannedVerticalPixelScale() {
        return this.scannedVerticalPixelScale;
    }

    public void setScannedVerticalPixelScale(String str) {
        this.scannedVerticalPixelScale = str;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public String getDeviceMonitoringMode() {
        return this.deviceMonitoringMode;
    }

    public void setDeviceMonitoringMode(String str) {
        this.deviceMonitoringMode = str;
    }
}
