package com.iecisa.ctausuario.ui.main.transportcard.myaccount;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.HolderRequestModel;
import com.iecisa.ctausuario.model.HolderResponseModel;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface MyAccountViewModel {
    LiveData<Resource<HolderResponseModel>> getDetailsAccount(Context context);

    LiveData<Resource<ResponseBody>> saveDataAccount(Context context, Integer holderId, HolderRequestModel requestModel);
}
