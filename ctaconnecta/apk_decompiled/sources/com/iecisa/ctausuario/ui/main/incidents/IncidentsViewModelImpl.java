package com.iecisa.ctausuario.ui.main.incidents;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.data.UserRepository;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.HolderResponseModel;
import com.iecisa.ctausuario.model.IncidenceTypeResponseModel;
import com.iecisa.ctausuario.model.LoginRequest;
import com.iecisa.ctausuario.model.TokenModel;
import com.iecisa.ctausuario.model.incidence.IncidenceRequestModel;
import java.util.List;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class IncidentsViewModelImpl extends BaseViewModel implements IncidentsViewModel {
    private NewsRepository newsRepository;
    private TransportCardRepository transportCardRepository;
    private UserRepository userRepository;

    @Inject
    public IncidentsViewModelImpl(Application application, TransportCardRepository transportCardRepository, UserRepository userRepository, NewsRepository newsRepository) {
        super(application);
        this.transportCardRepository = transportCardRepository;
        this.userRepository = userRepository;
        this.newsRepository = newsRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.incidents.IncidentsViewModel
    public LiveData<Resource<HolderResponseModel>> getDetailsAccount(Context context) {
        return this.userRepository.getDetailsAccount(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.incidents.IncidentsViewModel
    public LiveData<Resource<List<IncidenceTypeResponseModel>>> getTypeIncidence(Context context, String cardNumber) {
        return this.transportCardRepository.getTypeIncidence(context, cardNumber);
    }

    @Override // com.iecisa.ctausuario.ui.main.incidents.IncidentsViewModel
    public LiveData<Resource<TokenModel>> login(LoginRequest request, Context context) {
        return this.userRepository.loginUser(request, context);
    }

    @Override // com.iecisa.ctausuario.ui.main.incidents.IncidentsViewModel
    public LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id) {
        return this.newsRepository.getLegalConditions(context, id);
    }

    @Override // com.iecisa.ctausuario.ui.main.incidents.IncidentsViewModel
    public LiveData<Resource<ResponseBody>> sendIncidence(Context context, IncidenceRequestModel model) {
        return this.userRepository.sendIncidence(context, model);
    }
}
