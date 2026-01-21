package com.iecisa.ctausuario.model.transportcarddetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class RechargeHistoryModel implements Serializable {

    @SerializedName("areas")
    @Expose
    private Integer areas;

    @SerializedName("balanceAmount")
    @Expose
    private Double balanceAmount;

    @SerializedName("company")
    @Expose
    private String company;

    @SerializedName("rechargeAmount")
    @Expose
    private Double rechargeAmount;

    @SerializedName("rechargeMethod")
    @Expose
    private String rechargeMethod;

    @SerializedName("trips")
    @Expose
    private Integer trips;

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRechargeMethod() {
        return this.rechargeMethod;
    }

    public void setRechargeMethod(String rechargeMethod) {
        this.rechargeMethod = rechargeMethod;
    }

    public Double getRechargeAmount() {
        return this.rechargeAmount;
    }

    public void setRechargeAmount(Double rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public Double getBalanceAmount() {
        return this.balanceAmount;
    }

    public void setBalanceAmount(Double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Integer getAreas() {
        return this.areas;
    }

    public void setAreas(Integer areas) {
        this.areas = areas;
    }

    public Integer getTrips() {
        return this.trips;
    }

    public void setTrips(Integer trips) {
        this.trips = trips;
    }
}
