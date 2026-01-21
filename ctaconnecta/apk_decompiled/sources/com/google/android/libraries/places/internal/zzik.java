package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
abstract class zzik extends zzfi {
    private final Locale zza;
    private final String zzb;
    private final zzki zzc;

    protected zzik(zzjt zzjtVar, Locale locale, String str, boolean z, zzki zzkiVar) {
        super(zzjtVar);
        this.zza = locale;
        this.zzb = str;
        this.zzc = zzkiVar;
    }

    protected static void zzg(Map map, String str, Object obj, Object obj2) {
        String string = obj != null ? obj.toString() : null;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        map.put(str, string);
    }

    @Override // com.google.android.libraries.places.internal.zzfi
    protected final String zzc() {
        zziw zziwVar = new zziw(zze(), this.zzb);
        zziwVar.zza(this.zza);
        zziwVar.zzb(zzf());
        return zziwVar.zzc();
    }

    @Override // com.google.android.libraries.places.internal.zzfi
    protected final Map zzd() {
        HashMap map = new HashMap();
        map.putAll(this.zzc.zza());
        map.put("X-Places-Android-Sdk", "3.5.0");
        return map;
    }

    protected abstract String zze();

    protected abstract Map zzf();
}
