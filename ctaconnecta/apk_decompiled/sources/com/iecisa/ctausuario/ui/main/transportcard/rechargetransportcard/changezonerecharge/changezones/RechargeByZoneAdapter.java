package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.RechargeZones;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones.RechargeByZoneViewHolder;
import java.util.List;

/* loaded from: classes5.dex */
public class RechargeByZoneAdapter extends RecyclerView.Adapter<RechargeByZoneViewHolder> {
    private RechargeByZoneViewHolder.OnZoneListener listener;
    private List<RechargeZones> rechargeZonesList;

    public RechargeByZoneAdapter(List<RechargeZones> modelList, RechargeByZoneViewHolder.OnZoneListener listener) {
        this.rechargeZonesList = modelList;
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RechargeByZoneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RechargeByZoneViewHolder(parent.getContext(), LayoutInflater.from(parent.getContext()).inflate(R.layout.row_detail_recharge_by_zone, parent, false), this.listener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RechargeByZoneViewHolder holder, int position) {
        holder.bindView(this.rechargeZonesList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.rechargeZonesList.size();
    }

    RechargeZones selectZone(Integer zone) {
        List<RechargeZones> list = this.rechargeZonesList;
        RechargeZones rechargeZones = null;
        if (list != null && list.size() > 0) {
            for (RechargeZones rechargeZones2 : this.rechargeZonesList) {
                if (zone.equals(Integer.valueOf(rechargeZones2.getZone()))) {
                    rechargeZones2.setSelected(true);
                    rechargeZones = rechargeZones2;
                } else {
                    rechargeZones2.setSelected(false);
                }
            }
        }
        notifyDataSetChanged();
        return rechargeZones;
    }

    public void reloadData(List<RechargeZones> rechargeZones) {
        this.rechargeZonesList.clear();
        this.rechargeZonesList.addAll(rechargeZones);
        notifyDataSetChanged();
    }
}
