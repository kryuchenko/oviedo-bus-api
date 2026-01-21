package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {IncidentsFragmentSubcomponent.class})
/* loaded from: classes5.dex */
public abstract class FragmentModule_ContributesIncidentsFragment {

    @Subcomponent
    public interface IncidentsFragmentSubcomponent extends AndroidInjector<IncidentsFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<IncidentsFragment> {
        }
    }

    @Binds
    @ClassKey(IncidentsFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(IncidentsFragmentSubcomponent.Factory builder);

    private FragmentModule_ContributesIncidentsFragment() {
    }
}
