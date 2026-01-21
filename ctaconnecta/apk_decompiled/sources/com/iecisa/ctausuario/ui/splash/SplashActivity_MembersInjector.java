package com.iecisa.ctausuario.ui.splash;

import androidx.fragment.app.Fragment;
import com.cexmobility.core.ui.BaseActivity_MembersInjector;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SplashActivity_MembersInjector implements MembersInjector<SplashActivity> {
    private final Provider<PreferencesHelper> preferencesProvider;
    private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;

    public SplashActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<PreferencesHelper> preferencesProvider) {
        this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
        this.preferencesProvider = preferencesProvider;
    }

    public static MembersInjector<SplashActivity> create(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<PreferencesHelper> preferencesProvider) {
        return new SplashActivity_MembersInjector(supportFragmentInjectorProvider, preferencesProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SplashActivity instance) {
        BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, this.supportFragmentInjectorProvider.get());
        injectPreferences(instance, this.preferencesProvider.get());
    }

    public static void injectPreferences(SplashActivity instance, PreferencesHelper preferences) {
        instance.preferences = preferences;
    }
}
