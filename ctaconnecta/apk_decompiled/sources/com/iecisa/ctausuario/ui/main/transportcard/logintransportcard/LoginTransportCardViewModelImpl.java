package com.iecisa.ctausuario.ui.main.transportcard.logintransportcard;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.data.UserRepository;
import com.iecisa.ctausuario.model.LoginRequest;
import com.iecisa.ctausuario.model.TokenModel;
import com.iecisa.ctausuario.model.transportcarddetail.ImpersonalTransportCardModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class LoginTransportCardViewModelImpl extends BaseViewModel implements LoginTransportCardViewModel {
    private TransportCardRepository transportCardRepository;
    private UserRepository userRepository;

    @Inject
    public LoginTransportCardViewModelImpl(Application application, TransportCardRepository transportCardRepository, UserRepository userRepository) {
        super(application);
        this.transportCardRepository = transportCardRepository;
        this.userRepository = userRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardViewModel
    public LiveData<Resource<ImpersonalTransportCardModel>> getDetailTransportCard(Context context, String cardNumberText, String cardCharacter) {
        return this.transportCardRepository.getDetailTransportCard(context, cardNumberText, cardCharacter);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardViewModel
    public LiveData<Resource<TokenModel>> login(LoginRequest request, Context context) {
        return this.userRepository.loginUser(request, context);
    }
}
