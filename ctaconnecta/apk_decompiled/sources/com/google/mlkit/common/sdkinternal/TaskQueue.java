package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzw;
import com.google.mlkit.common.sdkinternal.TaskQueue;
import java.io.Closeable;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class TaskQueue {
    private boolean zzb;
    private final Object zza = new Object();
    private final Queue<zzb> zzc = new ArrayDeque();
    private final AtomicReference<Thread> zzd = new AtomicReference<>();

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    static class zzb {
        final Executor zza;
        final Runnable zzb;

        private zzb(Executor executor, Runnable runnable) {
            this.zza = executor;
            this.zzb = runnable;
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    class zza implements Closeable, AutoCloseable {
        private zza() {
            Preconditions.checkState(((Thread) TaskQueue.this.zzd.getAndSet(Thread.currentThread())) == null);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            TaskQueue.this.zzd.set(null);
            TaskQueue.this.zza();
        }
    }

    public void submit(Executor executor, Runnable runnable) {
        synchronized (this.zza) {
            if (this.zzb) {
                this.zzc.add(new zzb(executor, runnable));
            } else {
                this.zzb = true;
                zza(executor, runnable);
            }
        }
    }

    private final void zza(Executor executor, final Runnable runnable) {
        executor.execute(new Runnable(this, runnable) { // from class: com.google.mlkit.common.sdkinternal.zzq
            private final TaskQueue zza;
            private final Runnable zzb;

            {
                this.zza = this;
                this.zzb = runnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TaskQueue taskQueue = this.zza;
                Runnable runnable2 = this.zzb;
                TaskQueue.zza zzaVar = new TaskQueue.zza();
                try {
                    runnable2.run();
                    zzaVar.close();
                } catch (Throwable th) {
                    try {
                        zzaVar.close();
                    } catch (Throwable th2) {
                        zzw.zza(th, th2);
                    }
                    throw th;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza() {
        synchronized (this.zza) {
            if (this.zzc.isEmpty()) {
                this.zzb = false;
            } else {
                zzb zzbVarRemove = this.zzc.remove();
                zza(zzbVarRemove.zza, zzbVarRemove.zzb);
            }
        }
    }

    public void checkIsRunningOnCurrentThread() {
        Preconditions.checkState(Thread.currentThread().equals(this.zzd.get()));
    }
}
