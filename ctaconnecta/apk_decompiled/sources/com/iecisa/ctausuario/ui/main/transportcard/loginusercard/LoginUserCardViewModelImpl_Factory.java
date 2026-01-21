package com.iecisa.ctausuario.ui.main.transportcard.loginusercard;

import android.app.Application;
import com.iecisa.ctausuario.data.UserRepository;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import dagger.internal.Factory;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LoginUserCardViewModelImpl_Factory implements Factory<LoginUserCardViewModelImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<UserRepository> repositoryProvider;
    private final Provider<SchedulerProvider> schedulerProvider;

    public LoginUserCardViewModelImpl_Factory(Provider<Application> applicationProvider, Provider<UserRepository> repositoryProvider, Provider<CompositeDisposable> compositeDisposableProvider, Provider<SchedulerProvider> schedulerProvider) {
        this.applicationProvider = applicationProvider;
        this.repositoryProvider = repositoryProvider;
        this.compositeDisposableProvider = compositeDisposableProvider;
        this.schedulerProvider = schedulerProvider;
    }

    @Override // javax.inject.Provider
    public LoginUserCardViewModelImpl get() {
        return newInstance(this.applicationProvider.get(), this.repositoryProvider.get(), this.compositeDisposableProvider.get(), this.schedulerProvider.get());
    }

    public static LoginUserCardViewModelImpl_Factory create(Provider<Application> applicationProvider, Provider<UserRepository> repositoryProvider, Provider<CompositeDisposable> compositeDisposableProvider, Provider<SchedulerProvider> schedulerProvider) {
        return new LoginUserCardViewModelImpl_Factory(applicationProvider, repositoryProvider, compositeDisposableProvider, schedulerProvider);
    }

    public static LoginUserCardViewModelImpl newInstance(Application application, UserRepository repository, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        return new LoginUserCardViewModelImpl(application, repository, compositeDisposable, schedulerProvider);
    }
}
