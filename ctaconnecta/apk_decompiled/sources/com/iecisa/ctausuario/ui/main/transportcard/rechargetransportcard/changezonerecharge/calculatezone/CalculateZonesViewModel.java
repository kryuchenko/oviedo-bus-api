package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.MunicipalityResponseModel;
import com.iecisa.ctausuario.model.RechargeZones;
import java.util.List;

/* loaded from: classes5.dex */
public interface CalculateZonesViewModel {
    LiveData<Resource<List<MunicipalityResponseModel>>> getMunicipality(Context context);

    LiveData<Resource<RechargeZones>> getPriceBetweenZones(Context context, Integer origin, Integer destiny, Integer numTrips, String cardNumber);
}
