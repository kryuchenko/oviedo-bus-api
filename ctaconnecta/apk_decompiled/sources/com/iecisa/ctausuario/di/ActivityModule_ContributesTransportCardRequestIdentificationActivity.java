package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.identification.TransportCardRequestIdentificationActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {TransportCardRequestIdentificationActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesTransportCardRequestIdentificationActivity {

    @Subcomponent
    public interface TransportCardRequestIdentificationActivitySubcomponent extends AndroidInjector<TransportCardRequestIdentificationActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<TransportCardRequestIdentificationActivity> {
        }
    }

    @Binds
    @ClassKey(TransportCardRequestIdentificationActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(TransportCardRequestIdentificationActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesTransportCardRequestIdentificationActivity() {
    }
}
