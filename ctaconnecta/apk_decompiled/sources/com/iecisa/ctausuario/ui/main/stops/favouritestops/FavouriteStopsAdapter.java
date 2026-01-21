package com.iecisa.ctausuario.ui.main.stops.favouritestops;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.MapStop;
import java.util.List;

/* loaded from: classes5.dex */
public class FavouriteStopsAdapter extends RecyclerView.Adapter<FavouriteStopsHolder> {
    private List<MapStop> listFavouriteStops;
    private OnFavouriteStopClickListener onFavouriteStopClickListener;

    public interface OnFavouriteStopClickListener {
        void onFavouriteStopClick(MapStop favouriteStop);

        void onHeartFavouriteStopClick(MapStop favouriteStop);
    }

    public void setOnFavouriteStopClickListener(OnFavouriteStopClickListener onFavouriteStopClickListener) {
        this.onFavouriteStopClickListener = onFavouriteStopClickListener;
    }

    public FavouriteStopsAdapter(List<MapStop> listStops) {
        this.listFavouriteStops = listStops;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public FavouriteStopsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FavouriteStopsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_favourite_stop, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final FavouriteStopsHolder holder, int position) {
        holder.bindView(this.listFavouriteStops.get(position));
        holder.rowFavouriteStop.setOnClickListener(new View.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(holder, view);
            }
        });
        holder.ivFavouriteStop.setOnClickListener(new View.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$1(holder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(FavouriteStopsHolder favouriteStopsHolder, View view) {
        this.onFavouriteStopClickListener.onFavouriteStopClick(this.listFavouriteStops.get(favouriteStopsHolder.getAdapterPosition()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$1(FavouriteStopsHolder favouriteStopsHolder, View view) {
        this.onFavouriteStopClickListener.onHeartFavouriteStopClick(this.listFavouriteStops.get(favouriteStopsHolder.getAdapterPosition()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listFavouriteStops.size();
    }

    public void setListFavouriteStops(List<MapStop> listFavouriteStops) {
        this.listFavouriteStops = listFavouriteStops;
    }
}
