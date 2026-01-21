package com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.cexmobility.core.ui.BaseActivity_MembersInjector;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.ui.main.BaseTransportCardActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyPaymentCardsActivity_MembersInjector implements MembersInjector<MyPaymentCardsActivity> {
    private final Provider<PreferencesHelper> preferencesProvider;
    private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider2;

    public MyPaymentCardsActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider2) {
        this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
        this.viewModelFactoryProvider = viewModelFactoryProvider;
        this.preferencesProvider = preferencesProvider;
        this.viewModelFactoryProvider2 = viewModelFactoryProvider2;
    }

    public static MembersInjector<MyPaymentCardsActivity> create(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider2) {
        return new MyPaymentCardsActivity_MembersInjector(supportFragmentInjectorProvider, viewModelFactoryProvider, preferencesProvider, viewModelFactoryProvider2);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MyPaymentCardsActivity instance) {
        BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, this.supportFragmentInjectorProvider.get());
        BaseTransportCardActivity_MembersInjector.injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
        BaseTransportCardActivity_MembersInjector.injectPreferences(instance, this.preferencesProvider.get());
        injectViewModelFactory(instance, this.viewModelFactoryProvider2.get());
    }

    public static void injectViewModelFactory(MyPaymentCardsActivity instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }
}
