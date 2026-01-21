package com.cexmobility.core.ui;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes.dex */
public class BaseViewModelFactory implements ViewModelProvider.Factory {
    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
    }

    @Inject
    public BaseViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
        this.creators = creators;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Provider<ViewModel> value = this.creators.get(modelClass);
        if (value == null) {
            Iterator<Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>>> it = this.creators.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> next = it.next();
                if (modelClass.isAssignableFrom(next.getKey())) {
                    value = next.getValue();
                    break;
                }
            }
        }
        if (value == null) {
            throw new IllegalArgumentException("unknown viewmodel class " + modelClass);
        }
        try {
            return (T) value.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
