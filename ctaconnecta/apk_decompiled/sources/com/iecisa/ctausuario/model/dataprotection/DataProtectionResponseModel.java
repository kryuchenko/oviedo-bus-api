package com.iecisa.ctausuario.model.dataprotection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes5.dex */
public class DataProtectionResponseModel implements Serializable {

    @SerializedName("mandatoryConsents")
    @Expose
    private List<ConsentModel> mandatoryConsents = null;

    @SerializedName("otherConsents")
    @Expose
    private List<ConsentModel> otherConsents = null;

    public List<ConsentModel> getMandatoryConsents() {
        return this.mandatoryConsents;
    }

    public void setMandatoryConsents(List<ConsentModel> mandatoryConsents) {
        this.mandatoryConsents = mandatoryConsents;
    }

    public List<ConsentModel> getOtherConsents() {
        return this.otherConsents;
    }

    public void setOtherConsents(List<ConsentModel> otherConsents) {
        this.otherConsents = otherConsents;
    }
}
