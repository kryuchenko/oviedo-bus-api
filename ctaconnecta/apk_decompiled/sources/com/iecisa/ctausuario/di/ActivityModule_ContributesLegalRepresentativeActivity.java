package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {LegalRepresentativeActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesLegalRepresentativeActivity {

    @Subcomponent
    public interface LegalRepresentativeActivitySubcomponent extends AndroidInjector<LegalRepresentativeActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<LegalRepresentativeActivity> {
        }
    }

    @Binds
    @ClassKey(LegalRepresentativeActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(LegalRepresentativeActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesLegalRepresentativeActivity() {
    }
}
