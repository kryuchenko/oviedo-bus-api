package com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword;

import android.app.Application;
import com.iecisa.ctausuario.data.UserRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RecoverPasswordViewModelImpl_Factory implements Factory<RecoverPasswordViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<UserRepository> repositoryProvider;

    public RecoverPasswordViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<UserRepository> repositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.repositoryProvider = repositoryProvider;
    }

    @Override // javax.inject.Provider
    public RecoverPasswordViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.repositoryProvider.get());
    }

    public static RecoverPasswordViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<UserRepository> repositoryProvider) {
        return new RecoverPasswordViewModelImpl_Factory(applicationProvider, repositoryProvider);
    }

    public static RecoverPasswordViewModelImpl newInstance(Application application, UserRepository repository) {
        return new RecoverPasswordViewModelImpl(application, repository);
    }
}
