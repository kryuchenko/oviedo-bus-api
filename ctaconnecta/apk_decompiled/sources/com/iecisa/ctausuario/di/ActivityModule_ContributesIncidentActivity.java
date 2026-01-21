package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.detail.incident.IncidentActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {IncidentActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesIncidentActivity {

    @Subcomponent
    public interface IncidentActivitySubcomponent extends AndroidInjector<IncidentActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<IncidentActivity> {
        }
    }

    @Binds
    @ClassKey(IncidentActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(IncidentActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesIncidentActivity() {
    }
}
