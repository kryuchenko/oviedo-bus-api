package com.iecisa.ctausuario.ui.main.stops;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class StopsFragment_ViewBinding implements Unbinder {
    private StopsFragment target;
    private View view7f0a01ed;
    private View view7f0a01f5;
    private View view7f0a01fd;

    public StopsFragment_ViewBinding(final StopsFragment target, View source) {
        this.target = target;
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.ivMapStopAction, "method 'onClickEvents'");
        this.view7f0a01f5 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.StopsFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.ivSearchStopAction, "method 'onClickEvents'");
        this.view7f0a01fd = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.StopsFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.ivFavouriteStopAction, "method 'onClickEvents'");
        this.view7f0a01ed = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.StopsFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        target.ivStopsActions = Utils.listFilteringNull((ImageView) Utils.findRequiredViewAsType(source, R.id.ivMapStopAction, "field 'ivStopsActions'", ImageView.class), (ImageView) Utils.findRequiredViewAsType(source, R.id.ivSearchStopAction, "field 'ivStopsActions'", ImageView.class), (ImageView) Utils.findRequiredViewAsType(source, R.id.ivFavouriteStopAction, "field 'ivStopsActions'", ImageView.class));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StopsFragment stopsFragment = this.target;
        if (stopsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        stopsFragment.ivStopsActions = null;
        this.view7f0a01f5.setOnClickListener(null);
        this.view7f0a01f5 = null;
        this.view7f0a01fd.setOnClickListener(null);
        this.view7f0a01fd = null;
        this.view7f0a01ed.setOnClickListener(null);
        this.view7f0a01ed = null;
    }
}
