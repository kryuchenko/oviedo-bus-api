package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CreateReportsActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesCreateReportsActivity {

    @Subcomponent
    public interface CreateReportsActivitySubcomponent extends AndroidInjector<CreateReportsActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CreateReportsActivity> {
        }
    }

    @Binds
    @ClassKey(CreateReportsActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CreateReportsActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesCreateReportsActivity() {
    }
}
