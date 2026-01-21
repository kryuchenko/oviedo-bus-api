package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.stops.searchstop.SearchStopsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SearchStopsFragmentSubcomponent.class})
/* loaded from: classes5.dex */
public abstract class FragmentModule_ContributesSearchStopsFragment {

    @Subcomponent
    public interface SearchStopsFragmentSubcomponent extends AndroidInjector<SearchStopsFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<SearchStopsFragment> {
        }
    }

    @Binds
    @ClassKey(SearchStopsFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(SearchStopsFragmentSubcomponent.Factory builder);

    private FragmentModule_ContributesSearchStopsFragment() {
    }
}
