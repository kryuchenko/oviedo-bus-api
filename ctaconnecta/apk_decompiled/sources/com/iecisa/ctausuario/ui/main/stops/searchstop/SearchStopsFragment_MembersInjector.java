package com.iecisa.ctausuario.ui.main.stops.searchstop;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SearchStopsFragment_MembersInjector implements MembersInjector<SearchStopsFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public SearchStopsFragment_MembersInjector(Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        this.viewModelFactoryProvider = viewModelFactoryProvider;
    }

    public static MembersInjector<SearchStopsFragment> create(Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        return new SearchStopsFragment_MembersInjector(viewModelFactoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SearchStopsFragment instance) {
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(SearchStopsFragment instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }
}
