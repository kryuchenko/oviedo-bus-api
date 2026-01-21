package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway;

import android.app.Application;
import com.iecisa.ctausuario.data.NfcRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RechargeRedsysViewModelImpl_Factory implements Factory<RechargeRedsysViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NfcRepository> nfcRepositoryProvider;

    public RechargeRedsysViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<NfcRepository> nfcRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.nfcRepositoryProvider = nfcRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public RechargeRedsysViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.nfcRepositoryProvider.get());
    }

    public static RechargeRedsysViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<NfcRepository> nfcRepositoryProvider) {
        return new RechargeRedsysViewModelImpl_Factory(applicationProvider, nfcRepositoryProvider);
    }

    public static RechargeRedsysViewModelImpl newInstance(Application application, NfcRepository nfcRepository) {
        return new RechargeRedsysViewModelImpl(application, nfcRepository);
    }
}
