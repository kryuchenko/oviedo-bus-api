package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {FavouriteStopsFragmentSubcomponent.class})
/* loaded from: classes5.dex */
public abstract class FragmentModule_ContributesFavouriteStopsFragment {

    @Subcomponent
    public interface FavouriteStopsFragmentSubcomponent extends AndroidInjector<FavouriteStopsFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<FavouriteStopsFragment> {
        }
    }

    @Binds
    @ClassKey(FavouriteStopsFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(FavouriteStopsFragmentSubcomponent.Factory builder);

    private FragmentModule_ContributesFavouriteStopsFragment() {
    }
}
