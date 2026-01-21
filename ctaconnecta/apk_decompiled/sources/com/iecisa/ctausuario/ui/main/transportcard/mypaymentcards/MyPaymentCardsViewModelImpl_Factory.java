package com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards;

import android.app.Application;
import com.iecisa.ctausuario.data.PaymentCardRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyPaymentCardsViewModelImpl_Factory implements Factory<MyPaymentCardsViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<PaymentCardRepository> repositoryProvider;

    public MyPaymentCardsViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<PaymentCardRepository> repositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.repositoryProvider = repositoryProvider;
    }

    @Override // javax.inject.Provider
    public MyPaymentCardsViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.repositoryProvider.get());
    }

    public static MyPaymentCardsViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<PaymentCardRepository> repositoryProvider) {
        return new MyPaymentCardsViewModelImpl_Factory(applicationProvider, repositoryProvider);
    }

    public static MyPaymentCardsViewModelImpl newInstance(Application application, PaymentCardRepository repository) {
        return new MyPaymentCardsViewModelImpl(application, repository);
    }
}
