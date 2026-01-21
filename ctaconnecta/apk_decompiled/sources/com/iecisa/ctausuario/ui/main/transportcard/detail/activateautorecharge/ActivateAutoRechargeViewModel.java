package com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.OnlineRechargeResponseModel;
import com.iecisa.ctausuario.model.PaymentCardModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeConfigModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeModel;
import java.util.List;

/* loaded from: classes5.dex */
public interface ActivateAutoRechargeViewModel {
    LiveData<Resource<OnlineRechargeResponseModel>> addCreditCard(Context context);

    LiveData<Resource<AutomaticRechargeModel>> createAutomaticRecharge(Context context, AutomaticRechargeModel model);

    LiveData<Resource<AutomaticRechargeConfigModel>> getAutomaticRechargeConfig(Context context);

    LiveData<Resource<List<PaymentCardModel>>> getCardTokenList(Context context);

    LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id);
}
