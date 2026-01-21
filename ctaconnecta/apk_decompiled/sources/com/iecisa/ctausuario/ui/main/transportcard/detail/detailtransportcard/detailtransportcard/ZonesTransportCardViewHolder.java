package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.detailtransportcard;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.transportcarddetail.ZonesAmountModel;
import com.iecisa.ctausuario.utils.Utils;

/* loaded from: classes5.dex */
class ZonesTransportCardViewHolder extends RecyclerView.ViewHolder {
    private Context context;

    @BindView(R.id.tvActualPrice)
    TextView tvActualPrice;

    @BindView(R.id.tvTravels)
    TextView tvTravels;

    @BindView(R.id.tvZones)
    TextView tvZones;

    public ZonesTransportCardViewHolder(Context context, View itemView) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
    }

    public void bindView(ZonesAmountModel pricesZonesModel) throws Resources.NotFoundException {
        if (pricesZonesModel.getAmount().equals(Double.valueOf(0.0d))) {
            int color = this.context.getResources().getColor(R.color.green_toogle_button);
            this.tvZones.setBackgroundColor(color);
            this.tvTravels.setBackgroundColor(color);
            this.tvActualPrice.setBackgroundColor(color);
        }
        this.tvZones.setText(String.valueOf(pricesZonesModel.getZone()));
        this.tvTravels.setText(String.valueOf(pricesZonesModel.getTravelsNum()));
        this.tvActualPrice.setText(this.context.getString(R.string.label_price_euros, Double.valueOf(Utils.INSTANCE.getEuros(pricesZonesModel.getAmount()))));
    }
}
