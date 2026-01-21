package com.iecisa.ctausuario.ui.main.route.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.routes.Route;
import com.iecisa.ctausuario.model.routes.RoutesResponse;
import java.util.List;

/* loaded from: classes5.dex */
public class RouteListAdapter extends RecyclerView.Adapter<RouteViewHolder> {
    private List<Route> listRoutes;
    private OnRouteClickListener listener;

    public interface OnRouteClickListener {
        void onClickRoute(Route route);
    }

    public RouteListAdapter(List<Route> routes) {
        this.listRoutes = routes;
    }

    public void setOnStopClickListener(OnRouteClickListener onRouteClickListener) {
        this.listener = onRouteClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RouteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RouteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_routes, parent, false), parent.getContext());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RouteViewHolder holder, int position) {
        holder.bindView(this.listRoutes.get(position));
        holder.rowSearchRoute.setOnClickListener(new View.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.adapter.RouteListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(holder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(RouteViewHolder routeViewHolder, View view) {
        this.listener.onClickRoute(this.listRoutes.get(routeViewHolder.getAdapterPosition()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listRoutes.size();
    }

    public void updateResults(RoutesResponse routes) {
        this.listRoutes.clear();
        this.listRoutes.addAll(routes.getRoutes());
        notifyDataSetChanged();
    }

    public void clearAll() {
        this.listRoutes.clear();
        notifyDataSetChanged();
    }

    public void setListRoutes(List<Route> listRoutes) {
        this.listRoutes = listRoutes;
    }
}
