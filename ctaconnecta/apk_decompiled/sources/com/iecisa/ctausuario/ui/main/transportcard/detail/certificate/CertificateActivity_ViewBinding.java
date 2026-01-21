package com.iecisa.ctausuario.ui.main.transportcard.detail.certificate;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class CertificateActivity_ViewBinding implements Unbinder {
    private CertificateActivity target;
    private View view7f0a00c0;
    private View view7f0a0159;
    private TextWatcher view7f0a0159TextWatcher;
    private View view7f0a0160;
    private TextWatcher view7f0a0160TextWatcher;
    private View view7f0a0163;
    private TextWatcher view7f0a0163TextWatcher;
    private View view7f0a0165;
    private TextWatcher view7f0a0165TextWatcher;
    private View view7f0a016f;
    private TextWatcher view7f0a016fTextWatcher;
    private View view7f0a0261;
    private View view7f0a03e7;
    private TextWatcher view7f0a03e7TextWatcher;
    private View view7f0a03e8;
    private TextWatcher view7f0a03e8TextWatcher;
    private View view7f0a0410;

    public CertificateActivity_ViewBinding(CertificateActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public CertificateActivity_ViewBinding(final CertificateActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.tvErrorMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvErrorMessage, "field 'tvErrorMessage'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.tvDateSince, "field 'tvDateSince', method 'onViewClicked', and method 'onTextChangedDateSince'");
        target.tvDateSince = (TextView) Utils.castView(viewFindRequiredView, R.id.tvDateSince, "field 'tvDateSince'", TextView.class);
        this.view7f0a03e7 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        TextWatcher textWatcher = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity_ViewBinding.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedDateSince(p0);
            }
        };
        this.view7f0a03e7TextWatcher = textWatcher;
        ((TextView) viewFindRequiredView).addTextChangedListener(textWatcher);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvDateTo, "field 'tvDateTo', method 'onViewClicked', and method 'onTextChangedDateTo'");
        target.tvDateTo = (TextView) Utils.castView(viewFindRequiredView2, R.id.tvDateTo, "field 'tvDateTo'", TextView.class);
        this.view7f0a03e8 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        TextWatcher textWatcher2 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity_ViewBinding.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedDateTo(p0);
            }
        };
        this.view7f0a03e8TextWatcher = textWatcher2;
        ((TextView) viewFindRequiredView2).addTextChangedListener(textWatcher2);
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.etName, "field 'etName' and method 'onTextChangedName'");
        target.etName = (EditText) Utils.castView(viewFindRequiredView3, R.id.etName, "field 'etName'", EditText.class);
        this.view7f0a0163 = viewFindRequiredView3;
        TextWatcher textWatcher3 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity_ViewBinding.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedName(p0);
            }
        };
        this.view7f0a0163TextWatcher = textWatcher3;
        ((TextView) viewFindRequiredView3).addTextChangedListener(textWatcher3);
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.etSurname, "field 'etSurname' and method 'onTextChangedSurname'");
        target.etSurname = (EditText) Utils.castView(viewFindRequiredView4, R.id.etSurname, "field 'etSurname'", EditText.class);
        this.view7f0a016f = viewFindRequiredView4;
        TextWatcher textWatcher4 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity_ViewBinding.6
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedSurname(p0);
            }
        };
        this.view7f0a016fTextWatcher = textWatcher4;
        ((TextView) viewFindRequiredView4).addTextChangedListener(textWatcher4);
        View viewFindRequiredView5 = Utils.findRequiredView(source, R.id.etDocument, "field 'etDocument' and method 'onTextChangedDocument'");
        target.etDocument = (EditText) Utils.castView(viewFindRequiredView5, R.id.etDocument, "field 'etDocument'", EditText.class);
        this.view7f0a0159 = viewFindRequiredView5;
        TextWatcher textWatcher5 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity_ViewBinding.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedDocument(p0);
            }
        };
        this.view7f0a0159TextWatcher = textWatcher5;
        ((TextView) viewFindRequiredView5).addTextChangedListener(textWatcher5);
        View viewFindRequiredView6 = Utils.findRequiredView(source, R.id.etPhone, "field 'etPhone' and method 'onTextChangedPhone'");
        target.etPhone = (EditText) Utils.castView(viewFindRequiredView6, R.id.etPhone, "field 'etPhone'", EditText.class);
        this.view7f0a0165 = viewFindRequiredView6;
        TextWatcher textWatcher6 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity_ViewBinding.8
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedPhone(p0);
            }
        };
        this.view7f0a0165TextWatcher = textWatcher6;
        ((TextView) viewFindRequiredView6).addTextChangedListener(textWatcher6);
        View viewFindRequiredView7 = Utils.findRequiredView(source, R.id.etMail, "field 'etMail' and method 'onTextChangedMail'");
        target.etMail = (EditText) Utils.castView(viewFindRequiredView7, R.id.etMail, "field 'etMail'", EditText.class);
        this.view7f0a0160 = viewFindRequiredView7;
        TextWatcher textWatcher7 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity_ViewBinding.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedMail(p0);
            }
        };
        this.view7f0a0160TextWatcher = textWatcher7;
        ((TextView) viewFindRequiredView7).addTextChangedListener(textWatcher7);
        View viewFindRequiredView8 = Utils.findRequiredView(source, R.id.mbRequestCertificate, "field 'mbRequestCertificate' and method 'onViewClicked'");
        target.mbRequestCertificate = (MaterialButton) Utils.castView(viewFindRequiredView8, R.id.mbRequestCertificate, "field 'mbRequestCertificate'", MaterialButton.class);
        this.view7f0a0261 = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        target.rbOffice = (RadioButton) Utils.findRequiredViewAsType(source, R.id.rbOffice, "field 'rbOffice'", RadioButton.class);
        target.spOffice = (Spinner) Utils.findRequiredViewAsType(source, R.id.spOffice, "field 'spOffice'", Spinner.class);
        target.rbAddress = (RadioButton) Utils.findRequiredViewAsType(source, R.id.rbAddress, "field 'rbAddress'", RadioButton.class);
        target.rbMail = (RadioButton) Utils.findRequiredViewAsType(source, R.id.rbMail, "field 'rbMail'", RadioButton.class);
        target.rgDeliverMethod = (RadioGroup) Utils.findRequiredViewAsType(source, R.id.rgDeliverMethod, "field 'rgDeliverMethod'", RadioGroup.class);
        target.gpPersonal = (Group) Utils.findRequiredViewAsType(source, R.id.gpPersonal, "field 'gpPersonal'", Group.class);
        target.gpImpersonal = (Group) Utils.findRequiredViewAsType(source, R.id.gpImpersonal, "field 'gpImpersonal'", Group.class);
        View viewFindRequiredView9 = Utils.findRequiredView(source, R.id.cbAceptTermsPayment, "field 'cbAceptTermsPayment' and method 'onCheckedChanged'");
        target.cbAceptTermsPayment = (CheckBox) Utils.castView(viewFindRequiredView9, R.id.cbAceptTermsPayment, "field 'cbAceptTermsPayment'", CheckBox.class);
        this.view7f0a00c0 = viewFindRequiredView9;
        ((CompoundButton) viewFindRequiredView9).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity_ViewBinding.11
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton p0, boolean p1) {
                target.onCheckedChanged(p1);
            }
        });
        View viewFindRequiredView10 = Utils.findRequiredView(source, R.id.tvLabelAceptTermsPayment, "method 'onViewClicked'");
        this.view7f0a0410 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CertificateActivity certificateActivity = this.target;
        if (certificateActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        certificateActivity.toolbar = null;
        certificateActivity.tvErrorMessage = null;
        certificateActivity.tvDateSince = null;
        certificateActivity.tvDateTo = null;
        certificateActivity.etName = null;
        certificateActivity.etSurname = null;
        certificateActivity.etDocument = null;
        certificateActivity.etPhone = null;
        certificateActivity.etMail = null;
        certificateActivity.mbRequestCertificate = null;
        certificateActivity.rbOffice = null;
        certificateActivity.spOffice = null;
        certificateActivity.rbAddress = null;
        certificateActivity.rbMail = null;
        certificateActivity.rgDeliverMethod = null;
        certificateActivity.gpPersonal = null;
        certificateActivity.gpImpersonal = null;
        certificateActivity.cbAceptTermsPayment = null;
        this.view7f0a03e7.setOnClickListener(null);
        ((TextView) this.view7f0a03e7).removeTextChangedListener(this.view7f0a03e7TextWatcher);
        this.view7f0a03e7TextWatcher = null;
        this.view7f0a03e7 = null;
        this.view7f0a03e8.setOnClickListener(null);
        ((TextView) this.view7f0a03e8).removeTextChangedListener(this.view7f0a03e8TextWatcher);
        this.view7f0a03e8TextWatcher = null;
        this.view7f0a03e8 = null;
        ((TextView) this.view7f0a0163).removeTextChangedListener(this.view7f0a0163TextWatcher);
        this.view7f0a0163TextWatcher = null;
        this.view7f0a0163 = null;
        ((TextView) this.view7f0a016f).removeTextChangedListener(this.view7f0a016fTextWatcher);
        this.view7f0a016fTextWatcher = null;
        this.view7f0a016f = null;
        ((TextView) this.view7f0a0159).removeTextChangedListener(this.view7f0a0159TextWatcher);
        this.view7f0a0159TextWatcher = null;
        this.view7f0a0159 = null;
        ((TextView) this.view7f0a0165).removeTextChangedListener(this.view7f0a0165TextWatcher);
        this.view7f0a0165TextWatcher = null;
        this.view7f0a0165 = null;
        ((TextView) this.view7f0a0160).removeTextChangedListener(this.view7f0a0160TextWatcher);
        this.view7f0a0160TextWatcher = null;
        this.view7f0a0160 = null;
        this.view7f0a0261.setOnClickListener(null);
        this.view7f0a0261 = null;
        ((CompoundButton) this.view7f0a00c0).setOnCheckedChangeListener(null);
        this.view7f0a00c0 = null;
        this.view7f0a0410.setOnClickListener(null);
        this.view7f0a0410 = null;
    }
}
