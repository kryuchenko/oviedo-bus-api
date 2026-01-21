package com.iecisa.ctausuario.ui.main.route;

import android.app.Application;
import com.iecisa.ctausuario.data.RouteRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RouteViewModelImpl_Factory implements Factory<RouteViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<RouteRepository> routesRepositoryProvider;

    public RouteViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<RouteRepository> routesRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.routesRepositoryProvider = routesRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public RouteViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.routesRepositoryProvider.get());
    }

    public static RouteViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<RouteRepository> routesRepositoryProvider) {
        return new RouteViewModelImpl_Factory(applicationProvider, routesRepositoryProvider);
    }

    public static RouteViewModelImpl newInstance(Application application, RouteRepository routesRepository) {
        return new RouteViewModelImpl(application, routesRepository);
    }
}
