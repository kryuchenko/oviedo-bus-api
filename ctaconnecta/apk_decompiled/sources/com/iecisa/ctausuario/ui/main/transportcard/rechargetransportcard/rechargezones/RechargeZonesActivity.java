package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Parcelable;
import android.text.TextUtils;
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
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.CheckCardSimulationsResponseModel;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.PaymentCardModel;
import com.iecisa.ctausuario.model.RechargeZones;
import com.iecisa.ctausuario.model.ValidatorModel;
import com.iecisa.ctausuario.model.ValidatorResponseModel;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import com.iecisa.ctausuario.ui.main.BaseTransportCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentcard.PaymentCardAdapter;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.DateUtils;
import com.iecisa.ctausuario.utils.Utils;
import com.iecisa.ctausuario.utils.ValidatorUtils;
import com.iecisa.ctausuario.utils.dialog.BaseOptionsDialog;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class RechargeZonesActivity extends BaseTransportCardActivity {
    private ArrayList<Integer> availableTripsToBuy;
    private ArrayList<RechargeZones> availableZonesToBuy;
    private BaseOptionsDialog baseOptionsDialog;

    @BindView(R.id.btAddCardPayment)
    MaterialButton btAddCardPayment;

    @BindView(R.id.btMyCardToken)
    MaterialButton btMyCardToken;

    @BindView(R.id.btPaymentPass)
    MaterialButton btPaymentPass;

    @BindView(R.id.btPaymentToken)
    TextView btPaymentToken;

    @BindView(R.id.btPaymentWithoutCard)
    MaterialButton btPaymentWithoutCard;

    @BindView(R.id.cbAceptTermsPayment)
    CheckBox cbAceptTermsPayment;

    @BindView(R.id.etEmailSend)
    EditText etEmailSend;

    @BindView(R.id.etRepeatEmail)
    EditText etRepeatEmail;

    @BindView(R.id.gpPaymentTokenCard)
    Group gpPaymentTokenCard;

    @BindView(R.id.gpPaymentWithoutCard)
    Group gpPaymentWithoutCard;
    private int initialZones;

    @BindView(R.id.mbAmountTicket)
    MaterialButton mbAmountTicket;

    @BindView(R.id.mbNumTicketsZones)
    MaterialButton mbNumTicketsZones;

    @BindView(R.id.mbValidityDate)
    MaterialButton mbValidityDate;
    private NfcAdapter nfcAdapter;
    private NumberTripsAdapter numberTripsAdapter;
    private PaymentCardAdapter paymentCardAdapter;

    @Inject
    PreferencesHelper preferences;

    @BindView(R.id.sNumberTickets)
    AutoCompleteTextView sNumberTickets;
    private PaymentCardModel selectedPaymentCardModel;
    private Integer selectedTrips;
    private RechargeZones selectedZone;
    private MutableLiveData<Integer> servicesLoading = new MutableLiveData<>();
    final Observer<Integer> servicesLoadingObserver = new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity$$ExternalSyntheticLambda13
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$0((Integer) obj);
        }
    };

    @BindView(R.id.spCardToken)
    AutoCompleteTextView spCardToken;

    @BindView(R.id.tilNumberTickets)
    TextInputLayout tilNumberTickets;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private TransportCardModel transportCardModel;

    @BindView(R.id.tvExtendedInfo)
    TextView tvExtendedInfo;

    @BindView(R.id.tvInfoMessage)
    TextView tvInfoMessage;
    private List<ValidatorModel> validatorModelList;
    RechargeZonesViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_recharge_zones;
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
        this.viewModel = (RechargeZonesViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(RechargeZonesViewModelImpl.class);
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_recharge_transport_card));
        this.servicesLoading.setValue(0);
        this.servicesLoading.observe(this, this.servicesLoadingObserver);
        createValidator();
        setupIntent();
        validateFields();
        setupListeners();
    }

    private void setupIntent() {
        if (getIntent().getExtras() == null) {
            Timber.d("El intent es null", new Object[0]);
            showKoDialog(getString(R.string.label_error_recovering_card));
        }
        TransportCardModel transportCardModel = (TransportCardModel) getIntent().getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER);
        this.transportCardModel = transportCardModel;
        if (transportCardModel == null) {
            Timber.d("El modelo de la tarjeta de transporte es null", new Object[0]);
            showKoDialog(getString(R.string.label_error_recovering_card));
        }
        this.initialZones = this.transportCardModel.getZones().intValue();
        setupTransportCard();
        if (this.transportCardModel.getCardTypeId().equals(Constants.Cards.TRANSPORT_CARD_ABONO_CTA)) {
            this.tilNumberTickets.setVisibility(8);
            setupPassRates();
        } else {
            setupNumTrips();
        }
        setupPayment();
    }

    private void setupNumTrips() {
        this.viewModel.getNumTrips(this, this.transportCardModel.getCardNumber()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupNumTrips$1((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupNumTrips$1(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            resetServicesLoading();
            showKoDialog(resource.message);
        } else if (i == 2) {
            incServicesLoading();
        } else {
            if (i != 3) {
                return;
            }
            setupAvailableTripsToBuy((List) resource.data);
            decServicesLoading();
        }
    }

    private void setupAvailableTripsToBuy(List<Integer> availableTripsToBuy) {
        if (availableTripsToBuy == null || availableTripsToBuy.size() == 0) {
            Timber.d(getString(R.string.error_getting_num_trips) + ": null", new Object[0]);
            showKoDialog(getString(R.string.error_getting_num_trips));
        }
        this.availableTripsToBuy = new ArrayList<>(availableTripsToBuy);
        NumberTripsAdapter numberTripsAdapter = new NumberTripsAdapter(this, this.availableTripsToBuy);
        this.numberTripsAdapter = numberTripsAdapter;
        numberTripsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.sNumberTickets.setAdapter(this.numberTripsAdapter);
        Integer item = this.numberTripsAdapter.getItem(0);
        this.selectedTrips = item;
        if (item.intValue() == 1) {
            this.sNumberTickets.setText(getString(R.string.buy_trip));
        } else {
            this.sNumberTickets.setText(getString(R.string.buy_trips, new Object[]{this.selectedTrips}));
        }
        BaseUtils.setupAdapter(this.numberTripsAdapter, this.sNumberTickets);
        setupTenPassRates(this.selectedTrips);
    }

    private void setupPassRates() {
        this.viewModel.getPassRates(this, this.transportCardModel.getCardNumber()).observe(this, new RechargeZonesActivity$$ExternalSyntheticLambda7(this));
    }

    private void setupTenPassRates(Integer numTrips) {
        this.viewModel.getTenPassRates(this, this.transportCardModel.getCardNumber(), numTrips).observe(this, new RechargeZonesActivity$$ExternalSyntheticLambda7(this));
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity$4, reason: invalid class name */
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
    public void onGetRatesResponse(Resource<List<RechargeZones>> resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            resetServicesLoading();
            showKoDialog(resource.message);
        } else if (i == 2) {
            incServicesLoading();
        } else {
            if (i != 3) {
                return;
            }
            loadRechargeZonesList(resource.data);
            decServicesLoading();
        }
    }

    private void loadRechargeZonesList(List<RechargeZones> rechargeZonesList) {
        if (rechargeZonesList == null || rechargeZonesList.size() == 0) {
            String string = getString(R.string.error_getting_fares);
            Timber.d(string + ": null", new Object[0]);
            showKoDialog(string);
        }
        this.availableZonesToBuy = (ArrayList) rechargeZonesList;
        if (this.transportCardModel.getZones().equals(0)) {
            this.transportCardModel.setZones(1);
        }
        loadRechargeZones(new RechargeZones(this.transportCardModel.getZones().intValue(), setupZoneText(this.transportCardModel.getZones(), this.availableZonesToBuy)));
    }

    private void loadRechargeZones(RechargeZones rechargeZones) {
        this.selectedZone = rechargeZones;
        checkCardSimulations();
        this.mbNumTicketsZones.setText(String.valueOf(rechargeZones.getZone()));
        this.mbAmountTicket.setText(getString(R.string.label_price_euros, new Object[]{Double.valueOf(Utils.INSTANCE.getEuros(rechargeZones.getRate()))}));
    }

    private void checkCardSimulations() {
        Integer num;
        if (!this.transportCardModel.getCardTypeId().equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10)) {
            num = 0;
        } else {
            num = this.selectedTrips;
        }
        this.viewModel.checkCardSimulations(this, this.transportCardModel.getCardNumber(), num, Integer.valueOf(this.selectedZone.getZone()), 0).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$checkCardSimulations$2((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$checkCardSimulations$2(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            resetServicesLoading();
            if (resource.code.intValue() == 404) {
                loadCannotRechargeCardData(resource.message);
                return;
            } else {
                showKoDialog(resource.message);
                return;
            }
        }
        if (i == 2) {
            incServicesLoading();
        } else {
            if (i != 3) {
                return;
            }
            loadCardSimulationsData((String) resource.data);
            decServicesLoading();
        }
    }

    private void loadCardSimulationsData(String cardSimulationsData) {
        if (cardSimulationsData == null) {
            String string = getString(R.string.error_getting_validity_date);
            Timber.d(string + ": null", new Object[0]);
            showKoDialog(string);
        }
        CheckCardSimulationsResponseModel checkCardSimulationsResponseModel = (CheckCardSimulationsResponseModel) new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DOTS).create().fromJson(cardSimulationsData, CheckCardSimulationsResponseModel.class);
        if (checkCardSimulationsResponseModel.getValidityDate() != null) {
            this.mbValidityDate.setText(DateUtils.getDate(checkCardSimulationsResponseModel.getValidityDate()));
        } else {
            this.mbValidityDate.setText(getString(R.string.label_not_used));
        }
        validateFields();
        if (checkCardSimulationsResponseModel.getExtensionBit().booleanValue()) {
            this.tvExtendedInfo.setVisibility(0);
        } else {
            this.tvExtendedInfo.setVisibility(8);
        }
    }

    private void loadCannotRechargeCardData(String errorMessage) {
        this.mbValidityDate.setText("");
        this.tvInfoMessage.setText(getString(R.string.label_cannot_be_recharged, new Object[]{errorMessage}));
        validateFields();
    }

    private void setupListeners() {
        this.sNumberTickets.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity$$ExternalSyntheticLambda5
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$setupListeners$3(adapterView, view, i, j);
            }
        });
        this.spCardToken.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity$$ExternalSyntheticLambda6
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$setupListeners$4(adapterView, view, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$3(AdapterView adapterView, View view, int i, long j) {
        NumberTripsAdapter numberTripsAdapter = this.numberTripsAdapter;
        if (numberTripsAdapter != null) {
            Integer item = numberTripsAdapter.getItem(i);
            this.selectedTrips = item;
            if (item.intValue() == 1) {
                this.sNumberTickets.setText(getString(R.string.buy_trip));
            } else {
                this.sNumberTickets.setText(getString(R.string.buy_trips, new Object[]{this.selectedTrips}));
            }
            BaseUtils.setupAdapter(this.numberTripsAdapter, this.sNumberTickets);
            setupTenPassRates(this.selectedTrips);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$4(AdapterView adapterView, View view, int i, long j) {
        PaymentCardAdapter paymentCardAdapter = this.paymentCardAdapter;
        if (paymentCardAdapter != null) {
            this.selectedPaymentCardModel = paymentCardAdapter.getItem(i);
            BaseUtils.setupAdapter(this.numberTripsAdapter, this.sNumberTickets);
        }
    }

    private void createValidator() {
        ArrayList arrayList = new ArrayList();
        this.validatorModelList = arrayList;
        arrayList.add(new ValidatorModel(1, this.etEmailSend));
        this.validatorModelList.add(new ValidatorModel(2, this.etRepeatEmail, this.etEmailSend));
        this.validatorModelList.add(new ValidatorModel(3, this.cbAceptTermsPayment.isChecked()));
    }

    private void setupTransportCard() {
        setToolbarTitle(getString(R.string.title_toolbar_recharge_transport_card_user, new Object[]{this.transportCardModel.getCardTypeName()}), getIntent().getStringExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_SUBTITLE));
        String mail = Utils.INSTANCE.getMail(this.preferences.getBearerToken());
        if (mail == null || !this.preferences.getUser().equals(1)) {
            return;
        }
        this.etEmailSend.setText(mail);
        ValidatorUtils.activateValidator(this.etEmailSend, this.validatorModelList);
        this.etRepeatEmail.setText(mail);
        ValidatorUtils.activateValidator(this.etRepeatEmail, this.validatorModelList);
    }

    private void setupPayment() {
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

    private void setupPaymentCard() {
        this.viewModel.getPaymentCards(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupPaymentCard$5((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupPaymentCard$5(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            if (resource.code.intValue() == 204) {
                showPaymentOptions(false);
                decServicesLoading();
                return;
            } else {
                resetServicesLoading();
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
            showKoDialog(getString(R.string.error_recharge_getting_payment_cards));
        }
    }

    private void loadPaymmentCardsAdapter(List<PaymentCardModel> data) {
        PaymentCardAdapter paymentCardAdapter = new PaymentCardAdapter(this, data);
        this.paymentCardAdapter = paymentCardAdapter;
        paymentCardAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spCardToken.setAdapter(this.paymentCardAdapter);
        PaymentCardModel favouritePaymentCard = getFavouritePaymentCard(data);
        this.spCardToken.setText(favouritePaymentCard.getCardNumber());
        this.selectedPaymentCardModel = favouritePaymentCard;
        BaseUtils.setupAdapter(this.paymentCardAdapter, this.spCardToken);
    }

    private void showPaymentOptions(boolean hasPaymentCard) {
        if (this.preferences.getUser().equals(1)) {
            this.gpPaymentWithoutCard.setVisibility(hasPaymentCard ? 8 : 0);
            this.gpPaymentTokenCard.setVisibility(hasPaymentCard ? 0 : 8);
        }
    }

    private Double setupZoneText(Integer zones, List<RechargeZones> rechargeZonesList) {
        for (RechargeZones rechargeZones : rechargeZonesList) {
            if (zones.equals(Integer.valueOf(rechargeZones.getZone()))) {
                return rechargeZones.getRate();
            }
        }
        return Double.valueOf(0.0d);
    }

    @OnTextChanged({R.id.etEmailSend})
    public void onTextChangedMail(CharSequence text) {
        if (!TextUtils.isEmpty(text)) {
            ValidatorUtils.activateValidator(this.etEmailSend, this.validatorModelList);
        }
        validateFields();
    }

    @OnTextChanged({R.id.etRepeatEmail})
    public void onTextChangedRepeatMail(CharSequence text) {
        if (!TextUtils.isEmpty(text)) {
            ValidatorUtils.activateValidator(this.etRepeatEmail, this.validatorModelList);
        }
        validateFields();
    }

    @OnFocusChange({R.id.etEmailSend, R.id.etRepeatEmail})
    public void onFocusChanged(View view, boolean hasFocus) {
        if (!hasFocus) {
            ValidatorUtils.activateValidator(view, this.validatorModelList);
        }
        validateFields();
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
        if (this.mbValidityDate.getText() == "") {
            this.tvInfoMessage.setVisibility(0);
            ValidatorUtils.loadBackgroundResource(this.sNumberTickets, true);
            enableButtons(false);
            return false;
        }
        ValidatorUtils.loadBackgroundResource(this.sNumberTickets, false);
        if (validatorResponseModelValidateField.getMessage() == null) {
            this.tvInfoMessage.setVisibility(8);
            enableButtons(true);
            return true;
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

    private void enableButtons(boolean isEnabled) {
        this.btPaymentToken.setEnabled(isEnabled);
        this.btAddCardPayment.setEnabled(isEnabled);
        this.btPaymentWithoutCard.setEnabled(isEnabled);
        this.btPaymentPass.setEnabled(isEnabled);
    }

    @OnClick({R.id.btCalculateZones, R.id.btPaymentToken, R.id.tvLabelAceptTermsPayment, R.id.btAddCardPayment, R.id.btPaymentWithoutCard, R.id.btMyCardToken, R.id.btPaymentPass})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btAddCardPayment /* 2131361915 */:
                addPaymentCardAndCheckout();
                break;
            case R.id.btCalculateZones /* 2131361919 */:
                Intent intent = new Intent(this, (Class<?>) ChangeZonesRechargeActivity.class);
                intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.transportCardModel);
                intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TRIPS, this.availableTripsToBuy);
                intent.putExtra(Constants.IntentData.INTENT_TYPE_RECHARGE_ZONES_INIT, this.initialZones > 0);
                intent.putExtra(Constants.IntentData.INTENT_TYPE_RECHARGE_ZONES_INITIAL, this.initialZones);
                intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TRIP, this.selectedTrips);
                intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_LIST_ZONES, this.availableZonesToBuy);
                startActivityForResult(intent, 0);
                break;
            case R.id.btMyCardToken /* 2131361932 */:
                startActivityForResult(new Intent(this, (Class<?>) MyPaymentCardsActivity.class), 11);
                break;
            case R.id.btPaymentPass /* 2131361937 */:
            case R.id.btPaymentWithoutCard /* 2131361939 */:
                checkoutPaymentGateway();
                break;
            case R.id.btPaymentToken /* 2131361938 */:
                PaymentCardModel paymentCardModel = this.selectedPaymentCardModel;
                if (paymentCardModel != null) {
                    checkoutOneClickPayment(paymentCardModel);
                    break;
                }
                break;
            case R.id.tvLabelAceptTermsPayment /* 2131362832 */:
                getLegalConditions();
                break;
        }
    }

    private void addPaymentCardAndCheckout() {
        getConditions(BuildConfig.ADD_PAYMENT_CARD, new BaseUtils.onGetConditions() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity.1
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onGetConditions
            public void onSuccess(ConditionsResponseModel model) {
                RechargeZonesActivity.this.goToOneClickPaymentDialog(model.getTitle(), model.getDescription());
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onGetConditions
            public void onError(Integer code, String message) {
                RechargeZonesActivity.this.showKoDialog(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToOneClickPaymentDialog(String title, String description) {
        BaseUtils.showDialog(this, 1, title, description, getString(R.string.label_payment_one_click_ok), getString(R.string.label_payment_one_click_ko), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity.2
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                RechargeZonesActivity.this.addPaymentCard();
            }
        });
    }

    private void getLegalConditions() {
        this.viewModel.getLegalConditions(this, BuildConfig.CONDITIONS_RECHARGE).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getLegalConditions$6((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getLegalConditions$6(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            resetServicesLoading();
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
            if (resource.data != 0) {
                BaseUtils.showDialog(this, 1, ((ConditionsResponseModel) resource.data).getTitle(), ((ConditionsResponseModel) resource.data).getDescription(), getString(R.string.label_payment_one_click_ok), getString(R.string.label_payment_one_click_ko), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity.3
                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickPositive() {
                        RechargeZonesActivity.this.cbAceptTermsPayment.setChecked(true);
                        RechargeZonesActivity.this.validateFields();
                    }

                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickNegative() {
                        RechargeZonesActivity.this.cbAceptTermsPayment.setChecked(false);
                    }
                });
            } else {
                showKoDialog(getString(R.string.error_getting_terms));
            }
        }
    }

    private void checkoutOneClickPayment(PaymentCardModel paymentCardModel) {
        this.viewModel.checkoutOneClickPayment(this, this.transportCardModel.getCardNumber(), paymentCardModel.getIdToken(), null, Integer.valueOf(this.selectedZone.getZone()), this.transportCardModel.getCardTypeId().equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10) ? this.selectedTrips : null, this.etEmailSend.getText().toString()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$checkoutOneClickPayment$7((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkoutOneClickPayment$7(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            resetServicesLoading();
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
            if (checkNFC()) {
                goBackSuccess();
            } else {
                showOkDialog();
            }
        }
    }

    private void showOkDialog() {
        String string;
        Integer num;
        if (this.transportCardModel.getCardTypeId().equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10) && (num = this.selectedTrips) != null) {
            string = getString(R.string.label_rtm_recharge_trips, new Object[]{num});
        } else {
            string = getString(R.string.label_buy_new_pass);
        }
        this.baseOptionsDialog = BaseUtils.showInfoDialog(this, 3, string, getString(R.string.label_recharge_not_nfc), getString(R.string.label_finish_recharge_button), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity$$ExternalSyntheticLambda11
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.goBackSuccess();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBackSuccess() {
        BaseOptionsDialog baseOptionsDialog = this.baseOptionsDialog;
        if (baseOptionsDialog != null) {
            baseOptionsDialog.dismiss();
        }
        Intent intent = new Intent();
        intent.putExtra(Constants.IntentData.INTENT_RECHARGE_ZONES, Integer.parseInt(this.mbNumTicketsZones.getText().toString()));
        if (this.transportCardModel.getCardTypeId().equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10) && this.sNumberTickets != null) {
            intent.putExtra(Constants.IntentData.INTENT_RECHARGE_TRIPS, this.selectedTrips);
        }
        setResult(-1, intent);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void addPaymentCard() {
        this.viewModel.addPaymentCard(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$addPaymentCard$8((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addPaymentCard$8(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            resetServicesLoading();
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
        resetServicesLoading();
        if (resource.data != 0) {
            Intent intent = new Intent(this, (Class<?>) RechargeRedsysActivity.class);
            intent.putExtra(Constants.IntentData.INTENT_TYPE_RECHARGE_WEBVIEW, (Parcelable) resource.data);
            intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.transportCardModel.getCardNumber());
            startActivityForResult(intent, 9);
            return;
        }
        showKoDialog(getString(R.string.error_recharge_doing_payment));
    }

    private void checkoutPaymentGateway() {
        this.viewModel.checkoutPaymentGateway(this, this.transportCardModel.getCardNumber(), this.etEmailSend.getText().toString(), null, Integer.valueOf(this.selectedZone.getZone()), this.transportCardModel.getCardTypeId().equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10) ? this.selectedTrips : null).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$checkoutPaymentGateway$9((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkoutPaymentGateway$9(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            resetServicesLoading();
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
        resetServicesLoading();
        if (resource.data != 0) {
            Intent intent = new Intent(this, (Class<?>) RechargeRedsysActivity.class);
            intent.putExtra(Constants.IntentData.INTENT_TYPE_RECHARGE_WEBVIEW, (Parcelable) resource.data);
            startActivityForResult(intent, 7);
            return;
        }
        showKoDialog(getString(R.string.error_recharge_doing_payment));
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        BaseOptionsDialog baseOptionsDialog = this.baseOptionsDialog;
        if (baseOptionsDialog != null) {
            baseOptionsDialog.dismiss();
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (data == null || data.getExtras() == null) {
                return;
            }
            if (data.getParcelableExtra(Constants.IntentData.INTENT_TYPE_RECHARGE_ZONES) != null && (data.getParcelableExtra(Constants.IntentData.INTENT_TYPE_RECHARGE_ZONES) instanceof RechargeZones)) {
                RechargeZones rechargeZones = (RechargeZones) data.getParcelableExtra(Constants.IntentData.INTENT_TYPE_RECHARGE_ZONES);
                TransportCardModel transportCardModel = this.transportCardModel;
                if (transportCardModel != null && rechargeZones != null) {
                    transportCardModel.setZones(Integer.valueOf(rechargeZones.getZone()));
                    loadRechargeZones(rechargeZones);
                }
            }
            TransportCardModel transportCardModel2 = this.transportCardModel;
            if (transportCardModel2 == null || !transportCardModel2.getCardTypeId().equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10) || data.getIntExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TRIP, 0) == 0) {
                return;
            }
            selectNumberTrips(data.getIntExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TRIP, 0));
        }
        if (requestCode != 7) {
            if (requestCode == 9) {
                if (resultCode != 9) {
                    return;
                }
                setupCardAndCheckout();
                return;
            } else {
                if (requestCode == 11) {
                    setupPaymentCard();
                    return;
                }
                return;
            }
        }
        switch (resultCode) {
            case 9:
                goBackSuccess();
                break;
            case 10:
                BaseOptionsDialog baseOptionsDialog = this.baseOptionsDialog;
                if (baseOptionsDialog != null) {
                    baseOptionsDialog.dismiss();
                }
                setResult(0, new Intent());
                finish();
                break;
            case 11:
                checkoutPaymentGateway();
                break;
        }
    }

    private void selectNumberTrips(int trips) {
        Integer item = this.numberTripsAdapter.getItem(this.numberTripsAdapter.getPosition(Integer.valueOf(trips)));
        this.selectedTrips = item;
        if (item.intValue() == 1) {
            this.sNumberTickets.setText(getString(R.string.buy_trip));
        } else {
            this.sNumberTickets.setText(getString(R.string.buy_trips, new Object[]{this.selectedTrips}));
        }
        BaseUtils.setupAdapter(this.numberTripsAdapter, this.sNumberTickets);
    }

    private void setupCardAndCheckout() {
        this.viewModel.getPaymentCards(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupCardAndCheckout$10((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupCardAndCheckout$10(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            if (resource.code.intValue() == 204) {
                showPaymentOptions(false);
                decServicesLoading();
                return;
            } else {
                resetServicesLoading();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showKoDialog(String description) {
        BaseUtils.showInfoDialog(this, 2, getString(R.string.label_something_go_wrong), description, getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity$$ExternalSyntheticLambda10
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.lambda$showKoDialog$11();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showKoDialog$11() {
        setResult(0, new Intent());
        finish();
    }
}
