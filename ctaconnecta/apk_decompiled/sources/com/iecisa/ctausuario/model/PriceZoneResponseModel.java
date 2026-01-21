package com.iecisa.ctausuario.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class PriceZoneResponseModel implements Serializable {

    @SerializedName("rate")
    @Expose
    private Double rate;

    @SerializedName("zone")
    @Expose
    private Integer zone;

    public Integer getZone() {
        return this.zone;
    }

    public void setZone(Integer zone) {
        this.zone = zone;
    }

    public Double getRate() {
        return this.rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
