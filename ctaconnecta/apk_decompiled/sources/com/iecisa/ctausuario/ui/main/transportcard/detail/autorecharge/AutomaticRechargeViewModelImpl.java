package com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge;

import android.app.Application;
import android.content.Context;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.PaymentCardRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.model.PaymentCardModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeModel;
import com.iecisa.ctausuario.model.autorecharge.ErrorAutomaticRechargeModel;
import java.util.List;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class AutomaticRechargeViewModelImpl extends BaseViewModel implements AutomaticRechargeViewModel {
    private NfcRepository nfcRepository;
    private PaymentCardRepository paymentCardRepository;
    private TransportCardRepository transportCardRepository;

    @Inject
    public AutomaticRechargeViewModelImpl(Application application, TransportCardRepository transportCardRepository, PaymentCardRepository paymentCardRepository, NfcRepository nfcRepository) {
        super(application);
        this.transportCardRepository = transportCardRepository;
        this.paymentCardRepository = paymentCardRepository;
        this.nfcRepository = nfcRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeViewModel
    public LiveData<Resource<ResponseBody>> setAutomaticRecharge(Context context, AutomaticRechargeModel model, String cardNumber) {
        return this.transportCardRepository.setAutomaticRecharge(context, model, cardNumber);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeViewModel
    public LiveData<Resource<ResponseBody>> changeAutomaticRecharge(Context context, String cardNumber) {
        return this.transportCardRepository.changeAutomaticRecharge(context, cardNumber);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeViewModel
    public MutableLiveData<Resource<List<PaymentCardModel>>> getCreditCards(Context context) {
        return this.paymentCardRepository.getPaymentCards(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeViewModel
    public LiveData<Resource<AutomaticRechargeModel>> getAutomaticRechargeConfig(Context context, String cardNumber) {
        return this.transportCardRepository.getAutomaticRechargeConfig(context, cardNumber);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeViewModel
    public LiveData<Resource<ErrorAutomaticRechargeModel>> getErrorsAutoRecharge(Context context, String cardNumber) {
        return this.transportCardRepository.getErrorsAutoRecharge(context, cardNumber);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeViewModel
    public LiveData<Resource<ResponseBody>> retryAutoRecharge(Context context, Integer id) {
        return this.transportCardRepository.retryAutoRecharge(context, id);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeViewModel
    public Resource.Status initNfcAdapter(NfcAdapter nfcAdapter) {
        return this.nfcRepository.initNfc(nfcAdapter);
    }
}
