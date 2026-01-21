package com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge;

import android.app.Application;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.PaymentCardRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AutomaticRechargeViewModelImpl_Factory implements Factory<AutomaticRechargeViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NfcRepository> nfcRepositoryProvider;
    private final Provider<PaymentCardRepository> paymentCardRepositoryProvider;
    private final Provider<TransportCardRepository> transportCardRepositoryProvider;

    public AutomaticRechargeViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<PaymentCardRepository> paymentCardRepositoryProvider, Provider<NfcRepository> nfcRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.transportCardRepositoryProvider = transportCardRepositoryProvider;
        this.paymentCardRepositoryProvider = paymentCardRepositoryProvider;
        this.nfcRepositoryProvider = nfcRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public AutomaticRechargeViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.transportCardRepositoryProvider.get(), this.paymentCardRepositoryProvider.get(), this.nfcRepositoryProvider.get());
    }

    public static AutomaticRechargeViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<PaymentCardRepository> paymentCardRepositoryProvider, Provider<NfcRepository> nfcRepositoryProvider) {
        return new AutomaticRechargeViewModelImpl_Factory(applicationProvider, transportCardRepositoryProvider, paymentCardRepositoryProvider, nfcRepositoryProvider);
    }

    public static AutomaticRechargeViewModelImpl newInstance(Application application, TransportCardRepository transportCardRepository, PaymentCardRepository paymentCardRepository, NfcRepository nfcRepository) {
        return new AutomaticRechargeViewModelImpl(application, transportCardRepository, paymentCardRepository, nfcRepository);
    }
}
