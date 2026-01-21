package com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeConfigModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeModel;
import com.iecisa.ctausuario.ui.main.BaseTransportCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ActivateAutoRechargeActivity extends BaseTransportCardActivity {

    @BindView(R.id.btActivate)
    Button btActivate;
    private String cardNumber;

    @BindView(R.id.cbAceptTerms)
    CheckBox cbAceptTerms;
    private boolean haveCreditCards = false;
    private AutomaticRechargeModel model;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @BindView(R.id.tvInfoMessage)
    TextView tvInfoMessage;
    private ActivateAutoRechargeViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_activate_auto_recharge;
    }

    @Override // com.iecisa.ctausuario.ui.main.BaseTransportCardActivity, com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.btActivate.setEnabled(false);
        this.viewModel = (ActivateAutoRechargeViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(ActivateAutoRechargeViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_auto_recharge));
        if (getIntent().getExtras() != null) {
            this.cardNumber = getIntent().getStringExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER);
        }
        checkTokenizedCreditCards();
    }

    @OnCheckedChanged({R.id.cbAceptTerms})
    public void onCheckedChanged(boolean checked) {
        if (checked) {
            this.tvInfoMessage.setVisibility(8);
        }
        this.btActivate.setEnabled(checked);
    }

    @OnClick({R.id.tvLabelAceptTerms})
    public void onViewClicked(View view) {
        showAutoRechargeConditions();
    }

    private void showAutoRechargeConditions() {
        this.viewModel.getLegalConditions(this, BuildConfig.CONDITIONS_AUTOMATIC_RECHARGE).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$showAutoRechargeConditions$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showAutoRechargeConditions$0(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
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
                BaseUtils.showDialog(this, 1, ((ConditionsResponseModel) resource.data).getTitle(), ((ConditionsResponseModel) resource.data).getDescription(), getString(R.string.label_recharge_accept_conditions), getString(R.string.label_recharge_reject_conditions), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity.1
                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickPositive() {
                        ActivateAutoRechargeActivity.this.updateAcceptConditions(true);
                    }

                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickNegative() {
                        ActivateAutoRechargeActivity.this.updateAcceptConditions(false);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAcceptConditions(Boolean accept) {
        this.tvInfoMessage.setVisibility(8);
        this.cbAceptTerms.setChecked(accept.booleanValue());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11) {
            if (resultCode == 9) {
                retrieveAutoRechargeRangesConfig();
            } else if (resultCode == 11) {
                addTokenizedCreditCard();
            }
        }
    }

    private void showSuccess() {
        Intent intent = new Intent();
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.model);
        setResult(-1, intent);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0, new Intent());
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        return super.lambda$showIsRepresentativeDialog$3();
    }

    @OnClick({R.id.btActivate})
    public void onViewClicked() {
        if (!this.haveCreditCards) {
            goToAddCreditCard();
        } else {
            retrieveAutoRechargeRangesConfig();
        }
    }

    private void retrieveAutoRechargeRangesConfig() {
        this.viewModel.getAutomaticRechargeConfig(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$retrieveAutoRechargeRangesConfig$1((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$retrieveAutoRechargeRangesConfig$1(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showKoDialog(resource.message);
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            if (resource.data != 0) {
                createAutomaticRecharge(((AutomaticRechargeConfigModel) resource.data).getRechargeThresholdMin(), ((AutomaticRechargeConfigModel) resource.data).getRechargeAmountMin());
            }
        }
    }

    private void createAutomaticRecharge(Integer rechargeThreshold, Integer rechargeAmount) {
        this.viewModel.createAutomaticRecharge(this, new AutomaticRechargeModel(rechargeThreshold, rechargeAmount, this.cardNumber)).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$createAutomaticRecharge$2((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$createAutomaticRecharge$2(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showKoDialog(resource.message);
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
                this.model = (AutomaticRechargeModel) resource.data;
                showSuccess();
            }
        }
    }

    private void checkTokenizedCreditCards() {
        this.viewModel.getCardTokenList(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$checkTokenizedCreditCards$3((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkTokenizedCreditCards$3(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showKoDialog(resource.message);
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            this.haveCreditCards = true;
        }
    }

    private void goToAddCreditCard() {
        getConditions(BuildConfig.ADD_PAYMENT_CARD, new BaseUtils.onGetConditions() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity.2
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onGetConditions
            public void onSuccess(ConditionsResponseModel responseModel) {
                ActivateAutoRechargeActivity.this.goToOneClickPaymentConditionsDialog(responseModel.getTitle(), responseModel.getDescription());
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onGetConditions
            public void onError(Integer code, String message) {
                ActivateAutoRechargeActivity.this.showKoDialog(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showKoDialog(String message) {
        BaseUtils.showKoDialog(this, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToOneClickPaymentConditionsDialog(String title, String description) {
        BaseUtils.showDialog(this, 1, title, description, getString(R.string.label_payment_one_click_ok), getString(R.string.label_payment_one_click_ko), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity.3
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                ActivateAutoRechargeActivity.this.addTokenizedCreditCard();
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity$4, reason: invalid class name */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void addTokenizedCreditCard() {
        this.viewModel.addCreditCard(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$addTokenizedCreditCard$4((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addTokenizedCreditCard$4(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showKoDialog(resource.message);
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
            Intent intent = new Intent(this, (Class<?>) RechargeRedsysActivity.class);
            intent.putExtra(Constants.IntentData.INTENT_TYPE_RECHARGE_WEBVIEW, (Parcelable) resource.data);
            startActivityForResult(intent, 11);
        }
    }
}
