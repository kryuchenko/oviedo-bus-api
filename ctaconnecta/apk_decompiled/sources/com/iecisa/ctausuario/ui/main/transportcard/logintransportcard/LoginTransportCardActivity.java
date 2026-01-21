package com.iecisa.ctausuario.ui.main.transportcard.logintransportcard;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.LoginRequest;
import com.iecisa.ctausuario.model.TokenModel;
import com.iecisa.ctausuario.model.ValidatorModel;
import com.iecisa.ctausuario.model.ValidatorResponseModel;
import com.iecisa.ctausuario.model.transportcarddetail.ImpersonalTransportCardModel;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmCardActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.ValidatorUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class LoginTransportCardActivity extends CustomToolbarActivity {

    @BindView(R.id.etCardNumber)
    EditText etCardNumber;

    @BindView(R.id.etCharacter)
    EditText etCharacter;

    @BindView(R.id.mbLogin)
    TextView mbLogin;

    @Inject
    PreferencesHelper preferences;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvInfoMessage)
    TextView tvInfoMessage;
    private List<ValidatorModel> validatorModelList;
    private LoginTransportCardViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    static /* synthetic */ void lambda$showDialogError$1() {
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_login_transport_card;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (LoginTransportCardViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(LoginTransportCardViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_check_card));
        createValidator();
        setupView();
    }

    private void createValidator() {
        ArrayList arrayList = new ArrayList();
        this.validatorModelList = arrayList;
        arrayList.add(new ValidatorModel(4, this.etCardNumber));
        this.validatorModelList.add(new ValidatorModel(10, this.etCharacter));
        validateFields();
    }

    @OnTextChanged({R.id.etCardNumber})
    public void onTextChangedCardNumber() {
        ValidatorUtils.activateValidator(this.etCardNumber, this.validatorModelList);
        validateFields();
    }

    @OnTextChanged({R.id.etCharacter})
    public void onTextChangedCharacter() {
        ValidatorUtils.activateValidator(this.etCharacter, this.validatorModelList);
        validateFields();
    }

    private boolean validateFields() {
        ValidatorResponseModel validatorResponseModelValidateField = ValidatorUtils.validateField(this, this.validatorModelList);
        ValidatorUtils.showErrorField(validatorResponseModelValidateField.getModel(), this.validatorModelList);
        if (validatorResponseModelValidateField.getMessage() == null) {
            this.tvInfoMessage.setVisibility(8);
            this.mbLogin.setEnabled(true);
            return true;
        }
        if (validatorResponseModelValidateField.getMessage().isEmpty()) {
            this.tvInfoMessage.setVisibility(8);
            this.mbLogin.setEnabled(false);
            return false;
        }
        this.tvInfoMessage.setVisibility(0);
        this.tvInfoMessage.setText(validatorResponseModelValidateField.getMessage());
        this.mbLogin.setEnabled(false);
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }

    private void setupView() {
        Intent intent = new Intent(this, (Class<?>) RtmCardActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TYPE_RTM, 0);
        intent.putExtra(Constants.IntentData.INTENT_READ_CARD, true);
        startActivityForResult(intent, 8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || requestCode != 8) {
            if (resultCode == 0) {
                onBackPressed();
            }
        } else {
            if (data == null || data.getExtras() == null || !(data.getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_RECHARGE_RTM) instanceof TransportCardModel)) {
                return;
            }
            TransportCardModel transportCardModel = (TransportCardModel) data.getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_RECHARGE_RTM);
            Intent intent = new Intent(this, (Class<?>) DetailTransportCardActivity.class);
            intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, transportCardModel);
            intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_RMT, true);
            intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_UNLOGGED_DETAIL, getIntent().getBooleanExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_UNLOGGED_DETAIL, false));
            startActivity(intent);
            finish();
        }
    }

    @OnClick({R.id.tvLogin, R.id.mbLogin})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id != R.id.mbLogin) {
            if (id != R.id.tvLogin) {
                return;
            }
            startActivity(new Intent(this, (Class<?>) LoginUserCardActivity.class));
            finish();
            return;
        }
        this.preferences.setPassUser();
        if (this.preferences.getBearerToken() != null) {
            loginTransportCard();
        } else {
            login();
        }
    }

    private void login() {
        this.viewModel.login(new LoginRequest(BuildConfig.LOGIN_USER, BuildConfig.LOGIN_PASS), this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$login$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$login$0(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            showDialogError(resource.message);
        } else if (i == 3 && resource.data != 0) {
            this.preferences.setPassUser();
            this.preferences.saveTokens(((TokenModel) resource.data).getToken(), ((TokenModel) resource.data).getRefreshToken());
            loginTransportCard();
        }
    }

    private void showDialogError(String message) {
        BaseUtils.showInfoDialog(this, 2, getString(R.string.error), message, getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardActivity$$ExternalSyntheticLambda0
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                LoginTransportCardActivity.lambda$showDialogError$1();
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardActivity$1, reason: invalid class name */
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

    private void loginTransportCard() {
        this.viewModel.getDetailTransportCard(this, this.etCardNumber.getText().toString(), this.etCharacter.getText().toString()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$loginTransportCard$2((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$loginTransportCard$2(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showDialogError(resource.message);
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            chooseTypePass((ImpersonalTransportCardModel) resource.data);
        }
    }

    private void chooseTypePass(ImpersonalTransportCardModel impersonalTransportCardModel) {
        if (impersonalTransportCardModel.getCtaPass() != null) {
            TransportCardModel ctaPass = impersonalTransportCardModel.getCtaPass();
            ctaPass.setCardTypeId(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_CTA);
            goToDetails(ctaPass);
        } else if (impersonalTransportCardModel.getCtaTenPass() != null) {
            TransportCardModel ctaTenPass = impersonalTransportCardModel.getCtaTenPass();
            ctaTenPass.setCardTypeId(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10);
            goToDetails(ctaTenPass);
        }
    }

    private void goToDetails(TransportCardModel model) {
        Intent intent = new Intent(this, (Class<?>) DetailTransportCardActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, model);
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_UNLOGGED_DETAIL, getIntent().getBooleanExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_UNLOGGED_DETAIL, false));
        startActivity(intent);
        finish();
    }
}
