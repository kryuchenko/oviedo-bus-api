package com.iecisa.ctausuario.model.routes;

import com.iecisa.ctausuario.model.SearchAddress;
import java.util.Calendar;

/* loaded from: classes5.dex */
public class RoutesModelRequest {
    private SearchAddress addressDestination;
    private SearchAddress addressOrigin;
    private boolean isBus;
    private boolean isExit;
    private boolean isTrain;
    private String key;
    private Calendar selectedDateTime;

    public RoutesModelRequest(boolean isExit, boolean isBus, boolean isTrain, Calendar selectedDateTime, SearchAddress addressOrigin, SearchAddress addressDestination, String key) {
        this.isExit = isExit;
        this.isBus = isBus;
        this.isTrain = isTrain;
        this.selectedDateTime = selectedDateTime;
        this.addressOrigin = addressOrigin;
        this.addressDestination = addressDestination;
        this.key = key;
    }

    public boolean isExit() {
        return this.isExit;
    }

    public void setExit(boolean exit) {
        this.isExit = exit;
    }

    public boolean isBus() {
        return this.isBus;
    }

    public void setBus(boolean bus) {
        this.isBus = bus;
    }

    public boolean isTrain() {
        return this.isTrain;
    }

    public void setTrain(boolean train) {
        this.isTrain = train;
    }

    public Calendar getSelectedDateTime() {
        return this.selectedDateTime;
    }

    public void setSelectedDateTime(Calendar selectedDateTime) {
        this.selectedDateTime = selectedDateTime;
    }

    public SearchAddress getAddressOrigin() {
        return this.addressOrigin;
    }

    public void setAddressOrigin(SearchAddress addressOrigin) {
        this.addressOrigin = addressOrigin;
    }

    public SearchAddress getAddressDestination() {
        return this.addressDestination;
    }

    public void setAddressDestination(SearchAddress addressDestination) {
        this.addressDestination = addressDestination;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
