package com.google.mlkit.vision.common.internal;

import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.mlkit.vision.common.InputImage;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public class BitmapInStreamingChecker {
    private static final GmsLogger zza = new GmsLogger("StreamingFormatChecker", "");
    private final LinkedList<Long> zzb = new LinkedList<>();
    private long zzc = -1;

    public void check(InputImage inputImage) {
        if (inputImage.getFormat() != -1) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.zzb.add(Long.valueOf(jElapsedRealtime));
        if (this.zzb.size() > 5) {
            this.zzb.removeFirst();
        }
        if (this.zzb.size() != 5 || jElapsedRealtime - this.zzb.peekFirst().longValue() >= DeviceOrientationRequest.OUTPUT_PERIOD_FAST) {
            return;
        }
        long j = this.zzc;
        if (j == -1 || jElapsedRealtime - j >= TimeUnit.SECONDS.toMillis(5L)) {
            this.zzc = jElapsedRealtime;
            zza.w("StreamingFormatChecker", "ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit.");
        }
    }
}
