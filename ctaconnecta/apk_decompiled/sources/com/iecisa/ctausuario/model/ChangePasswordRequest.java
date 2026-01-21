package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class ChangePasswordRequest implements Parcelable {
    public static final Parcelable.Creator<ChangePasswordRequest> CREATOR = new Parcelable.Creator<ChangePasswordRequest>() { // from class: com.iecisa.ctausuario.model.ChangePasswordRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChangePasswordRequest createFromParcel(Parcel in) {
            return new ChangePasswordRequest(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChangePasswordRequest[] newArray(int size) {
            return new ChangePasswordRequest[size];
        }
    };

    @SerializedName("oldPassword")
    String actualPassword;

    @SerializedName("application")
    Integer application;

    @SerializedName("newPassword")
    String password;

    @SerializedName("userName")
    String userName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ChangePasswordRequest(String userName, String actualPassword, String password, int application) {
        this.userName = userName;
        this.actualPassword = actualPassword;
        this.password = password;
        this.application = Integer.valueOf(application);
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

    public Integer getApplication() {
        return this.application;
    }

    public void setApplication(Integer application) {
        this.application = application;
    }

    protected ChangePasswordRequest(Parcel in) {
        this.userName = in.readString();
        this.password = in.readString();
        this.application = Integer.valueOf(in.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userName);
        dest.writeString(this.password);
        if (this.application == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.application.intValue());
        }
    }
}
