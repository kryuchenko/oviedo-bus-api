package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {AutomaticRechargeActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesAutomaticRechargeActivity {

    @Subcomponent
    public interface AutomaticRechargeActivitySubcomponent extends AndroidInjector<AutomaticRechargeActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<AutomaticRechargeActivity> {
        }
    }

    @Binds
    @ClassKey(AutomaticRechargeActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(AutomaticRechargeActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesAutomaticRechargeActivity() {
    }
}
