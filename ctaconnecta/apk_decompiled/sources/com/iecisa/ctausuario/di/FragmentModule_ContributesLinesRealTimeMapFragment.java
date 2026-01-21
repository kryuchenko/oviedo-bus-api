package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {LinesRealTimeMapFragmentSubcomponent.class})
/* loaded from: classes5.dex */
public abstract class FragmentModule_ContributesLinesRealTimeMapFragment {

    @Subcomponent
    public interface LinesRealTimeMapFragmentSubcomponent extends AndroidInjector<LinesRealTimeMapFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<LinesRealTimeMapFragment> {
        }
    }

    @Binds
    @ClassKey(LinesRealTimeMapFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(LinesRealTimeMapFragmentSubcomponent.Factory builder);

    private FragmentModule_ContributesLinesRealTimeMapFragment() {
    }
}
