package com.iecisa.ctausuario.ui.main.more.news.newsdetail;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.model.NewsDetail;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class NewsDetailViewModelImpl extends BaseViewModel implements NewsDetailViewModel {
    private NewsRepository newsRepository;

    @Inject
    public NewsDetailViewModelImpl(Application application, NewsRepository newsRepository) {
        super(application);
        this.newsRepository = newsRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.more.news.newsdetail.NewsDetailViewModel
    public LiveData<Resource<NewsDetail>> getNewsDetail(String idNew, Context context) {
        return this.newsRepository.getNewsDetail(idNew, context);
    }
}
