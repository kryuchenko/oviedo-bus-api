package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.detailtransportcard;

import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.cexmobility.core.ui.BaseFragment;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.transportcarddetail.DiscountProfileModel;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import com.iecisa.ctausuario.model.transportcarddetail.ZonesAmountModel;
import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity;
import com.iecisa.ctausuario.utils.Constants;
import java.util.List;

/* loaded from: classes5.dex */
public class InfoTransportCardFragment extends BaseFragment {

    @BindView(R.id.gpDiscount)
    Group gpDiscount;

    @BindView(R.id.gpZones)
    Group gpZones;

    @BindView(R.id.rvDiscount)
    RecyclerView rvDiscount;

    @BindView(R.id.rvZones)
    RecyclerView rvZones;

    @BindView(R.id.tvLabelCardOwner)
    TextView tvLabelCardOwner;

    @BindView(R.id.tvLabelSpendInfo)
    TextView tvLabelSpendInfo;

    @BindView(R.id.tvSpendInfo)
    TextView tvSpendInfo;

    @BindView(R.id.tvUserName)
    TextView tvUserName;

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_detail_transport_card;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return false;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
        if (getActivity() instanceof DetailTransportCardActivity) {
            TransportCardModel cardDetailModel = ((DetailTransportCardActivity) getActivity()).getCardDetailModel();
            if (cardDetailModel != null) {
                setupView(cardDetailModel);
                if (cardDetailModel.getDiscountProfileModels() != null && cardDetailModel.getDiscountProfileModels().size() > 0) {
                    setupAdapterDiscount(cardDetailModel.getDiscountProfileModels());
                } else {
                    this.gpDiscount.setVisibility(8);
                }
                if (cardDetailModel.getZonesAmountModel() != null && cardDetailModel.getZonesAmountModel().size() > 0) {
                    setupAdapterZones(cardDetailModel.getZonesAmountModel());
                    return;
                } else {
                    this.gpZones.setVisibility(8);
                    return;
                }
            }
            this.gpDiscount.setVisibility(8);
            this.gpZones.setVisibility(8);
        }
    }

    private void setupAdapterDiscount(List<DiscountProfileModel> discountProfileModels) {
        this.rvDiscount.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvDiscount.setAdapter(new DiscountTransportCardAdapter(discountProfileModels));
    }

    private void setupAdapterZones(List<ZonesAmountModel> zonesAmountModel) {
        this.rvZones.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvZones.setAdapter(new ZonesTransportCardAdapter(zonesAmountModel));
    }

    private void setupView(TransportCardModel cardDetailModel) {
        this.tvUserName.setText(cardDetailModel.getCardHolderName());
        if (cardDetailModel.getCurrentMonthAmount() != null) {
            this.tvSpendInfo.setText(getString(R.string.label_price_euros, Double.valueOf(cardDetailModel.getCurrentMonthAmount().doubleValue() / 100.0d)));
        }
        if (cardDetailModel.getCardTypeId().equals(Constants.Cards.TRANSPORT_CARD_ABONO_CTA)) {
            this.tvLabelSpendInfo.setVisibility(8);
        }
    }
}
