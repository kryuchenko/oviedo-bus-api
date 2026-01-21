package com.iecisa.ctausuario.ui.main;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class MainActivity_ViewBinding implements Unbinder {
    private MainActivity target;
    private View view7f0a0408;
    private View view7f0a0454;
    private View view7f0a0477;
    private View view7f0a0483;
    private View view7f0a04a5;

    public MainActivity_ViewBinding(MainActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public MainActivity_ViewBinding(final MainActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.tvStopsActionMenu, "method 'onClickEvents'");
        this.view7f0a0483 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.MainActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvTransportCardActionMenu, "method 'onClickEvents'");
        this.view7f0a04a5 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.MainActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.tvRouteActionMenu, "method 'onClickEvents'");
        this.view7f0a0477 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.MainActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.tvIncidentsActionMenu, "method 'onClickEvents'");
        this.view7f0a0408 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.MainActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(source, R.id.tvMoreActionMenu, "method 'onClickEvents'");
        this.view7f0a0454 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.MainActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        target.tvMenuActions = Utils.listFilteringNull((TextView) Utils.findRequiredViewAsType(source, R.id.tvStopsActionMenu, "field 'tvMenuActions'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.tvTransportCardActionMenu, "field 'tvMenuActions'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.tvRouteActionMenu, "field 'tvMenuActions'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.tvIncidentsActionMenu, "field 'tvMenuActions'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.tvMoreActionMenu, "field 'tvMenuActions'", TextView.class));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MainActivity mainActivity = this.target;
        if (mainActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mainActivity.toolbar = null;
        mainActivity.tvMenuActions = null;
        this.view7f0a0483.setOnClickListener(null);
        this.view7f0a0483 = null;
        this.view7f0a04a5.setOnClickListener(null);
        this.view7f0a04a5 = null;
        this.view7f0a0477.setOnClickListener(null);
        this.view7f0a0477 = null;
        this.view7f0a0408.setOnClickListener(null);
        this.view7f0a0408 = null;
        this.view7f0a0454.setOnClickListener(null);
        this.view7f0a0454 = null;
    }
}
