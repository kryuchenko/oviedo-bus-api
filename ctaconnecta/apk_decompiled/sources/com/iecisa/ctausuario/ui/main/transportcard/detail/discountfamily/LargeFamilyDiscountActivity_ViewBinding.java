package com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily;

import android.text.Editable;
import android.text.TextWatcher;
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
public class LargeFamilyDiscountActivity_ViewBinding implements Unbinder {
    private LargeFamilyDiscountActivity target;
    private View view7f0a00c1;
    private View view7f0a0155;
    private TextWatcher view7f0a0155TextWatcher;
    private View view7f0a0260;
    private View view7f0a0410;

    public LargeFamilyDiscountActivity_ViewBinding(LargeFamilyDiscountActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public LargeFamilyDiscountActivity_ViewBinding(final LargeFamilyDiscountActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.tvInfoMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoMessage, "field 'tvInfoMessage'", TextView.class);
        target.tvTitle = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'tvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.etCardNumber, "field 'etCardNumber' and method 'onTextChanged'");
        target.etCardNumber = (TextView) Utils.castView(viewFindRequiredView, R.id.etCardNumber, "field 'etCardNumber'", TextView.class);
        this.view7f0a0155 = viewFindRequiredView;
        TextWatcher textWatcher = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity_ViewBinding.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChanged();
            }
        };
        this.view7f0a0155TextWatcher = textWatcher;
        ((TextView) viewFindRequiredView).addTextChangedListener(textWatcher);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.cbConditions, "field 'cbConditions' and method 'onCheckedChanged'");
        target.cbConditions = (CheckBox) Utils.castView(viewFindRequiredView2, R.id.cbConditions, "field 'cbConditions'", CheckBox.class);
        this.view7f0a00c1 = viewFindRequiredView2;
        ((CompoundButton) viewFindRequiredView2).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity_ViewBinding.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton p0, boolean p1) {
                target.onCheckedChanged(p1);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.mbRequest, "field 'mbRequest' and method 'onViewClicked'");
        target.mbRequest = (MaterialButton) Utils.castView(viewFindRequiredView3, R.id.mbRequest, "field 'mbRequest'", MaterialButton.class);
        this.view7f0a0260 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.tvLabelAceptTermsPayment, "method 'onViewClicked'");
        this.view7f0a0410 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LargeFamilyDiscountActivity largeFamilyDiscountActivity = this.target;
        if (largeFamilyDiscountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        largeFamilyDiscountActivity.toolbar = null;
        largeFamilyDiscountActivity.tvInfoMessage = null;
        largeFamilyDiscountActivity.tvTitle = null;
        largeFamilyDiscountActivity.etCardNumber = null;
        largeFamilyDiscountActivity.cbConditions = null;
        largeFamilyDiscountActivity.mbRequest = null;
        ((TextView) this.view7f0a0155).removeTextChangedListener(this.view7f0a0155TextWatcher);
        this.view7f0a0155TextWatcher = null;
        this.view7f0a0155 = null;
        ((CompoundButton) this.view7f0a00c1).setOnCheckedChangeListener(null);
        this.view7f0a00c1 = null;
        this.view7f0a0260.setOnClickListener(null);
        this.view7f0a0260 = null;
        this.view7f0a0410.setOnClickListener(null);
        this.view7f0a0410 = null;
    }
}
