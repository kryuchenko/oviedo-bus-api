package com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeConfigModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeModel;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface EditAutomaticRechargeViewModel {
    LiveData<Resource<AutomaticRechargeConfigModel>> getAutomaticRechargeConfig(Context context);

    LiveData<Resource<ResponseBody>> setAutomaticRecharge(Context context, AutomaticRechargeModel model, String cardNumber);
}
