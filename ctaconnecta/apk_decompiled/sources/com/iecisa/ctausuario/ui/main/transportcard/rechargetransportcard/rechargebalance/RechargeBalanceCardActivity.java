package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.PaymentCardModel;
import com.iecisa.ctausuario.model.ValidatorModel;
import com.iecisa.ctausuario.model.ValidatorResponseModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeConfigModel;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import com.iecisa.ctausuario.ui.main.BaseTransportCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.DecimalDigitsInputFilter;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentcard.PaymentCardAdapter;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.Utils;
import com.iecisa.ctausuario.utils.ValidatorUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class RechargeBalanceCardActivity extends BaseTransportCardActivity {

    @BindView(R.id.btAddCardPayment)
    MaterialButton btAddCardPayment;

    @BindView(R.id.btMyCardToken)
    MaterialButton btMyCardToken;

    @BindView(R.id.btPaymentPass)
    MaterialButton btPaymentPass;

    @BindView(R.id.btPaymentToken)
    MaterialButton btPaymentToken;

    @BindView(R.id.btPaymentWithoutCard)
    MaterialButton btPaymentWithoutCard;

    @BindView(R.id.cbAceptTermsPayment)
    CheckBox cbAceptTermsPayment;

    @BindView(R.id.etEmailSend)
    EditText etEmailSend;

    @BindView(R.id.etPrice)
    EditText etPrice;

    @BindView(R.id.etRepeatEmail)
    EditText etRepeatEmail;

    @BindView(R.id.gpPaymentTokenCard)
    Group gpPaymentTokenCard;

    @BindView(R.id.gpPaymentWithoutCard)
    Group gpPaymentWithoutCard;
    private Integer maxRechargeAmount;
    private Integer minRechargeAmount;
    private NfcAdapter nfcAdapter;
    private PaymentCardAdapter paymentCardAdapter;

    @Inject
    PreferencesHelper preferences;
    private PaymentCardModel selectedModel;
    private MutableLiveData<Integer> servicesLoading = new MutableLiveData<>();
    final Observer<Integer> servicesLoadingObserver = new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity$$ExternalSyntheticLambda10
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$0((Integer) obj);
        }
    };

    @BindView(R.id.spCardToken)
    AutoCompleteTextView spCardToken;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private TransportCardModel transportCardModel;

    @BindView(R.id.tvInfoMessage)
    TextView tvInfoMessage;

    @BindView(R.id.tvLabelAceptTermsPayment)
    TextView tvLabelAceptTermsPayment;
    private List<ValidatorModel> validatorModelList;
    private RechargeBalanceCardViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_recharge_amount_transport_card;
    }

    @Override // com.iecisa.ctausuario.ui.main.BaseTransportCardActivity, com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    private void incServicesLoading() {
        MutableLiveData<Integer> mutableLiveData = this.servicesLoading;
        mutableLiveData.setValue(Integer.valueOf(mutableLiveData.getValue().intValue() + 1));
    }

    private void decServicesLoading() {
        this.servicesLoading.setValue(Integer.valueOf(r0.getValue().intValue() - 1));
    }

    private void resetServicesLoading() {
        this.servicesLoading.setValue(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Integer num) {
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            hideLoading();
        } else {
            if (iIntValue != 1) {
                return;
            }
            showLoading();
        }
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        invalidateOptionsMenu();
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_recharge_transport_card));
        this.etPrice.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(5, 2)});
        this.viewModel = (RechargeBalanceCardViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(RechargeBalanceCardViewModelImpl.class);
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        this.servicesLoading.setValue(0);
        this.servicesLoading.observe(this, this.servicesLoadingObserver);
        createValidator();
        setupIntent();
        validateFields();
        setupListeners();
    }

    private void setupListeners() {
        this.etPrice.addTextChangedListener(new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                RechargeBalanceCardActivity.this.setSymbol(s);
                RechargeBalanceCardActivity.this.validateFields();
                ValidatorUtils.activateValidator(RechargeBalanceCardActivity.this.getCurrentFocus(), RechargeBalanceCardActivity.this.validatorModelList);
            }
        });
        this.spCardToken.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity$$ExternalSyntheticLambda2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$setupListeners$1(adapterView, view, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$1(AdapterView adapterView, View view, int i, long j) {
        PaymentCardAdapter paymentCardAdapter = this.paymentCardAdapter;
        if (paymentCardAdapter != null) {
            this.selectedModel = paymentCardAdapter.getItem(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSymbol(Editable number) {
        if (number.toString().contains(".")) {
            if (number.toString().contains(",")) {
                this.etPrice.setText(number.toString().replace(".", ""));
            } else {
                this.etPrice.setText(number.toString().replace(".", ","));
            }
            EditText editText = this.etPrice;
            editText.setSelection(editText.getText().length());
            return;
        }
        if (number.toString().contains(",") && Utils.INSTANCE.numCommas(number)) {
            this.etPrice.setText(Utils.INSTANCE.replaceCommas(number));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    private void createValidator() {
        ArrayList arrayList = new ArrayList();
        this.validatorModelList = arrayList;
        arrayList.add(new ValidatorModel(0, this.etPrice));
        this.validatorModelList.add(new ValidatorModel(1, this.etEmailSend));
        this.validatorModelList.add(new ValidatorModel(2, this.etRepeatEmail, this.etEmailSend));
        this.validatorModelList.add(new ValidatorModel(3, this.cbAceptTermsPayment.isChecked()));
    }

    private void setupIntent() {
        if (getIntent().getExtras() == null) {
            Timber.d("El intent es null", new Object[0]);
            showKoDialog("El intent es null");
        }
        TransportCardModel transportCardModel = (TransportCardModel) getIntent().getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER);
        this.transportCardModel = transportCardModel;
        if (transportCardModel == null) {
            Timber.d("El modelo de la tarjeta de transporte es null", new Object[0]);
            showKoDialog("El modelo de la tarjeta de transporte es null");
        }
        setToolbarTitle(getString(R.string.title_toolbar_recharge_transport_card_user, new Object[]{this.transportCardModel.getCardTypeName()}), getIntent().getStringExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_SUBTITLE));
        String mail = Utils.INSTANCE.getMail(this.preferences.getBearerToken());
        if (mail != null && this.preferences.getUser().equals(1)) {
            this.etEmailSend.setText(mail);
            ValidatorUtils.activateValidator(this.etEmailSend, this.validatorModelList);
            this.etRepeatEmail.setText(mail);
            ValidatorUtils.activateValidator(this.etRepeatEmail, this.validatorModelList);
        }
        getRechargeAmountLimits();
        if (this.preferences.getUser().equals(1)) {
            this.gpPaymentTokenCard.setVisibility(0);
            this.gpPaymentWithoutCard.setVisibility(0);
            this.btPaymentPass.setVisibility(8);
            setupPaymentCard();
            return;
        }
        this.gpPaymentTokenCard.setVisibility(8);
        this.gpPaymentWithoutCard.setVisibility(8);
        this.btPaymentPass.setVisibility(0);
    }

    @OnFocusChange({R.id.etEmailSend, R.id.etRepeatEmail, R.id.etPrice})
    public void onFocusChanged(View view, boolean hasFocus) {
        validate(view, hasFocus);
    }

    private void validate(View view, boolean hasFocus) {
        if (!hasFocus) {
            ValidatorUtils.activateValidator(view, this.validatorModelList);
        }
        validateFields();
    }

    @OnTextChanged({R.id.etEmailSend})
    public void onTextChangedMail(CharSequence text) {
        validate(this.etEmailSend, TextUtils.isEmpty(text));
    }

    @OnTextChanged({R.id.etRepeatEmail})
    public void onTextChangedRepeatMail(CharSequence text) {
        validate(this.etRepeatEmail, TextUtils.isEmpty(text));
    }

    @OnTextChanged({R.id.etPrice})
    public void onTextChangedPrice(CharSequence text) {
        validate(this.etPrice, TextUtils.isEmpty(text));
    }

    @OnCheckedChanged({R.id.cbAceptTermsPayment})
    public void onCheckedChanged(boolean checked) {
        ValidatorUtils.setValidatorChecked(checked, this.validatorModelList);
        validateFields();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateFields() {
        ValidatorResponseModel validatorResponseModelValidateField = ValidatorUtils.validateField(this, this.validatorModelList);
        ValidatorUtils.showErrorField(validatorResponseModelValidateField.getModel(), this.validatorModelList);
        if (validatorResponseModelValidateField.getMessage() == null) {
            if (this.minRechargeAmount != null && this.maxRechargeAmount != null) {
                if (getRechargeAmount().intValue() < this.minRechargeAmount.intValue()) {
                    this.tvInfoMessage.setVisibility(0);
                    this.tvInfoMessage.setText(getString(R.string.label_error_recharge_min_amount, new Object[]{Double.valueOf(Utils.INSTANCE.getEuros(this.minRechargeAmount))}));
                    ValidatorUtils.loadBackgroundResource(this.etPrice, true);
                    enableButtons(false);
                    return false;
                }
                if (getRechargeAmount().intValue() > this.maxRechargeAmount.intValue()) {
                    this.tvInfoMessage.setVisibility(0);
                    this.tvInfoMessage.setText(getString(R.string.label_error_recharge_max_amount, new Object[]{Double.valueOf(Utils.INSTANCE.getEuros(this.maxRechargeAmount))}));
                    ValidatorUtils.loadBackgroundResource(this.etPrice, true);
                    enableButtons(false);
                    return false;
                }
                this.tvInfoMessage.setVisibility(8);
                enableButtons(true);
                return true;
            }
            BaseUtils.showInfoDialog(this, 2, getString(R.string.label_something_go_wrong), getString(R.string.error_unknown), getString(R.string.label_accept), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity$$ExternalSyntheticLambda5
                @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
                public final void onClickPositive() {
                    this.f$0.goBackError();
                }
            });
            return false;
        }
        if (validatorResponseModelValidateField.getMessage().isEmpty()) {
            this.tvInfoMessage.setVisibility(8);
            enableButtons(false);
            return false;
        }
        this.tvInfoMessage.setVisibility(0);
        this.tvInfoMessage.setText(validatorResponseModelValidateField.getMessage());
        enableButtons(false);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBackError() {
        setResult(0, new Intent());
        finish();
    }

    private void enableButtons(boolean isEnabled) {
        this.btPaymentToken.setEnabled(isEnabled);
        this.btAddCardPayment.setEnabled(isEnabled);
        this.btPaymentWithoutCard.setEnabled(isEnabled);
        this.btPaymentPass.setEnabled(isEnabled);
    }

    private void getRechargeAmountLimits() {
        this.viewModel.getAutomaticRechargeConfig(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getRechargeAmountLimits$2((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getRechargeAmountLimits$2(Resource resource) {
        int i = AnonymousClass7.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            resetServicesLoading();
            setEnableButtons(true);
            showKoDialog(resource.message);
            return;
        }
        if (i == 2) {
            incServicesLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        if (resource.data != 0) {
            if (Constants.Cards.TRANSPORT_CARD_TYPE_BILLETE_UNICO.equals(this.transportCardModel.getCardTypeId())) {
                this.minRechargeAmount = ((AutomaticRechargeConfigModel) resource.data).getRechargeAmountMin();
                this.maxRechargeAmount = ((AutomaticRechargeConfigModel) resource.data).getRechargeAmountMax();
            } else {
                this.minRechargeAmount = ((AutomaticRechargeConfigModel) resource.data).getRechargeAnonAmountMin();
                this.maxRechargeAmount = ((AutomaticRechargeConfigModel) resource.data).getRechargeAnonAmountMax();
            }
            decServicesLoading();
            return;
        }
        resetServicesLoading();
        setEnableButtons(true);
        showKoDialog(getString(R.string.label_error_getting_min_max_amount));
    }

    private void setupPaymentCard() {
        this.viewModel.getPaymentCards(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupPaymentCard$3((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupPaymentCard$3(Resource resource) {
        int i = AnonymousClass7.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            if (resource.code.intValue() == 204) {
                showPaymentOptions(false);
                decServicesLoading();
                return;
            } else {
                resetServicesLoading();
                setEnableButtons(true);
                showKoDialog(resource.message);
                return;
            }
        }
        if (i == 2) {
            incServicesLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        if (resource.data != 0) {
            showPaymentOptions(true);
            loadPaymmentCardsAdapter((List) resource.data);
            decServicesLoading();
        } else {
            resetServicesLoading();
            setEnableButtons(true);
            showKoDialog(getString(R.string.error_recharge_getting_payment_cards));
        }
    }

    private void setupCardAndCheckout() {
        this.viewModel.getPaymentCards(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupCardAndCheckout$4((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupCardAndCheckout$4(Resource resource) {
        int i = AnonymousClass7.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            if (resource.code.intValue() == 204) {
                showPaymentOptions(false);
                decServicesLoading();
                return;
            } else {
                showKoDialog(resource.message);
                return;
            }
        }
        if (i == 2) {
            incServicesLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        if (resource.data != 0 && ((List) resource.data).size() > 0) {
            checkoutOneClickPayment(getFavouritePaymentCard((List) resource.data));
            decServicesLoading();
        } else {
            resetServicesLoading();
            setEnableButtons(true);
            showKoDialog(getString(R.string.error_recharge_getting_payment_cards));
        }
    }

    private PaymentCardModel getFavouritePaymentCard(List<PaymentCardModel> paymentCardModelList) {
        for (PaymentCardModel paymentCardModel : paymentCardModelList) {
            if (paymentCardModel.getIsFavourite().equals(true)) {
                return paymentCardModel;
            }
        }
        return paymentCardModelList.get(0);
    }

    private void loadPaymmentCardsAdapter(List<PaymentCardModel> data) {
        PaymentCardAdapter paymentCardAdapter = new PaymentCardAdapter(this, data);
        this.paymentCardAdapter = paymentCardAdapter;
        paymentCardAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spCardToken.setAdapter(this.paymentCardAdapter);
        PaymentCardModel favouritePaymentCard = getFavouritePaymentCard(data);
        this.spCardToken.setText(favouritePaymentCard.getCardNumber());
        this.selectedModel = favouritePaymentCard;
        BaseUtils.setupAdapter(this.paymentCardAdapter, this.spCardToken);
    }

    private void showPaymentOptions(boolean hasPaymentCard) {
        if (this.preferences.getUser().equals(1)) {
            this.gpPaymentTokenCard.setVisibility(hasPaymentCard ? 0 : 8);
            this.gpPaymentWithoutCard.setVisibility(hasPaymentCard ? 8 : 0);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @OnClick({R.id.btPaymentToken, R.id.tvLabelAceptTermsPayment, R.id.btAddCardPayment, R.id.btPaymentWithoutCard, R.id.btMyCardToken, R.id.btPaymentPass})
    public void onClickEvents(View view) {
        setEnableButtons(false);
        switch (view.getId()) {
            case R.id.btAddCardPayment /* 2131361915 */:
                performCheckout(Constants.RechargeType.ADD_CARD);
                return;
            case R.id.btMyCardToken /* 2131361932 */:
                startActivityForResult(new Intent(this, (Class<?>) MyPaymentCardsActivity.class), 11);
                break;
            case R.id.btPaymentPass /* 2131361937 */:
            case R.id.btPaymentWithoutCard /* 2131361939 */:
                performCheckout(Constants.RechargeType.CHECKOUT_PAYMENT_GATEWAY);
                return;
            case R.id.btPaymentToken /* 2131361938 */:
                performCheckout(Constants.RechargeType.CHECKOUT_ONE_CLICK_PAYMENT);
                return;
            case R.id.tvLabelAceptTermsPayment /* 2131362832 */:
                getLegalConditions();
                return;
        }
        setEnableButtons(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnableButtons(boolean enabled) {
        this.tvLabelAceptTermsPayment.setEnabled(enabled);
        this.btAddCardPayment.setEnabled(enabled);
        this.btPaymentToken.setEnabled(enabled);
        this.btPaymentPass.setEnabled(enabled);
        this.btPaymentWithoutCard.setEnabled(enabled);
        this.btMyCardToken.setEnabled(enabled);
    }

    private void getConditions() {
        getConditions(BuildConfig.ADD_PAYMENT_CARD, new BaseUtils.onGetConditions() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity.2
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onGetConditions
            public void onSuccess(ConditionsResponseModel model) {
                RechargeBalanceCardActivity.this.goToOneClickDialog(model.getTitle(), model.getDescription());
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onGetConditions
            public void onError(Integer code, String message) {
                RechargeBalanceCardActivity.this.showKoDialog(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToOneClickDialog(String title, String description) {
        BaseUtils.showDialog(this, 1, title, description, getString(R.string.label_payment_one_click_ok), getString(R.string.label_payment_one_click_ko), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity.3
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                RechargeBalanceCardActivity.this.addPaymentCard();
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
                RechargeBalanceCardActivity.this.setEnableButtons(true);
            }
        });
    }

    private void getLegalConditions() {
        this.viewModel.getLegalConditions(this, BuildConfig.CONDITIONS_RECHARGE).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getLegalConditions$5((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getLegalConditions$5(Resource resource) {
        int i = AnonymousClass7.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            resetServicesLoading();
            setEnableButtons(true);
            showKoDialog(resource.message);
        } else {
            if (i == 2) {
                incServicesLoading();
                return;
            }
            if (i != 3) {
                return;
            }
            resetServicesLoading();
            setEnableButtons(true);
            if (resource.data != 0) {
                BaseUtils.showDialog(this, 1, ((ConditionsResponseModel) resource.data).getTitle(), ((ConditionsResponseModel) resource.data).getDescription(), getString(R.string.label_payment_one_click_ok), getString(R.string.label_payment_one_click_ko), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity.4
                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickPositive() {
                        RechargeBalanceCardActivity.this.acceptConditions();
                    }

                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickNegative() {
                        RechargeBalanceCardActivity.this.cbAceptTermsPayment.setChecked(false);
                    }
                });
            } else {
                showKoDialog(getString(R.string.error_getting_terms));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPaymentCard() {
        this.viewModel.addPaymentCard(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$addPaymentCard$6((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addPaymentCard$6(Resource resource) {
        int i = AnonymousClass7.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            resetServicesLoading();
            setEnableButtons(true);
            BaseUtils.showKoDialog(this, resource.message);
        } else {
            if (i == 2) {
                incServicesLoading();
                return;
            }
            if (i != 3) {
                return;
            }
            resetServicesLoading();
            setEnableButtons(true);
            if (resource.data != 0) {
                Intent intent = new Intent(this, (Class<?>) RechargeRedsysActivity.class);
                intent.putExtra(Constants.IntentData.INTENT_TYPE_RECHARGE_WEBVIEW, (Parcelable) resource.data);
                intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.transportCardModel.getCardNumber());
                startActivityForResult(intent, 9);
                return;
            }
            showKoDialog(getString(R.string.error_recharge_doing_payment));
        }
    }

    private void checkoutPaymentGateway() {
        this.viewModel.checkoutPaymentGateway(this, this.transportCardModel.getCardNumber(), this.etEmailSend.getText().toString(), getRechargeAmount(), null, null).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$checkoutPaymentGateway$7((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkoutPaymentGateway$7(Resource resource) {
        int i = AnonymousClass7.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            resetServicesLoading();
            setEnableButtons(true);
            BaseUtils.showKoDialog(this, getString(R.string.label_cannot_be_recharged, new Object[]{resource.message}));
            return;
        }
        if (i == 2) {
            incServicesLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        resetServicesLoading();
        setEnableButtons(true);
        if (resource.data != 0) {
            String string = this.etPrice.getText().toString();
            Intent intent = new Intent(this, (Class<?>) RechargeRedsysActivity.class);
            intent.putExtra(Constants.IntentData.INTENT_TYPE_RECHARGE_WEBVIEW, (Parcelable) resource.data);
            intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.transportCardModel.getCardNumber());
            intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_QUANTITY, string);
            startActivityForResult(intent, 7);
            return;
        }
        showKoDialog(getString(R.string.error_recharge_doing_payment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkoutOneClickPayment(PaymentCardModel paymentCardModel) {
        this.viewModel.checkoutOneClickPayment(this, this.transportCardModel.getCardNumber(), paymentCardModel.getIdToken(), getRechargeAmount(), null, null, this.etEmailSend.getText().toString()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$checkoutOneClickPayment$8((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
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
    public /* synthetic */ void lambda$checkoutOneClickPayment$8(Resource resource) {
        int i = AnonymousClass7.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            resetServicesLoading();
            setEnableButtons(true);
            BaseUtils.showKoDialog(this, resource.message);
        } else {
            if (i == 2) {
                incServicesLoading();
                return;
            }
            if (i != 3) {
                return;
            }
            resetServicesLoading();
            setEnableButtons(true);
            if (checkNFC()) {
                goBackSuccess();
            } else {
                showRechargeOkDialog();
            }
        }
    }

    private void performCheckout(Integer rechargeType) {
        if (rechargeType.equals(Constants.RechargeType.CHECKOUT_PAYMENT_GATEWAY)) {
            checkoutPaymentGateway();
            return;
        }
        if (rechargeType.equals(Constants.RechargeType.CHECKOUT_ONE_CLICK_PAYMENT)) {
            PaymentCardModel paymentCardModel = this.selectedModel;
            if (paymentCardModel != null) {
                checkoutOneClickPayment(paymentCardModel);
                return;
            } else {
                setEnableButtons(true);
                return;
            }
        }
        getConditions();
    }

    private void showKoDialog(String message, final PaymentCardModel model) {
        BaseUtils.showDialog(this, 2, getString(R.string.label_something_go_wrong), message, getString(R.string.label_retry), getString(R.string.label_retry_later), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity.5
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                RechargeBalanceCardActivity.this.checkoutOneClickPayment(model);
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
                RechargeBalanceCardActivity.this.setResult(0, new Intent());
                RechargeBalanceCardActivity.this.finish();
            }
        });
    }

    private void showValidationKoDialog(String message) {
        BaseUtils.showDialog(this, 2, getString(R.string.label_something_go_wrong), message, getString(R.string.label_retry), getString(R.string.label_retry_later), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity.6
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
                RechargeBalanceCardActivity.this.setResult(0, new Intent());
                RechargeBalanceCardActivity.this.finish();
            }
        });
    }

    private void showRechargeOkDialog() {
        BaseUtils.showInfoDialog(this, 3, getString(R.string.label_recharge_ok_price, new Object[]{this.etPrice.getText().toString()}), getString(R.string.label_recharge_not_nfc), getString(R.string.label_finish_recharge_button), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity$$ExternalSyntheticLambda11
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.goBackSuccess();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showKoDialog(String message) {
        BaseUtils.showInfoDialog(this, 2, getString(R.string.label_something_go_wrong), message, getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity$$ExternalSyntheticLambda1
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.lambda$showKoDialog$9();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showKoDialog$9() {
        setResult(0, new Intent());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBackSuccess() {
        Intent intent = new Intent();
        intent.putExtra(Constants.IntentData.INTENT_RECHARGE_QUANTITY, getRechargeAmount());
        setResult(-1, intent);
        finish();
    }

    private Integer getRechargeAmount() {
        return Integer.valueOf(Utils.INSTANCE.getCentsForEuro(this.etPrice.getText().toString()));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 7) {
            switch (resultCode) {
                case 9:
                    goBackSuccess();
                    break;
                case 10:
                    setResult(0, new Intent());
                    finish();
                    break;
                case 11:
                    checkoutPaymentGateway();
                    break;
            }
            return;
        }
        if (requestCode == 9) {
            if (resultCode != 9) {
                return;
            }
            setupCardAndCheckout();
        } else if (requestCode == 11) {
            setupPaymentCard();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acceptConditions() {
        this.cbAceptTermsPayment.setChecked(true);
        validateFields();
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
}
