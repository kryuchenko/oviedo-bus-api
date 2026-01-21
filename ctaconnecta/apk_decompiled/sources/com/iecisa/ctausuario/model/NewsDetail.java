package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class NewsDetail implements Parcelable {
    public static final Parcelable.Creator<NewsDetail> CREATOR = new Parcelable.Creator<NewsDetail>() { // from class: com.iecisa.ctausuario.model.NewsDetail.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewsDetail createFromParcel(Parcel in) {
            return new NewsDetail(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewsDetail[] newArray(int size) {
            return new NewsDetail[size];
        }
    };

    @SerializedName("categories")
    List<NewsCategory> categoryNew;

    @SerializedName("date")
    String dateNewDetail;

    @SerializedName("id")
    String idNewDetail;

    @SerializedName("image")
    String imageNewDetail;

    @SerializedName("sections")
    List<NewsSection> sectionsNew;

    @SerializedName("shortDescription")
    String shortDescriptionNewDetail;

    @SerializedName("title")
    String titleNewDetail;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NewsDetail() {
    }

    public NewsDetail(String titleNew, String subtitleNew, String imageNew, String idNew, String dateNew) {
        this.idNewDetail = idNew;
        this.titleNewDetail = titleNew;
        this.shortDescriptionNewDetail = subtitleNew;
        this.dateNewDetail = dateNew;
        this.imageNewDetail = imageNew;
    }

    public String getIdNewDetail() {
        return this.idNewDetail;
    }

    public void setIdNewDetail(String idNewDetail) {
        this.idNewDetail = idNewDetail;
    }

    public String getTitleNewDetail() {
        return this.titleNewDetail;
    }

    public void setTitleNewDetail(String titleNewDetail) {
        this.titleNewDetail = titleNewDetail;
    }

    public String getShortDescriptionNewDetail() {
        return this.shortDescriptionNewDetail;
    }

    public void setShortDescriptionNewDetail(String shortDescriptionNewDetail) {
        this.shortDescriptionNewDetail = shortDescriptionNewDetail;
    }

    public String getImageNewDetail() {
        return this.imageNewDetail;
    }

    public void setImageNewDetail(String imageNewDetail) {
        this.imageNewDetail = imageNewDetail;
    }

    public String getDateNewDetail() {
        return this.dateNewDetail;
    }

    public void setDateNewDetail(String dateNewDetail) {
        this.dateNewDetail = dateNewDetail;
    }

    public List<NewsCategory> getCategoryNew() {
        return this.categoryNew;
    }

    public void setCategoryNew(List<NewsCategory> categoryNew) {
        this.categoryNew = categoryNew;
    }

    public List<NewsSection> getSectionsNew() {
        return this.sectionsNew;
    }

    public void setSectionsNew(List<NewsSection> sectionsNew) {
        this.sectionsNew = sectionsNew;
    }

    protected NewsDetail(Parcel in) {
        this.idNewDetail = in.readString();
        this.titleNewDetail = in.readString();
        this.shortDescriptionNewDetail = in.readString();
        this.imageNewDetail = in.readString();
        this.dateNewDetail = in.readString();
        if (in.readByte() == 1) {
            ArrayList arrayList = new ArrayList();
            this.categoryNew = arrayList;
            in.readList(arrayList, NewsCategory.class.getClassLoader());
        } else {
            this.categoryNew = null;
        }
        if (in.readByte() == 1) {
            ArrayList arrayList2 = new ArrayList();
            this.sectionsNew = arrayList2;
            in.readList(arrayList2, NewsSection.class.getClassLoader());
            return;
        }
        this.sectionsNew = null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.idNewDetail);
        dest.writeString(this.titleNewDetail);
        dest.writeString(this.shortDescriptionNewDetail);
        dest.writeString(this.imageNewDetail);
        dest.writeString(this.dateNewDetail);
        if (this.categoryNew == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeList(this.categoryNew);
        }
        if (this.sectionsNew == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeList(this.sectionsNew);
        }
    }
}
