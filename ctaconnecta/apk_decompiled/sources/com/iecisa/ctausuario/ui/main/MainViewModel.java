package com.iecisa.ctausuario.ui.main;

import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.notification.DeviceResponseModel;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface MainViewModel {
    LiveData<Resource<DeviceResponseModel>> addNotificationDevice(Context context, DeviceResponseModel model);

    LiveData<Resource<ResponseBody>> createNotificationService(Context context, String deviceToken);

    Resource.Status initNfcAdapter(NfcAdapter nfcAdapter);

    LiveData<Resource<String>> onNfcIntentRecived(Intent intent, Context context);

    LiveData<Resource<ResponseBody>> updateDeviceToken(Context context, String oldDeviceToken, String newDeviceToken);
}
