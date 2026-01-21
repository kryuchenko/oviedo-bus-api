package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class RechargeByZoneFragment_ViewBinding implements Unbinder {
    private RechargeByZoneFragment target;
    private View view7f0a008f;

    public RechargeByZoneFragment_ViewBinding(final RechargeByZoneFragment target, View source) {
        this.target = target;
        target.rvZones = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvZones, "field 'rvZones'", RecyclerView.class);
        target.tvWarningZones = (TextView) Utils.findRequiredViewAsType(source, R.id.tvWarningZones, "field 'tvWarningZones'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.btNext, "field 'btNext' and method 'onClickView'");
        target.btNext = (Button) Utils.castView(viewFindRequiredView, R.id.btNext, "field 'btNext'", Button.class);
        this.view7f0a008f = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones.RechargeByZoneFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickView();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RechargeByZoneFragment rechargeByZoneFragment = this.target;
        if (rechargeByZoneFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        rechargeByZoneFragment.rvZones = null;
        rechargeByZoneFragment.tvWarningZones = null;
        rechargeByZoneFragment.btNext = null;
        this.view7f0a008f.setOnClickListener(null);
        this.view7f0a008f = null;
    }
}
