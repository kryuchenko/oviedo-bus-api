package com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.data.UserRepository;
import com.iecisa.ctausuario.model.LoginRequest;
import com.iecisa.ctausuario.model.RecoverPasswordResponseModel;
import com.iecisa.ctausuario.model.TokenModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class RecoverPasswordViewModelImpl extends BaseViewModel implements RecoverPasswordViewModel {
    private UserRepository repository;

    @Inject
    public RecoverPasswordViewModelImpl(Application application, UserRepository repository) {
        super(application);
        this.repository = repository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordViewModel
    public LiveData<Resource<RecoverPasswordResponseModel>> recoverPassword(String nif, Context context) {
        return this.repository.recoverPassword(nif, context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordViewModel
    public LiveData<Resource<TokenModel>> loginUser(Context context) {
        return this.repository.loginUser(new LoginRequest(BuildConfig.LOGIN_USER, BuildConfig.LOGIN_PASS), context);
    }
}
