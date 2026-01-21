package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.identification;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class TransportCardRequestIdentificationActivity_ViewBinding implements Unbinder {
    private TransportCardRequestIdentificationActivity target;
    private View view7f0a0082;

    public TransportCardRequestIdentificationActivity_ViewBinding(TransportCardRequestIdentificationActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public TransportCardRequestIdentificationActivity_ViewBinding(final TransportCardRequestIdentificationActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.tvUserId = (TextView) Utils.findRequiredViewAsType(source, R.id.tvUserId, "field 'tvUserId'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.btContinueCardRequest, "method 'onViewClicked'");
        this.view7f0a0082 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.identification.TransportCardRequestIdentificationActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TransportCardRequestIdentificationActivity transportCardRequestIdentificationActivity = this.target;
        if (transportCardRequestIdentificationActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        transportCardRequestIdentificationActivity.toolbar = null;
        transportCardRequestIdentificationActivity.tvUserId = null;
        this.view7f0a0082.setOnClickListener(null);
        this.view7f0a0082 = null;
    }
}
