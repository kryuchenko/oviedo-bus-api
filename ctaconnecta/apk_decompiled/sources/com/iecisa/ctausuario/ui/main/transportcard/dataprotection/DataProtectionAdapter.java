package com.iecisa.ctausuario.ui.main.transportcard.dataprotection;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.dataprotection.ConsentModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class DataProtectionAdapter extends RecyclerView.Adapter<DataProtectionViewHolder> {
    private List<ConsentModel> dataProtectionModels = new ArrayList();
    private boolean isMandatory;

    public DataProtectionAdapter(boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DataProtectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DataProtectionViewHolder(parent.getContext(), LayoutInflater.from(parent.getContext()).inflate(R.layout.row_detail_data_protection, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DataProtectionViewHolder holder, int position) {
        holder.bindView(this.dataProtectionModels.get(position), this.isMandatory);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataProtectionModels.size();
    }

    public void add(ConsentModel model) {
        this.dataProtectionModels.add(model);
        notifyDataSetChanged();
    }

    public void addAll(List<ConsentModel> modelList) {
        this.dataProtectionModels.addAll(modelList);
        notifyDataSetChanged();
    }

    public List<ConsentModel> getItems() {
        return this.dataProtectionModels;
    }
}
