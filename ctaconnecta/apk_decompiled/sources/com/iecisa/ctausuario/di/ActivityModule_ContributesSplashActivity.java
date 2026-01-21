package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.splash.SplashActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SplashActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesSplashActivity {

    @Subcomponent
    public interface SplashActivitySubcomponent extends AndroidInjector<SplashActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<SplashActivity> {
        }
    }

    @Binds
    @ClassKey(SplashActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(SplashActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesSplashActivity() {
    }
}
