package com.iecisa.ctausuario.ui.main.transportcard.rtm;

import android.app.Application;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.UserRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RtmViewModelImpl_Factory implements Factory<RtmViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NfcRepository> nfcRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public RtmViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<UserRepository> userRepositoryProvider, Provider<NfcRepository> nfcRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.userRepositoryProvider = userRepositoryProvider;
        this.nfcRepositoryProvider = nfcRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public RtmViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.userRepositoryProvider.get(), this.nfcRepositoryProvider.get());
    }

    public static RtmViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<UserRepository> userRepositoryProvider, Provider<NfcRepository> nfcRepositoryProvider) {
        return new RtmViewModelImpl_Factory(applicationProvider, userRepositoryProvider, nfcRepositoryProvider);
    }

    public static RtmViewModelImpl newInstance(Application application, UserRepository userRepository, NfcRepository nfcRepository) {
        return new RtmViewModelImpl(application, userRepository, nfcRepository);
    }
}
