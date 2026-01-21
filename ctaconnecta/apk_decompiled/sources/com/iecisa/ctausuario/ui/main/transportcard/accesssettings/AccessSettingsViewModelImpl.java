package com.iecisa.ctausuario.ui.main.transportcard.accesssettings;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.UserRepository;
import com.iecisa.ctausuario.model.ChangePasswordRequest;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class AccessSettingsViewModelImpl extends BaseViewModel implements AccessSettingsViewModel {
    protected static final String COMMA = ", ";
    protected static final String EMPTY = "";
    private UserRepository repository;

    @Inject
    public AccessSettingsViewModelImpl(Application application, UserRepository repository) {
        super(application);
        this.repository = repository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsViewModel
    public LiveData<Resource<String>> changePassword(Context context, ChangePasswordRequest request) {
        return this.repository.changePassword(context, request);
    }
}
