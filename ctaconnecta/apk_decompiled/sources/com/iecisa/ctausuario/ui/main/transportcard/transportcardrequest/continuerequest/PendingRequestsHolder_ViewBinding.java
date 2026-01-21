package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class PendingRequestsHolder_ViewBinding implements Unbinder {
    private PendingRequestsHolder target;

    public PendingRequestsHolder_ViewBinding(PendingRequestsHolder target, View source) {
        this.target = target;
        target.tvRequestDateTime = (TextView) Utils.findRequiredViewAsType(source, R.id.tvRequestDateTime, "field 'tvRequestDateTime'", TextView.class);
        target.tvRequestNumber = (TextView) Utils.findRequiredViewAsType(source, R.id.tvRequestNumber, "field 'tvRequestNumber'", TextView.class);
        target.rowLine = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.rowTransportCardRequest, "field 'rowLine'", ConstraintLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PendingRequestsHolder pendingRequestsHolder = this.target;
        if (pendingRequestsHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        pendingRequestsHolder.tvRequestDateTime = null;
        pendingRequestsHolder.tvRequestNumber = null;
        pendingRequestsHolder.rowLine = null;
    }
}
