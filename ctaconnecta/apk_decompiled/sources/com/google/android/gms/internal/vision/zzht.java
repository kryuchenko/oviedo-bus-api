package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzht extends zzhr {
    private static final Class<?> zzyv = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    private zzht() {
        super();
    }

    @Override // com.google.android.gms.internal.vision.zzhr
    final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.vision.zzhr
    final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzju.zzp(obj, j);
        if (list instanceof zzho) {
            objUnmodifiableList = ((zzho) list).zzgz();
        } else {
            if (zzyv.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzit) && (list instanceof zzhe)) {
                zzhe zzheVar = (zzhe) list;
                if (zzheVar.zzdp()) {
                    zzheVar.zzdq();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzju.zza(obj, j, objUnmodifiableList);
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> arrayList;
        List<L> listZzd = zzd(obj, j);
        if (listZzd.isEmpty()) {
            if (listZzd instanceof zzho) {
                arrayList = new zzhp(i);
            } else if ((listZzd instanceof zzit) && (listZzd instanceof zzhe)) {
                arrayList = ((zzhe) listZzd).zzah(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            zzju.zza(obj, j, arrayList);
            return arrayList;
        }
        if (zzyv.isAssignableFrom(listZzd.getClass())) {
            ArrayList arrayList2 = new ArrayList(listZzd.size() + i);
            arrayList2.addAll(listZzd);
            zzju.zza(obj, j, arrayList2);
            return arrayList2;
        }
        if (listZzd instanceof zzjt) {
            zzhp zzhpVar = new zzhp(listZzd.size() + i);
            zzhpVar.addAll((zzjt) listZzd);
            zzju.zza(obj, j, zzhpVar);
            return zzhpVar;
        }
        if ((listZzd instanceof zzit) && (listZzd instanceof zzhe)) {
            zzhe zzheVar = (zzhe) listZzd;
            if (!zzheVar.zzdp()) {
                zzhe zzheVarZzah = zzheVar.zzah(listZzd.size() + i);
                zzju.zza(obj, j, zzheVarZzah);
                return zzheVarZzah;
            }
        }
        return listZzd;
    }

    @Override // com.google.android.gms.internal.vision.zzhr
    final <E> void zza(Object obj, Object obj2, long j) {
        List listZzd = zzd(obj2, j);
        List listZza = zza(obj, j, listZzd.size());
        int size = listZza.size();
        int size2 = listZzd.size();
        if (size > 0 && size2 > 0) {
            listZza.addAll(listZzd);
        }
        if (size > 0) {
            listZzd = listZza;
        }
        zzju.zza(obj, j, listZzd);
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzju.zzp(obj, j);
    }
}
