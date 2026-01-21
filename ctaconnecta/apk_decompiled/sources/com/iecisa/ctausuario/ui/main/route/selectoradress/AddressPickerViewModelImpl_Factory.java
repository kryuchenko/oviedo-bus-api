package com.iecisa.ctausuario.ui.main.route.selectoradress;

import android.app.Application;
import com.iecisa.ctausuario.data.RouteRepository;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import dagger.internal.Factory;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AddressPickerViewModelImpl_Factory implements Factory<AddressPickerViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<RouteRepository> routeRepositoryProvider;
    private final Provider<SchedulerProvider> schedulerProvider;

    public AddressPickerViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<RouteRepository> routeRepositoryProvider, Provider<CompositeDisposable> compositeDisposableProvider, Provider<SchedulerProvider> schedulerProvider) {
        this.applicationProvider = applicationProvider;
        this.routeRepositoryProvider = routeRepositoryProvider;
        this.compositeDisposableProvider = compositeDisposableProvider;
        this.schedulerProvider = schedulerProvider;
    }

    @Override // javax.inject.Provider
    public AddressPickerViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.routeRepositoryProvider.get(), this.compositeDisposableProvider.get(), this.schedulerProvider.get());
    }

    public static AddressPickerViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<RouteRepository> routeRepositoryProvider, Provider<CompositeDisposable> compositeDisposableProvider, Provider<SchedulerProvider> schedulerProvider) {
        return new AddressPickerViewModelImpl_Factory(applicationProvider, routeRepositoryProvider, compositeDisposableProvider, schedulerProvider);
    }

    public static AddressPickerViewModelImpl newInstance(Application application, RouteRepository routeRepository, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        return new AddressPickerViewModelImpl(application, routeRepository, compositeDisposable, schedulerProvider);
    }
}
