package com.iecisa.ctausuario.model.routes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class TransitDetails implements Serializable {

    @SerializedName("arrival_stop")
    @Expose
    private TransitStop arrivalStop;

    @SerializedName("arrival_time")
    @Expose
    private TransitTime arrivalTime;

    @SerializedName("departure_stop")
    @Expose
    private TransitStop departureStop;

    @SerializedName("departure_time")
    @Expose
    private TransitTime departureTime;

    @SerializedName("headsign")
    @Expose
    private String headsign;

    @SerializedName("line")
    @Expose
    private Line line;

    @SerializedName("num_stops")
    @Expose
    private Integer numStops;

    public TransitStop getArrivalStop() {
        return this.arrivalStop;
    }

    public void setArrivalStop(TransitStop arrivalStop) {
        this.arrivalStop = arrivalStop;
    }

    public TransitTime getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(TransitTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public TransitStop getDepartureStop() {
        return this.departureStop;
    }

    public void setDepartureStop(TransitStop departureStop) {
        this.departureStop = departureStop;
    }

    public TransitTime getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(TransitTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getHeadsign() {
        return this.headsign;
    }

    public void setHeadsign(String headsign) {
        this.headsign = headsign;
    }

    public Line getLine() {
        return this.line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Integer getNumStops() {
        return this.numStops;
    }

    public void setNumStops(Integer numStops) {
        this.numStops = numStops;
    }
}
