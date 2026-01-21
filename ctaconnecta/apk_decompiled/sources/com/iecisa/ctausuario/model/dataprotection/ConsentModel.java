package com.iecisa.ctausuario.model.dataprotection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class ConsentModel implements Serializable {

    @SerializedName("accepted")
    @Expose
    private Boolean accepted;

    @SerializedName("consentDate")
    @Expose
    private String consentDate;

    @SerializedName("consentId")
    @Expose
    private Integer consentId;

    @SerializedName("text")
    @Expose
    private String text;

    public Integer getConsentId() {
        return this.consentId;
    }

    public void setConsentId(Integer consentId) {
        this.consentId = consentId;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getAccepted() {
        return this.accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public String getConsentDate() {
        return this.consentDate;
    }

    public void setConsentDate(String consentDate) {
        this.consentDate = consentDate;
    }
}
