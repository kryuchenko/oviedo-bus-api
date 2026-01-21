package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class NewsCta implements Parcelable {
    public static final Parcelable.Creator<NewsCta> CREATOR = new Parcelable.Creator<NewsCta>() { // from class: com.iecisa.ctausuario.model.NewsCta.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewsCta createFromParcel(Parcel in) {
            return new NewsCta(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewsCta[] newArray(int size) {
            return new NewsCta[size];
        }
    };

    @SerializedName("categories")
    private List<NewsCategory> newsCategoriesList;

    @SerializedName("date")
    private String newsDate;

    @SerializedName("id")
    private String newsId;

    @SerializedName("image")
    private String newsImage;

    @SerializedName("shortDescription")
    private String newsSubtitle;

    @SerializedName("title")
    private String newsTitle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NewsCta() {
    }

    public NewsCta(String newsTitle, String newsSubtitle, String newsImage, String newsId, String newsDate) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsSubtitle = newsSubtitle;
        this.newsDate = newsDate;
        this.newsImage = newsImage;
    }

    public String getNewsId() {
        return this.newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return this.newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsSubtitle() {
        return this.newsSubtitle;
    }

    public void setNewsSubtitle(String newsSubtitle) {
        this.newsSubtitle = newsSubtitle;
    }

    public String getNewsDate() {
        return this.newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public List<NewsCategory> getNewsCategoriesList() {
        return this.newsCategoriesList;
    }

    public void setNewsCategoriesList(List<NewsCategory> newsCategoriesList) {
        this.newsCategoriesList = newsCategoriesList;
    }

    public String getNewsImage() {
        return this.newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    protected NewsCta(Parcel in) {
        this.newsId = in.readString();
        this.newsTitle = in.readString();
        this.newsSubtitle = in.readString();
        this.newsDate = in.readString();
        this.newsImage = in.readString();
        if (in.readByte() == 1) {
            ArrayList arrayList = new ArrayList();
            this.newsCategoriesList = arrayList;
            in.readList(arrayList, NewsCategory.class.getClassLoader());
            return;
        }
        this.newsCategoriesList = null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.newsId);
        dest.writeString(this.newsTitle);
        dest.writeString(this.newsSubtitle);
        dest.writeString(this.newsDate);
        dest.writeString(this.newsImage);
        if (this.newsCategoriesList == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeList(this.newsCategoriesList);
        }
    }
}
