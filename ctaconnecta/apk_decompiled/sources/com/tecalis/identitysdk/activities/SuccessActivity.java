package com.tecalis.identitysdk.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.tecalis.identitysdk.R;
import com.tecalis.identitysdk.SDK;
import com.tecalis.identitysdk.models.Customer;
import com.tecalis.identitysdk.utils.Toolbox;

/* loaded from: classes5.dex */
public class SuccessActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_success);
        final Customer customer = (Customer) getIntent().getParcelableExtra("customer");
        Toolbox.setTimeout(new Runnable() { // from class: com.tecalis.identitysdk.activities.SuccessActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m930x43fe2b5(customer);
            }
        }, DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
    }

    /* renamed from: lambda$onCreate$0$com-tecalis-identitysdk-activities-SuccessActivity, reason: not valid java name */
    /* synthetic */ void m930x43fe2b5(Customer customer) {
        SDK.onFlowEvent(customer);
        finish();
    }
}
