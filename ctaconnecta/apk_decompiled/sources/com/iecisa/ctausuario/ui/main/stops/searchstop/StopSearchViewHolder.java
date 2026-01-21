package com.iecisa.ctausuario.ui.main.stops.searchstop;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.MapStop;

/* loaded from: classes5.dex */
public class StopSearchViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.rowSearchStop)
    ConstraintLayout rowSearchStop;

    @BindView(R.id.tvCodeSearchStop)
    TextView tvCodeSearchStop;

    @BindView(R.id.tvNameSearchStop)
    TextView tvNameSearchStop;

    public StopSearchViewHolder(View itemView) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(MapStop searchStop) {
        this.tvNameSearchStop.setText(searchStop.getNameStop());
        this.tvCodeSearchStop.setText(String.valueOf(searchStop.getIdStop()));
    }
}
