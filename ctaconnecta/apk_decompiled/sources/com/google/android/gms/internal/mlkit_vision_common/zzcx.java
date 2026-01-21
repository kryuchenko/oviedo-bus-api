package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;
import com.google.android.gms.internal.mlkit_vision_common.zzcq;
import com.google.android.gms.internal.mlkit_vision_common.zzr;
import com.google.mlkit.common.sdkinternal.MlKitContext;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzcx {
    public static void zza(final int i, final int i2, long j, final int i3, final int i4, final int i5) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        ((zzcq) MlKitContext.getInstance().get(zzcq.class)).zza(new zzcq.zzb(i, i2, i5, i3, i4, jElapsedRealtime) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzcw
            private final int zza;
            private final int zzb;
            private final int zzc;
            private final int zzd;
            private final int zze;
            private final long zzf;

            {
                this.zza = i;
                this.zzb = i2;
                this.zzc = i5;
                this.zzd = i3;
                this.zze = i4;
                this.zzf = jElapsedRealtime;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzcq.zzb
            public final zzr.zzad.zza zza() {
                int i6 = this.zza;
                int i7 = this.zzb;
                int i8 = this.zzc;
                int i9 = this.zzd;
                return zzr.zzad.zzb().zza(zzr.zzag.zza().zza(i6 != -1 ? i6 != 35 ? i6 != 842094169 ? i6 != 16 ? i6 != 17 ? zzr.zzae.zza.UNKNOWN_FORMAT : zzr.zzae.zza.NV21 : zzr.zzae.zza.NV16 : zzr.zzae.zza.YV12 : zzr.zzae.zza.YUV_420_888 : zzr.zzae.zza.BITMAP).zza(i7 != 1 ? i7 != 2 ? i7 != 3 ? i7 != 4 ? i7 != 5 ? zzr.zzag.zzb.SOURCE_UNKNOWN : zzr.zzag.zzb.ANDROID_MEDIA_IMAGE : zzr.zzag.zzb.FILEPATH : zzr.zzag.zzb.BYTEBUFFER : zzr.zzag.zzb.BYTEARRAY : zzr.zzag.zzb.BITMAP).zza(i8).zzc(i9).zzb(this.zze).zza(this.zzf));
            }
        }, zzag.INPUT_IMAGE_CONSTRUCTION);
    }
}
