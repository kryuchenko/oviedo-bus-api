package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class ModelResource {
    private boolean zzb;
    private final AtomicInteger zza = new AtomicInteger(0);
    protected final TaskQueue taskQueue = new TaskQueue();

    public abstract void load() throws MlKitException;

    protected abstract void release();

    public void pin() {
        this.zza.incrementAndGet();
    }

    public void unpin(Executor executor) {
        Preconditions.checkState(this.zza.get() > 0);
        this.taskQueue.submit(executor, new Runnable(this) { // from class: com.google.mlkit.common.sdkinternal.zzl
            private final ModelResource zza;

            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza();
            }
        });
    }

    public <T> Task<T> callAfterLoad(final Executor executor, final Callable<T> callable, final CancellationToken cancellationToken) {
        Preconditions.checkState(this.zza.get() > 0);
        Executor executor2 = new Executor(this, executor) { // from class: com.google.mlkit.common.sdkinternal.zzk
            private final ModelResource zza;
            private final Executor zzb;

            {
                this.zza = this;
                this.zzb = executor;
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                ModelResource modelResource = this.zza;
                modelResource.taskQueue.submit(this.zzb, runnable);
            }
        };
        final Callable callable2 = new Callable(this, cancellationToken, callable) { // from class: com.google.mlkit.common.sdkinternal.zzn
            private final ModelResource zza;
            private final CancellationToken zzb;
            private final Callable zzc;

            {
                this.zza = this;
                this.zzb = cancellationToken;
                this.zzc = callable;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza(this.zzb, this.zzc);
            }
        };
        if (cancellationToken == null) {
            return Tasks.call(executor2, callable2);
        }
        if (cancellationToken.isCancellationRequested()) {
            return Tasks.forCanceled();
        }
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        executor2.execute(new Runnable(cancellationToken, cancellationTokenSource, callable2, taskCompletionSource) { // from class: com.google.mlkit.common.sdkinternal.zzm
            private final CancellationToken zza;
            private final CancellationTokenSource zzb;
            private final Callable zzc;
            private final TaskCompletionSource zzd;

            {
                this.zza = cancellationToken;
                this.zzb = cancellationTokenSource;
                this.zzc = callable2;
                this.zzd = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() throws Exception {
                CancellationToken cancellationToken2 = this.zza;
                CancellationTokenSource cancellationTokenSource2 = this.zzb;
                Callable callable3 = this.zzc;
                TaskCompletionSource taskCompletionSource2 = this.zzd;
                if (cancellationToken2.isCancellationRequested()) {
                    cancellationTokenSource2.cancel();
                    return;
                }
                try {
                    Object objCall = callable3.call();
                    if (cancellationToken2.isCancellationRequested()) {
                        cancellationTokenSource2.cancel();
                    } else {
                        taskCompletionSource2.setResult(objCall);
                    }
                } catch (Exception e) {
                    if (cancellationToken2.isCancellationRequested()) {
                        cancellationTokenSource2.cancel();
                    } else {
                        taskCompletionSource2.setException(e);
                    }
                }
            }
        });
        return taskCompletionSource.getTask();
    }

    final /* synthetic */ Object zza(CancellationToken cancellationToken, Callable callable) throws Exception {
        try {
            if (!this.zzb) {
                load();
                this.zzb = true;
            }
            if (cancellationToken.isCancellationRequested()) {
                throw new Exception();
            }
            return callable.call();
        } catch (RuntimeException e) {
            throw new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e);
        }
    }

    final /* synthetic */ void zza() {
        int iDecrementAndGet = this.zza.decrementAndGet();
        Preconditions.checkState(iDecrementAndGet >= 0);
        if (iDecrementAndGet == 0) {
            release();
            this.zzb = false;
        }
    }
}
