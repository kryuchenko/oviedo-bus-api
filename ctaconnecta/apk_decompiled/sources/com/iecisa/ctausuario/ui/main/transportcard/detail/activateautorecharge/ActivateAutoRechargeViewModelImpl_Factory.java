package com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge;

import android.app.Application;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.PaymentCardRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ActivateAutoRechargeViewModelImpl_Factory implements Factory<ActivateAutoRechargeViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NewsRepository> newsRepositoryProvider;
    private final Provider<PaymentCardRepository> paymentCardRepositoryProvider;
    private final Provider<TransportCardRepository> repositoryProvider;

    public ActivateAutoRechargeViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<PaymentCardRepository> paymentCardRepositoryProvider, Provider<TransportCardRepository> repositoryProvider, Provider<NewsRepository> newsRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.paymentCardRepositoryProvider = paymentCardRepositoryProvider;
        this.repositoryProvider = repositoryProvider;
        this.newsRepositoryProvider = newsRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public ActivateAutoRechargeViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.paymentCardRepositoryProvider.get(), this.repositoryProvider.get(), this.newsRepositoryProvider.get());
    }

    public static ActivateAutoRechargeViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<PaymentCardRepository> paymentCardRepositoryProvider, Provider<TransportCardRepository> repositoryProvider, Provider<NewsRepository> newsRepositoryProvider) {
        return new ActivateAutoRechargeViewModelImpl_Factory(applicationProvider, paymentCardRepositoryProvider, repositoryProvider, newsRepositoryProvider);
    }

    public static ActivateAutoRechargeViewModelImpl newInstance(Application application, PaymentCardRepository paymentCardRepository, TransportCardRepository repository, NewsRepository newsRepository) {
        return new ActivateAutoRechargeViewModelImpl(application, paymentCardRepository, repository, newsRepository);
    }
}
