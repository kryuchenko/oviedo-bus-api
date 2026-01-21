package com.iecisa.ctausuario.ui.main.stops.favouritestops;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FavouriteStopsFragment_MembersInjector implements MembersInjector<FavouriteStopsFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public FavouriteStopsFragment_MembersInjector(Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        this.viewModelFactoryProvider = viewModelFactoryProvider;
    }

    public static MembersInjector<FavouriteStopsFragment> create(Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        return new FavouriteStopsFragment_MembersInjector(viewModelFactoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FavouriteStopsFragment instance) {
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(FavouriteStopsFragment instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }
}
