package com.iecisa.ctausuario.ui.main.transportcard.loginusercard;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.UserRepository;
import com.iecisa.ctausuario.model.Login2FaRequest;
import com.iecisa.ctausuario.model.LoginRequest;
import com.iecisa.ctausuario.model.TokenModel;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class LoginUserCardViewModelImpl extends BaseViewModel implements LoginUserCardViewModel {
    private CompositeDisposable compositeDisposable;
    private UserRepository repository;
    private SchedulerProvider schedulerProvider;

    @Inject
    public LoginUserCardViewModelImpl(Application application, UserRepository repository, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(application);
        this.repository = repository;
        this.compositeDisposable = compositeDisposable;
        this.schedulerProvider = schedulerProvider;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardViewModel
    public MutableLiveData<Resource<TokenModel>> login(LoginRequest request, Context context) {
        return this.repository.loginUser(request, context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardViewModel
    public MutableLiveData<Resource<TokenModel>> login2Fa(Login2FaRequest request, Context context) {
        return this.repository.loginUser2Fa(request, context);
    }
}
