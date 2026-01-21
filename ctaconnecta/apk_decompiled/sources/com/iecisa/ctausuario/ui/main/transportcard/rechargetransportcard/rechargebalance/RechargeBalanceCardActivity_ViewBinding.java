package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class RechargeBalanceCardActivity_ViewBinding implements Unbinder {
    private RechargeBalanceCardActivity target;
    private View view7f0a007b;
    private View view7f0a008c;
    private View view7f0a0091;
    private View view7f0a0092;
    private View view7f0a0093;
    private View view7f0a00c0;
    private View view7f0a015a;
    private TextWatcher view7f0a015aTextWatcher;
    private View view7f0a0167;
    private TextWatcher view7f0a0167TextWatcher;
    private View view7f0a016b;
    private TextWatcher view7f0a016bTextWatcher;
    private View view7f0a0410;

    public RechargeBalanceCardActivity_ViewBinding(RechargeBalanceCardActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public RechargeBalanceCardActivity_ViewBinding(final RechargeBalanceCardActivity target, View source) {
        this.target = target;
        target.tvInfoMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoMessage, "field 'tvInfoMessage'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.etPrice, "field 'etPrice', method 'onFocusChanged', and method 'onTextChangedPrice'");
        target.etPrice = (EditText) Utils.castView(viewFindRequiredView, R.id.etPrice, "field 'etPrice'", EditText.class);
        this.view7f0a0167 = viewFindRequiredView;
        viewFindRequiredView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity_ViewBinding.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View p0, boolean p1) {
                target.onFocusChanged(p0, p1);
            }
        });
        TextWatcher textWatcher = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity_ViewBinding.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedPrice(p0);
            }
        };
        this.view7f0a0167TextWatcher = textWatcher;
        ((TextView) viewFindRequiredView).addTextChangedListener(textWatcher);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.etEmailSend, "field 'etEmailSend', method 'onFocusChanged', and method 'onTextChangedMail'");
        target.etEmailSend = (EditText) Utils.castView(viewFindRequiredView2, R.id.etEmailSend, "field 'etEmailSend'", EditText.class);
        this.view7f0a015a = viewFindRequiredView2;
        viewFindRequiredView2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity_ViewBinding.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View p0, boolean p1) {
                target.onFocusChanged(p0, p1);
            }
        });
        TextWatcher textWatcher2 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity_ViewBinding.4
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
        this.view7f0a015aTextWatcher = textWatcher2;
        ((TextView) viewFindRequiredView2).addTextChangedListener(textWatcher2);
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.etRepeatEmail, "field 'etRepeatEmail', method 'onFocusChanged', and method 'onTextChangedRepeatMail'");
        target.etRepeatEmail = (EditText) Utils.castView(viewFindRequiredView3, R.id.etRepeatEmail, "field 'etRepeatEmail'", EditText.class);
        this.view7f0a016b = viewFindRequiredView3;
        viewFindRequiredView3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity_ViewBinding.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View p0, boolean p1) {
                target.onFocusChanged(p0, p1);
            }
        });
        TextWatcher textWatcher3 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity_ViewBinding.6
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedRepeatMail(p0);
            }
        };
        this.view7f0a016bTextWatcher = textWatcher3;
        ((TextView) viewFindRequiredView3).addTextChangedListener(textWatcher3);
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.cbAceptTermsPayment, "field 'cbAceptTermsPayment' and method 'onCheckedChanged'");
        target.cbAceptTermsPayment = (CheckBox) Utils.castView(viewFindRequiredView4, R.id.cbAceptTermsPayment, "field 'cbAceptTermsPayment'", CheckBox.class);
        this.view7f0a00c0 = viewFindRequiredView4;
        ((CompoundButton) viewFindRequiredView4).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity_ViewBinding.7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton p0, boolean p1) {
                target.onCheckedChanged(p1);
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(source, R.id.tvLabelAceptTermsPayment, "field 'tvLabelAceptTermsPayment' and method 'onClickEvents'");
        target.tvLabelAceptTermsPayment = (TextView) Utils.castView(viewFindRequiredView5, R.id.tvLabelAceptTermsPayment, "field 'tvLabelAceptTermsPayment'", TextView.class);
        this.view7f0a0410 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(source, R.id.btAddCardPayment, "field 'btAddCardPayment' and method 'onClickEvents'");
        target.btAddCardPayment = (MaterialButton) Utils.castView(viewFindRequiredView6, R.id.btAddCardPayment, "field 'btAddCardPayment'", MaterialButton.class);
        this.view7f0a007b = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(source, R.id.btPaymentWithoutCard, "field 'btPaymentWithoutCard' and method 'onClickEvents'");
        target.btPaymentWithoutCard = (MaterialButton) Utils.castView(viewFindRequiredView7, R.id.btPaymentWithoutCard, "field 'btPaymentWithoutCard'", MaterialButton.class);
        this.view7f0a0093 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        target.spCardToken = (AutoCompleteTextView) Utils.findRequiredViewAsType(source, R.id.spCardToken, "field 'spCardToken'", AutoCompleteTextView.class);
        View viewFindRequiredView8 = Utils.findRequiredView(source, R.id.btMyCardToken, "field 'btMyCardToken' and method 'onClickEvents'");
        target.btMyCardToken = (MaterialButton) Utils.castView(viewFindRequiredView8, R.id.btMyCardToken, "field 'btMyCardToken'", MaterialButton.class);
        this.view7f0a008c = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView9 = Utils.findRequiredView(source, R.id.btPaymentToken, "field 'btPaymentToken' and method 'onClickEvents'");
        target.btPaymentToken = (MaterialButton) Utils.castView(viewFindRequiredView9, R.id.btPaymentToken, "field 'btPaymentToken'", MaterialButton.class);
        this.view7f0a0092 = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView10 = Utils.findRequiredView(source, R.id.btPaymentPass, "field 'btPaymentPass' and method 'onClickEvents'");
        target.btPaymentPass = (MaterialButton) Utils.castView(viewFindRequiredView10, R.id.btPaymentPass, "field 'btPaymentPass'", MaterialButton.class);
        this.view7f0a0091 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity_ViewBinding.13
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        target.gpPaymentTokenCard = (Group) Utils.findRequiredViewAsType(source, R.id.gpPaymentTokenCard, "field 'gpPaymentTokenCard'", Group.class);
        target.gpPaymentWithoutCard = (Group) Utils.findRequiredViewAsType(source, R.id.gpPaymentWithoutCard, "field 'gpPaymentWithoutCard'", Group.class);
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RechargeBalanceCardActivity rechargeBalanceCardActivity = this.target;
        if (rechargeBalanceCardActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        rechargeBalanceCardActivity.tvInfoMessage = null;
        rechargeBalanceCardActivity.etPrice = null;
        rechargeBalanceCardActivity.etEmailSend = null;
        rechargeBalanceCardActivity.etRepeatEmail = null;
        rechargeBalanceCardActivity.cbAceptTermsPayment = null;
        rechargeBalanceCardActivity.tvLabelAceptTermsPayment = null;
        rechargeBalanceCardActivity.btAddCardPayment = null;
        rechargeBalanceCardActivity.btPaymentWithoutCard = null;
        rechargeBalanceCardActivity.spCardToken = null;
        rechargeBalanceCardActivity.btMyCardToken = null;
        rechargeBalanceCardActivity.btPaymentToken = null;
        rechargeBalanceCardActivity.btPaymentPass = null;
        rechargeBalanceCardActivity.gpPaymentTokenCard = null;
        rechargeBalanceCardActivity.gpPaymentWithoutCard = null;
        rechargeBalanceCardActivity.toolbar = null;
        this.view7f0a0167.setOnFocusChangeListener(null);
        ((TextView) this.view7f0a0167).removeTextChangedListener(this.view7f0a0167TextWatcher);
        this.view7f0a0167TextWatcher = null;
        this.view7f0a0167 = null;
        this.view7f0a015a.setOnFocusChangeListener(null);
        ((TextView) this.view7f0a015a).removeTextChangedListener(this.view7f0a015aTextWatcher);
        this.view7f0a015aTextWatcher = null;
        this.view7f0a015a = null;
        this.view7f0a016b.setOnFocusChangeListener(null);
        ((TextView) this.view7f0a016b).removeTextChangedListener(this.view7f0a016bTextWatcher);
        this.view7f0a016bTextWatcher = null;
        this.view7f0a016b = null;
        ((CompoundButton) this.view7f0a00c0).setOnCheckedChangeListener(null);
        this.view7f0a00c0 = null;
        this.view7f0a0410.setOnClickListener(null);
        this.view7f0a0410 = null;
        this.view7f0a007b.setOnClickListener(null);
        this.view7f0a007b = null;
        this.view7f0a0093.setOnClickListener(null);
        this.view7f0a0093 = null;
        this.view7f0a008c.setOnClickListener(null);
        this.view7f0a008c = null;
        this.view7f0a0092.setOnClickListener(null);
        this.view7f0a0092 = null;
        this.view7f0a0091.setOnClickListener(null);
        this.view7f0a0091 = null;
    }
}
