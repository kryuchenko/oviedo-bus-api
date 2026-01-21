package com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.CardResponseModel;
import com.iecisa.ctausuario.utils.Constants;

/* loaded from: classes5.dex */
public class MyTransportCardsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.gpBlocked)
    Group gpBlocked;

    @BindView(R.id.ivTypeCard)
    ImageView ivTypeCard;
    private OnCardListener listener;
    private CardResponseModel model;

    @BindView(R.id.tvBlocked)
    TextView tvBlocked;

    @BindView(R.id.tvNameUserCard)
    TextView tvNameUserCard;

    @BindView(R.id.tvNumberCard)
    TextView tvNumberCard;

    public interface OnCardListener {
        void onClickListener(CardResponseModel model);
    }

    public MyTransportCardsViewHolder(View itemView, OnCardListener listener) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.listener = listener;
    }

    public void bindView(CardResponseModel model, Context context) {
        this.model = model;
        if (model.getAlias() != null) {
            this.tvNameUserCard.setText(model.getAlias());
        } else if (model.getCardHolderName() != null && model.getCardHolderSurname() != null) {
            if (model.getCardHolderLastname() != null) {
                this.tvNameUserCard.setText(context.getString(R.string.label_name_my_cards, model.getCardHolderName(), model.getCardHolderSurname(), model.getCardHolderLastname()));
            } else {
                this.tvNameUserCard.setText(context.getString(R.string.label_name_my_cards_one_surname, model.getCardHolderName(), model.getCardHolderSurname()));
            }
        } else if (model.getAlias() == null) {
            this.tvNameUserCard.setText("");
        }
        this.tvNumberCard.setText(model.getNumChip());
        this.gpBlocked.setVisibility(model.getCardStatusId().equals(Constants.CardStatus.ACTIVE) ? 8 : 0);
        if (Constants.CardStatus.ACTIVE.equals(model.getCardStatusId())) {
            return;
        }
        this.tvBlocked.setText(model.getCardStatus());
    }

    @OnClick({R.id.ivTypeCard})
    public void onClickCard() {
        this.listener.onClickListener(this.model);
    }
}
