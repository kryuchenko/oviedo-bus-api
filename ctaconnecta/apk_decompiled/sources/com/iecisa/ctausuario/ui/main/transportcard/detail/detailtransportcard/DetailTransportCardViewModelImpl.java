package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard;

import android.app.Application;
import android.content.Context;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.model.CardRechargePermissionResponseModel;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class DetailTransportCardViewModelImpl extends BaseViewModel implements DetailTransportCardViewModel {
    private NfcRepository nfcRepository;
    private TransportCardRepository transportCardRepository;

    @Inject
    public DetailTransportCardViewModelImpl(Application application, TransportCardRepository transportCardRepository, NfcRepository nfcRepository) {
        super(application);
        this.transportCardRepository = transportCardRepository;
        this.nfcRepository = nfcRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardViewModel
    public LiveData<Resource<TransportCardModel>> loadDetailsCard(Context context, String cardSerialNumber, Integer cardTypeId) {
        return this.transportCardRepository.loadDetailsCard(context, cardSerialNumber, cardTypeId);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardViewModel
    public Resource.Status initNfcAdapter(NfcAdapter nfcAdapter) {
        return this.nfcRepository.initNfc(nfcAdapter);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardViewModel
    public LiveData<Resource<ResponseBody>> activateCard(Context context, String cardNumber) {
        return this.transportCardRepository.activateCard(context, cardNumber);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardViewModel
    public LiveData<Resource<CardRechargePermissionResponseModel>> getRechargePermission(Context context, String nif) {
        return this.transportCardRepository.getRechargePermission(context, nif);
    }
}
