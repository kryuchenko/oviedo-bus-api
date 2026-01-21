package com.iecisa.ctausuario.ui.main.notification;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;

/* loaded from: classes5.dex */
public class DoBNotificationMessageActivity extends AppCompatActivity {
    private String requestNumber;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestNumber = getIntent().getStringExtra(Constants.IntentData.INTENT_DOB_USER_ID);
        BaseUtils.showDialog(this, 0, getString(R.string.label_dictamination_finished_title), getString(R.string.label_dictamination_finished_description), getString(R.string.label_dictamination_finished_continue), getString(R.string.label_dictamination_finished_later), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.notification.DoBNotificationMessageActivity.1
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                Intent intent = new Intent(DoBNotificationMessageActivity.this.getBaseContext(), (Class<?>) TransportCardContinueRequestActivity.class);
                intent.putExtra(Constants.IntentData.INTENT_DOB_USER_ID, DoBNotificationMessageActivity.this.requestNumber);
                DoBNotificationMessageActivity.this.startActivity(intent);
                DoBNotificationMessageActivity.this.finish();
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
                DoBNotificationMessageActivity.this.onBackPressed();
                DoBNotificationMessageActivity.this.finish();
            }
        });
    }
}
