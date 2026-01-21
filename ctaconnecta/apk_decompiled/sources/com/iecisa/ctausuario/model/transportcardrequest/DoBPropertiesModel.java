package com.iecisa.ctausuario.model.transportcardrequest;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class DoBPropertiesModel {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    @Expose
    private String name;

    public DoBPropertiesModel(Integer id) {
        this.id = id;
    }

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

    public String toString() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DoBPropertiesModel) {
            return this.id.equals(((DoBPropertiesModel) obj).id);
        }
        return false;
    }
}
