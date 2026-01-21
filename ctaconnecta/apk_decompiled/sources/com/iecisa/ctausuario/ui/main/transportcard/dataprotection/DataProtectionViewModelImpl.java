package com.iecisa.ctausuario.ui.main.transportcard.dataprotection;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.model.dataprotection.DataProtectionRequestModel;
import com.iecisa.ctausuario.model.dataprotection.DataProtectionResponseModel;
import java.util.List;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class DataProtectionViewModelImpl extends BaseViewModel implements DataProtectionViewModel {
    private TransportCardRepository transportCardRepository;

    @Inject
    public DataProtectionViewModelImpl(Application application, TransportCardRepository transportCardRepository) {
        super(application);
        this.transportCardRepository = transportCardRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.dataprotection.DataProtectionViewModel
    public LiveData<Resource<DataProtectionResponseModel>> getDataProtection(Context context) {
        return this.transportCardRepository.getDataProtection(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.dataprotection.DataProtectionViewModel
    public LiveData<Resource<ResponseBody>> saveDataProtection(Context context, List<DataProtectionRequestModel> modelList) {
        return this.transportCardRepository.saveDataProtection(context, modelList);
    }
}
