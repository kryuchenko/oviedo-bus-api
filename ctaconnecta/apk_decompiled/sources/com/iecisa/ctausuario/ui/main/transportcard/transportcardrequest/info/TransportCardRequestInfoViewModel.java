package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.transportcardrequest.DoBTransactionModel;

/* loaded from: classes5.dex */
public interface TransportCardRequestInfoViewModel {
    LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id);

    LiveData<Resource<DoBTransactionModel>> startNewOnboardingTransaction(Context context, String authUuid, boolean isRepresentative);
}
