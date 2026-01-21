package com.iecisa.ctausuario.model.transportcarddetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class HistoricsData implements Serializable {

    @SerializedName("historicDate")
    @Expose
    private String historicDate;

    @SerializedName("historicRecharges")
    @Expose
    private RechargeHistoryModel rechargeHistoryModel;

    @SerializedName("historicValidations")
    @Expose
    private ValidationHistoryModel validationHistoryModel;

    public String getHistoricDate() {
        return this.historicDate;
    }

    public void setHistoricDate(String historicDate) {
        this.historicDate = historicDate;
    }

    public RechargeHistoryModel getRechargeHistoryModel() {
        return this.rechargeHistoryModel;
    }

    public void setRechargeHistoryModel(RechargeHistoryModel rechargeHistoryModel) {
        this.rechargeHistoryModel = rechargeHistoryModel;
    }

    public ValidationHistoryModel getValidationHistoryModel() {
        return this.validationHistoryModel;
    }

    public void setValidationHistoryModel(ValidationHistoryModel validationHistoryModel) {
        this.validationHistoryModel = validationHistoryModel;
    }
}
