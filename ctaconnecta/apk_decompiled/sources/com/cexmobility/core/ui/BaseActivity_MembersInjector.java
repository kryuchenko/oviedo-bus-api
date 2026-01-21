package com.cexmobility.core.ui;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class BaseActivity_MembersInjector implements MembersInjector<BaseActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;

    public BaseActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider) {
        this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
    }

    public static MembersInjector<BaseActivity> create(Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider) {
        return new BaseActivity_MembersInjector(supportFragmentInjectorProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BaseActivity instance) {
        injectSupportFragmentInjector(instance, this.supportFragmentInjectorProvider.get());
    }

    public static void injectSupportFragmentInjector(BaseActivity instance, DispatchingAndroidInjector<Fragment> supportFragmentInjector) {
        instance.supportFragmentInjector = supportFragmentInjector;
    }
}
