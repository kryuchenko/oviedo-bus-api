package com.iecisa.ctausuario.di;

import android.app.Application;
import com.iecisa.ctausuario.App;
import com.iecisa.ctausuario.data.api.RefreshInterceptor;
import com.iecisa.ctausuario.ui.main.notification.NotificationService;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import javax.inject.Singleton;

@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityModule.class, FragmentModule.class, ServiceModule.class, CoreModule.class})
@Singleton
/* loaded from: classes5.dex */
public interface AppComponent {

    @Component.Builder
    public interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(App app);

    void inject(RefreshInterceptor refreshInterceptor);

    void inject(NotificationService notificationService);
}
