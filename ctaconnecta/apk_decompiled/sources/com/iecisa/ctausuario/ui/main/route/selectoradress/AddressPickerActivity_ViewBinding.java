package com.iecisa.ctausuario.ui.main.route.selectoradress;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class AddressPickerActivity_ViewBinding implements Unbinder {
    private AddressPickerActivity target;
    private View view7f0a0464;
    private View view7f0a0479;
    private View view7f0a04ac;

    public AddressPickerActivity_ViewBinding(AddressPickerActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public AddressPickerActivity_ViewBinding(final AddressPickerActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.tvOrigin, "field 'tvOrigin' and method 'onEventsClick'");
        target.tvOrigin = (TextView) Utils.castView(viewFindRequiredView, R.id.tvOrigin, "field 'tvOrigin'", TextView.class);
        this.view7f0a0464 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventsClick(p0);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvUserLocation, "field 'tvUserLocation' and method 'onEventsClick'");
        target.tvUserLocation = (TextView) Utils.castView(viewFindRequiredView2, R.id.tvUserLocation, "field 'tvUserLocation'", TextView.class);
        this.view7f0a04ac = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventsClick(p0);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.tvSelectOnMap, "field 'tvSelectOnMap' and method 'onEventsClick'");
        target.tvSelectOnMap = (TextView) Utils.castView(viewFindRequiredView3, R.id.tvSelectOnMap, "field 'tvSelectOnMap'", TextView.class);
        this.view7f0a0479 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventsClick(p0);
            }
        });
        target.rvSaveSearch = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvSaveSearch, "field 'rvSaveSearch'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AddressPickerActivity addressPickerActivity = this.target;
        if (addressPickerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        addressPickerActivity.toolbar = null;
        addressPickerActivity.tvOrigin = null;
        addressPickerActivity.tvUserLocation = null;
        addressPickerActivity.tvSelectOnMap = null;
        addressPickerActivity.rvSaveSearch = null;
        this.view7f0a0464.setOnClickListener(null);
        this.view7f0a0464 = null;
        this.view7f0a04ac.setOnClickListener(null);
        this.view7f0a04ac = null;
        this.view7f0a0479.setOnClickListener(null);
        this.view7f0a0479 = null;
    }
}
