package com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge;

import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class AutomaticRechargeActivity_ViewBinding implements Unbinder {
    private AutomaticRechargeActivity target;
    private View view7f0a0083;
    private View view7f0a0084;
    private View view7f0a0085;
    private View view7f0a0262;
    private View view7f0a037b;

    public AutomaticRechargeActivity_ViewBinding(AutomaticRechargeActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public AutomaticRechargeActivity_ViewBinding(final AutomaticRechargeActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.swAutomaticRecharge, "field 'swAutomaticRecharge' and method 'onViewClicked'");
        target.swAutomaticRecharge = (Switch) Utils.castView(viewFindRequiredView, R.id.swAutomaticRecharge, "field 'swAutomaticRecharge'", Switch.class);
        this.view7f0a037b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        target.tvMinThreshold = (TextView) Utils.findRequiredViewAsType(source, R.id.tvMinThreshold, "field 'tvMinThreshold'", TextView.class);
        target.tvRechargeQuantity = (TextView) Utils.findRequiredViewAsType(source, R.id.tvRechargeQuantity, "field 'tvRechargeQuantity'", TextView.class);
        target.tvCreditCard = (TextView) Utils.findRequiredViewAsType(source, R.id.tvCreditCard, "field 'tvCreditCard'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.btEditMinThreshold, "field 'btEditMinThreshold' and method 'onViewClicked'");
        target.btEditMinThreshold = (MaterialButton) Utils.castView(viewFindRequiredView2, R.id.btEditMinThreshold, "field 'btEditMinThreshold'", MaterialButton.class);
        this.view7f0a0084 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.btEditRechargeQuantity, "field 'btEditRechargeQuantity' and method 'onViewClicked'");
        target.btEditRechargeQuantity = (MaterialButton) Utils.castView(viewFindRequiredView3, R.id.btEditRechargeQuantity, "field 'btEditRechargeQuantity'", MaterialButton.class);
        this.view7f0a0085 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.btEditCreditCard, "field 'btEditCreditCard' and method 'onViewClicked'");
        target.btEditCreditCard = (MaterialButton) Utils.castView(viewFindRequiredView4, R.id.btEditCreditCard, "field 'btEditCreditCard'", MaterialButton.class);
        this.view7f0a0083 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        target.gpErrorRecharge = (Group) Utils.findRequiredViewAsType(source, R.id.gpErrorRecharge, "field 'gpErrorRecharge'", Group.class);
        View viewFindRequiredView5 = Utils.findRequiredView(source, R.id.mbRetryAutoRecharge, "field 'mbRetryAutoRecharge' and method 'onViewClicked'");
        target.mbRetryAutoRecharge = (MaterialButton) Utils.castView(viewFindRequiredView5, R.id.mbRetryAutoRecharge, "field 'mbRetryAutoRecharge'", MaterialButton.class);
        this.view7f0a0262 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AutomaticRechargeActivity automaticRechargeActivity = this.target;
        if (automaticRechargeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        automaticRechargeActivity.toolbar = null;
        automaticRechargeActivity.swAutomaticRecharge = null;
        automaticRechargeActivity.tvMinThreshold = null;
        automaticRechargeActivity.tvRechargeQuantity = null;
        automaticRechargeActivity.tvCreditCard = null;
        automaticRechargeActivity.btEditMinThreshold = null;
        automaticRechargeActivity.btEditRechargeQuantity = null;
        automaticRechargeActivity.btEditCreditCard = null;
        automaticRechargeActivity.gpErrorRecharge = null;
        automaticRechargeActivity.mbRetryAutoRecharge = null;
        this.view7f0a037b.setOnClickListener(null);
        this.view7f0a037b = null;
        this.view7f0a0084.setOnClickListener(null);
        this.view7f0a0084 = null;
        this.view7f0a0085.setOnClickListener(null);
        this.view7f0a0085 = null;
        this.view7f0a0083.setOnClickListener(null);
        this.view7f0a0083 = null;
        this.view7f0a0262.setOnClickListener(null);
        this.view7f0a0262 = null;
    }
}
