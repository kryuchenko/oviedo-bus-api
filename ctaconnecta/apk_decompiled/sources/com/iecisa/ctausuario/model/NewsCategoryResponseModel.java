package com.iecisa.ctausuario.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes5.dex */
public class NewsCategoryResponseModel {

    @SerializedName("categories")
    private List<NewsCategory> categories;

    public List<NewsCategory> getCategories() {
        return this.categories;
    }

    public void setCategories(List<NewsCategory> categories) {
        this.categories = categories;
    }
}
