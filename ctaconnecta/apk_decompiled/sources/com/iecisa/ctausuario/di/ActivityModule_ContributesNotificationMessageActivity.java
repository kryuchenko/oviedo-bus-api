package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.notification.NotificationMessageActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {NotificationMessageActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesNotificationMessageActivity {

    @Subcomponent
    public interface NotificationMessageActivitySubcomponent extends AndroidInjector<NotificationMessageActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<NotificationMessageActivity> {
        }
    }

    @Binds
    @ClassKey(NotificationMessageActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(NotificationMessageActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesNotificationMessageActivity() {
    }
}
