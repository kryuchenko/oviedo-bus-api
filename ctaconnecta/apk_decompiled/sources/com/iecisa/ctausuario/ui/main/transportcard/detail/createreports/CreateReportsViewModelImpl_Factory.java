package com.iecisa.ctausuario.ui.main.transportcard.detail.createreports;

import android.app.Application;
import com.iecisa.ctausuario.data.TransportCardRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CreateReportsViewModelImpl_Factory implements Factory<CreateReportsViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<TransportCardRepository> transportCardRepositoryProvider;

    public CreateReportsViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.transportCardRepositoryProvider = transportCardRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public CreateReportsViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.transportCardRepositoryProvider.get());
    }

    public static CreateReportsViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider) {
        return new CreateReportsViewModelImpl_Factory(applicationProvider, transportCardRepositoryProvider);
    }

    public static CreateReportsViewModelImpl newInstance(Application application, TransportCardRepository transportCardRepository) {
        return new CreateReportsViewModelImpl(application, transportCardRepository);
    }
}
