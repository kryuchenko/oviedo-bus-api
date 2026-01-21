package com.iecisa.ctausuario.ui.main.route.detailroute.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.routes.DetailRouteModel;
import com.iecisa.ctausuario.model.routes.Step;
import com.iecisa.ctausuario.ui.main.route.detailroute.adapter.DetailRouteBaseViewHolder;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.attributes.Attributes;
import java.util.List;

/* loaded from: classes5.dex */
public class DetailRouteAdapter extends RecyclerView.Adapter<DetailRouteBaseViewHolder> {
    private DetailRouteModel endAddress;
    private DetailRouteBaseViewHolder.OnRouteClickListener listener;
    private DetailRouteModel startAddress;
    private List<Step> steps;

    public DetailRouteAdapter(List<Step> steps, DetailRouteModel startAddress, DetailRouteModel endAddress, DetailRouteBaseViewHolder.OnRouteClickListener listener) {
        this.steps = steps;
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DetailRouteBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Attributes.Way.TRAVEL_MODE_WALKING.ordinal()) {
            return new DetailRouteWalkingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_detail_routes_walking, parent, false), this.listener, parent.getContext());
        }
        return new DetailRouteTransitViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_detail_routes_transit, parent, false), this.listener, parent.getContext());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DetailRouteBaseViewHolder holder, int position) {
        if (position == 0) {
            holder.bindView(this.steps.get(position), this.startAddress, null);
        } else if (position == getItemCount() - 1) {
            holder.bindView(this.steps.get(position), null, this.endAddress);
        } else {
            holder.bindView(this.steps.get(position), null, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        String travelMode = this.steps.get(position).getTravelMode();
        travelMode.hashCode();
        if (travelMode.equals(Constants.Routes.ROUTE_TRAVEL_MODE_TRANSIT)) {
            return Attributes.Way.TRAVEL_MODE_BUS.ordinal();
        }
        return Attributes.Way.TRAVEL_MODE_WALKING.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.steps.size();
    }
}
