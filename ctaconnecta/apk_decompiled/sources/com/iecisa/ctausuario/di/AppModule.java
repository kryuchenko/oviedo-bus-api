package com.iecisa.ctausuario.di;

import android.app.Application;
import android.content.Context;
import androidx.room.Room;
import com.iecisa.ctausuario.data.DoBRepository;
import com.iecisa.ctausuario.data.DoBRepositoryImpl;
import com.iecisa.ctausuario.data.FavouriteStopsRepository;
import com.iecisa.ctausuario.data.FavouriteStopsRepositoryImpl;
import com.iecisa.ctausuario.data.LinesRepository;
import com.iecisa.ctausuario.data.LinesRepositoryImpl;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.NewsRepositoryImpl;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.NfcRepositoryImpl;
import com.iecisa.ctausuario.data.NotificationRepository;
import com.iecisa.ctausuario.data.NotificationRepositoryImpl;
import com.iecisa.ctausuario.data.PaymentCardRepository;
import com.iecisa.ctausuario.data.PaymentCardRepositoryImpl;
import com.iecisa.ctausuario.data.RechargeRepository;
import com.iecisa.ctausuario.data.RechargeRepositoryImpl;
import com.iecisa.ctausuario.data.RouteRepository;
import com.iecisa.ctausuario.data.RouteRepositoryImpl;
import com.iecisa.ctausuario.data.RtmRepository;
import com.iecisa.ctausuario.data.RtmRepositoryImpl;
import com.iecisa.ctausuario.data.StopsRepository;
import com.iecisa.ctausuario.data.StopsRepositoryImpl;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.data.TransportCardRepositoryImpl;
import com.iecisa.ctausuario.data.UserRepository;
import com.iecisa.ctausuario.data.UserRepositoryImpl;
import com.iecisa.ctausuario.data.database.AppDatabase;
import com.iecisa.ctausuario.data.database.SearchDao;
import com.iecisa.ctausuario.data.database.StopsDao;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import com.iecisa.ctausuario.utils.rx.SchedulerProviderImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Named;
import javax.inject.Singleton;

@Module(includes = {ViewModelModule.class})
/* loaded from: classes5.dex */
public abstract class AppModule {
    public static final String APPLICATION_CONTEXT = "application.context";

    @Provides
    @Singleton
    @Named(APPLICATION_CONTEXT)
    static Context provideContextApplication(Application app) {
        return app;
    }

    @Singleton
    @Binds
    abstract PaymentCardRepository provideCardTokenRepository(PaymentCardRepositoryImpl cardTokenRepository);

    @Singleton
    @Binds
    abstract DoBRepository provideDoBRepository(DoBRepositoryImpl dobRepository);

    @Singleton
    @Binds
    abstract FavouriteStopsRepository provideFavouriteStopsRepository(FavouriteStopsRepositoryImpl favouriteStopsRepository);

    @Singleton
    @Binds
    abstract LinesRepository provideLinesRepository(LinesRepositoryImpl linesRepository);

    @Singleton
    @Binds
    abstract NewsRepository provideNewsRepository(NewsRepositoryImpl newsRespository);

    @Singleton
    @Binds
    abstract NfcRepository provideNfcRepository(NfcRepositoryImpl nfcRepository);

    @Singleton
    @Binds
    abstract NotificationRepository provideNotificationRepository(NotificationRepositoryImpl notificationRepository);

    @Singleton
    @Binds
    abstract RechargeRepository provideRechargeRepository(RechargeRepositoryImpl rechargeRepository);

    @Singleton
    @Binds
    abstract RouteRepository provideRouteRepository(RouteRepositoryImpl routeRepository);

    @Singleton
    @Binds
    abstract RtmRepository provideRtmRepository(RtmRepositoryImpl rtmRepository);

    @Singleton
    @Binds
    abstract StopsRepository provideStopsRepository(StopsRepositoryImpl stopsRepository);

    @Singleton
    @Binds
    abstract TransportCardRepository provideTransportCardRespository(TransportCardRepositoryImpl transportCardRepository);

    @Singleton
    @Binds
    abstract UserRepository provideUserRepository(UserRepositoryImpl userRepository);

    @Provides
    static CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    static SchedulerProvider provideSchedulerProvider() {
        return new SchedulerProviderImpl();
    }

    @Provides
    @Singleton
    static AppDatabase provideAppDatabase(Application application) {
        return (AppDatabase) Room.databaseBuilder(application, AppDatabase.class, "db-stops").build();
    }

    @Provides
    @Singleton
    static StopsDao providesStopsDao(AppDatabase appDatabase) {
        return appDatabase.getStopsDao();
    }

    @Provides
    @Singleton
    static SearchDao provideSearchDao(AppDatabase appDatabase) {
        return appDatabase.getSearchDao();
    }
}
