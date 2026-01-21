package com.iecisa.ctausuario.ui.main.stops.mapstops;

import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class MapStopsFragment_ViewBinding implements Unbinder {
    private MapStopsFragment target;
    private View view7f0a00d9;
    private View view7f0a01e8;
    private View view7f0a01ea;
    private View view7f0a01fa;
    private View view7f0a0208;
    private View view7f0a041f;
    private View view7f0a0422;

    public MapStopsFragment_ViewBinding(final MapStopsFragment target, View source) {
        this.target = target;
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.ivUserLocation, "field 'ivUserLocation' and method 'onEventClick'");
        target.ivUserLocation = (ImageView) Utils.castView(viewFindRequiredView, R.id.ivUserLocation, "field 'ivUserLocation'", ImageView.class);
        this.view7f0a0208 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClick(p0);
            }
        });
        target.swOnlyDestination = (Switch) Utils.findRequiredViewAsType(source, R.id.swOnlyDestination, "field 'swOnlyDestination'", Switch.class);
        target.clSnackBarTop = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.clSnackBarTop, "field 'clSnackBarTop'", ConstraintLayout.class);
        target.tvMessageSnackBarTop = (TextView) Utils.findRequiredViewAsType(source, R.id.tvMessageSnackBarTop, "field 'tvMessageSnackBarTop'", TextView.class);
        target.clStopsToDestination = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.clStopsToDestination, "field 'clStopsToDestination'", ConstraintLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvLabelDestination, "field 'tvLabelDestination' and method 'onEventClick'");
        target.tvLabelDestination = (TextView) Utils.castView(viewFindRequiredView2, R.id.tvLabelDestination, "field 'tvLabelDestination'", TextView.class);
        this.view7f0a041f = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClick(p0);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.clSwipeStop, "field 'clSwipeStop' and method 'onEventClick'");
        target.clSwipeStop = (ConstraintLayout) Utils.castView(viewFindRequiredView3, R.id.clSwipeStop, "field 'clSwipeStop'", ConstraintLayout.class);
        this.view7f0a00d9 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClick(p0);
            }
        });
        target.clSwipeNoDirectConnections = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.clSwipeNoDirectConnections, "field 'clSwipeNoDirectConnections'", ConstraintLayout.class);
        target.tvStopNumber = (TextView) Utils.findRequiredViewAsType(source, R.id.tvStopNumber, "field 'tvStopNumber'", TextView.class);
        target.tvStopName = (TextView) Utils.findRequiredViewAsType(source, R.id.tvStopName, "field 'tvStopName'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.ivCloseStopData, "field 'ivCloseStopData' and method 'onEventClick'");
        target.ivCloseStopData = (ImageView) Utils.castView(viewFindRequiredView4, R.id.ivCloseStopData, "field 'ivCloseStopData'", ImageView.class);
        this.view7f0a01ea = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClick(p0);
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(source, R.id.tvLabelEnterDirection, "field 'tvLabelEnterDirection' and method 'onEventClick'");
        target.tvLabelEnterDirection = (TextView) Utils.castView(viewFindRequiredView5, R.id.tvLabelEnterDirection, "field 'tvLabelEnterDirection'", TextView.class);
        this.view7f0a0422 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClick(p0);
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(source, R.id.ivRemoveUserDestination, "field 'ivRemoveDestination' and method 'onEventClick'");
        target.ivRemoveDestination = (ImageView) Utils.castView(viewFindRequiredView6, R.id.ivRemoveUserDestination, "field 'ivRemoveDestination'", ImageView.class);
        this.view7f0a01fa = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClick(p0);
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(source, R.id.ivCloseNoConnections, "method 'onEventClick'");
        this.view7f0a01e8 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClick(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MapStopsFragment mapStopsFragment = this.target;
        if (mapStopsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mapStopsFragment.ivUserLocation = null;
        mapStopsFragment.swOnlyDestination = null;
        mapStopsFragment.clSnackBarTop = null;
        mapStopsFragment.tvMessageSnackBarTop = null;
        mapStopsFragment.clStopsToDestination = null;
        mapStopsFragment.tvLabelDestination = null;
        mapStopsFragment.clSwipeStop = null;
        mapStopsFragment.clSwipeNoDirectConnections = null;
        mapStopsFragment.tvStopNumber = null;
        mapStopsFragment.tvStopName = null;
        mapStopsFragment.ivCloseStopData = null;
        mapStopsFragment.tvLabelEnterDirection = null;
        mapStopsFragment.ivRemoveDestination = null;
        this.view7f0a0208.setOnClickListener(null);
        this.view7f0a0208 = null;
        this.view7f0a041f.setOnClickListener(null);
        this.view7f0a041f = null;
        this.view7f0a00d9.setOnClickListener(null);
        this.view7f0a00d9 = null;
        this.view7f0a01ea.setOnClickListener(null);
        this.view7f0a01ea = null;
        this.view7f0a0422.setOnClickListener(null);
        this.view7f0a0422 = null;
        this.view7f0a01fa.setOnClickListener(null);
        this.view7f0a01fa = null;
        this.view7f0a01e8.setOnClickListener(null);
        this.view7f0a01e8 = null;
    }
}
