package com.tecalis.identitysdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.PlaceTypes;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class Customer implements Parcelable {
    public static final Parcelable.Creator<Customer> CREATOR = new Parcelable.Creator<Customer>() { // from class: com.tecalis.identitysdk.models.Customer.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Customer createFromParcel(Parcel parcel) {
            return new Customer(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Customer[] newArray(int i) {
            return new Customer[i];
        }
    };
    private CustomerAddress address;
    private String b_day;
    private String b_month;
    private String b_year;
    private String country_code;
    private String doc_type;
    private String exp_day;
    private String exp_month;
    private String exp_year;
    private String gender;
    private String identifier;
    private String n1;
    private String n2;
    private String n3;
    private String n4;
    private String nationality;
    private String sn1;
    private String sn2;
    private String sn3;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Customer() {
        this.doc_type = "";
        this.identifier = "";
        this.country_code = "ESP";
        this.b_year = "";
        this.b_month = "";
        this.b_day = "";
        this.gender = "";
        this.exp_year = "";
        this.exp_month = "";
        this.exp_day = "";
        this.nationality = "";
        this.sn1 = "";
        this.sn2 = "";
        this.sn3 = "";
        this.n1 = "";
        this.n2 = "";
        this.n3 = "";
        this.n4 = "";
    }

    public Customer(JSONObject jSONObject) {
        this.doc_type = "";
        this.identifier = "";
        this.country_code = "ESP";
        this.b_year = "";
        this.b_month = "";
        this.b_day = "";
        this.gender = "";
        this.exp_year = "";
        this.exp_month = "";
        this.exp_day = "";
        this.nationality = "";
        this.sn1 = "";
        this.sn2 = "";
        this.sn3 = "";
        this.n1 = "";
        this.n2 = "";
        this.n3 = "";
        this.n4 = "";
        this.doc_type = jSONObject.optString("doc_type");
        this.identifier = jSONObject.optString("identifier");
        this.country_code = jSONObject.optString("country_code");
        this.b_year = jSONObject.optString("b_year");
        this.b_month = jSONObject.optString("b_month");
        this.b_day = jSONObject.optString("b_day");
        this.gender = jSONObject.optString("gender");
        this.exp_year = jSONObject.optString("exp_year");
        this.exp_month = jSONObject.optString("exp_month");
        this.exp_day = jSONObject.optString("exp_day");
        this.nationality = jSONObject.optString("nationality");
        this.sn1 = jSONObject.optString("sn1");
        this.sn2 = jSONObject.optString("sn2");
        this.sn3 = jSONObject.optString("sn3");
        this.n1 = jSONObject.optString("n1");
        this.n2 = jSONObject.optString("n2");
        this.n3 = jSONObject.optString("n3");
        this.n4 = jSONObject.optString("n4");
        this.address = new CustomerAddress((JSONObject) Objects.requireNonNull(jSONObject.optJSONObject(PlaceTypes.ADDRESS)));
    }

    protected Customer(Parcel parcel) {
        this.doc_type = "";
        this.identifier = "";
        this.country_code = "ESP";
        this.b_year = "";
        this.b_month = "";
        this.b_day = "";
        this.gender = "";
        this.exp_year = "";
        this.exp_month = "";
        this.exp_day = "";
        this.nationality = "";
        this.sn1 = "";
        this.sn2 = "";
        this.sn3 = "";
        this.n1 = "";
        this.n2 = "";
        this.n3 = "";
        this.n4 = "";
        this.doc_type = parcel.readString();
        this.identifier = parcel.readString();
        this.country_code = parcel.readString();
        this.b_year = parcel.readString();
        this.b_month = parcel.readString();
        this.b_day = parcel.readString();
        this.gender = parcel.readString();
        this.exp_year = parcel.readString();
        this.exp_month = parcel.readString();
        this.exp_day = parcel.readString();
        this.nationality = parcel.readString();
        this.sn1 = parcel.readString();
        this.sn2 = parcel.readString();
        this.sn3 = parcel.readString();
        this.n1 = parcel.readString();
        this.n2 = parcel.readString();
        this.n3 = parcel.readString();
        this.n4 = parcel.readString();
        this.address = (CustomerAddress) parcel.readParcelable(CustomerAddress.class.getClassLoader());
    }

    public String getDoc_type() {
        return this.doc_type;
    }

    public void setDoc_type(String str) {
        this.doc_type = str;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public String getCountry_code() {
        return this.country_code;
    }

    public void setCountry_code(String str) {
        this.country_code = str;
    }

    public String getB_year() {
        return this.b_year;
    }

    public void setB_year(String str) {
        this.b_year = str;
    }

    public String getB_month() {
        return this.b_month;
    }

    public void setB_month(String str) {
        this.b_month = str;
    }

    public String getB_day() {
        return this.b_day;
    }

    public void setB_day(String str) {
        this.b_day = str;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public String getExp_year() {
        return this.exp_year;
    }

    public void setExp_year(String str) {
        this.exp_year = str;
    }

    public String getExp_month() {
        return this.exp_month;
    }

    public void setExp_month(String str) {
        this.exp_month = str;
    }

    public String getExp_day() {
        return this.exp_day;
    }

    public void setExp_day(String str) {
        this.exp_day = str;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String str) {
        this.nationality = str;
    }

    public String getSn1() {
        return this.sn1;
    }

    public void setSn1(String str) {
        this.sn1 = str;
    }

    public String getSn2() {
        return this.sn2;
    }

    public void setSn2(String str) {
        this.sn2 = str;
    }

    public String getSn3() {
        return this.sn3;
    }

    public void setSn3(String str) {
        this.sn3 = str;
    }

    public String getN1() {
        return this.n1;
    }

    public void setN1(String str) {
        this.n1 = str;
    }

    public String getN2() {
        return this.n2;
    }

    public void setN2(String str) {
        this.n2 = str;
    }

    public String getN3() {
        return this.n3;
    }

    public void setN3(String str) {
        this.n3 = str;
    }

    public String getN4() {
        return this.n4;
    }

    public void setN4(String str) {
        this.n4 = str;
    }

    public CustomerAddress getAddress() {
        return this.address;
    }

    public void setAddress(CustomerAddress customerAddress) {
        this.address = customerAddress;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.doc_type);
        parcel.writeString(this.identifier);
        parcel.writeString(this.country_code);
        parcel.writeString(this.b_year);
        parcel.writeString(this.b_month);
        parcel.writeString(this.b_day);
        parcel.writeString(this.gender);
        parcel.writeString(this.exp_year);
        parcel.writeString(this.exp_month);
        parcel.writeString(this.exp_day);
        parcel.writeString(this.nationality);
        parcel.writeString(this.sn1);
        parcel.writeString(this.sn2);
        parcel.writeString(this.sn3);
        parcel.writeString(this.n1);
        parcel.writeString(this.n2);
        parcel.writeString(this.n3);
        parcel.writeString(this.n4);
        parcel.writeParcelable(this.address, 0);
    }

    public static Customer getEmptyInstance() {
        CustomerAddress customerAddress = new CustomerAddress();
        Customer customer = new Customer();
        customerAddress.setDirection("");
        customerAddress.setLocation("");
        customerAddress.setProvince("");
        customerAddress.setPostal_code("");
        customer.doc_type = "";
        customer.identifier = "";
        customer.country_code = "";
        customer.b_year = "";
        customer.b_month = "";
        customer.b_day = "";
        customer.gender = "";
        customer.exp_year = "";
        customer.exp_month = "";
        customer.exp_day = "";
        customer.nationality = "";
        customer.sn1 = "";
        customer.sn2 = "";
        customer.sn3 = "";
        customer.n1 = "";
        customer.n2 = "";
        customer.n3 = "";
        customer.n4 = "";
        customer.address = customerAddress;
        return customer;
    }

    public String toString() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("doc_type", this.doc_type);
            jSONObject.put("identifier", this.identifier);
            jSONObject.put("country_code", this.country_code);
            jSONObject.put("b_year", this.b_year);
            jSONObject.put("b_month", this.b_month);
            jSONObject.put("b_day", this.b_day);
            jSONObject.put("gender", this.gender);
            jSONObject.put("exp_year", this.exp_year);
            jSONObject.put("exp_month", this.exp_month);
            jSONObject.put("exp_day", this.exp_day);
            jSONObject.put("nationality", this.nationality);
            jSONObject.put("sn1", this.sn1);
            jSONObject.put("sn2", this.sn2);
            jSONObject.put("sn3", this.sn3);
            jSONObject.put("n1", this.n1);
            jSONObject.put("n2", this.n2);
            jSONObject.put("n3", this.n3);
            jSONObject.put("n4", this.n4);
            jSONObject.put(PlaceTypes.ADDRESS, this.address);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
