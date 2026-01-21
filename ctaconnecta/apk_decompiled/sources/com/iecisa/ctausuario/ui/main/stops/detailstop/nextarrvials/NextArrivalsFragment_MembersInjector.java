package com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials;

import androidx.lifecycle.ViewModelProvider;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NextArrivalsFragment_MembersInjector implements MembersInjector<NextArrivalsFragment> {
    private final Provider<PreferencesHelper> preferencesProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public NextArrivalsFragment_MembersInjector(Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider) {
        this.viewModelFactoryProvider = viewModelFactoryProvider;
        this.preferencesProvider = preferencesProvider;
    }

    public static MembersInjector<NextArrivalsFragment> create(Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider) {
        return new NextArrivalsFragment_MembersInjector(viewModelFactoryProvider, preferencesProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(NextArrivalsFragment instance) {
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
        injectPreferences(instance, this.preferencesProvider.get());
    }

    public static void injectViewModelFactory(NextArrivalsFragment instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }

    public static void injectPreferences(NextArrivalsFragment instance, PreferencesHelper preferences) {
        instance.preferences = preferences;
    }
}
