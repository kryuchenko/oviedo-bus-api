package org.jnbis.record;

import org.jnbis.internal.record.BaseVariableResolutionImageRecord;

/* loaded from: classes6.dex */
public class VariableResolutionLatentImage extends BaseVariableResolutionImageRecord {
    private String fingerPalmPosition;
    private String latentQualityMetric;
    private String printPositionCoordinates;
    private String searchPositionDescriptors;

    public String getFingerPalmPosition() {
        return this.fingerPalmPosition;
    }

    public void setFingerPalmPosition(String str) {
        this.fingerPalmPosition = str;
    }

    public String getSearchPositionDescriptors() {
        return this.searchPositionDescriptors;
    }

    public void setSearchPositionDescriptors(String str) {
        this.searchPositionDescriptors = str;
    }

    public String getPrintPositionCoordinates() {
        return this.printPositionCoordinates;
    }

    public void setPrintPositionCoordinates(String str) {
        this.printPositionCoordinates = str;
    }

    public String getLatentQualityMetric() {
        return this.latentQualityMetric;
    }

    public void setLatentQualityMetric(String str) {
        this.latentQualityMetric = str;
    }
}
