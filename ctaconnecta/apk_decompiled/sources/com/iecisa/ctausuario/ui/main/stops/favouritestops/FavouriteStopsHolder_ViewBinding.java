package com.iecisa.ctausuario.ui.main.stops.favouritestops;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class FavouriteStopsHolder_ViewBinding implements Unbinder {
    private FavouriteStopsHolder target;

    public FavouriteStopsHolder_ViewBinding(FavouriteStopsHolder target, View source) {
        this.target = target;
        target.rowFavouriteStop = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.rowFavouriteStop, "field 'rowFavouriteStop'", ConstraintLayout.class);
        target.tvNameFavouriteStop = (TextView) Utils.findRequiredViewAsType(source, R.id.tvNameFavouriteStop, "field 'tvNameFavouriteStop'", TextView.class);
        target.tvCodeFavouriteStop = (TextView) Utils.findRequiredViewAsType(source, R.id.tvCodeFavouriteStop, "field 'tvCodeFavouriteStop'", TextView.class);
        target.ivFavouriteStop = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivFavouriteStop, "field 'ivFavouriteStop'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        FavouriteStopsHolder favouriteStopsHolder = this.target;
        if (favouriteStopsHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        favouriteStopsHolder.rowFavouriteStop = null;
        favouriteStopsHolder.tvNameFavouriteStop = null;
        favouriteStopsHolder.tvCodeFavouriteStop = null;
        favouriteStopsHolder.ivFavouriteStop = null;
    }
}
