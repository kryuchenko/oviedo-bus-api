package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class TransportCardContinueRequestActivity_ViewBinding implements Unbinder {
    private TransportCardContinueRequestActivity target;

    public TransportCardContinueRequestActivity_ViewBinding(TransportCardContinueRequestActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public TransportCardContinueRequestActivity_ViewBinding(TransportCardContinueRequestActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.tvInfoMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoMessage, "field 'tvInfoMessage'", TextView.class);
        target.rvPendingRequests = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvPendingRequests, "field 'rvPendingRequests'", RecyclerView.class);
        target.tvLabelRequestNumber = (TextView) Utils.findRequiredViewAsType(source, R.id.tvLabelRequestNumber, "field 'tvLabelRequestNumber'", TextView.class);
        target.tvNoPendingRequests = (TextView) Utils.findRequiredViewAsType(source, R.id.tvNoPendingRequests, "field 'tvNoPendingRequests'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TransportCardContinueRequestActivity transportCardContinueRequestActivity = this.target;
        if (transportCardContinueRequestActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        transportCardContinueRequestActivity.toolbar = null;
        transportCardContinueRequestActivity.tvInfoMessage = null;
        transportCardContinueRequestActivity.rvPendingRequests = null;
        transportCardContinueRequestActivity.tvLabelRequestNumber = null;
        transportCardContinueRequestActivity.tvNoPendingRequests = null;
    }
}
