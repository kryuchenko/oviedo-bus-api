package com.google.android.gms.internal.vision;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzbk extends zzbj<Boolean> {
    zzbk(zzbp zzbpVar, String str, Boolean bool, boolean z) {
        super(zzbpVar, str, bool, z, null);
    }

    @Override // com.google.android.gms.internal.vision.zzbj
    final /* synthetic */ Boolean zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzaq.zzfc.matcher(str).matches()) {
                return true;
            }
            if (zzaq.zzfd.matcher(str).matches()) {
                return false;
            }
        }
        String strZzad = super.zzad();
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(strZzad).length() + 28 + String.valueOf(strValueOf).length());
        sb.append("Invalid boolean value for ");
        sb.append(strZzad);
        sb.append(": ");
        sb.append(strValueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
