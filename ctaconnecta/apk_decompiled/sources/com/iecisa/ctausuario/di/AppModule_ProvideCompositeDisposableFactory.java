package com.iecisa.ctausuario.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.disposables.CompositeDisposable;

/* loaded from: classes5.dex */
public final class AppModule_ProvideCompositeDisposableFactory implements Factory<CompositeDisposable> {
    @Override // javax.inject.Provider
    public CompositeDisposable get() {
        return provideCompositeDisposable();
    }

    public static AppModule_ProvideCompositeDisposableFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CompositeDisposable provideCompositeDisposable() {
        return (CompositeDisposable) Preconditions.checkNotNullFromProvides(AppModule.provideCompositeDisposable());
    }

    private static final class InstanceHolder {
        private static final AppModule_ProvideCompositeDisposableFactory INSTANCE = new AppModule_ProvideCompositeDisposableFactory();

        private InstanceHolder() {
        }
    }
}
