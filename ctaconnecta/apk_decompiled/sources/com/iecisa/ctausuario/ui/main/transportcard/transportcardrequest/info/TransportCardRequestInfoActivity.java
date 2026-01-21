package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info;

import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.messaging.FirebaseMessaging;
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.transportcardrequest.DoBTransactionModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.identification.TransportCardRequestIdentificationActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.logs.ErrorReportingUtils;
import com.iecisa.ctausuario.utils.logs.NonFatalException;
import com.tecalis.identitysdk.IdentitySDK;
import com.tecalis.identitysdk.models.Customer;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class TransportCardRequestInfoActivity extends CustomToolbarActivity {

    @BindView(R.id.btStartCardRequest)
    MaterialButton btStartCardRequest;

    @BindView(R.id.cbAcceptCardRequestTerms)
    CheckBox cbAcceptCardRequestTerms;

    @BindView(R.id.clPopupDni30)
    ConstraintLayout clPopupDni30;

    @BindView(R.id.gpNfcSupported)
    Group gpNfcSupported;
    private IdentitySDK.Environment idSdkEnvironment;
    private boolean isRepresentative;

    @BindView(R.id.ivClosePopupDni30)
    ImageView ivClosePopupDni30;
    private NfcAdapter nfcAdapter;
    private boolean nfcSupported;

    @Inject
    PreferencesHelper preferences;
    private int selectedIdType = 0;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private String transactionId;

    @BindView(R.id.tvDni30)
    TextView tvDni30;

    @BindView(R.id.tvLabelAceptTermsCardRequest)
    TextView tvLabelAceptTermsCardRequest;

    @BindView(R.id.tvLabelRepresentative)
    TextView tvLabelRepresentative;

    @BindView(R.id.tvTextRepresentativeIntro2)
    TextView tvLabelRepresentativeIntro2;

    @BindView(R.id.tvOtherId)
    TextView tvOtherId;

    @BindView(R.id.tvShowDni30)
    TextView tvShowDni30;

    @BindView(R.id.tvTextIntro)
    TextView tvTextIntro;

    @BindView(R.id.tvTextRepresentative)
    TextView tvTextRepresentative;

    @BindView(R.id.tvTextRepresentativeIntro)
    TextView tvTextRepresentativeIntro;
    private TransportCardRequestInfoViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    static /* synthetic */ void lambda$initializeView$0() {
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_transport_card_request_info;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        TransportCardRequestInfoActivity transportCardRequestInfoActivity;
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.request_card));
        this.viewModel = (TransportCardRequestInfoViewModel) new ViewModelProvider(this, this.viewModelFactory).get(TransportCardRequestInfoViewModelImpl.class);
        if (NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            transportCardRequestInfoActivity = this;
        } else {
            transportCardRequestInfoActivity = this;
            BaseUtils.showInfoDialog(transportCardRequestInfoActivity, 4, getString(R.string.label_notifications_disabled_title), getString(R.string.label_notifications_disabled_text), getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity$$ExternalSyntheticLambda1
                @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
                public final void onClickPositive() {
                    TransportCardRequestInfoActivity.lambda$initializeView$0();
                }
            });
        }
        transportCardRequestInfoActivity.idSdkEnvironment = IdentitySDK.Environment.PRODUCTION;
        setupView();
        transportCardRequestInfoActivity.nfcSupported = false;
        transportCardRequestInfoActivity.gpNfcSupported.setVisibility(8);
        getDeviceTokenAndStartupOnboarding();
    }

    private void setupView() {
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            boolean booleanExtra = intent.getBooleanExtra(Constants.IntentData.INTENT_DOB_REPRESENTATIVE_REQUEST, false);
            this.isRepresentative = booleanExtra;
            if (booleanExtra) {
                setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.legal_representative));
                this.tvTextIntro.setVisibility(8);
                this.tvTextRepresentativeIntro.setVisibility(0);
                this.tvLabelRepresentative.setVisibility(8);
                this.tvTextRepresentative.setVisibility(8);
                this.tvLabelRepresentativeIntro2.setVisibility(0);
                return;
            }
            setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.request_card));
            this.tvTextIntro.setVisibility(0);
            this.tvTextRepresentativeIntro.setVisibility(8);
            this.tvLabelRepresentative.setVisibility(0);
            this.tvTextRepresentative.setVisibility(0);
            this.tvLabelRepresentativeIntro2.setVisibility(8);
            return;
        }
        BaseUtils.showKoDialog(this, getString(R.string.label_date_error_getting_dob_request_type));
    }

    private void getDeviceTokenAndStartupOnboarding() {
        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(this, new OnSuccessListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.lambda$getDeviceTokenAndStartupOnboarding$1((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDeviceTokenAndStartupOnboarding$1(String str) {
        if (str != null) {
            startupOnboarding(str);
        } else {
            BaseUtils.showInfoDialog(this, 2, getString(R.string.label_something_go_wrong), getString(R.string.error_unknown), getString(R.string.label_accept), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity$$ExternalSyntheticLambda4
                @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
                public final void onClickPositive() {
                    this.f$0.goBackError();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBackError() {
        setResult(0, new Intent());
        finish();
    }

    protected void startupOnboarding(String fcmToken) {
        HashMap map = new HashMap();
        map.put("fcmToken", fcmToken);
        map.put("fcmTokenIsEmptyOrNull", String.valueOf(fcmToken == null || fcmToken.isEmpty()));
        ErrorReportingUtils.sendErrorToFirebase("IdentitySDK.init", map);
        IdentitySDK.init(this, BuildConfig.DOB_API_KEY, BuildConfig.PROFILE, BuildConfig.DOB_WEBHOOK, fcmToken, this.idSdkEnvironment);
    }

    @OnCheckedChanged({R.id.cbAcceptCardRequestTerms})
    public void onCheckedChanged(boolean checked) {
        validateFields();
    }

    @OnClick({R.id.tvOtherId, R.id.tvDni30, R.id.tvShowDni30, R.id.ivClosePopupDni30, R.id.tvLabelAceptTermsCardRequest, R.id.btStartCardRequest})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btStartCardRequest /* 2131361945 */:
                startNewProcess();
                break;
            case R.id.ivClosePopupDni30 /* 2131362281 */:
                this.clPopupDni30.setVisibility(8);
                break;
            case R.id.tvDni30 /* 2131362803 */:
                this.selectedIdType = 1;
                changeSelectedId(this.tvDni30, this.tvOtherId);
                break;
            case R.id.tvLabelAceptTermsCardRequest /* 2131362831 */:
                getLegalConditions();
                break;
            case R.id.tvOtherId /* 2131362918 */:
                this.selectedIdType = 2;
                changeSelectedId(this.tvOtherId, this.tvDni30);
                break;
            case R.id.tvShowDni30 /* 2131362939 */:
                this.clPopupDni30.setVisibility(0);
                break;
        }
    }

    private void changeSelectedId(TextView selected, TextView unselected) {
        selected.setBackgroundResource(R.drawable.zones_selector_green);
        selected.setTextColor(getResources().getColor(R.color.text_color));
        unselected.setBackgroundResource(R.drawable.zones_selector_blue);
        unselected.setTextColor(getResources().getColor(R.color.white));
        validateFields();
    }

    private void getLegalConditions() {
        String str;
        if (this.isRepresentative) {
            str = BuildConfig.CONDITIONS_LEGAL_REPRESENTATIVE;
        } else {
            str = BuildConfig.CONDITIONS_NEW_CARD_REQUEST;
        }
        this.viewModel.getLegalConditions(this, str).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getLegalConditions$2((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getLegalConditions$2(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(this, resource.message);
        } else {
            if (i == 2) {
                showLoading();
                return;
            }
            if (i != 3) {
                return;
            }
            hideLoading();
            if (resource.data != 0) {
                BaseUtils.showDialog(this, 1, ((ConditionsResponseModel) resource.data).getTitle(), ((ConditionsResponseModel) resource.data).getDescription(), getString(R.string.label_payment_one_click_ok), getString(R.string.label_payment_one_click_ko), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity.1
                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickPositive() {
                        TransportCardRequestInfoActivity.this.cbAcceptCardRequestTerms.setChecked(true);
                        TransportCardRequestInfoActivity.this.validateFields();
                    }

                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickNegative() {
                        TransportCardRequestInfoActivity.this.cbAcceptCardRequestTerms.setChecked(false);
                        TransportCardRequestInfoActivity.this.validateFields();
                    }
                });
            } else {
                BaseUtils.showKoDialog(this, getString(R.string.error_getting_terms));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateFields() {
        if (this.nfcSupported) {
            this.btStartCardRequest.setEnabled(this.selectedIdType != 0 && this.cbAcceptCardRequestTerms.isChecked());
        } else {
            this.btStartCardRequest.setEnabled(this.cbAcceptCardRequestTerms.isChecked());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }

    private void startNewProcess() {
        if (this.selectedIdType == 1) {
            if (this.nfcAdapter.isEnabled()) {
                startNewOnboardingTransaction();
                return;
            } else {
                hideLoading();
                BaseUtils.showDialog(this, 0, getString(R.string.label_select_id_nfc_disabled_title), getString(R.string.label_select_id_nfc_disabled), getString(R.string.label_select_id_nfc_disabled_continue), getString(R.string.label_select_id_nfc_disabled_cancel), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity.2
                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickNegative() {
                    }

                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickPositive() {
                        TransportCardRequestInfoActivity.this.startNewOnboardingTransaction();
                    }
                });
                return;
            }
        }
        startNewOnboardingTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNewOnboardingTransaction() {
        try {
            IdentitySDK.startProcess(new AnonymousClass3(UUID.randomUUID().toString()));
        } catch (Exception unused) {
            showErrorDialog(getString(R.string.error_unknown));
        }
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity$3, reason: invalid class name */
    class AnonymousClass3 implements IdentitySDK.CallbackProgress {
        final /* synthetic */ String val$requestUuid;

        AnonymousClass3(final String val$requestUuid) {
            this.val$requestUuid = val$requestUuid;
        }

        @Override // com.tecalis.identitysdk.IdentitySDK.CallbackProgress
        public void onSuccess() throws NonFatalException {
            HashMap map = new HashMap();
            String str = this.val$requestUuid;
            if (str == null) {
                str = "nil";
            }
            map.put("tecalisRequest", str);
            map.put("tecalisStatus", "opened");
            ErrorReportingUtils.sendErrorToFirebase("ErrorKeyExample", map, "Tecalis opened for request " + this.val$requestUuid);
        }

        @Override // com.tecalis.identitysdk.IdentitySDK.CallbackProgress
        public void onFail(String message) throws NonFatalException {
            HashMap map = new HashMap();
            String str = this.val$requestUuid;
            if (str == null) {
                str = "nil";
            }
            map.put("tecalisRequest", str);
            map.put("tecalisStatus", "failed");
            map.put("tecalisReason", message);
            ErrorReportingUtils.sendErrorToFirebase("TecalisFailure", map, "Tecalis failed for request " + this.val$requestUuid + " because: " + message);
            TransportCardRequestInfoActivity transportCardRequestInfoActivity = TransportCardRequestInfoActivity.this;
            BaseUtils.showKoDialog(transportCardRequestInfoActivity, transportCardRequestInfoActivity.getString(R.string.error_connecting_dob_platform, new Object[]{message}));
        }

        @Override // com.tecalis.identitysdk.IdentitySDK.CallbackProgress
        public void getAuthUuid(final String authUuid) throws NonFatalException {
            final TransportCardRequestInfoActivity transportCardRequestInfoActivity = TransportCardRequestInfoActivity.this;
            HashMap map = new HashMap();
            String str = this.val$requestUuid;
            if (str == null) {
                str = "nil";
            }
            map.put("tecalisRequest", str);
            map.put("tecalisStatus", "uuid");
            map.put("tecalisUuid", authUuid);
            ErrorReportingUtils.sendErrorToFirebase("TecalisUidReceived", map, "Tecalis uuid for request " + this.val$requestUuid + " received: " + authUuid);
            TransportCardRequestInfoActivity.this.viewModel.startNewOnboardingTransaction(transportCardRequestInfoActivity, authUuid, TransportCardRequestInfoActivity.this.isRepresentative).observe(TransportCardRequestInfoActivity.this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity$3$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$getAuthUuid$0(authUuid, transportCardRequestInfoActivity, (Resource) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ void lambda$getAuthUuid$0(String str, Context context, Resource resource) {
            int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
            if (i == 1) {
                IdentitySDK.closeProcess(str);
                BaseUtils.showKoDialog(context, context.getString(R.string.error_new_dob_transaction, resource.message));
                return;
            }
            if (i != 3) {
                return;
            }
            if (resource.data != 0) {
                TransportCardRequestInfoActivity.this.transactionId = ((DoBTransactionModel) resource.data).getTransactionId();
                if (TransportCardRequestInfoActivity.this.transactionId == null || TransportCardRequestInfoActivity.this.transactionId.isEmpty()) {
                    IdentitySDK.closeProcess(str);
                    BaseUtils.showKoDialog(context, context.getString(R.string.error_new_dob_transaction_empty));
                    return;
                }
                return;
            }
            IdentitySDK.closeProcess(str);
            BaseUtils.showKoDialog(context, context.getString(R.string.error_new_dob_transaction_empty));
        }

        @Override // com.tecalis.identitysdk.IdentitySDK.CallbackProgress
        public void onFlowComplete(Customer customer) throws NonFatalException {
            HashMap map = new HashMap();
            String str = this.val$requestUuid;
            if (str == null) {
                str = "nil";
            }
            map.put("tecalisRequest", str);
            map.put("tecalisStatus", "flow");
            ErrorReportingUtils.sendErrorToFirebase("TecalisFlowComplete", map, "Tecalis flow complete for request " + this.val$requestUuid);
            final String str2 = TransportCardRequestInfoActivity.this.transactionId;
            new Handler().postDelayed(new Runnable() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity$3$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFlowComplete$1(str2);
                }
            }, 4000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFlowComplete$1(String str) {
            if (TransportCardRequestInfoActivity.this.preferences.isPendingCardRequest(str)) {
                return;
            }
            TransportCardRequestInfoActivity.this.preferences.addPendingCardRequest(str, new Date());
            Intent intent = new Intent(TransportCardRequestInfoActivity.this.getBaseContext(), (Class<?>) TransportCardRequestIdentificationActivity.class);
            intent.setFlags(335544320);
            intent.putExtra(Constants.IntentData.INTENT_DOB_USER_ID, str);
            TransportCardRequestInfoActivity.this.startActivity(intent);
            TransportCardRequestInfoActivity.this.finish();
        }
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
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

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void showErrorDialog(String description) {
        BaseUtils.showInfoDialog(this, 2, getString(R.string.label_something_go_wrong), description, getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity$$ExternalSyntheticLambda0
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.lambda$showErrorDialog$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorDialog$3() {
        setResult(0, new Intent());
        finish();
    }
}
