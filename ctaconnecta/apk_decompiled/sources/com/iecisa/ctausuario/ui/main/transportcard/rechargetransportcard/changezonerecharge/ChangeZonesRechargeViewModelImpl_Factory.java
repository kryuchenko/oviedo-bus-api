package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge;

import android.app.Application;
import com.iecisa.ctausuario.data.RechargeRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ChangeZonesRechargeViewModelImpl_Factory implements Factory<ChangeZonesRechargeViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<RechargeRepository> repositoryProvider;

    public ChangeZonesRechargeViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<RechargeRepository> repositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.repositoryProvider = repositoryProvider;
    }

    @Override // javax.inject.Provider
    public ChangeZonesRechargeViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.repositoryProvider.get());
    }

    public static ChangeZonesRechargeViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<RechargeRepository> repositoryProvider) {
        return new ChangeZonesRechargeViewModelImpl_Factory(applicationProvider, repositoryProvider);
    }

    public static ChangeZonesRechargeViewModelImpl newInstance(Application application, RechargeRepository repository) {
        return new ChangeZonesRechargeViewModelImpl(application, repository);
    }
}
