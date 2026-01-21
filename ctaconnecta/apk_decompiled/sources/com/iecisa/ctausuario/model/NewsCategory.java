package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class NewsCategory implements Parcelable {
    public static final Parcelable.Creator<NewsCategory> CREATOR = new Parcelable.Creator<NewsCategory>() { // from class: com.iecisa.ctausuario.model.NewsCategory.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewsCategory createFromParcel(Parcel in) {
            return new NewsCategory(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewsCategory[] newArray(int size) {
            return new NewsCategory[size];
        }
    };

    @SerializedName("id")
    String id;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NewsCategory(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected NewsCategory(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
    }

    public String toString() {
        return this.name;
    }
}
