package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class LoginUserCard implements Parcelable {
    public static final Parcelable.Creator<LoginUserCard> CREATOR = new Parcelable.Creator<LoginUserCard>() { // from class: com.iecisa.ctausuario.model.LoginUserCard.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginUserCard createFromParcel(Parcel in) {
            return new LoginUserCard(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginUserCard[] newArray(int size) {
            return new LoginUserCard[size];
        }
    };
    Integer idUserCard;
    String mailUserCard;
    String pwdUserCard;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LoginUserCard() {
    }

    public LoginUserCard(String mailUserCard, String pwdUserCard) {
        this.mailUserCard = mailUserCard;
        this.pwdUserCard = pwdUserCard;
    }

    public Integer getIdUserCard() {
        return this.idUserCard;
    }

    public void setIdUserCard(Integer idUserCard) {
        this.idUserCard = idUserCard;
    }

    public String getMailUserCard() {
        return this.mailUserCard;
    }

    public void setMailUserCard(String mailUserCard) {
        this.mailUserCard = mailUserCard;
    }

    public String getPwdUserCard() {
        return this.pwdUserCard;
    }

    public void setPwdUserCard(String pwdUserCard) {
        this.pwdUserCard = pwdUserCard;
    }

    protected LoginUserCard(Parcel in) {
        this.mailUserCard = in.readString();
        this.pwdUserCard = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mailUserCard);
        dest.writeString(this.pwdUserCard);
    }
}
