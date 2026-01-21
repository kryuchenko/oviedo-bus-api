package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.movementstransportcard;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.model.transportcarddetail.MovementsHistoryModel;

/* loaded from: classes5.dex */
public abstract class MovementsTransportCardViewHolder extends RecyclerView.ViewHolder {
    public abstract void bindView(MovementsHistoryModel movementsModel);

    public MovementsTransportCardViewHolder(View itemView) {
        super(itemView);
    }
}
