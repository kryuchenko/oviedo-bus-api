package com.tecalis.identitysdk.activities.kyc;

import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.tecalis.identitysdk.R;
import com.tecalis.identitysdk.SDK;
import com.tecalis.identitysdk.utils.Toolbox;

/* loaded from: classes5.dex */
public class KycActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSIONS = 2000;
    public static KycActivity instance;
    private WebView webview;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_web_view);
        instance = this;
        this.webview = (WebView) findViewById(R.id.webview);
        if (!checkPermissions()) {
            requestPermissions();
        } else {
            setWebview();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length <= 0 || i != 2000) {
            return;
        }
        setWebview();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.webview.saveState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.webview.restoreState(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.webview.destroy();
        super.onDestroy();
    }

    @JavascriptInterface
    public void onFlowComplete() {
        Log.e("TestSDK", "onFlowComplete");
        Toolbox.setTimeout(new Runnable() { // from class: com.tecalis.identitysdk.activities.kyc.KycActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m931x47f8f2a4();
            }
        }, DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
    }

    /* renamed from: lambda$onFlowComplete$0$com-tecalis-identitysdk-activities-kyc-KycActivity, reason: not valid java name */
    /* synthetic */ void m931x47f8f2a4() {
        SDK.onFlowEvent(null);
        finish();
    }

    private void setWebview() {
        WebSettings settings = this.webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        this.webview.setWebChromeClient(new WebChromeClient() { // from class: com.tecalis.identitysdk.activities.kyc.KycActivity.1
            @Override // android.webkit.WebChromeClient
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                permissionRequest.grant(permissionRequest.getResources());
            }
        });
        this.webview.setWebViewClient(new WebViewClient() { // from class: com.tecalis.identitysdk.activities.kyc.KycActivity.2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return false;
            }
        });
        this.webview.addJavascriptInterface(this, "IdentitySDK");
        this.webview.loadUrl(getIntent().getExtras().getString(ImagesContract.URL, ""));
        Log.e("WebViewUrl", getIntent().getExtras().getString(ImagesContract.URL, ""));
    }

    private boolean checkPermissions() {
        return ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 2000);
    }

    public static KycActivity getInstance() {
        return instance;
    }
}
