package com.iecisa.ctausuario.ui.main.route.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class RouteViewHolder_ViewBinding implements Unbinder {
    private RouteViewHolder target;

    public RouteViewHolder_ViewBinding(RouteViewHolder target, View source) {
        this.target = target;
        target.rowSearchRoute = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.rowSearchRoute, "field 'rowSearchRoute'", ConstraintLayout.class);
        target.rvResume = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvResume, "field 'rvResume'", RecyclerView.class);
        target.tvDuration = (TextView) Utils.findRequiredViewAsType(source, R.id.tvDuration, "field 'tvDuration'", TextView.class);
        target.tvTime = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTime, "field 'tvTime'", TextView.class);
        target.tvSince = (TextView) Utils.findRequiredViewAsType(source, R.id.tvSince, "field 'tvSince'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RouteViewHolder routeViewHolder = this.target;
        if (routeViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        routeViewHolder.rowSearchRoute = null;
        routeViewHolder.rvResume = null;
        routeViewHolder.tvDuration = null;
        routeViewHolder.tvTime = null;
        routeViewHolder.tvSince = null;
    }
}
