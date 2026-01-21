package com.iecisa.ctausuario.ui.main.transportcard.loginusercard;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.Login2FaRequest;
import com.iecisa.ctausuario.model.LoginRequest;
import com.iecisa.ctausuario.model.TokenModel;

/* loaded from: classes5.dex */
public interface LoginUserCardViewModel {
    MutableLiveData<Resource<TokenModel>> login(LoginRequest request, Context context);

    MutableLiveData<Resource<TokenModel>> login2Fa(Login2FaRequest request, Context context);
}
