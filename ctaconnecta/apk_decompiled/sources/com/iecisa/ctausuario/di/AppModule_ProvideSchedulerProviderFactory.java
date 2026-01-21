package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class AppModule_ProvideSchedulerProviderFactory implements Factory<SchedulerProvider> {
    @Override // javax.inject.Provider
    public SchedulerProvider get() {
        return provideSchedulerProvider();
    }

    public static AppModule_ProvideSchedulerProviderFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SchedulerProvider provideSchedulerProvider() {
        return (SchedulerProvider) Preconditions.checkNotNullFromProvides(AppModule.provideSchedulerProvider());
    }

    private static final class InstanceHolder {
        private static final AppModule_ProvideSchedulerProviderFactory INSTANCE = new AppModule_ProvideSchedulerProviderFactory();

        private InstanceHolder() {
        }
    }
}
