package com.iecisa.ctausuario.ui.main.transportcard.detail.certificate;

import android.app.Application;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.data.UserRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CertificateViewModelImpl_Factory implements Factory<CertificateViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NewsRepository> newsRepositoryProvider;
    private final Provider<TransportCardRepository> transportCardRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public CertificateViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<UserRepository> userRepositoryProvider, Provider<NewsRepository> newsRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.transportCardRepositoryProvider = transportCardRepositoryProvider;
        this.userRepositoryProvider = userRepositoryProvider;
        this.newsRepositoryProvider = newsRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public CertificateViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.transportCardRepositoryProvider.get(), this.userRepositoryProvider.get(), this.newsRepositoryProvider.get());
    }

    public static CertificateViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<UserRepository> userRepositoryProvider, Provider<NewsRepository> newsRepositoryProvider) {
        return new CertificateViewModelImpl_Factory(applicationProvider, transportCardRepositoryProvider, userRepositoryProvider, newsRepositoryProvider);
    }

    public static CertificateViewModelImpl newInstance(Application application, TransportCardRepository transportCardRepository, UserRepository userRepository, NewsRepository newsRepository) {
        return new CertificateViewModelImpl(application, transportCardRepository, userRepository, newsRepository);
    }
}
