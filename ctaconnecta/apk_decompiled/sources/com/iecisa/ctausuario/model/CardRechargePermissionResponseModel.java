package com.iecisa.ctausuario.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class CardRechargePermissionResponseModel implements Serializable {

    @SerializedName("canRecharge")
    @Expose
    private Boolean canRecharge;

    public Boolean getCanRecharge() {
        return this.canRecharge;
    }

    public void setCanRecharge(Boolean canRecharge) {
        this.canRecharge = canRecharge;
    }
}
