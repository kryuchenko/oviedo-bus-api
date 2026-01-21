package com.iecisa.ctausuario.ui.main.route.detailroute;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DetailRouteViewModelImpl_Factory implements Factory<DetailRouteViewModelImpl> {
    private final Provider<Application> applicationProvider;

    public DetailRouteViewModelImpl_Factory(Provider<Application> applicationProvider) {
        this.applicationProvider = applicationProvider;
    }

    @Override // javax.inject.Provider
    public DetailRouteViewModelImpl get() {
        return newInstance(this.applicationProvider.get());
    }

    public static DetailRouteViewModelImpl_Factory create(Provider<Application> applicationProvider) {
        return new DetailRouteViewModelImpl_Factory(applicationProvider);
    }

    public static DetailRouteViewModelImpl newInstance(Application application) {
        return new DetailRouteViewModelImpl(application);
    }
}
