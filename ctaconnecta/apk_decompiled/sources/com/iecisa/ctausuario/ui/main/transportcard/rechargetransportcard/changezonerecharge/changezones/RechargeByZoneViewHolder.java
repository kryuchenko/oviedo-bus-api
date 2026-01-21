package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.RechargeZones;
import com.iecisa.ctausuario.utils.Utils;

/* loaded from: classes5.dex */
public class RechargeByZoneViewHolder extends RecyclerView.ViewHolder {
    private Context context;
    private OnZoneListener listener;
    private RechargeZones rechargeZones;

    @BindView(R.id.tvLabelZones)
    TextView tvLabelZones;

    @BindView(R.id.tvPrice)
    TextView tvPrice;

    @BindView(R.id.tvZones)
    TextView tvZones;

    public interface OnZoneListener {
        void onClickListener(RechargeZones rechargeZones);
    }

    public RechargeByZoneViewHolder(Context context, View itemView, OnZoneListener listener) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
        this.listener = listener;
    }

    @OnClick({R.id.tvLabelZones})
    public void onViewClicked() {
        this.listener.onClickListener(this.rechargeZones);
    }

    public void bindView(RechargeZones rechargeZones) {
        this.rechargeZones = rechargeZones;
        if (rechargeZones.isSelected()) {
            selectRow();
        } else {
            unselectRow();
        }
        if (rechargeZones.getZone() == 1) {
            this.tvZones.setText(this.context.getString(R.string.label_recharge_zone));
        } else {
            this.tvZones.setText(this.context.getString(R.string.label_recharge_zones, Integer.valueOf(rechargeZones.getZone())));
        }
        this.tvPrice.setText(this.context.getString(R.string.label_price_euros, Double.valueOf(Utils.INSTANCE.getEuros(rechargeZones.getRate()))));
    }

    private void unselectRow() {
        this.tvLabelZones.setBackgroundResource(R.drawable.zones_selector_blue);
        this.tvZones.setTextColor(this.context.getResources().getColor(R.color.white));
        this.tvPrice.setTextColor(this.context.getResources().getColor(R.color.white));
    }

    private void selectRow() {
        this.tvLabelZones.setBackgroundResource(R.drawable.zones_selector_green);
        this.tvZones.setTextColor(this.context.getResources().getColor(R.color.text_color));
        this.tvPrice.setTextColor(this.context.getResources().getColor(R.color.text_color));
    }
}
