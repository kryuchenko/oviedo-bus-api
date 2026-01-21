package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzfr implements Continuation {
    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        ApiException apiException;
        Exception exception = task.getException();
        if (exception == null) {
            return task;
        }
        if (exception instanceof ApiException) {
            apiException = (ApiException) exception;
        } else if (exception instanceof zzbdq) {
            zzbdo zzbdoVarZze = zzbdo.zze((zzbdq) exception);
            zzbdj zzbdjVar = zzbdj.OK;
            int iOrdinal = zzbdoVarZze.zza().ordinal();
            apiException = iOrdinal != 3 ? iOrdinal != 4 ? iOrdinal != 5 ? iOrdinal != 7 ? iOrdinal != 13 ? iOrdinal != 14 ? new ApiException(new Status(13, zzbdoVarZze.zzi())) : new ApiException(new Status(7, zzbdoVarZze.zzi())) : new ApiException(new Status(8, zzbdoVarZze.zzi())) : new ApiException(new Status(PlacesStatusCodes.REQUEST_DENIED, zzbdoVarZze.zzi())) : new ApiException(new Status(PlacesStatusCodes.NOT_FOUND, zzbdoVarZze.zzi())) : new ApiException(new Status(15, zzbdoVarZze.zzi())) : new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, zzbdoVarZze.zzi()));
        } else {
            apiException = new ApiException(new Status(13, exception.toString()));
        }
        return Tasks.forException(apiException);
    }
}
