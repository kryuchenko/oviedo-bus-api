package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {AllLinesFragmentSubcomponent.class})
/* loaded from: classes5.dex */
public abstract class FragmentModule_ContributesAllLinesFragment {

    @Subcomponent
    public interface AllLinesFragmentSubcomponent extends AndroidInjector<AllLinesFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<AllLinesFragment> {
        }
    }

    @Binds
    @ClassKey(AllLinesFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(AllLinesFragmentSubcomponent.Factory builder);

    private FragmentModule_ContributesAllLinesFragment() {
    }
}
