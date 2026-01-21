package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {NextArrivalsFragmentSubcomponent.class})
/* loaded from: classes5.dex */
public abstract class FragmentModule_ContributesNextArrivalsFragment {

    @Subcomponent
    public interface NextArrivalsFragmentSubcomponent extends AndroidInjector<NextArrivalsFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<NextArrivalsFragment> {
        }
    }

    @Binds
    @ClassKey(NextArrivalsFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(NextArrivalsFragmentSubcomponent.Factory builder);

    private FragmentModule_ContributesNextArrivalsFragment() {
    }
}
