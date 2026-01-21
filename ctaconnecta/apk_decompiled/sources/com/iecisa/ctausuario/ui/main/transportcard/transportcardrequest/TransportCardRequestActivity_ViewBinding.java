package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class TransportCardRequestActivity_ViewBinding implements Unbinder {
    private TransportCardRequestActivity target;
    private View view7f0a0082;
    private View view7f0a008d;
    private View view7f0a008e;

    public TransportCardRequestActivity_ViewBinding(TransportCardRequestActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public TransportCardRequestActivity_ViewBinding(final TransportCardRequestActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.btNewCardRequest, "field 'btNewCardRequest' and method 'onViewClicked'");
        target.btNewCardRequest = (MaterialButton) Utils.castView(viewFindRequiredView, R.id.btNewCardRequest, "field 'btNewCardRequest'", MaterialButton.class);
        this.view7f0a008d = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.TransportCardRequestActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.btContinueCardRequest, "field 'btContinueCardRequest' and method 'onViewClicked'");
        target.btContinueCardRequest = (MaterialButton) Utils.castView(viewFindRequiredView2, R.id.btContinueCardRequest, "field 'btContinueCardRequest'", MaterialButton.class);
        this.view7f0a0082 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.TransportCardRequestActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.btNewRepresentativeRequest, "method 'onViewClicked'");
        this.view7f0a008e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.TransportCardRequestActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TransportCardRequestActivity transportCardRequestActivity = this.target;
        if (transportCardRequestActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        transportCardRequestActivity.toolbar = null;
        transportCardRequestActivity.btNewCardRequest = null;
        transportCardRequestActivity.btContinueCardRequest = null;
        this.view7f0a008d.setOnClickListener(null);
        this.view7f0a008d = null;
        this.view7f0a0082.setOnClickListener(null);
        this.view7f0a0082 = null;
        this.view7f0a008e.setOnClickListener(null);
        this.view7f0a008e = null;
    }
}
