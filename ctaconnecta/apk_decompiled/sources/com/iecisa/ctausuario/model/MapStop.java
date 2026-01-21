package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.maps.android.clustering.ClusterItem;
import java.util.Objects;

/* loaded from: classes5.dex */
public class MapStop implements Parcelable, ClusterItem {
    public static final Parcelable.Creator<MapStop> CREATOR = new Parcelable.Creator<MapStop>() { // from class: com.iecisa.ctausuario.model.MapStop.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapStop createFromParcel(Parcel in) {
            return new MapStop(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapStop[] newArray(int size) {
            return new MapStop[size];
        }
    };

    @SerializedName("id")
    Integer idStop;

    @Expose
    boolean isFavourite;

    @SerializedName("latitude")
    double latitude;

    @SerializedName("longitude")
    double longitude;

    @Expose
    Marker marker;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    String nameStop;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.maps.android.clustering.ClusterItem
    public String getTitle() {
        return null;
    }

    public MapStop(Integer idStop, String nameStop) {
        this.idStop = idStop;
        this.nameStop = nameStop;
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

    public void setLocation(LatLng location) {
        this.latitude = location.latitude;
        this.longitude = location.longitude;
    }

    public LatLng getLocation() {
        return new LatLng(this.latitude, this.longitude);
    }

    public Marker getMarker() {
        return this.marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public boolean isFavourite() {
        return this.isFavourite;
    }

    public void setFavourite(boolean favourite) {
        this.isFavourite = favourite;
    }

    protected MapStop(Parcel in) {
        this.longitude = in.readDouble();
        this.latitude = in.readDouble();
        this.idStop = in.readByte() == 0 ? null : Integer.valueOf(in.readInt());
        this.nameStop = in.readString();
        this.isFavourite = in.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
        if (this.idStop == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.idStop.intValue());
        }
        parcel.writeString(this.nameStop);
        parcel.writeByte(this.isFavourite ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.maps.android.clustering.ClusterItem
    public LatLng getPosition() {
        return new LatLng(this.latitude, this.longitude);
    }

    @Override // com.google.maps.android.clustering.ClusterItem
    public String getSnippet() {
        return this.nameStop;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return Objects.equals(this.idStop, ((MapStop) o).idStop);
    }

    public int hashCode() {
        return Objects.hash(this.idStop);
    }

    public boolean isClusterable() {
        return this.idStop.intValue() > 0;
    }
}
