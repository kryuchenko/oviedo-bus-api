package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.more.settings.SettingsActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SettingsActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesSettingsActivity {

    @Subcomponent
    public interface SettingsActivitySubcomponent extends AndroidInjector<SettingsActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<SettingsActivity> {
        }
    }

    @Binds
    @ClassKey(SettingsActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(SettingsActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesSettingsActivity() {
    }
}
