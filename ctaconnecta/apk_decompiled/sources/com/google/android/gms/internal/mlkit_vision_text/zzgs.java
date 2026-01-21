package com.google.android.gms.internal.mlkit_vision_text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgs extends zzgq {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    private zzgs() {
        super();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzgq
    final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zziv.zzf(obj, j);
        if (list instanceof zzgr) {
            objUnmodifiableList = ((zzgr) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzht) && (list instanceof zzgh)) {
                zzgh zzghVar = (zzgh) list;
                if (zzghVar.zza()) {
                    zzghVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zziv.zza(obj, j, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_text.zzgq
    final <E> void zza(Object obj, Object obj2, long j) {
        zzgo zzgoVar;
        List listZzb = zzb(obj2, j);
        int size = listZzb.size();
        List listZzb2 = zzb(obj, j);
        if (listZzb2.isEmpty()) {
            if (listZzb2 instanceof zzgr) {
                listZzb2 = new zzgo(size);
            } else if ((listZzb2 instanceof zzht) && (listZzb2 instanceof zzgh)) {
                listZzb2 = ((zzgh) listZzb2).zzb(size);
            } else {
                listZzb2 = new ArrayList(size);
            }
            zziv.zza(obj, j, listZzb2);
        } else {
            if (zza.isAssignableFrom(listZzb2.getClass())) {
                ArrayList arrayList = new ArrayList(listZzb2.size() + size);
                arrayList.addAll(listZzb2);
                zziv.zza(obj, j, arrayList);
                zzgoVar = arrayList;
            } else if (listZzb2 instanceof zziq) {
                zzgo zzgoVar2 = new zzgo(listZzb2.size() + size);
                zzgoVar2.addAll((zziq) listZzb2);
                zziv.zza(obj, j, zzgoVar2);
                zzgoVar = zzgoVar2;
            } else if ((listZzb2 instanceof zzht) && (listZzb2 instanceof zzgh)) {
                zzgh zzghVar = (zzgh) listZzb2;
                if (!zzghVar.zza()) {
                    listZzb2 = zzghVar.zzb(listZzb2.size() + size);
                    zziv.zza(obj, j, listZzb2);
                }
            }
            listZzb2 = zzgoVar;
        }
        int size2 = listZzb2.size();
        int size3 = listZzb.size();
        if (size2 > 0 && size3 > 0) {
            listZzb2.addAll(listZzb);
        }
        if (size2 > 0) {
            listZzb = listZzb2;
        }
        zziv.zza(obj, j, listZzb);
    }

    private static <E> List<E> zzb(Object obj, long j) {
        return (List) zziv.zzf(obj, j);
    }
}
