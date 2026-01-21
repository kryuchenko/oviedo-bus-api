package com.iecisa.ctausuario.model.transportcarddetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class ImpersonalTransportCardModel implements Serializable {

    @SerializedName("ctaPass")
    @Expose
    private TransportCardModel ctaPass;

    @SerializedName("ctaTenPass")
    @Expose
    private TransportCardModel ctaTenPass;

    public TransportCardModel getCtaPass() {
        return this.ctaPass;
    }

    public void setCtaPass(TransportCardModel ctaPass) {
        this.ctaPass = ctaPass;
    }

    public TransportCardModel getCtaTenPass() {
        return this.ctaTenPass;
    }

    public void setCtaTenPass(TransportCardModel ctaTenPass) {
        this.ctaTenPass = ctaTenPass;
    }
}
