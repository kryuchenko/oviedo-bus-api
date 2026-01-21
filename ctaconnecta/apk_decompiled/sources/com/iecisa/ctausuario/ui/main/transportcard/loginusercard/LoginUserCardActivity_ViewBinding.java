package com.iecisa.ctausuario.ui.main.transportcard.loginusercard;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class LoginUserCardActivity_ViewBinding implements Unbinder {
    private LoginUserCardActivity target;
    private View view7f0a008b;
    private View view7f0a0169;
    private TextWatcher view7f0a0169TextWatcher;
    private View view7f0a0171;
    private TextWatcher view7f0a0171TextWatcher;
    private View view7f0a0252;
    private View view7f0a0256;

    public LoginUserCardActivity_ViewBinding(LoginUserCardActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public LoginUserCardActivity_ViewBinding(final LoginUserCardActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.etUsername, "field 'etUserName' and method 'onTextChangedCardNumber'");
        target.etUserName = (TextInputEditText) Utils.castView(viewFindRequiredView, R.id.etUsername, "field 'etUserName'", TextInputEditText.class);
        this.view7f0a0171 = viewFindRequiredView;
        TextWatcher textWatcher = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity_ViewBinding.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedCardNumber(p0);
            }
        };
        this.view7f0a0171TextWatcher = textWatcher;
        ((TextView) viewFindRequiredView).addTextChangedListener(textWatcher);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.etPwd, "field 'etPwd' and method 'onTextChangedCharacter'");
        target.etPwd = (TextInputEditText) Utils.castView(viewFindRequiredView2, R.id.etPwd, "field 'etPwd'", TextInputEditText.class);
        this.view7f0a0169 = viewFindRequiredView2;
        TextWatcher textWatcher2 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity_ViewBinding.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedCharacter(p0);
            }
        };
        this.view7f0a0169TextWatcher = textWatcher2;
        ((TextView) viewFindRequiredView2).addTextChangedListener(textWatcher2);
        target.tvErrorMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvErrorMessage, "field 'tvErrorMessage'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.btLogin, "field 'btLogin' and method 'onViewClicked'");
        target.btLogin = (MaterialButton) Utils.castView(viewFindRequiredView3, R.id.btLogin, "field 'btLogin'", MaterialButton.class);
        this.view7f0a008b = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.mbLoginPrint, "field 'mbLoginPrint' and method 'onViewClicked'");
        target.mbLoginPrint = (MaterialButton) Utils.castView(viewFindRequiredView4, R.id.mbLoginPrint, "field 'mbLoginPrint'", MaterialButton.class);
        this.view7f0a0256 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(source, R.id.mbForgotPwd, "field 'mbForgotPwd' and method 'onViewClicked'");
        target.mbForgotPwd = (MaterialButton) Utils.castView(viewFindRequiredView5, R.id.mbForgotPwd, "field 'mbForgotPwd'", MaterialButton.class);
        this.view7f0a0252 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LoginUserCardActivity loginUserCardActivity = this.target;
        if (loginUserCardActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        loginUserCardActivity.toolbar = null;
        loginUserCardActivity.etUserName = null;
        loginUserCardActivity.etPwd = null;
        loginUserCardActivity.tvErrorMessage = null;
        loginUserCardActivity.btLogin = null;
        loginUserCardActivity.mbLoginPrint = null;
        loginUserCardActivity.mbForgotPwd = null;
        ((TextView) this.view7f0a0171).removeTextChangedListener(this.view7f0a0171TextWatcher);
        this.view7f0a0171TextWatcher = null;
        this.view7f0a0171 = null;
        ((TextView) this.view7f0a0169).removeTextChangedListener(this.view7f0a0169TextWatcher);
        this.view7f0a0169TextWatcher = null;
        this.view7f0a0169 = null;
        this.view7f0a008b.setOnClickListener(null);
        this.view7f0a008b = null;
        this.view7f0a0256.setOnClickListener(null);
        this.view7f0a0256 = null;
        this.view7f0a0252.setOnClickListener(null);
        this.view7f0a0252 = null;
    }
}
