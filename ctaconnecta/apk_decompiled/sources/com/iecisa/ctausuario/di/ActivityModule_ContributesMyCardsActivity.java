package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MyTransportCardsActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesMyCardsActivity {

    @Subcomponent
    public interface MyTransportCardsActivitySubcomponent extends AndroidInjector<MyTransportCardsActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<MyTransportCardsActivity> {
        }
    }

    @Binds
    @ClassKey(MyTransportCardsActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MyTransportCardsActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesMyCardsActivity() {
    }
}
