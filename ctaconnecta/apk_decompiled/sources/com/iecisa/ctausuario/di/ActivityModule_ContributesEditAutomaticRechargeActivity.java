package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {EditAutomaticRechargeActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesEditAutomaticRechargeActivity {

    @Subcomponent
    public interface EditAutomaticRechargeActivitySubcomponent extends AndroidInjector<EditAutomaticRechargeActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<EditAutomaticRechargeActivity> {
        }
    }

    @Binds
    @ClassKey(EditAutomaticRechargeActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(EditAutomaticRechargeActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesEditAutomaticRechargeActivity() {
    }
}
