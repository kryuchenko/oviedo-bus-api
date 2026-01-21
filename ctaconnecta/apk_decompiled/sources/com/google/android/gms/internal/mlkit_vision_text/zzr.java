package com.google.android.gms.internal.mlkit_vision_text;

import java.util.List;
import java.util.ListIterator;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzr<V> extends zzp implements ListIterator<V> {
    private final /* synthetic */ zzo zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzr(zzo zzoVar) {
        super(zzoVar);
        this.zzb = zzoVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzr(zzo zzoVar, int i) {
        super(zzoVar, ((List) zzoVar.zzb).listIterator(i));
        this.zzb = zzoVar;
    }

    private final ListIterator<V> zzb() {
        zza();
        return (ListIterator) this.zza;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return zzb().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final V previous() {
        return zzb().previous();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return zzb().nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return zzb().previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(V v) {
        zzb().set(v);
    }

    @Override // java.util.ListIterator
    public final void add(V v) {
        boolean zIsEmpty = this.zzb.isEmpty();
        zzb().add(v);
        zzh.zzc(this.zzb.zzd);
        if (zIsEmpty) {
            this.zzb.zzc();
        }
    }
}
