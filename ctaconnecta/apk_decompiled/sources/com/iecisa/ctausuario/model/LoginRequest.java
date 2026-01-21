package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class LoginRequest implements Parcelable {
    public static final Parcelable.Creator<LoginRequest> CREATOR = new Parcelable.Creator<LoginRequest>() { // from class: com.iecisa.ctausuario.model.LoginRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginRequest createFromParcel(Parcel in) {
            return new LoginRequest(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginRequest[] newArray(int size) {
            return new LoginRequest[size];
        }
    };

    @SerializedName("password")
    String password;

    @SerializedName("userName")
    String userName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
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

    protected LoginRequest(Parcel in) {
        this.userName = in.readString();
        this.password = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userName);
        dest.writeString(this.password);
    }
}
