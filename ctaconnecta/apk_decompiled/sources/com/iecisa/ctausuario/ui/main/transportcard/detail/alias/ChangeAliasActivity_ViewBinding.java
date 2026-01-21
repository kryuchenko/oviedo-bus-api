package com.iecisa.ctausuario.ui.main.transportcard.detail.alias;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class ChangeAliasActivity_ViewBinding implements Unbinder {
    private ChangeAliasActivity target;
    private View view7f0a0097;

    public ChangeAliasActivity_ViewBinding(ChangeAliasActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public ChangeAliasActivity_ViewBinding(final ChangeAliasActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.tvInfoMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoMessage, "field 'tvInfoMessage'", TextView.class);
        target.etAlias = (EditText) Utils.findRequiredViewAsType(source, R.id.etAlias, "field 'etAlias'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.btSave, "method 'onViewClicked'");
        this.view7f0a0097 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.alias.ChangeAliasActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ChangeAliasActivity changeAliasActivity = this.target;
        if (changeAliasActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        changeAliasActivity.toolbar = null;
        changeAliasActivity.tvInfoMessage = null;
        changeAliasActivity.etAlias = null;
        this.view7f0a0097.setOnClickListener(null);
        this.view7f0a0097 = null;
    }
}
