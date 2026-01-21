package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzfg {
    private final RequestQueue zza;

    zzfg(RequestQueue requestQueue) {
        this.zza = requestQueue;
    }

    static /* synthetic */ void zza(TaskCompletionSource taskCompletionSource, VolleyError volleyError) {
        ApiException apiExceptionZza;
        try {
            if (volleyError.networkResponse != null) {
                int i = volleyError.networkResponse.statusCode;
                apiExceptionZza = i != 400 ? i != 403 ? zzeu.zza(volleyError) : new ApiException(new Status(PlacesStatusCodes.REQUEST_DENIED, "The provided API key is invalid.")) : new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "The provided parameters are invalid (did you include a max width or height?)."));
            }
            taskCompletionSource.trySetException(apiExceptionZza);
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
    }

    static /* synthetic */ void zzc(zzhs zzhsVar, TaskCompletionSource taskCompletionSource, Bitmap bitmap) {
        try {
            zzhsVar.zzb(bitmap);
            taskCompletionSource.trySetResult(zzhsVar.zza());
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
    }

    public final Task zzb(zzfi zzfiVar, final zzhs zzhsVar) {
        String strZzc = zzfiVar.zzc();
        Map mapZzd = zzfiVar.zzd();
        CancellationToken cancellationTokenZza = zzfiVar.zza();
        final TaskCompletionSource taskCompletionSource = cancellationTokenZza != null ? new TaskCompletionSource(cancellationTokenZza) : new TaskCompletionSource();
        final zzff zzffVar = new zzff(this, strZzc, new Response.Listener() { // from class: com.google.android.libraries.places.internal.zzfc
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                zzfg.zzc(zzhsVar, taskCompletionSource, (Bitmap) obj);
            }
        }, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, new Response.ErrorListener() { // from class: com.google.android.libraries.places.internal.zzfd
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                zzfg.zza(taskCompletionSource, volleyError);
            }
        }, mapZzd);
        if (cancellationTokenZza != null) {
            cancellationTokenZza.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzfe
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzffVar.cancel();
                }
            });
        }
        this.zza.add(zzffVar);
        return taskCompletionSource.getTask();
    }
}
