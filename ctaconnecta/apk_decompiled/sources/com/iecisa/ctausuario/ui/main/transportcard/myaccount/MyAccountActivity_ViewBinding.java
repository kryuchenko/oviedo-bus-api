package com.iecisa.ctausuario.ui.main.transportcard.myaccount;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class MyAccountActivity_ViewBinding implements Unbinder {
    private MyAccountActivity target;
    private View view7f0a0097;
    private View view7f0a0158;
    private TextWatcher view7f0a0158TextWatcher;
    private View view7f0a015f;
    private TextWatcher view7f0a015fTextWatcher;
    private View view7f0a0160;
    private TextWatcher view7f0a0160TextWatcher;
    private View view7f0a0161;
    private TextWatcher view7f0a0161TextWatcher;
    private View view7f0a0165;
    private TextWatcher view7f0a0165TextWatcher;
    private View view7f0a0166;
    private TextWatcher view7f0a0166TextWatcher;
    private View view7f0a0168;
    private TextWatcher view7f0a0168TextWatcher;

    public MyAccountActivity_ViewBinding(MyAccountActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public MyAccountActivity_ViewBinding(final MyAccountActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.tvAdvice = (TextView) Utils.findRequiredViewAsType(source, R.id.tvAdvice, "field 'tvAdvice'", TextView.class);
        target.ivProfile = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivProfile, "field 'ivProfile'", ImageView.class);
        target.tvName = (TextView) Utils.findRequiredViewAsType(source, R.id.tvName, "field 'tvName'", TextView.class);
        target.tvIdentityDocument = (TextView) Utils.findRequiredViewAsType(source, R.id.tvIdentityDocument, "field 'tvIdentityDocument'", TextView.class);
        target.tvDateBirth = (TextView) Utils.findRequiredViewAsType(source, R.id.tvDateBirth, "field 'tvDateBirth'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.etMail, "field 'etMail' and method 'onTextChangedMail'");
        target.etMail = (EditText) Utils.castView(viewFindRequiredView, R.id.etMail, "field 'etMail'", EditText.class);
        this.view7f0a0160 = viewFindRequiredView;
        TextWatcher textWatcher = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity_ViewBinding.1
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
        this.view7f0a0160TextWatcher = textWatcher;
        ((TextView) viewFindRequiredView).addTextChangedListener(textWatcher);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.etMailConfirm, "field 'etMailConfirm' and method 'onTextChangedMailConfirm'");
        target.etMailConfirm = (EditText) Utils.castView(viewFindRequiredView2, R.id.etMailConfirm, "field 'etMailConfirm'", EditText.class);
        this.view7f0a0161 = viewFindRequiredView2;
        TextWatcher textWatcher2 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity_ViewBinding.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedMailConfirm(p0);
            }
        };
        this.view7f0a0161TextWatcher = textWatcher2;
        ((TextView) viewFindRequiredView2).addTextChangedListener(textWatcher2);
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.etPhone, "field 'etPhone' and method 'onTextChangedPhone'");
        target.etPhone = (EditText) Utils.castView(viewFindRequiredView3, R.id.etPhone, "field 'etPhone'", EditText.class);
        this.view7f0a0165 = viewFindRequiredView3;
        TextWatcher textWatcher3 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity_ViewBinding.3
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
        this.view7f0a0165TextWatcher = textWatcher3;
        ((TextView) viewFindRequiredView3).addTextChangedListener(textWatcher3);
        target.etSecondPhone = (EditText) Utils.findRequiredViewAsType(source, R.id.etSecondPhone, "field 'etSecondPhone'", EditText.class);
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.etDirection, "field 'etDirection' and method 'onTextChangedDirection'");
        target.etDirection = (EditText) Utils.castView(viewFindRequiredView4, R.id.etDirection, "field 'etDirection'", EditText.class);
        this.view7f0a0158 = viewFindRequiredView4;
        TextWatcher textWatcher4 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity_ViewBinding.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedDirection(p0);
            }
        };
        this.view7f0a0158TextWatcher = textWatcher4;
        ((TextView) viewFindRequiredView4).addTextChangedListener(textWatcher4);
        View viewFindRequiredView5 = Utils.findRequiredView(source, R.id.etPostalCode, "field 'etPostalCode' and method 'onTextChangedPostalCode'");
        target.etPostalCode = (EditText) Utils.castView(viewFindRequiredView5, R.id.etPostalCode, "field 'etPostalCode'", EditText.class);
        this.view7f0a0166 = viewFindRequiredView5;
        TextWatcher textWatcher5 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity_ViewBinding.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedPostalCode(p0);
            }
        };
        this.view7f0a0166TextWatcher = textWatcher5;
        ((TextView) viewFindRequiredView5).addTextChangedListener(textWatcher5);
        View viewFindRequiredView6 = Utils.findRequiredView(source, R.id.btSave, "field 'btSave' and method 'onViewClicked'");
        target.btSave = (MaterialButton) Utils.castView(viewFindRequiredView6, R.id.btSave, "field 'btSave'", MaterialButton.class);
        this.view7f0a0097 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(source, R.id.etLocation, "field 'etLocation' and method 'onTextChangedLocation'");
        target.etLocation = (EditText) Utils.castView(viewFindRequiredView7, R.id.etLocation, "field 'etLocation'", EditText.class);
        this.view7f0a015f = viewFindRequiredView7;
        TextWatcher textWatcher6 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity_ViewBinding.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedLocation(p0);
            }
        };
        this.view7f0a015fTextWatcher = textWatcher6;
        ((TextView) viewFindRequiredView7).addTextChangedListener(textWatcher6);
        View viewFindRequiredView8 = Utils.findRequiredView(source, R.id.etProvince, "field 'etProvince' and method 'onTextChangedProvince'");
        target.etProvince = (EditText) Utils.castView(viewFindRequiredView8, R.id.etProvince, "field 'etProvince'", EditText.class);
        this.view7f0a0168 = viewFindRequiredView8;
        TextWatcher textWatcher7 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity_ViewBinding.8
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedProvince(p0);
            }
        };
        this.view7f0a0168TextWatcher = textWatcher7;
        ((TextView) viewFindRequiredView8).addTextChangedListener(textWatcher7);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MyAccountActivity myAccountActivity = this.target;
        if (myAccountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        myAccountActivity.toolbar = null;
        myAccountActivity.tvAdvice = null;
        myAccountActivity.ivProfile = null;
        myAccountActivity.tvName = null;
        myAccountActivity.tvIdentityDocument = null;
        myAccountActivity.tvDateBirth = null;
        myAccountActivity.etMail = null;
        myAccountActivity.etMailConfirm = null;
        myAccountActivity.etPhone = null;
        myAccountActivity.etSecondPhone = null;
        myAccountActivity.etDirection = null;
        myAccountActivity.etPostalCode = null;
        myAccountActivity.btSave = null;
        myAccountActivity.etLocation = null;
        myAccountActivity.etProvince = null;
        ((TextView) this.view7f0a0160).removeTextChangedListener(this.view7f0a0160TextWatcher);
        this.view7f0a0160TextWatcher = null;
        this.view7f0a0160 = null;
        ((TextView) this.view7f0a0161).removeTextChangedListener(this.view7f0a0161TextWatcher);
        this.view7f0a0161TextWatcher = null;
        this.view7f0a0161 = null;
        ((TextView) this.view7f0a0165).removeTextChangedListener(this.view7f0a0165TextWatcher);
        this.view7f0a0165TextWatcher = null;
        this.view7f0a0165 = null;
        ((TextView) this.view7f0a0158).removeTextChangedListener(this.view7f0a0158TextWatcher);
        this.view7f0a0158TextWatcher = null;
        this.view7f0a0158 = null;
        ((TextView) this.view7f0a0166).removeTextChangedListener(this.view7f0a0166TextWatcher);
        this.view7f0a0166TextWatcher = null;
        this.view7f0a0166 = null;
        this.view7f0a0097.setOnClickListener(null);
        this.view7f0a0097 = null;
        ((TextView) this.view7f0a015f).removeTextChangedListener(this.view7f0a015fTextWatcher);
        this.view7f0a015fTextWatcher = null;
        this.view7f0a015f = null;
        ((TextView) this.view7f0a0168).removeTextChangedListener(this.view7f0a0168TextWatcher);
        this.view7f0a0168TextWatcher = null;
        this.view7f0a0168 = null;
    }
}
