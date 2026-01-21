package com.iecisa.ctausuario.ui.main;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.cexmobility.core.ui.BaseActivity_MembersInjector;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
    private final Provider<PreferencesHelper> preferencesProvider;
    private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public MainActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider) {
        this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
        this.viewModelFactoryProvider = viewModelFactoryProvider;
        this.preferencesProvider = preferencesProvider;
    }

    public static MembersInjector<MainActivity> create(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider) {
        return new MainActivity_MembersInjector(supportFragmentInjectorProvider, viewModelFactoryProvider, preferencesProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MainActivity instance) {
        BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, this.supportFragmentInjectorProvider.get());
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
        injectPreferences(instance, this.preferencesProvider.get());
    }

    public static void injectViewModelFactory(MainActivity instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }

    public static void injectPreferences(MainActivity instance, PreferencesHelper preferences) {
        instance.preferences = preferences;
    }
}
