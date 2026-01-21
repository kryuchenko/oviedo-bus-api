package com.iecisa.ctausuario.model.routes;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes5.dex */
public class Leg implements Serializable {

    @SerializedName("arrival_time")
    @Expose
    private TransitTime arrivalTime;

    @SerializedName("departure_time")
    @Expose
    private TransitTime departureTime;

    @SerializedName("distance")
    @Expose
    private Distance distance;

    @SerializedName(TypedValues.TransitionType.S_DURATION)
    @Expose
    private Distance duration;

    @SerializedName("end_address")
    @Expose
    private String endAddress;

    @SerializedName("end_location")
    @Expose
    private Location endLocation;

    @SerializedName("start_address")
    @Expose
    private String startAddress;

    @SerializedName("start_location")
    @Expose
    private Location startLocation;

    @SerializedName("steps")
    @Expose
    private List<Step> steps = null;

    public TransitTime getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(TransitTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public TransitTime getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(TransitTime departureTime) {
        this.departureTime = departureTime;
    }

    public Distance getDistance() {
        return this.distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Distance getDuration() {
        return this.duration;
    }

    public void setDuration(Distance duration) {
        this.duration = duration;
    }

    public String getEndAddress() {
        return this.endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public Location getEndLocation() {
        return this.endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public String getStartAddress() {
        return this.startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public Location getStartLocation() {
        return this.startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public List<Step> getSteps() {
        return this.steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
