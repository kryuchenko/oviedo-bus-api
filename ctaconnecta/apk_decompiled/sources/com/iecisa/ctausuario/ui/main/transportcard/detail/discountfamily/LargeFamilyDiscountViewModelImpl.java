package com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily;

import android.app.Application;
import android.content.Context;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class LargeFamilyDiscountViewModelImpl extends BaseViewModel implements LargeFamilyDiscountViewModel {
    private NewsRepository newsRepository;
    private NfcRepository nfcRepository;
    private TransportCardRepository transportCardRepository;

    @Inject
    public LargeFamilyDiscountViewModelImpl(Application application, TransportCardRepository transportCardRepository, NfcRepository nfcRepository, NewsRepository newsRepository) {
        super(application);
        this.transportCardRepository = transportCardRepository;
        this.nfcRepository = nfcRepository;
        this.newsRepository = newsRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountViewModel
    public LiveData<Resource<ResponseBody>> getLargeFamilyDiscount(Context context, String titleCode, String cardNumber) {
        return this.transportCardRepository.getFamilyDiscount(context, titleCode, cardNumber);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountViewModel
    public Resource.Status initNfcAdapter(NfcAdapter nfcAdapter) {
        return this.nfcRepository.initNfc(nfcAdapter);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountViewModel
    public LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id) {
        return this.newsRepository.getLegalConditions(context, id);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountViewModel
    public LiveData<Resource<Boolean>> hasDiscount(Context context, String cardNumber) {
        return this.transportCardRepository.hasDiscount(context, cardNumber);
    }
}
