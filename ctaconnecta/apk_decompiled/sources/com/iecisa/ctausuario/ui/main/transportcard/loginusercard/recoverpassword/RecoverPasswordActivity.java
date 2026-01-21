package com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword;

import android.content.Intent;
import android.text.TextUtils;
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
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.RecoverPasswordResponseModel;
import com.iecisa.ctausuario.model.TokenModel;
import com.iecisa.ctausuario.model.ValidatorModel;
import com.iecisa.ctausuario.model.ValidatorResponseModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.ValidatorUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class RecoverPasswordActivity extends CustomToolbarActivity {

    @BindView(R.id.btOk)
    MaterialButton btOk;

    @BindView(R.id.etMail)
    EditText etMail;

    @Inject
    PreferencesHelper preferences;
    private RecoverPasswordViewModel recoverPasswordViewModel;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvErrorMessage)
    TextView tvErrorMessage;
    private List<ValidatorModel> validatorModelList;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_recover_password;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        String stringExtra;
        this.recoverPasswordViewModel = (RecoverPasswordViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(RecoverPasswordViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_recover_password));
        this.preferences.setPassUser();
        if (this.preferences.getBearerToken() == null) {
            login();
        }
        if (getIntent().getExtras() != null && (stringExtra = getIntent().getStringExtra(Constants.IntentData.INTENT_RECOVER_PASSWORD)) != null) {
            this.etMail.setText(stringExtra);
        }
        createValidator();
    }

    private void createValidator() {
        ArrayList arrayList = new ArrayList();
        this.validatorModelList = arrayList;
        arrayList.add(new ValidatorModel(13, this.etMail));
    }

    @OnTextChanged({R.id.etMail})
    public void onTextChangedCardNumber(CharSequence text) {
        if (!TextUtils.isEmpty(text)) {
            ValidatorUtils.activateValidator(this.etMail, this.validatorModelList);
        }
        validateFields();
    }

    private boolean validateFields() {
        ValidatorResponseModel validatorResponseModelValidateField = ValidatorUtils.validateField(this, this.validatorModelList);
        ValidatorUtils.showErrorField(validatorResponseModelValidateField.getModel(), this.validatorModelList);
        if (validatorResponseModelValidateField.getMessage() == null) {
            this.tvErrorMessage.setVisibility(8);
            this.btOk.setEnabled(true);
            return true;
        }
        if (validatorResponseModelValidateField.getMessage().isEmpty()) {
            this.tvErrorMessage.setVisibility(8);
            this.btOk.setEnabled(false);
            return false;
        }
        this.tvErrorMessage.setVisibility(0);
        this.tvErrorMessage.setText(validatorResponseModelValidateField.getMessage());
        this.btOk.setEnabled(false);
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = new Intent();
        intent.putExtra(Constants.NFCValues.NFC_KEY_CARD, "");
        setResult(-1, intent);
        finish();
    }

    @OnClick({R.id.btOk})
    public void onViewClicked() {
        if (!TextUtils.isEmpty(this.etMail.getText())) {
            this.tvErrorMessage.setVisibility(8);
            this.tvErrorMessage.setVisibility(8);
            recoverPassword();
        } else {
            this.tvErrorMessage.setVisibility(0);
            this.tvErrorMessage.setText(getString(R.string.error_recover_password_email_empty));
        }
    }

    private void recoverPassword() {
        this.recoverPasswordViewModel.recoverPassword(this.etMail.getText().toString(), this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$recoverPassword$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$recoverPassword$0(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            this.tvErrorMessage.setVisibility(0);
            this.tvErrorMessage.setText(resource.message);
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
                deleteDataAccount(this.etMail.getText().toString());
                showConfirmationDialog(((RecoverPasswordResponseModel) resource.data).getEmail());
            }
        }
    }

    private void showConfirmationDialog(String email) {
        BaseUtils.showInfoDialog(this, 0, getString(R.string.title_label_confirmation_account), getString(R.string.text_label_confirmation_account, new Object[]{email.replaceAll("(^[^@]{3}|(?!^)\\G)[^@]", "$1*")}), getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordActivity$$ExternalSyntheticLambda2
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.lambda$showConfirmationDialog$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showConfirmationDialog$1() {
        Intent intent = new Intent();
        intent.putExtra(Constants.NFCValues.NFC_KEY_CARD, "");
        setResult(-1, intent);
        finish();
    }

    private void deleteDataAccount(String userName) {
        if (userName.equals(this.preferences.getUsername())) {
            saveBiometricInfo();
        }
    }

    private void saveBiometricInfo() {
        this.preferences.saveStatusBiometric(0);
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordActivity$1, reason: invalid class name */
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

    private void login() {
        this.recoverPasswordViewModel.loginUser(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$login$2((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$login$2(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            BaseUtils.showKoDialog(this, resource.message);
        } else if (i == 3 && resource.data != 0) {
            this.preferences.saveTokens(((TokenModel) resource.data).getToken(), ((TokenModel) resource.data).getRefreshToken());
        }
    }
}
