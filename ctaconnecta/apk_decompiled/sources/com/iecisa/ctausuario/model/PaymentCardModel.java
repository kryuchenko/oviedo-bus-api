package com.iecisa.ctausuario.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class PaymentCardModel implements Serializable {

    @SerializedName("cardNumber")
    @Expose
    private String cardNumber;

    @SerializedName("expirationDate")
    @Expose
    private String expirationDate;

    @SerializedName("expirationMonth")
    @Expose
    private Integer expirationMonth;

    @SerializedName("expirationYear")
    @Expose
    private Integer expirationYear;

    @SerializedName("idToken")
    @Expose
    private Long idToken;

    @SerializedName("isFavourite")
    @Expose
    private Boolean isFavourite;

    public Long getIdToken() {
        return this.idToken;
    }

    public void setIdToken(Long idToken) {
        this.idToken = idToken;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Boolean getIsFavourite() {
        return this.isFavourite;
    }

    public void setIsFavourite(Boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getExpirationYear() {
        return this.expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

    public Integer getExpirationMonth() {
        return this.expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String toString() {
        return this.cardNumber;
    }
}
