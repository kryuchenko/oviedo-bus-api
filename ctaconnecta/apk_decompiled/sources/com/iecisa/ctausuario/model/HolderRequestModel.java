package com.iecisa.ctausuario.model;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class HolderRequestModel implements Serializable {

    @SerializedName(PlaceTypes.ADDRESS)
    @Expose
    private String address;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("holderId")
    @Expose
    private Integer holderId;

    @SerializedName("mobilePhone")
    @Expose
    private String mobilePhone;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("postalCode")
    @Expose
    private String postalCode;

    @SerializedName("province")
    @Expose
    private String province;

    public HolderRequestModel(String email, String phone, String mobilePhone, String address, String postalCode, String city, String province) {
        this.email = email;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.province = province;
    }

    public Integer getHolderId() {
        return this.holderId;
    }

    public void setHolderId(Integer holderId) {
        this.holderId = holderId;
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
}
