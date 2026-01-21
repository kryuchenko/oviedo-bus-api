package com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.PaymentCardRepository;
import com.iecisa.ctausuario.model.OnlineRechargeResponseModel;
import com.iecisa.ctausuario.model.PaymentCardModel;
import java.util.List;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class MyPaymentCardsViewModelImpl extends BaseViewModel implements MyPaymentCardsViewModel {
    private PaymentCardRepository repository;

    @Inject
    public MyPaymentCardsViewModelImpl(Application application, PaymentCardRepository repository) {
        super(application);
        this.repository = repository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsViewModel
    public LiveData<Resource<List<PaymentCardModel>>> getPaymentCards(Context context) {
        return this.repository.getPaymentCards(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsViewModel
    public LiveData<Resource<ResponseBody>> removePaymentCard(Context context, Long idToken) {
        return this.repository.removePaymentCard(context, idToken);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsViewModel
    public LiveData<Resource<ResponseBody>> setFavouritePaymentCard(Context context, Long idToken) {
        return this.repository.setFavouritePaymentCard(context, idToken);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsViewModel
    public LiveData<Resource<OnlineRechargeResponseModel>> addPaymentCard(Context context) {
        return this.repository.addPaymentCard(context);
    }
}
