package com.iecisa.ctausuario.ui.main.transportcard.rtm;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NdefFormatable;
import android.nfc.tech.NfcA;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;
import com.airbnb.lottie.LottieAnimationView;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseActivity;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.common.net.HttpHeaders;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.LoginRequest;
import com.iecisa.ctausuario.model.NfcDetailResponseModel;
import com.iecisa.ctausuario.model.TokenModel;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.Utils;
import com.palmatools.sdk.NfcHandle;
import com.palmatools.sdk.model.ClsApduMessage;
import com.palmatools.sdk.model.ClsErrorMessage;
import com.palmatools.sdk.model.ClsTextMessage;
import java.io.IOException;
import java.util.HashMap;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class RtmCardActivity extends BaseActivity implements NfcHandle.Callback {
    private String alias;
    private TransportCardModel cardModel;
    private String cardNumber;
    private String cardTypeName;
    private IntentFilter[] intentFiltersArray;

    @BindView(R.id.lottieCard)
    LottieAnimationView lottieAnimationView;
    private NfcAdapter nfcAdapter;
    private NfcHandle nfcHandle;
    private PendingIntent nfcPendingIntent;

    @Inject
    PreferencesHelper preferences;
    private Integer rechargeQuantity;
    private Integer rechargeTrips;
    private Tag tag;
    private String[][] techListsArray;
    private String tokenBearer;

    @BindView(R.id.tvInfoMessage)
    TextView tvInfoMessage;

    @BindView(R.id.tvLabelGetCardCloseToPhone)
    TextView tvLabelGetCardCloseToPhone;
    private int typeRtm;
    private Integer userType;
    private RtmViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private IsoDep isoDep = null;
    private boolean close = false;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_rtm_recharge_card;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.palmatools.sdk.NfcHandle.Callback
    public void onPreExecute() {
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (RtmViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(RtmViewModelImpl.class);
        setupHandle();
        saveAndPickStatus();
        this.tokenBearer = this.preferences.getBearerToken();
        setupAnimation();
        setNfcAdapter();
        if (this.preferences.getBearerToken() != null) {
            setupView();
        } else {
            login(false);
        }
    }

    private void saveAndPickStatus() {
        this.userType = this.preferences.getUser();
        this.preferences.setRtmUser();
    }

    private void setupView() {
        setupExtras();
        setupIntent();
    }

    private void login(final boolean isRefresh) {
        this.viewModel.login(new LoginRequest(BuildConfig.LOGIN_USER, BuildConfig.LOGIN_PASS), this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmCardActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) throws IOException {
                this.f$0.lambda$login$0(isRefresh, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$login$0(boolean z, Resource resource) throws IOException {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            onBackPressed();
            return;
        }
        if (i == 2) {
            showLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        hideLoading();
        if (resource.data != 0) {
            if (!z) {
                setupActivity((TokenModel) resource.data);
            } else {
                saveAndLoadRtm((TokenModel) resource.data);
            }
        }
    }

    private void saveAndLoadRtm(TokenModel model) throws IOException {
        this.preferences.saveTokens(model.getToken(), model.getRefreshToken());
        this.tokenBearer = model.getToken();
        processIsoTag(IsoDep.get(this.tag));
    }

    private void setupActivity(TokenModel model) {
        this.preferences.saveTokens(model.getToken(), model.getRefreshToken());
        setupView();
        enableNfc();
    }

    private void setupIntent() {
        Intent intent = new Intent(this, getClass());
        intent.addFlags(536870912);
        this.nfcPendingIntent = PendingIntent.getActivity(this, 0, intent, MediaHttpDownloader.MAXIMUM_CHUNK_SIZE);
        this.intentFiltersArray = new IntentFilter[]{new IntentFilter("android.nfc.action.TECH_DISCOVERED")};
        this.techListsArray = new String[][]{new String[]{IsoDep.class.getName(), NfcA.class.getName(), NdefFormatable.class.getName()}};
    }

    private void setNfcAdapter() {
        this.nfcHandle.setCallback(this);
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
    }

    private void setupExtras() {
        if (getIntent().getExtras() != null) {
            if (getIntent().getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER) instanceof TransportCardModel) {
                this.cardModel = (TransportCardModel) getIntent().getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER);
            } else if (getIntent().getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER) instanceof String) {
                this.cardNumber = getIntent().getStringExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER);
            }
        }
        this.alias = getIntent().getExtras().getString(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_ALIAS);
        this.cardTypeName = getIntent().getExtras().getString(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TYPE_NAME);
        this.rechargeQuantity = Integer.valueOf(getIntent().getExtras().getInt(Constants.IntentData.INTENT_RECHARGE_QUANTITY, 0));
        this.rechargeTrips = Integer.valueOf(getIntent().getExtras().getInt(Constants.IntentData.INTENT_RECHARGE_TRIPS, 0));
        this.typeRtm = getIntent().getExtras().getInt(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TYPE_RTM, 0);
        boolean z = getIntent().getExtras().getBoolean(Constants.IntentData.INTENT_READ_CARD, false);
        int i = this.typeRtm;
        if (i != 2) {
            if (i == 3) {
                showSuccessMessage(getString(R.string.card_reactivated));
            }
        } else if (this.rechargeQuantity.intValue() != 0) {
            showSuccessMessage(getString(R.string.label_rtm_recharge_amount, new Object[]{Double.valueOf(Utils.INSTANCE.getEuros(this.rechargeQuantity))}));
        } else if (this.rechargeTrips.intValue() != 0) {
            showSuccessMessage(getString(R.string.label_rtm_recharge_trips, new Object[]{this.rechargeTrips}));
        } else {
            if (z) {
                return;
            }
            showSuccessMessage(getString(R.string.label_buy_new_pass));
        }
    }

    private void showSuccessMessage(String message) {
        this.tvInfoMessage.setText(message);
        setColorMessage(this.tvInfoMessage, getResources().getColor(R.color.green_toogle_button), getResources().getColor(R.color.text_color));
        BaseUtils.showInfoMessage(this.tvInfoMessage);
    }

    private void setColorMessage(TextView textView, int backgroundColor, int textColor) {
        textView.setBackgroundColor(backgroundColor);
        textView.setTextColor(textColor);
    }

    private void setupAnimation() {
        this.lottieAnimationView.setRepeatCount(-1);
        this.lottieAnimationView.playAnimation();
    }

    private void setupHandle() {
        this.nfcHandle = new NfcHandle("https://www.consorcioasturias.org/rtm/api/RechargeCard/");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        if (intent.getParcelableExtra("android.nfc.extra.TAG") == null || !(intent.getParcelableExtra("android.nfc.extra.TAG") instanceof Tag)) {
            return;
        }
        showLoading(R.string.keep_transport_card_same_position);
        this.viewModel.onNfcIntentRecived(intent, this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmCardActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) throws IOException {
                this.f$0.lambda$onNewIntent$1(intent, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onNewIntent$1(Intent intent, Resource resource) throws IOException {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            this.tvInfoMessage.setText(getString(R.string.error_card_can_not_read_card_broken));
            setColorMessage(this.tvInfoMessage, getResources().getColor(R.color.text_color_red), getResources().getColor(R.color.white));
            BaseUtils.showInfoMessage(this.tvInfoMessage);
            return;
        }
        if (i == 2) {
            showLoading(R.string.keep_transport_card_same_position);
            return;
        }
        if (i != 3) {
            return;
        }
        TransportCardModel transportCardModel = this.cardModel;
        if (transportCardModel != null && transportCardModel.getCardNumber() != null && this.cardModel.getCardNumber().equals(resource.data)) {
            Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            this.tag = tag;
            processIsoTag(IsoDep.get(tag));
            return;
        }
        String str = this.cardNumber;
        if (str != null && str.equals(resource.data)) {
            Tag tag2 = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            this.tag = tag2;
            processIsoTag(IsoDep.get(tag2));
        } else if (this.typeRtm != 1 && this.cardModel == null) {
            Tag tag3 = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            this.tag = tag3;
            processIsoTag(IsoDep.get(tag3));
        } else {
            hideLoading();
            Timber.v((String) resource.data, new Object[0]);
            this.tvInfoMessage.setText(getString(R.string.error_card_read_not_match));
            setColorMessage(this.tvInfoMessage, getResources().getColor(R.color.text_color_red), getResources().getColor(R.color.white));
            BaseUtils.showInfoMessage(this.tvInfoMessage);
        }
    }

    @OnClick({R.id.mbCancel})
    public void onViewClicked() {
        if (this.typeRtm == 2) {
            recoverUser();
            Intent intent = new Intent();
            intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TYPE_RTM, 2);
            intent.putExtra(Constants.IntentData.INTENT_RECHARGE_QUANTITY, this.rechargeQuantity);
            intent.putExtra(Constants.IntentData.INTENT_RECHARGE_TRIPS, this.rechargeTrips);
            setResult(1, intent);
            this.close = true;
            hideLoading();
            finish();
            return;
        }
        goToLoginManually();
    }

    @Override // com.palmatools.sdk.NfcHandle.Callback
    public void onError(ClsErrorMessage clsErrorMessage) throws IOException {
        Timber.e(clsErrorMessage.toString(), new Object[0]);
        Integer numValueOf = Integer.valueOf(clsErrorMessage.getErrorCode());
        if (Constants.ResponseCode.UNAUTHORIZED.equals(numValueOf)) {
            closeIsoDep();
            refreshToken();
        } else if (Constants.ResponseCode.BAD_REQUEST.equals(numValueOf)) {
            closeIsoDep();
            login(true);
        } else {
            showErrorMessage(getString(R.string.error_rtm));
        }
        hideLoading();
    }

    private void showErrorMessage(String errorMsg) {
        this.tvInfoMessage.setText(errorMsg);
        setColorMessage(this.tvInfoMessage, getResources().getColor(R.color.text_color_red), getResources().getColor(R.color.white));
        BaseUtils.showInfoMessage(this.tvInfoMessage);
    }

    private void refreshToken() {
        this.viewModel.refreshToken(this, new TokenModel(this.preferences.getBearerToken(), this.preferences.getRefreshToken())).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmCardActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) throws IOException {
                this.f$0.lambda$refreshToken$2((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmCardActivity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$refreshToken$2(Resource resource) throws IOException {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            if (Constants.ResponseCode.BAD_REQUEST.equals(resource.code)) {
                login(true);
                return;
            }
            return;
        }
        if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            if (resource.data != 0) {
                saveAndLoadRtm((TokenModel) resource.data);
            }
        }
    }

    private void processIsoTag(IsoDep isoDep) throws IOException {
        this.isoDep = isoDep;
        try {
            isoDep.connect();
            if (isoDep.isConnected()) {
                showLoading(R.string.keep_transport_card_same_position);
                this.nfcHandle.setTaskname("newComando", NfcHandle.Method.GET, new HashMap());
                HashMap map = new HashMap();
                map.put(HttpHeaders.AUTHORIZATION, Constants.Api.BEARER + this.tokenBearer);
                Timber.d("%s%s", Constants.Api.BEARER, this.tokenBearer);
                this.nfcHandle.setHeaders(map);
                this.nfcHandle.startForeGroundDispatch();
            }
        } catch (IOException e) {
            hideLoading();
            this.tvInfoMessage.setText(getString(R.string.error_card_not_read));
            setColorMessage(this.tvInfoMessage, getResources().getColor(R.color.text_color_red), getResources().getColor(R.color.white));
            BaseUtils.showInfoMessage(this.tvInfoMessage);
            Timber.e(e);
        } catch (SecurityException e2) {
            hideLoading();
            this.tvInfoMessage.setText(getString(R.string.error_read_nfc));
            setColorMessage(this.tvInfoMessage, getResources().getColor(R.color.text_color_red), getResources().getColor(R.color.white));
            BaseUtils.showInfoMessage(this.tvInfoMessage);
            Timber.e(e2);
        }
    }

    @Override // com.palmatools.sdk.NfcHandle.Callback
    public void onProgressUpdate(ClsApduMessage message) throws IOException {
        processApdu(message.getApdu());
    }

    private void processApdu(String apdu) throws IOException {
        IsoDep isoDep = this.isoDep;
        if (isoDep != null) {
            try {
                if (!isoDep.isConnected()) {
                    this.isoDep.connect();
                }
                if (this.isoDep.isConnected()) {
                    byte[] bArrTransceive = this.isoDep.transceive(BaseUtils.hexToByteArray(apdu));
                    HashMap map = new HashMap();
                    map.put("apdu", BaseUtils.toHexString(bArrTransceive));
                    this.nfcHandle.setTaskname("callBack", NfcHandle.Method.POST, map);
                    HashMap map2 = new HashMap();
                    map2.put(HttpHeaders.AUTHORIZATION, Constants.Api.BEARER + this.tokenBearer);
                    this.nfcHandle.setHeaders(map2);
                    this.nfcHandle.startForeGroundDispatch();
                }
            } catch (IOException e) {
                hideLoading();
                this.tvInfoMessage.setText(getString(R.string.error_card_not_read));
                setColorMessage(this.tvInfoMessage, getResources().getColor(R.color.text_color_red), getResources().getColor(R.color.white));
                BaseUtils.showInfoMessage(this.tvInfoMessage);
                Timber.e(e);
            } catch (SecurityException e2) {
                hideLoading();
                this.tvInfoMessage.setText(getString(R.string.error_read_nfc));
                setColorMessage(this.tvInfoMessage, getResources().getColor(R.color.text_color_red), getResources().getColor(R.color.white));
                BaseUtils.showInfoMessage(this.tvInfoMessage);
                Timber.e(e2);
            }
        }
    }

    @Override // com.palmatools.sdk.NfcHandle.Callback
    public void onSuccess(ClsTextMessage clsTextMessage) throws IOException {
        this.close = true;
        Gson gsonCreate = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DOTS).create();
        Timber.v(clsTextMessage.getText(), new Object[0]);
        NfcDetailResponseModel nfcDetailResponseModel = (NfcDetailResponseModel) gsonCreate.fromJson(clsTextMessage.getText(), NfcDetailResponseModel.class);
        Timber.v(clsTextMessage.getText(), new Object[0]);
        TransportCardModel transportCardModel = (TransportCardModel) gsonCreate.fromJson(nfcDetailResponseModel.getDataResult(), TransportCardModel.class);
        if (nfcDetailResponseModel.getCardType() != null) {
            transportCardModel.setCardTypeId(Integer.valueOf(nfcDetailResponseModel.getCardType().intValue()));
        }
        if (transportCardModel != null) {
            if (this.typeRtm == 0 && (transportCardModel.getCardTypeId().equals(Constants.Cards.TRANSPORT_CARD_ABONO_CTA) || transportCardModel.getCardTypeId().equals(Constants.Cards.TRANSPORT_CARD_TYPE_BILLETE_UNICO))) {
                showKoDialog();
            } else {
                goBackSuccess(transportCardModel);
            }
        } else {
            if (nfcDetailResponseModel.getMessage() != null) {
                this.tvInfoMessage.setText(nfcDetailResponseModel.getMessage());
            } else {
                this.tvInfoMessage.setText(getString(R.string.error_read_nfc_card));
            }
            setColorMessage(this.tvInfoMessage, getResources().getColor(R.color.text_color_red), getResources().getColor(R.color.white));
            BaseUtils.showInfoMessage(this.tvInfoMessage);
        }
        hideLoading();
        closeIsoDep();
    }

    private void closeIsoDep() throws IOException {
        IsoDep isoDep = this.isoDep;
        if (isoDep != null) {
            try {
                isoDep.close();
            } catch (IOException | SecurityException e) {
                Timber.e(e);
            }
        }
    }

    private void showKoDialog() {
        disableNfc();
        BaseUtils.showInfoDialog(this, 2, getString(R.string.label_something_go_wrong), getString(R.string.label_card_type_error), getString(R.string.label_accept), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmCardActivity$$ExternalSyntheticLambda3
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.goBack();
            }
        });
    }

    private void disableNfc() {
        this.nfcHandle.stopForeGroundDispatch();
        NfcAdapter nfcAdapter = this.nfcAdapter;
        if (nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(this);
        }
    }

    private void goBackSuccess(TransportCardModel cardModel) {
        recoverUser();
        Intent intent = new Intent();
        cardModel.setAlias(this.alias);
        cardModel.setCardTypeName(this.cardTypeName);
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_RECHARGE_RTM, cardModel);
        setResult(-1, intent);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        enableNfc();
        checkNFC();
    }

    private void enableNfc() {
        PendingIntent pendingIntent;
        IntentFilter[] intentFilterArr;
        String[][] strArr;
        NfcAdapter nfcAdapter = this.nfcAdapter;
        if (nfcAdapter == null || (pendingIntent = this.nfcPendingIntent) == null || (intentFilterArr = this.intentFiltersArray) == null || (strArr = this.techListsArray) == null) {
            return;
        }
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilterArr, strArr);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!checkNFC() || this.close) {
            return;
        }
        enableNfc();
    }

    private boolean checkNFC() {
        Resource.Status statusInitNfcAdapter = this.viewModel.initNfcAdapter(this.nfcAdapter);
        if (statusInitNfcAdapter == Resource.Status.ERROR) {
            recoverUser();
            setResult(1, new Intent());
            finish();
            return false;
        }
        if (statusInitNfcAdapter == Resource.Status.LOADING) {
            showErrorNfc(getString(R.string.label_error_inspection_nfc_off));
            return false;
        }
        showSuccessNfc();
        return true;
    }

    private void showErrorNfc(String textErrorLabel) {
        this.tvLabelGetCardCloseToPhone.setText(textErrorLabel);
    }

    private void showSuccessNfc() {
        this.tvLabelGetCardCloseToPhone.setText(getString(R.string.label_recharge_nfc_get_card_close));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.close = true;
        disableNfc();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        goBack();
        return false;
    }

    private void recoverUser() {
        Integer num = this.userType;
        if (num != null) {
            this.preferences.saveUser(num);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBack() {
        recoverUser();
        setResult(0, new Intent());
        this.close = true;
        finish();
    }

    private void goToLoginManually() {
        recoverUser();
        setResult(1, new Intent());
        this.close = true;
        hideLoading();
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        goBack();
        hideLoading();
    }
}
