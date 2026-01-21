package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.BaseTransportCardActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BaseTransportCardActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesBaseTransportCardActivity {

    @Subcomponent
    public interface BaseTransportCardActivitySubcomponent extends AndroidInjector<BaseTransportCardActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<BaseTransportCardActivity> {
        }
    }

    @Binds
    @ClassKey(BaseTransportCardActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(BaseTransportCardActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesBaseTransportCardActivity() {
    }
}
