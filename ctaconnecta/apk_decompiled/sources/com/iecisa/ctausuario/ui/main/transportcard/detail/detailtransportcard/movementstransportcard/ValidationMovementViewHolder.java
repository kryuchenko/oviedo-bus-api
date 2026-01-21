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
public class ValidationMovementViewHolder extends MovementsTransportCardViewHolder {
    private Integer cardTypeId;
    private Context context;

    @BindView(R.id.tvBalance)
    TextView tvBalance;

    @BindView(R.id.tvDate)
    TextView tvDate;

    @BindView(R.id.tvItinerary)
    TextView tvItinerary;

    @BindView(R.id.tvPrice)
    TextView tvPrice;

    @BindView(R.id.tvStartRoute)
    TextView tvStartRoute;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    public ValidationMovementViewHolder(View itemView, Context context, Integer cardTypeId) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
        this.cardTypeId = cardTypeId;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.movementstransportcard.MovementsTransportCardViewHolder
    public void bindView(MovementsHistoryModel model) {
        String string;
        if (model == null || model.getValidationHistoryModel() == null) {
            return;
        }
        this.tvTitle.setText(model.getValidationHistoryModel().getShortCompanyName());
        if (this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10) || this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_ABONO_CTA)) {
            Double travelUnits = model.getValidationHistoryModel().getTravelUnits();
            if (travelUnits.doubleValue() == 1.0d) {
                this.tvPrice.setText(this.context.getString(R.string.label_number_trip, travelUnits));
            } else {
                this.tvPrice.setText(this.context.getString(R.string.label_number_trips, Double.valueOf(travelUnits == null ? 0.0d : travelUnits.doubleValue())));
            }
            if (this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10)) {
                Double balanceAmount = model.getValidationHistoryModel().getBalanceAmount();
                if (balanceAmount.doubleValue() == 1.0d) {
                    this.tvBalance.setText(this.context.getString(R.string.label_number_trip, balanceAmount));
                } else {
                    this.tvBalance.setText(this.context.getString(R.string.label_number_trips, balanceAmount));
                }
            } else {
                this.tvBalance.setVisibility(8);
            }
        } else {
            this.tvPrice.setText(this.context.getString(R.string.label_price_euros, Double.valueOf(Utils.INSTANCE.getEuros(model.getValidationHistoryModel().getTravelUnits()))));
            if (model.getValidationHistoryModel().getBalanceAmount() != null) {
                this.tvBalance.setText(this.context.getString(R.string.label_price_euros, Double.valueOf(Utils.INSTANCE.getEuros(model.getValidationHistoryModel().getBalanceAmount()))));
            }
        }
        this.tvItinerary.setText(model.getValidationHistoryModel().getItinerary());
        String startStopName = model.getValidationHistoryModel().getStartStopName();
        Integer zonesNumber = model.getValidationHistoryModel().getZonesNumber();
        if (zonesNumber != null && zonesNumber.intValue() > 0) {
            if (zonesNumber.intValue() == 1) {
                string = this.context.getString(R.string.label_recharge_zone);
            } else {
                string = this.context.getString(R.string.label_recharge_zones, zonesNumber);
            }
            TextView textView = this.tvStartRoute;
            if (startStopName != null && startStopName.length() > 0) {
                string = startStopName + ", " + string;
            }
            textView.setText(string);
        }
        this.tvDate.setText(DateUtils.getDateTime(model.getHistoricDate()));
    }
}
