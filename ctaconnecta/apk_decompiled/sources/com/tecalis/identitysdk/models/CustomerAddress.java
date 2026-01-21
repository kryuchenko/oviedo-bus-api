package com.tecalis.identitysdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class CustomerAddress implements Parcelable {
    public static final Parcelable.Creator<CustomerAddress> CREATOR = new Parcelable.Creator<CustomerAddress>() { // from class: com.tecalis.identitysdk.models.CustomerAddress.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CustomerAddress createFromParcel(Parcel parcel) {
            return new CustomerAddress(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CustomerAddress[] newArray(int i) {
            return new CustomerAddress[i];
        }
    };
    private String direction;
    private String location;
    private String postal_code;
    private String province;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CustomerAddress() {
        this.direction = "";
        this.location = "";
        this.postal_code = "";
        this.province = "";
    }

    public CustomerAddress(JSONObject jSONObject) {
        this.direction = "";
        this.location = "";
        this.postal_code = "";
        this.province = "";
        try {
            this.direction = jSONObject.getString("direction");
            this.location = jSONObject.getString(FirebaseAnalytics.Param.LOCATION);
            this.postal_code = jSONObject.getString(PlaceTypes.POSTAL_CODE);
            this.province = jSONObject.getString("province");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected CustomerAddress(Parcel parcel) {
        this.direction = "";
        this.location = "";
        this.postal_code = "";
        this.province = "";
        this.direction = parcel.readString();
        this.location = parcel.readString();
        this.postal_code = parcel.readString();
        this.province = parcel.readString();
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public String getPostal_code() {
        return this.postal_code;
    }

    public void setPostal_code(String str) {
        this.postal_code = str;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.direction);
        parcel.writeString(this.location);
        parcel.writeString(this.postal_code);
        parcel.writeString(this.province);
    }

    public String toString() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("direction", this.direction);
            jSONObject.put(FirebaseAnalytics.Param.LOCATION, this.location);
            jSONObject.put(PlaceTypes.POSTAL_CODE, this.postal_code);
            jSONObject.put("province", this.province);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
