package com.iecisa.ctausuario.model.autorecharge;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class ErrorAutomaticRechargeModel implements Serializable {

    @SerializedName("applyDate")
    @Expose
    private String applyDate;

    @SerializedName("cardAmount")
    @Expose
    private Integer cardAmount;

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private String error;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("numChip")
    @Expose
    private String numChip;

    @SerializedName("rechargeAmount")
    @Expose
    private Integer rechargeAmount;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumChip() {
        return this.numChip;
    }

    public void setNumChip(String numChip) {
        this.numChip = numChip;
    }

    public Integer getRechargeAmount() {
        return this.rechargeAmount;
    }

    public void setRechargeAmount(Integer rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public Integer getCardAmount() {
        return this.cardAmount;
    }

    public void setCardAmount(Integer cardAmount) {
        this.cardAmount = cardAmount;
    }

    public String getApplyDate() {
        return this.applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
