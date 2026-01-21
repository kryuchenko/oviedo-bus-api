package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Map;
import kotlin.UShort;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzdq<K, V> extends zzdl<K, V> {
    private static final zzdl<Object, Object> zzmm = new zzdq(null, new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzmk;
    private final transient Object zzmn;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        r0[r6] = (byte) r2;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009e, code lost:
    
        r0[r6] = (short) r2;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d3, code lost:
    
        r0[r7] = r2;
        r3 = r3 + 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static <K, V> zzdq<K, V> zza(int i, Object[] objArr) {
        int iHighestOneBit;
        byte[] bArr;
        zzcy.zze(4, objArr.length >> 1);
        int iMax = Math.max(4, 2);
        int i2 = 0;
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
            while (iHighestOneBit * 0.7d < iMax) {
                iHighestOneBit <<= 1;
            }
        } else {
            zzcy.checkArgument(iMax < 1073741824, "collection too large");
            iHighestOneBit = 1073741824;
        }
        int i3 = iHighestOneBit - 1;
        if (iHighestOneBit <= 128) {
            bArr = new byte[iHighestOneBit];
            Arrays.fill(bArr, (byte) -1);
            while (i2 < 4) {
                int i4 = i2 * 2;
                Object obj = objArr[i4];
                Object obj2 = objArr[i4 ^ 1];
                zzdf.zza(obj, obj2);
                int iZzs = zzdi.zzs(obj.hashCode());
                while (true) {
                    int i5 = iZzs & i3;
                    int i6 = bArr[i5] & 255;
                    if (i6 == 255) {
                        break;
                    }
                    if (objArr[i6].equals(obj)) {
                        throw zza(obj, obj2, objArr, i6);
                    }
                    iZzs = i5 + 1;
                }
            }
        } else if (iHighestOneBit <= 32768) {
            bArr = new short[iHighestOneBit];
            Arrays.fill(bArr, (short) -1);
            while (i2 < 4) {
                int i7 = i2 * 2;
                Object obj3 = objArr[i7];
                Object obj4 = objArr[i7 ^ 1];
                zzdf.zza(obj3, obj4);
                int iZzs2 = zzdi.zzs(obj3.hashCode());
                while (true) {
                    int i8 = iZzs2 & i3;
                    int i9 = bArr[i8] & UShort.MAX_VALUE;
                    if (i9 == 65535) {
                        break;
                    }
                    if (objArr[i9].equals(obj3)) {
                        throw zza(obj3, obj4, objArr, i9);
                    }
                    iZzs2 = i8 + 1;
                }
            }
        } else {
            bArr = new int[iHighestOneBit];
            Arrays.fill((int[]) bArr, -1);
            while (i2 < 4) {
                int i10 = i2 * 2;
                Object obj5 = objArr[i10];
                Object obj6 = objArr[i10 ^ 1];
                zzdf.zza(obj5, obj6);
                int iZzs3 = zzdi.zzs(obj5.hashCode());
                while (true) {
                    int i11 = iZzs3 & i3;
                    char c = bArr[i11];
                    if (c == -1) {
                        break;
                    }
                    if (objArr[c].equals(obj5)) {
                        throw zza(obj5, obj6, objArr, c);
                    }
                    iZzs3 = i11 + 1;
                }
            }
        }
        return new zzdq<>(bArr, objArr, 4);
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i) {
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(obj2);
        String strValueOf3 = String.valueOf(objArr[i]);
        String strValueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 39 + String.valueOf(strValueOf2).length() + String.valueOf(strValueOf3).length() + String.valueOf(strValueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        sb.append(" and ");
        sb.append(strValueOf3);
        sb.append("=");
        sb.append(strValueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    private zzdq(Object obj, Object[] objArr, int i) {
        this.zzmn = obj;
        this.zzmk = objArr;
        this.size = i;
    }

    @Override // java.util.Map
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.vision.zzdl, java.util.Map
    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.zzmn;
        Object[] objArr = this.zzmk;
        int i = this.size;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[0].equals(obj)) {
                return (V) objArr[1];
            }
            return null;
        }
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof byte[]) {
            byte[] bArr = (byte[]) obj2;
            int length = bArr.length - 1;
            int iZzs = zzdi.zzs(obj.hashCode());
            while (true) {
                int i2 = iZzs & length;
                int i3 = bArr[i2] & 255;
                if (i3 == 255) {
                    return null;
                }
                if (objArr[i3].equals(obj)) {
                    return (V) objArr[i3 ^ 1];
                }
                iZzs = i2 + 1;
            }
        } else if (obj2 instanceof short[]) {
            short[] sArr = (short[]) obj2;
            int length2 = sArr.length - 1;
            int iZzs2 = zzdi.zzs(obj.hashCode());
            while (true) {
                int i4 = iZzs2 & length2;
                int i5 = sArr[i4] & UShort.MAX_VALUE;
                if (i5 == 65535) {
                    return null;
                }
                if (objArr[i5].equals(obj)) {
                    return (V) objArr[i5 ^ 1];
                }
                iZzs2 = i4 + 1;
            }
        } else {
            int[] iArr = (int[]) obj2;
            int length3 = iArr.length - 1;
            int iZzs3 = zzdi.zzs(obj.hashCode());
            while (true) {
                int i6 = iZzs3 & length3;
                int i7 = iArr[i6];
                if (i7 == -1) {
                    return null;
                }
                if (objArr[i7].equals(obj)) {
                    return (V) objArr[i7 ^ 1];
                }
                iZzs3 = i6 + 1;
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzdl
    final zzdo<Map.Entry<K, V>> zzcf() {
        return new zzdp(this, this.zzmk, 0, this.size);
    }

    @Override // com.google.android.gms.internal.vision.zzdl
    final zzdo<K> zzcg() {
        return new zzdr(this, new zzdu(this.zzmk, 0, this.size));
    }

    @Override // com.google.android.gms.internal.vision.zzdl
    final zzdh<V> zzch() {
        return new zzdu(this.zzmk, 1, this.size);
    }
}
