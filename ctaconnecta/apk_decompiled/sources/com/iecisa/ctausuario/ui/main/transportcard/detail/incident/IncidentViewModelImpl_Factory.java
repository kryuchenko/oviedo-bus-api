package com.iecisa.ctausuario.ui.main.transportcard.detail.incident;

import android.app.Application;
import com.iecisa.ctausuario.data.TransportCardRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class IncidentViewModelImpl_Factory implements Factory<IncidentViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<TransportCardRepository> transportCardRepositoryProvider;

    public IncidentViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.transportCardRepositoryProvider = transportCardRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public IncidentViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.transportCardRepositoryProvider.get());
    }

    public static IncidentViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider) {
        return new IncidentViewModelImpl_Factory(applicationProvider, transportCardRepositoryProvider);
    }

    public static IncidentViewModelImpl newInstance(Application application, TransportCardRepository transportCardRepository) {
        return new IncidentViewModelImpl(application, transportCardRepository);
    }
}
