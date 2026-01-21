package com.iecisa.ctausuario.model.routes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class Distance implements Serializable {

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("value")
    @Expose
    private Integer value;

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
