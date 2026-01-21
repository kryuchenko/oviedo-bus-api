package com.iecisa.ctausuario;

import android.app.Activity;
import com.iecisa.ctausuario.data.NotificationRepository;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class App_MembersInjector implements MembersInjector<App> {
    private final Provider<DispatchingAndroidInjector<Activity>> activityInjectorProvider;
    private final Provider<NotificationRepository> notificationRepositoryProvider;
    private final Provider<PreferencesHelper> preferencesProvider;

    public App_MembersInjector(Provider<DispatchingAndroidInjector<Activity>> activityInjectorProvider, Provider<PreferencesHelper> preferencesProvider, Provider<NotificationRepository> notificationRepositoryProvider) {
        this.activityInjectorProvider = activityInjectorProvider;
        this.preferencesProvider = preferencesProvider;
        this.notificationRepositoryProvider = notificationRepositoryProvider;
    }

    public static MembersInjector<App> create(Provider<DispatchingAndroidInjector<Activity>> activityInjectorProvider, Provider<PreferencesHelper> preferencesProvider, Provider<NotificationRepository> notificationRepositoryProvider) {
        return new App_MembersInjector(activityInjectorProvider, preferencesProvider, notificationRepositoryProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(App instance) {
        injectActivityInjector(instance, this.activityInjectorProvider.get());
        injectPreferences(instance, this.preferencesProvider.get());
        injectNotificationRepository(instance, this.notificationRepositoryProvider.get());
    }

    public static void injectActivityInjector(App instance, DispatchingAndroidInjector<Activity> activityInjector) {
        instance.activityInjector = activityInjector;
    }

    public static void injectPreferences(App instance, PreferencesHelper preferences) {
        instance.preferences = preferences;
    }

    public static void injectNotificationRepository(App instance, NotificationRepository notificationRepository) {
        instance.notificationRepository = notificationRepository;
    }
}
