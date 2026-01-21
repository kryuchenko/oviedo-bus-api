package org.jnbis.internal.record;

import androidx.window.embedding.EmbeddingCompat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = EmbeddingCompat.DEBUG)
/* loaded from: classes6.dex */
public abstract class BaseGrayscaleFingerprintRecord extends BaseImageRecord {

    @JsonProperty("finger_position")
    private String fingerPosition;

    @JsonProperty("image_scanning_resolution")
    private String imageScanningResolution;

    @JsonProperty("impression_type")
    private String impressionType;

    public String getImpressionType() {
        return this.impressionType;
    }

    public void setImpressionType(String str) {
        this.impressionType = str;
    }

    public String getFingerPosition() {
        return this.fingerPosition;
    }

    public void setFingerPosition(String str) {
        this.fingerPosition = str;
    }

    public String getImageScanningResolution() {
        return this.imageScanningResolution;
    }

    public void setImageScanningResolution(String str) {
        this.imageScanningResolution = str;
    }
}
