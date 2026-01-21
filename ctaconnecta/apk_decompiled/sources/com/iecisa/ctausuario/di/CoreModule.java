package com.iecisa.ctausuario.di;

import android.app.Application;
import android.content.Context;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.data.preferences.PreferencesHelperImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
/* loaded from: classes5.dex */
public abstract class CoreModule {
    @Provides
    @Singleton
    static PreferencesHelper providePreferencesHelper(PreferencesHelperImpl preferencesHelper) {
        return preferencesHelper;
    }

    @Singleton
    @Binds
    public abstract Context context(Application application);
}
