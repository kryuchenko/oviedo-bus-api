package com.iecisa.ctausuario.model.transportcarddetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class TransportCardModel implements Serializable {
    private String alias;

    @SerializedName(alternate = {"BalanceRecoveryData"}, value = "banlanceRecoveryData")
    @Expose
    private String banlanceRecoveryData;

    @SerializedName(alternate = {"CardHolderName"}, value = "cardHolderName")
    @Expose
    private String cardHolderName;

    @SerializedName(alternate = {"CardNumber"}, value = "cardNumber")
    @Expose
    private String cardNumber;

    @SerializedName("cardStatus")
    @Expose
    private String cardStatus;

    @SerializedName("cardStatusId")
    @Expose
    private Integer cardStatusId;
    private Integer cardTypeId;

    @SerializedName("cardTypeName")
    @Expose
    private String cardTypeName;

    @SerializedName(alternate = {"CurrentAmount"}, value = "currentAmount")
    @Expose
    private Double currentAmount;

    @SerializedName(alternate = {"CurrentMonthAmount"}, value = "currentMonthAmount")
    @Expose
    private Double currentMonthAmount;

    @SerializedName("extensionBit")
    @Expose
    private Boolean extensionBit;

    @SerializedName(alternate = {"FlatFeeZonesAmount"}, value = "flatFeeZonesAmount")
    @Expose
    private Double flatFeeZonesAmount;

    @SerializedName(alternate = {"FlatFeeZonesNumber"}, value = "flatFeeZonesNumber")
    @Expose
    private Integer flatFeeZonesNumber;

    @SerializedName(alternate = {"IsPostPaymentActive"}, value = "isPostPaymentActive")
    @Expose
    private Boolean isPostPaymentActive;

    @SerializedName("isReactivable")
    @Expose
    private Boolean isReactivable;

    @SerializedName("isReactivated")
    @Expose
    private Boolean isReactivated;

    @SerializedName(alternate = {"LastUpdate"}, value = "lastUpdate")
    @Expose
    private String lastUpdate;

    @SerializedName("pendingAmount")
    @Expose
    private Double pendingAmount;

    @SerializedName("reactivable")
    @Expose
    private Integer reactivable;

    @SerializedName(alternate = {"Tickets"}, value = "tickets")
    @Expose
    private Integer tickets;

    @SerializedName(alternate = {"ValidityDate"}, value = "validityDate")
    @Expose
    private String validityDate;

    @SerializedName(alternate = {"Zones"}, value = "zones")
    @Expose
    private Integer zones;

    @SerializedName(alternate = {"DiscountProfiles"}, value = "discountProfiles")
    @Expose
    private List<DiscountProfileModel> discountProfileModels = new ArrayList();

    @SerializedName(alternate = {"ZonesAmount"}, value = "zonesAmount")
    @Expose
    private List<ZonesAmountModel> zonesAmountModel = new ArrayList();

    @SerializedName(alternate = {"HistoricsData"}, value = "historicsData")
    @Expose
    private List<HistoricsData> historicsData = new ArrayList();

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Boolean getIsPostPaymentActive() {
        return this.isPostPaymentActive;
    }

    public void setIsPostPaymentActive(Boolean isPostPaymentActive) {
        this.isPostPaymentActive = isPostPaymentActive;
    }

    public String getCardHolderName() {
        return this.cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Double getCurrentAmount() {
        return this.currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Double getCurrentMonthAmount() {
        return this.currentMonthAmount;
    }

    public void setCurrentMonthAmount(Double currentMonthAmount) {
        this.currentMonthAmount = currentMonthAmount;
    }

    public List<DiscountProfileModel> getDiscountProfileModels() {
        return this.discountProfileModels;
    }

    public void setDiscountProfileModels(List<DiscountProfileModel> discountProfileModels) {
        this.discountProfileModels = discountProfileModels;
    }

    public Integer getFlatFeeZonesNumber() {
        return this.flatFeeZonesNumber;
    }

    public void setFlatFeeZonesNumber(Integer flatFeeZonesNumber) {
        this.flatFeeZonesNumber = flatFeeZonesNumber;
    }

    public Double getFlatFeeZonesAmount() {
        return this.flatFeeZonesAmount;
    }

    public void setFlatFeeZonesAmount(Double flatFeeZonesAmount) {
        this.flatFeeZonesAmount = flatFeeZonesAmount;
    }

    public List<ZonesAmountModel> getZonesAmountModel() {
        return this.zonesAmountModel;
    }

    public void setZonesAmountModel(List<ZonesAmountModel> zonesAmountModel) {
        this.zonesAmountModel = zonesAmountModel;
    }

    public List<HistoricsData> getHistoricsData() {
        return this.historicsData;
    }

    public void setHistoricsData(List<HistoricsData> historicsData) {
        this.historicsData = historicsData;
    }

    public Boolean getPostPaymentActive() {
        return this.isPostPaymentActive;
    }

    public void setPostPaymentActive(Boolean postPaymentActive) {
        this.isPostPaymentActive = postPaymentActive;
    }

    public Integer getZones() {
        return this.zones;
    }

    public void setZones(Integer zones) {
        this.zones = zones;
    }

    public Integer getTickets() {
        return this.tickets;
    }

    public void setTickets(Integer tickets) {
        this.tickets = tickets;
    }

    public String getValidityDate() {
        return this.validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

    public String getBanlanceRecoveryData() {
        return this.banlanceRecoveryData;
    }

    public void setBanlanceRecoveryData(String banlanceRecoveryData) {
        this.banlanceRecoveryData = banlanceRecoveryData;
    }

    public Integer getCardTypeId() {
        return this.cardTypeId;
    }

    public void setCardTypeId(Integer cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public String getCardStatus() {
        return this.cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Boolean getReactivated() {
        return this.isReactivated;
    }

    public void setReactivated(Boolean reactivated) {
        this.isReactivated = reactivated;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getCardStatusId() {
        return this.cardStatusId;
    }

    public void setCardStatusId(Integer cardStatusId) {
        this.cardStatusId = cardStatusId;
    }

    public Double getPendingAmount() {
        return this.pendingAmount;
    }

    public void setPendingAmount(Double pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    public Boolean isReactivable() {
        return this.isReactivable;
    }

    public Integer getReactivable() {
        return this.reactivable;
    }

    public void setReactivable(Integer reactivable) {
        this.reactivable = reactivable;
    }

    public void setReactivable(Boolean reactivable) {
        this.isReactivable = reactivable;
    }

    public Boolean getExtensionBit() {
        return this.extensionBit;
    }

    public void setExtensionBit(Boolean extensionBit) {
        this.extensionBit = extensionBit;
    }

    public String getCardTypeName() {
        return this.cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }
}
