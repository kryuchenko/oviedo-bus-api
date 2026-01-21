package com.iecisa.ctausuario.model.vehicles;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class VehicleCoordinates implements Serializable {

    @SerializedName("companyName")
    @Expose
    private String companyName;

    @SerializedName("directionDesc")
    @Expose
    private String directionDesc;

    @SerializedName("directionId")
    @Expose
    private Integer directionId;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("itineraryDesc")
    @Expose
    private String itineraryDesc;

    @SerializedName("itineraryId")
    @Expose
    private Integer itineraryId;

    @SerializedName("latitude")
    @Expose
    private double latitude;

    @SerializedName("lineDesc")
    @Expose
    private String lineDesc;

    @SerializedName("lineId")
    @Expose
    private Integer lineId;

    @SerializedName("longitude")
    @Expose
    private double longitude;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    @Expose
    private String name;

    @SerializedName("nextRealTime")
    @Expose
    private String nextRealTime;

    @SerializedName("vehicleId")
    @Expose
    private Integer vehicleId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getItineraryId() {
        return this.itineraryId;
    }

    public void setItineraryId(Integer itineraryId) {
        this.itineraryId = itineraryId;
    }

    public String getItineraryDesc() {
        return this.itineraryDesc;
    }

    public void setItineraryDesc(String itineraryDesc) {
        this.itineraryDesc = itineraryDesc;
    }

    public Integer getDirectionId() {
        return this.directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    public String getDirectionDesc() {
        return this.directionDesc;
    }

    public void setDirectionDesc(String directionDesc) {
        this.directionDesc = directionDesc;
    }

    public Integer getLineId() {
        return this.lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getLineDesc() {
        return this.lineDesc;
    }

    public void setLineDesc(String lineDesc) {
        this.lineDesc = lineDesc;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getNextRealTime() {
        return this.nextRealTime;
    }

    public void setNextRealTime(String nextRealTime) {
        this.nextRealTime = nextRealTime;
    }

    public Integer getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }
}
