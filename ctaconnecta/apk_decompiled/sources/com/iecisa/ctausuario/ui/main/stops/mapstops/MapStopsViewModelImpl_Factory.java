package com.iecisa.ctausuario.ui.main.stops.mapstops;

import android.app.Application;
import com.iecisa.ctausuario.data.RouteRepository;
import com.iecisa.ctausuario.data.StopsRepository;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import dagger.internal.Factory;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MapStopsViewModelImpl_Factory implements Factory<MapStopsViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<RouteRepository> routeRepositoryProvider;
    private final Provider<SchedulerProvider> schedulerProvider;
    private final Provider<StopsRepository> stopsRepositoryProvider;

    public MapStopsViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<StopsRepository> stopsRepositoryProvider, Provider<RouteRepository> routeRepositoryProvider, Provider<CompositeDisposable> compositeDisposableProvider, Provider<SchedulerProvider> schedulerProvider) {
        this.applicationProvider = applicationProvider;
        this.stopsRepositoryProvider = stopsRepositoryProvider;
        this.routeRepositoryProvider = routeRepositoryProvider;
        this.compositeDisposableProvider = compositeDisposableProvider;
        this.schedulerProvider = schedulerProvider;
    }

    @Override // javax.inject.Provider
    public MapStopsViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.stopsRepositoryProvider.get(), this.routeRepositoryProvider.get(), this.compositeDisposableProvider.get(), this.schedulerProvider.get());
    }

    public static MapStopsViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<StopsRepository> stopsRepositoryProvider, Provider<RouteRepository> routeRepositoryProvider, Provider<CompositeDisposable> compositeDisposableProvider, Provider<SchedulerProvider> schedulerProvider) {
        return new MapStopsViewModelImpl_Factory(applicationProvider, stopsRepositoryProvider, routeRepositoryProvider, compositeDisposableProvider, schedulerProvider);
    }

    public static MapStopsViewModelImpl newInstance(Application application, StopsRepository stopsRepository, RouteRepository routeRepository, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        return new MapStopsViewModelImpl(application, stopsRepository, routeRepository, compositeDisposable, schedulerProvider);
    }
}
