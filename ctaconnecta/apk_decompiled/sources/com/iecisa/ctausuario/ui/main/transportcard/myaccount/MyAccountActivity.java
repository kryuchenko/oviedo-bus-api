package com.iecisa.ctausuario.ui.main.transportcard.myaccount;

import android.content.Intent;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.bumptech.glide.Glide;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.HolderRequestModel;
import com.iecisa.ctausuario.model.HolderResponseModel;
import com.iecisa.ctausuario.model.ValidatorModel;
import com.iecisa.ctausuario.model.ValidatorResponseModel;
import com.iecisa.ctausuario.ui.main.BaseTransportCardActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.DateUtils;
import com.iecisa.ctausuario.utils.ValidatorUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class MyAccountActivity extends BaseTransportCardActivity {

    @BindView(R.id.btSave)
    MaterialButton btSave;

    @BindView(R.id.etDirection)
    EditText etDirection;

    @BindView(R.id.etLocation)
    EditText etLocation;

    @BindView(R.id.etMail)
    EditText etMail;

    @BindView(R.id.etMailConfirm)
    EditText etMailConfirm;

    @BindView(R.id.etPhone)
    EditText etPhone;

    @BindView(R.id.etPostalCode)
    EditText etPostalCode;

    @BindView(R.id.etProvince)
    EditText etProvince;

    @BindView(R.id.etSecondPhone)
    EditText etSecondPhone;

    @BindView(R.id.ivProfile)
    ImageView ivProfile;
    private HolderResponseModel model;

    @Inject
    PreferencesHelper preferences;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvAdvice)
    TextView tvAdvice;

    @BindView(R.id.tvDateBirth)
    TextView tvDateBirth;

    @BindView(R.id.tvIdentityDocument)
    TextView tvIdentityDocument;

    @BindView(R.id.tvName)
    TextView tvName;
    private List<ValidatorModel> validatorModelList;
    private MyAccountViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_my_account;
    }

    @Override // com.iecisa.ctausuario.ui.main.BaseTransportCardActivity, com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (MyAccountViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(MyAccountViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_my_account));
        setupView();
    }

    private void setupView() {
        this.btSave.setEnabled(false);
        this.viewModel.getDetailsAccount(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupView$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$setupView$0(Resource resource) {
        int i = AnonymousClass6.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
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
            createValidator();
            setupData((HolderResponseModel) resource.data);
            disableCopyPaste(this.etMail);
            disableCopyPaste(this.etMailConfirm);
            this.btSave.setEnabled(true);
            return;
        }
        BaseUtils.showInfoDialog(this, 2, getString(R.string.label_something_go_wrong), getString(R.string.error_unknown), getString(R.string.label_accept), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity$$ExternalSyntheticLambda3
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.goBackError();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBackError() {
        setResult(0, new Intent());
        finish();
    }

    private void createValidator() {
        ArrayList arrayList = new ArrayList();
        this.validatorModelList = arrayList;
        arrayList.add(new ValidatorModel(1, this.etMail));
        this.validatorModelList.add(new ValidatorModel(2, this.etMailConfirm, this.etMail));
        this.validatorModelList.add(new ValidatorModel(6, this.etPhone));
        this.validatorModelList.add(new ValidatorModel(5, this.etDirection));
        this.validatorModelList.add(new ValidatorModel(12, this.etPostalCode));
        this.validatorModelList.add(new ValidatorModel(5, this.etLocation));
        this.validatorModelList.add(new ValidatorModel(5, this.etProvince));
        validateFields();
    }

    @OnTextChanged({R.id.etMail})
    public void onTextChangedMail(CharSequence text) {
        validate(text, this.etMail);
    }

    @OnTextChanged({R.id.etMailConfirm})
    public void onTextChangedMailConfirm(CharSequence text) {
        validate(text, this.etMailConfirm);
    }

    @OnTextChanged({R.id.etPhone})
    public void onTextChangedPhone(CharSequence text) {
        validate(text, this.etPhone);
    }

    @OnTextChanged({R.id.etDirection})
    public void onTextChangedDirection(CharSequence text) {
        validate(text, this.etDirection);
    }

    @OnTextChanged({R.id.etPostalCode})
    public void onTextChangedPostalCode(CharSequence text) {
        validate(text, this.etPostalCode);
    }

    @OnTextChanged({R.id.etLocation})
    public void onTextChangedLocation(CharSequence text) {
        validate(text, this.etLocation);
    }

    @OnTextChanged({R.id.etProvince})
    public void onTextChangedProvince(CharSequence text) {
        validate(text, this.etProvince);
    }

    private void validate(CharSequence text, EditText etDirection) {
        if (!TextUtils.isEmpty(text)) {
            ValidatorUtils.activateValidator(etDirection, this.validatorModelList);
        }
        validateFields();
    }

    private void disableCopyPaste(final EditText editText) {
        editText.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity.1
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode mode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }
        });
        if (Build.VERSION.SDK_INT >= 23) {
            editText.setCustomInsertionActionModeCallback(new ActionMode.Callback() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity.2
                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(ActionMode mode) {
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }
            });
        }
        editText.setLongClickable(false);
        editText.setTextIsSelectable(false);
        editText.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity.3
            @Override // android.view.View.OnCreateContextMenuListener
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.clear();
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity.4
            private String previousText = "";
            private boolean isUpdating = false;

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (this.isUpdating) {
                    return;
                }
                this.previousText = s.toString();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (!this.isUpdating && s.length() - this.previousText.length() > 1) {
                    this.isUpdating = true;
                    editText.setText(this.previousText);
                    if (this.previousText.length() > 0) {
                        editText.setSelection(this.previousText.length());
                    }
                    this.isUpdating = false;
                }
            }
        });
    }

    private boolean validateFields() {
        ValidatorResponseModel validatorResponseModelValidateField = ValidatorUtils.validateField(this, this.validatorModelList);
        ValidatorUtils.showErrorField(validatorResponseModelValidateField.getModel(), this.validatorModelList);
        if (validatorResponseModelValidateField.getMessage() == null) {
            this.tvAdvice.setVisibility(8);
            this.btSave.setEnabled(true);
            return true;
        }
        if (validatorResponseModelValidateField.getMessage().isEmpty()) {
            this.tvAdvice.setVisibility(8);
            this.btSave.setEnabled(false);
            return false;
        }
        this.tvAdvice.setVisibility(0);
        showErrorMessage(validatorResponseModelValidateField.getMessage());
        this.btSave.setEnabled(false);
        return false;
    }

    private void setupData(HolderResponseModel model) {
        this.model = model;
        if (model.getLastName() != null) {
            this.tvName.setText(getString(R.string.label_name_my_cards, new Object[]{model.getName(), model.getSurname(), model.getLastName()}));
        } else {
            this.tvName.setText(getString(R.string.label_name_my_cards_one_surname, new Object[]{model.getName(), model.getSurname()}));
        }
        this.tvIdentityDocument.setText(model.getDni());
        this.tvDateBirth.setText(DateUtils.getDate(model.getBirthDate()));
        this.etMail.setText(model.getEmail());
        ValidatorUtils.activateValidator(this.etMail, this.validatorModelList);
        this.etMailConfirm.setText(model.getEmail());
        ValidatorUtils.activateValidator(this.etMailConfirm, this.validatorModelList);
        this.etPhone.setText(model.getMobilePhone());
        ValidatorUtils.activateValidator(this.etPhone, this.validatorModelList);
        this.etSecondPhone.setText(model.getPhone());
        this.etDirection.setText(model.getAddress());
        ValidatorUtils.activateValidator(this.etDirection, this.validatorModelList);
        this.etPostalCode.setText(model.getPostalCode());
        ValidatorUtils.activateValidator(this.etPostalCode, this.validatorModelList);
        this.etLocation.setText(model.getCity());
        ValidatorUtils.activateValidator(this.etLocation, this.validatorModelList);
        this.etProvince.setText(model.getProvince());
        ValidatorUtils.activateValidator(this.etProvince, this.validatorModelList);
        if (model.getPhoto().isEmpty()) {
            return;
        }
        Glide.with((FragmentActivity) this).load(Base64.decode(model.getPhoto(), 0)).into(this.ivProfile);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }

    @OnClick({R.id.btSave})
    public void onViewClicked(View view) {
        HolderRequestModel holderRequestModel = new HolderRequestModel(this.etMail.getText().toString(), this.etSecondPhone.getText().toString(), this.etPhone.getText().toString(), this.etDirection.getText().toString(), this.etPostalCode.getText().toString(), this.etLocation.getText().toString(), this.etProvince.getText().toString());
        HolderResponseModel holderResponseModel = this.model;
        if (holderResponseModel != null && holderResponseModel.getId() != null) {
            this.viewModel.saveDataAccount(this, this.model.getId(), holderRequestModel).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity$$ExternalSyntheticLambda1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$onViewClicked$1((Resource) obj);
                }
            });
        } else {
            showErrorMessage(getString(R.string.error_service_call));
        }
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
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
    public /* synthetic */ void lambda$onViewClicked$1(Resource resource) {
        int i = AnonymousClass6.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showErrorMessage(resource.message);
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            goToRefreshToken();
        }
    }

    private void goToRefreshToken() {
        refreshToken(new BaseUtils.onRefreshToken() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity.5
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onRefreshToken
            public void onError() {
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onRefreshToken
            public void onSuccess() {
                MyAccountActivity.this.onRefreshSuccess();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRefreshSuccess() {
        this.tvAdvice.setText(R.string.changes_account_ok);
        this.tvAdvice.setTextColor(getResources().getColor(R.color.text_color));
        this.tvAdvice.setBackgroundColor(getResources().getColor(R.color.green_toogle_button));
        BaseUtils.showInfoMessage(this.tvAdvice);
    }

    private void showErrorMessage(String message) {
        this.tvAdvice.setText(message);
        this.tvAdvice.setTextColor(getResources().getColor(R.color.white));
        this.tvAdvice.setBackgroundColor(getResources().getColor(R.color.red_toogle_button));
        this.tvAdvice.setVisibility(0);
    }
}
