package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CertificateActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesCertificateActivity {

    @Subcomponent
    public interface CertificateActivitySubcomponent extends AndroidInjector<CertificateActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CertificateActivity> {
        }
    }

    @Binds
    @ClassKey(CertificateActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CertificateActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesCertificateActivity() {
    }
}
