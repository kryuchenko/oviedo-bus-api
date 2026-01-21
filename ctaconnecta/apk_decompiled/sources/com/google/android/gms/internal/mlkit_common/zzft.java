package com.google.android.gms.internal.mlkit_common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzft extends zzfr {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    private zzft() {
        super();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfr
    final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzhw.zzf(obj, j);
        if (list instanceof zzfs) {
            objUnmodifiableList = ((zzfs) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzgu) && (list instanceof zzfi)) {
                zzfi zzfiVar = (zzfi) list;
                if (zzfiVar.zza()) {
                    zzfiVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzhw.zza(obj, j, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_common.zzfr
    final <E> void zza(Object obj, Object obj2, long j) {
        zzfp zzfpVar;
        List listZzb = zzb(obj2, j);
        int size = listZzb.size();
        List listZzb2 = zzb(obj, j);
        if (listZzb2.isEmpty()) {
            if (listZzb2 instanceof zzfs) {
                listZzb2 = new zzfp(size);
            } else if ((listZzb2 instanceof zzgu) && (listZzb2 instanceof zzfi)) {
                listZzb2 = ((zzfi) listZzb2).zzb(size);
            } else {
                listZzb2 = new ArrayList(size);
            }
            zzhw.zza(obj, j, listZzb2);
        } else {
            if (zza.isAssignableFrom(listZzb2.getClass())) {
                ArrayList arrayList = new ArrayList(listZzb2.size() + size);
                arrayList.addAll(listZzb2);
                zzhw.zza(obj, j, arrayList);
                zzfpVar = arrayList;
            } else if (listZzb2 instanceof zzhr) {
                zzfp zzfpVar2 = new zzfp(listZzb2.size() + size);
                zzfpVar2.addAll((zzhr) listZzb2);
                zzhw.zza(obj, j, zzfpVar2);
                zzfpVar = zzfpVar2;
            } else if ((listZzb2 instanceof zzgu) && (listZzb2 instanceof zzfi)) {
                zzfi zzfiVar = (zzfi) listZzb2;
                if (!zzfiVar.zza()) {
                    listZzb2 = zzfiVar.zzb(listZzb2.size() + size);
                    zzhw.zza(obj, j, listZzb2);
                }
            }
            listZzb2 = zzfpVar;
        }
        int size2 = listZzb2.size();
        int size3 = listZzb.size();
        if (size2 > 0 && size3 > 0) {
            listZzb2.addAll(listZzb);
        }
        if (size2 > 0) {
            listZzb = listZzb2;
        }
        zzhw.zza(obj, j, listZzb);
    }

    private static <E> List<E> zzb(Object obj, long j) {
        return (List) zzhw.zzf(obj, j);
    }
}
