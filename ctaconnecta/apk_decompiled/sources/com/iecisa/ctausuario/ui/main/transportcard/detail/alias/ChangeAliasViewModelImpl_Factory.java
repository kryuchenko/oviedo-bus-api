package com.iecisa.ctausuario.ui.main.transportcard.detail.alias;

import android.app.Application;
import com.iecisa.ctausuario.data.UserRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ChangeAliasViewModelImpl_Factory implements Factory<ChangeAliasViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public ChangeAliasViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<UserRepository> userRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.userRepositoryProvider = userRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public ChangeAliasViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.userRepositoryProvider.get());
    }

    public static ChangeAliasViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<UserRepository> userRepositoryProvider) {
        return new ChangeAliasViewModelImpl_Factory(applicationProvider, userRepositoryProvider);
    }

    public static ChangeAliasViewModelImpl newInstance(Application application, UserRepository userRepository) {
        return new ChangeAliasViewModelImpl(application, userRepository);
    }
}
