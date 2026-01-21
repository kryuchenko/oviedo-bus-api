package com.iecisa.ctausuario.ui.main.transportcard.accesssettings;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.cexmobility.core.ui.BaseActivity_MembersInjector;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AccessSettingsActivity_MembersInjector implements MembersInjector<AccessSettingsActivity> {
    private final Provider<PreferencesHelper> preferencesHelperProvider;
    private final Provider<PreferencesHelper> preferencesProvider;
    private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public AccessSettingsActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider, Provider<PreferencesHelper> preferencesHelperProvider) {
        this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
        this.viewModelFactoryProvider = viewModelFactoryProvider;
        this.preferencesProvider = preferencesProvider;
        this.preferencesHelperProvider = preferencesHelperProvider;
    }

    public static MembersInjector<AccessSettingsActivity> create(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider, Provider<PreferencesHelper> preferencesHelperProvider) {
        return new AccessSettingsActivity_MembersInjector(supportFragmentInjectorProvider, viewModelFactoryProvider, preferencesProvider, preferencesHelperProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AccessSettingsActivity instance) {
        BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, this.supportFragmentInjectorProvider.get());
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
        injectPreferences(instance, this.preferencesProvider.get());
        injectPreferencesHelper(instance, this.preferencesHelperProvider.get());
    }

    public static void injectViewModelFactory(AccessSettingsActivity instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }

    public static void injectPreferences(AccessSettingsActivity instance, PreferencesHelper preferences) {
        instance.preferences = preferences;
    }

    public static void injectPreferencesHelper(AccessSettingsActivity instance, PreferencesHelper preferencesHelper) {
        instance.preferencesHelper = preferencesHelper;
    }
}
