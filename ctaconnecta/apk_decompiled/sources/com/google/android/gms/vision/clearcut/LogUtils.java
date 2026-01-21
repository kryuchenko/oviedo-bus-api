package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.vision.zzef;
import com.google.android.gms.internal.vision.zzgx;
import com.google.android.gms.vision.L;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public class LogUtils {
    public static zzef.zza zza(Context context) {
        zzef.zza.C0078zza c0078zzaZzl = zzef.zza.zzck().zzl(context.getPackageName());
        String strZzb = zzb(context);
        if (strZzb != null) {
            c0078zzaZzl.zzm(strZzb);
        }
        return (zzef.zza) ((zzgx) c0078zzaZzl.zzgd());
    }

    private static String zzb(Context context) {
        try {
            return Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            L.e(e, "Unable to find calling package info for %s", context.getPackageName());
            return null;
        }
    }
}
