package com.iecisa.ctausuario.ui.main.incidents;

import android.app.Application;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.data.UserRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class IncidentsViewModelImpl_Factory implements Factory<IncidentsViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NewsRepository> newsRepositoryProvider;
    private final Provider<TransportCardRepository> transportCardRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public IncidentsViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<UserRepository> userRepositoryProvider, Provider<NewsRepository> newsRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.transportCardRepositoryProvider = transportCardRepositoryProvider;
        this.userRepositoryProvider = userRepositoryProvider;
        this.newsRepositoryProvider = newsRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public IncidentsViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.transportCardRepositoryProvider.get(), this.userRepositoryProvider.get(), this.newsRepositoryProvider.get());
    }

    public static IncidentsViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<UserRepository> userRepositoryProvider, Provider<NewsRepository> newsRepositoryProvider) {
        return new IncidentsViewModelImpl_Factory(applicationProvider, transportCardRepositoryProvider, userRepositoryProvider, newsRepositoryProvider);
    }

    public static IncidentsViewModelImpl newInstance(Application application, TransportCardRepository transportCardRepository, UserRepository userRepository, NewsRepository newsRepository) {
        return new IncidentsViewModelImpl(application, transportCardRepository, userRepository, newsRepository);
    }
}
