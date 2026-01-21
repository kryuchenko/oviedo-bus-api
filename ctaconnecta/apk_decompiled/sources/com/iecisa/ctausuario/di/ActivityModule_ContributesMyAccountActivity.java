package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MyAccountActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesMyAccountActivity {

    @Subcomponent
    public interface MyAccountActivitySubcomponent extends AndroidInjector<MyAccountActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<MyAccountActivity> {
        }
    }

    @Binds
    @ClassKey(MyAccountActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MyAccountActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesMyAccountActivity() {
    }
}
