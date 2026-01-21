package com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.view.View;
import android.widget.CheckBox;
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
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.ValidatorModel;
import com.iecisa.ctausuario.model.ValidatorResponseModel;
import com.iecisa.ctausuario.ui.main.BaseTransportCardActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.ValidatorUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class LargeFamilyDiscountActivity extends BaseTransportCardActivity {
    private String cardNumber;

    @BindView(R.id.cbConditions)
    CheckBox cbConditions;

    @BindView(R.id.etCardNumber)
    TextView etCardNumber;

    @BindView(R.id.mbRequest)
    MaterialButton mbRequest;
    private NfcAdapter nfcAdapter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvInfoMessage)
    TextView tvInfoMessage;

    @BindView(R.id.tvTitle)
    TextView tvTitle;
    private List<ValidatorModel> validatorModelList;
    private LargeFamilyDiscountViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_large_family_discount;
    }

    @Override // com.iecisa.ctausuario.ui.main.BaseTransportCardActivity, com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (LargeFamilyDiscountViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(LargeFamilyDiscountViewModelImpl.class);
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_family_discount));
        getIntentExtra();
        setupDiscount();
        createValidator();
        validateFields();
    }

    private void setupDiscount() {
        this.viewModel.hasDiscount(this, this.cardNumber).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupDiscount$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$setupDiscount$0(Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
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
        if (resource.data == 0 || !((Boolean) resource.data).booleanValue()) {
            return;
        }
        showDialogSuccess();
    }

    private void showDialogSuccess() {
        BaseUtils.showInfoDialog(this, 3, getString(R.string.label_has_family_discount_title), getString(R.string.label_has_family_discount_description), getString(R.string.label_finish_recharge_button), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity$$ExternalSyntheticLambda3
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.lambda$showOkDialog$3();
            }
        });
    }

    private void getIntentExtra() {
        if (getIntent().getExtras() != null) {
            this.cardNumber = getIntent().getStringExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER);
        }
    }

    private void createValidator() {
        ArrayList arrayList = new ArrayList();
        this.validatorModelList = arrayList;
        arrayList.add(new ValidatorModel(10, this.etCardNumber));
        this.validatorModelList.add(new ValidatorModel(3, this.cbConditions.isChecked()));
        validateFields();
    }

    @OnTextChanged({R.id.etCardNumber})
    public void onTextChanged() {
        validateFields();
        ValidatorUtils.activateValidator(getCurrentFocus(), this.validatorModelList);
    }

    @OnCheckedChanged({R.id.cbConditions})
    public void onCheckedChanged(boolean checked) {
        ValidatorUtils.setValidatorChecked(checked, this.validatorModelList);
        validateFields();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateFields() {
        ValidatorResponseModel validatorResponseModelValidateField = ValidatorUtils.validateField(this, this.validatorModelList);
        ValidatorUtils.showErrorField(validatorResponseModelValidateField.getModel(), this.validatorModelList);
        if (validatorResponseModelValidateField.getMessage() == null) {
            this.tvInfoMessage.setVisibility(8);
            this.mbRequest.setEnabled(true);
            return true;
        }
        if (validatorResponseModelValidateField.getMessage().isEmpty()) {
            this.tvInfoMessage.setVisibility(8);
            this.mbRequest.setEnabled(false);
            return false;
        }
        this.tvInfoMessage.setVisibility(0);
        this.tvInfoMessage.setText(validatorResponseModelValidateField.getMessage());
        this.mbRequest.setEnabled(false);
        return false;
    }

    @OnClick({R.id.mbRequest, R.id.tvLabelAceptTermsPayment})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.mbRequest) {
            getFamilyDiscount();
        } else {
            if (id != R.id.tvLabelAceptTermsPayment) {
                return;
            }
            setupConditions();
        }
    }

    private void setupConditions() {
        this.viewModel.getLegalConditions(this, BuildConfig.CONDITIONS_LARGE_FAMILY_DISCOUNT).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupConditions$1((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$setupConditions$1(Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
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
                BaseUtils.showDialog(this, 1, ((ConditionsResponseModel) resource.data).getTitle(), ((ConditionsResponseModel) resource.data).getDescription(), getString(R.string.label_payment_one_click_ok), getString(R.string.label_payment_one_click_ko), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity.1
                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickPositive() {
                        ValidatorUtils.setValidatorChecked(true, LargeFamilyDiscountActivity.this.validatorModelList);
                        LargeFamilyDiscountActivity.this.cbConditions.setChecked(true);
                        LargeFamilyDiscountActivity.this.validateFields();
                    }

                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickNegative() {
                        ValidatorUtils.setValidatorChecked(true, LargeFamilyDiscountActivity.this.validatorModelList);
                        LargeFamilyDiscountActivity.this.cbConditions.setChecked(false);
                        LargeFamilyDiscountActivity.this.validateFields();
                    }
                });
            }
        }
    }

    private void getFamilyDiscount() {
        if (this.cbConditions.isChecked()) {
            this.viewModel.getLargeFamilyDiscount(this, this.etCardNumber.getText().toString(), this.cardNumber).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity$$ExternalSyntheticLambda1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$getFamilyDiscount$2((Resource) obj);
                }
            });
        }
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
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
    public /* synthetic */ void lambda$getFamilyDiscount$2(Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showErrorDialog(resource.message);
        } else {
            if (i == 2) {
                showLoading();
                return;
            }
            if (i != 3) {
                return;
            }
            hideLoading();
            if (checkNFC()) {
                lambda$showOkDialog$3();
            } else {
                showOkDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: goBackSuccess, reason: merged with bridge method [inline-methods] */
    public void lambda$showOkDialog$3() {
        setResult(-1, new Intent());
        finish();
    }

    private void showOkDialog() {
        BaseUtils.showInfoDialog(this, 3, getString(R.string.label_ok_family_discount_title), getString(R.string.label_ok_family_discount_description), getString(R.string.label_finish_recharge_button), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity$$ExternalSyntheticLambda5
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.lambda$showOkDialog$3();
            }
        });
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void showErrorDialog(String description) {
        BaseUtils.showInfoDialog(this, 2, getString(R.string.label_something_go_wrong), description, getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity$$ExternalSyntheticLambda0
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.lambda$showErrorDialog$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorDialog$4() {
        setResult(0, new Intent());
        finish();
    }

    private boolean checkNFC() {
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

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        return true;
    }
}
