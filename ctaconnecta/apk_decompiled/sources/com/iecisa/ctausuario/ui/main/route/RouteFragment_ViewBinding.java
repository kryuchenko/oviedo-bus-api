package com.iecisa.ctausuario.ui.main.route;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class RouteFragment_ViewBinding implements Unbinder {
    private RouteFragment target;
    private View view7f0a007c;
    private View view7f0a007d;
    private View view7f0a007e;
    private View view7f0a009b;
    private View view7f0a01e7;
    private View view7f0a03ee;
    private TextWatcher view7f0a03eeTextWatcher;
    private View view7f0a0464;
    private TextWatcher view7f0a0464TextWatcher;
    private View view7f0a0478;

    public RouteFragment_ViewBinding(final RouteFragment target, View source) {
        this.target = target;
        target.tvErrorMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvErrorMessage, "field 'tvErrorMessage'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.tvOrigin, "field 'tvOrigin', method 'onClickEvents', and method 'onTextChangedCarOrigin'");
        target.tvOrigin = (TextView) Utils.castView(viewFindRequiredView, R.id.tvOrigin, "field 'tvOrigin'", TextView.class);
        this.view7f0a0464 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.RouteFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        TextWatcher textWatcher = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.route.RouteFragment_ViewBinding.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedCarOrigin(p0);
            }
        };
        this.view7f0a0464TextWatcher = textWatcher;
        ((TextView) viewFindRequiredView).addTextChangedListener(textWatcher);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.tvDestination, "field 'tvDestination', method 'onClickEvents', and method 'onTextChangedDestiny'");
        target.tvDestination = (TextView) Utils.castView(viewFindRequiredView2, R.id.tvDestination, "field 'tvDestination'", TextView.class);
        this.view7f0a03ee = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.RouteFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        TextWatcher textWatcher2 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.route.RouteFragment_ViewBinding.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedDestiny(p0);
            }
        };
        this.view7f0a03eeTextWatcher = textWatcher2;
        ((TextView) viewFindRequiredView2).addTextChangedListener(textWatcher2);
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.ivChangeWay, "field 'ivChangeWay' and method 'onClickEvents'");
        target.ivChangeWay = (ImageView) Utils.castView(viewFindRequiredView3, R.id.ivChangeWay, "field 'ivChangeWay'", ImageView.class);
        this.view7f0a01e7 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.RouteFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.btBus, "field 'btBus' and method 'onClickEvents'");
        target.btBus = (MaterialButton) Utils.castView(viewFindRequiredView4, R.id.btBus, "field 'btBus'", MaterialButton.class);
        this.view7f0a007d = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.RouteFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(source, R.id.btTrain, "field 'btTrain' and method 'onClickEvents'");
        target.btTrain = (MaterialButton) Utils.castView(viewFindRequiredView5, R.id.btTrain, "field 'btTrain'", MaterialButton.class);
        this.view7f0a009b = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.RouteFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(source, R.id.btAnyway, "field 'btAnyway' and method 'onClickEvents'");
        target.btAnyway = (MaterialButton) Utils.castView(viewFindRequiredView6, R.id.btAnyway, "field 'btAnyway'", MaterialButton.class);
        this.view7f0a007c = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.RouteFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(source, R.id.tvSelectDate, "field 'tvSelectDate' and method 'onClickEvents'");
        target.tvSelectDate = (TextView) Utils.castView(viewFindRequiredView7, R.id.tvSelectDate, "field 'tvSelectDate'", TextView.class);
        this.view7f0a0478 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.RouteFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        target.rvRoutes = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvRoutes, "field 'rvRoutes'", RecyclerView.class);
        View viewFindRequiredView8 = Utils.findRequiredView(source, R.id.btCalculate, "field 'btCalculate' and method 'onViewClicked'");
        target.btCalculate = (MaterialButton) Utils.castView(viewFindRequiredView8, R.id.btCalculate, "field 'btCalculate'", MaterialButton.class);
        this.view7f0a007e = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.RouteFragment_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RouteFragment routeFragment = this.target;
        if (routeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        routeFragment.tvErrorMessage = null;
        routeFragment.tvOrigin = null;
        routeFragment.tvDestination = null;
        routeFragment.ivChangeWay = null;
        routeFragment.btBus = null;
        routeFragment.btTrain = null;
        routeFragment.btAnyway = null;
        routeFragment.tvSelectDate = null;
        routeFragment.rvRoutes = null;
        routeFragment.btCalculate = null;
        this.view7f0a0464.setOnClickListener(null);
        ((TextView) this.view7f0a0464).removeTextChangedListener(this.view7f0a0464TextWatcher);
        this.view7f0a0464TextWatcher = null;
        this.view7f0a0464 = null;
        this.view7f0a03ee.setOnClickListener(null);
        ((TextView) this.view7f0a03ee).removeTextChangedListener(this.view7f0a03eeTextWatcher);
        this.view7f0a03eeTextWatcher = null;
        this.view7f0a03ee = null;
        this.view7f0a01e7.setOnClickListener(null);
        this.view7f0a01e7 = null;
        this.view7f0a007d.setOnClickListener(null);
        this.view7f0a007d = null;
        this.view7f0a009b.setOnClickListener(null);
        this.view7f0a009b = null;
        this.view7f0a007c.setOnClickListener(null);
        this.view7f0a007c = null;
        this.view7f0a0478.setOnClickListener(null);
        this.view7f0a0478 = null;
        this.view7f0a007e.setOnClickListener(null);
        this.view7f0a007e = null;
    }
}
