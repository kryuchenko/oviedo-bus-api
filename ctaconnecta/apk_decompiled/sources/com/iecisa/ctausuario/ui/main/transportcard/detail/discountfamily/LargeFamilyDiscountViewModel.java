package com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily;

import android.content.Context;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface LargeFamilyDiscountViewModel {
    LiveData<Resource<ResponseBody>> getLargeFamilyDiscount(Context context, String titleCode, String cardNumber);

    LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id);

    LiveData<Resource<Boolean>> hasDiscount(Context context, String cardNumber);

    Resource.Status initNfcAdapter(NfcAdapter nfcAdapter);
}
