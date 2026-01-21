package com.iecisa.ctausuario.model.routes;

/* loaded from: classes5.dex */
public class RoutesRequest {
    private Long arrivalTime;
    private Long departureTime;
    private String destiny;
    private String key;
    private String origin;
    private String transitModel;
    private String mode = "transit";
    private String travelmodel = "transit";
    private boolean alternatives = true;
    private String language = "es";
    private String region = "es";

    public RoutesRequest(String origin, String destiny, Long arrivalTime, Long departureTime, String transitModel, String key) {
        this.origin = origin;
        this.destiny = destiny;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.transitModel = transitModel;
        this.key = key;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return this.destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public Long getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(Long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Long getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(Long departureTime) {
        this.departureTime = departureTime;
    }

    public String getTransitModel() {
        return this.transitModel;
    }

    public void setTransitModel(String transitModel) {
        this.transitModel = transitModel;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMode() {
        return this.mode;
    }

    public String getTravelmodel() {
        return this.travelmodel;
    }

    public void setTravelmodel(String travelmodel) {
        this.travelmodel = travelmodel;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isAlternatives() {
        return this.alternatives;
    }

    public void setAlternatives(boolean alternatives) {
        this.alternatives = alternatives;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
