package com.iecisa.ctausuario.model;

/* loaded from: classes5.dex */
public class Action {
    private String date;
    private String hour;
    private String name;
    private String nameBusType;
    private String nameRoute;
    private String nameWay;
    private Double price;
    private Integer type;

    public Action(String name, String nameRoute, String nameWay, String nameBusType, Integer type, String date, String hour, Double price) {
        this.name = name;
        this.nameRoute = nameRoute;
        this.nameWay = nameWay;
        this.nameBusType = nameBusType;
        this.type = type;
        this.date = date;
        this.hour = hour;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameRoute() {
        return this.nameRoute;
    }

    public void setNameRoute(String nameRoute) {
        this.nameRoute = nameRoute;
    }

    public String getNameWay() {
        return this.nameWay;
    }

    public void setNameWay(String nameWay) {
        this.nameWay = nameWay;
    }

    public String getNameBusType() {
        return this.nameBusType;
    }

    public void setNameBusType(String nameBusType) {
        this.nameBusType = nameBusType;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return this.hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
