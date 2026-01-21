package com.google.android.gms.internal.mlkit_vision_common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzfh extends zzff {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    private zzfh() {
        super();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzff
    final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzhg.zzf(obj, j);
        if (list instanceof zzfc) {
            objUnmodifiableList = ((zzfc) list).a_();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzge) && (list instanceof zzes)) {
                zzes zzesVar = (zzes) list;
                if (zzesVar.zza()) {
                    zzesVar.b_();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzhg.zza(obj, j, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzff
    final <E> void zza(Object obj, Object obj2, long j) {
        zzfd zzfdVar;
        List listZzb = zzb(obj2, j);
        int size = listZzb.size();
        List listZzb2 = zzb(obj, j);
        if (listZzb2.isEmpty()) {
            if (listZzb2 instanceof zzfc) {
                listZzb2 = new zzfd(size);
            } else if ((listZzb2 instanceof zzge) && (listZzb2 instanceof zzes)) {
                listZzb2 = ((zzes) listZzb2).zzb(size);
            } else {
                listZzb2 = new ArrayList(size);
            }
            zzhg.zza(obj, j, listZzb2);
        } else {
            if (zza.isAssignableFrom(listZzb2.getClass())) {
                ArrayList arrayList = new ArrayList(listZzb2.size() + size);
                arrayList.addAll(listZzb2);
                zzhg.zza(obj, j, arrayList);
                zzfdVar = arrayList;
            } else if (listZzb2 instanceof zzhf) {
                zzfd zzfdVar2 = new zzfd(listZzb2.size() + size);
                zzfdVar2.addAll((zzhf) listZzb2);
                zzhg.zza(obj, j, zzfdVar2);
                zzfdVar = zzfdVar2;
            } else if ((listZzb2 instanceof zzge) && (listZzb2 instanceof zzes)) {
                zzes zzesVar = (zzes) listZzb2;
                if (!zzesVar.zza()) {
                    listZzb2 = zzesVar.zzb(listZzb2.size() + size);
                    zzhg.zza(obj, j, listZzb2);
                }
            }
            listZzb2 = zzfdVar;
        }
        int size2 = listZzb2.size();
        int size3 = listZzb.size();
        if (size2 > 0 && size3 > 0) {
            listZzb2.addAll(listZzb);
        }
        if (size2 > 0) {
            listZzb = listZzb2;
        }
        zzhg.zza(obj, j, listZzb);
    }

    private static <E> List<E> zzb(Object obj, long j) {
        return (List) zzhg.zzf(obj, j);
    }
}
