package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.transportcard.detail.alias.ChangeAliasActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ChangeAliasActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesChangeAliasActivity {

    @Subcomponent
    public interface ChangeAliasActivitySubcomponent extends AndroidInjector<ChangeAliasActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<ChangeAliasActivity> {
        }
    }

    @Binds
    @ClassKey(ChangeAliasActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(ChangeAliasActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesChangeAliasActivity() {
    }
}
