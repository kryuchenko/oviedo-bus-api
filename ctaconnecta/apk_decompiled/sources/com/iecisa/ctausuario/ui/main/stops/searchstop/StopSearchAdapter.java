package com.iecisa.ctausuario.ui.main.stops.searchstop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.MapStop;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class StopSearchAdapter extends RecyclerView.Adapter<StopSearchViewHolder> {
    private List<MapStop> listStops = new ArrayList();
    private OnSearchStopClickListener onSearchStopClickListener;

    public interface OnSearchStopClickListener {
        void onStopClick(MapStop searchStop);
    }

    public void setOnSearchStopClickListener(OnSearchStopClickListener onSearchStopClickListener) {
        this.onSearchStopClickListener = onSearchStopClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public StopSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StopSearchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_search_stop, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final StopSearchViewHolder holder, int position) {
        holder.bindView(this.listStops.get(position));
        holder.rowSearchStop.setOnClickListener(new View.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.searchstop.StopSearchAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(holder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(StopSearchViewHolder stopSearchViewHolder, View view) {
        this.onSearchStopClickListener.onStopClick(this.listStops.get(stopSearchViewHolder.getAdapterPosition()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listStops.size();
    }

    public void setListStops(List<MapStop> listStops) {
        this.listStops = listStops;
    }
}
