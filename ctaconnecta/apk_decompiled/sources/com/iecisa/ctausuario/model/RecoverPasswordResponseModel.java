package com.iecisa.ctausuario.model;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class RecoverPasswordResponseModel implements Serializable {

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    @Expose
    private Integer status;

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
