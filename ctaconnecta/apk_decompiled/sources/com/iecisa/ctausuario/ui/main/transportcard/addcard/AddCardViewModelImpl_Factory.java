package com.iecisa.ctausuario.ui.main.transportcard.addcard;

import android.app.Application;
import com.iecisa.ctausuario.data.NfcRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AddCardViewModelImpl_Factory implements Factory<AddCardViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NfcRepository> nfcRepositoryProvider;

    public AddCardViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<NfcRepository> nfcRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.nfcRepositoryProvider = nfcRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public AddCardViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.nfcRepositoryProvider.get());
    }

    public static AddCardViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<NfcRepository> nfcRepositoryProvider) {
        return new AddCardViewModelImpl_Factory(applicationProvider, nfcRepositoryProvider);
    }

    public static AddCardViewModelImpl newInstance(Application application, NfcRepository nfcRepository) {
        return new AddCardViewModelImpl(application, nfcRepository);
    }
}
