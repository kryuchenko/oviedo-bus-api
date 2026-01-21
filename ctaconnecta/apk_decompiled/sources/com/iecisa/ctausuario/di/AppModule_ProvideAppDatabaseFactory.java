package com.iecisa.ctausuario.di;

import android.app.Application;
import com.iecisa.ctausuario.data.database.AppDatabase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AppModule_ProvideAppDatabaseFactory implements Factory<AppDatabase> {
    private final Provider<Application> applicationProvider;

    public AppModule_ProvideAppDatabaseFactory(Provider<Application> applicationProvider) {
        this.applicationProvider = applicationProvider;
    }

    @Override // javax.inject.Provider
    public AppDatabase get() {
        return provideAppDatabase(this.applicationProvider.get());
    }

    public static AppModule_ProvideAppDatabaseFactory create(Provider<Application> applicationProvider) {
        return new AppModule_ProvideAppDatabaseFactory(applicationProvider);
    }

    public static AppDatabase provideAppDatabase(Application application) {
        return (AppDatabase) Preconditions.checkNotNullFromProvides(AppModule.provideAppDatabase(application));
    }
}
