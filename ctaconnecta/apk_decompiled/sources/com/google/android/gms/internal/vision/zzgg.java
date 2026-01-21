package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzgg extends zzfc<Double> implements zzhe<Double>, zzit, RandomAccess {
    private static final zzgg zzti;
    private int size;
    private double[] zztj;

    zzgg() {
        this(new double[10], 0);
    }

    private zzgg(double[] dArr, int i) {
        this.zztj = dArr;
        this.size = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzdr();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zztj;
        System.arraycopy(dArr, i2, dArr, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgg)) {
            return super.equals(obj);
        }
        zzgg zzggVar = (zzgg) obj;
        if (this.size != zzggVar.size) {
            return false;
        }
        double[] dArr = zzggVar.zztj;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zztj[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzab = 1;
        for (int i = 0; i < this.size; i++) {
            iZzab = (iZzab * 31) + zzgy.zzab(Double.doubleToLongBits(this.zztj[i]));
        }
        return iZzab;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.zztj[i] == dDoubleValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zzc(double d) {
        zzdr();
        int i = this.size;
        double[] dArr = this.zztj;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zztj = dArr2;
        }
        double[] dArr3 = this.zztj;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr3[i2] = d;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzdr();
        zzgy.checkNotNull(collection);
        if (!(collection instanceof zzgg)) {
            return super.addAll(collection);
        }
        zzgg zzggVar = (zzgg) collection;
        int i = zzggVar.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.zztj;
        if (i3 > dArr.length) {
            this.zztj = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(zzggVar.zztj, 0, this.zztj, this.size, zzggVar.size);
        this.size = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzdr();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zztj[i]))) {
                double[] dArr = this.zztj;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzaf(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzag(i));
        }
    }

    private final String zzag(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zzdr();
        zzaf(i);
        double[] dArr = this.zztj;
        double d = dArr[i];
        dArr[i] = dDoubleValue;
        return Double.valueOf(d);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzdr();
        zzaf(i);
        double[] dArr = this.zztj;
        double d = dArr[i];
        if (i < this.size - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (r3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double dDoubleValue = ((Double) obj).doubleValue();
        zzdr();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzag(i));
        }
        double[] dArr = this.zztj;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zztj, i, dArr2, i + 1, this.size - i);
            this.zztj = dArr2;
        }
        this.zztj[i] = dDoubleValue;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zzc(((Double) obj).doubleValue());
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzhe
    public final /* synthetic */ zzhe<Double> zzah(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzgg(Arrays.copyOf(this.zztj, i), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzaf(i);
        return Double.valueOf(this.zztj[i]);
    }

    static {
        zzgg zzggVar = new zzgg(new double[0], 0);
        zzti = zzggVar;
        zzggVar.zzdq();
    }
}
