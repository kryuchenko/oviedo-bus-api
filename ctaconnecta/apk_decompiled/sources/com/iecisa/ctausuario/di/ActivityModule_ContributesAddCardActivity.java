package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.addcard.AddCardActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {AddCardActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesAddCardActivity {

    @Subcomponent
    public interface AddCardActivitySubcomponent extends AndroidInjector<AddCardActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<AddCardActivity> {
        }
    }

    @Binds
    @ClassKey(AddCardActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(AddCardActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesAddCardActivity() {
    }
}
