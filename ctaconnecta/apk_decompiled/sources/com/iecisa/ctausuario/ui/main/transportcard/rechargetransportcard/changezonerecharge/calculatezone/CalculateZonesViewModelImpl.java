package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.RechargeRepository;
import com.iecisa.ctausuario.model.MunicipalityResponseModel;
import com.iecisa.ctausuario.model.RechargeZones;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class CalculateZonesViewModelImpl extends BaseViewModel implements CalculateZonesViewModel {
    private RechargeRepository repository;

    @Inject
    public CalculateZonesViewModelImpl(Application application, RechargeRepository repository) {
        super(application);
        this.repository = repository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZonesViewModel
    public LiveData<Resource<List<MunicipalityResponseModel>>> getMunicipality(Context context) {
        return this.repository.getMunicipality(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZonesViewModel
    public LiveData<Resource<RechargeZones>> getPriceBetweenZones(Context context, Integer origin, Integer destiny, Integer numTrips, String cardNumber) {
        return this.repository.getPriceBetweenZones(context, origin, destiny, numTrips, cardNumber);
    }
}
