package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {LinesRealTimeActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesLinesRealTimeActivity {

    @Subcomponent
    public interface LinesRealTimeActivitySubcomponent extends AndroidInjector<LinesRealTimeActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<LinesRealTimeActivity> {
        }
    }

    @Binds
    @ClassKey(LinesRealTimeActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(LinesRealTimeActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesLinesRealTimeActivity() {
    }
}
