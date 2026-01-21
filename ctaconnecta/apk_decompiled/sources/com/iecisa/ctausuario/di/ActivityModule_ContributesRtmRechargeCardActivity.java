package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmCardActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {RtmCardActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesRtmRechargeCardActivity {

    @Subcomponent
    public interface RtmCardActivitySubcomponent extends AndroidInjector<RtmCardActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<RtmCardActivity> {
        }
    }

    @Binds
    @ClassKey(RtmCardActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(RtmCardActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesRtmRechargeCardActivity() {
    }
}
