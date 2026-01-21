package com.iecisa.ctausuario.ui.main.transportcard.loginusercard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.auth0.android.jwt.JWT;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.messaging.FirebaseMessaging;
import com.iecisa.ctausuario.App;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.Login2FaRequest;
import com.iecisa.ctausuario.model.LoginRequest;
import com.iecisa.ctausuario.model.TokenModel;
import com.iecisa.ctausuario.model.ValidatorModel;
import com.iecisa.ctausuario.model.ValidatorResponseModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordActivity;
import com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.Utils;
import com.iecisa.ctausuario.utils.ValidatorUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class LoginUserCardActivity extends CustomToolbarActivity {

    @BindView(R.id.btLogin)
    MaterialButton btLogin;

    @BindView(R.id.etPwd)
    TextInputEditText etPwd;

    @BindView(R.id.etUsername)
    TextInputEditText etUserName;
    private LoginUserCardViewModel loginUserCardViewModel;

    @BindView(R.id.mbForgotPwd)
    MaterialButton mbForgotPwd;

    @BindView(R.id.mbLoginPrint)
    MaterialButton mbLoginPrint;

    @Inject
    PreferencesHelper preferences;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvErrorMessage)
    TextView tvErrorMessage;
    private List<ValidatorModel> validatorModelList;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;
    private int userBiometricPreference = -1;
    private Boolean isLogin = true;
    private Boolean isLoginAfterChangePassword = false;
    private Handler handler = new Handler();
    private Executor executor = new Executor() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$$ExternalSyntheticLambda7
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f$0.lambda$new$0(runnable);
        }
    };
    private Boolean biometricsSupported = null;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_login_user_card;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Runnable runnable) {
        this.handler.post(runnable);
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.loginUserCardViewModel = (LoginUserCardViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(LoginUserCardViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.personal_card));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getInt(Constants.IntentData.INTENT_REQUEST_INCIDENT, -1) >= 0) {
                this.isLogin = false;
            }
            this.isLoginAfterChangePassword = Boolean.valueOf(extras.getBoolean(Constants.IntentData.INTENT_LOGIN_AFTER_CHANGE_PASSWORD, false));
        }
        createValidator();
        setFields();
    }

    private void createValidator() {
        ArrayList arrayList = new ArrayList();
        this.validatorModelList = arrayList;
        arrayList.add(new ValidatorModel(13, this.etUserName));
        this.validatorModelList.add(new ValidatorModel(14, this.etPwd));
        validateFields();
    }

    @OnTextChanged({R.id.etUsername})
    public void onTextChangedCardNumber(CharSequence text) {
        if (!TextUtils.isEmpty(text)) {
            ValidatorUtils.activateValidator(this.etUserName, this.validatorModelList);
        }
        validateFields();
    }

    @OnTextChanged({R.id.etPwd})
    public void onTextChangedCharacter(CharSequence text) {
        if (!TextUtils.isEmpty(text)) {
            ValidatorUtils.activateValidator(this.etPwd, this.validatorModelList);
        }
        validateFields();
    }

    private boolean validateFields() {
        ValidatorResponseModel validatorResponseModelValidateField = ValidatorUtils.validateField(this, this.validatorModelList);
        ValidatorUtils.showErrorField(validatorResponseModelValidateField.getModel(), this.validatorModelList);
        if (validatorResponseModelValidateField.getMessage() == null) {
            this.tvErrorMessage.setVisibility(8);
            this.btLogin.setEnabled(true);
            return true;
        }
        if (validatorResponseModelValidateField.getMessage().isEmpty()) {
            this.tvErrorMessage.setVisibility(8);
            this.btLogin.setEnabled(false);
            return false;
        }
        this.tvErrorMessage.setVisibility(0);
        this.tvErrorMessage.setText(validatorResponseModelValidateField.getMessage());
        this.btLogin.setEnabled(false);
        return false;
    }

    private void setFields() {
        this.mbForgotPwd.setEnabled(true);
        if (this.isLogin.booleanValue()) {
            this.preferences.setLoginUser();
            if (this.preferences.getBearerToken() != null) {
                goToMyCards();
                return;
            } else {
                setupView();
                return;
            }
        }
        setupView();
    }

    private void setupView() {
        if (!this.preferences.getUsername().equals("")) {
            this.etUserName.setText(this.preferences.getUsername());
            ValidatorUtils.activateValidator(this.etUserName, this.validatorModelList);
        }
        if (!this.isLoginAfterChangePassword.booleanValue() && isBiometricsSupported() && getUserBiometricPreference() == 2 && !this.preferences.getUsername().equals("")) {
            showBiometricPrompt();
            this.mbLoginPrint.setVisibility(0);
            this.mbLoginPrint.setEnabled(true);
            return;
        }
        this.mbLoginPrint.setVisibility(8);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.preferences.setExtUser();
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @OnClick({R.id.mbForgotPwd, R.id.btLogin, R.id.mbLoginPrint})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.btLogin) {
            login(this.etUserName.getText().toString().trim(), this.etPwd.getText().toString(), false);
            return;
        }
        if (id != R.id.mbForgotPwd) {
            if (id != R.id.mbLoginPrint) {
                return;
            }
            showBiometricPrompt();
        } else {
            Intent intent = new Intent(this, (Class<?>) RecoverPasswordActivity.class);
            if (!TextUtils.isEmpty(this.etUserName.getText())) {
                intent.putExtra(Constants.IntentData.INTENT_RECOVER_PASSWORD, this.etUserName.getText().toString());
            }
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveLoginInfo() {
        this.preferences.saveLoginInfo(this.etUserName.getText().toString(), this.etPwd.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login(String userName, String pwd, final boolean isBiometric) {
        if (isBiometric) {
            this.loginUserCardViewModel.login(new LoginRequest(userName, pwd), this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$$ExternalSyntheticLambda3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$login$2(isBiometric, (Resource) obj);
                }
            });
        } else {
            final Login2FaRequest login2FaRequest = new Login2FaRequest(userName, pwd);
            this.loginUserCardViewModel.login2Fa(login2FaRequest, this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$$ExternalSyntheticLambda4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$login$3(login2FaRequest, (Resource) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$login$2(boolean z, Resource resource) {
        int i = AnonymousClass5.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            if (resource.code.intValue() == 427) {
                showExpiredPasswordDialog();
                return;
            } else {
                this.tvErrorMessage.setVisibility(0);
                this.tvErrorMessage.setText(resource.message);
                return;
            }
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
            this.preferences.saveTokens(((TokenModel) resource.data).getToken(), ((TokenModel) resource.data).getRefreshToken());
            loadJWT(new JWT(((TokenModel) resource.data).getToken()), z);
            FirebaseMessaging.getInstance().getToken().addOnSuccessListener(this, new OnSuccessListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    LoginUserCardActivity.lambda$login$1((String) obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$login$1(String str) {
        if (str != null) {
            App.getInstance().updateNotificationTokenStatus(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$login$3(Login2FaRequest login2FaRequest, Resource resource) {
        int i = AnonymousClass5.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            if (resource.code.intValue() == 427) {
                showExpiredPasswordDialog();
                return;
            } else {
                this.tvErrorMessage.setVisibility(0);
                this.tvErrorMessage.setText(resource.message);
                return;
            }
        }
        if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            showVerificationDialog(login2FaRequest);
        }
    }

    private void showVerificationDialog(final Login2FaRequest request) {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.dialog_2fa, (ViewGroup) null);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.digit1);
        final EditText editText2 = (EditText) viewInflate.findViewById(R.id.digit2);
        final EditText editText3 = (EditText) viewInflate.findViewById(R.id.digit3);
        final EditText editText4 = (EditText) viewInflate.findViewById(R.id.digit4);
        final EditText editText5 = (EditText) viewInflate.findViewById(R.id.digit5);
        setupOtpInputs(editText, editText2, editText3, editText4, editText5);
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle("Verificación requerida").setView(viewInflate).setCancelable(false).setPositiveButton("Confirmar", (DialogInterface.OnClickListener) null).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create();
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f$0.lambda$showVerificationDialog$6(alertDialogCreate, editText, editText2, editText3, editText4, editText5, request, dialogInterface);
            }
        });
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showVerificationDialog$6(final AlertDialog alertDialog, final EditText editText, final EditText editText2, final EditText editText3, final EditText editText4, final EditText editText5, final Login2FaRequest login2FaRequest, DialogInterface dialogInterface) {
        final Button button = alertDialog.getButton(-1);
        button.setEnabled(false);
        TextWatcher textWatcher = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                StringBuilder sb = new StringBuilder();
                sb.append(editText.getText().toString());
                sb.append(editText2.getText().toString());
                sb.append(editText3.getText().toString());
                sb.append(editText4.getText().toString());
                sb.append(editText5.getText().toString());
                button.setEnabled(sb.toString().length() == 5);
            }
        };
        editText.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher);
        editText3.addTextChangedListener(textWatcher);
        editText4.addTextChangedListener(textWatcher);
        editText5.addTextChangedListener(textWatcher);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showVerificationDialog$5(editText, editText2, editText3, editText4, editText5, login2FaRequest, alertDialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showVerificationDialog$5(EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, Login2FaRequest login2FaRequest, AlertDialog alertDialog, View view) {
        String str = editText.getText().toString() + editText2.getText().toString() + editText3.getText().toString() + editText4.getText().toString() + editText5.getText().toString();
        if (str.length() == 5) {
            validateCode(str, login2FaRequest);
            alertDialog.dismiss();
        }
    }

    private void showExpiredPasswordDialog() {
        new AlertDialog.Builder(this).setTitle("Contraseña caducada").setMessage("Tu contraseña ha caducado por motivos de seguridad. Por favor, actualízala para poder seguir utilizando la aplicación.").setCancelable(false).setPositiveButton("Actualizar", new DialogInterface.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showExpiredPasswordDialog$7(dialogInterface, i);
            }
        }).setNegativeButton("Cerrar", new DialogInterface.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showExpiredPasswordDialog$7(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this, (Class<?>) RecoverPasswordActivity.class);
        if (!TextUtils.isEmpty(this.etUserName.getText())) {
            intent.putExtra(Constants.IntentData.INTENT_RECOVER_PASSWORD, this.etUserName.getText().toString());
        }
        startActivity(intent);
    }

    private void validateCode(String code, Login2FaRequest request) {
        request.setCode(code);
        this.loginUserCardViewModel.login2Fa(request, this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$validateCode$10((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
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
    public /* synthetic */ void lambda$validateCode$10(Resource resource) {
        int i = AnonymousClass5.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            if (resource.code.intValue() == 427) {
                showExpiredPasswordDialog();
                return;
            } else {
                this.tvErrorMessage.setVisibility(0);
                this.tvErrorMessage.setText(resource.message);
                return;
            }
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
            this.preferences.setLoginUser();
            this.preferences.saveTokens(((TokenModel) resource.data).getToken(), ((TokenModel) resource.data).getRefreshToken());
            if (!this.isLogin.booleanValue()) {
                loadSuccess();
            } else {
                loadJWT(new JWT(((TokenModel) resource.data).getToken()), false);
            }
            FirebaseMessaging.getInstance().getToken().addOnSuccessListener(this, new OnSuccessListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$$ExternalSyntheticLambda13
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    LoginUserCardActivity.lambda$validateCode$9((String) obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$validateCode$9(String str) {
        if (str != null) {
            App.getInstance().updateNotificationTokenStatus(str);
        }
    }

    private void setupOtpInputs(final EditText... editTexts) {
        for (final int i = 0; i < editTexts.length; i++) {
            editTexts[i].addTextChangedListener(new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity.2
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.length() == 1) {
                        int i2 = i;
                        EditText[] editTextArr = editTexts;
                        if (i2 < editTextArr.length - 1) {
                            editTextArr[i2 + 1].requestFocus();
                        }
                    }
                    if (s.length() > 1) {
                        String strTrim = s.toString().trim();
                        if (strTrim.matches("^[0-9]{5}$")) {
                            for (int i3 = 0; i3 < 5; i3++) {
                                EditText[] editTextArr2 = editTexts;
                                if (i3 >= editTextArr2.length) {
                                    break;
                                }
                                editTextArr2[i3].setText(String.valueOf(strTrim.charAt(i3)));
                            }
                            editTexts[4].requestFocus();
                            return;
                        }
                        editTexts[i].setText("");
                        Toast.makeText(editTexts[i].getContext(), "Debe ingresar 5 dígitos numéricos", 0).show();
                    }
                }
            });
            editTexts[i].setOnKeyListener(new View.OnKeyListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$$ExternalSyntheticLambda10
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                    return LoginUserCardActivity.lambda$setupOtpInputs$11(editTexts, i, view, i2, keyEvent);
                }
            });
        }
    }

    static /* synthetic */ boolean lambda$setupOtpInputs$11(EditText[] editTextArr, int i, View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i2 != 67 || !editTextArr[i].getText().toString().isEmpty() || i <= 0) {
            return false;
        }
        int i3 = i - 1;
        editTextArr[i3].setText("");
        editTextArr[i3].requestFocus();
        return false;
    }

    private void showPasswordExpirationDialog(long daysLeft) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Contraseña próxima a caducar");
        StringBuilder sb = new StringBuilder("Tu contraseña caducará en ");
        sb.append(daysLeft);
        sb.append(" día");
        sb.append(daysLeft != 1 ? "s" : "");
        sb.append(".");
        builder.setMessage(sb.toString());
        builder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showPasswordExpirationDialog$12(dialogInterface, i);
            }
        });
        builder.setNegativeButton("Cambiar contraseña", new DialogInterface.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showPasswordExpirationDialog$13(dialogInterface, i);
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPasswordExpirationDialog$12(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        goToMyCards();
        showLastAccountLogin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPasswordExpirationDialog$13(DialogInterface dialogInterface, int i) {
        openChangePasswordScreen();
        dialogInterface.dismiss();
    }

    private void openChangePasswordScreen() {
        goToMyCards();
        startActivity(new Intent(this, (Class<?>) AccessSettingsActivity.class));
    }

    private void loadSuccess() {
        setResult(-1, new Intent());
        finish();
    }

    private void loadJWT(JWT jwt, boolean isBiometric) {
        Boolean boolAsBoolean = jwt.getClaim("FirstLogin").asBoolean();
        if (boolAsBoolean != null && boolAsBoolean.booleanValue()) {
            saveLoginInfo();
            goToChangePwd();
            return;
        }
        if (!this.etUserName.getText().toString().equals(this.preferences.getUsername()) && !isBiometric) {
            saveLoginInfo();
            this.userBiometricPreference = 0;
        }
        if (isBiometricsSupported() && getUserBiometricPreference() == 0) {
            showBiometricDialog();
            return;
        }
        if (!isBiometric) {
            saveLoginInfo();
        }
        checkAccountExpiration(jwt);
    }

    private void goToChangePwd() {
        Intent intent = new Intent(this, (Class<?>) AccessSettingsActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_SHOW_BIOMETRIC_SWITCH, false);
        intent.putExtra(Constants.IntentData.INTENT_FIRST_LOGIN_PASSWORD, this.etPwd.getText());
        startActivity(intent);
        finish();
        this.etPwd.setText("");
    }

    private void checkAccountExpiration(JWT jwt) {
        int iIntValue = Utils.INSTANCE.getDaysUntilExpiration(jwt).intValue();
        if (iIntValue <= 15) {
            showPasswordExpirationDialog(iIntValue);
        } else {
            goToMyCards();
            showLastAccountLogin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToMyCards() {
        startActivity(new Intent(this, (Class<?>) MyTransportCardsActivity.class));
        finish();
    }

    private void showLastAccountLogin() {
        Toast.makeText(this, getString(R.string.last_login_label) + " " + Utils.INSTANCE.getAccountLastAccess(this.preferences.getBearerToken()), 1).show();
    }

    private boolean isBiometricsSupported() {
        if (this.biometricsSupported == null) {
            this.biometricsSupported = Boolean.valueOf(Build.VERSION.SDK_INT >= 23 && BiometricManager.from(this).canAuthenticate() == 0);
        }
        return this.biometricsSupported.booleanValue();
    }

    private int getUserBiometricPreference() {
        if (this.userBiometricPreference == -1) {
            this.userBiometricPreference = this.preferences.getStatusBiometric().intValue();
        }
        return this.userBiometricPreference;
    }

    private void showBiometricPrompt() {
        new BiometricPrompt(this, this.executor, new BiometricPrompt.AuthenticationCallback() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity.3
            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Timber.d("Error autenticando con biometría: " + errString.toString(), new Object[0]);
            }

            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                LoginUserCardActivity.this.tvErrorMessage.setVisibility(8);
                LoginUserCardActivity loginUserCardActivity = LoginUserCardActivity.this;
                loginUserCardActivity.login(loginUserCardActivity.preferences.getUsername(), LoginUserCardActivity.this.preferences.getPwd(), true);
            }
        }).authenticate(new BiometricPrompt.PromptInfo.Builder().setTitle(getString(R.string.label_biometric_login_title)).setSubtitle(getString(R.string.label_biometric_login_subtitle)).setNegativeButtonText(getString(R.string.label_cancel)).setConfirmationRequired(false).build());
    }

    protected void showBiometricDialog() {
        BaseUtils.showDialog(this, 0, null, getString(R.string.login_with_biometrical_data), getString(R.string.label_yes), getString(R.string.label_no), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity.4
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                LoginUserCardActivity.this.saveBiometricInfo(2);
                LoginUserCardActivity.this.saveLoginInfo();
                LoginUserCardActivity.this.goToMyCards();
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
                LoginUserCardActivity.this.saveBiometricInfo(1);
                LoginUserCardActivity.this.goToMyCards();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveBiometricInfo(Integer biometricInfo) {
        this.preferences.saveStatusBiometric(biometricInfo);
    }
}
