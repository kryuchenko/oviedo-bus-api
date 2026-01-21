package com.iecisa.ctausuario.ui.main.route;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RouteFragment_MembersInjector implements MembersInjector<RouteFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public RouteFragment_MembersInjector(Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        this.viewModelFactoryProvider = viewModelFactoryProvider;
    }

    public static MembersInjector<RouteFragment> create(Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        return new RouteFragment_MembersInjector(viewModelFactoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(RouteFragment instance) {
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(RouteFragment instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }
}
