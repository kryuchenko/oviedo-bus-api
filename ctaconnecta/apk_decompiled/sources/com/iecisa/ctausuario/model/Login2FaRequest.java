package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class Login2FaRequest implements Parcelable {
    public static final Parcelable.Creator<Login2FaRequest> CREATOR = new Parcelable.Creator<Login2FaRequest>() { // from class: com.iecisa.ctausuario.model.Login2FaRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Login2FaRequest createFromParcel(Parcel in) {
            return new Login2FaRequest(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Login2FaRequest[] newArray(int size) {
            return new Login2FaRequest[size];
        }
    };

    @SerializedName("code")
    String code;

    @SerializedName("deviceName")
    String deviceName;

    @SerializedName("password")
    String password;

    @SerializedName("userName")
    String userName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Login2FaRequest(String userName, String password, String code) {
        this.userName = userName;
        this.password = password;
        this.deviceName = "Android";
        this.code = code;
    }

    public Login2FaRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.deviceName = "Android";
        this.code = null;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getCode() {
        return this.code;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    protected Login2FaRequest(Parcel in) {
        this.userName = in.readString();
        this.password = in.readString();
        this.deviceName = in.readString();
        this.code = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userName);
        dest.writeString(this.password);
    }
}
