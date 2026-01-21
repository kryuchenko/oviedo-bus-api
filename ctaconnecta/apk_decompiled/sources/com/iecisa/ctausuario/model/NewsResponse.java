package com.iecisa.ctausuario.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class NewsResponse implements Parcelable {
    public static final Parcelable.Creator<NewsResponse> CREATOR = new Parcelable.Creator<NewsResponse>() { // from class: com.iecisa.ctausuario.model.NewsResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewsResponse createFromParcel(Parcel in) {
            return new NewsResponse(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewsResponse[] newArray(int size) {
            return new NewsResponse[size];
        }
    };

    @SerializedName(FirebaseAnalytics.Param.ITEMS)
    List<NewsCta> listNews;

    @SerializedName("page")
    Integer page;

    @SerializedName("total")
    Integer total;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NewsResponse() {
    }

    public List<NewsCta> getListNews() {
        return this.listNews;
    }

    public void setListNews(List<NewsCta> listNews) {
        this.listNews = listNews;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    protected NewsResponse(Parcel in) {
        if (in.readByte() == 1) {
            ArrayList arrayList = new ArrayList();
            this.listNews = arrayList;
            in.readList(arrayList, NewsCta.class.getClassLoader());
        } else {
            this.listNews = null;
        }
        this.page = in.readByte() == 0 ? null : Integer.valueOf(in.readInt());
        this.total = in.readByte() != 0 ? Integer.valueOf(in.readInt()) : null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if (this.listNews == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeList(this.listNews);
        }
        if (this.page == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.page.intValue());
        }
        if (this.total == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.total.intValue());
        }
    }
}
