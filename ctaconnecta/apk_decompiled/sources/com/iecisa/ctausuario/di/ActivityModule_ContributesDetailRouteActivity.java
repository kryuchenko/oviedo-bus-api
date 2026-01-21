package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.route.detailroute.DetailRouteActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {DetailRouteActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesDetailRouteActivity {

    @Subcomponent
    public interface DetailRouteActivitySubcomponent extends AndroidInjector<DetailRouteActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<DetailRouteActivity> {
        }
    }

    @Binds
    @ClassKey(DetailRouteActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(DetailRouteActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesDetailRouteActivity() {
    }
}
