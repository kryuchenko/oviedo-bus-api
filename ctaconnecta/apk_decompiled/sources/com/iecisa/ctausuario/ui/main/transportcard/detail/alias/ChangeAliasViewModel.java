package com.iecisa.ctausuario.ui.main.transportcard.detail.alias;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.routes.ChangeAliasRequestModel;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface ChangeAliasViewModel {
    LiveData<Resource<ResponseBody>> updateAlias(Context context, ChangeAliasRequestModel model);
}
