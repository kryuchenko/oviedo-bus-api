package com.iecisa.ctausuario.ui.main.linesrealtime;

import android.app.Application;
import com.iecisa.ctausuario.data.LinesRepository;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import dagger.internal.Factory;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LinesRealTimeViewModelImpl_Factory implements Factory<LinesRealTimeViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<LinesRepository> linesRepositoryProvider;
    private final Provider<SchedulerProvider> schedulerProvider;

    public LinesRealTimeViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<LinesRepository> linesRepositoryProvider, Provider<CompositeDisposable> compositeDisposableProvider, Provider<SchedulerProvider> schedulerProvider) {
        this.applicationProvider = applicationProvider;
        this.linesRepositoryProvider = linesRepositoryProvider;
        this.compositeDisposableProvider = compositeDisposableProvider;
        this.schedulerProvider = schedulerProvider;
    }

    @Override // javax.inject.Provider
    public LinesRealTimeViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.linesRepositoryProvider.get(), this.compositeDisposableProvider.get(), this.schedulerProvider.get());
    }

    public static LinesRealTimeViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<LinesRepository> linesRepositoryProvider, Provider<CompositeDisposable> compositeDisposableProvider, Provider<SchedulerProvider> schedulerProvider) {
        return new LinesRealTimeViewModelImpl_Factory(applicationProvider, linesRepositoryProvider, compositeDisposableProvider, schedulerProvider);
    }

    public static LinesRealTimeViewModelImpl newInstance(Application application, LinesRepository linesRepository, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        return new LinesRealTimeViewModelImpl(application, linesRepository, compositeDisposable, schedulerProvider);
    }
}
