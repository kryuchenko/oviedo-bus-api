package com.iecisa.ctausuario.ui.main.transportcard.dataprotection;

import android.view.View;
import android.widget.Switch;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class DataProtectionViewHolder_ViewBinding implements Unbinder {
    private DataProtectionViewHolder target;

    public DataProtectionViewHolder_ViewBinding(DataProtectionViewHolder target, View source) {
        this.target = target;
        target.swConditions = (Switch) Utils.findRequiredViewAsType(source, R.id.swConditions, "field 'swConditions'", Switch.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DataProtectionViewHolder dataProtectionViewHolder = this.target;
        if (dataProtectionViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        dataProtectionViewHolder.swConditions = null;
    }
}
