package com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class ActivateAutoRechargeActivity_ViewBinding implements Unbinder {
    private ActivateAutoRechargeActivity target;
    private View view7f0a0079;
    private View view7f0a00bf;
    private View view7f0a040e;

    public ActivateAutoRechargeActivity_ViewBinding(ActivateAutoRechargeActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public ActivateAutoRechargeActivity_ViewBinding(final ActivateAutoRechargeActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.tvDescription = (TextView) Utils.findRequiredViewAsType(source, R.id.tvDescription, "field 'tvDescription'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.cbAceptTerms, "field 'cbAceptTerms' and method 'onCheckedChanged'");
        target.cbAceptTerms = (CheckBox) Utils.castView(viewFindRequiredView, R.id.cbAceptTerms, "field 'cbAceptTerms'", CheckBox.class);
        this.view7f0a00bf = viewFindRequiredView;
        ((CompoundButton) viewFindRequiredView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity_ViewBinding.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton p0, boolean p1) {
                target.onCheckedChanged(p1);
            }
        });
        target.tvInfoMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoMessage, "field 'tvInfoMessage'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.btActivate, "field 'btActivate' and method 'onViewClicked'");
        target.btActivate = (Button) Utils.castView(viewFindRequiredView2, R.id.btActivate, "field 'btActivate'", Button.class);
        this.view7f0a0079 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.tvLabelAceptTerms, "method 'onViewClicked'");
        this.view7f0a040e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ActivateAutoRechargeActivity activateAutoRechargeActivity = this.target;
        if (activateAutoRechargeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        activateAutoRechargeActivity.toolbar = null;
        activateAutoRechargeActivity.tvDescription = null;
        activateAutoRechargeActivity.cbAceptTerms = null;
        activateAutoRechargeActivity.tvInfoMessage = null;
        activateAutoRechargeActivity.btActivate = null;
        ((CompoundButton) this.view7f0a00bf).setOnCheckedChangeListener(null);
        this.view7f0a00bf = null;
        this.view7f0a0079.setOnClickListener(null);
        this.view7f0a0079 = null;
        this.view7f0a040e.setOnClickListener(null);
        this.view7f0a040e = null;
    }
}
