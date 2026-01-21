package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.movementstransportcard;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class RechargeMovementViewHolder_ViewBinding implements Unbinder {
    private RechargeMovementViewHolder target;

    public RechargeMovementViewHolder_ViewBinding(RechargeMovementViewHolder target, View source) {
        this.target = target;
        target.tvTitle = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'tvTitle'", TextView.class);
        target.tvPrice = (TextView) Utils.findRequiredViewAsType(source, R.id.tvPrice, "field 'tvPrice'", TextView.class);
        target.tvBalance = (TextView) Utils.findRequiredViewAsType(source, R.id.tvBalance, "field 'tvBalance'", TextView.class);
        target.tvRechargeTrips = (TextView) Utils.findRequiredViewAsType(source, R.id.tvRechargeTrips, "field 'tvRechargeTrips'", TextView.class);
        target.tvRecharge = (TextView) Utils.findRequiredViewAsType(source, R.id.tvRecharge, "field 'tvRecharge'", TextView.class);
        target.tvDate = (TextView) Utils.findRequiredViewAsType(source, R.id.tvDate, "field 'tvDate'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RechargeMovementViewHolder rechargeMovementViewHolder = this.target;
        if (rechargeMovementViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        rechargeMovementViewHolder.tvTitle = null;
        rechargeMovementViewHolder.tvPrice = null;
        rechargeMovementViewHolder.tvBalance = null;
        rechargeMovementViewHolder.tvRechargeTrips = null;
        rechargeMovementViewHolder.tvRecharge = null;
        rechargeMovementViewHolder.tvDate = null;
    }
}
