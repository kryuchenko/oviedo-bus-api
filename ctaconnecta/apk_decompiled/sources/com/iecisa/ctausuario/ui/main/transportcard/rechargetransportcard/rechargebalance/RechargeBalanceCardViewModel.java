package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance;

import android.content.Context;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.OnlineRechargeResponseModel;
import com.iecisa.ctausuario.model.PaymentCardModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeConfigModel;
import java.util.List;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface RechargeBalanceCardViewModel {
    LiveData<Resource<OnlineRechargeResponseModel>> addPaymentCard(Context context);

    LiveData<Resource<ResponseBody>> checkoutOneClickPayment(Context context, String cardNumber, Long idCardToken, Integer walletAmount, Integer areas, Integer trips, String mail);

    LiveData<Resource<OnlineRechargeResponseModel>> checkoutPaymentGateway(Context context, String cardNumber, String email, Integer walletAmount, Integer areas, Integer trips);

    LiveData<Resource<AutomaticRechargeConfigModel>> getAutomaticRechargeConfig(Context context);

    LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id);

    LiveData<Resource<List<PaymentCardModel>>> getPaymentCards(Context context);

    Resource.Status initNfcAdapter(NfcAdapter nfcAdapter);
}
