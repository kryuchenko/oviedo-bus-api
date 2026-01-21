package com.iecisa.ctausuario.ui.main.more.news;

import android.app.Application;
import com.iecisa.ctausuario.data.NewsRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NewsViewModelImpl_Factory implements Factory<NewsViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NewsRepository> newsRepositoryProvider;

    public NewsViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<NewsRepository> newsRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.newsRepositoryProvider = newsRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public NewsViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.newsRepositoryProvider.get());
    }

    public static NewsViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<NewsRepository> newsRepositoryProvider) {
        return new NewsViewModelImpl_Factory(applicationProvider, newsRepositoryProvider);
    }

    public static NewsViewModelImpl newInstance(Application application, NewsRepository newsRepository) {
        return new NewsViewModelImpl(application, newsRepository);
    }
}
