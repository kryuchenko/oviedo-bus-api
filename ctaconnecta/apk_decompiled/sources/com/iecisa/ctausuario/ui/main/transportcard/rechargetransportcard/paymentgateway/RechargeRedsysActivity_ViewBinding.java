package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway;

import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class RechargeRedsysActivity_ViewBinding implements Unbinder {
    private RechargeRedsysActivity target;

    public RechargeRedsysActivity_ViewBinding(RechargeRedsysActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public RechargeRedsysActivity_ViewBinding(RechargeRedsysActivity target, View source) {
        this.target = target;
        target.wbRedsys = (WebView) Utils.findRequiredViewAsType(source, R.id.wbRedsys, "field 'wbRedsys'", WebView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RechargeRedsysActivity rechargeRedsysActivity = this.target;
        if (rechargeRedsysActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        rechargeRedsysActivity.wbRedsys = null;
    }
}
