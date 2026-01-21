package com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.CardResponseModel;
import com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.adapter.MyTransportCardsViewHolder;
import java.util.List;

/* loaded from: classes5.dex */
public class MyTransportCardsAdapter extends RecyclerView.Adapter<MyTransportCardsViewHolder> {
    private MyTransportCardsViewHolder.OnCardListener cardListener;
    private List<CardResponseModel> cardModelList;
    private Context context;
    private OnRemoveCardListener removeCardListener;

    public interface OnRemoveCardListener {
        void onRemoveListener(CardResponseModel model);
    }

    public MyTransportCardsAdapter(List<CardResponseModel> cardModelList, MyTransportCardsViewHolder.OnCardListener cardListener, OnRemoveCardListener removeCardListener) {
        this.cardModelList = cardModelList;
        this.cardListener = cardListener;
        this.removeCardListener = removeCardListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyTransportCardsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_my_card, parent, false);
        this.context = parent.getContext();
        return new MyTransportCardsViewHolder(viewInflate, this.cardListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MyTransportCardsViewHolder holder, int position) {
        holder.bindView(this.cardModelList.get(position), this.context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cardModelList.size();
    }

    public void removeCard(int position) {
        this.removeCardListener.onRemoveListener(this.cardModelList.get(position));
    }

    public void remove(int position) {
        List<CardResponseModel> list = this.cardModelList;
        list.remove(list.get(position));
        notifyDataSetChanged();
    }

    public Context getContext() {
        return this.context;
    }

    public void add(CardResponseModel card) {
        this.cardModelList.add(card);
        notifyDataSetChanged();
        notifyItemChanged(findPosition(card.getNumChip()));
    }

    public int findPosition(String numChip) {
        for (int i = 0; i < this.cardModelList.size(); i++) {
            if (this.cardModelList.get(i).getNumChip().equals(numChip)) {
                return i;
            }
        }
        return -1;
    }

    public void clearAll() {
        this.cardModelList.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<CardResponseModel> cardList) {
        this.cardModelList.clear();
        this.cardModelList.addAll(cardList);
        notifyDataSetChanged();
    }

    public Integer getCardType(int position) {
        return this.cardModelList.get(position).getCardTypeId();
    }
}
