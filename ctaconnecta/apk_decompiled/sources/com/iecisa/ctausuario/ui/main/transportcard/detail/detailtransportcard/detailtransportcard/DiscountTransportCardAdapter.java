package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.detailtransportcard;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.transportcarddetail.DiscountProfileModel;
import java.util.List;

/* loaded from: classes5.dex */
public class DiscountTransportCardAdapter extends RecyclerView.Adapter<DiscountTransportCardViewHolder> {
    private List<DiscountProfileModel> discountProfileModels;

    public DiscountTransportCardAdapter(List<DiscountProfileModel> discountProfileModels) {
        this.discountProfileModels = discountProfileModels;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DiscountTransportCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DiscountTransportCardViewHolder(parent.getContext(), LayoutInflater.from(parent.getContext()).inflate(R.layout.row_discount_transport_card, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DiscountTransportCardViewHolder holder, int position) {
        holder.bindView(this.discountProfileModels.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.discountProfileModels.size();
    }
}
