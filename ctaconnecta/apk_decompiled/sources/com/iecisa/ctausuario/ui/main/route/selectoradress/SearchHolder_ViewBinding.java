package com.iecisa.ctausuario.ui.main.route.selectoradress;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class SearchHolder_ViewBinding implements Unbinder {
    private SearchHolder target;

    public SearchHolder_ViewBinding(SearchHolder target, View source) {
        this.target = target;
        target.rowSearchAddress = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.rowSearchAddress, "field 'rowSearchAddress'", ConstraintLayout.class);
        target.tvNameAddress = (TextView) Utils.findRequiredViewAsType(source, R.id.tvNameAddress, "field 'tvNameAddress'", TextView.class);
        target.tvCityAddress = (TextView) Utils.findRequiredViewAsType(source, R.id.tvCityAddress, "field 'tvCityAddress'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SearchHolder searchHolder = this.target;
        if (searchHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        searchHolder.rowSearchAddress = null;
        searchHolder.tvNameAddress = null;
        searchHolder.tvCityAddress = null;
    }
}
