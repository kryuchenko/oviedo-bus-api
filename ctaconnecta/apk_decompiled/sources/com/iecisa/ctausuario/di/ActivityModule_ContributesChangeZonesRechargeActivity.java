package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ChangeZonesRechargeActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesChangeZonesRechargeActivity {

    @Subcomponent
    public interface ChangeZonesRechargeActivitySubcomponent extends AndroidInjector<ChangeZonesRechargeActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<ChangeZonesRechargeActivity> {
        }
    }

    @Binds
    @ClassKey(ChangeZonesRechargeActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(ChangeZonesRechargeActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesChangeZonesRechargeActivity() {
    }
}
