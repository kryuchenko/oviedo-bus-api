package org.jnbis.internal.record;

import androidx.window.embedding.EmbeddingCompat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = EmbeddingCompat.DEBUG)
/* loaded from: classes6.dex */
public abstract class BaseRecord implements Serializable {

    @JsonProperty("logical_record_length")
    private String logicalRecordLength;

    public String getLogicalRecordLength() {
        return this.logicalRecordLength;
    }

    public void setLogicalRecordLength(String str) {
        this.logicalRecordLength = str;
    }
}
