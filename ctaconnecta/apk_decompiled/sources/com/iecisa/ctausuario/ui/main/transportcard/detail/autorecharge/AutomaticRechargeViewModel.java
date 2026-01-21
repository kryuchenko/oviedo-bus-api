package com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge;

import android.content.Context;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.PaymentCardModel;
import com.iecisa.ctausuario.model.autorecharge.AutomaticRechargeModel;
import com.iecisa.ctausuario.model.autorecharge.ErrorAutomaticRechargeModel;
import java.util.List;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface AutomaticRechargeViewModel {
    LiveData<Resource<ResponseBody>> changeAutomaticRecharge(Context context, String cardNumber);

    LiveData<Resource<AutomaticRechargeModel>> getAutomaticRechargeConfig(Context context, String cardNumber);

    LiveData<Resource<List<PaymentCardModel>>> getCreditCards(Context context);

    LiveData<Resource<ErrorAutomaticRechargeModel>> getErrorsAutoRecharge(Context context, String cardNumber);

    Resource.Status initNfcAdapter(NfcAdapter nfcAdapter);

    LiveData<Resource<ResponseBody>> retryAutoRecharge(Context context, Integer id);

    LiveData<Resource<ResponseBody>> setAutomaticRecharge(Context context, AutomaticRechargeModel model, String cardNumber);
}
