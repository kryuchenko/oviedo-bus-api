package com.iecisa.ctausuario.ui.main.route.selectoradress;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.SearchAddress;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class SearchAdapter extends RecyclerView.Adapter<SearchHolder> {
    private List<SearchAddress> listSearchAddress = new ArrayList();
    private OnSearchAddressClickListener onSearchAddressClickListener;

    public interface OnSearchAddressClickListener {
        void onSearchAddressClick(SearchAddress searchAddress);
    }

    public void setOnSearchAddressClickListener(OnSearchAddressClickListener onSearchAddressClickListener) {
        this.onSearchAddressClickListener = onSearchAddressClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SearchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_search_address, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final SearchHolder holder, int position) {
        holder.bindView(this.listSearchAddress.get(position));
        holder.rowSearchAddress.setOnClickListener(new View.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.selectoradress.SearchAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(holder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(SearchHolder searchHolder, View view) {
        this.onSearchAddressClickListener.onSearchAddressClick(this.listSearchAddress.get(searchHolder.getAdapterPosition()));
    }

    public void addAll(List<SearchAddress> searchAddressList) {
        for (SearchAddress searchAddress : searchAddressList) {
            if (searchAddress.getLongitude() != null && searchAddress.getLatitude() != null) {
                this.listSearchAddress.add(searchAddress);
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listSearchAddress.size();
    }
}
