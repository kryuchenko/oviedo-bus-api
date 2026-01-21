package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway;

import android.content.Intent;
import android.graphics.Bitmap;
import android.nfc.NfcAdapter;
import android.util.Base64;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseActivity;
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.OnlineRechargeResponseModel;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class RechargeRedsysActivity extends BaseActivity {
    protected static final String CHARSET = StandardCharsets.UTF_8.displayName();
    protected static final String PAYMENT_URL = "/sis/pagoTarjeta";
    private NfcAdapter nfcAdapter;

    @Inject
    PreferencesHelper preferences;
    private String quantity;
    private Integer userType;
    private RechargeRedsysViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.wbRedsys)
    WebView wbRedsys;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_recharge_redsys;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() throws JSONException {
        this.viewModel = (RechargeRedsysViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(RechargeRedsysViewModelImpl.class);
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        setExtUser();
        if (getIntent().getExtras() != null) {
            OnlineRechargeResponseModel onlineRechargeResponseModel = (OnlineRechargeResponseModel) getIntent().getExtras().getParcelable(Constants.IntentData.INTENT_TYPE_RECHARGE_WEBVIEW);
            this.quantity = getIntent().getExtras().getString(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_QUANTITY);
            if (onlineRechargeResponseModel != null) {
                setupWebView(onlineRechargeResponseModel);
            }
        }
    }

    private void setExtUser() {
        this.userType = this.preferences.getUser();
        this.preferences.setExtUser();
    }

    private void setupWebView(OnlineRechargeResponseModel model) throws JSONException {
        try {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.wbRedsys, true);
            JSONObject jSONObject = new JSONObject(new String(Base64.decode(model.getDsMerchantParameters(), 0)));
            final String string = jSONObject.getString("Ds_Merchant_UrlOK");
            final String string2 = jSONObject.getString("Ds_Merchant_UrlKO");
            StringBuilder sb = new StringBuilder("Ds_MerchantParameters=");
            String dsMerchantParameters = model.getDsMerchantParameters();
            String str = CHARSET;
            sb.append(URLEncoder.encode(dsMerchantParameters, str));
            StringBuilder sb2 = new StringBuilder(sb.toString());
            sb2.append("&Ds_SignatureVersion=" + URLEncoder.encode(model.getDsSignatureVersion(), str));
            sb2.append("&Ds_Signature=" + URLEncoder.encode(model.getDsSignature(), str));
            String string3 = sb2.toString();
            this.wbRedsys.getSettings().setJavaScriptEnabled(true);
            this.wbRedsys.postUrl(BuildConfig.BASE_URL_REDSYS, string3.getBytes());
            this.wbRedsys.setWebViewClient(new WebViewClient() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysActivity.1
                @Override // android.webkit.WebViewClient
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    RechargeRedsysActivity.this.showLoading();
                    super.onPageStarted(view, url, favicon);
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    RechargeRedsysActivity.this.hideLoading();
                }

                @Override // android.webkit.WebViewClient
                public void onLoadResource(WebView view, String url) {
                    if (url.contains(RechargeRedsysActivity.PAYMENT_URL)) {
                        RechargeRedsysActivity.this.showLoading();
                    }
                    super.onLoadResource(view, url);
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    if (request.getUrl().toString().equals(string)) {
                        if (RechargeRedsysActivity.this.checkNFC()) {
                            RechargeRedsysActivity.this.goBackSuccess();
                        } else {
                            RechargeRedsysActivity.this.goToOkDialog();
                        }
                        return true;
                    }
                    if (!request.getUrl().toString().equals(string2)) {
                        return false;
                    }
                    RechargeRedsysActivity.this.goToKoDialog();
                    return true;
                }
            });
        } catch (UnsupportedEncodingException | JSONException e) {
            Timber.e(e, "Error codificando a " + CHARSET + " los valores de los parámetros de pago", new Object[0]);
            goToKoDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToOkDialog() {
        String str = this.quantity;
        if (str != null) {
            BaseUtils.showInfoDialog(this, 3, getString(R.string.label_recharge_ok_price, new Object[]{str}), getString(R.string.label_recharge_not_nfc), getString(R.string.label_finish_recharge_button), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysActivity$$ExternalSyntheticLambda0
                @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
                public final void onClickPositive() {
                    this.f$0.goBackSuccess();
                }
            });
        } else {
            goBackSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBackSuccess() {
        goBack(9);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        goBack(10);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.wbRedsys.clearCache(true);
        this.wbRedsys.destroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToKoDialog() {
        BaseUtils.showDialog(this, 2, getString(R.string.label_something_go_wrong), getString(R.string.label_example_fail_card), getString(R.string.label_retry), getString(R.string.label_retry_later), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysActivity.2
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                RechargeRedsysActivity.this.goBack(11);
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
                RechargeRedsysActivity.this.goBack(10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBack(int resultCode) {
        Integer num = this.userType;
        if (num != null) {
            this.preferences.saveUser(num);
        }
        setResult(resultCode, new Intent());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkNFC() {
        Resource.Status statusInitNfcAdapter = this.viewModel.initNfcAdapter(this.nfcAdapter);
        if (statusInitNfcAdapter == Resource.Status.ERROR) {
            setResult(0, new Intent());
            return false;
        }
        if (statusInitNfcAdapter == Resource.Status.LOADING) {
            setResult(0, new Intent());
        }
        return true;
    }
}
