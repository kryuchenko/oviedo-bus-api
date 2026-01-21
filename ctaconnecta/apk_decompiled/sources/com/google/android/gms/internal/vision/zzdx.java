package com.google.android.gms.internal.vision;

import java.io.PrintStream;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzdx {
    private static final zzea zzmp;
    private static final int zzmq;

    public static void zza(Throwable th, Throwable th2) {
        zzmp.zza(th, th2);
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    static final class zza extends zzea {
        zza() {
        }

        @Override // com.google.android.gms.internal.vision.zzea
        public final void zza(Throwable th, Throwable th2) {
        }

        @Override // com.google.android.gms.internal.vision.zzea
        public final void zza(Throwable th) {
            th.printStackTrace();
        }
    }

    public static void zza(Throwable th) {
        zzmp.zza(th);
    }

    private static Integer zzcj() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x0006, B:6:0x000e, B:7:0x0014, B:9:0x001c, B:10:0x0022), top: B:24:0x0006 }] */
    static {
        Integer numZzcj;
        zzea zzaVar;
        try {
            numZzcj = zzcj();
            if (numZzcj != null) {
                try {
                    if (numZzcj.intValue() >= 19) {
                        zzaVar = new zzed();
                    } else if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
                        zzaVar = new zzeb();
                    } else {
                        zzaVar = new zza();
                    }
                } catch (Throwable th) {
                    th = th;
                    PrintStream printStream = System.err;
                    String name = zza.class.getName();
                    StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 133);
                    sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                    sb.append(name);
                    sb.append("will be used. The error is: ");
                    printStream.println(sb.toString());
                    th.printStackTrace(System.err);
                    zzaVar = new zza();
                    zzmp = zzaVar;
                    zzmq = numZzcj != null ? 1 : numZzcj.intValue();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            numZzcj = null;
        }
        zzmp = zzaVar;
        zzmq = numZzcj != null ? 1 : numZzcj.intValue();
    }
}
