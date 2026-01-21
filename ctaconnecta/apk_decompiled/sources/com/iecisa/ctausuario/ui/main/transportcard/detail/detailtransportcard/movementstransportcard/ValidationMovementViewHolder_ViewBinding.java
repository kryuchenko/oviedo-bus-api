package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.movementstransportcard;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class ValidationMovementViewHolder_ViewBinding implements Unbinder {
    private ValidationMovementViewHolder target;

    public ValidationMovementViewHolder_ViewBinding(ValidationMovementViewHolder target, View source) {
        this.target = target;
        target.tvTitle = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'tvTitle'", TextView.class);
        target.tvPrice = (TextView) Utils.findRequiredViewAsType(source, R.id.tvPrice, "field 'tvPrice'", TextView.class);
        target.tvStartRoute = (TextView) Utils.findRequiredViewAsType(source, R.id.tvStartRoute, "field 'tvStartRoute'", TextView.class);
        target.tvBalance = (TextView) Utils.findRequiredViewAsType(source, R.id.tvBalance, "field 'tvBalance'", TextView.class);
        target.tvItinerary = (TextView) Utils.findRequiredViewAsType(source, R.id.tvItinerary, "field 'tvItinerary'", TextView.class);
        target.tvDate = (TextView) Utils.findRequiredViewAsType(source, R.id.tvDate, "field 'tvDate'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ValidationMovementViewHolder validationMovementViewHolder = this.target;
        if (validationMovementViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        validationMovementViewHolder.tvTitle = null;
        validationMovementViewHolder.tvPrice = null;
        validationMovementViewHolder.tvStartRoute = null;
        validationMovementViewHolder.tvBalance = null;
        validationMovementViewHolder.tvItinerary = null;
        validationMovementViewHolder.tvDate = null;
    }
}
