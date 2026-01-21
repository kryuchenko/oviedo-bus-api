package com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.RecoverPasswordResponseModel;
import com.iecisa.ctausuario.model.TokenModel;

/* loaded from: classes5.dex */
public interface RecoverPasswordViewModel {
    LiveData<Resource<TokenModel>> loginUser(Context context);

    LiveData<Resource<RecoverPasswordResponseModel>> recoverPassword(String nif, Context context);
}
