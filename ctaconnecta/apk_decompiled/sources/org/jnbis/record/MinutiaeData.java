package org.jnbis.record;

import org.jnbis.internal.record.BaseImageRecord;

/* loaded from: classes6.dex */
public class MinutiaeData extends BaseImageRecord {
    private String corePosition;
    private String deltaPosition;
    private String fingerPosition;
    private String fingerprintPatternClassification;
    private String impressionType;
    private String minutiaeFormat;
    private String numberOfMinutiae;
    private String originatingFingerprintReadingSystem;

    public String getImpressionType() {
        return this.impressionType;
    }

    public void setImpressionType(String str) {
        this.impressionType = str;
    }

    public String getMinutiaeFormat() {
        return this.minutiaeFormat;
    }

    public void setMinutiaeFormat(String str) {
        this.minutiaeFormat = str;
    }

    public String getOriginatingFingerprintReadingSystem() {
        return this.originatingFingerprintReadingSystem;
    }

    public void setOriginatingFingerprintReadingSystem(String str) {
        this.originatingFingerprintReadingSystem = str;
    }

    public String getFingerPosition() {
        return this.fingerPosition;
    }

    public void setFingerPosition(String str) {
        this.fingerPosition = str;
    }

    public String getFingerprintPatternClassification() {
        return this.fingerprintPatternClassification;
    }

    public void setFingerprintPatternClassification(String str) {
        this.fingerprintPatternClassification = str;
    }

    public String getCorePosition() {
        return this.corePosition;
    }

    public void setCorePosition(String str) {
        this.corePosition = str;
    }

    public String getDeltaPosition() {
        return this.deltaPosition;
    }

    public void setDeltaPosition(String str) {
        this.deltaPosition = str;
    }

    public String getNumberOfMinutiae() {
        return this.numberOfMinutiae;
    }

    public void setNumberOfMinutiae(String str) {
        this.numberOfMinutiae = str;
    }
}
