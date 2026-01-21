package com.iecisa.ctausuario.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class NfcDetailResponseModel implements Serializable {

    @SerializedName("CardType")
    @Expose
    private Double cardType;

    @SerializedName("DataResult")
    @Expose
    private String dataResult;

    @SerializedName("Message")
    @Expose
    private String message;

    @SerializedName("Result")
    @Expose
    private Integer result;

    public Integer getResult() {
        return this.result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getCardType() {
        return this.cardType;
    }

    public void setCardType(Double cardType) {
        this.cardType = cardType;
    }

    public String getDataResult() {
        return this.dataResult;
    }

    public void setDataResult(String dataResult) {
        this.dataResult = dataResult;
    }
}
