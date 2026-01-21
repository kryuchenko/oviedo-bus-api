package com.iecisa.ctausuario.ui.main.stops.searchstop;

import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class SearchStopsFragment_ViewBinding implements Unbinder {
    private SearchStopsFragment target;

    public SearchStopsFragment_ViewBinding(SearchStopsFragment target, View source) {
        this.target = target;
        target.etSearch = (EditText) Utils.findRequiredViewAsType(source, R.id.etSearch, "field 'etSearch'", EditText.class);
        target.rvSearchResult = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvSearchResult, "field 'rvSearchResult'", RecyclerView.class);
        target.pbLoadingStopData = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.pbLoadingStopData, "field 'pbLoadingStopData'", ProgressBar.class);
        target.tvErrorStopData = (TextView) Utils.findRequiredViewAsType(source, R.id.tvErrorStopData, "field 'tvErrorStopData'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SearchStopsFragment searchStopsFragment = this.target;
        if (searchStopsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        searchStopsFragment.etSearch = null;
        searchStopsFragment.rvSearchResult = null;
        searchStopsFragment.pbLoadingStopData = null;
        searchStopsFragment.tvErrorStopData = null;
    }
}
