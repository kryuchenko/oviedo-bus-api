package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {TransportCardContinueRequestActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesTransportCardContinueRequestActivity {

    @Subcomponent
    public interface TransportCardContinueRequestActivitySubcomponent extends AndroidInjector<TransportCardContinueRequestActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<TransportCardContinueRequestActivity> {
        }
    }

    @Binds
    @ClassKey(TransportCardContinueRequestActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(TransportCardContinueRequestActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesTransportCardContinueRequestActivity() {
    }
}
