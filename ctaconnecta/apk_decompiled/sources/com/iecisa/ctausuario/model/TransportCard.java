package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;

/* loaded from: classes5.dex */
public class TransportCard implements Parcelable {
    public static final Parcelable.Creator<TransportCard> CREATOR = new Parcelable.Creator<TransportCard>() { // from class: com.iecisa.ctausuario.model.TransportCard.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TransportCard createFromParcel(Parcel in) {
            return new TransportCard(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TransportCard[] newArray(int size) {
            return new TransportCard[size];
        }
    };
    private Integer idCard;
    private String idFavouriteTrasnportCard;

    @Expose
    boolean isFavourite;
    private String nameFavouriteTransportCard;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TransportCard(String idFavouriteTrasnportCard, String nameFavouriteTransportCard) {
        this.idFavouriteTrasnportCard = idFavouriteTrasnportCard;
        this.nameFavouriteTransportCard = nameFavouriteTransportCard;
    }

    public TransportCard() {
    }

    public Integer getIdCard() {
        return this.idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public String getIdFavouriteTrasnportCard() {
        return this.idFavouriteTrasnportCard;
    }

    public void setIdFavouriteTrasnportCard(String idFavouriteTrasnportCard) {
        this.idFavouriteTrasnportCard = idFavouriteTrasnportCard;
    }

    public String getNameFavouriteTransportCard() {
        return this.nameFavouriteTransportCard;
    }

    public void setNameFavouriteTransportCard(String nameFavouriteTransportCard) {
        this.nameFavouriteTransportCard = nameFavouriteTransportCard;
    }

    public boolean isFavourite() {
        return this.isFavourite;
    }

    public void setFavourite(boolean favourite) {
        this.isFavourite = favourite;
    }

    protected TransportCard(Parcel in) {
        this.idCard = in.readByte() == 0 ? null : Integer.valueOf(in.readInt());
        this.idFavouriteTrasnportCard = in.readString();
        this.nameFavouriteTransportCard = in.readString();
        this.isFavourite = in.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.idCard == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.idCard.intValue());
        }
        parcel.writeString(this.idFavouriteTrasnportCard);
        parcel.writeString(this.nameFavouriteTransportCard);
        parcel.writeByte(this.isFavourite ? (byte) 1 : (byte) 0);
    }
}
