package com.iecisa.ctausuario.ui.main.route.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class WayViewHolder_ViewBinding implements Unbinder {
    private WayViewHolder target;

    public WayViewHolder_ViewBinding(WayViewHolder target, View source) {
        this.target = target;
        target.ivResume = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivResume, "field 'ivResume'", ImageView.class);
        target.tvResume = (TextView) Utils.findRequiredViewAsType(source, R.id.tvResume, "field 'tvResume'", TextView.class);
        target.ivArrow = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivArrow, "field 'ivArrow'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        WayViewHolder wayViewHolder = this.target;
        if (wayViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        wayViewHolder.ivResume = null;
        wayViewHolder.tvResume = null;
        wayViewHolder.ivArrow = null;
    }
}
