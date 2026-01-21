package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.detailtransportcard;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.transportcarddetail.ZonesAmountModel;
import java.util.List;

/* loaded from: classes5.dex */
public class ZonesTransportCardAdapter extends RecyclerView.Adapter<ZonesTransportCardViewHolder> {
    List<ZonesAmountModel> zonesAmountModelList;

    public ZonesTransportCardAdapter(List<ZonesAmountModel> zonesAmountModel) {
        this.zonesAmountModelList = zonesAmountModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ZonesTransportCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ZonesTransportCardViewHolder(parent.getContext(), LayoutInflater.from(parent.getContext()).inflate(R.layout.row_zones_transport_card, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ZonesTransportCardViewHolder holder, int position) throws Resources.NotFoundException {
        holder.bindView(this.zonesAmountModelList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.zonesAmountModelList.size();
    }
}
