package com.iecisa.ctausuario.ui.main.incidents;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.HolderResponseModel;
import com.iecisa.ctausuario.model.IncidenceTypeResponseModel;
import com.iecisa.ctausuario.model.LoginRequest;
import com.iecisa.ctausuario.model.TokenModel;
import com.iecisa.ctausuario.model.incidence.IncidenceRequestModel;
import java.util.List;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface IncidentsViewModel {
    LiveData<Resource<HolderResponseModel>> getDetailsAccount(Context context);

    LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id);

    LiveData<Resource<List<IncidenceTypeResponseModel>>> getTypeIncidence(Context context, String cardNumber);

    LiveData<Resource<TokenModel>> login(LoginRequest request, Context context);

    LiveData<Resource<ResponseBody>> sendIncidence(Context context, IncidenceRequestModel model);
}
