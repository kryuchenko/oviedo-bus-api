package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
public final class zzgo implements zzgt {
    private final SimpleArrayMap<String, SimpleArrayMap<String, String>> zza;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0019 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001a  */
    @Override // com.google.android.gms.internal.measurement.zzgt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String zza(Uri uri, String str, String str2, String str3) {
        SimpleArrayMap<String, String> simpleArrayMap;
        if (uri == null) {
            if (str == null) {
                simpleArrayMap = null;
            }
            if (simpleArrayMap != null) {
                return null;
            }
            if (str2 != null) {
                str3 = str2 + str3;
            }
            return simpleArrayMap.get(str3);
        }
        str = uri.toString();
        SimpleArrayMap<String, SimpleArrayMap<String, String>> simpleArrayMap2 = this.zza;
        if (simpleArrayMap2 != null) {
            simpleArrayMap = simpleArrayMap2.get(str);
        }
        if (simpleArrayMap != null) {
        }
    }

    zzgo(SimpleArrayMap<String, SimpleArrayMap<String, String>> simpleArrayMap) {
        this.zza = simpleArrayMap;
    }
}
