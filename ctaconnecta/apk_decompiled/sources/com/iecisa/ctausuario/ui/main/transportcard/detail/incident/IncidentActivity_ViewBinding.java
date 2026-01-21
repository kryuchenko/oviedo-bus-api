package com.iecisa.ctausuario.ui.main.transportcard.detail.incident;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class IncidentActivity_ViewBinding implements Unbinder {
    private IncidentActivity target;

    public IncidentActivity_ViewBinding(IncidentActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public IncidentActivity_ViewBinding(IncidentActivity target, View source) {
        this.target = target;
        target.container = (FrameLayout) Utils.findRequiredViewAsType(source, R.id.container, "field 'container'", FrameLayout.class);
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        IncidentActivity incidentActivity = this.target;
        if (incidentActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        incidentActivity.container = null;
        incidentActivity.toolbar = null;
    }
}
