package com.google.android.libraries.places.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzjw {
    private final Context zza;

    public zzjw(Context context) {
        this.zza = context;
    }

    public final zzbcf zza(String str, String str2) throws PackageManager.NameNotFoundException {
        zzbcf zzbcfVar = new zzbcf();
        if (!str.isEmpty()) {
            zzbcfVar.zzf(zzbca.zzc("X-Goog-FieldMask", zzbcf.zzb), str);
        }
        zzbcfVar.zzf(zzbca.zzc("X-Goog-Api-Key", zzbcf.zzb), str2);
        Context context = this.zza;
        String strZza = zzju.zza(context.getPackageManager(), context.getPackageName());
        if (!TextUtils.isEmpty(strZza)) {
            zzbcfVar.zzf(zzbca.zzc("X-Android-Package", zzbcf.zzb), this.zza.getPackageName());
            zzbcfVar.zzf(zzbca.zzc("X-Android-Cert", zzbcf.zzb), strZza);
        }
        return zzbcfVar;
    }
}
