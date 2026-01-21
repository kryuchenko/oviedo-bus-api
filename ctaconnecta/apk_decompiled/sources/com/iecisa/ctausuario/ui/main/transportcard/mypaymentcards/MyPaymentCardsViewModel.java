package com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.OnlineRechargeResponseModel;
import com.iecisa.ctausuario.model.PaymentCardModel;
import java.util.List;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface MyPaymentCardsViewModel {
    LiveData<Resource<OnlineRechargeResponseModel>> addPaymentCard(Context context);

    LiveData<Resource<List<PaymentCardModel>>> getPaymentCards(Context context);

    LiveData<Resource<ResponseBody>> removePaymentCard(Context context, Long idToken);

    LiveData<Resource<ResponseBody>> setFavouritePaymentCard(Context context, Long idToken);
}
