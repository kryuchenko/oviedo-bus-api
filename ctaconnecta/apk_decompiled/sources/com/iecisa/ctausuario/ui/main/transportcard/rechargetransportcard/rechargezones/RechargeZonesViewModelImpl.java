package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones;

import android.app.Application;
import android.content.Context;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.PaymentCardRepository;
import com.iecisa.ctausuario.data.RechargeRepository;
import com.iecisa.ctausuario.data.RtmRepository;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.OnlineRechargeResponseModel;
import com.iecisa.ctausuario.model.PaymentCardModel;
import com.iecisa.ctausuario.model.RechargeZones;
import java.util.List;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class RechargeZonesViewModelImpl extends BaseViewModel implements RechargeZonesViewModel {
    private NewsRepository newsRepository;
    private NfcRepository nfcRepository;
    private PaymentCardRepository paymentCardRepository;
    private RechargeRepository rechargeRepository;
    private RtmRepository rtmRepository;

    @Inject
    public RechargeZonesViewModelImpl(Application application, RechargeRepository rechargeRepository, PaymentCardRepository paymentCardRepository, RtmRepository rtmRepository, NfcRepository nfcRepository, NewsRepository newsRepository) {
        super(application);
        this.paymentCardRepository = paymentCardRepository;
        this.rechargeRepository = rechargeRepository;
        this.newsRepository = newsRepository;
        this.nfcRepository = nfcRepository;
        this.rtmRepository = rtmRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesViewModel
    public LiveData<Resource<List<Integer>>> getNumTrips(Context context, String cardNumber) {
        return this.rechargeRepository.getNumTrips(context, cardNumber);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesViewModel
    public LiveData<Resource<List<RechargeZones>>> getPassRates(Context context, String cardNumber) {
        return this.rechargeRepository.getPassRates(context, cardNumber);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesViewModel
    public LiveData<Resource<OnlineRechargeResponseModel>> checkoutPaymentGateway(Context context, String cardNumber, String mail, Integer amount, Integer zones, Integer trips) {
        return this.rechargeRepository.checkoutPaymentGateway(context, cardNumber, mail, amount, zones, trips);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesViewModel
    public LiveData<Resource<List<RechargeZones>>> getTenPassRates(Context context, String cardNumber, Integer numTrips) {
        return this.rechargeRepository.getTenPassRates(context, cardNumber, numTrips);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesViewModel
    public LiveData<Resource<List<PaymentCardModel>>> getPaymentCards(Context context) {
        return this.paymentCardRepository.getPaymentCards(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesViewModel
    public LiveData<Resource<ResponseBody>> checkoutOneClickPayment(Context context, String cardNumber, Long creditCardId, Integer walletAmount, Integer areas, Integer trips, String mail) {
        return this.rechargeRepository.checkoutOneClickPayment(context, cardNumber, creditCardId, walletAmount, areas, trips, mail);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesViewModel
    public Resource.Status initNfcAdapter(NfcAdapter nfcAdapter) {
        return this.nfcRepository.initNfc(nfcAdapter);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesViewModel
    public LiveData<Resource<OnlineRechargeResponseModel>> addPaymentCard(Context context) {
        return this.paymentCardRepository.addPaymentCard(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesViewModel
    public LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id) {
        return this.newsRepository.getLegalConditions(context, id);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesViewModel
    public LiveData<Resource<String>> checkCardSimulations(Context context, String cardNumber, Integer trips, Integer areas, Integer price) {
        return this.rtmRepository.checkCardSimulations(context, cardNumber, trips, areas, price);
    }
}
