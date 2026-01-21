package com.iecisa.ctausuario.ui.main.transportcard.detail.alias;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.UserRepository;
import com.iecisa.ctausuario.model.routes.ChangeAliasRequestModel;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class ChangeAliasViewModelImpl extends BaseViewModel implements ChangeAliasViewModel {
    private UserRepository userRepository;

    @Inject
    public ChangeAliasViewModelImpl(Application application, UserRepository userRepository) {
        super(application);
        this.userRepository = userRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.alias.ChangeAliasViewModel
    public LiveData<Resource<ResponseBody>> updateAlias(Context context, ChangeAliasRequestModel model) {
        return this.userRepository.updateAlias(context, model);
    }
}
