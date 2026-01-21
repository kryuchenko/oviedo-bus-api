package com.iecisa.ctausuario.model.incidence;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class IncidenceRequestModel implements Serializable {

    @SerializedName(PlaceTypes.ADDRESS)
    @Expose
    private String address;

    @SerializedName("cardNumber")
    @Expose
    private String cardNumber;

    @SerializedName("cp")
    @Expose
    private String cp;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("dni")
    @Expose
    private String dni;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("file1")
    @Expose
    private String file1;

    @SerializedName("file2")
    @Expose
    private String file2;

    @SerializedName("incidenceType")
    @Expose
    private Integer incidenceType;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    @Expose
    private String name;

    @SerializedName("phone1")
    @Expose
    private String phone1;

    @SerializedName("phone2")
    @Expose
    private String phone2;

    @SerializedName("region")
    @Expose
    private String region;

    @SerializedName("surName")
    @Expose
    private String surName;

    @SerializedName("town")
    @Expose
    private String town;

    public Integer getIncidenceType() {
        return this.incidenceType;
    }

    public void setIncidenceType(Integer incidenceType) {
        this.incidenceType = incidenceType;
    }

    public String getFile1() {
        return this.file1;
    }

    public void setFile1(String file1) {
        this.file1 = file1;
    }

    public String getFile2() {
        return this.file2;
    }

    public void setFile2(String file2) {
        this.file2 = file2;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return this.surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone1() {
        return this.phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return this.phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCp() {
        return this.cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
