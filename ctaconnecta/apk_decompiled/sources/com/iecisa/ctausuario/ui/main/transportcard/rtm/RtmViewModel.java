package com.iecisa.ctausuario.ui.main.transportcard.rtm;

import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.LoginRequest;
import com.iecisa.ctausuario.model.TokenModel;

/* loaded from: classes5.dex */
public interface RtmViewModel {
    Resource.Status initNfcAdapter(NfcAdapter nfcAdapter);

    LiveData<Resource<TokenModel>> login(LoginRequest request, Context context);

    LiveData<Resource<String>> onNfcIntentRecived(Intent intent, Context context);

    MutableLiveData<Resource<TokenModel>> refreshToken(Context context, TokenModel model);
}
