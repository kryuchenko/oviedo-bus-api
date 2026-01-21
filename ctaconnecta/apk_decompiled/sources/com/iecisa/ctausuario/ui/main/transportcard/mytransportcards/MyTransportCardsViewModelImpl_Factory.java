package com.iecisa.ctausuario.ui.main.transportcard.mytransportcards;

import android.app.Application;
import com.iecisa.ctausuario.data.TransportCardRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyTransportCardsViewModelImpl_Factory implements Factory<MyTransportCardsViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<TransportCardRepository> transportCardRepositoryProvider;

    public MyTransportCardsViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.transportCardRepositoryProvider = transportCardRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public MyTransportCardsViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.transportCardRepositoryProvider.get());
    }

    public static MyTransportCardsViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider) {
        return new MyTransportCardsViewModelImpl_Factory(applicationProvider, transportCardRepositoryProvider);
    }

    public static MyTransportCardsViewModelImpl newInstance(Application application, TransportCardRepository transportCardRepository) {
        return new MyTransportCardsViewModelImpl(application, transportCardRepository);
    }
}
