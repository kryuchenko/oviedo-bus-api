package com.iecisa.ctausuario.model.transportcarddetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class ZonesAmountModel implements Serializable {

    @SerializedName("amount")
    @Expose
    private Double amount;

    @SerializedName("travelsNum")
    @Expose
    private Integer travelsNum;

    @SerializedName("zone")
    @Expose
    private Integer zone;

    public Integer getZone() {
        return this.zone;
    }

    public void setZone(Integer zone) {
        this.zone = zone;
    }

    public Integer getTravelsNum() {
        return this.travelsNum;
    }

    public void setTravelsNum(Integer travelsNum) {
        this.travelsNum = travelsNum;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
