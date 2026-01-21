package com.iecisa.ctausuario.model;

/* loaded from: classes5.dex */
public class ValidatorResponseModel {
    private String message;
    private ValidatorModel model;

    public ValidatorResponseModel(String message, ValidatorModel model) {
        this.message = message;
        this.model = model;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ValidatorModel getModel() {
        return this.model;
    }

    public void setModel(ValidatorModel model) {
        this.model = model;
    }
}
