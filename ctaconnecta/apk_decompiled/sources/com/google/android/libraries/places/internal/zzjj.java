package com.google.android.libraries.places.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzjj {
    private final zzjf zza;
    private final Map zzb = new HashMap();

    public zzjj(zzjf zzjfVar) {
        this.zza = zzjfVar;
    }

    public final boolean zza(final TaskCompletionSource taskCompletionSource, long j, String str) {
        if (this.zzb.containsKey(taskCompletionSource)) {
            return false;
        }
        HandlerThread handlerThread = new HandlerThread("timeoutHandlerThread");
        handlerThread.start();
        this.zzb.put(taskCompletionSource, handlerThread);
        final String str2 = "Location timeout.";
        return new Handler(handlerThread.getLooper()).postDelayed(new Runnable(str2) { // from class: com.google.android.libraries.places.internal.zzjg
            public final /* synthetic */ String zzb = "Location timeout.";

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.trySetException(new ApiException(new Status(15, this.zzb)));
            }
        }, j);
    }

    public final boolean zzb(TaskCompletionSource taskCompletionSource) {
        HandlerThread handlerThread = (HandlerThread) this.zzb.remove(taskCompletionSource);
        if (handlerThread == null) {
            return false;
        }
        return handlerThread.quit();
    }
}
