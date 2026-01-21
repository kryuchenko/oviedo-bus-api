package com.iecisa.ctausuario.ui.main.route.selectoradress;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.SearchAddress;

/* loaded from: classes5.dex */
public class SearchHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.rowSearchAddress)
    ConstraintLayout rowSearchAddress;

    @BindView(R.id.tvCityAddress)
    TextView tvCityAddress;

    @BindView(R.id.tvNameAddress)
    TextView tvNameAddress;

    public SearchHolder(View itemView) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(SearchAddress searchAddress) {
        this.tvNameAddress.setText(searchAddress.getNameAddress());
        this.tvCityAddress.setText(searchAddress.getDetailAddress());
    }
}
