package com.iecisa.ctausuario.model.routes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class ChangeAliasRequestModel implements Serializable {

    @SerializedName("alias")
    @Expose
    private String alias;

    @SerializedName("numChip")
    @Expose
    private String numChip;

    public ChangeAliasRequestModel(String numChip, String alias) {
        this.numChip = numChip;
        this.alias = alias;
    }

    public String getNumChip() {
        return this.numChip;
    }

    public void setNumChip(String numChip) {
        this.numChip = numChip;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
