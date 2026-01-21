package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {AddressPickerActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesAddressPickerActivity {

    @Subcomponent
    public interface AddressPickerActivitySubcomponent extends AndroidInjector<AddressPickerActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<AddressPickerActivity> {
        }
    }

    @Binds
    @ClassKey(AddressPickerActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(AddressPickerActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesAddressPickerActivity() {
    }
}
