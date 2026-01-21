package com.iecisa.ctausuario.ui.main.stops.favouritestops;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class FavouriteStopsFragment_ViewBinding implements Unbinder {
    private FavouriteStopsFragment target;

    public FavouriteStopsFragment_ViewBinding(FavouriteStopsFragment target, View source) {
        this.target = target;
        target.rvFavouriteStops = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvFavouriteStops, "field 'rvFavouriteStops'", RecyclerView.class);
        target.ivBackgroundNoFavouriteStops = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivBackgroundNoFavouriteStops, "field 'ivBackgroundNoFavouriteStops'", ImageView.class);
        target.tvLabelNoFavouriteStops = (TextView) Utils.findRequiredViewAsType(source, R.id.tvLabelNoFavouriteStops, "field 'tvLabelNoFavouriteStops'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        FavouriteStopsFragment favouriteStopsFragment = this.target;
        if (favouriteStopsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        favouriteStopsFragment.rvFavouriteStops = null;
        favouriteStopsFragment.ivBackgroundNoFavouriteStops = null;
        favouriteStopsFragment.tvLabelNoFavouriteStops = null;
    }
}
