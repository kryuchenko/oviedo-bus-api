package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzjc extends zzji {
    private final /* synthetic */ zzjb zzaaq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzjc(zzjb zzjbVar) {
        super(zzjbVar, null);
        this.zzaaq = zzjbVar;
    }

    @Override // com.google.android.gms.internal.vision.zzji, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzjd(this.zzaaq, null);
    }

    /* synthetic */ zzjc(zzjb zzjbVar, zzja zzjaVar) {
        this(zzjbVar);
    }
}
