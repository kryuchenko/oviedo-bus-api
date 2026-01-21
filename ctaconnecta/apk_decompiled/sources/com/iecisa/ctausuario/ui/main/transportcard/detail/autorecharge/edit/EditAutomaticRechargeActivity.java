package com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.ValidatorModel;
import com.iecisa.ctausuario.model.ValidatorResponseModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeConfigModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.Utils;
import com.iecisa.ctausuario.utils.ValidatorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class EditAutomaticRechargeActivity extends CustomToolbarActivity {

    @BindView(R.id.btSave)
    MaterialButton btSave;
    private String cardNumber;

    @BindView(R.id.etMinThreshold)
    EditText etMinThreshold;

    @BindView(R.id.etRechargeQuantity)
    EditText etRechargeQuantity;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvInfoMessage)
    TextView tvInfoMessage;
    private List<ValidatorModel> validatorModelList;
    private EditAutomaticRechargeViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private Integer min_threshold = 0;
    private Integer max_threshold = 0;
    private Integer min_quantity = 0;
    private Integer max_quantity = 0;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_edit_threshold;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (EditAutomaticRechargeViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(EditAutomaticRechargeViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_settings_automatic_recharge));
        if (getIntent().getExtras() != null) {
            this.cardNumber = getIntent().getStringExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER);
            this.etMinThreshold.setText(getString(R.string.label_price_auto_recharge, new Object[]{Double.valueOf(Utils.INSTANCE.getEuros(Integer.valueOf(getIntent().getExtras().getInt(Constants.IntentData.INTENT_MIN_THRESHOLD, Constants.AutoRecharge.MIN_THRESHOLD.intValue()))))}));
            this.etRechargeQuantity.setText(getString(R.string.label_price_auto_recharge, new Object[]{Double.valueOf(Utils.INSTANCE.getEuros(Integer.valueOf(getIntent().getExtras().getInt(Constants.IntentData.INTENT_RECHARGE_QUANTITY, Constants.AutoRecharge.MIN_RECHARGE_QUANTITY.intValue()))))}));
        }
        setupAutomaticRechargeConfig();
    }

    private void setupAutomaticRechargeConfig() {
        this.viewModel.getAutomaticRechargeConfig(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupAutomaticRechargeConfig$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$setupAutomaticRechargeConfig$0(Resource resource) {
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(this, resource.message);
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
            this.min_quantity = ((AutomaticRechargeConfigModel) resource.data).getRechargeAmountMin();
            this.max_quantity = ((AutomaticRechargeConfigModel) resource.data).getRechargeAmountMax();
            this.min_threshold = ((AutomaticRechargeConfigModel) resource.data).getRechargeThresholdMin();
            this.max_threshold = ((AutomaticRechargeConfigModel) resource.data).getRechargeThresholdMax();
            createValidator();
            setupListener();
        }
    }

    private void setupListener() {
        this.etMinThreshold.addTextChangedListener(new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                EditAutomaticRechargeActivity editAutomaticRechargeActivity = EditAutomaticRechargeActivity.this;
                editAutomaticRechargeActivity.setSymbol(s, editAutomaticRechargeActivity.etMinThreshold);
                EditAutomaticRechargeActivity.this.validateFields();
                ValidatorUtils.activateValidator(EditAutomaticRechargeActivity.this.getCurrentFocus(), EditAutomaticRechargeActivity.this.validatorModelList);
                ValidatorUtils.activateValidator(EditAutomaticRechargeActivity.this.etRechargeQuantity, EditAutomaticRechargeActivity.this.validatorModelList);
            }
        });
        this.etRechargeQuantity.addTextChangedListener(new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeActivity.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                EditAutomaticRechargeActivity editAutomaticRechargeActivity = EditAutomaticRechargeActivity.this;
                editAutomaticRechargeActivity.setSymbol(s, editAutomaticRechargeActivity.etRechargeQuantity);
                EditAutomaticRechargeActivity.this.validateFields();
                ValidatorUtils.activateValidator(EditAutomaticRechargeActivity.this.getCurrentFocus(), EditAutomaticRechargeActivity.this.validatorModelList);
                ValidatorUtils.activateValidator(EditAutomaticRechargeActivity.this.etMinThreshold, EditAutomaticRechargeActivity.this.validatorModelList);
            }
        });
    }

    private void createValidator() {
        ArrayList arrayList = new ArrayList();
        this.validatorModelList = arrayList;
        arrayList.add(new ValidatorModel(17, this.etMinThreshold));
        this.validatorModelList.add(new ValidatorModel(16, this.etRechargeQuantity));
        validateFields();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateFields() {
        ValidatorResponseModel validatorResponseModelValidateField = validateField(this, this.validatorModelList);
        ValidatorUtils.showErrorField(validatorResponseModelValidateField.getModel(), this.validatorModelList);
        if (validatorResponseModelValidateField.getMessage() == null) {
            this.tvInfoMessage.setVisibility(8);
            this.btSave.setEnabled(true);
            return true;
        }
        if (validatorResponseModelValidateField.getMessage().isEmpty()) {
            this.tvInfoMessage.setVisibility(8);
            this.btSave.setEnabled(false);
            return false;
        }
        this.tvInfoMessage.setVisibility(0);
        this.tvInfoMessage.setText(validatorResponseModelValidateField.getMessage());
        this.btSave.setEnabled(false);
        return false;
    }

    @OnClick({R.id.btSave})
    public void onViewClicked() {
        this.viewModel.setAutomaticRecharge(this, new AutomaticRechargeModel(Integer.valueOf(Utils.INSTANCE.getCentsForEuro(this.etMinThreshold.getText().toString())), Integer.valueOf(Utils.INSTANCE.getCentsForEuro(this.etRechargeQuantity.getText().toString()))), this.cardNumber).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onViewClicked$1((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeActivity$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
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
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            if (resource.code.intValue() == 304) {
                goToAutomaticRecharge();
                return;
            } else {
                BaseUtils.showKoDialog(this, resource.message);
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
            goToAutomaticRecharge();
        }
    }

    private void goToAutomaticRecharge() {
        setResult(-1, new Intent());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSymbol(Editable number, EditText editText) {
        if (number.toString().contains(".")) {
            if (number.toString().contains(",")) {
                editText.setText(number.toString().replace(".", ""));
            } else {
                editText.setText(number.toString().replace(".", ","));
            }
            editText.setSelection(editText.getText().length());
            return;
        }
        if (number.toString().contains(",") && number.toString().length() == 1 && number.toString().substring(0, 1).equals(",")) {
            editText.setText(number.toString().replace(",", ""));
        }
    }

    private ValidatorResponseModel validateField(Context context, List<ValidatorModel> validatorModelList) {
        if (validatorModelList != null && !validatorModelList.isEmpty()) {
            for (ValidatorModel validatorModel : validatorModelList) {
                int typeValidator = validatorModel.getTypeValidator();
                if (typeValidator == 16) {
                    if (validatorModel.isActivated() && validatorModel.getTextView().getText().toString().isEmpty()) {
                        return new ValidatorResponseModel(context.getString(R.string.error_recharge_payment_price_empty), validatorModel);
                    }
                    if (Utils.INSTANCE.getCentsForEuro(validatorModel.getTextView().getText().toString()) > this.max_quantity.intValue() || Utils.INSTANCE.getCentsForEuro(validatorModel.getTextView().getText().toString()) < this.min_quantity.intValue()) {
                        return new ValidatorResponseModel(context.getString(R.string.error_auto_recharge_quantity, Double.valueOf(Utils.INSTANCE.getEuros(this.min_quantity)), Double.valueOf(Utils.INSTANCE.getEuros(this.max_quantity))), validatorModel);
                    }
                } else if (typeValidator != 17) {
                    continue;
                } else {
                    if (validatorModel.isActivated() && validatorModel.getTextView().getText().toString().isEmpty()) {
                        return new ValidatorResponseModel(context.getString(R.string.error_recharge_payment_price_empty), validatorModel);
                    }
                    if (Utils.INSTANCE.getCentsForEuro(validatorModel.getTextView().getText().toString()) > this.max_threshold.intValue() || Utils.INSTANCE.getCentsForEuro(validatorModel.getTextView().getText().toString()) < this.min_threshold.intValue()) {
                        return new ValidatorResponseModel(context.getString(R.string.error_auto_recharge_threshold, Double.valueOf(Utils.INSTANCE.getEuros(this.min_threshold)), Double.valueOf(Utils.INSTANCE.getEuros(this.max_threshold))), validatorModel);
                    }
                }
            }
        }
        if (validatorModelList != null && validatorModelList.size() > 0) {
            Iterator<ValidatorModel> it = validatorModelList.iterator();
            while (it.hasNext()) {
                if (!it.next().isActivated()) {
                    return new ValidatorResponseModel("", null);
                }
            }
        }
        return new ValidatorResponseModel(null, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }
}
