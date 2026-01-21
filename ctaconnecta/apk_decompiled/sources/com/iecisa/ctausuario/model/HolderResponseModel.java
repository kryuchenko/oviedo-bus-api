package com.iecisa.ctausuario.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class HolderResponseModel implements Serializable {

    @SerializedName(PlaceTypes.ADDRESS)
    @Expose
    private String address;

    @SerializedName("birthDate")
    @Expose
    private String birthDate;

    @SerializedName("cardExpirationDate")
    @Expose
    private String cardExpirationDate;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("dni")
    @Expose
    private String dni;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("mobilePhone")
    @Expose
    private String mobilePhone;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    @Expose
    private String name;

    @SerializedName("pan")
    @Expose
    private String pan;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("photo")
    @Expose
    private String photo;

    @SerializedName("postalCode")
    @Expose
    private String postalCode;

    @SerializedName("province")
    @Expose
    private String province;

    @SerializedName("surname")
    @Expose
    private String surname;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPan() {
        return this.pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getCardExpirationDate() {
        return this.cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
