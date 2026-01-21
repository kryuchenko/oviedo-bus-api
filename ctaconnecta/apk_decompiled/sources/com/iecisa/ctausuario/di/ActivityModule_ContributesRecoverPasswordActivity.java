package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {RecoverPasswordActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesRecoverPasswordActivity {

    @Subcomponent
    public interface RecoverPasswordActivitySubcomponent extends AndroidInjector<RecoverPasswordActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<RecoverPasswordActivity> {
        }
    }

    @Binds
    @ClassKey(RecoverPasswordActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(RecoverPasswordActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesRecoverPasswordActivity() {
    }
}
