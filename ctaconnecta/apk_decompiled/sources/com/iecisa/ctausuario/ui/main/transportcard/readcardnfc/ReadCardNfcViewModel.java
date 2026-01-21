package com.iecisa.ctausuario.ui.main.transportcard.readcardnfc;

import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;

/* loaded from: classes5.dex */
public interface ReadCardNfcViewModel {
    Resource.Status initNfcAdapter(NfcAdapter nfcAdapter);

    LiveData<Resource<String>> onNfcIntentRecived(Intent intent, Context context);
}
