package com.iecisa.ctausuario.ui.main.transportcard.accesssettings;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.ChangePasswordRequest;

/* loaded from: classes5.dex */
public interface AccessSettingsViewModel {
    LiveData<Resource<String>> changePassword(Context context, ChangePasswordRequest request);
}
