package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {AccessSettingsActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesAccessSettingsActivity {

    @Subcomponent
    public interface AccessSettingsActivitySubcomponent extends AndroidInjector<AccessSettingsActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<AccessSettingsActivity> {
        }
    }

    @Binds
    @ClassKey(AccessSettingsActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(AccessSettingsActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesAccessSettingsActivity() {
    }
}
