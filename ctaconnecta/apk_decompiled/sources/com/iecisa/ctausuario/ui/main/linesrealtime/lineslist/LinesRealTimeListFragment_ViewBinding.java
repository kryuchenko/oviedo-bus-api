package com.iecisa.ctausuario.ui.main.linesrealtime.lineslist;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class LinesRealTimeListFragment_ViewBinding implements Unbinder {
    private LinesRealTimeListFragment target;
    private View view7f0a0095;

    public LinesRealTimeListFragment_ViewBinding(final LinesRealTimeListFragment target, View source) {
        this.target = target;
        target.rvStopsLine = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvStopsLine, "field 'rvStopsLine'", RecyclerView.class);
        target.tvErrorListStops = (TextView) Utils.findRequiredViewAsType(source, R.id.tvErrorListStops, "field 'tvErrorListStops'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.btRefresh, "field 'btRefresh' and method 'onEventsClick'");
        target.btRefresh = (MaterialButton) Utils.castView(viewFindRequiredView, R.id.btRefresh, "field 'btRefresh'", MaterialButton.class);
        this.view7f0a0095 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.linesrealtime.lineslist.LinesRealTimeListFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventsClick(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LinesRealTimeListFragment linesRealTimeListFragment = this.target;
        if (linesRealTimeListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        linesRealTimeListFragment.rvStopsLine = null;
        linesRealTimeListFragment.tvErrorListStops = null;
        linesRealTimeListFragment.btRefresh = null;
        this.view7f0a0095.setOnClickListener(null);
        this.view7f0a0095 = null;
    }
}
