package com.iecisa.ctausuario.ui.main.linesrealtime.linesmap;

import android.app.Application;
import com.iecisa.ctausuario.data.LinesRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LinesRealTimeMapViewModelImpl_Factory implements Factory<LinesRealTimeMapViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<LinesRepository> linesRepositoryProvider;

    public LinesRealTimeMapViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<LinesRepository> linesRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.linesRepositoryProvider = linesRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public LinesRealTimeMapViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.linesRepositoryProvider.get());
    }

    public static LinesRealTimeMapViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<LinesRepository> linesRepositoryProvider) {
        return new LinesRealTimeMapViewModelImpl_Factory(applicationProvider, linesRepositoryProvider);
    }

    public static LinesRealTimeMapViewModelImpl newInstance(Application application, LinesRepository linesRepository) {
        return new LinesRealTimeMapViewModelImpl(application, linesRepository);
    }
}
