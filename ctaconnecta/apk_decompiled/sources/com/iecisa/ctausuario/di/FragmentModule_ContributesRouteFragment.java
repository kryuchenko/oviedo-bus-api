package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.route.RouteFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {RouteFragmentSubcomponent.class})
/* loaded from: classes5.dex */
public abstract class FragmentModule_ContributesRouteFragment {

    @Subcomponent
    public interface RouteFragmentSubcomponent extends AndroidInjector<RouteFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<RouteFragment> {
        }
    }

    @Binds
    @ClassKey(RouteFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(RouteFragmentSubcomponent.Factory builder);

    private FragmentModule_ContributesRouteFragment() {
    }
}
