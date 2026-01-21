package com.iecisa.ctausuario.ui.main.linesrealtime.lineslist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class StopLineHolder_ViewBinding implements Unbinder {
    private StopLineHolder target;

    public StopLineHolder_ViewBinding(StopLineHolder target, View source) {
        this.target = target;
        target.rowStopsLine = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.rowStopsLine, "field 'rowStopsLine'", ConstraintLayout.class);
        target.tvTimeFromStop = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTimeFromStop, "field 'tvTimeFromStop'", TextView.class);
        target.ivStopCircle = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivStopCircle, "field 'ivStopCircle'", ImageView.class);
        target.tvNameStop = (TextView) Utils.findRequiredViewAsType(source, R.id.tvNameStop, "field 'tvNameStop'", TextView.class);
        target.ivLocationUserStop = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivLocationUserStop, "field 'ivLocationUserStop'", ImageView.class);
        target.vTop = Utils.findRequiredView(source, R.id.vTop, "field 'vTop'");
        target.vBottom = Utils.findRequiredView(source, R.id.vBottom, "field 'vBottom'");
        target.hBus = Utils.findRequiredView(source, R.id.hBus, "field 'hBus'");
        target.busInfoContainer = Utils.findRequiredView(source, R.id.busInfoContainer, "field 'busInfoContainer'");
        target.spacerhBus = Utils.findRequiredView(source, R.id.spacerhBus, "field 'spacerhBus'");
        target.dividerBusNumber = (TextView) Utils.findRequiredViewAsType(source, R.id.dividerBusNumber, "field 'dividerBusNumber'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StopLineHolder stopLineHolder = this.target;
        if (stopLineHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        stopLineHolder.rowStopsLine = null;
        stopLineHolder.tvTimeFromStop = null;
        stopLineHolder.ivStopCircle = null;
        stopLineHolder.tvNameStop = null;
        stopLineHolder.ivLocationUserStop = null;
        stopLineHolder.vTop = null;
        stopLineHolder.vBottom = null;
        stopLineHolder.hBus = null;
        stopLineHolder.busInfoContainer = null;
        stopLineHolder.spacerhBus = null;
        stopLineHolder.dividerBusNumber = null;
    }
}
