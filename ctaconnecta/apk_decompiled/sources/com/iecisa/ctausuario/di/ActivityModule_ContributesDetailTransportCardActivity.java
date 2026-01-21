package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {DetailTransportCardActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesDetailTransportCardActivity {

    @Subcomponent
    public interface DetailTransportCardActivitySubcomponent extends AndroidInjector<DetailTransportCardActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<DetailTransportCardActivity> {
        }
    }

    @Binds
    @ClassKey(DetailTransportCardActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(DetailTransportCardActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesDetailTransportCardActivity() {
    }
}
