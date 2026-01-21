package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest;

import java.util.Date;

/* loaded from: classes5.dex */
public class PendingCardRequest {
    Date requestDate;
    String requestNumber;

    public PendingCardRequest(Date requestDate, String requestNumber) {
        this.requestDate = requestDate;
        this.requestNumber = requestNumber;
    }

    public Date getRequestDate() {
        return this.requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestNumber() {
        return this.requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }
}
