package com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class MyPaymentCardsActivity_ViewBinding implements Unbinder {
    private MyPaymentCardsActivity target;
    private View view7f0a007a;

    public MyPaymentCardsActivity_ViewBinding(MyPaymentCardsActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public MyPaymentCardsActivity_ViewBinding(final MyPaymentCardsActivity target, View source) {
        this.target = target;
        target.tvCardAdded = (TextView) Utils.findRequiredViewAsType(source, R.id.tvCardAdded, "field 'tvCardAdded'", TextView.class);
        target.tvInfoMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoMessage, "field 'tvInfoMessage'", TextView.class);
        target.rvCard = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvCard, "field 'rvCard'", RecyclerView.class);
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.btAddCard, "method 'onViewClicked'");
        this.view7f0a007a = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MyPaymentCardsActivity myPaymentCardsActivity = this.target;
        if (myPaymentCardsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        myPaymentCardsActivity.tvCardAdded = null;
        myPaymentCardsActivity.tvInfoMessage = null;
        myPaymentCardsActivity.rvCard = null;
        myPaymentCardsActivity.toolbar = null;
        this.view7f0a007a.setOnClickListener(null);
        this.view7f0a007a = null;
    }
}
