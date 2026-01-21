package com.iecisa.ctausuario.ui.main.more.news;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.model.NewsCategoryResponseModel;
import com.iecisa.ctausuario.model.NewsResponse;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class NewsViewModelImpl extends BaseViewModel implements NewsViewModel {
    private NewsRepository newsRepository;

    @Inject
    public NewsViewModelImpl(Application application, NewsRepository newsRepository) {
        super(application);
        this.newsRepository = newsRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.more.news.NewsViewModel
    public LiveData<Resource<NewsResponse>> getNewsList(int page, Context context, String category) {
        return this.newsRepository.getNewsList(page, context, category);
    }

    @Override // com.iecisa.ctausuario.ui.main.more.news.NewsViewModel
    public LiveData<Resource<NewsCategoryResponseModel>> getCategories(Context context) {
        return this.newsRepository.getCategories(context);
    }
}
