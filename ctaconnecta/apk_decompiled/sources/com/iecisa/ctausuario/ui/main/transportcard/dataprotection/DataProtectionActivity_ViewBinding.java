package com.iecisa.ctausuario.ui.main.transportcard.dataprotection;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class DataProtectionActivity_ViewBinding implements Unbinder {
    private DataProtectionActivity target;
    private View view7f0a0097;

    public DataProtectionActivity_ViewBinding(DataProtectionActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public DataProtectionActivity_ViewBinding(final DataProtectionActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.rvProtectionMandatory = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvProtectionMandatory, "field 'rvProtectionMandatory'", RecyclerView.class);
        target.rvProtection = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvProtection, "field 'rvProtection'", RecyclerView.class);
        target.tvLabelDataMandatory = (TextView) Utils.findRequiredViewAsType(source, R.id.tvLabelDataMandatory, "field 'tvLabelDataMandatory'", TextView.class);
        target.tvLabelDataNotMandatory = (TextView) Utils.findRequiredViewAsType(source, R.id.tvLabelDataNotMandatory, "field 'tvLabelDataNotMandatory'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.btSave, "method 'onViewClicked'");
        this.view7f0a0097 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.dataprotection.DataProtectionActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DataProtectionActivity dataProtectionActivity = this.target;
        if (dataProtectionActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        dataProtectionActivity.toolbar = null;
        dataProtectionActivity.rvProtectionMandatory = null;
        dataProtectionActivity.rvProtection = null;
        dataProtectionActivity.tvLabelDataMandatory = null;
        dataProtectionActivity.tvLabelDataNotMandatory = null;
        this.view7f0a0097.setOnClickListener(null);
        this.view7f0a0097 = null;
    }
}
