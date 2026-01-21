package com.iecisa.ctausuario.ui.main.stops.detailstop.alllines;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class AllLinesFragment_ViewBinding implements Unbinder {
    private AllLinesFragment target;

    public AllLinesFragment_ViewBinding(AllLinesFragment target, View source) {
        this.target = target;
        target.rvStops = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvStops, "field 'rvStops'", RecyclerView.class);
        target.tvErrorStopData = (TextView) Utils.findRequiredViewAsType(source, R.id.tvErrorStopData, "field 'tvErrorStopData'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AllLinesFragment allLinesFragment = this.target;
        if (allLinesFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        allLinesFragment.rvStops = null;
        allLinesFragment.tvErrorStopData = null;
    }
}
