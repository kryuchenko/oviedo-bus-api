package com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.PaymentCardRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeConfigModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeModel;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class EditAutomaticRechargeViewModelImpl extends BaseViewModel implements EditAutomaticRechargeViewModel {
    private TransportCardRepository transportCardRepository;

    @Inject
    public EditAutomaticRechargeViewModelImpl(Application application, TransportCardRepository transportCardRepository, PaymentCardRepository paymentCardRepository) {
        super(application);
        this.transportCardRepository = transportCardRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeViewModel
    public LiveData<Resource<ResponseBody>> setAutomaticRecharge(Context context, AutomaticRechargeModel model, String cardNumber) {
        return this.transportCardRepository.setAutomaticRecharge(context, model, cardNumber);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeViewModel
    public LiveData<Resource<AutomaticRechargeConfigModel>> getAutomaticRechargeConfig(Context context) {
        return this.transportCardRepository.getAutomaticRechargeConfig(context);
    }
}
