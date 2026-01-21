package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MapStopsFragmentSubcomponent.class})
/* loaded from: classes5.dex */
public abstract class FragmentModule_ContributesMapStopsFragment {

    @Subcomponent
    public interface MapStopsFragmentSubcomponent extends AndroidInjector<MapStopsFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<MapStopsFragment> {
        }
    }

    @Binds
    @ClassKey(MapStopsFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MapStopsFragmentSubcomponent.Factory builder);

    private FragmentModule_ContributesMapStopsFragment() {
    }
}
