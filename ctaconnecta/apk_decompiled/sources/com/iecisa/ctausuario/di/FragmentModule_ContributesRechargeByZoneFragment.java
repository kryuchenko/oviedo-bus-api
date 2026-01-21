package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones.RechargeByZoneFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {RechargeByZoneFragmentSubcomponent.class})
/* loaded from: classes5.dex */
public abstract class FragmentModule_ContributesRechargeByZoneFragment {

    @Subcomponent
    public interface RechargeByZoneFragmentSubcomponent extends AndroidInjector<RechargeByZoneFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<RechargeByZoneFragment> {
        }
    }

    @Binds
    @ClassKey(RechargeByZoneFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(RechargeByZoneFragmentSubcomponent.Factory builder);

    private FragmentModule_ContributesRechargeByZoneFragment() {
    }
}
