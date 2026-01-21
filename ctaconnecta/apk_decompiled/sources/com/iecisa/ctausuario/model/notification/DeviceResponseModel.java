package com.iecisa.ctausuario.model.notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class DeviceResponseModel implements Serializable {

    @SerializedName("deviceToken")
    @Expose
    private String deviceToken;

    @SerializedName("deviceType")
    @Expose
    private Integer deviceType;

    public DeviceResponseModel(String deviceToken, Integer deviceType) {
        this.deviceToken = deviceToken;
        this.deviceType = deviceType;
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Integer getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }
}
