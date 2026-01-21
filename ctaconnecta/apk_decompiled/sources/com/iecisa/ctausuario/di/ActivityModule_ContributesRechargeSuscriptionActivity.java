package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {RechargeZonesActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesRechargeSuscriptionActivity {

    @Subcomponent
    public interface RechargeZonesActivitySubcomponent extends AndroidInjector<RechargeZonesActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<RechargeZonesActivity> {
        }
    }

    @Binds
    @ClassKey(RechargeZonesActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(RechargeZonesActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesRechargeSuscriptionActivity() {
    }
}
