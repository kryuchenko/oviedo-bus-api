package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {LoginUserCardActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesLoginUserCardActivity {

    @Subcomponent
    public interface LoginUserCardActivitySubcomponent extends AndroidInjector<LoginUserCardActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<LoginUserCardActivity> {
        }
    }

    @Binds
    @ClassKey(LoginUserCardActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(LoginUserCardActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesLoginUserCardActivity() {
    }
}
