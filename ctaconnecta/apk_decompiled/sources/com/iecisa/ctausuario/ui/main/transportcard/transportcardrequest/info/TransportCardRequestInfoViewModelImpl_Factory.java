package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info;

import android.app.Application;
import com.iecisa.ctausuario.data.DoBRepository;
import com.iecisa.ctausuario.data.NewsRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class TransportCardRequestInfoViewModelImpl_Factory implements Factory<TransportCardRequestInfoViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<DoBRepository> dobRepositoryProvider;
    private final Provider<NewsRepository> newsRepositoryProvider;

    public TransportCardRequestInfoViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<NewsRepository> newsRepositoryProvider, Provider<DoBRepository> dobRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.newsRepositoryProvider = newsRepositoryProvider;
        this.dobRepositoryProvider = dobRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public TransportCardRequestInfoViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.newsRepositoryProvider.get(), this.dobRepositoryProvider.get());
    }

    public static TransportCardRequestInfoViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<NewsRepository> newsRepositoryProvider, Provider<DoBRepository> dobRepositoryProvider) {
        return new TransportCardRequestInfoViewModelImpl_Factory(applicationProvider, newsRepositoryProvider, dobRepositoryProvider);
    }

    public static TransportCardRequestInfoViewModelImpl newInstance(Application application, NewsRepository newsRepository, DoBRepository dobRepository) {
        return new TransportCardRequestInfoViewModelImpl(application, newsRepository, dobRepository);
    }
}
