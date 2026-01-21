package com.iecisa.ctausuario.ui.main.transportcard.detail.createreports;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class CreateReportsActivity_ViewBinding implements Unbinder {
    private CreateReportsActivity target;
    private View view7f0a025e;
    private View view7f0a03e7;
    private View view7f0a03e8;

    public CreateReportsActivity_ViewBinding(CreateReportsActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public CreateReportsActivity_ViewBinding(final CreateReportsActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.tvErrorMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvErrorMessage, "field 'tvErrorMessage'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.tvDateSince, "field 'tvDateSince' and method 'onViewClicked'");
        target.tvDateSince = (TextView) Utils.castView(viewFindRequiredView, R.id.tvDateSince, "field 'tvDateSince'", TextView.class);
        this.view7f0a03e7 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvDateTo, "field 'tvDateTo' and method 'onViewClicked'");
        target.tvDateTo = (TextView) Utils.castView(viewFindRequiredView2, R.id.tvDateTo, "field 'tvDateTo'", TextView.class);
        this.view7f0a03e8 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.mbRechargeTrips, "field 'mbRechargeTrips' and method 'onViewClicked'");
        target.mbRechargeTrips = (MaterialButton) Utils.castView(viewFindRequiredView3, R.id.mbRechargeTrips, "field 'mbRechargeTrips'", MaterialButton.class);
        this.view7f0a025e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CreateReportsActivity createReportsActivity = this.target;
        if (createReportsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        createReportsActivity.toolbar = null;
        createReportsActivity.tvErrorMessage = null;
        createReportsActivity.tvDateSince = null;
        createReportsActivity.tvDateTo = null;
        createReportsActivity.mbRechargeTrips = null;
        this.view7f0a03e7.setOnClickListener(null);
        this.view7f0a03e7 = null;
        this.view7f0a03e8.setOnClickListener(null);
        this.view7f0a03e8 = null;
        this.view7f0a025e.setOnClickListener(null);
        this.view7f0a025e = null;
    }
}
