package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.CardResponseModel;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.detailtransportcard.InfoTransportCardFragment;
import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.movementstransportcard.MovementsTransportCardFragment;
import com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.incident.IncidentActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmCardActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.DateUtils;
import com.iecisa.ctausuario.utils.Utils;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class DetailTransportCardActivity extends CustomToolbarActivity {
    protected static final String BLANK = " ";
    protected static final String EMPTY = "";
    public static final int FRAGMENT_DETAILS = 1;
    public static final int FRAGMENT_MOVEMENTS = 0;
    protected static final String NEW_LINE = "\n";
    protected static final String PLURAL = "s";
    private CardResponseModel cardModel;
    private Integer cardTypeId;

    @BindView(R.id.ctaImpersonalPass)
    ConstraintLayout ctaImpersonalPass;

    @BindView(R.id.ctaPass)
    ConstraintLayout ctaPass;

    @BindView(R.id.ctaSinglePass)
    ConstraintLayout ctaSinglePass;

    @BindView(R.id.ctaTenImpersonalPass)
    ConstraintLayout ctaTenImpersonalPass;

    @BindView(R.id.gpDetails)
    Group gpDetails;
    private boolean isRTM;

    @BindView(R.id.mbBalance)
    MaterialButton mbBalance;

    @BindView(R.id.mbNumTicketsZones)
    MaterialButton mbNumTicketsZones;

    @BindView(R.id.mbNumZones)
    MaterialButton mbNumZones;

    @BindView(R.id.mbPocket)
    MaterialButton mbPocket;

    @BindView(R.id.mbRechargeCtaImpersonalPass)
    MaterialButton mbRechargeCtaImpersonalPass;

    @BindView(R.id.mbRechargeCtaPass)
    MaterialButton mbRechargeCtaPass;

    @BindView(R.id.mbRechargeSinglePass)
    MaterialButton mbRechargeSinglePass;

    @BindView(R.id.mbRechargeImpersonalPass)
    MaterialButton mbRechargeTenImpersonalPass;

    @BindView(R.id.mbTripTicket)
    MaterialButton mbTripTicket;

    @BindView(R.id.mbValidTicketUntil)
    MaterialButton mbValidTicketUntil;

    @BindView(R.id.mbValidUntil)
    MaterialButton mbValidUntil;
    private TransportCardModel model;
    private NfcAdapter nfcAdapter;

    @Inject
    PreferencesHelper preferences;
    private String subtitle;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvAdvice)
    TextView tvAdvice;

    @BindView(R.id.tvExpired)
    TextView tvExpired;

    @BindView(R.id.tvExpiredInfo)
    TextView tvExpiredInfo;

    @BindView(R.id.tvExtendedInfo)
    TextView tvExtendedInfo;

    @BindView(R.id.tvInfoDetails)
    TextView tvInfoDetails;

    @BindView(R.id.tvInfoTransportCardAction)
    TextView tvInfoTransportCardAction;

    @BindView(R.id.tvRechargeTransportCardAction)
    TextView tvRechargeTransportCardAction;

    @BindView(R.id.tvSpendInfo)
    TextView tvSpendInfo;

    @BindViews({R.id.tvInfoTransportCardAction, R.id.tvRechargeTransportCardAction})
    List<TextView> tvTransportCardAction;

    @BindView(R.id.tvTripsInfo)
    TextView tvTripsInfo;
    private boolean unloggedDetail;
    private DetailTransportCardViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final Fragment fragmentMovementsTransportCard = new MovementsTransportCardFragment();
    private final Fragment fragmentDetailsTransportCard = new InfoTransportCardFragment();
    private int isActive = Constants.CardStatus.ACTIVE.intValue();
    private boolean canRechargeTransportCard = true;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_detail_transport_card;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (DetailTransportCardViewModel) new ViewModelProvider(this, this.viewModelFactory).get(DetailTransportCardViewModelImpl.class);
        this.tvTransportCardAction.get(0).setSelected(true);
        this.tvTransportCardAction.get(1).setSelected(false);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.titile_toolbar_recharge));
        if (getIntent().getExtras() != null) {
            if (getIntent().getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER) instanceof CardResponseModel) {
                CardResponseModel cardResponseModel = (CardResponseModel) getIntent().getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER);
                this.cardModel = cardResponseModel;
                if (cardResponseModel != null) {
                    setupView();
                    loadDetailCard();
                    this.cardTypeId = this.cardModel.getCardTypeId();
                    return;
                }
                return;
            }
            if (getIntent().getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER) instanceof TransportCardModel) {
                this.model = (TransportCardModel) getIntent().getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER);
                this.isRTM = getIntent().getBooleanExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_RMT, false);
                this.unloggedDetail = getIntent().getBooleanExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_UNLOGGED_DETAIL, false);
                setupMessageUpdate();
                TransportCardModel transportCardModel = this.model;
                if (transportCardModel != null) {
                    this.cardTypeId = transportCardModel.getCardTypeId();
                }
                setupView();
                setupDetailCard();
            }
        }
    }

    private void initNFC() {
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
    }

    private void setupView() {
        this.ctaSinglePass.setVisibility(8);
        this.ctaPass.setVisibility(8);
        this.ctaImpersonalPass.setVisibility(8);
        this.ctaTenImpersonalPass.setVisibility(8);
    }

    private void showDetails(boolean isVisible) {
        this.gpDetails.setVisibility(isVisible ? 0 : 8);
        this.tvInfoDetails.setVisibility(isVisible ? 8 : 0);
        this.tvInfoDetails.setText(getString(R.string.view_detail_error));
    }

    private void showOptionDetails(boolean isVisible) {
        this.tvRechargeTransportCardAction.setVisibility(isVisible ? 0 : 8);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.isActive == Constants.CardStatus.BLOCK.intValue()) {
            getMenuInflater().inflate(R.menu.menu_block_detail_card, menu);
        } else {
            getMenuInflater().inflate(R.menu.menu_main_detail_card, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.isActive == Constants.CardStatus.ACTIVE.intValue()) {
            menu.findItem(R.id.navAutoRecharge).setVisible(Constants.Cards.TRANSPORT_CARD_TYPE_BILLETE_UNICO.equals(this.cardTypeId) && this.canRechargeTransportCard);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navAutoRecharge /* 2131362448 */:
                goToAutomaticRecharge();
                break;
            case R.id.navCertificate /* 2131362449 */:
                goToCertificate();
                break;
            case R.id.navLargeFamilyDiscount /* 2131362451 */:
                Intent intent = new Intent(this, (Class<?>) LargeFamilyDiscountActivity.class);
                TransportCardModel transportCardModel = this.model;
                if (transportCardModel != null && transportCardModel.getCardNumber() != null) {
                    intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.model.getCardNumber());
                } else {
                    CardResponseModel cardResponseModel = this.cardModel;
                    if (cardResponseModel != null && cardResponseModel.getNumChip() != null) {
                        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.cardModel.getNumChip());
                    }
                }
                startActivityForResult(intent, 2);
                break;
            case R.id.navSendIncident /* 2131362455 */:
                Intent intent2 = new Intent(this, (Class<?>) IncidentActivity.class);
                intent2.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.model);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void goToCertificate() {
        Intent intent = new Intent(this, (Class<?>) CertificateActivity.class);
        TransportCardModel transportCardModel = this.model;
        if (transportCardModel != null && transportCardModel.getCardNumber() != null) {
            intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.model.getCardNumber());
        } else {
            CardResponseModel cardResponseModel = this.cardModel;
            if (cardResponseModel != null && cardResponseModel.getNumChip() != null) {
                intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.cardModel.getNumChip());
            }
        }
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TYPE, this.cardTypeId);
        startActivity(intent);
    }

    private void goToAutomaticRecharge() {
        TransportCardModel transportCardModel = this.model;
        if (transportCardModel != null && transportCardModel.getCardNumber() != null) {
            Intent intent = new Intent(this, (Class<?>) AutomaticRechargeActivity.class);
            intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.model.getCardNumber());
            startActivityForResult(intent, 15);
            return;
        }
        showBlockDialog(getString(R.string.error), getString(R.string.error_unknown));
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }

    @OnClick({R.id.tvInfoTransportCardAction, R.id.tvRechargeTransportCardAction})
    public void onClickEvents(View view) {
        int id = view.getId();
        if (id == R.id.tvInfoTransportCardAction) {
            setFragment(this.fragmentMovementsTransportCard);
            this.tvTransportCardAction.get(0).setSelected(true);
            this.tvTransportCardAction.get(1).setSelected(false);
        } else {
            if (id == R.id.tvRechargeTransportCardAction) {
                setFragment(this.fragmentDetailsTransportCard);
                this.tvTransportCardAction.get(0).setSelected(false);
                this.tvTransportCardAction.get(1).setSelected(true);
                return;
            }
            Timber.d("Unknown Action Selected", new Object[0]);
        }
    }

    private void setFragment(Fragment selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = this.fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, selectedFragment);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            if (resultCode != 1) {
                if (requestCode == 1) {
                    onBackPressed();
                    return;
                } else {
                    refreshDetailCard();
                    return;
                }
            }
            if (requestCode == 10) {
                if (data == null || data.getExtras() == null) {
                    return;
                }
                loadDetailDialog(data);
                return;
            }
            if (requestCode == 1) {
                showReactivatedDialog();
                return;
            } else {
                refreshDetailCard();
                return;
            }
        }
        if (requestCode == 1) {
            reloadViewForResult(data);
            return;
        }
        if (requestCode == 0) {
            initNFC();
            int i = data.getExtras().getInt(Constants.IntentData.INTENT_RECHARGE_QUANTITY, 0);
            int i2 = data.getExtras().getInt(Constants.IntentData.INTENT_RECHARGE_TRIPS, 0);
            if (checkNFC()) {
                loadRtmRecharge(i, i2);
                return;
            } else {
                refreshDetailCard();
                return;
            }
        }
        if (requestCode == 15) {
            initNFC();
            int i3 = data.getExtras().getInt(Constants.IntentData.INTENT_RECHARGE_QUANTITY, 0);
            if (checkNFC()) {
                loadRtmRecharge(i3, 0);
                return;
            } else {
                refreshDetailCard();
                return;
            }
        }
        if (requestCode == 2) {
            initNFC();
            if (checkNFC()) {
                readRtmCard();
                return;
            }
            return;
        }
        if (requestCode == 10) {
            reloadViewForResult(data);
            return;
        }
        if (requestCode != 12 || data == null || data.getExtras() == null) {
            return;
        }
        String string = data.getExtras().getString(Constants.IntentData.INTENT_RECHARGE_ALIAS, "");
        this.model.setAlias(string);
        if (string != null && !TextUtils.isEmpty(string)) {
            setToolbarSubtitle(string);
        } else {
            setToolbarSubtitle(this.model.getCardNumber());
        }
    }

    private void showReactivatedDialog() {
        BaseUtils.showInfoDialog(this, 0, null, getString(R.string.label_reactivate_info, new Object[]{this.model.getCardNumber()}), getString(R.string.label_finish_recharge_button), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity$$ExternalSyntheticLambda1
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.onBackPressed();
            }
        });
    }

    private void reloadViewForResult(Intent data) {
        if (data == null || data.getExtras() == null || !(data.getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_RECHARGE_RTM) instanceof TransportCardModel)) {
            return;
        }
        this.isRTM = true;
        TransportCardModel transportCardModel = (TransportCardModel) data.getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_RECHARGE_RTM);
        if (transportCardModel != null) {
            setupMessageUpdate();
            showDetailTransportCard(transportCardModel);
        }
    }

    private void loadDetailDialog(Intent data) {
        String string;
        int intExtra = data.getIntExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TYPE_RTM, 0);
        int intExtra2 = data.getIntExtra(Constants.IntentData.INTENT_RECHARGE_QUANTITY, 0);
        int intExtra3 = data.getIntExtra(Constants.IntentData.INTENT_RECHARGE_TRIPS, 0);
        if (intExtra == 2) {
            if (intExtra2 != 0) {
                string = getString(R.string.label_recharge_ok_price_double, new Object[]{Double.valueOf(Utils.INSTANCE.getEuros(Double.valueOf(intExtra2)))});
            } else {
                string = intExtra3 != 0 ? getString(R.string.label_rtm_recharge_trips, new Object[]{Integer.valueOf(intExtra3)}) : getString(R.string.label_buy_new_pass);
            }
            showOkDetailDialog(string);
            return;
        }
        refreshDetailCard();
    }

    private void showOkDetailDialog(String title) {
        BaseUtils.showInfoDialog(this, 3, title, getString(R.string.label_recharge_not_nfc), getString(R.string.label_finish_recharge_button), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity$$ExternalSyntheticLambda3
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.refreshDetailCard();
            }
        });
    }

    private void loadRtmRecharge(int rechargeQuantity, int rechargeTrips) {
        this.isRTM = false;
        Intent intent = new Intent(this, (Class<?>) RtmCardActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TYPE_RTM, 2);
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.model);
        intent.putExtra(Constants.IntentData.INTENT_RECHARGE_QUANTITY, rechargeQuantity);
        intent.putExtra(Constants.IntentData.INTENT_RECHARGE_TRIPS, rechargeTrips);
        startActivityForResult(intent, 10);
    }

    private void readRtmCard() {
        this.isRTM = false;
        Intent intent = new Intent(this, (Class<?>) RtmCardActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TYPE_RTM, 1);
        TransportCardModel transportCardModel = this.model;
        if (transportCardModel != null) {
            intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, transportCardModel.getCardNumber());
        }
        intent.putExtra(Constants.IntentData.INTENT_READ_CARD, true);
        startActivityForResult(intent, 10);
    }

    private boolean checkNFC() {
        if (this.viewModel.initNfcAdapter(this.nfcAdapter) == Resource.Status.ERROR) {
            return false;
        }
        Resource.Status status = Resource.Status.LOADING;
        return true;
    }

    private void loadDetailCard() {
        this.viewModel.loadDetailsCard(this, this.cardModel.getNumChip(), this.cardModel.getCardTypeId()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$loadDetailCard$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$loadDetailCard$0(Resource resource) {
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
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
                showDetailCard((TransportCardModel) resource.data);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshDetailCard() {
        TransportCardModel transportCardModel = this.model;
        if (transportCardModel == null || this.cardTypeId == null) {
            return;
        }
        this.viewModel.loadDetailsCard(this, transportCardModel.getCardNumber(), this.cardTypeId).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$refreshDetailCard$1((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$refreshDetailCard$1(Resource resource) {
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
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
            showDetailCard((TransportCardModel) resource.data);
            ((MovementsTransportCardFragment) this.fragmentMovementsTransportCard).refreshAdapter(((TransportCardModel) resource.data).getHistoricsData());
        }
    }

    private void showDetailCard(TransportCardModel detailResponseModel) {
        this.model = detailResponseModel;
        detailResponseModel.setCardTypeId(this.cardTypeId);
        CardResponseModel cardResponseModel = this.cardModel;
        if (cardResponseModel != null && cardResponseModel.getAlias() != null) {
            this.model.setAlias(this.cardModel.getAlias());
        }
        setupMessageUpdate();
        setupDetailCard();
    }

    private void showDetailTransportCard(TransportCardModel detailResponseModel) {
        this.model = detailResponseModel;
        detailResponseModel.setCardTypeId(this.cardTypeId);
        ((MovementsTransportCardFragment) this.fragmentMovementsTransportCard).refreshAdapter(detailResponseModel.getHistoricsData());
        this.tvAdvice.setVisibility(8);
        setupDetailCard();
    }

    private void setupMessageUpdate() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (!this.isRTM && this.model.getLastUpdate() != null) {
            if (this.model.getPendingAmount() != null && this.model.getPendingAmount().doubleValue() > 0.0d) {
                str = NEW_LINE;
            } else {
                str = BLANK;
            }
            sb.append(getString(R.string.label_update_data_card_short));
            sb.append(str);
        }
        if (this.model.getPendingAmount() != null && this.model.getPendingAmount().doubleValue() > 0.0d) {
            sb.append(getString(R.string.label_update_pending_amount, new Object[]{Double.valueOf(Utils.INSTANCE.getEuros(this.model.getPendingAmount()))}));
        }
        if (sb.length() > 0) {
            this.tvAdvice.setText(sb.toString());
            this.tvAdvice.setVisibility(0);
        } else {
            this.tvAdvice.setVisibility(8);
        }
    }

    private void setupDetailCard() {
        setTitleToolbar(this.model.getCardTypeName(), this.model.getCardNumber());
        setFragment(this.fragmentMovementsTransportCard);
        if (isActive(this.model.getCardStatusId(), this.model.getReactivable())) {
            if (this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10)) {
                setupBono10(this.model);
                return;
            }
            if (this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_ABONO_CTA)) {
                setupAbonoCTA(this.model);
            } else if (this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_CTA)) {
                setupBonoCTA(this.model);
            } else if (this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_TYPE_BILLETE_UNICO)) {
                setupBilleteUnico(this.model);
            }
        }
    }

    private boolean isActive(Integer status, Integer reactivable) {
        if (Constants.CardStatus.ACTIVE.equals(status)) {
            return true;
        }
        if (Constants.CardStatus.BLOCK.equals(status)) {
            this.isActive = Constants.CardStatus.BLOCK.intValue();
            invalidateOptionsMenu();
            blockRecharge();
            if (Constants.ReactivatedCardStatus.BLOCKED.equals(reactivable)) {
                showBlockDialog(getString(R.string.label_title_blocked), getString(R.string.label_description_blocked));
            } else if (Constants.ReactivatedCardStatus.REACTIVATED.equals(reactivable)) {
                showBlockDialog(getString(R.string.label_title_blocked), getString(R.string.label_description_reactivated));
            } else {
                if (Constants.ReactivatedCardStatus.REACTIVABLE.equals(reactivable)) {
                    showBlockDialog(getString(R.string.label_title_blocked), getString(R.string.label_description_reactivable), getString(R.string.label_reactivate), getString(R.string.label_not_in_this_moment), true);
                }
                return false;
            }
            return false;
        }
        showBlockDialog(getString(R.string.label_title_disabled), getString(R.string.label_description_disabled));
        return false;
    }

    private void blockRecharge() {
        this.mbRechargeCtaImpersonalPass.setEnabled(false);
        this.mbRechargeCtaPass.setEnabled(false);
        this.mbRechargeSinglePass.setEnabled(false);
        this.mbRechargeTenImpersonalPass.setEnabled(false);
        this.tvAdvice.setVisibility(8);
    }

    private void showBlockDialog(String title, String description, String positive, String negative, final boolean isReactivate) {
        BaseUtils.showBlockDialog(this, 2, title, description, positive, negative, new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity.1
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                if (isReactivate) {
                    DetailTransportCardActivity.this.setupReactivateCard();
                }
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity$3, reason: invalid class name */
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
    public void setupReactivateCard() {
        this.viewModel.activateCard(this, this.model.getCardNumber()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupReactivateCard$2((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupReactivateCard$2(Resource resource) {
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showBlockDialog(getString(R.string.label_error_reactivate_card), resource.message, getString(R.string.label_retry), getString(R.string.label_retry_later), true);
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            reactivateCard();
        }
    }

    private void reactivateCard() {
        this.isRTM = false;
        Intent intent = new Intent(this, (Class<?>) RtmCardActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TYPE_RTM, 3);
        intent.putExtra(Constants.IntentData.INTENT_READ_CARD, true);
        startActivityForResult(intent, 1);
    }

    private void showBlockDialog(String title, String description) {
        BaseUtils.showBlockInfoDialog(this, 2, title, description, getString(R.string.label_finish_recharge_button), new BaseUtils.onInfoBlockDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity.2
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onInfoBlockDialogListener
            public void onClickPositive() {
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onInfoBlockDialogListener
            public void onDismiss() {
            }
        });
    }

    private void setupBono10(TransportCardModel model) {
        this.ctaTenImpersonalPass.setVisibility(0);
        if (model.getZones().intValue() > 0) {
            changeToGreenButton(this.mbNumTicketsZones);
        } else {
            changeToRedButton(this.mbNumTicketsZones);
        }
        this.mbNumTicketsZones.setText(String.valueOf(model.getZones()));
        if (model.getTickets().intValue() > 0) {
            changeToGreenButton(this.mbTripTicket);
        } else {
            changeToRedButton(this.mbTripTicket);
        }
        this.mbTripTicket.setText(String.valueOf(model.getTickets()));
        if (model.getValidityDate() != null) {
            this.mbValidTicketUntil.setText(DateUtils.getDate(model.getValidityDate()));
            if (DateUtils.beforeNow(model.getValidityDate())) {
                changeToRedButton(this.mbValidTicketUntil);
                if (model.getBanlanceRecoveryData() != null && model.getTickets() != null) {
                    this.tvTripsInfo.setText(getString(R.string.recharge_card_until_for_recover, new Object[]{DateUtils.getDate(model.getBanlanceRecoveryData()), String.valueOf(model.getTickets())}));
                }
                this.tvExpired.setVisibility(0);
            } else {
                this.tvExpired.setVisibility(8);
                this.tvTripsInfo.setText((CharSequence) null);
            }
        } else {
            this.mbValidTicketUntil.setText(getString(R.string.label_not_used));
            this.tvExpired.setVisibility(8);
        }
        showDetails(true);
        showOptionDetails(false);
    }

    private void changeToGreenButton(MaterialButton button) {
        button.setBackgroundColor(getResources().getColor(R.color.green_toogle_button));
        button.setTextColor(getResources().getColor(R.color.text_color));
    }

    private void setupAbonoCTA(TransportCardModel model) {
        this.ctaPass.setVisibility(0);
        int iIntValue = model.getZones().intValue();
        this.mbNumZones.setText(String.valueOf(iIntValue));
        if (iIntValue > 0) {
            changeToGreenButton(this.mbNumZones);
        } else {
            changeToRedButton(this.mbNumZones);
        }
        if (model.getValidityDate() != null) {
            this.mbValidUntil.setText(DateUtils.getDate(model.getValidityDate()));
        } else {
            this.mbValidUntil.setText(getString(R.string.label_not_used));
        }
        if (DateUtils.beforeNow(model.getValidityDate())) {
            changeToRedButton(this.mbValidUntil);
            this.tvExpiredInfo.setVisibility(0);
        } else {
            changeToGreenButton(this.mbValidUntil);
            this.tvExpiredInfo.setVisibility(8);
        }
        if (model.getExtensionBit().booleanValue()) {
            this.tvExtendedInfo.setVisibility(0);
        } else {
            this.tvExtendedInfo.setVisibility(8);
        }
        showDetails(true);
        showOptionDetails(true);
    }

    private void setupBonoCTA(TransportCardModel model) {
        this.ctaImpersonalPass.setVisibility(0);
        Double currentAmount = model.getCurrentAmount();
        this.mbBalance.setText(getString(R.string.label_price_euros, new Object[]{Double.valueOf(Utils.INSTANCE.getEuros(currentAmount))}));
        if (currentAmount.doubleValue() > 0.0d) {
            changeToGreenButton(this.mbBalance);
        } else {
            changeToRedButton(this.mbBalance);
        }
        showDetails(true);
        showOptionDetails(false);
    }

    private void setupBilleteUnico(TransportCardModel model) {
        String str;
        this.ctaSinglePass.setVisibility(0);
        Double currentAmount = model.getCurrentAmount();
        this.mbPocket.setText(getString(R.string.label_price_euros, new Object[]{Double.valueOf(Utils.INSTANCE.getEuros(currentAmount))}));
        if (currentAmount.doubleValue() > 0.0d) {
            changeToGreenButton(this.mbPocket);
        } else {
            changeToRedButton(this.mbPocket);
        }
        StringBuilder sb = new StringBuilder();
        Integer flatFeeZonesNumber = 0;
        if (model.getFlatFeeZonesNumber() != null && model.getFlatFeeZonesNumber().intValue() > 0) {
            flatFeeZonesNumber = model.getFlatFeeZonesNumber();
            if (flatFeeZonesNumber.intValue() > 1) {
                str = PLURAL;
            } else {
                str = "";
            }
            sb.append(getString(R.string.label_flat_free_zones_number, new Object[]{flatFeeZonesNumber, str}));
            sb.append(BLANK);
        }
        if (model.getFlatFeeZonesAmount() != null && model.getFlatFeeZonesAmount().doubleValue() > 0.0d) {
            Double flatFeeZonesAmount = model.getFlatFeeZonesAmount();
            flatFeeZonesNumber.intValue();
            sb.append(getString(R.string.label_flat_free_zones_amount, new Object[]{Double.valueOf(Utils.INSTANCE.getEuros(flatFeeZonesAmount))}));
        }
        if (sb.length() > 0) {
            this.tvSpendInfo.setText(sb.toString());
        } else {
            this.tvSpendInfo.setVisibility(8);
        }
        showDetails(true);
        showOptionDetails(true);
    }

    private void setTitleToolbar(String title, String cardNumber) {
        this.subtitle = cardNumber;
        CardResponseModel cardResponseModel = this.cardModel;
        if (cardResponseModel != null && cardResponseModel.getAlias() != null) {
            this.subtitle = this.cardModel.getAlias();
        }
        setToolbarTitle(title, this.subtitle);
    }

    private void changeToRedButton(MaterialButton button) {
        button.setBackgroundColor(getResources().getColor(R.color.text_color_red));
        button.setTextColor(getResources().getColor(R.color.white));
    }

    @OnClick({R.id.mbRechargeCtaPass, R.id.mbRechargeCtaImpersonalPass, R.id.mbRechargeSinglePass, R.id.mbRechargeImpersonalPass})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mbRechargeCtaImpersonalPass /* 2131362394 */:
            case R.id.mbRechargeSinglePass /* 2131362397 */:
                Intent intent = new Intent(this, (Class<?>) RechargeBalanceCardActivity.class);
                intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.model);
                intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_SUBTITLE, this.subtitle);
                startActivityForResult(intent, 0);
                break;
            case R.id.mbRechargeCtaPass /* 2131362395 */:
            case R.id.mbRechargeImpersonalPass /* 2131362396 */:
                Intent intent2 = new Intent(this, (Class<?>) RechargeZonesActivity.class);
                intent2.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.model);
                intent2.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_SUBTITLE, this.subtitle);
                startActivityForResult(intent2, 0);
                break;
        }
    }

    public TransportCardModel getCardDetailModel() {
        return this.model;
    }
}
