package com.iecisa.ctausuario.ui.main.transportcard.accesssettings;

import android.app.Application;
import com.iecisa.ctausuario.data.UserRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AccessSettingsViewModelImpl_Factory implements Factory<AccessSettingsViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<UserRepository> repositoryProvider;

    public AccessSettingsViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<UserRepository> repositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.repositoryProvider = repositoryProvider;
    }

    @Override // javax.inject.Provider
    public AccessSettingsViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.repositoryProvider.get());
    }

    public static AccessSettingsViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<UserRepository> repositoryProvider) {
        return new AccessSettingsViewModelImpl_Factory(applicationProvider, repositoryProvider);
    }

    public static AccessSettingsViewModelImpl newInstance(Application application, UserRepository repository) {
        return new AccessSettingsViewModelImpl(application, repository);
    }
}
