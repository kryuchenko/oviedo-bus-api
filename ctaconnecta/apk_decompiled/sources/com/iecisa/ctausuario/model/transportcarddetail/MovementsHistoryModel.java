package com.iecisa.ctausuario.model.transportcarddetail;

/* loaded from: classes5.dex */
public class MovementsHistoryModel {
    private String historicDate;
    private RechargeHistoryModel rechargeHistoryModel;
    private ValidationHistoryModel validationHistoryModel;

    public MovementsHistoryModel(String historicDate, RechargeHistoryModel rechargeHistoryModel) {
        this.historicDate = historicDate;
        this.rechargeHistoryModel = rechargeHistoryModel;
    }

    public MovementsHistoryModel(String historicDate, ValidationHistoryModel validationHistoryModel) {
        this.historicDate = historicDate;
        this.validationHistoryModel = validationHistoryModel;
    }

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
