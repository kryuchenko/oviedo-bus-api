package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseFragment;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.MunicipalityResponseModel;
import com.iecisa.ctausuario.model.RechargeZones;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.Utils;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class CalculateZoneFragment extends BaseFragment {

    @BindView(R.id.actvDestination)
    AutoCompleteTextView actvDestination;

    @BindView(R.id.actvOrigin)
    AutoCompleteTextView actvOrigin;
    private MunicipalityAdapter adapterDestiny;
    private MunicipalityAdapter adapterOrigin;

    @BindView(R.id.btCalculate)
    MaterialButton btCalculate;

    @BindView(R.id.btNext)
    MaterialButton btNext;
    private Integer destiny;

    @BindView(R.id.gpCalculate)
    Group gpCalculate;
    private boolean isDestiny;
    private boolean isOrigin;
    private Integer origin;
    private RechargeZones rechargeZones;

    @BindView(R.id.tvOriginDestiny)
    TextView tvOriginDestiny;

    @BindView(R.id.tvPrice)
    TextView tvPrice;

    @BindView(R.id.tvWarningZones)
    TextView tvWarningZones;

    @BindView(R.id.tvZones)
    TextView tvZones;
    private CalculateZonesViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_calculate_zone;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
        this.viewModel = (CalculateZonesViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(CalculateZonesViewModelImpl.class);
        this.gpCalculate.setVisibility(8);
        this.tvWarningZones.setVisibility(8);
        this.btCalculate.setEnabled(false);
        setupView();
        setupAutocomplete();
    }

    private void setupView() {
        this.viewModel.getMunicipality(getContext()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupView$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupView$0(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
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
            setupAdapters((List) resource.data);
        }
    }

    private void setupAutocomplete() {
        this.actvOrigin.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment$$ExternalSyntheticLambda2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$setupAutocomplete$1(adapterView, view, i, j);
            }
        });
        this.actvDestination.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment$$ExternalSyntheticLambda3
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$setupAutocomplete$2(adapterView, view, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupAutocomplete$1(AdapterView adapterView, View view, int i, long j) {
        this.isOrigin = true;
        this.origin = ((MunicipalityResponseModel) this.actvOrigin.getAdapter().getItem(i)).getCode();
        if (getActivity() instanceof ChangeZonesRechargeActivity) {
            ((ChangeZonesRechargeActivity) getActivity()).hideKey();
        }
        if (this.isDestiny) {
            this.btCalculate.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupAutocomplete$2(AdapterView adapterView, View view, int i, long j) {
        this.isDestiny = true;
        this.destiny = ((MunicipalityResponseModel) this.actvDestination.getAdapter().getItem(i)).getCode();
        if (getActivity() instanceof ChangeZonesRechargeActivity) {
            ((ChangeZonesRechargeActivity) getActivity()).hideKey();
        }
        if (this.isOrigin) {
            this.btCalculate.setEnabled(true);
        }
    }

    private void setupAdapters(List<MunicipalityResponseModel> model) {
        this.adapterOrigin = new MunicipalityAdapter(getContext(), model);
        this.adapterDestiny = new MunicipalityAdapter(getContext(), model);
        this.actvOrigin.setThreshold(0);
        this.actvOrigin.setAdapter(this.adapterOrigin);
        this.actvDestination.setThreshold(0);
        this.actvDestination.setAdapter(this.adapterDestiny);
    }

    @OnClick({R.id.btNext, R.id.btCalculate})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id != R.id.btCalculate) {
            if (id == R.id.btNext && this.rechargeZones != null) {
                ((ChangeZonesRechargeActivity) getActivity()).getZones(this.rechargeZones);
                return;
            }
            return;
        }
        calculateZone();
    }

    public void calculateZone() {
        if (this.actvDestination.getText().toString().equals("") || this.actvOrigin.getText().toString().equals("") || !this.isOrigin || !this.isDestiny) {
            return;
        }
        TransportCardModel cardDetailModel = ((ChangeZonesRechargeActivity) getActivity()).getCardDetailModel();
        this.viewModel.getPriceBetweenZones(getContext(), this.origin, this.destiny, ((ChangeZonesRechargeActivity) getActivity()).getSelectedTrip(), cardDetailModel.getCardNumber()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$calculateZone$3((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment$1, reason: invalid class name */
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
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$calculateZone$3(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(getContext(), resource.message);
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
                this.rechargeZones = (RechargeZones) resource.data;
                loadResultZones((RechargeZones) resource.data);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void loadResultZones(RechargeZones data) {
        String string;
        String string2;
        this.tvOriginDestiny.setText(getString(R.string.label_origin_destiny, this.actvOrigin.getText().toString(), this.actvDestination.getText().toString()));
        if (data.getZone() == 1) {
            this.tvZones.setText(getString(R.string.label_recharge_zone));
        } else {
            this.tvZones.setText(getString(R.string.label_recharge_zones, Integer.valueOf(data.getZone())));
        }
        this.tvPrice.setText(getString(R.string.label_price_euros, Double.valueOf(Utils.INSTANCE.getEuros(data.getRate()))));
        int zones = ((ChangeZonesRechargeActivity) getActivity()).getZones();
        Integer numValueOf = Integer.valueOf(zones);
        boolean zIsHaveZones = ((ChangeZonesRechargeActivity) getActivity()).isHaveZones();
        int zone = data.getZone();
        numValueOf.getClass();
        if (zone < zones && zIsHaveZones) {
            if (((ChangeZonesRechargeActivity) getActivity()).getTypePass().equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10)) {
                string2 = getString(R.string.warning_decreased_number_zones_trips);
            } else {
                string2 = getString(R.string.warning_decreased_number_zones);
            }
            this.tvWarningZones.setText(string2);
            this.tvWarningZones.setVisibility(0);
        } else if (!numValueOf.equals(0)) {
            int zone2 = data.getZone();
            numValueOf.getClass();
            if (zone2 > zones && zIsHaveZones) {
                if (((ChangeZonesRechargeActivity) getActivity()).getTypePass().equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10)) {
                    string = getString(R.string.warning_increased_number_zones_trips);
                } else {
                    string = getString(R.string.warning_increased_number_zones);
                }
                this.tvWarningZones.setText(string);
                this.tvWarningZones.setVisibility(0);
            } else {
                this.tvWarningZones.setVisibility(8);
            }
        }
        setCalculate(true);
    }

    @OnTextChanged({R.id.actvOrigin})
    public void onTextChangedOrigin() {
        this.isOrigin = false;
        hideResults();
    }

    @OnTextChanged({R.id.actvDestination})
    public void onTextChangedDestination() {
        this.isDestiny = false;
        hideResults();
    }

    public void hideResults() {
        this.btCalculate.setEnabled(false);
        this.tvWarningZones.setVisibility(8);
        setCalculate(false);
    }

    private void setCalculate(boolean isEnabled) {
        this.btNext.setEnabled(isEnabled);
        this.gpCalculate.setVisibility(isEnabled ? 0 : 8);
    }

    @OnFocusChange({R.id.actvOrigin, R.id.actvDestination})
    public void onFocusChange(View view, boolean hasFocus) {
        switch (view.getId()) {
            case R.id.actvDestination /* 2131361867 */:
                if (!hasFocus) {
                    BaseUtils.setupAdapter(this.adapterDestiny, this.actvDestination);
                }
                this.actvDestination.showDropDown();
                break;
            case R.id.actvOrigin /* 2131361868 */:
                if (!hasFocus) {
                    BaseUtils.setupAdapter(this.adapterOrigin, this.actvOrigin);
                }
                this.actvOrigin.showDropDown();
                break;
        }
    }
}
