package com.iecisa.ctausuario.ui.main.transportcard.detail.certificate;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.data.UserRepository;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.HolderResponseModel;
import com.iecisa.ctausuario.model.OfficeResponseModel;
import com.iecisa.ctausuario.model.dataprotection.CertificateRequestModel;
import java.util.List;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class CertificateViewModelImpl extends BaseViewModel implements CertificateViewModel {
    private NewsRepository newsRepository;
    private TransportCardRepository transportCardRepository;
    private UserRepository userRepository;

    @Inject
    public CertificateViewModelImpl(Application application, TransportCardRepository transportCardRepository, UserRepository userRepository, NewsRepository newsRepository) {
        super(application);
        this.transportCardRepository = transportCardRepository;
        this.userRepository = userRepository;
        this.newsRepository = newsRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateViewModel
    public MutableLiveData<Resource<ResponseBody>> createCertificate(Context context, CertificateRequestModel model) {
        return this.transportCardRepository.createCertificate(context, model);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateViewModel
    public LiveData<Resource<List<OfficeResponseModel>>> loadOffices(Context context) {
        return this.transportCardRepository.loadOffices(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateViewModel
    public LiveData<Resource<HolderResponseModel>> getDetailsAccount(Context context) {
        return this.userRepository.getDetailsAccount(context);
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateViewModel
    public LiveData<Resource<ConditionsResponseModel>> getLegalConditions(Context context, String id) {
        return this.newsRepository.getLegalConditions(context, id);
    }
}
