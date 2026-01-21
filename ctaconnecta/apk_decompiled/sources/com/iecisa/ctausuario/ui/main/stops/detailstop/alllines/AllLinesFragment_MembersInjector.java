package com.iecisa.ctausuario.ui.main.stops.detailstop.alllines;

import androidx.lifecycle.ViewModelProvider;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AllLinesFragment_MembersInjector implements MembersInjector<AllLinesFragment> {
    private final Provider<PreferencesHelper> preferencesProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public AllLinesFragment_MembersInjector(Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider) {
        this.viewModelFactoryProvider = viewModelFactoryProvider;
        this.preferencesProvider = preferencesProvider;
    }

    public static MembersInjector<AllLinesFragment> create(Provider<ViewModelProvider.Factory> viewModelFactoryProvider, Provider<PreferencesHelper> preferencesProvider) {
        return new AllLinesFragment_MembersInjector(viewModelFactoryProvider, preferencesProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AllLinesFragment instance) {
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
        injectPreferences(instance, this.preferencesProvider.get());
    }

    public static void injectViewModelFactory(AllLinesFragment instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }

    public static void injectPreferences(AllLinesFragment instance, PreferencesHelper preferences) {
        instance.preferences = preferences;
    }
}
