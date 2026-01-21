package com.iecisa.ctausuario.ui.main.stops.detailstop.alllines;

import android.app.Application;
import com.iecisa.ctausuario.data.LinesRepository;
import com.iecisa.ctausuario.data.NotificationRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AllLinesViewModelImpl_Factory implements Factory<AllLinesViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<LinesRepository> linesRepositoryProvider;
    private final Provider<NotificationRepository> notificationRepositoryProvider;

    public AllLinesViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<LinesRepository> linesRepositoryProvider, Provider<NotificationRepository> notificationRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.linesRepositoryProvider = linesRepositoryProvider;
        this.notificationRepositoryProvider = notificationRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public AllLinesViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.linesRepositoryProvider.get(), this.notificationRepositoryProvider.get());
    }

    public static AllLinesViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<LinesRepository> linesRepositoryProvider, Provider<NotificationRepository> notificationRepositoryProvider) {
        return new AllLinesViewModelImpl_Factory(applicationProvider, linesRepositoryProvider, notificationRepositoryProvider);
    }

    public static AllLinesViewModelImpl newInstance(Application application, LinesRepository linesRepository, NotificationRepository notificationRepository) {
        return new AllLinesViewModelImpl(application, linesRepository, notificationRepository);
    }
}
