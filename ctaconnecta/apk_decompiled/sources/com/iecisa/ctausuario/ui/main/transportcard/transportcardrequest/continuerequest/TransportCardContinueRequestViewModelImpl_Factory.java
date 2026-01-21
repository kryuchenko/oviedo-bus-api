package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest;

import android.app.Application;
import com.iecisa.ctausuario.data.DoBRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class TransportCardContinueRequestViewModelImpl_Factory implements Factory<TransportCardContinueRequestViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<DoBRepository> dobRepositoryProvider;

    public TransportCardContinueRequestViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<DoBRepository> dobRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.dobRepositoryProvider = dobRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public TransportCardContinueRequestViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.dobRepositoryProvider.get());
    }

    public static TransportCardContinueRequestViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<DoBRepository> dobRepositoryProvider) {
        return new TransportCardContinueRequestViewModelImpl_Factory(applicationProvider, dobRepositoryProvider);
    }

    public static TransportCardContinueRequestViewModelImpl newInstance(Application application, DoBRepository dobRepository) {
        return new TransportCardContinueRequestViewModelImpl(application, dobRepository);
    }
}
