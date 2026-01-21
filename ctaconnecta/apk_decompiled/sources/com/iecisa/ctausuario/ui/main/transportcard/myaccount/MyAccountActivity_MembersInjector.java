package com.iecisa.ctausuario.ui.main.transportcard.myaccount;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.cexmobility.core.ui.BaseActivity_MembersInjector;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.ui.main.BaseTransportCardActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyAccountActivity_MembersInjector implements MembersInjector<MyAccountActivity> {
    private final Provider<PreferencesHelper> preferencesProvider;
    private final Provider<PreferencesHelper> preferencesProvider2;
    private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider2;

    public MyAccountActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider2, Provider<PreferencesHelper> preferencesProvider2) {
        this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
        this.viewModelFactoryProvider = viewModelFactoryProvider;
        this.preferencesProvider = preferencesProvider;
        this.viewModelFactoryProvider2 = viewModelFactoryProvider2;
        this.preferencesProvider2 = preferencesProvider2;
    }

    public static MembersInjector<MyAccountActivity> create(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider2, Provider<PreferencesHelper> preferencesProvider2) {
        return new MyAccountActivity_MembersInjector(supportFragmentInjectorProvider, viewModelFactoryProvider, preferencesProvider, viewModelFactoryProvider2, preferencesProvider2);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MyAccountActivity instance) {
        BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, this.supportFragmentInjectorProvider.get());
        BaseTransportCardActivity_MembersInjector.injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
        BaseTransportCardActivity_MembersInjector.injectPreferences(instance, this.preferencesProvider.get());
        injectViewModelFactory(instance, this.viewModelFactoryProvider2.get());
        injectPreferences(instance, this.preferencesProvider2.get());
    }

    public static void injectViewModelFactory(MyAccountActivity instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }

    public static void injectPreferences(MyAccountActivity instance, PreferencesHelper preferences) {
        instance.preferences = preferences;
    }
}
