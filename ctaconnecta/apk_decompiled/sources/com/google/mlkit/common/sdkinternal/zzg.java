package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzg implements Continuation {
    static final Continuation zza = new zzg();

    private zzg() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        return task.getResult();
    }
}
