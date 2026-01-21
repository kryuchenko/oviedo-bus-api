package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {LargeFamilyDiscountActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesLargeFamilyDiscountActivity {

    @Subcomponent
    public interface LargeFamilyDiscountActivitySubcomponent extends AndroidInjector<LargeFamilyDiscountActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<LargeFamilyDiscountActivity> {
        }
    }

    @Binds
    @ClassKey(LargeFamilyDiscountActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(LargeFamilyDiscountActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesLargeFamilyDiscountActivity() {
    }
}
