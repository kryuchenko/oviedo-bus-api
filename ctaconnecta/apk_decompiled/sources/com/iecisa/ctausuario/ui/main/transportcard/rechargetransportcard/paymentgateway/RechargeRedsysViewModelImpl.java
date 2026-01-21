package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway;

import android.app.Application;
import android.nfc.NfcAdapter;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NfcRepository;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class RechargeRedsysViewModelImpl extends BaseViewModel implements RechargeRedsysViewModel {
    private NfcRepository nfcRepository;

    @Inject
    public RechargeRedsysViewModelImpl(Application application, NfcRepository nfcRepository) {
        super(application);
        this.nfcRepository = nfcRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysViewModel
    public Resource.Status initNfcAdapter(NfcAdapter nfcAdapter) {
        return this.nfcRepository.initNfc(nfcAdapter);
    }
}
