package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.datelines.DateTimeLineActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {DateTimeLineActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesDateTimeLineActivity {

    @Subcomponent
    public interface DateTimeLineActivitySubcomponent extends AndroidInjector<DateTimeLineActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<DateTimeLineActivity> {
        }
    }

    @Binds
    @ClassKey(DateTimeLineActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(DateTimeLineActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesDateTimeLineActivity() {
    }
}
