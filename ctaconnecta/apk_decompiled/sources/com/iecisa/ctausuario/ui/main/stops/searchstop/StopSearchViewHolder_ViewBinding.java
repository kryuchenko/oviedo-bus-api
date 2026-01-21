package com.iecisa.ctausuario.ui.main.stops.searchstop;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class StopSearchViewHolder_ViewBinding implements Unbinder {
    private StopSearchViewHolder target;

    public StopSearchViewHolder_ViewBinding(StopSearchViewHolder target, View source) {
        this.target = target;
        target.rowSearchStop = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.rowSearchStop, "field 'rowSearchStop'", ConstraintLayout.class);
        target.tvNameSearchStop = (TextView) Utils.findRequiredViewAsType(source, R.id.tvNameSearchStop, "field 'tvNameSearchStop'", TextView.class);
        target.tvCodeSearchStop = (TextView) Utils.findRequiredViewAsType(source, R.id.tvCodeSearchStop, "field 'tvCodeSearchStop'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StopSearchViewHolder stopSearchViewHolder = this.target;
        if (stopSearchViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        stopSearchViewHolder.rowSearchStop = null;
        stopSearchViewHolder.tvNameSearchStop = null;
        stopSearchViewHolder.tvCodeSearchStop = null;
    }
}
