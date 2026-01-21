package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzhp extends zzfc<String> implements zzho, RandomAccess {
    private static final zzhp zzyq;
    private static final zzho zzyr;
    private final List<Object> zzys;

    public zzhp() {
        this(10);
    }

    public zzhp(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzhp(ArrayList<Object> arrayList) {
        this.zzys = arrayList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzys.size();
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzdr();
        if (collection instanceof zzho) {
            collection = ((zzho) collection).zzgy();
        }
        boolean zAddAll = this.zzys.addAll(i, collection);
        this.modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzdr();
        this.zzys.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final void zzc(zzfm zzfmVar) {
        zzdr();
        this.zzys.add(zzfmVar);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final Object getRaw(int i) {
        return this.zzys.get(i);
    }

    private static String zzk(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzfm) {
            return ((zzfm) obj).zzes();
        }
        return zzgy.zzh((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final List<?> zzgy() {
        return Collections.unmodifiableList(this.zzys);
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final zzho zzgz() {
        return zzdp() ? new zzjt(this) : this;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzdr();
        return zzk(this.zzys.set(i, (String) obj));
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzdr();
        Object objRemove = this.zzys.remove(i);
        this.modCount++;
        return zzk(objRemove);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, com.google.android.gms.internal.vision.zzhe
    public final /* bridge */ /* synthetic */ boolean zzdp() {
        return super.zzdp();
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzdr();
        this.zzys.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.vision.zzhe
    public final /* synthetic */ zzhe zzah(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzys);
        return new zzhp((ArrayList<Object>) arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzys.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzfm) {
            zzfm zzfmVar = (zzfm) obj;
            String strZzes = zzfmVar.zzes();
            if (zzfmVar.zzet()) {
                this.zzys.set(i, strZzes);
            }
            return strZzes;
        }
        byte[] bArr = (byte[]) obj;
        String strZzh = zzgy.zzh(bArr);
        if (zzgy.zzg(bArr)) {
            this.zzys.set(i, strZzh);
        }
        return strZzh;
    }

    static {
        zzhp zzhpVar = new zzhp();
        zzyq = zzhpVar;
        zzhpVar.zzdq();
        zzyr = zzhpVar;
    }
}
