package com.iecisa.ctausuario.ui.main.transportcard.detail.createreports;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.TransportCardRepository;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class CreateReportsViewModelImpl extends BaseViewModel implements CreateReportsViewModel {
    private TransportCardRepository transportCardRepository;

    @Inject
    public CreateReportsViewModelImpl(Application application, TransportCardRepository transportCardRepository) {
        super(application);
        this.transportCardRepository = transportCardRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsViewModel
    public LiveData<Resource<String>> createReport(Context context, String cardNumber, String dateSince, String dateTo) {
        return this.transportCardRepository.createReport(context, cardNumber, dateSince, dateTo);
    }
}
