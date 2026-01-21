package org.jnbis.record;

import org.jnbis.internal.record.BaseVariableResolutionImageRecord;

/* loaded from: classes6.dex */
public class VariableResolutionPalmprint extends BaseVariableResolutionImageRecord {
    private String palmprintPosition;
    private String palmprintQualityMetric;

    public String getPalmprintPosition() {
        return this.palmprintPosition;
    }

    public void setPalmprintPosition(String str) {
        this.palmprintPosition = str;
    }

    public String getPalmprintQualityMetric() {
        return this.palmprintQualityMetric;
    }

    public void setPalmprintQualityMetric(String str) {
        this.palmprintQualityMetric = str;
    }
}
