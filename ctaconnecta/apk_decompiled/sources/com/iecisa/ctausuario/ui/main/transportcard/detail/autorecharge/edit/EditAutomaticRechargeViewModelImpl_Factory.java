package com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit;

import android.app.Application;
import com.iecisa.ctausuario.data.PaymentCardRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class EditAutomaticRechargeViewModelImpl_Factory implements Factory<EditAutomaticRechargeViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<PaymentCardRepository> paymentCardRepositoryProvider;
    private final Provider<TransportCardRepository> transportCardRepositoryProvider;

    public EditAutomaticRechargeViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<PaymentCardRepository> paymentCardRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.transportCardRepositoryProvider = transportCardRepositoryProvider;
        this.paymentCardRepositoryProvider = paymentCardRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public EditAutomaticRechargeViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.transportCardRepositoryProvider.get(), this.paymentCardRepositoryProvider.get());
    }

    public static EditAutomaticRechargeViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<PaymentCardRepository> paymentCardRepositoryProvider) {
        return new EditAutomaticRechargeViewModelImpl_Factory(applicationProvider, transportCardRepositoryProvider, paymentCardRepositoryProvider);
    }

    public static EditAutomaticRechargeViewModelImpl newInstance(Application application, TransportCardRepository transportCardRepository, PaymentCardRepository paymentCardRepository) {
        return new EditAutomaticRechargeViewModelImpl(application, transportCardRepository, paymentCardRepository);
    }
}
