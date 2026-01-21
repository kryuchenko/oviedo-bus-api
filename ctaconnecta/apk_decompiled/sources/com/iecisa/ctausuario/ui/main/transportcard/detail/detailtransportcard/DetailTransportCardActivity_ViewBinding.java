package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class DetailTransportCardActivity_ViewBinding implements Unbinder {
    private DetailTransportCardActivity target;
    private View view7f0a025a;
    private View view7f0a025b;
    private View view7f0a025c;
    private View view7f0a025d;
    private View view7f0a040c;
    private View view7f0a0470;

    public DetailTransportCardActivity_ViewBinding(DetailTransportCardActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public DetailTransportCardActivity_ViewBinding(final DetailTransportCardActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.tvAdvice = (TextView) Utils.findRequiredViewAsType(source, R.id.tvAdvice, "field 'tvAdvice'", TextView.class);
        target.mbPocket = (MaterialButton) Utils.findRequiredViewAsType(source, R.id.mbPocket, "field 'mbPocket'", MaterialButton.class);
        target.tvSpendInfo = (TextView) Utils.findRequiredViewAsType(source, R.id.tvSpendInfo, "field 'tvSpendInfo'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.tvInfoTransportCardAction, "field 'tvInfoTransportCardAction' and method 'onClickEvents'");
        target.tvInfoTransportCardAction = (TextView) Utils.castView(viewFindRequiredView, R.id.tvInfoTransportCardAction, "field 'tvInfoTransportCardAction'", TextView.class);
        this.view7f0a040c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvRechargeTransportCardAction, "field 'tvRechargeTransportCardAction' and method 'onClickEvents'");
        target.tvRechargeTransportCardAction = (TextView) Utils.castView(viewFindRequiredView2, R.id.tvRechargeTransportCardAction, "field 'tvRechargeTransportCardAction'", TextView.class);
        this.view7f0a0470 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        target.tvInfoDetails = (TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoDetails, "field 'tvInfoDetails'", TextView.class);
        target.tvExpired = (TextView) Utils.findRequiredViewAsType(source, R.id.tvExpired, "field 'tvExpired'", TextView.class);
        target.tvExpiredInfo = (TextView) Utils.findRequiredViewAsType(source, R.id.tvExpiredInfo, "field 'tvExpiredInfo'", TextView.class);
        target.tvExtendedInfo = (TextView) Utils.findRequiredViewAsType(source, R.id.tvExtendedInfo, "field 'tvExtendedInfo'", TextView.class);
        target.ctaSinglePass = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.ctaSinglePass, "field 'ctaSinglePass'", ConstraintLayout.class);
        target.ctaPass = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.ctaPass, "field 'ctaPass'", ConstraintLayout.class);
        target.ctaImpersonalPass = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.ctaImpersonalPass, "field 'ctaImpersonalPass'", ConstraintLayout.class);
        target.ctaTenImpersonalPass = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.ctaTenImpersonalPass, "field 'ctaTenImpersonalPass'", ConstraintLayout.class);
        target.gpDetails = (Group) Utils.findRequiredViewAsType(source, R.id.gpDetails, "field 'gpDetails'", Group.class);
        target.mbNumZones = (MaterialButton) Utils.findRequiredViewAsType(source, R.id.mbNumZones, "field 'mbNumZones'", MaterialButton.class);
        target.mbValidUntil = (MaterialButton) Utils.findRequiredViewAsType(source, R.id.mbValidUntil, "field 'mbValidUntil'", MaterialButton.class);
        target.mbBalance = (MaterialButton) Utils.findRequiredViewAsType(source, R.id.mbBalance, "field 'mbBalance'", MaterialButton.class);
        target.mbNumTicketsZones = (MaterialButton) Utils.findRequiredViewAsType(source, R.id.mbNumTicketsZones, "field 'mbNumTicketsZones'", MaterialButton.class);
        target.mbTripTicket = (MaterialButton) Utils.findRequiredViewAsType(source, R.id.mbTripTicket, "field 'mbTripTicket'", MaterialButton.class);
        target.mbValidTicketUntil = (MaterialButton) Utils.findRequiredViewAsType(source, R.id.mbValidTicketUntil, "field 'mbValidTicketUntil'", MaterialButton.class);
        target.tvTripsInfo = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTripsInfo, "field 'tvTripsInfo'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.mbRechargeSinglePass, "field 'mbRechargeSinglePass' and method 'onViewClicked'");
        target.mbRechargeSinglePass = (MaterialButton) Utils.castView(viewFindRequiredView3, R.id.mbRechargeSinglePass, "field 'mbRechargeSinglePass'", MaterialButton.class);
        this.view7f0a025d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.mbRechargeImpersonalPass, "field 'mbRechargeTenImpersonalPass' and method 'onViewClicked'");
        target.mbRechargeTenImpersonalPass = (MaterialButton) Utils.castView(viewFindRequiredView4, R.id.mbRechargeImpersonalPass, "field 'mbRechargeTenImpersonalPass'", MaterialButton.class);
        this.view7f0a025c = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(source, R.id.mbRechargeCtaPass, "field 'mbRechargeCtaPass' and method 'onViewClicked'");
        target.mbRechargeCtaPass = (MaterialButton) Utils.castView(viewFindRequiredView5, R.id.mbRechargeCtaPass, "field 'mbRechargeCtaPass'", MaterialButton.class);
        this.view7f0a025b = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(source, R.id.mbRechargeCtaImpersonalPass, "field 'mbRechargeCtaImpersonalPass' and method 'onViewClicked'");
        target.mbRechargeCtaImpersonalPass = (MaterialButton) Utils.castView(viewFindRequiredView6, R.id.mbRechargeCtaImpersonalPass, "field 'mbRechargeCtaImpersonalPass'", MaterialButton.class);
        this.view7f0a025a = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        target.tvTransportCardAction = Utils.listFilteringNull((TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoTransportCardAction, "field 'tvTransportCardAction'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.tvRechargeTransportCardAction, "field 'tvTransportCardAction'", TextView.class));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DetailTransportCardActivity detailTransportCardActivity = this.target;
        if (detailTransportCardActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        detailTransportCardActivity.toolbar = null;
        detailTransportCardActivity.tvAdvice = null;
        detailTransportCardActivity.mbPocket = null;
        detailTransportCardActivity.tvSpendInfo = null;
        detailTransportCardActivity.tvInfoTransportCardAction = null;
        detailTransportCardActivity.tvRechargeTransportCardAction = null;
        detailTransportCardActivity.tvInfoDetails = null;
        detailTransportCardActivity.tvExpired = null;
        detailTransportCardActivity.tvExpiredInfo = null;
        detailTransportCardActivity.tvExtendedInfo = null;
        detailTransportCardActivity.ctaSinglePass = null;
        detailTransportCardActivity.ctaPass = null;
        detailTransportCardActivity.ctaImpersonalPass = null;
        detailTransportCardActivity.ctaTenImpersonalPass = null;
        detailTransportCardActivity.gpDetails = null;
        detailTransportCardActivity.mbNumZones = null;
        detailTransportCardActivity.mbValidUntil = null;
        detailTransportCardActivity.mbBalance = null;
        detailTransportCardActivity.mbNumTicketsZones = null;
        detailTransportCardActivity.mbTripTicket = null;
        detailTransportCardActivity.mbValidTicketUntil = null;
        detailTransportCardActivity.tvTripsInfo = null;
        detailTransportCardActivity.mbRechargeSinglePass = null;
        detailTransportCardActivity.mbRechargeTenImpersonalPass = null;
        detailTransportCardActivity.mbRechargeCtaPass = null;
        detailTransportCardActivity.mbRechargeCtaImpersonalPass = null;
        detailTransportCardActivity.tvTransportCardAction = null;
        this.view7f0a040c.setOnClickListener(null);
        this.view7f0a040c = null;
        this.view7f0a0470.setOnClickListener(null);
        this.view7f0a0470 = null;
        this.view7f0a025d.setOnClickListener(null);
        this.view7f0a025d = null;
        this.view7f0a025c.setOnClickListener(null);
        this.view7f0a025c = null;
        this.view7f0a025b.setOnClickListener(null);
        this.view7f0a025b = null;
        this.view7f0a025a.setOnClickListener(null);
        this.view7f0a025a = null;
    }
}
