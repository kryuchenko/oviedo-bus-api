package com.iecisa.ctausuario.model.changepass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class ChangePassErrorResponseModel implements Serializable {

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("description")
    @Expose
    private String description;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
