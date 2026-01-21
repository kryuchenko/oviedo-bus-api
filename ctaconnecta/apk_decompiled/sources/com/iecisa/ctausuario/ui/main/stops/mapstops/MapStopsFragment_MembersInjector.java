package com.iecisa.ctausuario.ui.main.stops.mapstops;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MapStopsFragment_MembersInjector implements MembersInjector<MapStopsFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public MapStopsFragment_MembersInjector(Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        this.viewModelFactoryProvider = viewModelFactoryProvider;
    }

    public static MembersInjector<MapStopsFragment> create(Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        return new MapStopsFragment_MembersInjector(viewModelFactoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MapStopsFragment instance) {
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(MapStopsFragment instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }
}
