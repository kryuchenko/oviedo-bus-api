package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class StopTime implements Parcelable {
    public static final Parcelable.Creator<StopTime> CREATOR = new Parcelable.Creator<StopTime>() { // from class: com.iecisa.ctausuario.model.StopTime.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StopTime createFromParcel(Parcel in) {
            return new StopTime(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StopTime[] newArray(int size) {
            return new StopTime[size];
        }
    };

    @SerializedName("id")
    Integer id;

    @SerializedName("stopTime")
    String stopTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public StopTime() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStopTime() {
        return this.stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    protected StopTime(Parcel in) {
        this.id = in.readByte() == 0 ? null : Integer.valueOf(in.readInt());
        this.stopTime = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if (this.id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.id.intValue());
        }
        dest.writeString(this.stopTime);
    }
}
