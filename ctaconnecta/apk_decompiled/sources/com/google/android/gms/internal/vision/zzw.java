package com.google.android.gms.internal.vision;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.vision.L;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzw {
    public static boolean zza(Context context, String str) {
        return DynamiteModule.getLocalVersion(context, str) > DynamiteModule.getRemoteVersion(context, "com.google.android.gms.vision.dynamite");
    }

    public static DynamiteModule zza(Context context, String str, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        String str2 = String.format("%s.%s", "com.google.android.gms.vision", str);
        if (!z) {
            str2 = "com.google.android.gms.vision.dynamite";
        }
        try {
            L.d("Loading module %s", str2);
            if (z) {
                versionPolicy = DynamiteModule.PREFER_REMOTE;
            } else {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
            }
            return DynamiteModule.load(context, versionPolicy, str2);
        } catch (DynamiteModule.LoadingException e) {
            L.e(e, "Error loading module %s optional module %b", str2, Boolean.valueOf(z));
            return null;
        }
    }
}
