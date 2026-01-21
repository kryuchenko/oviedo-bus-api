package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class CalculateZoneFragment_ViewBinding implements Unbinder {
    private CalculateZoneFragment target;
    private View view7f0a004b;
    private TextWatcher view7f0a004bTextWatcher;
    private View view7f0a004c;
    private TextWatcher view7f0a004cTextWatcher;
    private View view7f0a007e;
    private View view7f0a008f;

    public CalculateZoneFragment_ViewBinding(final CalculateZoneFragment target, View source) {
        this.target = target;
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.actvOrigin, "field 'actvOrigin', method 'onFocusChange', and method 'onTextChangedOrigin'");
        target.actvOrigin = (AutoCompleteTextView) Utils.castView(viewFindRequiredView, R.id.actvOrigin, "field 'actvOrigin'", AutoCompleteTextView.class);
        this.view7f0a004c = viewFindRequiredView;
        viewFindRequiredView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment_ViewBinding.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View p0, boolean p1) {
                target.onFocusChange(p0, p1);
            }
        });
        TextWatcher textWatcher = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment_ViewBinding.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedOrigin();
            }
        };
        this.view7f0a004cTextWatcher = textWatcher;
        ((TextView) viewFindRequiredView).addTextChangedListener(textWatcher);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.actvDestination, "field 'actvDestination', method 'onFocusChange', and method 'onTextChangedDestination'");
        target.actvDestination = (AutoCompleteTextView) Utils.castView(viewFindRequiredView2, R.id.actvDestination, "field 'actvDestination'", AutoCompleteTextView.class);
        this.view7f0a004b = viewFindRequiredView2;
        viewFindRequiredView2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment_ViewBinding.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View p0, boolean p1) {
                target.onFocusChange(p0, p1);
            }
        });
        TextWatcher textWatcher2 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment_ViewBinding.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedDestination();
            }
        };
        this.view7f0a004bTextWatcher = textWatcher2;
        ((TextView) viewFindRequiredView2).addTextChangedListener(textWatcher2);
        target.gpCalculate = (Group) Utils.findRequiredViewAsType(source, R.id.gpCalculate, "field 'gpCalculate'", Group.class);
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.btCalculate, "field 'btCalculate' and method 'onViewClicked'");
        target.btCalculate = (MaterialButton) Utils.castView(viewFindRequiredView3, R.id.btCalculate, "field 'btCalculate'", MaterialButton.class);
        this.view7f0a007e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        target.tvOriginDestiny = (TextView) Utils.findRequiredViewAsType(source, R.id.tvOriginDestiny, "field 'tvOriginDestiny'", TextView.class);
        target.tvZones = (TextView) Utils.findRequiredViewAsType(source, R.id.tvZones, "field 'tvZones'", TextView.class);
        target.tvPrice = (TextView) Utils.findRequiredViewAsType(source, R.id.tvPrice, "field 'tvPrice'", TextView.class);
        target.tvWarningZones = (TextView) Utils.findRequiredViewAsType(source, R.id.tvWarningZones, "field 'tvWarningZones'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.btNext, "field 'btNext' and method 'onViewClicked'");
        target.btNext = (MaterialButton) Utils.castView(viewFindRequiredView4, R.id.btNext, "field 'btNext'", MaterialButton.class);
        this.view7f0a008f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CalculateZoneFragment calculateZoneFragment = this.target;
        if (calculateZoneFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        calculateZoneFragment.actvOrigin = null;
        calculateZoneFragment.actvDestination = null;
        calculateZoneFragment.gpCalculate = null;
        calculateZoneFragment.btCalculate = null;
        calculateZoneFragment.tvOriginDestiny = null;
        calculateZoneFragment.tvZones = null;
        calculateZoneFragment.tvPrice = null;
        calculateZoneFragment.tvWarningZones = null;
        calculateZoneFragment.btNext = null;
        this.view7f0a004c.setOnFocusChangeListener(null);
        ((TextView) this.view7f0a004c).removeTextChangedListener(this.view7f0a004cTextWatcher);
        this.view7f0a004cTextWatcher = null;
        this.view7f0a004c = null;
        this.view7f0a004b.setOnFocusChangeListener(null);
        ((TextView) this.view7f0a004b).removeTextChangedListener(this.view7f0a004bTextWatcher);
        this.view7f0a004bTextWatcher = null;
        this.view7f0a004b = null;
        this.view7f0a007e.setOnClickListener(null);
        this.view7f0a007e = null;
        this.view7f0a008f.setOnClickListener(null);
        this.view7f0a008f = null;
    }
}
