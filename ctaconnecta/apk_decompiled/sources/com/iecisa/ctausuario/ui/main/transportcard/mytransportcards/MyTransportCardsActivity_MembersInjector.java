package com.iecisa.ctausuario.ui.main.transportcard.mytransportcards;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.cexmobility.core.ui.BaseActivity_MembersInjector;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.ui.main.BaseTransportCardActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyTransportCardsActivity_MembersInjector implements MembersInjector<MyTransportCardsActivity> {
    private final Provider<PreferencesHelper> myPreferencesProvider;
    private final Provider<PreferencesHelper> preferencesHelperProvider;
    private final Provider<PreferencesHelper> preferencesProvider;
    private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider2;

    public MyTransportCardsActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider2, Provider<PreferencesHelper> preferencesHelperProvider, Provider<PreferencesHelper> myPreferencesProvider) {
        this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
        this.viewModelFactoryProvider = viewModelFactoryProvider;
        this.preferencesProvider = preferencesProvider;
        this.viewModelFactoryProvider2 = viewModelFactoryProvider2;
        this.preferencesHelperProvider = preferencesHelperProvider;
        this.myPreferencesProvider = myPreferencesProvider;
    }

    public static MembersInjector<MyTransportCardsActivity> create(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider2, Provider<PreferencesHelper> preferencesHelperProvider, Provider<PreferencesHelper> myPreferencesProvider) {
        return new MyTransportCardsActivity_MembersInjector(supportFragmentInjectorProvider, viewModelFactoryProvider, preferencesProvider, viewModelFactoryProvider2, preferencesHelperProvider, myPreferencesProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MyTransportCardsActivity instance) {
        BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, this.supportFragmentInjectorProvider.get());
        BaseTransportCardActivity_MembersInjector.injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
        BaseTransportCardActivity_MembersInjector.injectPreferences(instance, this.preferencesProvider.get());
        injectViewModelFactory(instance, this.viewModelFactoryProvider2.get());
        injectPreferencesHelper(instance, this.preferencesHelperProvider.get());
        injectMyPreferences(instance, this.myPreferencesProvider.get());
    }

    public static void injectViewModelFactory(MyTransportCardsActivity instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }

    public static void injectPreferencesHelper(MyTransportCardsActivity instance, PreferencesHelper preferencesHelper) {
        instance.preferencesHelper = preferencesHelper;
    }

    public static void injectMyPreferences(MyTransportCardsActivity instance, PreferencesHelper myPreferences) {
        instance.myPreferences = myPreferences;
    }
}
