package com.iecisa.ctausuario.model.token;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class TokenResponseModel implements Parcelable {
    public static final Parcelable.Creator<TokenResponseModel> CREATOR = new Parcelable.Creator<TokenResponseModel>() { // from class: com.iecisa.ctausuario.model.token.TokenResponseModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TokenResponseModel createFromParcel(Parcel in) {
            return new TokenResponseModel(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TokenResponseModel[] newArray(int size) {
            return new TokenResponseModel[size];
        }
    };

    @SerializedName("token")
    @Expose
    private String token;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected TokenResponseModel(Parcel in) {
        this.token = in.readString();
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.token);
    }
}
