package com.iecisa.ctausuario.ui.main.route.detailroute.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class DetailRouteWalkingViewHolder_ViewBinding implements Unbinder {
    private DetailRouteWalkingViewHolder target;
    private View view7f0a0327;

    public DetailRouteWalkingViewHolder_ViewBinding(final DetailRouteWalkingViewHolder target, View source) {
        this.target = target;
        target.tvTitle = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'tvTitle'", TextView.class);
        target.gpStart = (Group) Utils.findRequiredViewAsType(source, R.id.gpStart, "field 'gpStart'", Group.class);
        target.tvStartLocation = (TextView) Utils.findRequiredViewAsType(source, R.id.tvStartLocation, "field 'tvStartLocation'", TextView.class);
        target.tvStartTime = (TextView) Utils.findRequiredViewAsType(source, R.id.tvStartTime, "field 'tvStartTime'", TextView.class);
        target.gpEnd = (Group) Utils.findRequiredViewAsType(source, R.id.gpEnd, "field 'gpEnd'", Group.class);
        target.tvEndLocation = (TextView) Utils.findRequiredViewAsType(source, R.id.tvEndLocation, "field 'tvEndLocation'", TextView.class);
        target.tvEndTime = (TextView) Utils.findRequiredViewAsType(source, R.id.tvEndTime, "field 'tvEndTime'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.rvRouteWalking, "method 'onClickMap'");
        this.view7f0a0327 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.detailroute.adapter.DetailRouteWalkingViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickMap();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DetailRouteWalkingViewHolder detailRouteWalkingViewHolder = this.target;
        if (detailRouteWalkingViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        detailRouteWalkingViewHolder.tvTitle = null;
        detailRouteWalkingViewHolder.gpStart = null;
        detailRouteWalkingViewHolder.tvStartLocation = null;
        detailRouteWalkingViewHolder.tvStartTime = null;
        detailRouteWalkingViewHolder.gpEnd = null;
        detailRouteWalkingViewHolder.tvEndLocation = null;
        detailRouteWalkingViewHolder.tvEndTime = null;
        this.view7f0a0327.setOnClickListener(null);
        this.view7f0a0327 = null;
    }
}
