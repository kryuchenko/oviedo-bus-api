package com.iecisa.ctausuario.ui.main.more.news.newsdetail;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.NewsDetail;

/* loaded from: classes5.dex */
public interface NewsDetailViewModel {
    LiveData<Resource<NewsDetail>> getNewsDetail(String idNew, Context context);
}
