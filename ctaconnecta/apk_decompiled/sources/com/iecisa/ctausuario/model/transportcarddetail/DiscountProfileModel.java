package com.iecisa.ctausuario.model.transportcarddetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class DiscountProfileModel implements Serializable {

    @SerializedName("amountDiscount")
    @Expose
    private Integer amountDiscount;

    @SerializedName("percentDiscount")
    @Expose
    private Double percentDiscount;

    @SerializedName("profileName")
    @Expose
    private String profileName;

    @SerializedName("validityDate")
    @Expose
    private String validityDate;

    public String getProfileName() {
        return this.profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Double getPercentDiscount() {
        return this.percentDiscount;
    }

    public void setPercentDiscount(Double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public Integer getAmountDiscount() {
        return this.amountDiscount;
    }

    public void setAmountDiscount(Integer amountDiscount) {
        this.amountDiscount = amountDiscount;
    }

    public String getValidityDate() {
        return this.validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }
}
