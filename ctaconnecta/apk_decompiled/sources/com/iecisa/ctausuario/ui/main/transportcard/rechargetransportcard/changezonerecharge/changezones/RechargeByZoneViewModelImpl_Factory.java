package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones;

import android.app.Application;
import com.iecisa.ctausuario.data.TransportCardRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RechargeByZoneViewModelImpl_Factory implements Factory<RechargeByZoneViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<TransportCardRepository> transportCardRepositoryProvider;

    public RechargeByZoneViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.transportCardRepositoryProvider = transportCardRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public RechargeByZoneViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.transportCardRepositoryProvider.get());
    }

    public static RechargeByZoneViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider) {
        return new RechargeByZoneViewModelImpl_Factory(applicationProvider, transportCardRepositoryProvider);
    }

    public static RechargeByZoneViewModelImpl newInstance(Application application, TransportCardRepository transportCardRepository) {
        return new RechargeByZoneViewModelImpl(application, transportCardRepository);
    }
}
