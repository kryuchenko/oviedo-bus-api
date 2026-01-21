package com.iecisa.ctausuario.ui.main.stops.detailstop;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class DetailStopActivity_ViewBinding implements Unbinder {
    private DetailStopActivity target;
    private View view7f0a040c;
    private View view7f0a0470;

    public DetailStopActivity_ViewBinding(DetailStopActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public DetailStopActivity_ViewBinding(final DetailStopActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.vpContainer = (ViewPager) Utils.findRequiredViewAsType(source, R.id.vpContainer, "field 'vpContainer'", ViewPager.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.tvInfoTransportCardAction, "method 'onClickEvents'");
        this.view7f0a040c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvRechargeTransportCardAction, "method 'onClickEvents'");
        this.view7f0a0470 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        target.tvStopsAction = Utils.listFilteringNull((TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoTransportCardAction, "field 'tvStopsAction'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.tvRechargeTransportCardAction, "field 'tvStopsAction'", TextView.class));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DetailStopActivity detailStopActivity = this.target;
        if (detailStopActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        detailStopActivity.toolbar = null;
        detailStopActivity.vpContainer = null;
        detailStopActivity.tvStopsAction = null;
        this.view7f0a040c.setOnClickListener(null);
        this.view7f0a040c = null;
        this.view7f0a0470.setOnClickListener(null);
        this.view7f0a0470 = null;
    }
}
