package com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit;

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
public class EditAutomaticRechargeActivity_ViewBinding implements Unbinder {
    private EditAutomaticRechargeActivity target;
    private View view7f0a0097;

    public EditAutomaticRechargeActivity_ViewBinding(EditAutomaticRechargeActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public EditAutomaticRechargeActivity_ViewBinding(final EditAutomaticRechargeActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.tvInfoMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoMessage, "field 'tvInfoMessage'", TextView.class);
        target.etMinThreshold = (EditText) Utils.findRequiredViewAsType(source, R.id.etMinThreshold, "field 'etMinThreshold'", EditText.class);
        target.etRechargeQuantity = (EditText) Utils.findRequiredViewAsType(source, R.id.etRechargeQuantity, "field 'etRechargeQuantity'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.btSave, "field 'btSave' and method 'onViewClicked'");
        target.btSave = (MaterialButton) Utils.castView(viewFindRequiredView, R.id.btSave, "field 'btSave'", MaterialButton.class);
        this.view7f0a0097 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        EditAutomaticRechargeActivity editAutomaticRechargeActivity = this.target;
        if (editAutomaticRechargeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        editAutomaticRechargeActivity.toolbar = null;
        editAutomaticRechargeActivity.tvInfoMessage = null;
        editAutomaticRechargeActivity.etMinThreshold = null;
        editAutomaticRechargeActivity.etRechargeQuantity = null;
        editAutomaticRechargeActivity.btSave = null;
        this.view7f0a0097.setOnClickListener(null);
        this.view7f0a0097 = null;
    }
}
