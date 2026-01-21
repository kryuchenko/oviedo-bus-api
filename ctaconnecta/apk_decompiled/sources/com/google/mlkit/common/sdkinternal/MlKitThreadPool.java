package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.internal.mlkit_common.zzu;
import java.util.Deque;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class MlKitThreadPool extends zzu {
    private static final ThreadLocal<Deque<Runnable>> zzd = new zzi();
    private final ExecutorService zza = new ThreadPoolExecutor(0, Runtime.getRuntime().availableProcessors(), 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory(this) { // from class: com.google.mlkit.common.sdkinternal.zzh
        private final MlKitThreadPool zza;

        {
            this.zza = this;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return this.zza.zzb(runnable);
        }
    });
    private final ThreadFactory zzb = Executors.defaultThreadFactory();
    private final WeakHashMap<Thread, Void> zzc = new WeakHashMap<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_common.zzu
    /* renamed from: zzb */
    public final ExecutorService zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final Thread zzb(Runnable runnable) {
        Thread threadNewThread = this.zzb.newThread(runnable);
        synchronized (this.zzc) {
            this.zzc.put(threadNewThread, null);
        }
        return threadNewThread;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzu, java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        boolean zContainsKey;
        synchronized (this.zzc) {
            zContainsKey = this.zzc.containsKey(Thread.currentThread());
        }
        if (zContainsKey) {
            zzd(runnable);
        } else {
            this.zza.execute(new Runnable(runnable) { // from class: com.google.mlkit.common.sdkinternal.zzj
                private final Runnable zza;

                {
                    this.zza = runnable;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MlKitThreadPool.zzd(this.zza);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(Runnable runnable) {
        Deque<Runnable> deque = zzd.get();
        deque.add(runnable);
        if (deque.size() > 1) {
            return;
        }
        do {
            runnable.run();
            deque.removeFirst();
            runnable = deque.peekFirst();
        } while (runnable != null);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzu, com.google.android.gms.internal.mlkit_common.zzj
    protected final /* synthetic */ Object zza() {
        return zza();
    }
}
