package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.textfield.TextInputLayout;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class ChangeZonesRechargeActivity_ViewBinding implements Unbinder {
    private ChangeZonesRechargeActivity target;
    private View view7f0a040c;
    private View view7f0a0470;

    public ChangeZonesRechargeActivity_ViewBinding(ChangeZonesRechargeActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public ChangeZonesRechargeActivity_ViewBinding(final ChangeZonesRechargeActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.tvInfoTransportCardAction, "field 'tvInfoTransportCardAction' and method 'onClickEvents'");
        target.tvInfoTransportCardAction = (TextView) Utils.castView(viewFindRequiredView, R.id.tvInfoTransportCardAction, "field 'tvInfoTransportCardAction'", TextView.class);
        this.view7f0a040c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvRechargeTransportCardAction, "field 'tvRechargeTransportCardAction' and method 'onClickEvents'");
        target.tvRechargeTransportCardAction = (TextView) Utils.castView(viewFindRequiredView2, R.id.tvRechargeTransportCardAction, "field 'tvRechargeTransportCardAction'", TextView.class);
        this.view7f0a0470 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        target.tilNumberTickets = (TextInputLayout) Utils.findRequiredViewAsType(source, R.id.tilNumberTickets, "field 'tilNumberTickets'", TextInputLayout.class);
        target.sNumberTickets = (AutoCompleteTextView) Utils.findRequiredViewAsType(source, R.id.sNumberTickets, "field 'sNumberTickets'", AutoCompleteTextView.class);
        target.tvTransportCardAction = Utils.listFilteringNull((TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoTransportCardAction, "field 'tvTransportCardAction'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.tvRechargeTransportCardAction, "field 'tvTransportCardAction'", TextView.class));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ChangeZonesRechargeActivity changeZonesRechargeActivity = this.target;
        if (changeZonesRechargeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        changeZonesRechargeActivity.toolbar = null;
        changeZonesRechargeActivity.tvInfoTransportCardAction = null;
        changeZonesRechargeActivity.tvRechargeTransportCardAction = null;
        changeZonesRechargeActivity.tilNumberTickets = null;
        changeZonesRechargeActivity.sNumberTickets = null;
        changeZonesRechargeActivity.tvTransportCardAction = null;
        this.view7f0a040c.setOnClickListener(null);
        this.view7f0a040c = null;
        this.view7f0a0470.setOnClickListener(null);
        this.view7f0a0470 = null;
    }
}
