package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.RechargeRepository;
import com.iecisa.ctausuario.model.RechargeZones;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ChangeZonesRechargeViewModelImpl extends BaseViewModel implements ChangeZonesRechargeViewModel {
    private RechargeRepository repository;

    @Inject
    public ChangeZonesRechargeViewModelImpl(Application application, RechargeRepository repository) {
        super(application);
        this.repository = repository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeViewModel
    public LiveData<Resource<List<RechargeZones>>> getTenPassRates(Context context, String cardNumber, Integer numTrips) {
        return this.repository.getTenPassRates(context, cardNumber, numTrips);
    }
}
