package com.iecisa.ctausuario.ui.main.notification;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;

/* loaded from: classes5.dex */
public class NotificationMessageActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        BaseUtils.showBlockInfoDialog(this, 0, intent.getStringExtra(Constants.IntentData.INTENT_NOTIFICATION_TITLE), intent.getStringExtra(Constants.IntentData.INTENT_NOTIFICATION_BODY), getString(R.string.label_accept), new BaseUtils.onInfoBlockDialogListener() { // from class: com.iecisa.ctausuario.ui.main.notification.NotificationMessageActivity.1
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onInfoBlockDialogListener
            public void onClickPositive() {
                NotificationMessageActivity.this.onBackPressed();
                NotificationMessageActivity.this.finish();
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onInfoBlockDialogListener
            public void onDismiss() {
                NotificationMessageActivity.this.onBackPressed();
                NotificationMessageActivity.this.finish();
            }
        });
    }
}
