package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: classes5.dex */
public class SearchAddress implements Parcelable {
    public static final Parcelable.Creator<SearchAddress> CREATOR = new Parcelable.Creator<SearchAddress>() { // from class: com.iecisa.ctausuario.model.SearchAddress.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchAddress createFromParcel(Parcel in) {
            return new SearchAddress(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchAddress[] newArray(int size) {
            return new SearchAddress[size];
        }
    };
    String detailAddress;
    Integer idAddress;
    Double latitude;
    Double longitude;
    String nameAddress;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SearchAddress() {
    }

    public SearchAddress(String nameAddress, double longitude, double latitude) {
        this.nameAddress = nameAddress;
        this.longitude = Double.valueOf(longitude);
        this.latitude = Double.valueOf(latitude);
    }

    public SearchAddress(String nameAddress, String detailAddress, Double longitude, Double latitude) {
        this.nameAddress = nameAddress;
        this.detailAddress = detailAddress;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Integer getIdAddress() {
        return this.idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getNameAddress() {
        return this.nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }

    public String getDetailAddress() {
        return this.detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    protected SearchAddress(Parcel in) {
        this.nameAddress = in.readString();
        this.detailAddress = in.readString();
        this.longitude = in.readByte() == 0 ? null : Double.valueOf(in.readDouble());
        this.latitude = in.readByte() != 0 ? Double.valueOf(in.readDouble()) : null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nameAddress);
        dest.writeString(this.detailAddress);
        if (this.longitude == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(this.longitude.doubleValue());
        }
        if (this.latitude == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(this.latitude.doubleValue());
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass()) {
            SearchAddress searchAddress = (SearchAddress) o;
            if (Objects.equals(this.idAddress, searchAddress.idAddress) && Objects.equals(this.nameAddress, searchAddress.nameAddress) && Objects.equals(this.detailAddress, searchAddress.detailAddress) && Objects.equals(this.longitude, searchAddress.longitude) && Objects.equals(this.latitude, searchAddress.latitude)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.idAddress, this.nameAddress, this.detailAddress, this.longitude, this.latitude);
    }
}
