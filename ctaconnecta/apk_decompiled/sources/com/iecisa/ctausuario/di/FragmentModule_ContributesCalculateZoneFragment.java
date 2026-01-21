package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CalculateZoneFragmentSubcomponent.class})
/* loaded from: classes5.dex */
public abstract class FragmentModule_ContributesCalculateZoneFragment {

    @Subcomponent
    public interface CalculateZoneFragmentSubcomponent extends AndroidInjector<CalculateZoneFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CalculateZoneFragment> {
        }
    }

    @Binds
    @ClassKey(CalculateZoneFragment.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CalculateZoneFragmentSubcomponent.Factory builder);

    private FragmentModule_ContributesCalculateZoneFragment() {
    }
}
