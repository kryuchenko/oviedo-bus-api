package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {LoginTransportCardActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesLoginTransportCardActivity {

    @Subcomponent
    public interface LoginTransportCardActivitySubcomponent extends AndroidInjector<LoginTransportCardActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<LoginTransportCardActivity> {
        }
    }

    @Binds
    @ClassKey(LoginTransportCardActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(LoginTransportCardActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesLoginTransportCardActivity() {
    }
}
