package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MyPaymentCardsActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesMyCreditCardsActivity {

    @Subcomponent
    public interface MyPaymentCardsActivitySubcomponent extends AndroidInjector<MyPaymentCardsActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<MyPaymentCardsActivity> {
        }
    }

    @Binds
    @ClassKey(MyPaymentCardsActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MyPaymentCardsActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesMyCreditCardsActivity() {
    }
}
