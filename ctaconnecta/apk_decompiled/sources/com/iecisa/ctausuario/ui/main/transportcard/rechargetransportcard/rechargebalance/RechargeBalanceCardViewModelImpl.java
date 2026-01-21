package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance;

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
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.OnlineRechargeResponseModel;
import com.iecisa.ctausuario.model.PaymentCardModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeConfigModel;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class RechargeBalanceCardViewModelImpl extends BaseViewModel implements RechargeBalanceCardViewModel {
    private CompositeDisposable compositeDisposable;
    private NewsRepository newsRepository;
    private NfcRepository nfcRepository;
    private PaymentCardRepository paymentCardRepository;
    private RechargeRepository rechargeRepository;
    private RtmRepository rtmRepository;
    private SchedulerProvider schedulerProvider;
    private TransportCardRepository transportCardRepository;

    @Inject
    public RechargeBalanceCardViewModelImpl(Application application, TransportCardRepository transportCardRepository, RechargeRepository rechargeRepository, PaymentCardRepository paymentCardRepository, NfcRepository nfcRepository, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider, NewsRepository newsRepository, RtmRepository rtmRepository) {
        super(application);
        this.transportCardRepository = transportCardRepository;
        this.rechargeRepository = rechargeRepository;
        this.paymentCardRepository = paymentCardRepository;
        this.nfcRepository = nfcRepository;
        this.compositeDisposable = compositeDisposable;
        this.schedulerProvider = schedulerProvider;
        this.newsRepository = newsRepository;
        this.rtmRepository = rtmRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardViewModel
    public LiveData<Resource<OnlineRechargeResponseModel>> checkoutPaymentGateway(Context context, String cardNumber, String email, Integer walletAmount, Integer areas, Integer trips) {
        return this.rechargeRepository.checkoutPaymentGateway(context, cardNumber, email, walletAmount, areas, trips);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardViewModel
    public LiveData<Resource<List<PaymentCardModel>>> getPaymentCards(Context context) {
        return this.paymentCardRepository.getPaymentCards(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardViewModel
    public LiveData<Resource<OnlineRechargeResponseModel>> addPaymentCard(Context context) {
        return this.paymentCardRepository.addPaymentCard(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardViewModel
    public LiveData<Resource<ResponseBody>> checkoutOneClickPayment(Context context, String cardNumber, Long idCardToken, Integer walletAmount, Integer areas, Integer trips, String mail) {
        return this.rechargeRepository.checkoutOneClickPayment(context, cardNumber, idCardToken, walletAmount, areas, trips, mail);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardViewModel
    public Resource.Status initNfcAdapter(NfcAdapter nfcAdapter) {
        return this.nfcRepository.initNfc(nfcAdapter);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardViewModel
    public LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id) {
        return this.newsRepository.getLegalConditions(context, id);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardViewModel
    public LiveData<Resource<AutomaticRechargeConfigModel>> getAutomaticRechargeConfig(Context context) {
        return this.rechargeRepository.getAutomaticRechargeConfig(context);
    }
}
