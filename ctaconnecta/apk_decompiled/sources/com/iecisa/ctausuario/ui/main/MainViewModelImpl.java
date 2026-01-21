package com.iecisa.ctausuario.ui.main;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.NotificationRepository;
import com.iecisa.ctausuario.model.notification.DeviceResponseModel;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class MainViewModelImpl extends BaseViewModel implements MainViewModel {
    private NfcRepository nfcRepository;
    private NotificationRepository notificationRepository;

    @Inject
    public MainViewModelImpl(Application application, NfcRepository nfcRepository, NotificationRepository notificationRepository) {
        super(application);
        this.nfcRepository = nfcRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.MainViewModel
    public Resource.Status initNfcAdapter(NfcAdapter nfcAdapter) {
        return this.nfcRepository.initNfc(nfcAdapter);
    }

    @Override // com.iecisa.ctausuario.ui.main.MainViewModel
    public LiveData<Resource<String>> onNfcIntentRecived(Intent intent, Context context) {
        return this.nfcRepository.validateNfcIntent(intent, context);
    }

    @Override // com.iecisa.ctausuario.ui.main.MainViewModel
    public LiveData<Resource<ResponseBody>> createNotificationService(Context context, String deviceToken) {
        return this.notificationRepository.createNotificationService(context, deviceToken);
    }

    @Override // com.iecisa.ctausuario.ui.main.MainViewModel
    public LiveData<Resource<DeviceResponseModel>> addNotificationDevice(Context context, DeviceResponseModel model) {
        return this.notificationRepository.addNotificationDevice(context, model);
    }

    @Override // com.iecisa.ctausuario.ui.main.MainViewModel
    public LiveData<Resource<ResponseBody>> updateDeviceToken(Context context, String oldDeviceToken, String newDeviceToken) {
        return this.notificationRepository.updateDeviceToken(context, oldDeviceToken, newDeviceToken);
    }
}
