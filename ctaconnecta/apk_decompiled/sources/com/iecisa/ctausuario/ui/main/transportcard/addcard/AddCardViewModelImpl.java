package com.iecisa.ctausuario.ui.main.transportcard.addcard;

import android.app.Application;
import android.nfc.NfcAdapter;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NfcRepository;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class AddCardViewModelImpl extends BaseViewModel implements AddCardViewModel {
    private NfcRepository nfcRepository;

    @Inject
    public AddCardViewModelImpl(Application application, NfcRepository nfcRepository) {
        super(application);
        this.nfcRepository = nfcRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.addcard.AddCardViewModel
    public Resource.Status initNfcAdapter(NfcAdapter nfcAdapter) {
        return this.nfcRepository.initNfc(nfcAdapter);
    }
}
