package com.iecisa.ctausuario.ui.main.incidents;

import androidx.lifecycle.ViewModelProvider;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class IncidentsFragment_MembersInjector implements MembersInjector<IncidentsFragment> {
    private final Provider<PreferencesHelper> preferencesProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public IncidentsFragment_MembersInjector(Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider) {
        this.viewModelFactoryProvider = viewModelFactoryProvider;
        this.preferencesProvider = preferencesProvider;
    }

    public static MembersInjector<IncidentsFragment> create(Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider) {
        return new IncidentsFragment_MembersInjector(viewModelFactoryProvider, preferencesProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(IncidentsFragment instance) {
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
        injectPreferences(instance, this.preferencesProvider.get());
    }

    public static void injectViewModelFactory(IncidentsFragment instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }

    public static void injectPreferences(IncidentsFragment instance, PreferencesHelper preferences) {
        instance.preferences = preferences;
    }
}
