package com.iecisa.ctausuario.di;

import android.app.Application;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AppModule_ProvideContextApplicationFactory implements Factory<Context> {
    private final Provider<Application> appProvider;

    public AppModule_ProvideContextApplicationFactory(Provider<Application> appProvider) {
        this.appProvider = appProvider;
    }

    @Override // javax.inject.Provider
    public Context get() {
        return provideContextApplication(this.appProvider.get());
    }

    public static AppModule_ProvideContextApplicationFactory create(Provider<Application> appProvider) {
        return new AppModule_ProvideContextApplicationFactory(appProvider);
    }

    public static Context provideContextApplication(Application app) {
        return (Context) Preconditions.checkNotNullFromProvides(AppModule.provideContextApplication(app));
    }
}
