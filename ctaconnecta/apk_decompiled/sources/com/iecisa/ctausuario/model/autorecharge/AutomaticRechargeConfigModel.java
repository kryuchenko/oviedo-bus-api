package com.iecisa.ctausuario.model.autorecharge;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class AutomaticRechargeConfigModel {

    @SerializedName("rechargeAmountMax")
    @Expose
    private Integer rechargeAmountMax;

    @SerializedName("rechargeAmountMin")
    @Expose
    private Integer rechargeAmountMin;

    @SerializedName("rechargeAnonAmountMax")
    @Expose
    private Integer rechargeAnonAmountMax;

    @SerializedName("rechargeAnonAmountMin")
    @Expose
    private Integer rechargeAnonAmountMin;

    @SerializedName("rechargeThresholdMax")
    @Expose
    private Integer rechargeThresholdMax;

    @SerializedName("rechargeThresholdMin")
    @Expose
    private Integer rechargeThresholdMin;

    public Integer getRechargeThresholdMin() {
        return this.rechargeThresholdMin;
    }

    public void setRechargeThresholdMin(Integer rechargeThresholdMin) {
        this.rechargeThresholdMin = rechargeThresholdMin;
    }

    public Integer getRechargeThresholdMax() {
        return this.rechargeThresholdMax;
    }

    public void setRechargeThresholdMax(Integer rechargeThresholdMax) {
        this.rechargeThresholdMax = rechargeThresholdMax;
    }

    public Integer getRechargeAmountMin() {
        return this.rechargeAmountMin;
    }

    public void setRechargeAmountMin(Integer rechargeAmountMin) {
        this.rechargeAmountMin = rechargeAmountMin;
    }

    public Integer getRechargeAmountMax() {
        return this.rechargeAmountMax;
    }

    public void setRechargeAmountMax(Integer rechargeAmountMax) {
        this.rechargeAmountMax = rechargeAmountMax;
    }

    public Integer getRechargeAnonAmountMin() {
        return this.rechargeAnonAmountMin;
    }

    public void setRechargeAnonAmountMin(Integer rechargeAnonAmountMin) {
        this.rechargeAnonAmountMin = rechargeAnonAmountMin;
    }

    public Integer getRechargeAnonAmountMax() {
        return this.rechargeAnonAmountMax;
    }

    public void setRechargeAnonAmountMax(Integer rechargeAnonAmountMax) {
        this.rechargeAnonAmountMax = rechargeAnonAmountMax;
    }
}
