package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class SearchStop implements Parcelable {
    public static final Parcelable.Creator<SearchStop> CREATOR = new Parcelable.Creator<SearchStop>() { // from class: com.iecisa.ctausuario.model.SearchStop.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchStop createFromParcel(Parcel in) {
            return new SearchStop(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchStop[] newArray(int size) {
            return new SearchStop[size];
        }
    };

    @SerializedName("id")
    Integer idStop;

    @SerializedName("latitude")
    double latitude;

    @SerializedName("itineraries")
    List<StopItinerary> listStopItinerary;

    @SerializedName("longitude")
    double longitude;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    String nameStop;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SearchStop() {
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Integer getIdStop() {
        return this.idStop;
    }

    public void setIdStop(Integer idStop) {
        this.idStop = idStop;
    }

    public String getNameStop() {
        return this.nameStop;
    }

    public void setNameStop(String nameStop) {
        this.nameStop = nameStop;
    }

    public List<StopItinerary> getListStopItinerary() {
        return this.listStopItinerary;
    }

    public void setListStopItinerary(List<StopItinerary> listStopItinerary) {
        this.listStopItinerary = listStopItinerary;
    }

    protected SearchStop(Parcel in) {
        this.longitude = in.readDouble();
        this.latitude = in.readDouble();
        this.idStop = in.readByte() == 0 ? null : Integer.valueOf(in.readInt());
        this.nameStop = in.readString();
        if (in.readByte() == 1) {
            ArrayList arrayList = new ArrayList();
            this.listStopItinerary = arrayList;
            in.readList(arrayList, StopItinerary.class.getClassLoader());
            return;
        }
        this.listStopItinerary = null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.longitude);
        dest.writeDouble(this.latitude);
        if (this.idStop == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.idStop.intValue());
        }
        dest.writeString(this.nameStop);
        if (this.listStopItinerary == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeList(this.listStopItinerary);
        }
    }
}
