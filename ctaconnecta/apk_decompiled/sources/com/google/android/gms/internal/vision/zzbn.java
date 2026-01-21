package com.google.android.gms.internal.vision;

import android.util.Base64;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzbn<T> extends zzbj<T> {
    private final /* synthetic */ zzbm zzgq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbn(zzbp zzbpVar, String str, Object obj, boolean z, zzbm zzbmVar) {
        super(zzbpVar, str, obj, z, null);
        this.zzgq = zzbmVar;
    }

    @Override // com.google.android.gms.internal.vision.zzbj
    final T zza(Object obj) {
        if (obj instanceof String) {
            try {
                return (T) this.zzgq.zzb(Base64.decode((String) obj, 3));
            } catch (IOException | IllegalArgumentException unused) {
            }
        }
        String strZzad = super.zzad();
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(strZzad).length() + 27 + String.valueOf(strValueOf).length());
        sb.append("Invalid byte[] value for ");
        sb.append(strZzad);
        sb.append(": ");
        sb.append(strValueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
