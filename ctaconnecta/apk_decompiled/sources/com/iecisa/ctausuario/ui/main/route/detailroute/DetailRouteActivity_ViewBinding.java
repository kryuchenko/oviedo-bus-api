package com.iecisa.ctausuario.ui.main.route.detailroute;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class DetailRouteActivity_ViewBinding implements Unbinder {
    private DetailRouteActivity target;
    private View view7f0a0201;

    public DetailRouteActivity_ViewBinding(DetailRouteActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public DetailRouteActivity_ViewBinding(final DetailRouteActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.clBottomSheet = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.clBottomSheet, "field 'clBottomSheet'", ConstraintLayout.class);
        target.rvResume = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvResume, "field 'rvResume'", RecyclerView.class);
        target.rvRoute = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvRoute, "field 'rvRoute'", RecyclerView.class);
        target.tvTime = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTime, "field 'tvTime'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.ivSlider, "method 'onEventClick'");
        this.view7f0a0201 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.detailroute.DetailRouteActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClick(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DetailRouteActivity detailRouteActivity = this.target;
        if (detailRouteActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        detailRouteActivity.toolbar = null;
        detailRouteActivity.clBottomSheet = null;
        detailRouteActivity.rvResume = null;
        detailRouteActivity.rvRoute = null;
        detailRouteActivity.tvTime = null;
        this.view7f0a0201.setOnClickListener(null);
        this.view7f0a0201 = null;
    }
}
