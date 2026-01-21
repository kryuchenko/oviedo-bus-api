package com.iecisa.ctausuario.ui.main;

import android.app.Application;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.UserRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class BaseTransportCardViewModelImpl_Factory implements Factory<BaseTransportCardViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NewsRepository> newsRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public BaseTransportCardViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<UserRepository> userRepositoryProvider, Provider<NewsRepository> newsRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.userRepositoryProvider = userRepositoryProvider;
        this.newsRepositoryProvider = newsRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public BaseTransportCardViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.userRepositoryProvider.get(), this.newsRepositoryProvider.get());
    }

    public static BaseTransportCardViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<UserRepository> userRepositoryProvider, Provider<NewsRepository> newsRepositoryProvider) {
        return new BaseTransportCardViewModelImpl_Factory(applicationProvider, userRepositoryProvider, newsRepositoryProvider);
    }

    public static BaseTransportCardViewModelImpl newInstance(Application application, UserRepository userRepository, NewsRepository newsRepository) {
        return new BaseTransportCardViewModelImpl(application, userRepository, newsRepository);
    }
}
