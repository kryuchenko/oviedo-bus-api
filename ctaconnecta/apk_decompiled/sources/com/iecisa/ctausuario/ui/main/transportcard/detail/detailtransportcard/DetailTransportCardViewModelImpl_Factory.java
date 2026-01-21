package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard;

import android.app.Application;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DetailTransportCardViewModelImpl_Factory implements Factory<DetailTransportCardViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NfcRepository> nfcRepositoryProvider;
    private final Provider<TransportCardRepository> transportCardRepositoryProvider;

    public DetailTransportCardViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<NfcRepository> nfcRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.transportCardRepositoryProvider = transportCardRepositoryProvider;
        this.nfcRepositoryProvider = nfcRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public DetailTransportCardViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.transportCardRepositoryProvider.get(), this.nfcRepositoryProvider.get());
    }

    public static DetailTransportCardViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<NfcRepository> nfcRepositoryProvider) {
        return new DetailTransportCardViewModelImpl_Factory(applicationProvider, transportCardRepositoryProvider, nfcRepositoryProvider);
    }

    public static DetailTransportCardViewModelImpl newInstance(Application application, TransportCardRepository transportCardRepository, NfcRepository nfcRepository) {
        return new DetailTransportCardViewModelImpl(application, transportCardRepository, nfcRepository);
    }
}
