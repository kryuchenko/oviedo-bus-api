package com.iecisa.ctausuario.ui.main.transportcard.myaccount;

import android.app.Application;
import com.iecisa.ctausuario.data.UserRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyAccountViewModelImpl_Factory implements Factory<MyAccountViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public MyAccountViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<UserRepository> userRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.userRepositoryProvider = userRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public MyAccountViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.userRepositoryProvider.get());
    }

    public static MyAccountViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<UserRepository> userRepositoryProvider) {
        return new MyAccountViewModelImpl_Factory(applicationProvider, userRepositoryProvider);
    }

    public static MyAccountViewModelImpl newInstance(Application application, UserRepository userRepository) {
        return new MyAccountViewModelImpl(application, userRepository);
    }
}
