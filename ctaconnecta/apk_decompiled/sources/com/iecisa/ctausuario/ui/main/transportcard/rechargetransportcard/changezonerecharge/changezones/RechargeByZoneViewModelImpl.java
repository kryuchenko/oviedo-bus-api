package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones;

import android.app.Application;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.TransportCardRepository;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class RechargeByZoneViewModelImpl extends BaseViewModel implements RechargeByZoneViewModel {
    private TransportCardRepository transportCardRepository;

    @Inject
    public RechargeByZoneViewModelImpl(Application application, TransportCardRepository transportCardRepository) {
        super(application);
        this.transportCardRepository = transportCardRepository;
    }
}
