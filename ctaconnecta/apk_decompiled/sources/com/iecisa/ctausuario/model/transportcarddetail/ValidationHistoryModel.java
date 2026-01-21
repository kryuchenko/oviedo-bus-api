package com.iecisa.ctausuario.model.transportcarddetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class ValidationHistoryModel implements Serializable {

    @SerializedName("balanceAmount")
    @Expose
    private Double balanceAmount;

    @SerializedName("finishStopName")
    @Expose
    private String finishStopName;

    @SerializedName("itinerary")
    @Expose
    private String itinerary;

    @SerializedName("shortCompanyName")
    @Expose
    private String shortCompanyName;

    @SerializedName("startStopName")
    @Expose
    private String startStopName;

    @SerializedName("travelUnits")
    @Expose
    private Double travelUnits;

    @SerializedName("validationAmount")
    @Expose
    private Double validationAmount;

    @SerializedName("zonesNumber")
    @Expose
    private Integer zonesNumber;

    public String getShortCompanyName() {
        return this.shortCompanyName;
    }

    public void setShortCompanyName(String shortCompanyName) {
        this.shortCompanyName = shortCompanyName;
    }

    public String getStartStopName() {
        return this.startStopName;
    }

    public void setStartStopName(String startStopName) {
        this.startStopName = startStopName;
    }

    public String getFinishStopName() {
        return this.finishStopName;
    }

    public void setFinishStopName(String finishStopName) {
        this.finishStopName = finishStopName;
    }

    public String getItinerary() {
        return this.itinerary;
    }

    public void setItinerary(String itinerary) {
        this.itinerary = itinerary;
    }

    public Integer getZonesNumber() {
        return this.zonesNumber;
    }

    public void setZonesNumber(Integer zonesNumber) {
        this.zonesNumber = zonesNumber;
    }

    public Double getValidationAmount() {
        return this.validationAmount;
    }

    public void setValidationAmount(Double validationAmount) {
        this.validationAmount = validationAmount;
    }

    public Double getBalanceAmount() {
        return this.balanceAmount;
    }

    public void setBalanceAmount(Double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Double getTravelUnits() {
        return this.travelUnits;
    }

    public void setTravelUnits(Double travelUnits) {
        this.travelUnits = travelUnits;
    }
}
