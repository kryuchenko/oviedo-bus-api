package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesMainActivity {

    @Subcomponent
    public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<MainActivity> {
        }
    }

    @Binds
    @ClassKey(MainActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MainActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesMainActivity() {
    }
}
