package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {DestinationUserSelectorActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesDestinationUserSelectorActivity {

    @Subcomponent
    public interface DestinationUserSelectorActivitySubcomponent extends AndroidInjector<DestinationUserSelectorActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<DestinationUserSelectorActivity> {
        }
    }

    @Binds
    @ClassKey(DestinationUserSelectorActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(DestinationUserSelectorActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesDestinationUserSelectorActivity() {
    }
}
