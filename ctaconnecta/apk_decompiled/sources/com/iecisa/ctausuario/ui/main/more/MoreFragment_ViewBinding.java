package com.iecisa.ctausuario.ui.main.more;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class MoreFragment_ViewBinding implements Unbinder {
    private MoreFragment target;
    private View view7f0a0088;
    private View view7f0a0089;
    private View view7f0a008a;

    public MoreFragment_ViewBinding(final MoreFragment target, View source) {
        this.target = target;
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.btLabelNews, "field 'btLabelNews' and method 'onEventClick'");
        target.btLabelNews = (MaterialButton) Utils.castView(viewFindRequiredView, R.id.btLabelNews, "field 'btLabelNews'", MaterialButton.class);
        this.view7f0a0088 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.more.MoreFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClick(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.btLabelPrice, "field 'btLabelPrice' and method 'onEventClick'");
        target.btLabelPrice = (MaterialButton) Utils.castView(viewFindRequiredView2, R.id.btLabelPrice, "field 'btLabelPrice'", MaterialButton.class);
        this.view7f0a0089 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.more.MoreFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClick(p0);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.btLabelSettings, "field 'btLabelSettings' and method 'onEventClick'");
        target.btLabelSettings = (MaterialButton) Utils.castView(viewFindRequiredView3, R.id.btLabelSettings, "field 'btLabelSettings'", MaterialButton.class);
        this.view7f0a008a = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.more.MoreFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClick(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MoreFragment moreFragment = this.target;
        if (moreFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        moreFragment.btLabelNews = null;
        moreFragment.btLabelPrice = null;
        moreFragment.btLabelSettings = null;
        this.view7f0a0088.setOnClickListener(null);
        this.view7f0a0088 = null;
        this.view7f0a0089.setOnClickListener(null);
        this.view7f0a0089 = null;
        this.view7f0a008a.setOnClickListener(null);
        this.view7f0a008a = null;
    }
}
