package com.iecisa.ctausuario.ui.userdestination;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class DestinationUserSelectorActivity_ViewBinding implements Unbinder {
    private DestinationUserSelectorActivity target;
    private View view7f0a0208;
    private View view7f0a0254;
    private View view7f0a0422;

    public DestinationUserSelectorActivity_ViewBinding(DestinationUserSelectorActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public DestinationUserSelectorActivity_ViewBinding(final DestinationUserSelectorActivity target, View source) {
        this.target = target;
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.ivUserLocation, "field 'ivUserLocation' and method 'onEventClick'");
        target.ivUserLocation = (ImageView) Utils.castView(viewFindRequiredView, R.id.ivUserLocation, "field 'ivUserLocation'", ImageView.class);
        this.view7f0a0208 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClick(p0);
            }
        });
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvLabelEnterDirection, "field 'tvLabelEnterDirection' and method 'onEventClick'");
        target.tvLabelEnterDirection = (TextView) Utils.castView(viewFindRequiredView2, R.id.tvLabelEnterDirection, "field 'tvLabelEnterDirection'", TextView.class);
        this.view7f0a0422 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClick(p0);
            }
        });
        target.clSnackBarTop = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.clSnackBarTop, "field 'clSnackBarTop'", ConstraintLayout.class);
        target.tvMessageSnackBarTop = (TextView) Utils.findRequiredViewAsType(source, R.id.tvMessageSnackBarTop, "field 'tvMessageSnackBarTop'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.mbGoToGoogleMaps, "method 'onEventClick'");
        this.view7f0a0254 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClick(p0);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DestinationUserSelectorActivity destinationUserSelectorActivity = this.target;
        if (destinationUserSelectorActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        destinationUserSelectorActivity.ivUserLocation = null;
        destinationUserSelectorActivity.toolbar = null;
        destinationUserSelectorActivity.tvLabelEnterDirection = null;
        destinationUserSelectorActivity.clSnackBarTop = null;
        destinationUserSelectorActivity.tvMessageSnackBarTop = null;
        this.view7f0a0208.setOnClickListener(null);
        this.view7f0a0208 = null;
        this.view7f0a0422.setOnClickListener(null);
        this.view7f0a0422 = null;
        this.view7f0a0254.setOnClickListener(null);
        this.view7f0a0254 = null;
    }
}
