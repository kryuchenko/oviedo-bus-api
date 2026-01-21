package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbsv {
    private static final Logger zza = Logger.getLogger(zzbsv.class.getName());

    private zzbsv() {
    }

    public static zzbcf zza(List list) {
        return zzbar.zzc(zzc(list));
    }

    public static zzbcf zzb(List list) {
        return zzbar.zzc(zzc(list));
    }

    @CheckReturnValue
    private static byte[][] zzc(List list) {
        int size = list.size();
        byte[][] bArr = new byte[size + size][];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            zzbtt zzbttVar = (zzbtt) it.next();
            bArr[i] = zzbttVar.zzh.zzp();
            bArr[i + 1] = zzbttVar.zzi.zzp();
            i += 2;
        }
        return zzbqu.zzb(bArr);
    }
}
