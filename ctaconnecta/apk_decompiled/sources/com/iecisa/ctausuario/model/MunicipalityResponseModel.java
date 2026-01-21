package com.iecisa.ctausuario.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class MunicipalityResponseModel implements Serializable {

    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("ctaZoneCode")
    @Expose
    private Integer ctaZoneCode;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    @Expose
    private String name;

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCtaZoneCode() {
        return this.ctaZoneCode;
    }

    public void setCtaZoneCode(Integer ctaZoneCode) {
        this.ctaZoneCode = ctaZoneCode;
    }
}
