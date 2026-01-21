package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {RechargeRedsysActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesRechargeRedsysActivity {

    @Subcomponent
    public interface RechargeRedsysActivitySubcomponent extends AndroidInjector<RechargeRedsysActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<RechargeRedsysActivity> {
        }
    }

    @Binds
    @ClassKey(RechargeRedsysActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(RechargeRedsysActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesRechargeRedsysActivity() {
    }
}
