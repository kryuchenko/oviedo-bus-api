package com.iecisa.ctausuario.ui.splash;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import com.cexmobility.core.ui.BaseActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.ui.main.MainActivity;
import com.iecisa.ctausuario.ui.main.notification.NotificationService;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SplashActivity extends BaseActivity {
    protected static final long DELAY_MILLIS = 2000;
    final Handler handler = new Handler();

    @Inject
    PreferencesHelper preferences;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.preferences.removeBearerToken();
        this.preferences.setPassUser();
        final FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        firebaseRemoteConfig.setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(0L).build());
        firebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(this, new OnCompleteListener() { // from class: com.iecisa.ctausuario.ui.splash.SplashActivity$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$initializeView$1(firebaseRemoteConfig, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeView$1(final FirebaseRemoteConfig firebaseRemoteConfig, Task task) {
        if (task.isSuccessful()) {
            this.handler.postDelayed(new Runnable() { // from class: com.iecisa.ctausuario.ui.splash.SplashActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$initializeView$0(firebaseRemoteConfig);
                }
            }, DELAY_MILLIS);
        } else {
            goToMain();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeView$0(FirebaseRemoteConfig firebaseRemoteConfig) {
        if (compareVersionApp(firebaseRemoteConfig)) {
            goToMain();
        } else {
            showDialogErrorVersion();
        }
    }

    private void goToMain() {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        processBackgroundNotificationIntent();
        finish();
    }

    private boolean compareVersionApp(FirebaseRemoteConfig firebaseRemoteConfig) {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode >= Integer.parseInt(firebaseRemoteConfig.getString(Constants.Firebase.VERSION_APP));
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    private void showDialogErrorVersion() {
        BaseUtils.showInfoDialog(this, 5, getString(R.string.warning_version), getString(R.string.error_version_app), getString(R.string.label_update), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.splash.SplashActivity$$ExternalSyntheticLambda2
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.lambda$showDialogErrorVersion$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogErrorVersion$2() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
        finish();
    }

    private void processBackgroundNotificationIntent() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString("title");
            String string2 = extras.getString(Constants.Notification.DATA_MESSAGE);
            String string3 = extras.getString(Constants.Notification.DATA_INFORMATION);
            if (string == null || string2 == null) {
                return;
            }
            startActivity(NotificationService.createNotificationIntent(this, string, string2, string3));
        }
    }
}
