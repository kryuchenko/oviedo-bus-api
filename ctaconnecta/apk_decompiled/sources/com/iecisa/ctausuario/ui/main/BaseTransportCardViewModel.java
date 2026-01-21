package com.iecisa.ctausuario.ui.main;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.TokenModel;

/* loaded from: classes5.dex */
public interface BaseTransportCardViewModel {
    LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String idConditions);

    LiveData<Resource<TokenModel>> refreshToken(Context context, TokenModel model);
}
