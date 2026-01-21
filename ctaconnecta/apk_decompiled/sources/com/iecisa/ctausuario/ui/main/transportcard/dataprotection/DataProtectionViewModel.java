package com.iecisa.ctausuario.ui.main.transportcard.dataprotection;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.dataprotection.DataProtectionRequestModel;
import com.iecisa.ctausuario.model.dataprotection.DataProtectionResponseModel;
import java.util.List;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface DataProtectionViewModel {
    LiveData<Resource<DataProtectionResponseModel>> getDataProtection(Context context);

    LiveData<Resource<ResponseBody>> saveDataProtection(Context context, List<DataProtectionRequestModel> modelList);
}
