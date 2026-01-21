package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.RechargeZones;
import java.util.List;

/* loaded from: classes5.dex */
public interface ChangeZonesRechargeViewModel {
    LiveData<Resource<List<RechargeZones>>> getTenPassRates(Context context, String cardNumber, Integer numTrips);
}
