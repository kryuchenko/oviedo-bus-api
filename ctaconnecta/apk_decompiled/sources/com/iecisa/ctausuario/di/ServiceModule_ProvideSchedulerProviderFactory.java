package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class ServiceModule_ProvideSchedulerProviderFactory implements Factory<SchedulerProvider> {
    @Override // javax.inject.Provider
    public SchedulerProvider get() {
        return provideSchedulerProvider();
    }

    public static ServiceModule_ProvideSchedulerProviderFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SchedulerProvider provideSchedulerProvider() {
        return (SchedulerProvider) Preconditions.checkNotNullFromProvides(ServiceModule.provideSchedulerProvider());
    }

    private static final class InstanceHolder {
        private static final ServiceModule_ProvideSchedulerProviderFactory INSTANCE = new ServiceModule_ProvideSchedulerProviderFactory();

        private InstanceHolder() {
        }
    }
}
