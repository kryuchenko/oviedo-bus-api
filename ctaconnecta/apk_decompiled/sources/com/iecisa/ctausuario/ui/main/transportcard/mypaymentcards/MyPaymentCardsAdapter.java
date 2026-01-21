package com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.PaymentCardModel;
import com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class MyPaymentCardsAdapter extends RecyclerView.Adapter<MyPaymentCardsViewHolder> {
    private MyPaymentCardsViewHolder.OnCardListener cardListener;
    private Context context;
    private List<PaymentCardModel> modelList;
    private OnRemoveCardListener removeCardListener;

    public interface OnRemoveCardListener {
        void onRemoveListener(PaymentCardModel model);
    }

    public MyPaymentCardsAdapter(List<PaymentCardModel> paymentCardsModel, OnRemoveCardListener removeCardListener, MyPaymentCardsViewHolder.OnCardListener cardListener) {
        ArrayList arrayList = new ArrayList();
        this.modelList = arrayList;
        if (paymentCardsModel != null) {
            arrayList.addAll(paymentCardsModel);
        }
        this.removeCardListener = removeCardListener;
        this.cardListener = cardListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyPaymentCardsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_my_payment_card, parent, false);
        this.context = parent.getContext();
        return new MyPaymentCardsViewHolder(viewInflate, this.cardListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MyPaymentCardsViewHolder holder, int position) {
        holder.bindView(this.modelList.get(position), this.context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.modelList.size();
    }

    public void removeCard(int position) {
        this.removeCardListener.onRemoveListener(this.modelList.get(position));
    }

    public int findPosition(Long idToken) {
        for (int i = 0; i < this.modelList.size(); i++) {
            if (this.modelList.get(i).getIdToken().equals(idToken)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        this.modelList.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<PaymentCardModel> cardResponseModelList) {
        this.modelList.clear();
        Iterator<PaymentCardModel> it = cardResponseModelList.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        notifyDataSetChanged();
    }

    public void add(PaymentCardModel card) {
        this.modelList.add(card);
        notifyDataSetChanged();
        notifyItemChanged(findPosition(card.getIdToken()));
    }
}
