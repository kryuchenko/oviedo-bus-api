package com.iecisa.ctausuario.ui.main.route.timepicker;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.TimePicker;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class TimePickerDialogFragment_ViewBinding implements Unbinder {
    private TimePickerDialogFragment target;
    private View view7f0a0081;
    private View view7f0a0097;
    private View view7f0a0493;
    private View view7f0a0495;

    public TimePickerDialogFragment_ViewBinding(final TimePickerDialogFragment target, View source) {
        this.target = target;
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.tvTimeArrival, "field 'tvTimeArrival' and method 'onViewClicked'");
        target.tvTimeArrival = (CheckedTextView) Utils.castView(viewFindRequiredView, R.id.tvTimeArrival, "field 'tvTimeArrival'", CheckedTextView.class);
        this.view7f0a0493 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.timepicker.TimePickerDialogFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvTimeDeparture, "field 'tvTimeDeparture' and method 'onViewClicked'");
        target.tvTimeDeparture = (CheckedTextView) Utils.castView(viewFindRequiredView2, R.id.tvTimeDeparture, "field 'tvTimeDeparture'", CheckedTextView.class);
        this.view7f0a0495 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.timepicker.TimePickerDialogFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        target.dpContainer = (DatePicker) Utils.findRequiredViewAsType(source, R.id.dpContainer, "field 'dpContainer'", DatePicker.class);
        target.tpContainer = (TimePicker) Utils.findRequiredViewAsType(source, R.id.tpContainer, "field 'tpContainer'", TimePicker.class);
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.btCancel, "field 'btCancel' and method 'onViewClicked'");
        target.btCancel = (MaterialButton) Utils.castView(viewFindRequiredView3, R.id.btCancel, "field 'btCancel'", MaterialButton.class);
        this.view7f0a0081 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.timepicker.TimePickerDialogFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.btSave, "field 'btSave' and method 'onViewClicked'");
        target.btSave = (MaterialButton) Utils.castView(viewFindRequiredView4, R.id.btSave, "field 'btSave'", MaterialButton.class);
        this.view7f0a0097 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.timepicker.TimePickerDialogFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TimePickerDialogFragment timePickerDialogFragment = this.target;
        if (timePickerDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        timePickerDialogFragment.tvTimeArrival = null;
        timePickerDialogFragment.tvTimeDeparture = null;
        timePickerDialogFragment.dpContainer = null;
        timePickerDialogFragment.tpContainer = null;
        timePickerDialogFragment.btCancel = null;
        timePickerDialogFragment.btSave = null;
        this.view7f0a0493.setOnClickListener(null);
        this.view7f0a0493 = null;
        this.view7f0a0495.setOnClickListener(null);
        this.view7f0a0495 = null;
        this.view7f0a0081.setOnClickListener(null);
        this.view7f0a0081 = null;
        this.view7f0a0097.setOnClickListener(null);
        this.view7f0a0097 = null;
    }
}
