package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.DoBRepository;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class LegalRepresentativeViewModelImpl extends BaseViewModel implements LegalRepresentativeViewModel {
    private DoBRepository dobRepository;
    private NewsRepository newsRepository;

    @Inject
    public LegalRepresentativeViewModelImpl(Application application, NewsRepository newsRepository, DoBRepository dobRepository) {
        super(application);
        this.newsRepository = newsRepository;
        this.dobRepository = dobRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeViewModel
    public LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id) {
        return this.newsRepository.getLegalConditions(context, id);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeViewModel
    public LiveData<Resource<Boolean>> getRepresentative(Context context, String dni) {
        return this.dobRepository.getRepresentative(context, dni);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeViewModel
    public LiveData<Resource<ResponseBody>> makeUserRepresentative(Context context, String dni) {
        return this.dobRepository.makeUserRepresentative(context, dni);
    }
}
