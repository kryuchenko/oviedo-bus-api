package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.movementstransportcard;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class MovementsTransportCardFragment_ViewBinding implements Unbinder {
    private MovementsTransportCardFragment target;
    private View view7f0a025f;

    public MovementsTransportCardFragment_ViewBinding(final MovementsTransportCardFragment target, View source) {
        this.target = target;
        target.rvLastActionsTransportCard = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvLastActionsTransportCard, "field 'rvLastActionsTransportCard'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.mbReports, "field 'mbReports' and method 'onViewClicked'");
        target.mbReports = (MaterialButton) Utils.castView(viewFindRequiredView, R.id.mbReports, "field 'mbReports'", MaterialButton.class);
        this.view7f0a025f = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.movementstransportcard.MovementsTransportCardFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked();
            }
        });
        target.tvNoMovements = (TextView) Utils.findRequiredViewAsType(source, R.id.tvNoMovements, "field 'tvNoMovements'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MovementsTransportCardFragment movementsTransportCardFragment = this.target;
        if (movementsTransportCardFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        movementsTransportCardFragment.rvLastActionsTransportCard = null;
        movementsTransportCardFragment.mbReports = null;
        movementsTransportCardFragment.tvNoMovements = null;
        this.view7f0a025f.setOnClickListener(null);
        this.view7f0a025f = null;
    }
}
