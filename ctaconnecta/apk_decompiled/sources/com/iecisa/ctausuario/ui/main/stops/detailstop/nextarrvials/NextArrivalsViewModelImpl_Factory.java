package com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials;

import android.app.Application;
import com.iecisa.ctausuario.data.NotificationRepository;
import com.iecisa.ctausuario.data.StopsRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NextArrivalsViewModelImpl_Factory implements Factory<NextArrivalsViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NotificationRepository> notificationRepositoryProvider;
    private final Provider<StopsRepository> stopsRepositoryProvider;

    public NextArrivalsViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<StopsRepository> stopsRepositoryProvider, Provider<NotificationRepository> notificationRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.stopsRepositoryProvider = stopsRepositoryProvider;
        this.notificationRepositoryProvider = notificationRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public NextArrivalsViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.stopsRepositoryProvider.get(), this.notificationRepositoryProvider.get());
    }

    public static NextArrivalsViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<StopsRepository> stopsRepositoryProvider, Provider<NotificationRepository> notificationRepositoryProvider) {
        return new NextArrivalsViewModelImpl_Factory(applicationProvider, stopsRepositoryProvider, notificationRepositoryProvider);
    }

    public static NextArrivalsViewModelImpl newInstance(Application application, StopsRepository stopsRepository, NotificationRepository notificationRepository) {
        return new NextArrivalsViewModelImpl(application, stopsRepository, notificationRepository);
    }
}
