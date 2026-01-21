package com.iecisa.ctausuario.ui.main.transportcard.detail.createreports;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;

/* loaded from: classes5.dex */
public interface CreateReportsViewModel {
    LiveData<Resource<String>> createReport(Context context, String cardNumber, String dateSince, String dateTo);
}
