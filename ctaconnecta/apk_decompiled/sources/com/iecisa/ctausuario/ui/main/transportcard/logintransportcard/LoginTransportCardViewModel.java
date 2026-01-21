package com.iecisa.ctausuario.ui.main.transportcard.logintransportcard;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.LoginRequest;
import com.iecisa.ctausuario.model.TokenModel;
import com.iecisa.ctausuario.model.transportcarddetail.ImpersonalTransportCardModel;

/* loaded from: classes5.dex */
public interface LoginTransportCardViewModel {
    LiveData<Resource<ImpersonalTransportCardModel>> getDetailTransportCard(Context context, String cardNumberText, String cardCharacter);

    LiveData<Resource<TokenModel>> login(LoginRequest request, Context context);
}
