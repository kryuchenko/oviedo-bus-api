package com.iecisa.ctausuario.ui.main.stops.searchstop;

import android.app.Application;
import com.iecisa.ctausuario.data.StopsRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SearchStopViewModelImpl_Factory implements Factory<SearchStopViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<StopsRepository> stopsRepositoryProvider;

    public SearchStopViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<StopsRepository> stopsRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.stopsRepositoryProvider = stopsRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public SearchStopViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.stopsRepositoryProvider.get());
    }

    public static SearchStopViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<StopsRepository> stopsRepositoryProvider) {
        return new SearchStopViewModelImpl_Factory(applicationProvider, stopsRepositoryProvider);
    }

    public static SearchStopViewModelImpl newInstance(Application application, StopsRepository stopsRepository) {
        return new SearchStopViewModelImpl(application, stopsRepository);
    }
}
