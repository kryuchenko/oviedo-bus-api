package com.google.android.gms.internal.drive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
final class zzlc extends zzla {
    private static final Class<?> zzto = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    private zzlc() {
        super();
    }

    @Override // com.google.android.gms.internal.drive.zzla
    final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zznd.zzo(obj, j);
        if (list instanceof zzkz) {
            objUnmodifiableList = ((zzkz) list).zzds();
        } else {
            if (zzto.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzmc) && (list instanceof zzkp)) {
                zzkp zzkpVar = (zzkp) list;
                if (zzkpVar.zzbo()) {
                    zzkpVar.zzbp();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zznd.zza(obj, j, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.drive.zzla
    final <E> void zza(Object obj, Object obj2, long j) {
        zzky zzkyVar;
        List listZzb = zzb(obj2, j);
        int size = listZzb.size();
        List listZzb2 = zzb(obj, j);
        if (listZzb2.isEmpty()) {
            if (listZzb2 instanceof zzkz) {
                listZzb2 = new zzky(size);
            } else if ((listZzb2 instanceof zzmc) && (listZzb2 instanceof zzkp)) {
                listZzb2 = ((zzkp) listZzb2).zzr(size);
            } else {
                listZzb2 = new ArrayList(size);
            }
            zznd.zza(obj, j, listZzb2);
        } else {
            if (zzto.isAssignableFrom(listZzb2.getClass())) {
                ArrayList arrayList = new ArrayList(listZzb2.size() + size);
                arrayList.addAll(listZzb2);
                zznd.zza(obj, j, arrayList);
                zzkyVar = arrayList;
            } else if (listZzb2 instanceof zzna) {
                zzky zzkyVar2 = new zzky(listZzb2.size() + size);
                zzkyVar2.addAll((zzna) listZzb2);
                zznd.zza(obj, j, zzkyVar2);
                zzkyVar = zzkyVar2;
            } else if ((listZzb2 instanceof zzmc) && (listZzb2 instanceof zzkp)) {
                zzkp zzkpVar = (zzkp) listZzb2;
                if (!zzkpVar.zzbo()) {
                    listZzb2 = zzkpVar.zzr(listZzb2.size() + size);
                    zznd.zza(obj, j, listZzb2);
                }
            }
            listZzb2 = zzkyVar;
        }
        int size2 = listZzb2.size();
        int size3 = listZzb.size();
        if (size2 > 0 && size3 > 0) {
            listZzb2.addAll(listZzb);
        }
        if (size2 > 0) {
            listZzb = listZzb2;
        }
        zznd.zza(obj, j, listZzb);
    }

    private static <E> List<E> zzb(Object obj, long j) {
        return (List) zznd.zzo(obj, j);
    }
}
