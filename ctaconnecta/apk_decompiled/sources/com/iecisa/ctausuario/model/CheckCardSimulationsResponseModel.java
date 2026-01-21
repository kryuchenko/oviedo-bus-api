package com.iecisa.ctausuario.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class CheckCardSimulationsResponseModel {

    @SerializedName("ExtensionBit")
    Boolean extensionBit;

    @SerializedName("Message")
    String message;

    @SerializedName("ResponseCode")
    Integer responseCode;

    @SerializedName("ValidityDate")
    String validityDate;

    public Boolean getExtensionBit() {
        return this.extensionBit;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public void setExtensionBit(Boolean extensionBit) {
        this.extensionBit = extensionBit;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getValidityDate() {
        return this.validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }
}
