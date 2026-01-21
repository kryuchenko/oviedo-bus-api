package com.google.android.libraries.places.internal;

import android.content.Context;
import android.os.Build;
import android.os.DropBoxManager;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzkd {
    private static DropBoxManager zza;
    private static final LinkedHashMap zzb = new zzkc(16, 0.75f, true);
    private static String zzc;

    public static synchronized void zza(Context context, boolean z) {
        if (zza == null) {
            zza = (DropBoxManager) context.getApplicationContext().getSystemService("dropbox");
            zzc = "com.google.android.libraries.places";
        }
    }

    public static synchronized void zzb(Throwable th) {
        DropBoxManager dropBoxManager;
        long id = Thread.currentThread().getId();
        int iHashCode = th.hashCode();
        Integer num = (Integer) zzb.get(Long.valueOf(id));
        if ((num == null || num.intValue() != iHashCode) && (dropBoxManager = zza) != null && dropBoxManager.isTagEnabled("system_app_crash")) {
            DropBoxManager dropBoxManager2 = zza;
            StringBuilder sb = new StringBuilder();
            List listZzf = zzmy.zzb(zzma.zzb('.')).zzf("3.5.0");
            long j = -1;
            if (listZzf.size() == 3) {
                long j2 = 0;
                for (int i = 0; i < listZzf.size(); i++) {
                    try {
                        j2 = (j2 * 100) + Integer.parseInt((String) listZzf.get(i));
                    } catch (NumberFormatException unused) {
                    }
                }
                j = j2;
            }
            sb.append(String.format("Package: %s v%d (%s)\n", zzc, Long.valueOf(j), "3.5.0"));
            sb.append(String.format("Build: %s\n", Build.FINGERPRINT));
            sb.append("\n");
            sb.append(Log.getStackTraceString(th));
            dropBoxManager2.addText("system_app_crash", sb.toString());
            zzb.put(Long.valueOf(id), Integer.valueOf(iHashCode));
        }
    }
}
