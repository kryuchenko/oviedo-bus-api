package com.iecisa.ctausuario.model.routes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes5.dex */
public class Route implements Serializable {

    @SerializedName("legs")
    @Expose
    private List<Leg> legs = null;

    @SerializedName("overview_polyline")
    @Expose
    private PolylineData overviewPolyline;

    @SerializedName("summary")
    @Expose
    private String summary;

    public List<Leg> getLegs() {
        return this.legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    public PolylineData getOverviewPolyline() {
        return this.overviewPolyline;
    }

    public void setOverviewPolyline(PolylineData overviewPolyline) {
        this.overviewPolyline = overviewPolyline;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
