package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.dataprotection.DataProtectionActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {DataProtectionActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesDataProtectionActivity {

    @Subcomponent
    public interface DataProtectionActivitySubcomponent extends AndroidInjector<DataProtectionActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<DataProtectionActivity> {
        }
    }

    @Binds
    @ClassKey(DataProtectionActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(DataProtectionActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesDataProtectionActivity() {
    }
}
