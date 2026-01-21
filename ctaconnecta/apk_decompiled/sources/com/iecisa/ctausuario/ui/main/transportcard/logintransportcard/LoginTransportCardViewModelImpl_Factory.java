package com.iecisa.ctausuario.ui.main.transportcard.logintransportcard;

import android.app.Application;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.data.UserRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LoginTransportCardViewModelImpl_Factory implements Factory<LoginTransportCardViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<TransportCardRepository> transportCardRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public LoginTransportCardViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<UserRepository> userRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.transportCardRepositoryProvider = transportCardRepositoryProvider;
        this.userRepositoryProvider = userRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public LoginTransportCardViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.transportCardRepositoryProvider.get(), this.userRepositoryProvider.get());
    }

    public static LoginTransportCardViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider, Provider<UserRepository> userRepositoryProvider) {
        return new LoginTransportCardViewModelImpl_Factory(applicationProvider, transportCardRepositoryProvider, userRepositoryProvider);
    }

    public static LoginTransportCardViewModelImpl newInstance(Application application, TransportCardRepository transportCardRepository, UserRepository userRepository) {
        return new LoginTransportCardViewModelImpl(application, transportCardRepository, userRepository);
    }
}
