package com.iecisa.ctausuario.ui.main.more.settings;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SettingsViewModelImpl_Factory implements Factory<SettingsViewModelImpl> {
    private final Provider<Application> applicationProvider;

    public SettingsViewModelImpl_Factory(Provider<Application> applicationProvider) {
        this.applicationProvider = applicationProvider;
    }

    @Override // javax.inject.Provider
    public SettingsViewModelImpl get() {
        return newInstance(this.applicationProvider.get());
    }

    public static SettingsViewModelImpl_Factory create(Provider<Application> applicationProvider) {
        return new SettingsViewModelImpl_Factory(applicationProvider);
    }

    public static SettingsViewModelImpl newInstance(Application application) {
        return new SettingsViewModelImpl(application);
    }
}
