package com.iecisa.ctausuario.ui.main.transportcard.accesssettings;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class AccessSettingsActivity_ViewBinding implements Unbinder {
    private AccessSettingsActivity target;
    private View view7f0a014f;
    private TextWatcher view7f0a014fTextWatcher;
    private View view7f0a0164;
    private TextWatcher view7f0a0164TextWatcher;
    private View view7f0a016c;
    private TextWatcher view7f0a016cTextWatcher;
    private View view7f0a0250;
    private View view7f0a037d;

    public AccessSettingsActivity_ViewBinding(AccessSettingsActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public AccessSettingsActivity_ViewBinding(final AccessSettingsActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.swFingerPrint, "field 'swFingerPrint' and method 'onCheckedChanged'");
        target.swFingerPrint = (Switch) Utils.castView(viewFindRequiredView, R.id.swFingerPrint, "field 'swFingerPrint'", Switch.class);
        this.view7f0a037d = viewFindRequiredView;
        ((CompoundButton) viewFindRequiredView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity_ViewBinding.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton p0, boolean p1) {
                target.onCheckedChanged(p1);
            }
        });
        target.vwSeparator = Utils.findRequiredView(source, R.id.vSeparator, "field 'vwSeparator'");
        target.tvLabelActualPwd = (TextView) Utils.findRequiredViewAsType(source, R.id.tvLabelActualPwd, "field 'tvLabelActualPwd'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.etActualPwd, "field 'etActualPwd' and method 'onTextChangedActualPwd'");
        target.etActualPwd = (EditText) Utils.castView(viewFindRequiredView2, R.id.etActualPwd, "field 'etActualPwd'", EditText.class);
        this.view7f0a014f = viewFindRequiredView2;
        TextWatcher textWatcher = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity_ViewBinding.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedActualPwd(p0);
            }
        };
        this.view7f0a014fTextWatcher = textWatcher;
        ((TextView) viewFindRequiredView2).addTextChangedListener(textWatcher);
        target.tilActualPwd = (TextInputLayout) Utils.findRequiredViewAsType(source, R.id.tilActualPwd, "field 'tilActualPwd'", TextInputLayout.class);
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.etNewPwd, "field 'etNewPwd' and method 'onTextChangedNewPwd'");
        target.etNewPwd = (EditText) Utils.castView(viewFindRequiredView3, R.id.etNewPwd, "field 'etNewPwd'", EditText.class);
        this.view7f0a0164 = viewFindRequiredView3;
        TextWatcher textWatcher2 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity_ViewBinding.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedNewPwd(p0);
            }
        };
        this.view7f0a0164TextWatcher = textWatcher2;
        ((TextView) viewFindRequiredView3).addTextChangedListener(textWatcher2);
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.etRepeatPwd, "field 'etRepeatPwd' and method 'onTextChangedRepeatPwd'");
        target.etRepeatPwd = (EditText) Utils.castView(viewFindRequiredView4, R.id.etRepeatPwd, "field 'etRepeatPwd'", EditText.class);
        this.view7f0a016c = viewFindRequiredView4;
        TextWatcher textWatcher3 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity_ViewBinding.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedRepeatPwd(p0);
            }
        };
        this.view7f0a016cTextWatcher = textWatcher3;
        ((TextView) viewFindRequiredView4).addTextChangedListener(textWatcher3);
        target.tvErrorMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvErrorMessage, "field 'tvErrorMessage'", TextView.class);
        target.tvLastLogin = (TextView) Utils.findRequiredViewAsType(source, R.id.tvLastLogin, "field 'tvLastLogin'", TextView.class);
        View viewFindRequiredView5 = Utils.findRequiredView(source, R.id.mbChangePass, "field 'mbChangePass' and method 'onViewClicked'");
        target.mbChangePass = (MaterialButton) Utils.castView(viewFindRequiredView5, R.id.mbChangePass, "field 'mbChangePass'", MaterialButton.class);
        this.view7f0a0250 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AccessSettingsActivity accessSettingsActivity = this.target;
        if (accessSettingsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        accessSettingsActivity.toolbar = null;
        accessSettingsActivity.swFingerPrint = null;
        accessSettingsActivity.vwSeparator = null;
        accessSettingsActivity.tvLabelActualPwd = null;
        accessSettingsActivity.etActualPwd = null;
        accessSettingsActivity.tilActualPwd = null;
        accessSettingsActivity.etNewPwd = null;
        accessSettingsActivity.etRepeatPwd = null;
        accessSettingsActivity.tvErrorMessage = null;
        accessSettingsActivity.tvLastLogin = null;
        accessSettingsActivity.mbChangePass = null;
        ((CompoundButton) this.view7f0a037d).setOnCheckedChangeListener(null);
        this.view7f0a037d = null;
        ((TextView) this.view7f0a014f).removeTextChangedListener(this.view7f0a014fTextWatcher);
        this.view7f0a014fTextWatcher = null;
        this.view7f0a014f = null;
        ((TextView) this.view7f0a0164).removeTextChangedListener(this.view7f0a0164TextWatcher);
        this.view7f0a0164TextWatcher = null;
        this.view7f0a0164 = null;
        ((TextView) this.view7f0a016c).removeTextChangedListener(this.view7f0a016cTextWatcher);
        this.view7f0a016cTextWatcher = null;
        this.view7f0a016c = null;
        this.view7f0a0250.setOnClickListener(null);
        this.view7f0a0250 = null;
    }
}
