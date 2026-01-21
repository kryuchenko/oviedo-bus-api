package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class RechargeByZoneViewHolder_ViewBinding implements Unbinder {
    private RechargeByZoneViewHolder target;
    private View view7f0a044d;

    public RechargeByZoneViewHolder_ViewBinding(final RechargeByZoneViewHolder target, View source) {
        this.target = target;
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.tvLabelZones, "field 'tvLabelZones' and method 'onViewClicked'");
        target.tvLabelZones = (TextView) Utils.castView(viewFindRequiredView, R.id.tvLabelZones, "field 'tvLabelZones'", TextView.class);
        this.view7f0a044d = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones.RechargeByZoneViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked();
            }
        });
        target.tvZones = (TextView) Utils.findRequiredViewAsType(source, R.id.tvZones, "field 'tvZones'", TextView.class);
        target.tvPrice = (TextView) Utils.findRequiredViewAsType(source, R.id.tvPrice, "field 'tvPrice'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RechargeByZoneViewHolder rechargeByZoneViewHolder = this.target;
        if (rechargeByZoneViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        rechargeByZoneViewHolder.tvLabelZones = null;
        rechargeByZoneViewHolder.tvZones = null;
        rechargeByZoneViewHolder.tvPrice = null;
        this.view7f0a044d.setOnClickListener(null);
        this.view7f0a044d = null;
    }
}
