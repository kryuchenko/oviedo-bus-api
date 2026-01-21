package com.iecisa.ctausuario.ui.main.transportcard.mytransportcards;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.model.AddCardRequestModel;
import com.iecisa.ctausuario.model.CardRechargePermissionResponseModel;
import com.iecisa.ctausuario.model.CardResponseModel;
import java.util.List;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class MyTransportCardsViewModelImpl extends BaseViewModel implements MyTransportCardsViewModel {
    private TransportCardRepository transportCardRepository;

    @Inject
    public MyTransportCardsViewModelImpl(Application application, TransportCardRepository transportCardRepository) {
        super(application);
        this.transportCardRepository = transportCardRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsViewModel
    public LiveData<Resource<String>> addTransportCard(AddCardRequestModel requestModel, Context context) {
        return this.transportCardRepository.addTransportCard(requestModel, context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsViewModel
    public MutableLiveData<Resource<ResponseBody>> removeTransportCard(String numChip, Context context) {
        return this.transportCardRepository.removeTransportCard(numChip, context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsViewModel
    public MutableLiveData<Resource<List<CardResponseModel>>> getTransportCards(Context context) {
        return this.transportCardRepository.getTransportCards(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsViewModel
    public LiveData<Resource<CardRechargePermissionResponseModel>> getRechargePermission(Context context, String nif) {
        return this.transportCardRepository.getRechargePermission(context, nif);
    }
}
