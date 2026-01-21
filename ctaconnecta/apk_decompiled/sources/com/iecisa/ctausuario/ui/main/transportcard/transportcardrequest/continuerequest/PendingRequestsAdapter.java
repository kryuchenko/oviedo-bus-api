package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import java.util.List;

/* loaded from: classes5.dex */
public class PendingRequestsAdapter extends RecyclerView.Adapter<PendingRequestsHolder> {
    private Context context;
    private OnPendingRequestClickListener onPendingRequestClickListener;
    private List<PendingCardRequest> pendingCardRequests;

    public interface OnPendingRequestClickListener {
        void onPendingRequestClick(PendingCardRequest pendingCardRequest);
    }

    public PendingRequestsAdapter(List<PendingCardRequest> pendingCardRequests, Context context) {
        this.pendingCardRequests = pendingCardRequests;
        this.context = context;
    }

    public void setOnPendingRequestClickListener(OnPendingRequestClickListener onPendingRequestClickListener) {
        this.onPendingRequestClickListener = onPendingRequestClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PendingRequestsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PendingRequestsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_transport_card_request, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PendingRequestsHolder holder, int position) {
        final PendingCardRequest pendingCardRequest = this.pendingCardRequests.get(holder.getAdapterPosition());
        holder.bindView(pendingCardRequest.requestDate, pendingCardRequest.requestNumber, this.context);
        holder.rowLine.setOnClickListener(new View.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.PendingRequestsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(pendingCardRequest, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(PendingCardRequest pendingCardRequest, View view) {
        this.onPendingRequestClickListener.onPendingRequestClick(pendingCardRequest);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.pendingCardRequests.size();
    }

    public void setPendingCardRequestsList(List<PendingCardRequest> pendingCardRequests) {
        this.pendingCardRequests = pendingCardRequests;
    }
}
