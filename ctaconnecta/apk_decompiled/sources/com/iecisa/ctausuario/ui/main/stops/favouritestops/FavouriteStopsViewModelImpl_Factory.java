package com.iecisa.ctausuario.ui.main.stops.favouritestops;

import android.app.Application;
import com.iecisa.ctausuario.data.FavouriteStopsRepository;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import dagger.internal.Factory;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FavouriteStopsViewModelImpl_Factory implements Factory<FavouriteStopsViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<FavouriteStopsRepository> favouriteStopsRepositoryProvider;
    private final Provider<SchedulerProvider> schedulerProvider;

    public FavouriteStopsViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<FavouriteStopsRepository> favouriteStopsRepositoryProvider, Provider<CompositeDisposable> compositeDisposableProvider, Provider<SchedulerProvider> schedulerProvider) {
        this.applicationProvider = applicationProvider;
        this.favouriteStopsRepositoryProvider = favouriteStopsRepositoryProvider;
        this.compositeDisposableProvider = compositeDisposableProvider;
        this.schedulerProvider = schedulerProvider;
    }

    @Override // javax.inject.Provider
    public FavouriteStopsViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.favouriteStopsRepositoryProvider.get(), this.compositeDisposableProvider.get(), this.schedulerProvider.get());
    }

    public static FavouriteStopsViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<FavouriteStopsRepository> favouriteStopsRepositoryProvider, Provider<CompositeDisposable> compositeDisposableProvider, Provider<SchedulerProvider> schedulerProvider) {
        return new FavouriteStopsViewModelImpl_Factory(applicationProvider, favouriteStopsRepositoryProvider, compositeDisposableProvider, schedulerProvider);
    }

    public static FavouriteStopsViewModelImpl newInstance(Application application, FavouriteStopsRepository favouriteStopsRepository, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        return new FavouriteStopsViewModelImpl(application, favouriteStopsRepository, compositeDisposable, schedulerProvider);
    }
}
