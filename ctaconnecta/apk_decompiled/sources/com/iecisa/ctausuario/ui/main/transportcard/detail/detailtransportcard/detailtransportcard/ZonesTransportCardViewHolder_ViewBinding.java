package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.detailtransportcard;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class ZonesTransportCardViewHolder_ViewBinding implements Unbinder {
    private ZonesTransportCardViewHolder target;

    public ZonesTransportCardViewHolder_ViewBinding(ZonesTransportCardViewHolder target, View source) {
        this.target = target;
        target.tvZones = (TextView) Utils.findRequiredViewAsType(source, R.id.tvZones, "field 'tvZones'", TextView.class);
        target.tvTravels = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTravels, "field 'tvTravels'", TextView.class);
        target.tvActualPrice = (TextView) Utils.findRequiredViewAsType(source, R.id.tvActualPrice, "field 'tvActualPrice'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ZonesTransportCardViewHolder zonesTransportCardViewHolder = this.target;
        if (zonesTransportCardViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        zonesTransportCardViewHolder.tvZones = null;
        zonesTransportCardViewHolder.tvTravels = null;
        zonesTransportCardViewHolder.tvActualPrice = null;
    }
}
