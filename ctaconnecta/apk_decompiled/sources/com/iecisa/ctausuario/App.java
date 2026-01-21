package com.iecisa.ctausuario;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.cexmobility.core.data.Resource;
import com.google.android.libraries.places.api.Places;
import com.iecisa.ctausuario.data.NotificationRepository;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.di.DaggerAppComponent;
import com.iecisa.ctausuario.model.notification.DeviceResponseModel;
import com.iecisa.ctausuario.model.token.TokenResponseModel;
import com.iecisa.ctausuario.ui.main.MainActivity;
import com.iecisa.ctausuario.utils.Constants;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import java.util.Locale;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class App extends Application implements HasActivityInjector, LifecycleObserver {
    private static App instance;

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Inject
    NotificationRepository notificationRepository;

    @Inject
    PreferencesHelper preferences;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        Places.initialize(getApplicationContext(), BuildConfig.PLACES_API_KEY);
        instance = this;
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
        DaggerAppComponent.builder().application(this).build().inject(this);
        Locale.setDefault(Constants.SPANISH);
        Timber.plant(new Timber.DebugTree() { // from class: com.iecisa.ctausuario.App.1
            @Override // timber.log.Timber.DebugTree
            protected String createStackElementTag(StackTraceElement element) {
                return super.createStackElementTag(element) + ':' + element.getLineNumber();
            }
        });
    }

    public static App getInstance() {
        App app = instance;
        if (app != null) {
            return app;
        }
        throw new Error();
    }

    @Override // dagger.android.HasActivityInjector
    public AndroidInjector<Activity> activityInjector() {
        return this.activityInjector;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void destroy() {
        Timber.e("ON_DESTROY", new Object[0]);
        this.preferences.removeBearerToken();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void restartApp() {
        if ((this.preferences.getUser().equals(1) || this.preferences.getUser().equals(2)) && this.preferences.getBearerToken() != null) {
            Timber.d("CLEAR SESSION AND NAVIGATE BACK", new Object[0]);
            this.preferences.removeBearerToken();
            this.preferences.setPassUser();
            Intent intent = new Intent(this, (Class<?>) MainActivity.class);
            intent.setFlags(335544320);
            startActivity(intent);
        }
    }

    public void updateNotificationTokenStatus(final String newToken) {
        if (newToken != null) {
            this.notificationRepository.getNotificationToken(this).observeForever(new Observer() { // from class: com.iecisa.ctausuario.App$$ExternalSyntheticLambda2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$updateNotificationTokenStatus$0(newToken, (Resource) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$updateNotificationTokenStatus$0(String str, Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            Timber.d(resource.message, new Object[0]);
            return;
        }
        if (i != 3 || resource.data == 0 || ((TokenResponseModel) resource.data).getToken() == null) {
            return;
        }
        if (((TokenResponseModel) resource.data).getToken().isEmpty()) {
            sendNotificationToken(str);
        } else {
            if (((TokenResponseModel) resource.data).getToken().equals(str)) {
                return;
            }
            updateNotificationToken(((TokenResponseModel) resource.data).getToken(), str);
        }
    }

    private void updateNotificationToken(String currentToken, final String pendingToken) {
        this.notificationRepository.updateDeviceToken(this, currentToken, pendingToken).observeForever(new Observer() { // from class: com.iecisa.ctausuario.App$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$updateNotificationToken$1(pendingToken, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateNotificationToken$1(String str, Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            Timber.d(resource.message, new Object[0]);
        } else {
            if (i != 3) {
                return;
            }
            this.preferences.saveDeviceToken(str);
            this.preferences.clearPendingDeviceToken();
            Timber.d(getString(R.string.label_device_token_id, new Object[]{this.preferences.getDeviceToken()}), new Object[0]);
        }
    }

    private void sendNotificationToken(final String newToken) {
        this.notificationRepository.addNotificationDevice(this, new DeviceResponseModel(newToken, 2)).observeForever(new Observer() { // from class: com.iecisa.ctausuario.App$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$sendNotificationToken$2(newToken, (Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.App$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$cexmobility$core$data$Resource$Status;

        static {
            int[] iArr = new int[Resource.Status.values().length];
            $SwitchMap$com$cexmobility$core$data$Resource$Status = iArr;
            try {
                iArr[Resource.Status.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$cexmobility$core$data$Resource$Status[Resource.Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$cexmobility$core$data$Resource$Status[Resource.Status.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendNotificationToken$2(String str, Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            Timber.d(resource.message, new Object[0]);
        } else {
            if (i != 3) {
                return;
            }
            this.preferences.saveDeviceToken(str);
            this.preferences.clearPendingDeviceToken();
        }
    }
}
