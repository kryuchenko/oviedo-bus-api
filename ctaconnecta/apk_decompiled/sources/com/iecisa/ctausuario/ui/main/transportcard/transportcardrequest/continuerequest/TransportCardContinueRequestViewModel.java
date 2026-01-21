package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.transportcardrequest.DoBUserDataModel;

/* loaded from: classes5.dex */
public interface TransportCardContinueRequestViewModel {
    LiveData<Resource<DoBUserDataModel>> getUserData(Context context, String requestNumber);
}
