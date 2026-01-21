package com.iecisa.ctausuario.ui.main.linesrealtime;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class LinesRealTimeActivity_ViewBinding implements Unbinder {
    private LinesRealTimeActivity target;
    private View view7f0a040c;
    private View view7f0a0470;

    public LinesRealTimeActivity_ViewBinding(LinesRealTimeActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public LinesRealTimeActivity_ViewBinding(final LinesRealTimeActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.tvInfoTransportCardAction, "method 'onClickEvents'");
        this.view7f0a040c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvRechargeTransportCardAction, "method 'onClickEvents'");
        this.view7f0a0470 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        target.tvLineAction = Utils.listFilteringNull((TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoTransportCardAction, "field 'tvLineAction'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.tvRechargeTransportCardAction, "field 'tvLineAction'", TextView.class));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LinesRealTimeActivity linesRealTimeActivity = this.target;
        if (linesRealTimeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        linesRealTimeActivity.toolbar = null;
        linesRealTimeActivity.tvLineAction = null;
        this.view7f0a040c.setOnClickListener(null);
        this.view7f0a040c = null;
        this.view7f0a0470.setOnClickListener(null);
        this.view7f0a0470 = null;
    }
}
