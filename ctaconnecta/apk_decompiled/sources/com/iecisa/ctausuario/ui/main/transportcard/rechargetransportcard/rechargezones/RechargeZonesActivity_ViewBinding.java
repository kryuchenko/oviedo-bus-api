package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones;

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
import com.google.android.material.textfield.TextInputLayout;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class RechargeZonesActivity_ViewBinding implements Unbinder {
    private RechargeZonesActivity target;
    private View view7f0a007b;
    private View view7f0a007f;
    private View view7f0a008c;
    private View view7f0a0091;
    private View view7f0a0092;
    private View view7f0a0093;
    private View view7f0a00c0;
    private View view7f0a015a;
    private TextWatcher view7f0a015aTextWatcher;
    private View view7f0a016b;
    private TextWatcher view7f0a016bTextWatcher;
    private View view7f0a0410;

    public RechargeZonesActivity_ViewBinding(RechargeZonesActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public RechargeZonesActivity_ViewBinding(final RechargeZonesActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.tvInfoMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoMessage, "field 'tvInfoMessage'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.etEmailSend, "field 'etEmailSend', method 'onFocusChanged', and method 'onTextChangedMail'");
        target.etEmailSend = (EditText) Utils.castView(viewFindRequiredView, R.id.etEmailSend, "field 'etEmailSend'", EditText.class);
        this.view7f0a015a = viewFindRequiredView;
        viewFindRequiredView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity_ViewBinding.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View p0, boolean p1) {
                target.onFocusChanged(p0, p1);
            }
        });
        TextWatcher textWatcher = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity_ViewBinding.2
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
        this.view7f0a015aTextWatcher = textWatcher;
        ((TextView) viewFindRequiredView).addTextChangedListener(textWatcher);
        target.tilNumberTickets = (TextInputLayout) Utils.findRequiredViewAsType(source, R.id.tilNumberTickets, "field 'tilNumberTickets'", TextInputLayout.class);
        target.sNumberTickets = (AutoCompleteTextView) Utils.findRequiredViewAsType(source, R.id.sNumberTickets, "field 'sNumberTickets'", AutoCompleteTextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.etRepeatEmail, "field 'etRepeatEmail', method 'onFocusChanged', and method 'onTextChangedRepeatMail'");
        target.etRepeatEmail = (EditText) Utils.castView(viewFindRequiredView2, R.id.etRepeatEmail, "field 'etRepeatEmail'", EditText.class);
        this.view7f0a016b = viewFindRequiredView2;
        viewFindRequiredView2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity_ViewBinding.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View p0, boolean p1) {
                target.onFocusChanged(p0, p1);
            }
        });
        TextWatcher textWatcher2 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity_ViewBinding.4
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
        this.view7f0a016bTextWatcher = textWatcher2;
        ((TextView) viewFindRequiredView2).addTextChangedListener(textWatcher2);
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.cbAceptTermsPayment, "field 'cbAceptTermsPayment' and method 'onCheckedChanged'");
        target.cbAceptTermsPayment = (CheckBox) Utils.castView(viewFindRequiredView3, R.id.cbAceptTermsPayment, "field 'cbAceptTermsPayment'", CheckBox.class);
        this.view7f0a00c0 = viewFindRequiredView3;
        ((CompoundButton) viewFindRequiredView3).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity_ViewBinding.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton p0, boolean p1) {
                target.onCheckedChanged(p1);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.btPaymentToken, "field 'btPaymentToken' and method 'onViewClicked'");
        target.btPaymentToken = (TextView) Utils.castView(viewFindRequiredView4, R.id.btPaymentToken, "field 'btPaymentToken'", TextView.class);
        this.view7f0a0092 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(source, R.id.btAddCardPayment, "field 'btAddCardPayment' and method 'onViewClicked'");
        target.btAddCardPayment = (MaterialButton) Utils.castView(viewFindRequiredView5, R.id.btAddCardPayment, "field 'btAddCardPayment'", MaterialButton.class);
        this.view7f0a007b = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(source, R.id.btPaymentPass, "field 'btPaymentPass' and method 'onViewClicked'");
        target.btPaymentPass = (MaterialButton) Utils.castView(viewFindRequiredView6, R.id.btPaymentPass, "field 'btPaymentPass'", MaterialButton.class);
        this.view7f0a0091 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(source, R.id.btPaymentWithoutCard, "field 'btPaymentWithoutCard' and method 'onViewClicked'");
        target.btPaymentWithoutCard = (MaterialButton) Utils.castView(viewFindRequiredView7, R.id.btPaymentWithoutCard, "field 'btPaymentWithoutCard'", MaterialButton.class);
        this.view7f0a0093 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView8 = Utils.findRequiredView(source, R.id.btMyCardToken, "field 'btMyCardToken' and method 'onViewClicked'");
        target.btMyCardToken = (MaterialButton) Utils.castView(viewFindRequiredView8, R.id.btMyCardToken, "field 'btMyCardToken'", MaterialButton.class);
        this.view7f0a008c = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        target.spCardToken = (AutoCompleteTextView) Utils.findRequiredViewAsType(source, R.id.spCardToken, "field 'spCardToken'", AutoCompleteTextView.class);
        target.gpPaymentTokenCard = (Group) Utils.findRequiredViewAsType(source, R.id.gpPaymentTokenCard, "field 'gpPaymentTokenCard'", Group.class);
        target.gpPaymentWithoutCard = (Group) Utils.findRequiredViewAsType(source, R.id.gpPaymentWithoutCard, "field 'gpPaymentWithoutCard'", Group.class);
        target.mbNumTicketsZones = (MaterialButton) Utils.findRequiredViewAsType(source, R.id.mbNumTicketsZones, "field 'mbNumTicketsZones'", MaterialButton.class);
        target.mbValidityDate = (MaterialButton) Utils.findRequiredViewAsType(source, R.id.mbValidityDate, "field 'mbValidityDate'", MaterialButton.class);
        target.mbAmountTicket = (MaterialButton) Utils.findRequiredViewAsType(source, R.id.mbAmountTicket, "field 'mbAmountTicket'", MaterialButton.class);
        target.tvExtendedInfo = (TextView) Utils.findRequiredViewAsType(source, R.id.tvExtendedInfo, "field 'tvExtendedInfo'", TextView.class);
        View viewFindRequiredView9 = Utils.findRequiredView(source, R.id.btCalculateZones, "method 'onViewClicked'");
        this.view7f0a007f = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView10 = Utils.findRequiredView(source, R.id.tvLabelAceptTermsPayment, "method 'onViewClicked'");
        this.view7f0a0410 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RechargeZonesActivity rechargeZonesActivity = this.target;
        if (rechargeZonesActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        rechargeZonesActivity.toolbar = null;
        rechargeZonesActivity.tvInfoMessage = null;
        rechargeZonesActivity.etEmailSend = null;
        rechargeZonesActivity.tilNumberTickets = null;
        rechargeZonesActivity.sNumberTickets = null;
        rechargeZonesActivity.etRepeatEmail = null;
        rechargeZonesActivity.cbAceptTermsPayment = null;
        rechargeZonesActivity.btPaymentToken = null;
        rechargeZonesActivity.btAddCardPayment = null;
        rechargeZonesActivity.btPaymentPass = null;
        rechargeZonesActivity.btPaymentWithoutCard = null;
        rechargeZonesActivity.btMyCardToken = null;
        rechargeZonesActivity.spCardToken = null;
        rechargeZonesActivity.gpPaymentTokenCard = null;
        rechargeZonesActivity.gpPaymentWithoutCard = null;
        rechargeZonesActivity.mbNumTicketsZones = null;
        rechargeZonesActivity.mbValidityDate = null;
        rechargeZonesActivity.mbAmountTicket = null;
        rechargeZonesActivity.tvExtendedInfo = null;
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
        this.view7f0a0092.setOnClickListener(null);
        this.view7f0a0092 = null;
        this.view7f0a007b.setOnClickListener(null);
        this.view7f0a007b = null;
        this.view7f0a0091.setOnClickListener(null);
        this.view7f0a0091 = null;
        this.view7f0a0093.setOnClickListener(null);
        this.view7f0a0093 = null;
        this.view7f0a008c.setOnClickListener(null);
        this.view7f0a008c = null;
        this.view7f0a007f.setOnClickListener(null);
        this.view7f0a007f = null;
        this.view7f0a0410.setOnClickListener(null);
        this.view7f0a0410 = null;
    }
}
