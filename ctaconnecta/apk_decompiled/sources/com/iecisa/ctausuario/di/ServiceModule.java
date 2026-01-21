package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import com.iecisa.ctausuario.utils.rx.SchedulerProviderImpl;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Named;

@Module
/* loaded from: classes5.dex */
public abstract class ServiceModule {
    public static final String SERVICE_COMPOSITE_DISPOSABLE = "service_composite_disposable";
    public static final String SERVICE_SCHEDULER_PROVIDER = "service_scheduler_provider";

    @Provides
    @Named(SERVICE_COMPOSITE_DISPOSABLE)
    static CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @Named(SERVICE_SCHEDULER_PROVIDER)
    static SchedulerProvider provideSchedulerProvider() {
        return new SchedulerProviderImpl();
    }
}
