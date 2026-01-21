package com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.PaymentCardModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeModel;
import com.iecisa.ctausuario.model.autorecharge.ErrorAutomaticRechargeModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeActivity;
import com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.Utils;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class AutomaticRechargeActivity extends CustomToolbarActivity {

    @BindView(R.id.btEditCreditCard)
    MaterialButton btEditCreditCard;

    @BindView(R.id.btEditMinThreshold)
    MaterialButton btEditMinThreshold;

    @BindView(R.id.btEditRechargeQuantity)
    MaterialButton btEditRechargeQuantity;
    private String cardNumber;

    @BindView(R.id.gpErrorRecharge)
    Group gpErrorRecharge;
    private Integer idAutoRechargeError;

    @BindView(R.id.mbRetryAutoRecharge)
    MaterialButton mbRetryAutoRecharge;
    private AutomaticRechargeModel model;
    private NfcAdapter nfcAdapter;
    private Integer rechargeAmount;

    @BindView(R.id.swAutomaticRecharge)
    Switch swAutomaticRecharge;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvCreditCard)
    TextView tvCreditCard;

    @BindView(R.id.tvMinThreshold)
    TextView tvMinThreshold;

    @BindView(R.id.tvRechargeQuantity)
    TextView tvRechargeQuantity;
    private AutomaticRechargeViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_automatic_recharge;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (AutomaticRechargeViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(AutomaticRechargeViewModelImpl.class);
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_auto_recharge));
        this.model = new AutomaticRechargeModel(Constants.AutoRecharge.MIN_THRESHOLD, Constants.AutoRecharge.MIN_RECHARGE_QUANTITY);
        if (getIntent().getExtras() != null) {
            this.cardNumber = getIntent().getStringExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER);
        }
        getAutomaticRecharge(true);
    }

    private void setupCreditCardList() {
        this.viewModel.getCreditCards(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupCreditCardList$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupCreditCardList$0(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            this.tvCreditCard.setText(getString(R.string.label_no_credits_cards));
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
        if (resource.data != 0 && ((List) resource.data).size() > 0) {
            loadCardToken((List) resource.data);
        } else {
            this.tvCreditCard.setText(getString(R.string.label_no_credits_cards));
        }
    }

    private void getAutomaticRecharge(final boolean loadCards) {
        this.viewModel.getAutomaticRechargeConfig(this, this.cardNumber).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getAutomaticRecharge$1(loadCards, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getAutomaticRecharge$1(boolean z, Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            if (Constants.ResponseCode.NOT_FOUND.equals(resource.code)) {
                showActivateAutoRechargeView();
                return;
            } else {
                BaseUtils.showKoDialog(this, resource.message);
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
            AutomaticRechargeModel automaticRechargeModel = (AutomaticRechargeModel) resource.data;
            this.model = automaticRechargeModel;
            this.rechargeAmount = automaticRechargeModel.getRechargeAmount();
            setupEmptyAutoRecharge(this.model.isActive().booleanValue(), this.model.getRechargeThreshold().intValue(), this.model.getRechargeAmount().intValue());
            getErrorsAutoRecharge(z);
        }
    }

    private void getErrorsAutoRecharge(final boolean loadCards) {
        this.viewModel.getErrorsAutoRecharge(this, this.cardNumber).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getErrorsAutoRecharge$2(loadCards, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getErrorsAutoRecharge$2(boolean z, Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            this.gpErrorRecharge.setVisibility(8);
            if (z) {
                setupCreditCardList();
                return;
            }
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
            this.idAutoRechargeError = ((ErrorAutomaticRechargeModel) resource.data).getId();
            this.rechargeAmount = ((ErrorAutomaticRechargeModel) resource.data).getRechargeAmount();
            this.gpErrorRecharge.setVisibility(0);
        }
        if (z) {
            setupCreditCardList();
        }
    }

    private void setupEmptyAutoRecharge(boolean isChecked, int minThreshold, int quantity) {
        setEnableRecharge(isChecked);
        this.tvMinThreshold.setText(getString(R.string.label_price_euros, new Object[]{Double.valueOf(Utils.INSTANCE.getEuros(Integer.valueOf(minThreshold)))}));
        this.tvRechargeQuantity.setText(getString(R.string.label_price_euros, new Object[]{Double.valueOf(Utils.INSTANCE.getEuros(Integer.valueOf(quantity)))}));
    }

    private void setEnableRecharge(boolean isChecked) {
        this.swAutomaticRecharge.setChecked(isChecked);
        setStatusButtons(isChecked);
    }

    private void setStatusButtons(boolean isChecked) {
        this.btEditCreditCard.setEnabled(isChecked);
        this.btEditMinThreshold.setEnabled(isChecked);
        this.btEditRechargeQuantity.setEnabled(isChecked);
        this.mbRetryAutoRecharge.setEnabled(isChecked);
    }

    private void showActivateAutoRechargeView() {
        Intent intent = new Intent(this, (Class<?>) ActivateAutoRechargeActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.cardNumber);
        startActivityForResult(intent, 13);
    }

    private void loadCardToken(List<PaymentCardModel> data) {
        for (PaymentCardModel paymentCardModel : data) {
            if (paymentCardModel.getIsFavourite().booleanValue()) {
                this.tvCreditCard.setText(paymentCardModel.getCardNumber());
            }
        }
    }

    @OnClick({R.id.btEditMinThreshold, R.id.btEditRechargeQuantity, R.id.btEditCreditCard, R.id.mbRetryAutoRecharge, R.id.swAutomaticRecharge})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.mbRetryAutoRecharge) {
            retryAutoRecharge();
            return;
        }
        if (id != R.id.swAutomaticRecharge) {
            switch (id) {
                case R.id.btEditCreditCard /* 2131361923 */:
                    startActivityForResult(new Intent(this, (Class<?>) MyPaymentCardsActivity.class), 11);
                    break;
                case R.id.btEditMinThreshold /* 2131361924 */:
                case R.id.btEditRechargeQuantity /* 2131361925 */:
                    Intent intent = new Intent(this, (Class<?>) EditAutomaticRechargeActivity.class);
                    intent.putExtra(Constants.IntentData.INTENT_MIN_THRESHOLD, this.model.getRechargeThreshold());
                    intent.putExtra(Constants.IntentData.INTENT_RECHARGE_QUANTITY, this.model.getRechargeAmount());
                    intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.cardNumber);
                    startActivityForResult(intent, 0);
                    break;
            }
            return;
        }
        changeAutoRecharge();
    }

    private void retryAutoRecharge() {
        Integer num = this.idAutoRechargeError;
        if (num != null) {
            this.viewModel.retryAutoRecharge(this, num).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity$$ExternalSyntheticLambda2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$retryAutoRecharge$3((Resource) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$retryAutoRecharge$3(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
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
        this.gpErrorRecharge.setVisibility(8);
        if (checkNFC()) {
            goBackSuccess();
        } else {
            showOkDialog();
        }
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

    private void showOkDialog() {
        BaseUtils.showInfoDialog(this, 3, getString(R.string.label_recharge_ok_price_double, new Object[]{Double.valueOf(Utils.INSTANCE.getEuros(this.rechargeAmount))}), getString(R.string.label_recharge_not_nfc), getString(R.string.label_finish_recharge_button), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity$$ExternalSyntheticLambda4
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.goBackSuccess();
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        AutomaticRechargeModel automaticRechargeModel;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == -1) {
                getAutomaticRecharge(false);
                return;
            }
            return;
        }
        if (requestCode != 13) {
            if (requestCode == 11) {
                setupCreditCardList();
            }
        } else if (resultCode != -1) {
            if (resultCode == 0) {
                onBackPressed();
            }
        } else {
            if (data == null || data.getExtras() == null || (automaticRechargeModel = (AutomaticRechargeModel) data.getExtras().getSerializable(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER)) == null) {
                return;
            }
            AutomaticRechargeModel automaticRechargeModel2 = new AutomaticRechargeModel(automaticRechargeModel.getRechargeThreshold(), automaticRechargeModel.getRechargeAmount(), automaticRechargeModel.getCardNumber(), automaticRechargeModel.isActive());
            this.model = automaticRechargeModel2;
            this.rechargeAmount = automaticRechargeModel2.getRechargeAmount();
            setupEmptyAutoRecharge(this.model.isActive().booleanValue(), this.model.getRechargeThreshold().intValue(), this.model.getRechargeAmount().intValue());
            getErrorsAutoRecharge(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return super.lambda$showIsRepresentativeDialog$3();
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity$1, reason: invalid class name */
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

    private void changeAutoRecharge() {
        this.viewModel.changeAutomaticRecharge(this, this.cardNumber).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$changeAutoRecharge$4((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeAutoRecharge$4(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(this, resource.message);
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            setStatusButtons(this.swAutomaticRecharge.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBackSuccess() {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(this.tvRechargeQuantity.getText())) {
            intent.putExtra(Constants.IntentData.INTENT_RECHARGE_QUANTITY, this.rechargeAmount);
        }
        setResult(-1, intent);
        finish();
    }
}
