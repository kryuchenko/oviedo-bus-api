package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.data.preferences.PreferencesHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CoreModule_ProvidePreferencesHelperFactory implements Factory<PreferencesHelper> {
    private final Provider<PreferencesHelperImpl> preferencesHelperProvider;

    public CoreModule_ProvidePreferencesHelperFactory(Provider<PreferencesHelperImpl> preferencesHelperProvider) {
        this.preferencesHelperProvider = preferencesHelperProvider;
    }

    @Override // javax.inject.Provider
    public PreferencesHelper get() {
        return providePreferencesHelper(this.preferencesHelperProvider.get());
    }

    public static CoreModule_ProvidePreferencesHelperFactory create(Provider<PreferencesHelperImpl> preferencesHelperProvider) {
        return new CoreModule_ProvidePreferencesHelperFactory(preferencesHelperProvider);
    }

    public static PreferencesHelper providePreferencesHelper(PreferencesHelperImpl preferencesHelper) {
        return (PreferencesHelper) Preconditions.checkNotNullFromProvides(CoreModule.providePreferencesHelper(preferencesHelper));
    }
}
