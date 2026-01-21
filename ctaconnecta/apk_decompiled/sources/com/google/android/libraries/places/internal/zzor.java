package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzor extends zzoa {
    static final zzoa zza = new zzor(null, new Object[0], 0);
    final transient Object[] zzb;

    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzor(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a6  */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static zzor zzh(int i, Object[] objArr, zznz zznzVar) {
        char c;
        char c2;
        short[] sArr;
        byte[] bArr;
        boolean z;
        int i2 = i;
        Object[] objArrCopyOf = objArr;
        if (i2 == 0) {
            return (zzor) zza;
        }
        Object obj = null;
        int i3 = 1;
        if (i2 == 1) {
            zznj.zza(Objects.requireNonNull(objArrCopyOf[0]), Objects.requireNonNull(objArrCopyOf[1]));
            return new zzor(null, objArrCopyOf, 1);
        }
        zzmt.zzb(i2, objArrCopyOf.length >> 1, FirebaseAnalytics.Param.INDEX);
        int iZzh = zzob.zzh(i2);
        if (i2 == 1) {
            zznj.zza(Objects.requireNonNull(objArrCopyOf[0]), Objects.requireNonNull(objArrCopyOf[1]));
            i2 = 1;
            c = 0;
        } else {
            int i4 = iZzh - 1;
            if (iZzh <= 128) {
                byte[] bArr2 = new byte[iZzh];
                Arrays.fill(bArr2, (byte) -1);
                int i5 = 0;
                for (int i6 = 0; i6 < i2; i6++) {
                    int i7 = i5 + i5;
                    int i8 = i6 + i6;
                    Object objRequireNonNull = Objects.requireNonNull(objArrCopyOf[i8]);
                    Object objRequireNonNull2 = Objects.requireNonNull(objArrCopyOf[i8 ^ 1]);
                    zznj.zza(objRequireNonNull, objRequireNonNull2);
                    int iZza = zznq.zza(objRequireNonNull.hashCode());
                    while (true) {
                        int i9 = iZza & i4;
                        int i10 = bArr2[i9] & 255;
                        if (i10 == 255) {
                            bArr2[i9] = (byte) i7;
                            if (i5 < i6) {
                                objArrCopyOf[i7] = objRequireNonNull;
                                objArrCopyOf[i7 ^ 1] = objRequireNonNull2;
                            }
                            i5++;
                        } else {
                            if (objRequireNonNull.equals(objArrCopyOf[i10])) {
                                int i11 = i10 ^ 1;
                                zzny zznyVar = new zzny(objRequireNonNull, objRequireNonNull2, Objects.requireNonNull(objArrCopyOf[i11]));
                                objArrCopyOf[i11] = objRequireNonNull2;
                                obj = zznyVar;
                                break;
                            }
                            iZza = i9 + 1;
                        }
                    }
                }
                c = 0;
                bArr = bArr2;
                if (i5 != i2) {
                    sArr = new Object[]{bArr2, Integer.valueOf(i5), obj};
                    obj = sArr;
                }
                obj = bArr;
            } else {
                c = 0;
                if (iZzh > 32768) {
                    int[] iArr = new int[iZzh];
                    Arrays.fill(iArr, -1);
                    int i12 = 0;
                    int i13 = 0;
                    while (i12 < i2) {
                        int i14 = i13 + i13;
                        int i15 = i12 + i12;
                        Object objRequireNonNull3 = Objects.requireNonNull(objArrCopyOf[i15]);
                        Object objRequireNonNull4 = Objects.requireNonNull(objArrCopyOf[i15 ^ i3]);
                        zznj.zza(objRequireNonNull3, objRequireNonNull4);
                        int iZza2 = zznq.zza(objRequireNonNull3.hashCode());
                        while (true) {
                            int i16 = iZza2 & i4;
                            int i17 = iArr[i16];
                            if (i17 == -1) {
                                iArr[i16] = i14;
                                if (i13 < i12) {
                                    objArrCopyOf[i14] = objRequireNonNull3;
                                    objArrCopyOf[i14 ^ 1] = objRequireNonNull4;
                                }
                                i13++;
                            } else {
                                if (objRequireNonNull3.equals(objArrCopyOf[i17])) {
                                    int i18 = i17 ^ 1;
                                    zzny zznyVar2 = new zzny(objRequireNonNull3, objRequireNonNull4, Objects.requireNonNull(objArrCopyOf[i18]));
                                    objArrCopyOf[i18] = objRequireNonNull4;
                                    obj = zznyVar2;
                                    break;
                                }
                                iZza2 = i16 + 1;
                            }
                        }
                        i12++;
                        i3 = 1;
                    }
                    c2 = 1;
                    obj = i13 == i2 ? iArr : new Object[]{iArr, Integer.valueOf(i13), obj};
                    z = obj instanceof Object[];
                    Object obj2 = obj;
                    if (z) {
                        Object[] objArr2 = (Object[]) obj;
                        zznzVar.zzc = (zzny) objArr2[2];
                        Object obj3 = objArr2[c];
                        int iIntValue = ((Integer) objArr2[c2]).intValue();
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
                        obj2 = obj3;
                        i2 = iIntValue;
                    }
                    return new zzor(obj2, objArrCopyOf, i2);
                }
                sArr = new short[iZzh];
                Arrays.fill(sArr, (short) -1);
                int i19 = 0;
                for (int i20 = 0; i20 < i2; i20++) {
                    int i21 = i19 + i19;
                    int i22 = i20 + i20;
                    Object objRequireNonNull5 = Objects.requireNonNull(objArrCopyOf[i22]);
                    Object objRequireNonNull6 = Objects.requireNonNull(objArrCopyOf[i22 ^ 1]);
                    zznj.zza(objRequireNonNull5, objRequireNonNull6);
                    int iZza3 = zznq.zza(objRequireNonNull5.hashCode());
                    while (true) {
                        int i23 = iZza3 & i4;
                        char c3 = (char) sArr[i23];
                        if (c3 == 65535) {
                            sArr[i23] = (short) i21;
                            if (i19 < i20) {
                                objArrCopyOf[i21] = objRequireNonNull5;
                                objArrCopyOf[i21 ^ 1] = objRequireNonNull6;
                            }
                            i19++;
                        } else {
                            if (objRequireNonNull5.equals(objArrCopyOf[c3])) {
                                int i24 = c3 ^ 1;
                                zzny zznyVar3 = new zzny(objRequireNonNull5, objRequireNonNull6, Objects.requireNonNull(objArrCopyOf[i24]));
                                objArrCopyOf[i24] = objRequireNonNull6;
                                obj = zznyVar3;
                                break;
                            }
                            iZza3 = i23 + 1;
                        }
                    }
                }
                if (i19 != i2) {
                    bArr = new Object[]{sArr, Integer.valueOf(i19), obj};
                    obj = bArr;
                }
                obj = sArr;
            }
        }
        c2 = 1;
        z = obj instanceof Object[];
        Object obj22 = obj;
        if (z) {
        }
        return new zzor(obj22, objArrCopyOf, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[EDGE_INSN: B:44:0x0003->B:4:0x0003 BREAK  A[LOOP:0: B:16:0x003a->B:22:0x0050], EDGE_INSN: B:46:0x0003->B:4:0x0003 BREAK  A[LOOP:1: B:26:0x0065->B:32:0x007c], EDGE_INSN: B:48:0x0003->B:4:0x0003 BREAK  A[LOOP:2: B:34:0x008b->B:43:0x00a2]] */
    @Override // com.google.android.libraries.places.internal.zzoa, java.util.Map
    @CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(@CheckForNull Object obj) {
        Object objRequireNonNull;
        if (obj == null) {
            objRequireNonNull = null;
        } else {
            int i = this.zzd;
            Object[] objArr = this.zzb;
            if (i != 1) {
                Object obj2 = this.zzc;
                if (obj2 != null) {
                    if (obj2 instanceof byte[]) {
                        byte[] bArr = (byte[]) obj2;
                        int length = bArr.length - 1;
                        int iZza = zznq.zza(obj.hashCode());
                        while (true) {
                            int i2 = iZza & length;
                            int i3 = bArr[i2] & 255;
                            if (i3 == 255) {
                                break;
                            }
                            if (obj.equals(objArr[i3])) {
                                objRequireNonNull = objArr[i3 ^ 1];
                                break;
                            }
                            iZza = i2 + 1;
                        }
                    } else if (obj2 instanceof short[]) {
                        short[] sArr = (short[]) obj2;
                        int length2 = sArr.length - 1;
                        int iZza2 = zznq.zza(obj.hashCode());
                        while (true) {
                            int i4 = iZza2 & length2;
                            char c = (char) sArr[i4];
                            if (c == 65535) {
                                break;
                            }
                            if (obj.equals(objArr[c])) {
                                objRequireNonNull = objArr[c ^ 1];
                                break;
                            }
                            iZza2 = i4 + 1;
                        }
                    } else {
                        int[] iArr = (int[]) obj2;
                        int length3 = iArr.length - 1;
                        int iZza3 = zznq.zza(obj.hashCode());
                        while (true) {
                            int i5 = iZza3 & length3;
                            int i6 = iArr[i5];
                            if (i6 == -1) {
                                break;
                            }
                            if (obj.equals(objArr[i6])) {
                                objRequireNonNull = objArr[i6 ^ 1];
                                break;
                            }
                            iZza3 = i5 + 1;
                        }
                    }
                }
            } else if (Objects.requireNonNull(objArr[0]).equals(obj)) {
                objRequireNonNull = Objects.requireNonNull(objArr[1]);
            }
        }
        if (objRequireNonNull == null) {
            return null;
        }
        return objRequireNonNull;
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.libraries.places.internal.zzoa
    final zznt zza() {
        return new zzoq(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.libraries.places.internal.zzoa
    final zzob zze() {
        return new zzoo(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.libraries.places.internal.zzoa
    final zzob zzf() {
        return new zzop(this, new zzoq(this.zzb, 0, this.zzd));
    }
}
