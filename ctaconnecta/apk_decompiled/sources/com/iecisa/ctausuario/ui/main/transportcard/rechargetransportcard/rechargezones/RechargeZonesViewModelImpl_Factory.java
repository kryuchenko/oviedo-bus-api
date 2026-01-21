package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones;

import android.app.Application;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.PaymentCardRepository;
import com.iecisa.ctausuario.data.RechargeRepository;
import com.iecisa.ctausuario.data.RtmRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RechargeZonesViewModelImpl_Factory implements Factory<RechargeZonesViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NewsRepository> newsRepositoryProvider;
    private final Provider<NfcRepository> nfcRepositoryProvider;
    private final Provider<PaymentCardRepository> paymentCardRepositoryProvider;
    private final Provider<RechargeRepository> rechargeRepositoryProvider;
    private final Provider<RtmRepository> rtmRepositoryProvider;

    public RechargeZonesViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<RechargeRepository> rechargeRepositoryProvider, Provider<PaymentCardRepository> paymentCardRepositoryProvider, Provider<RtmRepository> rtmRepositoryProvider, Provider<NfcRepository> nfcRepositoryProvider, Provider<NewsRepository> newsRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.rechargeRepositoryProvider = rechargeRepositoryProvider;
        this.paymentCardRepositoryProvider = paymentCardRepositoryProvider;
        this.rtmRepositoryProvider = rtmRepositoryProvider;
        this.nfcRepositoryProvider = nfcRepositoryProvider;
        this.newsRepositoryProvider = newsRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public RechargeZonesViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.rechargeRepositoryProvider.get(), this.paymentCardRepositoryProvider.get(), this.rtmRepositoryProvider.get(), this.nfcRepositoryProvider.get(), this.newsRepositoryProvider.get());
    }

    public static RechargeZonesViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<RechargeRepository> rechargeRepositoryProvider, Provider<PaymentCardRepository> paymentCardRepositoryProvider, Provider<RtmRepository> rtmRepositoryProvider, Provider<NfcRepository> nfcRepositoryProvider, Provider<NewsRepository> newsRepositoryProvider) {
        return new RechargeZonesViewModelImpl_Factory(applicationProvider, rechargeRepositoryProvider, paymentCardRepositoryProvider, rtmRepositoryProvider, nfcRepositoryProvider, newsRepositoryProvider);
    }

    public static RechargeZonesViewModelImpl newInstance(Application application, RechargeRepository rechargeRepository, PaymentCardRepository paymentCardRepository, RtmRepository rtmRepository, NfcRepository nfcRepository, NewsRepository newsRepository) {
        return new RechargeZonesViewModelImpl(application, rechargeRepository, paymentCardRepository, rtmRepository, nfcRepository, newsRepository);
    }
}
