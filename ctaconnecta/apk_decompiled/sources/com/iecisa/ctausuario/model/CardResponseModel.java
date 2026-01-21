package com.iecisa.ctausuario.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class CardResponseModel implements Serializable {

    @SerializedName("alias")
    @Expose
    private String alias;

    @SerializedName("cardHolderLastname")
    @Expose
    private String cardHolderLastname;

    @SerializedName("cardHolderName")
    @Expose
    private String cardHolderName;

    @SerializedName("cardHolderSurname")
    @Expose
    private String cardHolderSurname;

    @SerializedName("cardStatus")
    @Expose
    private String cardStatus;

    @SerializedName("cardStatusId")
    @Expose
    private Integer cardStatusId;

    @SerializedName("cardTypeId")
    @Expose
    private Integer cardTypeId;

    @SerializedName("cardTypeName")
    @Expose
    private String cardTypeName;

    @SerializedName("isReactivated")
    @Expose
    private Boolean isReactivated;

    @SerializedName("numChip")
    @Expose
    private String numChip;

    @SerializedName("personal")
    @Expose
    private Boolean personal;

    @SerializedName("titleId")
    @Expose
    private Integer titleId;

    @SerializedName("titleName")
    @Expose
    private String titleName;

    @SerializedName("userId")
    @Expose
    private String userId;

    @SerializedName("verificationCode")
    @Expose
    private String verificationCode;

    public String getNumChip() {
        return this.numChip;
    }

    public void setNumChip(String numChip) {
        this.numChip = numChip;
    }

    public String getVerificationCode() {
        return this.verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getCardTypeId() {
        return this.cardTypeId;
    }

    public void setCardTypeId(Integer cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public String getCardTypeName() {
        return this.cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }

    public String getCardHolderName() {
        return this.cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardHolderSurname() {
        return this.cardHolderSurname;
    }

    public void setCardHolderSurname(String cardHolderSurname) {
        this.cardHolderSurname = cardHolderSurname;
    }

    public String getCardHolderLastname() {
        return this.cardHolderLastname;
    }

    public void setCardHolderLastname(String cardHolderLastname) {
        this.cardHolderLastname = cardHolderLastname;
    }

    public String getCardStatus() {
        return this.cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Boolean getPersonal() {
        return this.personal;
    }

    public void setPersonal(Boolean personal) {
        this.personal = personal;
    }

    public Integer getTitleId() {
        return this.titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return this.titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public Boolean getReactivated() {
        return this.isReactivated;
    }

    public void setReactivated(Boolean reactivated) {
        this.isReactivated = reactivated;
    }

    public Integer getCardStatusId() {
        return this.cardStatusId;
    }

    public void setCardStatusId(Integer cardStatusId) {
        this.cardStatusId = cardStatusId;
    }
}
