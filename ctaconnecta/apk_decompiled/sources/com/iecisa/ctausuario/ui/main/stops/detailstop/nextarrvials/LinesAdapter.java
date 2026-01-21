package com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.StopItinerary;
import java.util.List;

/* loaded from: classes5.dex */
public class LinesAdapter extends RecyclerView.Adapter<LinesHolder> {
    private Context context;
    private boolean isNextArrival;
    private OnStopClickListener onStopClickListener;
    private List<StopItinerary> stopItineraryList;

    public interface OnStopClickListener {
        void onAlertStopClick(StopItinerary line);

        void onStopClick(StopItinerary line);
    }

    public LinesAdapter(List<StopItinerary> stopItineraryList, boolean isNextArrival, Context context) {
        this.stopItineraryList = stopItineraryList;
        this.isNextArrival = isNextArrival;
        this.context = context;
    }

    public void setOnStopClickListener(OnStopClickListener onStopClickListener) {
        this.onStopClickListener = onStopClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public LinesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinesHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_lines, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final LinesHolder holder, int position) {
        holder.bindView(this.stopItineraryList.get(position), this.isNextArrival, this.context);
        holder.rowLine.setOnClickListener(new View.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.LinesAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(holder, view);
            }
        });
        holder.ivRingAlert.setOnClickListener(new View.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.LinesAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$1(holder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(LinesHolder linesHolder, View view) {
        this.onStopClickListener.onStopClick(this.stopItineraryList.get(linesHolder.getAdapterPosition()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$1(LinesHolder linesHolder, View view) {
        this.onStopClickListener.onAlertStopClick(this.stopItineraryList.get(linesHolder.getAdapterPosition()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.stopItineraryList.size();
    }

    public void setItineraryNotification(Integer itineraryId, boolean isAdded) {
        for (int i = 0; i < this.stopItineraryList.size(); i++) {
            if (itineraryId.equals(this.stopItineraryList.get(i).getItineraryId())) {
                this.stopItineraryList.get(i).setNotificationActive(isAdded);
                notifyItemChanged(findPosition(itineraryId));
                notifyDataSetChanged();
            }
        }
    }

    private int findPosition(Integer itineraryId) {
        for (int i = 0; i < this.stopItineraryList.size(); i++) {
            if (this.stopItineraryList.get(i).getItineraryId().equals(itineraryId)) {
                return i;
            }
        }
        return -1;
    }

    public void setStopItineraryList(List<StopItinerary> stopItineraryList) {
        this.stopItineraryList = stopItineraryList;
    }
}
