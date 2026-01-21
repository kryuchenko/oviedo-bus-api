package com.iecisa.ctausuario.ui.main.transportcard.readcardnfc;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NfcRepository;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ReadCardNfcViewModelImpl extends BaseViewModel implements ReadCardNfcViewModel {
    private NfcRepository nfcRepository;

    @Inject
    public ReadCardNfcViewModelImpl(Application application, NfcRepository nfcRepository) {
        super(application);
        this.nfcRepository = nfcRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.readcardnfc.ReadCardNfcViewModel
    public Resource.Status initNfcAdapter(NfcAdapter nfcAdapter) {
        return this.nfcRepository.initNfc(nfcAdapter);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.readcardnfc.ReadCardNfcViewModel
    public LiveData<Resource<String>> onNfcIntentRecived(Intent intent, Context context) {
        return this.nfcRepository.validateNfcIntent(intent, context);
    }
}
