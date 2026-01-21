package com.iecisa.ctausuario.ui.main.more.news.newsdetail;

import android.app.Application;
import com.iecisa.ctausuario.data.NewsRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NewsDetailViewModelImpl_Factory implements Factory<NewsDetailViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NewsRepository> newsRepositoryProvider;

    public NewsDetailViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<NewsRepository> newsRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.newsRepositoryProvider = newsRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public NewsDetailViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.newsRepositoryProvider.get());
    }

    public static NewsDetailViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<NewsRepository> newsRepositoryProvider) {
        return new NewsDetailViewModelImpl_Factory(applicationProvider, newsRepositoryProvider);
    }

    public static NewsDetailViewModelImpl newInstance(Application application, NewsRepository newsRepository) {
        return new NewsDetailViewModelImpl(application, newsRepository);
    }
}
