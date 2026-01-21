package org.jnbis.record;

import org.jnbis.internal.record.BaseVariableResolutionImageRecord;

/* loaded from: classes6.dex */
public class VariableResolutionFingerprint extends BaseVariableResolutionImageRecord {
    private String alternateFingerSegmentPosition;
    private String amputatedOrBandaged;
    private String fingerPosition;
    private String fingerprintQualityMetric;
    private String fingerprintSegmentationPosition;
    private String nistQualityMetric;
    private String printPositionCoordinates;
    private String printPositionDescriptors;
    private String segmentationQualityMetric;

    public String getFingerPosition() {
        return this.fingerPosition;
    }

    public void setFingerPosition(String str) {
        this.fingerPosition = str;
    }

    public String getPrintPositionDescriptors() {
        return this.printPositionDescriptors;
    }

    public void setPrintPositionDescriptors(String str) {
        this.printPositionDescriptors = str;
    }

    public String getPrintPositionCoordinates() {
        return this.printPositionCoordinates;
    }

    public void setPrintPositionCoordinates(String str) {
        this.printPositionCoordinates = str;
    }

    public String getAmputatedOrBandaged() {
        return this.amputatedOrBandaged;
    }

    public void setAmputatedOrBandaged(String str) {
        this.amputatedOrBandaged = str;
    }

    public String getFingerprintSegmentationPosition() {
        return this.fingerprintSegmentationPosition;
    }

    public void setFingerprintSegmentationPosition(String str) {
        this.fingerprintSegmentationPosition = str;
    }

    public String getNistQualityMetric() {
        return this.nistQualityMetric;
    }

    public void setNistQualityMetric(String str) {
        this.nistQualityMetric = str;
    }

    public String getSegmentationQualityMetric() {
        return this.segmentationQualityMetric;
    }

    public void setSegmentationQualityMetric(String str) {
        this.segmentationQualityMetric = str;
    }

    public String getFingerprintQualityMetric() {
        return this.fingerprintQualityMetric;
    }

    public void setFingerprintQualityMetric(String str) {
        this.fingerprintQualityMetric = str;
    }

    public String getAlternateFingerSegmentPosition() {
        return this.alternateFingerSegmentPosition;
    }

    public void setAlternateFingerSegmentPosition(String str) {
        this.alternateFingerSegmentPosition = str;
    }
}
