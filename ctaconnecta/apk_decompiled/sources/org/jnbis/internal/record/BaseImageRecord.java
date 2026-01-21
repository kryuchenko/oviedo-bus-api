package org.jnbis.internal.record;

import androidx.window.embedding.EmbeddingCompat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = EmbeddingCompat.DEBUG)
/* loaded from: classes6.dex */
public abstract class BaseImageRecord extends BaseRecord {

    @JsonProperty("compression_algorithm")
    private String compressionAlgorithm;

    @JsonProperty("horizontal_line_length")
    private String horizontalLineLength;

    @JsonProperty("image_data")
    private byte[] imageData;

    @JsonProperty("image_designation_character")
    private String imageDesignationCharacter;

    @JsonProperty("vertical_line_length")
    private String verticalLineLength;

    public String getImageDesignationCharacter() {
        return this.imageDesignationCharacter;
    }

    public void setImageDesignationCharacter(String str) {
        this.imageDesignationCharacter = str;
    }

    public String getHorizontalLineLength() {
        return this.horizontalLineLength;
    }

    public void setHorizontalLineLength(String str) {
        this.horizontalLineLength = str;
    }

    public String getVerticalLineLength() {
        return this.verticalLineLength;
    }

    public void setVerticalLineLength(String str) {
        this.verticalLineLength = str;
    }

    public String getCompressionAlgorithm() {
        return this.compressionAlgorithm;
    }

    public void setCompressionAlgorithm(String str) {
        this.compressionAlgorithm = str;
    }

    public byte[] getImageData() {
        return this.imageData;
    }

    public void setImageData(byte[] bArr) {
        this.imageData = bArr;
    }
}
