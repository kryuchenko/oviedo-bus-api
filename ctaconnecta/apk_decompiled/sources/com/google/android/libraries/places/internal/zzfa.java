package com.google.android.libraries.places.internal;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzfa {
    private final RequestQueue zza;
    private final zzij zzb;

    zzfa(RequestQueue requestQueue, zzij zzijVar) {
        this.zza = requestQueue;
        this.zzb = zzijVar;
    }

    static /* synthetic */ void zzc(TaskCompletionSource taskCompletionSource, VolleyError volleyError) {
        try {
            taskCompletionSource.trySetException(zzeu.zza(volleyError));
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
    }

    public final Task zza(zzfi zzfiVar, final Class cls) {
        String strZzc = zzfiVar.zzc();
        Map mapZzd = zzfiVar.zzd();
        CancellationToken cancellationTokenZza = zzfiVar.zza();
        final TaskCompletionSource taskCompletionSource = cancellationTokenZza != null ? new TaskCompletionSource(cancellationTokenZza) : new TaskCompletionSource();
        final zzez zzezVar = new zzez(this, 0, strZzc, null, new Response.Listener() { // from class: com.google.android.libraries.places.internal.zzew
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                this.zza.zzb(cls, taskCompletionSource, (JSONObject) obj);
            }
        }, new Response.ErrorListener() { // from class: com.google.android.libraries.places.internal.zzex
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                zzfa.zzc(taskCompletionSource, volleyError);
            }
        }, mapZzd);
        if (cancellationTokenZza != null) {
            cancellationTokenZza.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzey
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzezVar.cancel();
                }
            });
        }
        this.zza.add(zzezVar);
        return taskCompletionSource.getTask();
    }

    final /* synthetic */ void zzb(Class cls, TaskCompletionSource taskCompletionSource, JSONObject jSONObject) {
        try {
            try {
                taskCompletionSource.trySetResult((zzfj) this.zzb.zza(jSONObject.toString(), cls));
            } catch (zzfk e) {
                taskCompletionSource.trySetException(new ApiException(new Status(8, e.getMessage())));
            }
        } catch (Error | RuntimeException e2) {
            zzkd.zzb(e2);
            throw e2;
        }
    }
}
