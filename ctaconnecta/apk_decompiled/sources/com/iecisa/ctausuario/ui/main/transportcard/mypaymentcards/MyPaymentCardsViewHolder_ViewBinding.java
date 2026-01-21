package com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class MyPaymentCardsViewHolder_ViewBinding implements Unbinder {
    private MyPaymentCardsViewHolder target;
    private View view7f0a0251;

    public MyPaymentCardsViewHolder_ViewBinding(final MyPaymentCardsViewHolder target, View source) {
        this.target = target;
        target.ivBranchCard = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivBranchCard, "field 'ivBranchCard'", ImageView.class);
        target.tvNumberCard = (TextView) Utils.findRequiredViewAsType(source, R.id.tvNumberCard, "field 'tvNumberCard'", TextView.class);
        target.tvDateExpired = (TextView) Utils.findRequiredViewAsType(source, R.id.tvDateExpired, "field 'tvDateExpired'", TextView.class);
        target.tvDefault = (TextView) Utils.findRequiredViewAsType(source, R.id.tvDefault, "field 'tvDefault'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.mbDefault, "field 'mbDefault' and method 'onClickCard'");
        target.mbDefault = (MaterialButton) Utils.castView(viewFindRequiredView, R.id.mbDefault, "field 'mbDefault'", MaterialButton.class);
        this.view7f0a0251 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickCard();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MyPaymentCardsViewHolder myPaymentCardsViewHolder = this.target;
        if (myPaymentCardsViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        myPaymentCardsViewHolder.ivBranchCard = null;
        myPaymentCardsViewHolder.tvNumberCard = null;
        myPaymentCardsViewHolder.tvDateExpired = null;
        myPaymentCardsViewHolder.tvDefault = null;
        myPaymentCardsViewHolder.mbDefault = null;
        this.view7f0a0251.setOnClickListener(null);
        this.view7f0a0251 = null;
    }
}
