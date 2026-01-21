package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.readcardnfc.ReadCardNfcActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ReadCardNfcActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesReadCardNfcActivity {

    @Subcomponent
    public interface ReadCardNfcActivitySubcomponent extends AndroidInjector<ReadCardNfcActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<ReadCardNfcActivity> {
        }
    }

    @Binds
    @ClassKey(ReadCardNfcActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(ReadCardNfcActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesReadCardNfcActivity() {
    }
}
