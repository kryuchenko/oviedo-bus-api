package com.iecisa.ctausuario.ui.main.route.detailroute.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class DetailRouteTransitViewHolder_ViewBinding implements Unbinder {
    private DetailRouteTransitViewHolder target;
    private View view7f0a0326;

    public DetailRouteTransitViewHolder_ViewBinding(final DetailRouteTransitViewHolder target, View source) {
        this.target = target;
        target.tvTitle = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'tvTitle'", TextView.class);
        target.ivTitle = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivTitle, "field 'ivTitle'", ImageView.class);
        target.tvTime = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTime, "field 'tvTime'", TextView.class);
        target.tvTitleEnd = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTitleEnd, "field 'tvTitleEnd'", TextView.class);
        target.tvTimeEnd = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTimeEnd, "field 'tvTimeEnd'", TextView.class);
        target.tvResumeTransport = (TextView) Utils.findRequiredViewAsType(source, R.id.tvResumeTransport, "field 'tvResumeTransport'", TextView.class);
        target.tvDescriptionTransport = (TextView) Utils.findRequiredViewAsType(source, R.id.tvDescriptionTransport, "field 'tvDescriptionTransport'", TextView.class);
        target.tvProgrammed = (TextView) Utils.findRequiredViewAsType(source, R.id.tvProgrammed, "field 'tvProgrammed'", TextView.class);
        target.tvStopsTime = (TextView) Utils.findRequiredViewAsType(source, R.id.tvStopsTime, "field 'tvStopsTime'", TextView.class);
        target.vColor = Utils.findRequiredView(source, R.id.vColor, "field 'vColor'");
        target.ivTitleEnd = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivTitleEnd, "field 'ivTitleEnd'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.rvRouteTransit, "method 'onClickMap'");
        this.view7f0a0326 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.detailroute.adapter.DetailRouteTransitViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickMap();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DetailRouteTransitViewHolder detailRouteTransitViewHolder = this.target;
        if (detailRouteTransitViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        detailRouteTransitViewHolder.tvTitle = null;
        detailRouteTransitViewHolder.ivTitle = null;
        detailRouteTransitViewHolder.tvTime = null;
        detailRouteTransitViewHolder.tvTitleEnd = null;
        detailRouteTransitViewHolder.tvTimeEnd = null;
        detailRouteTransitViewHolder.tvResumeTransport = null;
        detailRouteTransitViewHolder.tvDescriptionTransport = null;
        detailRouteTransitViewHolder.tvProgrammed = null;
        detailRouteTransitViewHolder.tvStopsTime = null;
        detailRouteTransitViewHolder.vColor = null;
        detailRouteTransitViewHolder.ivTitleEnd = null;
        this.view7f0a0326.setOnClickListener(null);
        this.view7f0a0326 = null;
    }
}
