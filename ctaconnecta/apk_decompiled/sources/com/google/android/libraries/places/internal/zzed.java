package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzed {
    public static Task zza(zzaka zzakaVar) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        zzajx.zza(zzakaVar, new zzec(taskCompletionSource, zzakaVar, cancellationTokenSource), zzakb.zza());
        return taskCompletionSource.getTask();
    }
}
