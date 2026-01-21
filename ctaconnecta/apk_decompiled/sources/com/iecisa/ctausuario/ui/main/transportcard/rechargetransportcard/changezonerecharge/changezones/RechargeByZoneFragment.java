package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones;

import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.ui.BaseFragment;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.RechargeZones;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones.RechargeByZoneViewHolder;
import com.iecisa.ctausuario.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class RechargeByZoneFragment extends BaseFragment {

    @BindView(R.id.btNext)
    Button btNext;
    private TransportCardModel cardDetailModel;
    private boolean haveZones;
    private RechargeByZoneAdapter rechargeByZoneAdapter;
    private RechargeZones rechargeZones;

    @BindView(R.id.rvZones)
    RecyclerView rvZones;

    @BindView(R.id.tvWarningZones)
    TextView tvWarningZones;
    private RechargeByZoneViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;
    private Integer zones;

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_recharge_by_zone;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
        this.viewModel = (RechargeByZoneViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(RechargeByZoneViewModelImpl.class);
        this.tvWarningZones.setVisibility(8);
        if (getActivity() != null) {
            this.cardDetailModel = ((ChangeZonesRechargeActivity) getActivity()).getCardDetailModel();
            this.zones = Integer.valueOf(((ChangeZonesRechargeActivity) getActivity()).getZones());
            this.haveZones = ((ChangeZonesRechargeActivity) getActivity()).isHaveZones();
            ArrayList<RechargeZones> rechargeZones = ((ChangeZonesRechargeActivity) getActivity()).getRechargeZones();
            if (rechargeZones == null || rechargeZones.size() <= 0) {
                return;
            }
            setupAdapter(rechargeZones);
        }
    }

    private void setupAdapter(List<RechargeZones> data) {
        this.rvZones.setLayoutManager(new LinearLayoutManager(getContext()));
        RechargeByZoneAdapter rechargeByZoneAdapter = new RechargeByZoneAdapter(data, new RechargeByZoneViewHolder.OnZoneListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones.RechargeByZoneFragment$$ExternalSyntheticLambda0
            @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones.RechargeByZoneViewHolder.OnZoneListener
            public final void onClickListener(RechargeZones rechargeZones) {
                this.f$0.changeZone(rechargeZones);
            }
        });
        this.rechargeByZoneAdapter = rechargeByZoneAdapter;
        this.rvZones.setAdapter(rechargeByZoneAdapter);
        changeZone(this.rechargeByZoneAdapter.selectZone(this.cardDetailModel.getZones()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeZone(RechargeZones rechargeZones) {
        String string;
        String string2;
        this.rechargeByZoneAdapter.selectZone(Integer.valueOf(rechargeZones.getZone()));
        this.rechargeZones = rechargeZones;
        this.btNext.setEnabled(true);
        if (this.zones.intValue() > rechargeZones.getZone() && this.haveZones) {
            if (((ChangeZonesRechargeActivity) getActivity()).getTypePass().equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10)) {
                string2 = getString(R.string.warning_decreased_number_zones_trips);
            } else {
                string2 = getString(R.string.warning_decreased_number_zones);
            }
            this.tvWarningZones.setText(string2);
            this.tvWarningZones.setVisibility(0);
            return;
        }
        if (!this.zones.equals(0) && this.zones.intValue() < rechargeZones.getZone() && this.haveZones) {
            if (((ChangeZonesRechargeActivity) getActivity()).getTypePass().equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10)) {
                string = getString(R.string.warning_increased_number_zones_trips);
            } else {
                string = getString(R.string.warning_increased_number_zones);
            }
            this.tvWarningZones.setText(string);
            this.tvWarningZones.setVisibility(0);
            return;
        }
        this.tvWarningZones.setVisibility(8);
    }

    @OnClick({R.id.btNext})
    public void onClickView() {
        ((ChangeZonesRechargeActivity) getActivity()).getZones(this.rechargeZones);
    }

    public void reloadView() {
        if (getActivity() != null) {
            this.btNext.setEnabled(false);
            this.rechargeByZoneAdapter.reloadData(((ChangeZonesRechargeActivity) getActivity()).getRechargeZones());
            if (this.rechargeZones == null) {
                this.rechargeZones = this.rechargeByZoneAdapter.selectZone(this.cardDetailModel.getZones());
            }
            RechargeZones rechargeZones = this.rechargeZones;
            if (rechargeZones != null) {
                changeZone(rechargeZones);
            }
        }
    }
}
