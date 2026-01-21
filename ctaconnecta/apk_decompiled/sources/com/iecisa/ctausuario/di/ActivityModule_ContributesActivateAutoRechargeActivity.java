package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ActivateAutoRechargeActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesActivateAutoRechargeActivity {

    @Subcomponent
    public interface ActivateAutoRechargeActivitySubcomponent extends AndroidInjector<ActivateAutoRechargeActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<ActivateAutoRechargeActivity> {
        }
    }

    @Binds
    @ClassKey(ActivateAutoRechargeActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(ActivateAutoRechargeActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesActivateAutoRechargeActivity() {
    }
}
