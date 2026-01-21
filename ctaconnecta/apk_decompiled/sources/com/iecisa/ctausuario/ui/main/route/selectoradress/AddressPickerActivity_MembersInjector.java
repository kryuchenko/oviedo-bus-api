package com.iecisa.ctausuario.ui.main.route.selectoradress;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.cexmobility.core.ui.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AddressPickerActivity_MembersInjector implements MembersInjector<AddressPickerActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public AddressPickerActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
        this.viewModelFactoryProvider = viewModelFactoryProvider;
    }

    public static MembersInjector<AddressPickerActivity> create(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        return new AddressPickerActivity_MembersInjector(supportFragmentInjectorProvider, viewModelFactoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AddressPickerActivity instance) {
        BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, this.supportFragmentInjectorProvider.get());
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(AddressPickerActivity instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }
}
