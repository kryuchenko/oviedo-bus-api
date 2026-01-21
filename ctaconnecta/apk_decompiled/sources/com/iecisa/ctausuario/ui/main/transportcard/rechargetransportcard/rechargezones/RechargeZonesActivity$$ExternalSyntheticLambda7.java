package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones;

import androidx.lifecycle.Observer;
import com.cexmobility.core.data.Resource;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes5.dex */
public final /* synthetic */ class RechargeZonesActivity$$ExternalSyntheticLambda7 implements Observer {
    public final /* synthetic */ RechargeZonesActivity f$0;

    public /* synthetic */ RechargeZonesActivity$$ExternalSyntheticLambda7(RechargeZonesActivity rechargeZonesActivity) {
        this.f$0 = rechargeZonesActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f$0.onGetRatesResponse((Resource) obj);
    }
}
