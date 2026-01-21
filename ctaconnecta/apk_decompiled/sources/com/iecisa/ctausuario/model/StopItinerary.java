package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public class StopItinerary implements Parcelable {
    public static final Parcelable.Creator<StopItinerary> CREATOR = new Parcelable.Creator<StopItinerary>() { // from class: com.iecisa.ctausuario.model.StopItinerary.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StopItinerary createFromParcel(Parcel in) {
            return new StopItinerary(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StopItinerary[] newArray(int size) {
            return new StopItinerary[size];
        }
    };

    @SerializedName("companyName")
    String companyName;

    @SerializedName("directionDesc")
    String directionDesc;

    @SerializedName("directionId")
    Integer directionId;

    @SerializedName("id")
    Integer id;

    @SerializedName("idParada")
    @Expose
    Integer idParada;

    @SerializedName("itineraryDesc")
    String itineraryDesc;

    @SerializedName("itineraryId")
    Integer itineraryId;

    @SerializedName("latitude")
    @Expose
    Double latitude;

    @SerializedName("lineDesc")
    String lineDesc;

    @SerializedName("lineId")
    Integer lineId;

    @SerializedName("longitude")
    @Expose
    Double longitude;

    @Expose
    Marker marker;

    @SerializedName("minutes")
    String minutes;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    String name;

    @SerializedName("nextRealTime")
    @Expose
    String nextRealTime;
    boolean notificationActive;

    @SerializedName("vehicleId")
    @Expose
    Integer vehicleId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public StopItinerary() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getItineraryId() {
        return this.itineraryId;
    }

    public void setItineraryId(Integer itineraryId) {
        this.itineraryId = itineraryId;
    }

    public String getItineraryDesc() {
        return this.itineraryDesc;
    }

    public void setItineraryDesc(String itineraryDesc) {
        this.itineraryDesc = itineraryDesc;
    }

    public Integer getDirectionId() {
        return this.directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    public String getDirectionDesc() {
        return this.directionDesc;
    }

    public void setDirectionDesc(String directionDesc) {
        this.directionDesc = directionDesc;
    }

    public Integer getLineId() {
        return this.lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getLineDesc() {
        return this.lineDesc;
    }

    public void setLineDesc(String lineDesc) {
        this.lineDesc = lineDesc;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMinutes() {
        return this.minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getNextRealTime() {
        return this.nextRealTime;
    }

    public void setNextRealTime(String nextRealTime) {
        this.nextRealTime = nextRealTime;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Marker getMarker() {
        return this.marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public Integer getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setIdParada(Integer idParada) {
        this.idParada = idParada;
    }

    public Integer getIdParada() {
        return this.idParada;
    }

    public static String toJsonFormat(List<StopItinerary> stopItineraryList) {
        return new Gson().toJson(stopItineraryList);
    }

    public static List<StopItinerary> toObjectFormat(String listStopItineraryString) {
        return (List) new Gson().fromJson(listStopItineraryString, new TypeToken<List<StopItinerary>>() { // from class: com.iecisa.ctausuario.model.StopItinerary.1
        }.getType());
    }

    protected StopItinerary(Parcel in) {
        this.id = in.readByte() == 0 ? null : Integer.valueOf(in.readInt());
        this.name = in.readString();
        this.itineraryId = in.readByte() == 0 ? null : Integer.valueOf(in.readInt());
        this.itineraryDesc = in.readString();
        this.directionId = in.readByte() == 0 ? null : Integer.valueOf(in.readInt());
        this.directionDesc = in.readString();
        this.lineId = in.readByte() == 0 ? null : Integer.valueOf(in.readInt());
        this.lineDesc = in.readString();
        this.companyName = in.readString();
        this.nextRealTime = in.readString();
        this.latitude = in.readByte() == 0 ? null : Double.valueOf(in.readDouble());
        this.longitude = in.readByte() == 0 ? null : Double.valueOf(in.readDouble());
        this.vehicleId = in.readByte() == 0 ? null : Integer.valueOf(in.readInt());
        this.idParada = in.readByte() != 0 ? Integer.valueOf(in.readInt()) : null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if (this.id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.id.intValue());
        }
        dest.writeString(this.name);
        if (this.itineraryId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.itineraryId.intValue());
        }
        dest.writeString(this.itineraryDesc);
        if (this.directionId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.directionId.intValue());
        }
        dest.writeString(this.directionDesc);
        if (this.lineId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.lineId.intValue());
        }
        dest.writeString(this.lineDesc);
        dest.writeString(this.companyName);
        dest.writeString(this.nextRealTime);
        if (this.latitude == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(this.latitude.doubleValue());
        }
        if (this.longitude == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(this.longitude.doubleValue());
        }
        if (this.vehicleId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.vehicleId.intValue());
        }
        if (this.idParada == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.idParada.intValue());
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.id.equals(((StopItinerary) o).id);
    }

    public int hashCode() {
        return Objects.hash(this.id);
    }

    public boolean isNotificationActive() {
        return this.notificationActive;
    }

    public void setNotificationActive(boolean notificationActive) {
        this.notificationActive = notificationActive;
    }
}
