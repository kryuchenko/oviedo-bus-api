package com.iecisa.ctausuario.ui.main.more.news;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.NewsCategoryResponseModel;
import com.iecisa.ctausuario.model.NewsResponse;

/* loaded from: classes5.dex */
public interface NewsViewModel {
    LiveData<Resource<NewsCategoryResponseModel>> getCategories(Context context);

    LiveData<Resource<NewsResponse>> getNewsList(int page, Context context, String category);
}
