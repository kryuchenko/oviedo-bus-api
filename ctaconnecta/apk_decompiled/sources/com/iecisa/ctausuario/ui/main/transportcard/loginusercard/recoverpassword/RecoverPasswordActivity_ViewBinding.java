package com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class RecoverPasswordActivity_ViewBinding implements Unbinder {
    private RecoverPasswordActivity target;
    private View view7f0a0090;
    private View view7f0a0160;
    private TextWatcher view7f0a0160TextWatcher;

    public RecoverPasswordActivity_ViewBinding(RecoverPasswordActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public RecoverPasswordActivity_ViewBinding(final RecoverPasswordActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.etMail, "field 'etMail' and method 'onTextChangedCardNumber'");
        target.etMail = (EditText) Utils.castView(viewFindRequiredView, R.id.etMail, "field 'etMail'", EditText.class);
        this.view7f0a0160 = viewFindRequiredView;
        TextWatcher textWatcher = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordActivity_ViewBinding.1
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
        this.view7f0a0160TextWatcher = textWatcher;
        ((TextView) viewFindRequiredView).addTextChangedListener(textWatcher);
        target.tvErrorMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvErrorMessage, "field 'tvErrorMessage'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.btOk, "field 'btOk' and method 'onViewClicked'");
        target.btOk = (MaterialButton) Utils.castView(viewFindRequiredView2, R.id.btOk, "field 'btOk'", MaterialButton.class);
        this.view7f0a0090 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RecoverPasswordActivity recoverPasswordActivity = this.target;
        if (recoverPasswordActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        recoverPasswordActivity.toolbar = null;
        recoverPasswordActivity.etMail = null;
        recoverPasswordActivity.tvErrorMessage = null;
        recoverPasswordActivity.btOk = null;
        ((TextView) this.view7f0a0160).removeTextChangedListener(this.view7f0a0160TextWatcher);
        this.view7f0a0160TextWatcher = null;
        this.view7f0a0160 = null;
        this.view7f0a0090.setOnClickListener(null);
        this.view7f0a0090 = null;
    }
}
