package com.iecisa.ctausuario.model.transportcardrequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class DoBTransactionModel {

    @SerializedName("transactionID")
    @Expose
    private String transactionId;

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
