package com.iecisa.ctausuario.ui.main.transportcard.readcardnfc;

import android.app.Application;
import com.iecisa.ctausuario.data.NfcRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ReadCardNfcViewModelImpl_Factory implements Factory<ReadCardNfcViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NfcRepository> nfcRepositoryProvider;

    public ReadCardNfcViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<NfcRepository> nfcRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.nfcRepositoryProvider = nfcRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public ReadCardNfcViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.nfcRepositoryProvider.get());
    }

    public static ReadCardNfcViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<NfcRepository> nfcRepositoryProvider) {
        return new ReadCardNfcViewModelImpl_Factory(applicationProvider, nfcRepositoryProvider);
    }

    public static ReadCardNfcViewModelImpl newInstance(Application application, NfcRepository nfcRepository) {
        return new ReadCardNfcViewModelImpl(application, nfcRepository);
    }
}
