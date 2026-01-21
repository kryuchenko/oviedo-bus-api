package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone;

import android.app.Application;
import com.iecisa.ctausuario.data.RechargeRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CalculateZonesViewModelImpl_Factory implements Factory<CalculateZonesViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<RechargeRepository> repositoryProvider;

    public CalculateZonesViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<RechargeRepository> repositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.repositoryProvider = repositoryProvider;
    }

    @Override // javax.inject.Provider
    public CalculateZonesViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.repositoryProvider.get());
    }

    public static CalculateZonesViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<RechargeRepository> repositoryProvider) {
        return new CalculateZonesViewModelImpl_Factory(applicationProvider, repositoryProvider);
    }

    public static CalculateZonesViewModelImpl newInstance(Application application, RechargeRepository repository) {
        return new CalculateZonesViewModelImpl(application, repository);
    }
}
