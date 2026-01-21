package com.iecisa.ctausuario.ui.main.transportcard.myaccount;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.UserRepository;
import com.iecisa.ctausuario.model.HolderRequestModel;
import com.iecisa.ctausuario.model.HolderResponseModel;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class MyAccountViewModelImpl extends BaseViewModel implements MyAccountViewModel {
    private UserRepository userRepository;

    @Inject
    public MyAccountViewModelImpl(Application application, UserRepository userRepository) {
        super(application);
        this.userRepository = userRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountViewModel
    public LiveData<Resource<HolderResponseModel>> getDetailsAccount(Context context) {
        return this.userRepository.getDetailsAccount(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountViewModel
    public LiveData<Resource<ResponseBody>> saveDataAccount(Context context, Integer holderId, HolderRequestModel requestModel) {
        return this.userRepository.saveDataAccount(context, holderId, requestModel);
    }
}
