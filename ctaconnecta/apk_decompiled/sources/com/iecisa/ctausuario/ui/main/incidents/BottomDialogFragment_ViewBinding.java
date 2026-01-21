package com.iecisa.ctausuario.ui.main.incidents;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class BottomDialogFragment_ViewBinding implements Unbinder {
    private BottomDialogFragment target;
    private View view7f0a024e;
    private View view7f0a0253;

    public BottomDialogFragment_ViewBinding(final BottomDialogFragment target, View source) {
        this.target = target;
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.mbCamera, "method 'onViewClicked'");
        this.view7f0a024e = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.BottomDialogFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.mbGallery, "method 'onViewClicked'");
        this.view7f0a0253 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.BottomDialogFragment_ViewBinding.2
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
        this.view7f0a024e.setOnClickListener(null);
        this.view7f0a024e = null;
        this.view7f0a0253.setOnClickListener(null);
        this.view7f0a0253 = null;
    }
}
