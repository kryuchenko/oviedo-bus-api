package com.iecisa.ctausuario.ui.main.transportcard;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class TransportCardFragment_ViewBinding implements Unbinder {
    private TransportCardFragment target;
    private View view7f0a0087;
    private View view7f0a0094;
    private View view7f0a0096;

    public TransportCardFragment_ViewBinding(final TransportCardFragment target, View source) {
        this.target = target;
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.btPersonalCard, "method 'onViewClicked'");
        this.view7f0a0094 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.TransportCardFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.btImpersonalCard, "method 'onViewClicked'");
        this.view7f0a0087 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.TransportCardFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.btRequestCard, "method 'onViewClicked'");
        this.view7f0a0096 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.TransportCardFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        if (this.target == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        this.view7f0a0094.setOnClickListener(null);
        this.view7f0a0094 = null;
        this.view7f0a0087.setOnClickListener(null);
        this.view7f0a0087 = null;
        this.view7f0a0096.setOnClickListener(null);
        this.view7f0a0096 = null;
    }
}
