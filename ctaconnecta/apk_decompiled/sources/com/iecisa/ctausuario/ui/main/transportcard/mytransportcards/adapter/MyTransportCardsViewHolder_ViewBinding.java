package com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class MyTransportCardsViewHolder_ViewBinding implements Unbinder {
    private MyTransportCardsViewHolder target;
    private View view7f0a0207;

    public MyTransportCardsViewHolder_ViewBinding(final MyTransportCardsViewHolder target, View source) {
        this.target = target;
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.ivTypeCard, "field 'ivTypeCard' and method 'onClickCard'");
        target.ivTypeCard = (ImageView) Utils.castView(viewFindRequiredView, R.id.ivTypeCard, "field 'ivTypeCard'", ImageView.class);
        this.view7f0a0207 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.adapter.MyTransportCardsViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickCard();
            }
        });
        target.tvNameUserCard = (TextView) Utils.findRequiredViewAsType(source, R.id.tvNameUserCard, "field 'tvNameUserCard'", TextView.class);
        target.tvNumberCard = (TextView) Utils.findRequiredViewAsType(source, R.id.tvNumberCard, "field 'tvNumberCard'", TextView.class);
        target.tvBlocked = (TextView) Utils.findRequiredViewAsType(source, R.id.tvBlocked, "field 'tvBlocked'", TextView.class);
        target.gpBlocked = (Group) Utils.findRequiredViewAsType(source, R.id.gpBlocked, "field 'gpBlocked'", Group.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MyTransportCardsViewHolder myTransportCardsViewHolder = this.target;
        if (myTransportCardsViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        myTransportCardsViewHolder.ivTypeCard = null;
        myTransportCardsViewHolder.tvNameUserCard = null;
        myTransportCardsViewHolder.tvNumberCard = null;
        myTransportCardsViewHolder.tvBlocked = null;
        myTransportCardsViewHolder.gpBlocked = null;
        this.view7f0a0207.setOnClickListener(null);
        this.view7f0a0207 = null;
    }
}
