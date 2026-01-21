package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative;

import android.app.Application;
import com.iecisa.ctausuario.data.DoBRepository;
import com.iecisa.ctausuario.data.NewsRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LegalRepresentativeViewModelImpl_Factory implements Factory<LegalRepresentativeViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<DoBRepository> dobRepositoryProvider;
    private final Provider<NewsRepository> newsRepositoryProvider;

    public LegalRepresentativeViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<NewsRepository> newsRepositoryProvider, Provider<DoBRepository> dobRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.newsRepositoryProvider = newsRepositoryProvider;
        this.dobRepositoryProvider = dobRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public LegalRepresentativeViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.newsRepositoryProvider.get(), this.dobRepositoryProvider.get());
    }

    public static LegalRepresentativeViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<NewsRepository> newsRepositoryProvider, Provider<DoBRepository> dobRepositoryProvider) {
        return new LegalRepresentativeViewModelImpl_Factory(applicationProvider, newsRepositoryProvider, dobRepositoryProvider);
    }

    public static LegalRepresentativeViewModelImpl newInstance(Application application, NewsRepository newsRepository, DoBRepository dobRepository) {
        return new LegalRepresentativeViewModelImpl(application, newsRepository, dobRepository);
    }
}
