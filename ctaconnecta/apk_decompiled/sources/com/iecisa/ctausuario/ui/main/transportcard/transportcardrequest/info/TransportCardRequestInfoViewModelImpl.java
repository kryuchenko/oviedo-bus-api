package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.DoBRepository;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.transportcardrequest.DoBTransactionModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class TransportCardRequestInfoViewModelImpl extends BaseViewModel implements TransportCardRequestInfoViewModel {
    private DoBRepository dobRepository;
    private NewsRepository newsRepository;

    @Inject
    public TransportCardRequestInfoViewModelImpl(Application application, NewsRepository newsRepository, DoBRepository dobRepository) {
        super(application);
        this.newsRepository = newsRepository;
        this.dobRepository = dobRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoViewModel
    public LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id) {
        return this.newsRepository.getLegalConditions(context, id);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoViewModel
    public LiveData<Resource<DoBTransactionModel>> startNewOnboardingTransaction(Context context, String authUuid, boolean isRepresentative) {
        return this.dobRepository.startNewOnboardingTransaction(context, authUuid, isRepresentative);
    }
}
