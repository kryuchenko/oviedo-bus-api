package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones;

import android.content.Context;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.OnlineRechargeResponseModel;
import com.iecisa.ctausuario.model.PaymentCardModel;
import com.iecisa.ctausuario.model.RechargeZones;
import java.util.List;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface RechargeZonesViewModel {
    LiveData<Resource<OnlineRechargeResponseModel>> addPaymentCard(Context context);

    LiveData<Resource<String>> checkCardSimulations(Context context, String cardNumber, Integer trips, Integer areas, Integer price);

    LiveData<Resource<ResponseBody>> checkoutOneClickPayment(Context context, String cardNumber, Long idCardToken, Integer walletAmount, Integer areas, Integer trips, String mail);

    LiveData<Resource<OnlineRechargeResponseModel>> checkoutPaymentGateway(Context context, String cardNumber, String mail, Integer amount, Integer zones, Integer trips);

    LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id);

    LiveData<Resource<List<Integer>>> getNumTrips(Context context, String cardNumber);

    LiveData<Resource<List<RechargeZones>>> getPassRates(Context context, String cardNumber);

    LiveData<Resource<List<PaymentCardModel>>> getPaymentCards(Context context);

    LiveData<Resource<List<RechargeZones>>> getTenPassRates(Context context, String cardNumber, Integer numTrips);

    Resource.Status initNfcAdapter(NfcAdapter nfcAdapter);
}
