package com.iecisa.ctausuario.ui.main.stops.detailstop;

import android.app.Application;
import com.iecisa.ctausuario.data.StopsRepository;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import dagger.internal.Factory;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DetailStopViewModelImpl_Factory implements Factory<DetailStopViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<SchedulerProvider> schedulerProvider;
    private final Provider<StopsRepository> stopsRepositoryProvider;

    public DetailStopViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<StopsRepository> stopsRepositoryProvider, Provider<CompositeDisposable> compositeDisposableProvider, Provider<SchedulerProvider> schedulerProvider) {
        this.applicationProvider = applicationProvider;
        this.stopsRepositoryProvider = stopsRepositoryProvider;
        this.compositeDisposableProvider = compositeDisposableProvider;
        this.schedulerProvider = schedulerProvider;
    }

    @Override // javax.inject.Provider
    public DetailStopViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.stopsRepositoryProvider.get(), this.compositeDisposableProvider.get(), this.schedulerProvider.get());
    }

    public static DetailStopViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<StopsRepository> stopsRepositoryProvider, Provider<CompositeDisposable> compositeDisposableProvider, Provider<SchedulerProvider> schedulerProvider) {
        return new DetailStopViewModelImpl_Factory(applicationProvider, stopsRepositoryProvider, compositeDisposableProvider, schedulerProvider);
    }

    public static DetailStopViewModelImpl newInstance(Application application, StopsRepository stopsRepository, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        return new DetailStopViewModelImpl(application, stopsRepository, compositeDisposable, schedulerProvider);
    }
}
