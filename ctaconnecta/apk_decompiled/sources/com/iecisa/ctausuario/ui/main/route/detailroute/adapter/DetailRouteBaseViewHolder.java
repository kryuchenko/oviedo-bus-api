package com.iecisa.ctausuario.ui.main.route.detailroute.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.model.routes.DetailRouteModel;
import com.iecisa.ctausuario.model.routes.PolylineData;
import com.iecisa.ctausuario.model.routes.Step;

/* loaded from: classes5.dex */
public abstract class DetailRouteBaseViewHolder extends RecyclerView.ViewHolder {

    public interface OnRouteClickListener {
        void onClickMap(PolylineData polyline);
    }

    public abstract void bindView(Step step, DetailRouteModel startAddress, DetailRouteModel endAddress);

    public DetailRouteBaseViewHolder(View itemView, OnRouteClickListener listener) {
        super(itemView);
    }
}
