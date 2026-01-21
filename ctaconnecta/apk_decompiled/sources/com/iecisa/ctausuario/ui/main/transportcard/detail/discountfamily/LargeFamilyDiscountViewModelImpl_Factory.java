package com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily;

import android.app.Application;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LargeFamilyDiscountViewModelImpl_Factory implements Factory<LargeFamilyDiscountViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NewsRepository> newsRepositoryProvider;
    private final Provider<NfcRepository> nfcRepositoryProvider;
    private final Provider<TransportCardRepository> transportCardRepositoryProvider;

    public LargeFamilyDiscountViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<NfcRepository> nfcRepositoryProvider, Provider<NewsRepository> newsRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.transportCardRepositoryProvider = transportCardRepositoryProvider;
        this.nfcRepositoryProvider = nfcRepositoryProvider;
        this.newsRepositoryProvider = newsRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public LargeFamilyDiscountViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.transportCardRepositoryProvider.get(), this.nfcRepositoryProvider.get(), this.newsRepositoryProvider.get());
    }

    public static LargeFamilyDiscountViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<NfcRepository> nfcRepositoryProvider, Provider<NewsRepository> newsRepositoryProvider) {
        return new LargeFamilyDiscountViewModelImpl_Factory(applicationProvider, transportCardRepositoryProvider, nfcRepositoryProvider, newsRepositoryProvider);
    }

    public static LargeFamilyDiscountViewModelImpl newInstance(Application application, TransportCardRepository transportCardRepository, NfcRepository nfcRepository, NewsRepository newsRepository) {
        return new LargeFamilyDiscountViewModelImpl(application, transportCardRepository, nfcRepository, newsRepository);
    }
}
