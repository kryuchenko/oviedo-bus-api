package com.iecisa.ctausuario.ui.main.linesrealtime.linesmap;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LinesRealTimeMapFragment_MembersInjector implements MembersInjector<LinesRealTimeMapFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public LinesRealTimeMapFragment_MembersInjector(Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        this.viewModelFactoryProvider = viewModelFactoryProvider;
    }

    public static MembersInjector<LinesRealTimeMapFragment> create(Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        return new LinesRealTimeMapFragment_MembersInjector(viewModelFactoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LinesRealTimeMapFragment instance) {
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(LinesRealTimeMapFragment instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }
}
