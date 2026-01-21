package com.iecisa.ctausuario.ui.main.transportcard.accesssettings;

import android.content.Intent;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.ChangePasswordRequest;
import com.iecisa.ctausuario.model.ValidatorModel;
import com.iecisa.ctausuario.model.ValidatorResponseModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.MainActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.Utils;
import com.iecisa.ctausuario.utils.ValidatorUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes5.dex */
public class AccessSettingsActivity extends CustomToolbarActivity {

    @BindView(R.id.etActualPwd)
    EditText etActualPwd;

    @BindView(R.id.etNewPwd)
    EditText etNewPwd;

    @BindView(R.id.etRepeatPwd)
    EditText etRepeatPwd;

    @BindView(R.id.mbChangePass)
    MaterialButton mbChangePass;

    @Inject
    PreferencesHelper preferences;

    @Inject
    PreferencesHelper preferencesHelper;

    @BindView(R.id.swFingerPrint)
    Switch swFingerPrint;

    @BindView(R.id.tilActualPwd)
    TextInputLayout tilActualPwd;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvErrorMessage)
    TextView tvErrorMessage;

    @BindView(R.id.tvLabelActualPwd)
    TextView tvLabelActualPwd;

    @BindView(R.id.tvLastLogin)
    TextView tvLastLogin;
    private List<ValidatorModel> validatorModelList;
    private AccessSettingsViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.vSeparator)
    View vwSeparator;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_access_settings;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (AccessSettingsViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(AccessSettingsViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_access_configuration));
        String accountLastAccess = Utils.INSTANCE.getAccountLastAccess(this.preferences.getBearerToken());
        this.tvLastLogin.setText(getString(R.string.last_login_label) + " " + accountLastAccess);
        createValidator(setupView());
    }

    private void createValidator(boolean isFirstLoginPassword) {
        ArrayList arrayList = new ArrayList();
        this.validatorModelList = arrayList;
        if (!isFirstLoginPassword) {
            arrayList.add(new ValidatorModel(14, this.etActualPwd));
        }
        this.validatorModelList.add(new ValidatorModel(14, this.etNewPwd));
        this.etNewPwd.setFilters(new InputFilter[]{new InputFilter() { // from class: com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity$$ExternalSyntheticLambda2
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return AccessSettingsActivity.lambda$createValidator$0(charSequence, i, i2, spanned, i3, i4);
            }
        }});
        this.validatorModelList.add(new ValidatorModel(15, this.etRepeatPwd, this.etNewPwd));
        validateFields();
    }

    static /* synthetic */ CharSequence lambda$createValidator$0(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (charSequence.toString().contains(" ")) {
            return charSequence.toString().replace(" ", "");
        }
        return null;
    }

    private boolean validateFields() {
        ValidatorResponseModel validatorResponseModelValidateField = ValidatorUtils.validateField(this, this.validatorModelList);
        ValidatorUtils.showErrorField(validatorResponseModelValidateField.getModel(), this.validatorModelList);
        if (validatorResponseModelValidateField.getMessage() == null) {
            this.tvErrorMessage.setVisibility(8);
            this.mbChangePass.setEnabled(true);
            return true;
        }
        if (validatorResponseModelValidateField.getMessage().isEmpty()) {
            this.tvErrorMessage.setVisibility(8);
            this.mbChangePass.setEnabled(false);
            return false;
        }
        this.tvErrorMessage.setVisibility(0);
        this.tvErrorMessage.setText(validatorResponseModelValidateField.getMessage());
        this.mbChangePass.setEnabled(false);
        return false;
    }

    @OnTextChanged({R.id.etActualPwd})
    public void onTextChangedActualPwd(CharSequence text) {
        if (!TextUtils.isEmpty(text)) {
            ValidatorUtils.activateValidator(this.etActualPwd, this.validatorModelList);
        }
        validateFields();
    }

    @OnTextChanged({R.id.etNewPwd})
    public void onTextChangedNewPwd(CharSequence text) {
        if (!TextUtils.isEmpty(text)) {
            ValidatorUtils.activateValidator(this.etNewPwd, this.validatorModelList);
        }
        validateFields();
    }

    @OnTextChanged({R.id.etRepeatPwd})
    public void onTextChangedRepeatPwd(CharSequence text) {
        if (!TextUtils.isEmpty(text)) {
            ValidatorUtils.activateValidator(this.etRepeatPwd, this.validatorModelList);
        }
        validateFields();
    }

    private boolean setupView() {
        CharSequence charSequenceExtra;
        boolean booleanExtra;
        Intent intent = getIntent();
        if (intent != null) {
            booleanExtra = intent.getBooleanExtra(Constants.IntentData.INTENT_SHOW_BIOMETRIC_SWITCH, true);
            charSequenceExtra = intent.getCharSequenceExtra(Constants.IntentData.INTENT_FIRST_LOGIN_PASSWORD);
        } else {
            charSequenceExtra = null;
            booleanExtra = true;
        }
        if (booleanExtra) {
            this.swFingerPrint.setVisibility(0);
            this.vwSeparator.setVisibility(0);
            this.swFingerPrint.setChecked(this.preferencesHelper.getStatusBiometric().intValue() == 2);
        } else {
            this.swFingerPrint.setVisibility(8);
            this.vwSeparator.setVisibility(8);
        }
        if (charSequenceExtra != null && charSequenceExtra.length() > 0) {
            this.tvLabelActualPwd.setVisibility(8);
            this.tilActualPwd.setVisibility(8);
            this.etActualPwd.setVisibility(8);
            this.etActualPwd.setText(charSequenceExtra);
            return true;
        }
        this.tvLabelActualPwd.setVisibility(0);
        this.tilActualPwd.setVisibility(0);
        this.etActualPwd.setVisibility(0);
        this.etActualPwd.setText("");
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }

    private void saveBiometricInfo(Integer biometricInfo) {
        this.preferencesHelper.saveStatusBiometric(biometricInfo);
    }

    @OnCheckedChanged({R.id.swFingerPrint})
    public void onCheckedChanged(boolean checked) {
        saveBiometricInfo(Integer.valueOf(checked ? 2 : 1));
    }

    @OnClick({R.id.mbChangePass})
    public void onViewClicked() {
        if (this.preferencesHelper.getPwd().equals(this.etActualPwd.getText().toString())) {
            changePassword();
            return;
        }
        this.tvErrorMessage.setVisibility(0);
        this.tvErrorMessage.setText(getString(R.string.error_login_pwd));
        this.mbChangePass.setEnabled(false);
    }

    private void changePassword() {
        this.viewModel.changePassword(this, new ChangePasswordRequest(this.preferencesHelper.getUsername(), this.etActualPwd.getText().toString(), this.etNewPwd.getText().toString(), 1)).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$changePassword$1((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity$1, reason: invalid class name */
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
    public /* synthetic */ void lambda$changePassword$1(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i != 1) {
            if (i == 2) {
                showLoading();
                return;
            }
            if (i != 3) {
                return;
            }
            hideLoading();
            if (resource.data != 0) {
                this.preferencesHelper.removeBearerToken();
                this.preferencesHelper.setPassUser();
                showPasswordChangedDialog();
                return;
            }
            return;
        }
        hideLoading();
        try {
            JSONArray jSONArray = new JSONArray(resource.message);
            String str = "";
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                str = str + jSONArray.getJSONObject(i2).getString("description") + "\n\n";
            }
            BaseUtils.showKoDialog(this, str);
        } catch (JSONException unused) {
            BaseUtils.showKoDialog(this, resource.message);
        }
    }

    private void showPasswordChangedDialog() {
        BaseUtils.showInfoDialog(this, 3, getString(R.string.label_password_changed), getString(R.string.label_password_changed_description), getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity$$ExternalSyntheticLambda1
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.lambda$showPasswordChangedDialog$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPasswordChangedDialog$2() {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.setFlags(335544320);
        intent.putExtra(Constants.IntentData.INTENT_LOGIN_AFTER_CHANGE_PASSWORD, true);
        startActivity(intent);
        finish();
    }
}
