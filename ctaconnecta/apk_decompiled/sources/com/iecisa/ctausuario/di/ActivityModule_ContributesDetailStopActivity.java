package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {DetailStopActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesDetailStopActivity {

    @Subcomponent
    public interface DetailStopActivitySubcomponent extends AndroidInjector<DetailStopActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<DetailStopActivity> {
        }
    }

    @Binds
    @ClassKey(DetailStopActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(DetailStopActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesDetailStopActivity() {
    }
}
