package com.iecisa.ctausuario.ui.main.transportcard.dataprotection;

import android.app.Application;
import com.iecisa.ctausuario.data.TransportCardRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DataProtectionViewModelImpl_Factory implements Factory<DataProtectionViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<TransportCardRepository> transportCardRepositoryProvider;

    public DataProtectionViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider) {
        this.applicationProvider = applicationProvider;
        this.transportCardRepositoryProvider = transportCardRepositoryProvider;
    }

    @Override // javax.inject.Provider
    public DataProtectionViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.transportCardRepositoryProvider.get());
    }

    public static DataProtectionViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<TransportCardRepository> transportCardRepositoryProvider) {
        return new DataProtectionViewModelImpl_Factory(applicationProvider, transportCardRepositoryProvider);
    }

    public static DataProtectionViewModelImpl newInstance(Application application, TransportCardRepository transportCardRepository) {
        return new DataProtectionViewModelImpl(application, transportCardRepository);
    }
}
