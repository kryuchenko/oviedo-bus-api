package com.iecisa.ctausuario.model.routes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class PolylineData implements Serializable {

    @SerializedName("points")
    @Expose
    private String points;

    public String getPoints() {
        return this.points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
