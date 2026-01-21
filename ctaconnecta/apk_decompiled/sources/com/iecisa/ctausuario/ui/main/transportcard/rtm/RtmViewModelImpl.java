package com.iecisa.ctausuario.ui.main.transportcard.rtm;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.UserRepository;
import com.iecisa.ctausuario.model.LoginRequest;
import com.iecisa.ctausuario.model.TokenModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class RtmViewModelImpl extends BaseViewModel implements RtmViewModel {
    private NfcRepository nfcRepository;
    private UserRepository userRepository;

    @Inject
    public RtmViewModelImpl(Application application, UserRepository userRepository, NfcRepository nfcRepository) {
        super(application);
        this.nfcRepository = nfcRepository;
        this.userRepository = userRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmViewModel
    public Resource.Status initNfcAdapter(NfcAdapter nfcAdapter) {
        return this.nfcRepository.initNfc(nfcAdapter);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmViewModel
    public LiveData<Resource<String>> onNfcIntentRecived(Intent intent, Context context) {
        return this.nfcRepository.validateNfcIntent(intent, context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmViewModel
    public LiveData<Resource<TokenModel>> login(LoginRequest request, Context context) {
        return this.userRepository.loginUser(request, context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmViewModel
    public MutableLiveData<Resource<TokenModel>> refreshToken(Context context, TokenModel model) {
        return this.userRepository.refreshToken(context, model);
    }
}
