package com.iecisa.ctausuario.ui.main.transportcard.detail.certificate;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.HolderResponseModel;
import com.iecisa.ctausuario.model.OfficeResponseModel;
import com.iecisa.ctausuario.model.dataprotection.CertificateRequestModel;
import java.util.List;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface CertificateViewModel {
    MutableLiveData<Resource<ResponseBody>> createCertificate(Context context, CertificateRequestModel model);

    LiveData<Resource<HolderResponseModel>> getDetailsAccount(Context context);

    LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id);

    LiveData<Resource<List<OfficeResponseModel>>> loadOffices(Context context);
}
