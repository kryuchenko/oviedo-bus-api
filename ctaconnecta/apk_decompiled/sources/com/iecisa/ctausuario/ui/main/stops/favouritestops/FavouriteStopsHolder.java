package com.iecisa.ctausuario.ui.main.stops.favouritestops;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.MapStop;

/* loaded from: classes5.dex */
public class FavouriteStopsHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ivFavouriteStop)
    ImageView ivFavouriteStop;

    @BindView(R.id.rowFavouriteStop)
    ConstraintLayout rowFavouriteStop;

    @BindView(R.id.tvCodeFavouriteStop)
    TextView tvCodeFavouriteStop;

    @BindView(R.id.tvNameFavouriteStop)
    TextView tvNameFavouriteStop;

    public FavouriteStopsHolder(View itemView) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(MapStop favouriteStop) {
        this.tvNameFavouriteStop.setText(favouriteStop.getNameStop());
        this.tvCodeFavouriteStop.setText(String.valueOf(favouriteStop.getIdStop()));
    }
}
