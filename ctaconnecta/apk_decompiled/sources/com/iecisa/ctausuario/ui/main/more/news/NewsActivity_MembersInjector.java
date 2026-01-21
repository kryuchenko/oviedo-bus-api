package com.iecisa.ctausuario.ui.main.more.news;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.cexmobility.core.ui.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NewsActivity_MembersInjector implements MembersInjector<NewsActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public NewsActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
        this.viewModelFactoryProvider = viewModelFactoryProvider;
    }

    public static MembersInjector<NewsActivity> create(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider, Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
        return new NewsActivity_MembersInjector(supportFragmentInjectorProvider, viewModelFactoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(NewsActivity instance) {
        BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, this.supportFragmentInjectorProvider.get());
        injectViewModelFactory(instance, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(NewsActivity instance, ViewModelProvider.Factory viewModelFactory) {
        instance.viewModelFactory = viewModelFactory;
    }
}
