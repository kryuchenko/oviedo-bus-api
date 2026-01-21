package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class AddCardRequestModel implements Parcelable {
    public static final Parcelable.Creator<AddCardRequestModel> CREATOR = new Parcelable.Creator<AddCardRequestModel>() { // from class: com.iecisa.ctausuario.model.AddCardRequestModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddCardRequestModel createFromParcel(Parcel in) {
            return new AddCardRequestModel(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddCardRequestModel[] newArray(int size) {
            return new AddCardRequestModel[size];
        }
    };

    @SerializedName("alias")
    @Expose
    private String alias;

    @SerializedName("numChip")
    @Expose
    private String numChip;

    @SerializedName("numChipControl")
    @Expose
    private String numChipControl;

    @SerializedName("verificationCode")
    @Expose
    private String verificationCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AddCardRequestModel(String numChip, String verificationCode, String alias, String numChipControl) {
        this.numChip = numChip;
        this.verificationCode = verificationCode;
        this.alias = alias;
        this.numChipControl = numChipControl;
    }

    protected AddCardRequestModel(Parcel in) {
        this.numChip = in.readString();
        this.verificationCode = in.readString();
        this.alias = in.readString();
    }

    public String getNumChip() {
        return this.numChip;
    }

    public void setNumChip(String numChip) {
        this.numChip = numChip;
    }

    public String getVerificationCode() {
        return this.verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.numChip);
        dest.writeString(this.verificationCode);
        dest.writeString(this.alias);
    }
}
