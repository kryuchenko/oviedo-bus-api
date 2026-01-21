package com.iecisa.ctausuario.ui.main;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.UserRepository;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.TokenModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class BaseTransportCardViewModelImpl extends BaseViewModel implements BaseTransportCardViewModel {
    private NewsRepository newsRepository;
    private UserRepository userRepository;

    @Inject
    public BaseTransportCardViewModelImpl(Application application, UserRepository userRepository, NewsRepository newsRepository) {
        super(application);
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.BaseTransportCardViewModel
    public LiveData<Resource<TokenModel>> refreshToken(Context context, TokenModel model) {
        return this.userRepository.refreshToken(context, model);
    }

    @Override // com.iecisa.ctausuario.ui.main.BaseTransportCardViewModel
    public LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String idConditions) {
        return this.newsRepository.getLegalConditions(context, idConditions);
    }
}
