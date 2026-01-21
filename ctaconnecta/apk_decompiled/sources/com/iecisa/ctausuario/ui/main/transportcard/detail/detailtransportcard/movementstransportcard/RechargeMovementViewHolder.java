package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.movementstransportcard;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.transportcarddetail.MovementsHistoryModel;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.DateUtils;
import com.iecisa.ctausuario.utils.Utils;

/* loaded from: classes5.dex */
public class RechargeMovementViewHolder extends MovementsTransportCardViewHolder {
    private Integer cardTypeId;
    private Context context;

    @BindView(R.id.tvBalance)
    TextView tvBalance;

    @BindView(R.id.tvDate)
    TextView tvDate;

    @BindView(R.id.tvPrice)
    TextView tvPrice;

    @BindView(R.id.tvRecharge)
    TextView tvRecharge;

    @BindView(R.id.tvRechargeTrips)
    TextView tvRechargeTrips;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    public RechargeMovementViewHolder(View itemView, Context context, Integer cardTypeId) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
        this.cardTypeId = cardTypeId;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.movementstransportcard.MovementsTransportCardViewHolder
    public void bindView(MovementsHistoryModel model) {
        if (model == null || model.getRechargeHistoryModel() == null) {
            return;
        }
        this.tvTitle.setText(model.getRechargeHistoryModel().getCompany());
        this.tvPrice.setText(this.context.getString(R.string.label_price_euros, Double.valueOf(Utils.INSTANCE.getEuros(model.getRechargeHistoryModel().getRechargeAmount()))));
        this.tvRechargeTrips.setVisibility(8);
        if (this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_CTA) || this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_TYPE_BILLETE_UNICO)) {
            if (model.getRechargeHistoryModel().getBalanceAmount() != null) {
                this.tvBalance.setText(this.context.getString(R.string.label_price_euros, Double.valueOf(Utils.INSTANCE.getEuros(model.getRechargeHistoryModel().getBalanceAmount()))));
            }
        } else if (this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10)) {
            Double balanceAmount = model.getRechargeHistoryModel().getBalanceAmount();
            if (balanceAmount.doubleValue() == 1.0d) {
                this.tvBalance.setText(this.context.getString(R.string.label_number_trip, balanceAmount));
            } else {
                this.tvBalance.setText(this.context.getString(R.string.label_number_trips, balanceAmount));
            }
            this.tvRechargeTrips.setText(this.context.getString(R.string.label_recharge_zones_card, model.getRechargeHistoryModel().getTrips(), model.getRechargeHistoryModel().getAreas()));
            this.tvRechargeTrips.setVisibility(0);
        } else if (this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_ABONO_CTA)) {
            this.tvRechargeTrips.setText(this.context.getString(R.string.label_recharge_zones_card_pass, model.getRechargeHistoryModel().getAreas()));
            this.tvRechargeTrips.setVisibility(0);
        }
        this.tvRecharge.setText(model.getRechargeHistoryModel().getRechargeMethod());
        this.tvDate.setText(DateUtils.getDateTime(model.getHistoricDate()));
    }
}
