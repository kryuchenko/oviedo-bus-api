package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {RechargeBalanceCardActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesRechargeAmountCardActivity {

    @Subcomponent
    public interface RechargeBalanceCardActivitySubcomponent extends AndroidInjector<RechargeBalanceCardActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<RechargeBalanceCardActivity> {
        }
    }

    @Binds
    @ClassKey(RechargeBalanceCardActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(RechargeBalanceCardActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesRechargeAmountCardActivity() {
    }
}
