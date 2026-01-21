package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {TransportCardRequestInfoActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesTransportCardRequestInfoActivity {

    @Subcomponent
    public interface TransportCardRequestInfoActivitySubcomponent extends AndroidInjector<TransportCardRequestInfoActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<TransportCardRequestInfoActivity> {
        }
    }

    @Binds
    @ClassKey(TransportCardRequestInfoActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(TransportCardRequestInfoActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesTransportCardRequestInfoActivity() {
    }
}
