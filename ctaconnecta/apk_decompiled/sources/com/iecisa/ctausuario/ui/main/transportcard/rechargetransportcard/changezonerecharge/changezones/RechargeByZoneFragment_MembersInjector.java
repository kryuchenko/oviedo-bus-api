package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RechargeByZoneFragment_MembersInjector implements MembersInjector<RechargeByZoneFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public RechargeByZoneFragment_MembersInjector(Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        this.viewModelFactoryProvider = viewModelFactoryProvider;
    }

    public static MembersInjector<RechargeByZoneFragment> create(Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        return new RechargeByZoneFragment_MembersInjector(viewModelFactoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(RechargeByZoneFragment instance) {
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(RechargeByZoneFragment instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }
}
