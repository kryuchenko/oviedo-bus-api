package com.iecisa.ctausuario.ui.main.transportcard.mytransportcards;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.AddCardRequestModel;
import com.iecisa.ctausuario.model.CardRechargePermissionResponseModel;
import com.iecisa.ctausuario.model.CardResponseModel;
import java.util.List;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface MyTransportCardsViewModel {
    LiveData<Resource<String>> addTransportCard(AddCardRequestModel requestModel, Context context);

    LiveData<Resource<CardRechargePermissionResponseModel>> getRechargePermission(Context context, String nif);

    MutableLiveData<Resource<List<CardResponseModel>>> getTransportCards(Context context);

    MutableLiveData<Resource<ResponseBody>> removeTransportCard(String numChip, Context context);
}
