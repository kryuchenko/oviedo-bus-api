package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class TransportCardRequestInfoActivity_ViewBinding implements Unbinder {
    private TransportCardRequestInfoActivity target;
    private View view7f0a0099;
    private View view7f0a00bd;
    private View view7f0a01e9;
    private View view7f0a03f3;
    private View view7f0a040f;
    private View view7f0a0466;
    private View view7f0a047b;

    public TransportCardRequestInfoActivity_ViewBinding(TransportCardRequestInfoActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public TransportCardRequestInfoActivity_ViewBinding(final TransportCardRequestInfoActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.tvTextIntro = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTextIntro, "field 'tvTextIntro'", TextView.class);
        target.tvTextRepresentativeIntro = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTextRepresentativeIntro, "field 'tvTextRepresentativeIntro'", TextView.class);
        target.tvLabelRepresentative = (TextView) Utils.findRequiredViewAsType(source, R.id.tvLabelRepresentative, "field 'tvLabelRepresentative'", TextView.class);
        target.tvLabelRepresentativeIntro2 = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTextRepresentativeIntro2, "field 'tvLabelRepresentativeIntro2'", TextView.class);
        target.tvTextRepresentative = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTextRepresentative, "field 'tvTextRepresentative'", TextView.class);
        target.gpNfcSupported = (Group) Utils.findRequiredViewAsType(source, R.id.gpNfcSupported, "field 'gpNfcSupported'", Group.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.tvOtherId, "field 'tvOtherId' and method 'onViewClicked'");
        target.tvOtherId = (TextView) Utils.castView(viewFindRequiredView, R.id.tvOtherId, "field 'tvOtherId'", TextView.class);
        this.view7f0a0466 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvDni30, "field 'tvDni30' and method 'onViewClicked'");
        target.tvDni30 = (TextView) Utils.castView(viewFindRequiredView2, R.id.tvDni30, "field 'tvDni30'", TextView.class);
        this.view7f0a03f3 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.tvShowDni30, "field 'tvShowDni30' and method 'onViewClicked'");
        target.tvShowDni30 = (TextView) Utils.castView(viewFindRequiredView3, R.id.tvShowDni30, "field 'tvShowDni30'", TextView.class);
        this.view7f0a047b = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        target.clPopupDni30 = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.clPopupDni30, "field 'clPopupDni30'", ConstraintLayout.class);
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.ivClosePopupDni30, "field 'ivClosePopupDni30' and method 'onViewClicked'");
        target.ivClosePopupDni30 = (ImageView) Utils.castView(viewFindRequiredView4, R.id.ivClosePopupDni30, "field 'ivClosePopupDni30'", ImageView.class);
        this.view7f0a01e9 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(source, R.id.cbAcceptCardRequestTerms, "field 'cbAcceptCardRequestTerms' and method 'onCheckedChanged'");
        target.cbAcceptCardRequestTerms = (CheckBox) Utils.castView(viewFindRequiredView5, R.id.cbAcceptCardRequestTerms, "field 'cbAcceptCardRequestTerms'", CheckBox.class);
        this.view7f0a00bd = viewFindRequiredView5;
        ((CompoundButton) viewFindRequiredView5).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity_ViewBinding.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton p0, boolean p1) {
                target.onCheckedChanged(p1);
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(source, R.id.tvLabelAceptTermsCardRequest, "field 'tvLabelAceptTermsCardRequest' and method 'onViewClicked'");
        target.tvLabelAceptTermsCardRequest = (TextView) Utils.castView(viewFindRequiredView6, R.id.tvLabelAceptTermsCardRequest, "field 'tvLabelAceptTermsCardRequest'", TextView.class);
        this.view7f0a040f = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(source, R.id.btStartCardRequest, "field 'btStartCardRequest' and method 'onViewClicked'");
        target.btStartCardRequest = (MaterialButton) Utils.castView(viewFindRequiredView7, R.id.btStartCardRequest, "field 'btStartCardRequest'", MaterialButton.class);
        this.view7f0a0099 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TransportCardRequestInfoActivity transportCardRequestInfoActivity = this.target;
        if (transportCardRequestInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        transportCardRequestInfoActivity.toolbar = null;
        transportCardRequestInfoActivity.tvTextIntro = null;
        transportCardRequestInfoActivity.tvTextRepresentativeIntro = null;
        transportCardRequestInfoActivity.tvLabelRepresentative = null;
        transportCardRequestInfoActivity.tvLabelRepresentativeIntro2 = null;
        transportCardRequestInfoActivity.tvTextRepresentative = null;
        transportCardRequestInfoActivity.gpNfcSupported = null;
        transportCardRequestInfoActivity.tvOtherId = null;
        transportCardRequestInfoActivity.tvDni30 = null;
        transportCardRequestInfoActivity.tvShowDni30 = null;
        transportCardRequestInfoActivity.clPopupDni30 = null;
        transportCardRequestInfoActivity.ivClosePopupDni30 = null;
        transportCardRequestInfoActivity.cbAcceptCardRequestTerms = null;
        transportCardRequestInfoActivity.tvLabelAceptTermsCardRequest = null;
        transportCardRequestInfoActivity.btStartCardRequest = null;
        this.view7f0a0466.setOnClickListener(null);
        this.view7f0a0466 = null;
        this.view7f0a03f3.setOnClickListener(null);
        this.view7f0a03f3 = null;
        this.view7f0a047b.setOnClickListener(null);
        this.view7f0a047b = null;
        this.view7f0a01e9.setOnClickListener(null);
        this.view7f0a01e9 = null;
        ((CompoundButton) this.view7f0a00bd).setOnCheckedChangeListener(null);
        this.view7f0a00bd = null;
        this.view7f0a040f.setOnClickListener(null);
        this.view7f0a040f = null;
        this.view7f0a0099.setOnClickListener(null);
        this.view7f0a0099 = null;
    }
}
