package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.movementstransportcard;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.transportcarddetail.MovementsHistoryModel;
import com.iecisa.ctausuario.utils.Constants;
import java.util.List;

/* loaded from: classes5.dex */
public class MovementsTransportCardAdapter extends RecyclerView.Adapter<MovementsTransportCardViewHolder> {
    private Integer cardTypeId;
    private List<MovementsHistoryModel> movementsHistoryModels;

    public MovementsTransportCardAdapter(List<MovementsHistoryModel> modelList, Integer cardTypeId) {
        this.movementsHistoryModels = modelList;
        this.cardTypeId = cardTypeId;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MovementsTransportCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Constants.Movements.Recharge.ordinal()) {
            return new RechargeMovementViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recharge_transport_card, parent, false), parent.getContext(), this.cardTypeId);
        }
        return new ValidationMovementViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_validation_transport_card, parent, false), parent.getContext(), this.cardTypeId);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MovementsTransportCardViewHolder holder, int position) {
        holder.bindView(this.movementsHistoryModels.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (this.movementsHistoryModels.get(position).getRechargeHistoryModel() != null) {
            return Constants.Movements.Recharge.ordinal();
        }
        return Constants.Movements.Validation.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.movementsHistoryModels.size();
    }

    public void addAll(List<MovementsHistoryModel> historicsData) {
        this.movementsHistoryModels.clear();
        this.movementsHistoryModels.addAll(historicsData);
        notifyDataSetChanged();
    }
}
