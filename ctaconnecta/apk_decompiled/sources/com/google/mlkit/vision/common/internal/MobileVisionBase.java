package com.google.mlkit.vision.common.internal;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.vision.common.InputImage;
import java.io.Closeable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public class MobileVisionBase<DetectionResultT> implements LifecycleObserver, Closeable, AutoCloseable {
    private static final GmsLogger zza = new GmsLogger("MobileVisionBase", "");
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private final MLTask<DetectionResultT, InputImage> zzc;
    private final CancellationTokenSource zzd;
    private final Executor zze;

    public MobileVisionBase(MLTask<DetectionResultT, InputImage> mLTask, Executor executor) {
        this.zzc = mLTask;
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        this.zzd = cancellationTokenSource;
        this.zze = executor;
        mLTask.pin();
        mLTask.callAfterLoad(executor, zza.zza, cancellationTokenSource.getToken()).addOnFailureListener(zzc.zza);
    }

    static final /* synthetic */ Object zza() throws Exception {
        return null;
    }

    public synchronized Task<DetectionResultT> processBase(final InputImage inputImage) {
        Preconditions.checkNotNull(inputImage, "InputImage can not be null");
        if (this.zzb.get()) {
            return Tasks.forException(new MlKitException("This detector is already closed!", 14));
        }
        if (inputImage.getWidth() >= 32 && inputImage.getHeight() >= 32) {
            return this.zzc.callAfterLoad(this.zze, new Callable(this, inputImage) { // from class: com.google.mlkit.vision.common.internal.zzb
                private final MobileVisionBase zza;
                private final InputImage zzb;

                {
                    this.zza = this;
                    this.zzb = inputImage;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zza(this.zzb);
                }
            }, this.zzd.getToken());
        }
        return Tasks.forException(new MlKitException("InputImage width and height should be at least 32!", 3));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public synchronized void close() {
        if (!this.zzb.getAndSet(true)) {
            this.zzd.cancel();
            this.zzc.unpin(this.zze);
        }
    }

    final /* synthetic */ Object zza(InputImage inputImage) throws Exception {
        return this.zzc.run(inputImage);
    }
}
