package com.iecisa.ctausuario.model.dataprotection;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class CertificateRequestModel implements Serializable {

    @SerializedName("cardNumber")
    @Expose
    private String cardNumber;

    @SerializedName("deliveryMethod")
    @Expose
    private String deliveryMethod;

    @SerializedName("dni")
    @Expose
    private String dni;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("endDate")
    @Expose
    private String endDate;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    @Expose
    private String name;

    @SerializedName("officeId")
    @Expose
    private Integer officeId;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("startDate")
    @Expose
    private String startDate;

    @SerializedName("surname")
    @Expose
    private String surname;

    @SerializedName("userId")
    @Expose
    private String userId;

    public CertificateRequestModel(String userId, String cardNumber, String startDate, String endDate) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CertificateRequestModel(String name, String surname, String dni, String phone, String email, String cardNumber, String startDate, String endDate) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.phone = phone;
        this.email = email;
        this.cardNumber = cardNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getOfficeId() {
        return this.officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeliveryMethod() {
        return this.deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
