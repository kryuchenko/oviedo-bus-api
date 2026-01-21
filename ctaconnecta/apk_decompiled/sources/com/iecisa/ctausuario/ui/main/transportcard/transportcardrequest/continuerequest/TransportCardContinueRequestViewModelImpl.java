package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.DoBRepository;
import com.iecisa.ctausuario.model.transportcardrequest.DoBUserDataModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class TransportCardContinueRequestViewModelImpl extends BaseViewModel implements TransportCardContinueRequestViewModel {
    private DoBRepository dobRepository;

    @Inject
    public TransportCardContinueRequestViewModelImpl(Application application, DoBRepository dobRepository) {
        super(application);
        this.dobRepository = dobRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestViewModel
    public LiveData<Resource<DoBUserDataModel>> getUserData(Context context, String requestNumber) {
        return this.dobRepository.getUserData(context, requestNumber);
    }
}
