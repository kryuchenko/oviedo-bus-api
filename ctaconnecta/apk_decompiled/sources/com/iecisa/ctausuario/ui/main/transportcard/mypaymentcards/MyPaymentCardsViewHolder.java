package com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.PaymentCardModel;

/* loaded from: classes5.dex */
public class MyPaymentCardsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ivBranchCard)
    ImageView ivBranchCard;
    private OnCardListener listener;

    @BindView(R.id.mbDefault)
    MaterialButton mbDefault;
    private PaymentCardModel model;

    @BindView(R.id.tvDateExpired)
    TextView tvDateExpired;

    @BindView(R.id.tvDefault)
    TextView tvDefault;

    @BindView(R.id.tvNumberCard)
    TextView tvNumberCard;

    public interface OnCardListener {
        void onClickListener(PaymentCardModel model);
    }

    public MyPaymentCardsViewHolder(View itemView, OnCardListener cardListener) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.listener = cardListener;
    }

    public void bindView(PaymentCardModel model, Context context) {
        this.model = model;
        this.tvNumberCard.setText(model.getCardNumber());
        this.tvDateExpired.setText(context.getString(R.string.label_payment_card_date, model.getExpirationMonth(), model.getExpirationYear()));
        this.tvDefault.setVisibility(model.getIsFavourite().booleanValue() ? 0 : 8);
        this.mbDefault.setVisibility(model.getIsFavourite().booleanValue() ? 8 : 0);
        setBranchCard(context, model.getCardNumber());
    }

    private void setBranchCard(Context context, String cardNumber) {
        if (cardNumber.substring(0, 1).equals("5")) {
            this.ivBranchCard.setBackground(context.getDrawable(R.drawable.ic_master_card));
        } else {
            this.ivBranchCard.setBackground(context.getDrawable(R.drawable.ic_visa));
        }
    }

    @OnClick({R.id.mbDefault})
    public void onClickCard() {
        this.listener.onClickListener(this.model);
    }
}
