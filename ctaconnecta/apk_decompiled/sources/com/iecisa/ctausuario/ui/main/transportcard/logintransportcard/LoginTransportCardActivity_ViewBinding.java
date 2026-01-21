package com.iecisa.ctausuario.ui.main.transportcard.logintransportcard;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class LoginTransportCardActivity_ViewBinding implements Unbinder {
    private LoginTransportCardActivity target;
    private View view7f0a0155;
    private TextWatcher view7f0a0155TextWatcher;
    private View view7f0a0156;
    private TextWatcher view7f0a0156TextWatcher;
    private View view7f0a0255;
    private View view7f0a0450;

    public LoginTransportCardActivity_ViewBinding(LoginTransportCardActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public LoginTransportCardActivity_ViewBinding(final LoginTransportCardActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.etCardNumber, "field 'etCardNumber' and method 'onTextChangedCardNumber'");
        target.etCardNumber = (EditText) Utils.castView(viewFindRequiredView, R.id.etCardNumber, "field 'etCardNumber'", EditText.class);
        this.view7f0a0155 = viewFindRequiredView;
        TextWatcher textWatcher = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardActivity_ViewBinding.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedCardNumber();
            }
        };
        this.view7f0a0155TextWatcher = textWatcher;
        ((TextView) viewFindRequiredView).addTextChangedListener(textWatcher);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.etCharacter, "field 'etCharacter' and method 'onTextChangedCharacter'");
        target.etCharacter = (EditText) Utils.castView(viewFindRequiredView2, R.id.etCharacter, "field 'etCharacter'", EditText.class);
        this.view7f0a0156 = viewFindRequiredView2;
        TextWatcher textWatcher2 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardActivity_ViewBinding.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedCharacter();
            }
        };
        this.view7f0a0156TextWatcher = textWatcher2;
        ((TextView) viewFindRequiredView2).addTextChangedListener(textWatcher2);
        target.tvInfoMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoMessage, "field 'tvInfoMessage'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.mbLogin, "field 'mbLogin' and method 'onViewClicked'");
        target.mbLogin = (TextView) Utils.castView(viewFindRequiredView3, R.id.mbLogin, "field 'mbLogin'", TextView.class);
        this.view7f0a0255 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.tvLogin, "method 'onViewClicked'");
        this.view7f0a0450 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LoginTransportCardActivity loginTransportCardActivity = this.target;
        if (loginTransportCardActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        loginTransportCardActivity.toolbar = null;
        loginTransportCardActivity.etCardNumber = null;
        loginTransportCardActivity.etCharacter = null;
        loginTransportCardActivity.tvInfoMessage = null;
        loginTransportCardActivity.mbLogin = null;
        ((TextView) this.view7f0a0155).removeTextChangedListener(this.view7f0a0155TextWatcher);
        this.view7f0a0155TextWatcher = null;
        this.view7f0a0155 = null;
        ((TextView) this.view7f0a0156).removeTextChangedListener(this.view7f0a0156TextWatcher);
        this.view7f0a0156TextWatcher = null;
        this.view7f0a0156 = null;
        this.view7f0a0255.setOnClickListener(null);
        this.view7f0a0255 = null;
        this.view7f0a0450.setOnClickListener(null);
        this.view7f0a0450 = null;
    }
}
