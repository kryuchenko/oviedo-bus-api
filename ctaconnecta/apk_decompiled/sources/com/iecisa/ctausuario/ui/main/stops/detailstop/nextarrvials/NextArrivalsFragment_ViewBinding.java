package com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials;

import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class NextArrivalsFragment_ViewBinding implements Unbinder {
    private NextArrivalsFragment target;
    private View view7f0a0095;
    private View view7f0a01fa;
    private View view7f0a037e;
    private View view7f0a041f;

    public NextArrivalsFragment_ViewBinding(final NextArrivalsFragment target, View source) {
        this.target = target;
        target.rvStops = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvStops, "field 'rvStops'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.swOnlyDestination, "field 'swOnlyDestination' and method 'onEventsClick'");
        target.swOnlyDestination = (Switch) Utils.castView(viewFindRequiredView, R.id.swOnlyDestination, "field 'swOnlyDestination'", Switch.class);
        this.view7f0a037e = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventsClick(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvLabelDestination, "field 'tvLabelDestination' and method 'onEventsClick'");
        target.tvLabelDestination = (TextView) Utils.castView(viewFindRequiredView2, R.id.tvLabelDestination, "field 'tvLabelDestination'", TextView.class);
        this.view7f0a041f = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventsClick(p0);
            }
        });
        target.clStopsToDestination = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.clStopsToDestination, "field 'clStopsToDestination'", ConstraintLayout.class);
        target.tvErrorStopData = (TextView) Utils.findRequiredViewAsType(source, R.id.tvErrorStopData, "field 'tvErrorStopData'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.ivRemoveUserDestination, "field 'ivRemoveUserDestination' and method 'onEventsClick'");
        target.ivRemoveUserDestination = (ImageView) Utils.castView(viewFindRequiredView3, R.id.ivRemoveUserDestination, "field 'ivRemoveUserDestination'", ImageView.class);
        this.view7f0a01fa = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventsClick(p0);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.btRefresh, "field 'btRefresh' and method 'onEventsClick'");
        target.btRefresh = (MaterialButton) Utils.castView(viewFindRequiredView4, R.id.btRefresh, "field 'btRefresh'", MaterialButton.class);
        this.view7f0a0095 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventsClick(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NextArrivalsFragment nextArrivalsFragment = this.target;
        if (nextArrivalsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        nextArrivalsFragment.rvStops = null;
        nextArrivalsFragment.swOnlyDestination = null;
        nextArrivalsFragment.tvLabelDestination = null;
        nextArrivalsFragment.clStopsToDestination = null;
        nextArrivalsFragment.tvErrorStopData = null;
        nextArrivalsFragment.ivRemoveUserDestination = null;
        nextArrivalsFragment.btRefresh = null;
        this.view7f0a037e.setOnClickListener(null);
        this.view7f0a037e = null;
        this.view7f0a041f.setOnClickListener(null);
        this.view7f0a041f = null;
        this.view7f0a01fa.setOnClickListener(null);
        this.view7f0a01fa = null;
        this.view7f0a0095.setOnClickListener(null);
        this.view7f0a0095 = null;
    }
}
