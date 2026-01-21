package com.cexmobility.core.ui;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class BaseViewModelFactory_Factory implements Factory<BaseViewModelFactory> {
    private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> creatorsProvider;

    public BaseViewModelFactory_Factory(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> creatorsProvider) {
        this.creatorsProvider = creatorsProvider;
    }

    @Override // javax.inject.Provider
    public BaseViewModelFactory get() {
        return newInstance(this.creatorsProvider.get());
    }

    public static BaseViewModelFactory_Factory create(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> creatorsProvider) {
        return new BaseViewModelFactory_Factory(creatorsProvider);
    }

    public static BaseViewModelFactory newInstance(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
        return new BaseViewModelFactory(creators);
    }
}
