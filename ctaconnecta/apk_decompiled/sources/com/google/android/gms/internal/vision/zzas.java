package com.google.android.gms.internal.vision;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public class zzas {
    private static UserManager zzfn;
    private static volatile boolean zzfo = !zzt();
    private static boolean zzfp = false;

    private zzas() {
    }

    public static boolean zzt() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean isUserUnlocked(Context context) {
        return !zzt() || zzd(context);
    }

    private static boolean zzc(Context context) {
        boolean z;
        boolean z2 = true;
        int i = 1;
        while (true) {
            z = false;
            if (i > 2) {
                break;
            }
            if (zzfn == null) {
                zzfn = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = zzfn;
            if (userManager == null) {
                return true;
            }
            try {
                if (userManager.isUserUnlocked()) {
                    break;
                }
                if (userManager.isUserRunning(Process.myUserHandle())) {
                    z2 = false;
                }
            } catch (NullPointerException e) {
                Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e);
                zzfn = null;
                i++;
            }
        }
        z = z2;
        if (z) {
            zzfn = null;
        }
        return z;
    }

    private static boolean zzd(Context context) {
        if (zzfo) {
            return true;
        }
        synchronized (zzas.class) {
            if (zzfo) {
                return true;
            }
            boolean zZzc = zzc(context);
            if (zZzc) {
                zzfo = zZzc;
            }
            return zZzc;
        }
    }
}
