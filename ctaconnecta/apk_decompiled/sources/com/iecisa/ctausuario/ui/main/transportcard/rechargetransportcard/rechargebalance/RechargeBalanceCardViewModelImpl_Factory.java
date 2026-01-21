package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance;

import android.app.Application;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.PaymentCardRepository;
import com.iecisa.ctausuario.data.RechargeRepository;
import com.iecisa.ctausuario.data.RtmRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import dagger.internal.Factory;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RechargeBalanceCardViewModelImpl_Factory implements Factory<RechargeBalanceCardViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<NewsRepository> newsRepositoryProvider;
    private final Provider<NfcRepository> nfcRepositoryProvider;
    private final Provider<PaymentCardRepository> paymentCardRepositoryProvider;
    private final Provider<RechargeRepository> rechargeRepositoryProvider;
    private final Provider<RtmRepository> rtmRepositoryProvider;
    private final Provider<SchedulerProvider> schedulerProvider;
    private final Provider<TransportCardRepository> transportCardRepositoryProvider;

    public RechargeBalanceCardViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<RechargeRepository> rechargeRepositoryProvider, Provider<PaymentCardRepository> paymentCardRepositoryProvider, Provider<NfcRepository> nfcRepositoryProvider, Provider<CompositeDisposable> compositeDisposableProvider, Provider<SchedulerProvider> schedulerProvider, Provider<NewsRepository> newsRepositoryProvider, Provider<RtmRepository> rtmRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.transportCardRepositoryProvider = transportCardRepositoryProvider;
        this.rechargeRepositoryProvider = rechargeRepositoryProvider;
        this.paymentCardRepositoryProvider = paymentCardRepositoryProvider;
        this.nfcRepositoryProvider = nfcRepositoryProvider;
        this.compositeDisposableProvider = compositeDisposableProvider;
        this.schedulerProvider = schedulerProvider;
        this.newsRepositoryProvider = newsRepositoryProvider;
        this.rtmRepositoryProvider = rtmRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public RechargeBalanceCardViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.transportCardRepositoryProvider.get(), this.rechargeRepositoryProvider.get(), this.paymentCardRepositoryProvider.get(), this.nfcRepositoryProvider.get(), this.compositeDisposableProvider.get(), this.schedulerProvider.get(), this.newsRepositoryProvider.get(), this.rtmRepositoryProvider.get());
    }

    public static RechargeBalanceCardViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<RechargeRepository> rechargeRepositoryProvider, Provider<PaymentCardRepository> paymentCardRepositoryProvider, Provider<NfcRepository> nfcRepositoryProvider, Provider<CompositeDisposable> compositeDisposableProvider, Provider<SchedulerProvider> schedulerProvider, Provider<NewsRepository> newsRepositoryProvider, Provider<RtmRepository> rtmRepositoryProvider) {
        return new RechargeBalanceCardViewModelImpl_Factory(applicationProvider, transportCardRepositoryProvider, rechargeRepositoryProvider, paymentCardRepositoryProvider, nfcRepositoryProvider, compositeDisposableProvider, schedulerProvider, newsRepositoryProvider, rtmRepositoryProvider);
    }

    public static RechargeBalanceCardViewModelImpl newInstance(Application application, TransportCardRepository transportCardRepository, RechargeRepository rechargeRepository, PaymentCardRepository paymentCardRepository, NfcRepository nfcRepository, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider, NewsRepository newsRepository, RtmRepository rtmRepository) {
        return new RechargeBalanceCardViewModelImpl(application, transportCardRepository, rechargeRepository, paymentCardRepository, nfcRepository, compositeDisposable, schedulerProvider, newsRepository, rtmRepository);
    }
}
