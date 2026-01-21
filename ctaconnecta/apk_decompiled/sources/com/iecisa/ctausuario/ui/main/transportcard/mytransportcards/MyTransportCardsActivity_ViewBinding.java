package com.iecisa.ctausuario.ui.main.transportcard.mytransportcards;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class MyTransportCardsActivity_ViewBinding implements Unbinder {
    private MyTransportCardsActivity target;
    private View view7f0a007a;

    public MyTransportCardsActivity_ViewBinding(MyTransportCardsActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public MyTransportCardsActivity_ViewBinding(final MyTransportCardsActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.rvTransportCards = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvTransportCards, "field 'rvTransportCards'", RecyclerView.class);
        target.tvCardAdded = (TextView) Utils.findRequiredViewAsType(source, R.id.tvCardAdded, "field 'tvCardAdded'", TextView.class);
        target.tvInfoMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoMessage, "field 'tvInfoMessage'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.btAddCard, "method 'onClickAddCard'");
        this.view7f0a007a = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickAddCard();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MyTransportCardsActivity myTransportCardsActivity = this.target;
        if (myTransportCardsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        myTransportCardsActivity.toolbar = null;
        myTransportCardsActivity.rvTransportCards = null;
        myTransportCardsActivity.tvCardAdded = null;
        myTransportCardsActivity.tvInfoMessage = null;
        this.view7f0a007a.setOnClickListener(null);
        this.view7f0a007a = null;
    }
}
