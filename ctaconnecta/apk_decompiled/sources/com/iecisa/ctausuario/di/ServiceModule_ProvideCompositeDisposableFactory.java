package com.iecisa.ctausuario.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.disposables.CompositeDisposable;

/* loaded from: classes5.dex */
public final class ServiceModule_ProvideCompositeDisposableFactory implements Factory<CompositeDisposable> {
    @Override // javax.inject.Provider
    public CompositeDisposable get() {
        return provideCompositeDisposable();
    }

    public static ServiceModule_ProvideCompositeDisposableFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CompositeDisposable provideCompositeDisposable() {
        return (CompositeDisposable) Preconditions.checkNotNullFromProvides(ServiceModule.provideCompositeDisposable());
    }

    private static final class InstanceHolder {
        private static final ServiceModule_ProvideCompositeDisposableFactory INSTANCE = new ServiceModule_ProvideCompositeDisposableFactory();

        private InstanceHolder() {
        }
    }
}
