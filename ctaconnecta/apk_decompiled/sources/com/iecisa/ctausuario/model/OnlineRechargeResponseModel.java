package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class OnlineRechargeResponseModel implements Parcelable {
    public static final Parcelable.Creator<OnlineRechargeResponseModel> CREATOR = new Parcelable.Creator<OnlineRechargeResponseModel>() { // from class: com.iecisa.ctausuario.model.OnlineRechargeResponseModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OnlineRechargeResponseModel createFromParcel(Parcel in) {
            return new OnlineRechargeResponseModel(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OnlineRechargeResponseModel[] newArray(int size) {
            return new OnlineRechargeResponseModel[size];
        }
    };

    @SerializedName("ds_MerchantParameters")
    @Expose
    private String dsMerchantParameters;

    @SerializedName("ds_Signature")
    @Expose
    private String dsSignature;

    @SerializedName("ds_SignatureVersion")
    @Expose
    private String dsSignatureVersion;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDsSignatureVersion() {
        return this.dsSignatureVersion;
    }

    public void setDsSignatureVersion(String dsSignatureVersion) {
        this.dsSignatureVersion = dsSignatureVersion;
    }

    public String getDsMerchantParameters() {
        return this.dsMerchantParameters;
    }

    public void setDsMerchantParameters(String dsMerchantParameters) {
        this.dsMerchantParameters = dsMerchantParameters;
    }

    public String getDsSignature() {
        return this.dsSignature;
    }

    public void setDsSignature(String dsSignature) {
        this.dsSignature = dsSignature;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.dsSignatureVersion);
        dest.writeString(this.dsMerchantParameters);
        dest.writeString(this.dsSignature);
    }

    protected OnlineRechargeResponseModel(Parcel in) {
        this.dsSignatureVersion = in.readString();
        this.dsMerchantParameters = in.readString();
        this.dsSignature = in.readString();
    }
}
