package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class LegalRepresentativeActivity_ViewBinding implements Unbinder {
    private LegalRepresentativeActivity target;
    private View view7f0a009a;
    private View view7f0a00be;
    private View view7f0a0411;

    public LegalRepresentativeActivity_ViewBinding(LegalRepresentativeActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public LegalRepresentativeActivity_ViewBinding(final LegalRepresentativeActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.cbAcceptRepresentativeRequestTerms, "field 'cbAcceptRepresentativeRequestTerms' and method 'onCheckedChanged'");
        target.cbAcceptRepresentativeRequestTerms = (CheckBox) Utils.castView(viewFindRequiredView, R.id.cbAcceptRepresentativeRequestTerms, "field 'cbAcceptRepresentativeRequestTerms'", CheckBox.class);
        this.view7f0a00be = viewFindRequiredView;
        ((CompoundButton) viewFindRequiredView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeActivity_ViewBinding.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton p0, boolean p1) {
                target.onCheckedChanged(p1);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvLabelAceptTermsRepresentativeRequest, "field 'tvLabelAceptTermsRepresentativeRequest' and method 'onViewClicked'");
        target.tvLabelAceptTermsRepresentativeRequest = (TextView) Utils.castView(viewFindRequiredView2, R.id.tvLabelAceptTermsRepresentativeRequest, "field 'tvLabelAceptTermsRepresentativeRequest'", TextView.class);
        this.view7f0a0411 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.btStartRepresentativeRequest, "field 'btStartRepresentativeRequest' and method 'onViewClicked'");
        target.btStartRepresentativeRequest = (MaterialButton) Utils.castView(viewFindRequiredView3, R.id.btStartRepresentativeRequest, "field 'btStartRepresentativeRequest'", MaterialButton.class);
        this.view7f0a009a = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LegalRepresentativeActivity legalRepresentativeActivity = this.target;
        if (legalRepresentativeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        legalRepresentativeActivity.toolbar = null;
        legalRepresentativeActivity.cbAcceptRepresentativeRequestTerms = null;
        legalRepresentativeActivity.tvLabelAceptTermsRepresentativeRequest = null;
        legalRepresentativeActivity.btStartRepresentativeRequest = null;
        ((CompoundButton) this.view7f0a00be).setOnCheckedChangeListener(null);
        this.view7f0a00be = null;
        this.view7f0a0411.setOnClickListener(null);
        this.view7f0a0411 = null;
        this.view7f0a009a.setOnClickListener(null);
        this.view7f0a009a = null;
    }
}
