package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class NewsSection implements Parcelable {
    public static final Parcelable.Creator<NewsSection> CREATOR = new Parcelable.Creator<NewsSection>() { // from class: com.iecisa.ctausuario.model.NewsSection.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewsSection createFromParcel(Parcel in) {
            return new NewsSection(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewsSection[] newArray(int size) {
            return new NewsSection[size];
        }
    };

    @SerializedName("image")
    private String imageSection;

    @SerializedName("shortDescription")
    private String shortDescription;

    @SerializedName("text")
    private String textSection;

    @SerializedName("title")
    private String title;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NewsSection() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getTextSection() {
        return this.textSection;
    }

    public void setTextSection(String textSection) {
        this.textSection = textSection;
    }

    public String getImageSection() {
        return this.imageSection;
    }

    public void setImageSection(String imageSection) {
        this.imageSection = imageSection;
    }

    protected NewsSection(Parcel in) {
        this.title = in.readString();
        this.shortDescription = in.readString();
        this.textSection = in.readString();
        this.imageSection = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.shortDescription);
        dest.writeString(this.textSection);
        dest.writeString(this.imageSection);
    }
}
