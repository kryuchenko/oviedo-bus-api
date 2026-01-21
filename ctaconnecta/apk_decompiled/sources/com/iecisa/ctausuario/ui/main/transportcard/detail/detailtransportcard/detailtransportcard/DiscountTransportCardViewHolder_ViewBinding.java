package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.detailtransportcard;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class DiscountTransportCardViewHolder_ViewBinding implements Unbinder {
    private DiscountTransportCardViewHolder target;

    public DiscountTransportCardViewHolder_ViewBinding(DiscountTransportCardViewHolder target, View source) {
        this.target = target;
        target.tvProfile = (TextView) Utils.findRequiredViewAsType(source, R.id.tvProfile, "field 'tvProfile'", TextView.class);
        target.tvDiscount = (TextView) Utils.findRequiredViewAsType(source, R.id.tvDiscount, "field 'tvDiscount'", TextView.class);
        target.tvValidUntil = (TextView) Utils.findRequiredViewAsType(source, R.id.tvValidUntil, "field 'tvValidUntil'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DiscountTransportCardViewHolder discountTransportCardViewHolder = this.target;
        if (discountTransportCardViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        discountTransportCardViewHolder.tvProfile = null;
        discountTransportCardViewHolder.tvDiscount = null;
        discountTransportCardViewHolder.tvValidUntil = null;
    }
}
