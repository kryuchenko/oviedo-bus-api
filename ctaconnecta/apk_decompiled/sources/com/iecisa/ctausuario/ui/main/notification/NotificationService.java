package com.iecisa.ctausuario.ui.main.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.drive.DriveFile;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.iecisa.ctausuario.App;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelperImpl;
import com.iecisa.ctausuario.utils.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class NotificationService extends FirebaseMessagingService {
    private static final String CHANNEL_ID = "channel_id";
    private static final String GROUP_TYPE = "Notification";
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(final String token) {
        super.onNewToken(token);
        this.mainHandler.post(new Runnable() { // from class: com.iecisa.ctausuario.ui.main.notification.NotificationService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                App.getInstance().updateNotificationTokenStatus(token);
            }
        });
        Timber.d(getString(R.string.label_firebase_token_id, new Object[]{token}), new Object[0]);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String title;
        String body;
        PendingIntent activity;
        super.onMessageReceived(remoteMessage);
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        if (notification == null) {
            title = "";
            body = "";
        } else {
            title = notification.getTitle();
            body = notification.getBody();
        }
        String str = remoteMessage.getData().get(Constants.Notification.DATA_INFORMATION);
        Intent intentCreateNotificationIntent = createNotificationIntent(this, title, body, str);
        if (!TextUtils.isEmpty(str)) {
            startActivity(intentCreateNotificationIntent);
            return;
        }
        int id = getId();
        if (Build.VERSION.SDK_INT >= 23) {
            activity = PendingIntent.getActivity(this, id, intentCreateNotificationIntent, 201326592);
        } else {
            activity = PendingIntent.getActivity(this, id, intentCreateNotificationIntent, 134217728);
        }
        Notification notificationBuild = new NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle(title).setContentText(body).setSmallIcon(R.drawable.ic_bus).setColor(getResources().getColor(R.color.colorPrimary)).setGroup(GROUP_TYPE).setContentIntent(activity).setAutoCancel(true).build();
        Notification notificationBuild2 = new NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle(getString(R.string.summary_notifications)).setContentText(getString(R.string.title_notifications)).setSmallIcon(R.drawable.ic_bus).setColor(getResources().getColor(R.color.colorPrimary)).setGroup(GROUP_TYPE).setGroupSummary(true).setContentIntent(activity).setAutoCancel(true).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        notificationManager.notify(1, notificationBuild2);
        notificationManager.notify(id, notificationBuild);
    }

    public static int getId() {
        return Integer.parseInt(new SimpleDateFormat("ddHHmmss", Locale.US).format(new Date()));
    }

    public static Intent createNotificationIntent(Context context, String title, String message, String information) {
        Intent intent;
        if (TextUtils.isEmpty(information)) {
            intent = new Intent(context, (Class<?>) NotificationMessageActivity.class);
        } else {
            PreferencesHelperImpl preferencesHelperImpl = new PreferencesHelperImpl(context);
            if (!preferencesHelperImpl.isPendingCardRequest(information)) {
                preferencesHelperImpl.addPendingCardRequest(information, new Date());
            }
            Intent intent2 = new Intent(context, (Class<?>) DoBNotificationMessageActivity.class);
            intent2.putExtra(Constants.IntentData.INTENT_DOB_USER_ID, information);
            intent = intent2;
        }
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        intent.putExtra(Constants.IntentData.INTENT_NOTIFICATION_TITLE, title);
        intent.putExtra(Constants.IntentData.INTENT_NOTIFICATION_BODY, message);
        return intent;
    }
}
