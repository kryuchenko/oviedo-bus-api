package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard;

import android.content.Context;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.CardRechargePermissionResponseModel;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface DetailTransportCardViewModel {
    LiveData<Resource<ResponseBody>> activateCard(Context context, String cardNumber);

    LiveData<Resource<CardRechargePermissionResponseModel>> getRechargePermission(Context context, String nif);

    Resource.Status initNfcAdapter(NfcAdapter nfcAdapter);

    LiveData<Resource<TransportCardModel>> loadDetailsCard(Context context, String cardSerialNumber, Integer cardTypeId);
}
