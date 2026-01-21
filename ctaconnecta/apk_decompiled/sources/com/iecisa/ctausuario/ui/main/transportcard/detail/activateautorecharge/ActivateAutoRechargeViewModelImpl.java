package com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.PaymentCardRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.OnlineRechargeResponseModel;
import com.iecisa.ctausuario.model.PaymentCardModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeConfigModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeModel;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ActivateAutoRechargeViewModelImpl extends BaseViewModel implements ActivateAutoRechargeViewModel {
    private NewsRepository newsRepository;
    private PaymentCardRepository paymentCardRepository;
    private TransportCardRepository repository;

    @Inject
    public ActivateAutoRechargeViewModelImpl(Application application, PaymentCardRepository paymentCardRepository, TransportCardRepository repository, NewsRepository newsRepository) {
        super(application);
        this.paymentCardRepository = paymentCardRepository;
        this.repository = repository;
        this.newsRepository = newsRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeViewModel
    public LiveData<Resource<OnlineRechargeResponseModel>> addCreditCard(Context context) {
        return this.paymentCardRepository.addPaymentCard(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeViewModel
    public LiveData<Resource<AutomaticRechargeModel>> createAutomaticRecharge(Context context, AutomaticRechargeModel model) {
        return this.repository.createAutomaticRecharge(context, model);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeViewModel
    public LiveData<Resource<List<PaymentCardModel>>> getCardTokenList(Context context) {
        return this.paymentCardRepository.getPaymentCards(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeViewModel
    public LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id) {
        return this.newsRepository.getLegalConditions(context, id);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeViewModel
    public LiveData<Resource<AutomaticRechargeConfigModel>> getAutomaticRechargeConfig(Context context) {
        return this.repository.getAutomaticRechargeConfig(context);
    }
}
