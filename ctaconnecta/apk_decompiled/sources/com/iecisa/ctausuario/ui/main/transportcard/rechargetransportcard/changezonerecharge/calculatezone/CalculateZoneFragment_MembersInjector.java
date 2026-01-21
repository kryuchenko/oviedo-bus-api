package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CalculateZoneFragment_MembersInjector implements MembersInjector<CalculateZoneFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public CalculateZoneFragment_MembersInjector(Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        this.viewModelFactoryProvider = viewModelFactoryProvider;
    }

    public static MembersInjector<CalculateZoneFragment> create(Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        return new CalculateZoneFragment_MembersInjector(viewModelFactoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CalculateZoneFragment instance) {
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(CalculateZoneFragment instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }
}
