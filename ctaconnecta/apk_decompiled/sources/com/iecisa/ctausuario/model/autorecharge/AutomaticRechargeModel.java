package com.iecisa.ctausuario.model.autorecharge;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class AutomaticRechargeModel implements Serializable {

    @SerializedName("cardNumber")
    @Expose
    private String cardNumber;

    @SerializedName("isActive")
    @Expose
    private Boolean isActive;

    @SerializedName("rechargeAmount")
    @Expose
    private Integer rechargeAmount;

    @SerializedName("rechargeThreshold")
    @Expose
    private Integer rechargeThreshold;

    public AutomaticRechargeModel(Integer rechargeThreshold, Integer rechargeAmount) {
        this.rechargeThreshold = rechargeThreshold;
        this.rechargeAmount = rechargeAmount;
    }

    public AutomaticRechargeModel(Integer rechargeThreshold, Integer rechargeAmount, String cardNumber, Boolean isActive) {
        this.rechargeThreshold = rechargeThreshold;
        this.rechargeAmount = rechargeAmount;
        this.cardNumber = cardNumber;
        this.isActive = isActive;
    }

    public AutomaticRechargeModel(Integer rechargeThreshold, Integer rechargeAmount, String cardNumber) {
        this.rechargeThreshold = rechargeThreshold;
        this.rechargeAmount = rechargeAmount;
        this.cardNumber = cardNumber;
    }

    public Integer getRechargeThreshold() {
        return this.rechargeThreshold;
    }

    public void setRechargeThreshold(Integer rechargeThreshold) {
        this.rechargeThreshold = rechargeThreshold;
    }

    public Integer getRechargeAmount() {
        return this.rechargeAmount;
    }

    public void setRechargeAmount(Integer rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Boolean isActive() {
        return this.isActive;
    }

    public void setActive(Boolean active) {
        this.isActive = active;
    }
}
