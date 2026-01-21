package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.data.TransportCardRequestDataActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {TransportCardRequestDataActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesTransportCardRequestDataActivity {

    @Subcomponent
    public interface TransportCardRequestDataActivitySubcomponent extends AndroidInjector<TransportCardRequestDataActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<TransportCardRequestDataActivity> {
        }
    }

    @Binds
    @ClassKey(TransportCardRequestDataActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(TransportCardRequestDataActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesTransportCardRequestDataActivity() {
    }
}
