package com.iecisa.ctausuario.ui.main.linesrealtime.lineslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.StopItinerary;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class StopLineAdapter extends RecyclerView.Adapter<StopLineHolder> {
    private Context context;
    private List<StopItinerary> listStopsLine;
    private OnStopForLineClickListener onStopForLineClickListener;
    private StopItinerary stopItinerary;

    public interface OnStopForLineClickListener {
        void onStopClick(StopItinerary stop);
    }

    public StopLineAdapter(List<StopItinerary> listStopsLine, StopItinerary stopItinerary, Context context) {
        this.listStopsLine = listStopsLine;
        this.stopItinerary = stopItinerary;
        this.context = context;
    }

    public void setOnStopForLineClickListener(OnStopForLineClickListener onStopForLineClickListener) {
        this.onStopForLineClickListener = onStopForLineClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public StopLineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StopLineHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_stop_real_time, parent, false));
    }

    public static List<Integer> getFirstIndexesOfVehicleChanges(List<StopItinerary> listStopsLine) {
        ArrayList arrayList = new ArrayList();
        if (listStopsLine != null && !listStopsLine.isEmpty()) {
            int i = -1;
            for (int i2 = 0; i2 < listStopsLine.size(); i2++) {
                int iIntValue = listStopsLine.get(i2).getVehicleId().intValue();
                if (i2 == 0 || iIntValue != i) {
                    arrayList.add(Integer.valueOf(i2));
                    i = iIntValue;
                }
            }
        }
        return arrayList;
    }

    public boolean checkChangeVehicle(List<StopItinerary> listStopsLine, int now) {
        if (now - 1 < 0) {
            return false;
        }
        return !listStopsLine.get(now).getVehicleId().equals(listStopsLine.get(r0).getVehicleId());
    }

    public boolean checkLastOfVehicle(List<StopItinerary> listStopsLine, int now) {
        if (now + 1 > listStopsLine.size() - 1) {
            return false;
        }
        return !listStopsLine.get(now).getVehicleId().equals(listStopsLine.get(r0).getVehicleId());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final StopLineHolder holder, int position) {
        holder.bindView(this.listStopsLine.get(position), this.stopItinerary, this.context, getLastPosition(position), Boolean.valueOf(checkChangeVehicle(this.listStopsLine, position)), Boolean.valueOf(checkLastOfVehicle(this.listStopsLine, position)));
        holder.rowStopsLine.setOnClickListener(new View.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.linesrealtime.lineslist.StopLineAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(holder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(StopLineHolder stopLineHolder, View view) {
        this.onStopForLineClickListener.onStopClick(this.listStopsLine.get(stopLineHolder.getAdapterPosition()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listStopsLine.size();
    }

    private int getLastPosition(int position) {
        if (position == 0) {
            return 1;
        }
        return position == this.listStopsLine.size() - 1 ? 2 : 0;
    }

    public void setListStopsLine(List<StopItinerary> listStopsLine) {
        this.listStopsLine = listStopsLine;
    }
}
