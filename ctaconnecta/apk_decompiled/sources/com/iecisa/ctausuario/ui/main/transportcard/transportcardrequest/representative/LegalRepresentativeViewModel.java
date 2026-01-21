package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface LegalRepresentativeViewModel {
    LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id);

    LiveData<Resource<Boolean>> getRepresentative(Context context, String dni);

    LiveData<Resource<ResponseBody>> makeUserRepresentative(Context context, String dni);
}
