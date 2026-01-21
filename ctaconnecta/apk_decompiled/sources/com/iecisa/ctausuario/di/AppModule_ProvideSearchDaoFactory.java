package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.data.database.AppDatabase;
import com.iecisa.ctausuario.data.database.SearchDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AppModule_ProvideSearchDaoFactory implements Factory<SearchDao> {
    private final Provider<AppDatabase> appDatabaseProvider;

    public AppModule_ProvideSearchDaoFactory(Provider<AppDatabase> appDatabaseProvider) {
        this.appDatabaseProvider = appDatabaseProvider;
    }

    @Override // javax.inject.Provider
    public SearchDao get() {
        return provideSearchDao(this.appDatabaseProvider.get());
    }

    public static AppModule_ProvideSearchDaoFactory create(Provider<AppDatabase> appDatabaseProvider) {
        return new AppModule_ProvideSearchDaoFactory(appDatabaseProvider);
    }

    public static SearchDao provideSearchDao(AppDatabase appDatabase) {
        return (SearchDao) Preconditions.checkNotNullFromProvides(AppModule.provideSearchDao(appDatabase));
    }
}
