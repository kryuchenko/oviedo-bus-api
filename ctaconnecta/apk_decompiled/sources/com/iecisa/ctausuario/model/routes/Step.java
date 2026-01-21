package com.iecisa.ctausuario.model.routes;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes5.dex */
public class Step implements Serializable {

    @SerializedName("distance")
    @Expose
    private Distance distance;

    @SerializedName(TypedValues.TransitionType.S_DURATION)
    @Expose
    private Distance duration;

    @SerializedName("end_location")
    @Expose
    private Location endLocation;

    @SerializedName("html_instructions")
    @Expose
    private String htmlInstructions;

    @SerializedName("polyline")
    @Expose
    private PolylineData polyline;

    @SerializedName("start_location")
    @Expose
    private Location startLocation;

    @SerializedName("steps")
    @Expose
    private List<Step> steps = null;

    @SerializedName("transit_details")
    @Expose
    private TransitDetails transitDetails;

    @SerializedName("travel_mode")
    @Expose
    private String travelMode;

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

    public Location getEndLocation() {
        return this.endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public String getHtmlInstructions() {
        return this.htmlInstructions;
    }

    public void setHtmlInstructions(String htmlInstructions) {
        this.htmlInstructions = htmlInstructions;
    }

    public PolylineData getPolyline() {
        return this.polyline;
    }

    public void setPolyline(PolylineData polyline) {
        this.polyline = polyline;
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

    public String getTravelMode() {
        return this.travelMode;
    }

    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    public TransitDetails getTransitDetails() {
        return this.transitDetails;
    }

    public void setTransitDetails(TransitDetails transitDetails) {
        this.transitDetails = transitDetails;
    }
}
