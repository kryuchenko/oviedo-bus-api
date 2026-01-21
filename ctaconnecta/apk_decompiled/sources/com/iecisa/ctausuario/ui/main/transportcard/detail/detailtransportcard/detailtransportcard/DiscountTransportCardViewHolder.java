package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.detailtransportcard;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.transportcarddetail.DiscountProfileModel;
import com.iecisa.ctausuario.utils.DateUtils;

/* loaded from: classes5.dex */
class DiscountTransportCardViewHolder extends RecyclerView.ViewHolder {
    private Context context;

    @BindView(R.id.tvDiscount)
    TextView tvDiscount;

    @BindView(R.id.tvProfile)
    TextView tvProfile;

    @BindView(R.id.tvValidUntil)
    TextView tvValidUntil;

    public DiscountTransportCardViewHolder(Context context, View itemView) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
    }

    public void bindView(DiscountProfileModel discountProfileModel) {
        this.tvProfile.setText(discountProfileModel.getProfileName());
        if (discountProfileModel.getPercentDiscount() != null) {
            this.tvDiscount.setText(this.context.getString(R.string.label_percentage, discountProfileModel.getPercentDiscount()));
        }
        this.tvValidUntil.setText(DateUtils.getDate(discountProfileModel.getValidityDate()));
    }
}
