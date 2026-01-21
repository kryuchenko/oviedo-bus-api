package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class RechargeZones implements Parcelable {
    public static final Parcelable.Creator<RechargeZones> CREATOR = new Parcelable.Creator<RechargeZones>() { // from class: com.iecisa.ctausuario.model.RechargeZones.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RechargeZones createFromParcel(Parcel in) {
            return new RechargeZones(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RechargeZones[] newArray(int size) {
            return new RechargeZones[size];
        }
    };
    private boolean isSelected;

    @SerializedName("rate")
    private Double rate;

    @SerializedName("zone")
    private Integer zone;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RechargeZones(int zone, Double rate) {
        this.zone = Integer.valueOf(zone);
        this.rate = rate;
        this.isSelected = false;
    }

    protected RechargeZones(Parcel in) {
        if (in.readByte() == 0) {
            this.zone = null;
        } else {
            this.zone = Integer.valueOf(in.readInt());
        }
        if (in.readByte() == 0) {
            this.rate = null;
        } else {
            this.rate = Double.valueOf(in.readDouble());
        }
        this.isSelected = in.readByte() != 0;
    }

    public int getZone() {
        return this.zone.intValue();
    }

    public void setZone(int zone) {
        this.zone = Integer.valueOf(zone);
    }

    public Double getRate() {
        return this.rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.zone == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.zone.intValue());
        }
        if (this.rate == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(this.rate.doubleValue());
        }
        parcel.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
    }
}
