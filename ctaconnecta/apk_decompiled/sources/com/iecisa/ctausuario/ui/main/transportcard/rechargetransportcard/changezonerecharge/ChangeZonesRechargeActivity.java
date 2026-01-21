package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
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
import com.google.android.material.textfield.TextInputLayout;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.RechargeZones;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones.RechargeByZoneFragment;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.NumberTripsAdapter;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ChangeZonesRechargeActivity extends CustomToolbarActivity {
    public static final int FRAGMENT_CALCULATE_ZONES = 1;
    public static final int FRAGMENT_RECHARGE_BY_ZONE = 0;
    private boolean haveZones;
    private TransportCardModel model;
    private ArrayList<Integer> numTravels;
    private ArrayList<RechargeZones> rechargeZonesList;

    @BindView(R.id.sNumberTickets)
    AutoCompleteTextView sNumberTickets;
    private Integer selectedTrip;

    @BindView(R.id.tilNumberTickets)
    TextInputLayout tilNumberTickets;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private NumberTripsAdapter travelsAdapter;

    @BindView(R.id.tvInfoTransportCardAction)
    TextView tvInfoTransportCardAction;

    @BindView(R.id.tvRechargeTransportCardAction)
    TextView tvRechargeTransportCardAction;

    @BindViews({R.id.tvInfoTransportCardAction, R.id.tvRechargeTransportCardAction})
    List<TextView> tvTransportCardAction;
    private ChangeZonesRechargeViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;
    private int zones;
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final Fragment rechargeByZoneFragment = new RechargeByZoneFragment();
    private final Fragment calculateZoneFragment = new CalculateZoneFragment();

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_change_zones_recharge;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (ChangeZonesRechargeViewModel) new ViewModelProvider(this, this.viewModelFactory).get(ChangeZonesRechargeViewModelImpl.class);
        setFragment(this.rechargeByZoneFragment);
        this.tvTransportCardAction.get(0).setSelected(true);
        this.tvTransportCardAction.get(1).setSelected(false);
        this.tvInfoTransportCardAction.setText(getString(R.string.title_toolbar_choose_zone));
        this.tvRechargeTransportCardAction.setText(getString(R.string.title_toolbar_calculate_zone));
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_recharge_transport_card));
        setupIntent();
        setupListeners();
    }

    private void setupListeners() {
        this.sNumberTickets.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeActivity$$ExternalSyntheticLambda0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$setupListeners$0(adapterView, view, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$0(AdapterView adapterView, View view, int i, long j) {
        NumberTripsAdapter numberTripsAdapter = this.travelsAdapter;
        if (numberTripsAdapter != null) {
            Integer item = numberTripsAdapter.getItem(i);
            this.selectedTrip = item;
            if (item.intValue() == 1) {
                this.sNumberTickets.setText(getString(R.string.buy_trip));
            } else {
                this.sNumberTickets.setText(getString(R.string.buy_trips, new Object[]{this.selectedTrip}));
            }
            BaseUtils.setupAdapter(this.travelsAdapter, this.sNumberTickets);
            getTenPassRates(this.selectedTrip);
        }
    }

    private void setupIntent() {
        if (getIntent().getExtras() == null || !(getIntent().getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER) instanceof TransportCardModel)) {
            return;
        }
        this.model = (TransportCardModel) getIntent().getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER);
        this.numTravels = getIntent().getIntegerArrayListExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TRIPS);
        this.selectedTrip = Integer.valueOf(getIntent().getIntExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TRIP, 0));
        this.haveZones = getIntent().getBooleanExtra(Constants.IntentData.INTENT_TYPE_RECHARGE_ZONES_INIT, true);
        this.zones = getIntent().getIntExtra(Constants.IntentData.INTENT_TYPE_RECHARGE_ZONES_INITIAL, 0);
        this.rechargeZonesList = getIntent().getParcelableArrayListExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_LIST_ZONES);
        setupView();
        ArrayList<Integer> arrayList = this.numTravels;
        if (arrayList != null) {
            setupAdapterNumTravels(arrayList);
        }
    }

    private void setupView() {
        if (this.model.getCardTypeId().equals(Constants.Cards.TRANSPORT_CARD_ABONO_CTA)) {
            this.tilNumberTickets.setVisibility(8);
        }
    }

    @OnClick({R.id.tvInfoTransportCardAction, R.id.tvRechargeTransportCardAction})
    public void onClickEvents(View view) {
        int id = view.getId();
        if (id == R.id.tvInfoTransportCardAction) {
            setFragment(this.rechargeByZoneFragment);
            this.tvTransportCardAction.get(0).setSelected(true);
            this.tvTransportCardAction.get(1).setSelected(false);
        } else {
            if (id != R.id.tvRechargeTransportCardAction) {
                return;
            }
            setFragment(this.calculateZoneFragment);
            this.tvTransportCardAction.get(0).setSelected(false);
            this.tvTransportCardAction.get(1).setSelected(true);
        }
    }

    private void setFragment(Fragment selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = this.fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, selectedFragment);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }

    public void getZones(RechargeZones rechargeZones) {
        Intent intent = new Intent();
        intent.putExtra(Constants.IntentData.INTENT_TYPE_RECHARGE_ZONES, rechargeZones);
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TRIP, this.selectedTrip);
        setResult(-1, intent);
        finish();
    }

    private void setupAdapterNumTravels(List<Integer> numTravels) {
        NumberTripsAdapter numberTripsAdapter = new NumberTripsAdapter(this, numTravels);
        this.travelsAdapter = numberTripsAdapter;
        numberTripsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.sNumberTickets.setAdapter(this.travelsAdapter);
        if (this.selectedTrip.intValue() == 1) {
            this.sNumberTickets.setText(getString(R.string.buy_trip));
        } else {
            this.sNumberTickets.setText(getString(R.string.buy_trips, new Object[]{this.selectedTrip}));
        }
        BaseUtils.setupAdapter(this.travelsAdapter, this.sNumberTickets);
    }

    private void getTenPassRates(Integer numTrips) {
        this.viewModel.getTenPassRates(this, this.model.getCardNumber(), numTrips).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.onGetRatesResponse((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeActivity$1, reason: invalid class name */
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
    public void onGetRatesResponse(Resource<List<RechargeZones>> response) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[response.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(this, response.message);
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
        if (response.data == null || response.data.size() <= 0) {
            return;
        }
        this.rechargeZonesList = new ArrayList<>(response.data);
        ((CalculateZoneFragment) this.calculateZoneFragment).calculateZone();
        ((RechargeByZoneFragment) this.rechargeByZoneFragment).reloadView();
    }

    public void hideKey() {
        hideKeyboard();
    }

    public TransportCardModel getCardDetailModel() {
        return this.model;
    }

    public ArrayList<RechargeZones> getRechargeZones() {
        return this.rechargeZonesList;
    }

    public boolean isHaveZones() {
        return this.haveZones;
    }

    public Integer getSelectedTrip() {
        if (this.selectedTrip.intValue() > 0) {
            return this.selectedTrip;
        }
        return null;
    }

    public Integer getTypePass() {
        if (this.selectedTrip.intValue() > 0) {
            return Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10;
        }
        return Constants.Cards.TRANSPORT_CARD_ABONO_CTA;
    }

    public int getZones() {
        return this.zones;
    }
}
