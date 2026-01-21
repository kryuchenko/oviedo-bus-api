package com.iecisa.ctausuario.ui.main.route.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.routes.ResumeStepModelView;
import java.util.List;

/* loaded from: classes5.dex */
public class WayListAdapter extends RecyclerView.Adapter<WayViewHolder> {
    private List<ResumeStepModelView> stepList;

    public WayListAdapter(List<ResumeStepModelView> modelViewList) {
        this.stepList = modelViewList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WayViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_resume_walking, parent, false), parent.getContext());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(WayViewHolder holder, int position) {
        holder.bindView(this.stepList.get(position), position == getItemCount() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.stepList.size();
    }
}
