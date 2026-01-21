package com.iecisa.ctausuario.model.dataprotection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class DataProtectionRequestModel implements Serializable {

    @SerializedName("accepted")
    @Expose
    private Boolean accepted;

    @SerializedName("consentId")
    @Expose
    private Integer consentId;

    public DataProtectionRequestModel(Integer consentId, Boolean accepted) {
        this.consentId = consentId;
        this.accepted = accepted;
    }

    public Integer getConsentId() {
        return this.consentId;
    }

    public void setConsentId(Integer consentId) {
        this.consentId = consentId;
    }

    public Boolean getAccepted() {
        return this.accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }
}
