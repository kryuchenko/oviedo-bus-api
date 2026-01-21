package com.iecisa.ctausuario.ui.main.transportcard.dataprotection;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.cexmobility.core.ui.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DataProtectionActivity_MembersInjector implements MembersInjector<DataProtectionActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public DataProtectionActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
        this.viewModelFactoryProvider = viewModelFactoryProvider;
    }

    public static MembersInjector<DataProtectionActivity> create(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        return new DataProtectionActivity_MembersInjector(supportFragmentInjectorProvider, viewModelFactoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DataProtectionActivity instance) {
        BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, this.supportFragmentInjectorProvider.get());
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(DataProtectionActivity instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }
}
