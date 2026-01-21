package com.google.android.gms.internal.vision;

import android.content.Context;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzq {
    public static boolean zza(Context context, String str, String str2) {
        String strZzk = zzda.zzk(str2);
        if (!"face".equals(str) && !"ica".equals(str) && !"ocr".equals(str) && !"barcode".equals(str)) {
            Log.e("NativeLibraryLoader", String.format("Unrecognized engine: %s", str));
            return false;
        }
        int iLastIndexOf = strZzk.lastIndexOf(".so");
        if (iLastIndexOf == strZzk.length() - 3) {
            strZzk = strZzk.substring(0, iLastIndexOf);
        }
        if (strZzk.indexOf("lib") == 0) {
            strZzk = strZzk.substring(3);
        }
        boolean zZza = zzr.zza(str, strZzk);
        if (!zZza) {
            Log.d("NativeLibraryLoader", String.format("%s engine not loaded with %s.", str, strZzk));
        }
        return zZza;
    }
}
