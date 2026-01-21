package com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class LinesHolder_ViewBinding implements Unbinder {
    private LinesHolder target;

    public LinesHolder_ViewBinding(LinesHolder target, View source) {
        this.target = target;
        target.rowLine = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.rowLine, "field 'rowLine'", ConstraintLayout.class);
        target.tvNameLine = (TextView) Utils.findRequiredViewAsType(source, R.id.tvNameLine, "field 'tvNameLine'", TextView.class);
        target.tvTimeBusToStop = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTimeBusToStop, "field 'tvTimeBusToStop'", TextView.class);
        target.ivRingAlert = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivRingAlert, "field 'ivRingAlert'", ImageView.class);
        target.tvLabelNameCompany = (TextView) Utils.findRequiredViewAsType(source, R.id.tvLabelNameCompany, "field 'tvLabelNameCompany'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LinesHolder linesHolder = this.target;
        if (linesHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        linesHolder.rowLine = null;
        linesHolder.tvNameLine = null;
        linesHolder.tvTimeBusToStop = null;
        linesHolder.ivRingAlert = null;
        linesHolder.tvLabelNameCompany = null;
    }
}
