package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.linesrealtime.lineslist.LinesRealTimeListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {LinesRealTimeListFragmentSubcomponent.class})
/* loaded from: classes5.dex */
public abstract class FragmentModule_ContributesLinesRealTimeListFragment {

    @Subcomponent
    public interface LinesRealTimeListFragmentSubcomponent extends AndroidInjector<LinesRealTimeListFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<LinesRealTimeListFragment> {
        }
    }

    @Binds
    @ClassKey(LinesRealTimeListFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(LinesRealTimeListFragmentSubcomponent.Factory builder);

    private FragmentModule_ContributesLinesRealTimeListFragment() {
    }
}
