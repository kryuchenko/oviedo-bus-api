package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.data.database.AppDatabase;
import com.iecisa.ctausuario.data.database.StopsDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AppModule_ProvidesStopsDaoFactory implements Factory<StopsDao> {
    private final Provider<AppDatabase> appDatabaseProvider;

    public AppModule_ProvidesStopsDaoFactory(Provider<AppDatabase> appDatabaseProvider) {
        this.appDatabaseProvider = appDatabaseProvider;
    }

    @Override // javax.inject.Provider
    public StopsDao get() {
        return providesStopsDao(this.appDatabaseProvider.get());
    }

    public static AppModule_ProvidesStopsDaoFactory create(Provider<AppDatabase> appDatabaseProvider) {
        return new AppModule_ProvidesStopsDaoFactory(appDatabaseProvider);
    }

    public static StopsDao providesStopsDao(AppDatabase appDatabase) {
        return (StopsDao) Preconditions.checkNotNullFromProvides(AppModule.providesStopsDao(appDatabase));
    }
}
