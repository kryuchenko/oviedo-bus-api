package com.iecisa.ctausuario.ui.main;

import android.app.Application;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.NotificationRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MainViewModelImpl_Factory implements Factory<MainViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<NfcRepository> nfcRepositoryProvider;
    private final Provider<NotificationRepository> notificationRepositoryProvider;

    public MainViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<NfcRepository> nfcRepositoryProvider, Provider<NotificationRepository> notificationRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.nfcRepositoryProvider = nfcRepositoryProvider;
        this.notificationRepositoryProvider = notificationRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public MainViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.nfcRepositoryProvider.get(), this.notificationRepositoryProvider.get());
    }

    public static MainViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<NfcRepository> nfcRepositoryProvider, Provider<NotificationRepository> notificationRepositoryProvider) {
        return new MainViewModelImpl_Factory(applicationProvider, nfcRepositoryProvider, notificationRepositoryProvider);
    }

    public static MainViewModelImpl newInstance(Application application, NfcRepository nfcRepository, NotificationRepository notificationRepository) {
        return new MainViewModelImpl(application, nfcRepository, notificationRepository);
    }
}
