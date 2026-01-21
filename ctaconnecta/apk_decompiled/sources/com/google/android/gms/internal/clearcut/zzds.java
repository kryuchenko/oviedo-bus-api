package com.google.android.gms.internal.clearcut;

import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.clearcut.zzcg;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
final class zzds<T> implements zzef<T> {
    private static final Unsafe zzmh = zzfd.zzef();
    private final int[] zzmi;
    private final Object[] zzmj;
    private final int zzmk;
    private final int zzml;
    private final int zzmm;
    private final zzdo zzmn;
    private final boolean zzmo;
    private final boolean zzmp;
    private final boolean zzmq;
    private final boolean zzmr;
    private final int[] zzms;
    private final int[] zzmt;
    private final int[] zzmu;
    private final zzdw zzmv;
    private final zzcy zzmw;
    private final zzex<?, ?> zzmx;
    private final zzbu<?> zzmy;
    private final zzdj zzmz;

    private zzds(int[] iArr, Object[] objArr, int i, int i2, int i3, zzdo zzdoVar, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, zzdw zzdwVar, zzcy zzcyVar, zzex<?, ?> zzexVar, zzbu<?> zzbuVar, zzdj zzdjVar) {
        this.zzmi = iArr;
        this.zzmj = objArr;
        this.zzmk = i;
        this.zzml = i2;
        this.zzmm = i3;
        this.zzmp = zzdoVar instanceof zzcg;
        this.zzmq = z;
        this.zzmo = zzbuVar != null && zzbuVar.zze(zzdoVar);
        this.zzmr = false;
        this.zzms = iArr2;
        this.zzmt = iArr3;
        this.zzmu = iArr4;
        this.zzmv = zzdwVar;
        this.zzmw = zzcyVar;
        this.zzmx = zzexVar;
        this.zzmy = zzbuVar;
        this.zzmn = zzdoVar;
        this.zzmz = zzdjVar;
    }

    private static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzay zzayVar) throws IOException {
        return zzax.zza(i, bArr, i2, i3, zzn(obj), zzayVar);
    }

    private static int zza(zzef<?> zzefVar, int i, byte[] bArr, int i2, int i3, zzcn<?> zzcnVar, zzay zzayVar) throws IOException {
        int iZza = zza((zzef) zzefVar, bArr, i2, i3, zzayVar);
        while (true) {
            zzcnVar.add(zzayVar.zzff);
            if (iZza >= i3) {
                break;
            }
            int iZza2 = zzax.zza(bArr, iZza, zzayVar);
            if (i != zzayVar.zzfd) {
                break;
            }
            iZza = zza((zzef) zzefVar, bArr, iZza2, i3, zzayVar);
        }
        return iZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int zza(zzef zzefVar, byte[] bArr, int i, int i2, int i3, zzay zzayVar) throws IOException {
        zzds zzdsVar = (zzds) zzefVar;
        Object objNewInstance = zzdsVar.newInstance();
        int iZza = zzdsVar.zza((zzds) objNewInstance, bArr, i, i2, i3, zzayVar);
        zzdsVar.zzc(objNewInstance);
        zzayVar.zzff = objNewInstance;
        return iZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int zza(zzef zzefVar, byte[] bArr, int i, int i2, zzay zzayVar) throws IOException {
        int iZza = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZza = zzax.zza(i3, bArr, iZza, zzayVar);
            i3 = zzayVar.zzfd;
        }
        int i4 = iZza;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzco.zzbl();
        }
        Object objNewInstance = zzefVar.newInstance();
        int i5 = i4 + i3;
        zzefVar.zza(objNewInstance, bArr, i4, i5, zzayVar);
        zzefVar.zzc(objNewInstance);
        zzayVar.zzff = objNewInstance;
        return i5;
    }

    private static <UT, UB> int zza(zzex<UT, UB> zzexVar, T t) {
        return zzexVar.zzm(zzexVar.zzq(t));
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzay zzayVar) throws IOException {
        int i9;
        Object objValueOf;
        int i10;
        Object objValueOf2;
        int iZzb;
        long jZza;
        int iZzm;
        Object objValueOf3;
        Object object;
        Unsafe unsafe = zzmh;
        long j2 = this.zzmi[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                i9 = i;
                if (i5 != 1) {
                    return i9;
                }
                objValueOf = Double.valueOf(zzax.zze(bArr, i));
                unsafe.putObject(t, j, objValueOf);
                iZzb = i9 + 8;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 52:
                i10 = i;
                if (i5 != 5) {
                    return i10;
                }
                objValueOf2 = Float.valueOf(zzax.zzf(bArr, i));
                unsafe.putObject(t, j, objValueOf2);
                iZzb = i10 + 4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzax.zzb(bArr, i, zzayVar);
                jZza = zzayVar.zzfe;
                objValueOf3 = Long.valueOf(jZza);
                unsafe.putObject(t, j, objValueOf3);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzax.zza(bArr, i, zzayVar);
                iZzm = zzayVar.zzfd;
                objValueOf3 = Integer.valueOf(iZzm);
                unsafe.putObject(t, j, objValueOf3);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 56:
            case 65:
                i9 = i;
                if (i5 != 1) {
                    return i9;
                }
                objValueOf = Long.valueOf(zzax.zzd(bArr, i));
                unsafe.putObject(t, j, objValueOf);
                iZzb = i9 + 8;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 57:
            case 64:
                i10 = i;
                if (i5 != 5) {
                    return i10;
                }
                objValueOf2 = Integer.valueOf(zzax.zzc(bArr, i));
                unsafe.putObject(t, j, objValueOf2);
                iZzb = i10 + 4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzax.zzb(bArr, i, zzayVar);
                objValueOf3 = Boolean.valueOf(zzayVar.zzfe != 0);
                unsafe.putObject(t, j, objValueOf3);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzax.zza(bArr, i, zzayVar);
                int i11 = zzayVar.zzfd;
                if (i11 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !zzff.zze(bArr, iZza, iZza + i11)) {
                        throw zzco.zzbp();
                    }
                    unsafe.putObject(t, j, new String(bArr, iZza, i11, zzci.UTF_8));
                    iZza += i11;
                }
                unsafe.putInt(t, j2, i4);
                return iZza;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iZza2 = zza(zzad(i8), bArr, i, i2, zzayVar);
                object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                Object objZza = zzayVar.zzff;
                if (object != null) {
                    objZza = zzci.zza(object, objZza);
                }
                unsafe.putObject(t, j, objZza);
                unsafe.putInt(t, j2, i4);
                return iZza2;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iZza3 = zzax.zza(bArr, i, zzayVar);
                int i12 = zzayVar.zzfd;
                if (i12 == 0) {
                    unsafe.putObject(t, j, zzbb.zzfi);
                } else {
                    unsafe.putObject(t, j, zzbb.zzb(bArr, iZza3, i12));
                    iZza3 += i12;
                }
                unsafe.putInt(t, j2, i4);
                return iZza3;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iZza4 = zzax.zza(bArr, i, zzayVar);
                int i13 = zzayVar.zzfd;
                zzck<?> zzckVarZzaf = zzaf(i8);
                if (zzckVarZzaf != null && zzckVarZzaf.zzb(i13) == null) {
                    zzn(t).zzb(i3, Long.valueOf(i13));
                    return iZza4;
                }
                unsafe.putObject(t, j, Integer.valueOf(i13));
                iZzb = iZza4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzax.zza(bArr, i, zzayVar);
                iZzm = zzbk.zzm(zzayVar.zzfd);
                objValueOf3 = Integer.valueOf(iZzm);
                unsafe.putObject(t, j, objValueOf3);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzax.zzb(bArr, i, zzayVar);
                jZza = zzbk.zza(zzayVar.zzfe);
                objValueOf3 = Long.valueOf(jZza);
                unsafe.putObject(t, j, objValueOf3);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 68:
                if (i5 == 3) {
                    iZzb = zza(zzad(i8), bArr, i, i2, (i3 & (-8)) | 4, zzayVar);
                    object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    objValueOf3 = zzayVar.zzff;
                    if (object != null) {
                        objValueOf3 = zzci.zza(object, objValueOf3);
                    }
                    unsafe.putObject(t, j, objValueOf3);
                    unsafe.putInt(t, j2, i4);
                    return iZzb;
                }
            default:
                return i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:0x0272, code lost:
    
        if (r27.zzfe != 0) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0274, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0276, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0277, code lost:
    
        r1.addBoolean(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x027a, code lost:
    
        if (r14 >= r17) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x027c, code lost:
    
        r3 = com.google.android.gms.internal.clearcut.zzax.zza(r15, r14, r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0282, code lost:
    
        if (r18 != r27.zzfd) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0284, code lost:
    
        r14 = com.google.android.gms.internal.clearcut.zzax.zzb(r15, r3, r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x028c, code lost:
    
        if (r27.zzfe == 0) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x028f, code lost:
    
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0170, code lost:
    
        r4.add(com.google.android.gms.internal.clearcut.zzbb.zzb(r15, r1, r2));
        r1 = r1 + r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0277, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0160, code lost:
    
        if (r2 == 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0162, code lost:
    
        r4.add(com.google.android.gms.internal.clearcut.zzbb.zzfi);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0168, code lost:
    
        r4.add(com.google.android.gms.internal.clearcut.zzbb.zzb(r15, r1, r2));
        r1 = r1 + r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0170, code lost:
    
        if (r1 >= r17) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0172, code lost:
    
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r15, r1, r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0178, code lost:
    
        if (r18 != r27.zzfd) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x017a, code lost:
    
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r15, r2, r27);
        r2 = r27.zzfd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0180, code lost:
    
        if (r2 != 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0183, code lost:
    
        return r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x0217 -> B:102:0x01f0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:144:0x028c -> B:137:0x0274). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x0180 -> B:71:0x0162). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x01e2 -> B:90:0x01c3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzay zzayVar) throws IOException {
        int i8;
        int i9;
        int iZza;
        Unsafe unsafe = zzmh;
        zzcn zzcnVarZzi = (zzcn) unsafe.getObject(t, j2);
        if (!zzcnVarZzi.zzu()) {
            int size = zzcnVarZzi.size();
            zzcnVarZzi = zzcnVarZzi.zzi(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j2, zzcnVarZzi);
        }
        zzcn zzcnVar = zzcnVarZzi;
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzbq zzbqVar = (zzbq) zzcnVar;
                    int iZza2 = zzax.zza(bArr, i, zzayVar);
                    int i10 = zzayVar.zzfd + iZza2;
                    while (iZza2 < i10) {
                        zzbqVar.zzc(zzax.zze(bArr, iZza2));
                        iZza2 += 8;
                    }
                    if (iZza2 == i10) {
                        return iZza2;
                    }
                    throw zzco.zzbl();
                }
                if (i5 != 1) {
                    return i;
                }
                zzbq zzbqVar2 = (zzbq) zzcnVar;
                zzbqVar2.zzc(zzax.zze(bArr, i));
                int i11 = i + 8;
                while (i11 < i2) {
                    int iZza3 = zzax.zza(bArr, i11, zzayVar);
                    if (i3 != zzayVar.zzfd) {
                        return i11;
                    }
                    zzbqVar2.zzc(zzax.zze(bArr, iZza3));
                    i11 = iZza3 + 8;
                }
                return i11;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzce zzceVar = (zzce) zzcnVar;
                    int iZza4 = zzax.zza(bArr, i, zzayVar);
                    int i12 = zzayVar.zzfd + iZza4;
                    while (iZza4 < i12) {
                        zzceVar.zzc(zzax.zzf(bArr, iZza4));
                        iZza4 += 4;
                    }
                    if (iZza4 == i12) {
                        return iZza4;
                    }
                    throw zzco.zzbl();
                }
                if (i5 != 5) {
                    return i;
                }
                zzce zzceVar2 = (zzce) zzcnVar;
                zzceVar2.zzc(zzax.zzf(bArr, i));
                int i13 = i + 4;
                while (i13 < i2) {
                    int iZza5 = zzax.zza(bArr, i13, zzayVar);
                    if (i3 != zzayVar.zzfd) {
                        return i13;
                    }
                    zzceVar2.zzc(zzax.zzf(bArr, iZza5));
                    i13 = iZza5 + 4;
                }
                return i13;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzdc zzdcVar = (zzdc) zzcnVar;
                    int iZza6 = zzax.zza(bArr, i, zzayVar);
                    int i14 = zzayVar.zzfd + iZza6;
                    while (iZza6 < i14) {
                        iZza6 = zzax.zzb(bArr, iZza6, zzayVar);
                        zzdcVar.zzm(zzayVar.zzfe);
                    }
                    if (iZza6 == i14) {
                        return iZza6;
                    }
                    throw zzco.zzbl();
                }
                if (i5 != 0) {
                    return i;
                }
                zzdc zzdcVar2 = (zzdc) zzcnVar;
                int iZzb = zzax.zzb(bArr, i, zzayVar);
                while (true) {
                    zzdcVar2.zzm(zzayVar.zzfe);
                    if (iZzb < i2) {
                        int iZza7 = zzax.zza(bArr, iZzb, zzayVar);
                        if (i3 == zzayVar.zzfd) {
                            iZzb = zzax.zzb(bArr, iZza7, zzayVar);
                        }
                    }
                }
                return iZzb;
            case 22:
            case 29:
            case 39:
            case 43:
                return i5 == 2 ? zzax.zza(bArr, i, (zzcn<?>) zzcnVar, zzayVar) : i5 == 0 ? zzax.zza(i3, bArr, i, i2, (zzcn<?>) zzcnVar, zzayVar) : i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzdc zzdcVar3 = (zzdc) zzcnVar;
                    int iZza8 = zzax.zza(bArr, i, zzayVar);
                    int i15 = zzayVar.zzfd + iZza8;
                    while (iZza8 < i15) {
                        zzdcVar3.zzm(zzax.zzd(bArr, iZza8));
                        iZza8 += 8;
                    }
                    if (iZza8 == i15) {
                        return iZza8;
                    }
                    throw zzco.zzbl();
                }
                if (i5 != 1) {
                    return i;
                }
                zzdc zzdcVar4 = (zzdc) zzcnVar;
                zzdcVar4.zzm(zzax.zzd(bArr, i));
                int i16 = i + 8;
                while (i16 < i2) {
                    int iZza9 = zzax.zza(bArr, i16, zzayVar);
                    if (i3 != zzayVar.zzfd) {
                        return i16;
                    }
                    zzdcVar4.zzm(zzax.zzd(bArr, iZza9));
                    i16 = iZza9 + 8;
                }
                return i16;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzch zzchVar = (zzch) zzcnVar;
                    int iZza10 = zzax.zza(bArr, i, zzayVar);
                    int i17 = zzayVar.zzfd + iZza10;
                    while (iZza10 < i17) {
                        zzchVar.zzac(zzax.zzc(bArr, iZza10));
                        iZza10 += 4;
                    }
                    if (iZza10 == i17) {
                        return iZza10;
                    }
                    throw zzco.zzbl();
                }
                if (i5 != 5) {
                    return i;
                }
                zzch zzchVar2 = (zzch) zzcnVar;
                zzchVar2.zzac(zzax.zzc(bArr, i));
                int i18 = i + 4;
                while (i18 < i2) {
                    int iZza11 = zzax.zza(bArr, i18, zzayVar);
                    if (i3 != zzayVar.zzfd) {
                        return i18;
                    }
                    zzchVar2.zzac(zzax.zzc(bArr, iZza11));
                    i18 = iZza11 + 4;
                }
                return i18;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzaz zzazVar = (zzaz) zzcnVar;
                    int iZza12 = zzax.zza(bArr, i, zzayVar);
                    int i19 = zzayVar.zzfd + iZza12;
                    while (iZza12 < i19) {
                        iZza12 = zzax.zzb(bArr, iZza12, zzayVar);
                        zzazVar.addBoolean(zzayVar.zzfe != 0);
                    }
                    if (iZza12 == i19) {
                        return iZza12;
                    }
                    throw zzco.zzbl();
                }
                if (i5 != 0) {
                    return i;
                }
                zzaz zzazVar2 = (zzaz) zzcnVar;
                int iZzb2 = zzax.zzb(bArr, i, zzayVar);
                break;
            case 26:
                if (i5 != 2) {
                    return i;
                }
                long j3 = j & 536870912;
                int iZza13 = zzax.zza(bArr, i, zzayVar);
                int i20 = zzayVar.zzfd;
                if (j3 == 0) {
                    if (i20 == 0) {
                        zzcnVar.add("");
                    } else {
                        zzcnVar.add(new String(bArr, iZza13, i20, zzci.UTF_8));
                        iZza13 += i20;
                    }
                    while (iZza13 < i2) {
                        int iZza14 = zzax.zza(bArr, iZza13, zzayVar);
                        if (i3 != zzayVar.zzfd) {
                            return iZza13;
                        }
                        iZza13 = zzax.zza(bArr, iZza14, zzayVar);
                        int i21 = zzayVar.zzfd;
                        if (i21 == 0) {
                            zzcnVar.add("");
                            while (iZza13 < i2) {
                            }
                        } else {
                            zzcnVar.add(new String(bArr, iZza13, i21, zzci.UTF_8));
                            iZza13 += i21;
                        }
                    }
                    return iZza13;
                }
                if (i20 == 0) {
                    zzcnVar.add("");
                } else {
                    int i22 = iZza13 + i20;
                    if (!zzff.zze(bArr, iZza13, i22)) {
                        throw zzco.zzbp();
                    }
                    zzcnVar.add(new String(bArr, iZza13, i20, zzci.UTF_8));
                    iZza13 = i22;
                }
                while (iZza13 < i2) {
                    int iZza15 = zzax.zza(bArr, iZza13, zzayVar);
                    if (i3 != zzayVar.zzfd) {
                        return iZza13;
                    }
                    iZza13 = zzax.zza(bArr, iZza15, zzayVar);
                    int i23 = zzayVar.zzfd;
                    if (i23 == 0) {
                        zzcnVar.add("");
                        while (iZza13 < i2) {
                        }
                    } else {
                        int i24 = iZza13 + i23;
                        if (!zzff.zze(bArr, iZza13, i24)) {
                            throw zzco.zzbp();
                        }
                        zzcnVar.add(new String(bArr, iZza13, i23, zzci.UTF_8));
                        iZza13 = i24;
                    }
                }
                return iZza13;
            case 27:
                i8 = i;
                if (i5 == 2) {
                    return zza((zzef<?>) zzad(i6), i3, bArr, i8, i2, (zzcn<?>) zzcnVar, zzayVar);
                }
                return i8;
            case 28:
                i8 = i;
                if (i5 == 2) {
                    int iZza16 = zzax.zza(bArr, i8, zzayVar);
                    int i25 = zzayVar.zzfd;
                    break;
                }
                return i8;
            case 30:
            case 44:
                i9 = i;
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZza = zzax.zza(i3, bArr, i9, i2, (zzcn<?>) zzcnVar, zzayVar);
                    }
                    return i9;
                }
                iZza = zzax.zza(bArr, i9, (zzcn<?>) zzcnVar, zzayVar);
                zzcg zzcgVar = (zzcg) t;
                zzey zzeyVar = zzcgVar.zzjp;
                if (zzeyVar == zzey.zzea()) {
                    zzeyVar = null;
                }
                zzey zzeyVar2 = (zzey) zzeh.zza(i4, zzcnVar, zzaf(i6), zzeyVar, this.zzmx);
                if (zzeyVar2 != null) {
                    zzcgVar.zzjp = zzeyVar2;
                }
                return iZza;
            case 33:
            case 47:
                i9 = i;
                if (i5 == 2) {
                    zzch zzchVar3 = (zzch) zzcnVar;
                    int iZza17 = zzax.zza(bArr, i9, zzayVar);
                    int i26 = zzayVar.zzfd + iZza17;
                    while (iZza17 < i26) {
                        iZza17 = zzax.zza(bArr, iZza17, zzayVar);
                        zzchVar3.zzac(zzbk.zzm(zzayVar.zzfd));
                    }
                    if (iZza17 == i26) {
                        return iZza17;
                    }
                    throw zzco.zzbl();
                }
                if (i5 == 0) {
                    zzch zzchVar4 = (zzch) zzcnVar;
                    int iZza18 = zzax.zza(bArr, i9, zzayVar);
                    while (true) {
                        zzchVar4.zzac(zzbk.zzm(zzayVar.zzfd));
                        if (iZza18 < i2) {
                            int iZza19 = zzax.zza(bArr, iZza18, zzayVar);
                            if (i3 == zzayVar.zzfd) {
                                iZza18 = zzax.zza(bArr, iZza19, zzayVar);
                            }
                        }
                    }
                    return iZza18;
                }
                return i9;
            case 34:
            case 48:
                i9 = i;
                if (i5 == 2) {
                    zzdc zzdcVar5 = (zzdc) zzcnVar;
                    int iZza20 = zzax.zza(bArr, i9, zzayVar);
                    int i27 = zzayVar.zzfd + iZza20;
                    while (iZza20 < i27) {
                        iZza20 = zzax.zzb(bArr, iZza20, zzayVar);
                        zzdcVar5.zzm(zzbk.zza(zzayVar.zzfe));
                    }
                    if (iZza20 == i27) {
                        return iZza20;
                    }
                    throw zzco.zzbl();
                }
                if (i5 == 0) {
                    zzdc zzdcVar6 = (zzdc) zzcnVar;
                    int iZzb3 = zzax.zzb(bArr, i9, zzayVar);
                    while (true) {
                        zzdcVar6.zzm(zzbk.zza(zzayVar.zzfe));
                        if (iZzb3 < i2) {
                            int iZza21 = zzax.zza(bArr, iZzb3, zzayVar);
                            if (i3 == zzayVar.zzfd) {
                                iZzb3 = zzax.zzb(bArr, iZza21, zzayVar);
                            }
                        }
                    }
                    return iZzb3;
                }
                return i9;
            case 49:
                if (i5 == 3) {
                    zzef zzefVarZzad = zzad(i6);
                    int i28 = (i3 & (-8)) | 4;
                    int iZza22 = zza(zzefVarZzad, bArr, i, i2, i28, zzayVar);
                    zzef zzefVar = zzefVarZzad;
                    int i29 = i2;
                    zzay zzayVar2 = zzayVar;
                    zzcnVar.add(zzayVar2.zzff);
                    while (iZza22 < i29) {
                        int iZza23 = zzax.zza(bArr, iZza22, zzayVar2);
                        if (i3 != zzayVar2.zzfd) {
                            return iZza22;
                        }
                        zzef zzefVar2 = zzefVar;
                        int i30 = i29;
                        zzay zzayVar3 = zzayVar2;
                        iZza22 = zza(zzefVar2, bArr, iZza23, i30, i28, zzayVar3);
                        zzcnVar.add(zzayVar3.zzff);
                        zzefVar = zzefVar2;
                        i29 = i30;
                        zzayVar2 = zzayVar3;
                    }
                    return iZza22;
                }
            default:
                return i;
        }
    }

    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, long j, zzay zzayVar) throws IOException {
        byte[] bArr2;
        zzay zzayVar2;
        int i5;
        Unsafe unsafe = zzmh;
        Object objZzae = zzae(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzmz.zzi(object)) {
            Object objZzk = this.zzmz.zzk(objZzae);
            this.zzmz.zzb(objZzk, object);
            unsafe.putObject(t, j, objZzk);
            object = objZzk;
        }
        zzdh<?, ?> zzdhVarZzl = this.zzmz.zzl(objZzae);
        Map<?, ?> mapZzg = this.zzmz.zzg(object);
        int iZza = zzax.zza(bArr, i, zzayVar);
        int i6 = zzayVar.zzfd;
        if (i6 < 0 || i6 > i2 - iZza) {
            throw zzco.zzbl();
        }
        int i7 = i6 + iZza;
        K k = zzdhVarZzl.zzmc;
        V v = zzdhVarZzl.zzdu;
        while (iZza < i7) {
            int iZza2 = iZza + 1;
            int i8 = bArr[iZza];
            if (i8 < 0) {
                iZza2 = zzax.zza(i8, bArr, iZza2, zzayVar);
                i8 = zzayVar.zzfd;
            }
            int i9 = iZza2;
            int i10 = i8 >>> 3;
            int i11 = i8 & 7;
            if (i10 == 1) {
                bArr2 = bArr;
                int i12 = i2;
                zzayVar2 = zzayVar;
                if (i11 == zzdhVarZzl.zzmb.zzel()) {
                    i5 = i12;
                    iZza = zza(bArr2, i9, i5, zzdhVarZzl.zzmb, (Class<?>) null, zzayVar2);
                    k = zzayVar2.zzff;
                    bArr = bArr2;
                    i2 = i5;
                    zzayVar = zzayVar2;
                } else {
                    i5 = i12;
                }
            } else if (i10 == 2 && i11 == zzdhVarZzl.zzmd.zzel()) {
                byte[] bArr3 = bArr;
                int i13 = i2;
                zzay zzayVar3 = zzayVar;
                iZza = zza(bArr3, i9, i13, zzdhVarZzl.zzmd, zzdhVarZzl.zzdu.getClass(), zzayVar3);
                v = (V) zzayVar3.zzff;
                i2 = i13;
                bArr = bArr3;
            } else {
                bArr2 = bArr;
                i5 = i2;
                zzayVar2 = zzayVar;
            }
            iZza = zzax.zza(i8, bArr2, i9, i5, zzayVar2);
            k = k;
            bArr = bArr2;
            i2 = i5;
            zzayVar = zzayVar2;
        }
        if (iZza != i7) {
            throw zzco.zzbo();
        }
        mapZzg.put(k, v);
        return i7;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x0065. Please report as an issue. */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, zzay zzayVar) throws IOException {
        zzds<T> zzdsVar;
        T t2;
        int i4;
        Unsafe unsafe;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        zzds<T> zzdsVar2;
        zzck<?> zzckVarZzaf;
        int i10;
        int i11;
        int i12;
        byte[] bArr2;
        Unsafe unsafe2;
        int i13;
        int i14;
        int i15;
        int i16;
        int iZza;
        int i17;
        zzay zzayVar2;
        int i18;
        long j;
        Object objZza;
        zzay zzayVar3;
        int iZzb;
        Unsafe unsafe3;
        int i19;
        zzds<T> zzdsVar3 = this;
        T t3 = t;
        byte[] bArr3 = bArr;
        int i20 = i2;
        zzay zzayVar4 = zzayVar;
        Unsafe unsafe4 = zzmh;
        int i21 = -1;
        int iZza2 = i;
        int i22 = 0;
        int i23 = -1;
        int i24 = 0;
        while (true) {
            if (iZza2 < i20) {
                int iZza3 = iZza2 + 1;
                int i25 = bArr3[iZza2];
                if (i25 < 0) {
                    iZza3 = zzax.zza(i25, bArr3, iZza3, zzayVar4);
                    i25 = zzayVar4.zzfd;
                }
                int i26 = i25;
                iZza2 = iZza3;
                int i27 = i26 >>> 3;
                int i28 = i26 & 7;
                int iZzai = zzdsVar3.zzai(i27);
                if (iZzai != i21) {
                    int[] iArr = zzdsVar3.zzmi;
                    int i29 = iArr[iZzai + 1];
                    int i30 = (i29 & 267386880) >>> 20;
                    long j2 = i29 & 1048575;
                    if (i30 <= 17) {
                        int i31 = iArr[iZzai + 2];
                        int i32 = 1 << (i31 >>> 20);
                        int i33 = i31 & 1048575;
                        i5 = -1;
                        if (i33 != i23) {
                            if (i23 != -1) {
                                unsafe4.putInt(t3, i23, i24);
                            }
                            i24 = unsafe4.getInt(t3, i33);
                            i23 = i33;
                        }
                        switch (i30) {
                            case 0:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i13 = i26;
                                i14 = i2;
                                i15 = i23;
                                i16 = iZza2;
                                i11 = i24;
                                if (i28 != 1) {
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i23 = i15;
                                    i24 = i11;
                                    break;
                                } else {
                                    zzfd.zza(t3, j2, zzax.zze(bArr2, i16));
                                    iZza = i16 + 8;
                                    i24 = i11 | i32;
                                    zzayVar4 = zzayVar;
                                    i22 = i13;
                                    i20 = i14;
                                    i23 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                            case 1:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i13 = i26;
                                i14 = i2;
                                i15 = i23;
                                i16 = iZza2;
                                i11 = i24;
                                if (i28 != 5) {
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i23 = i15;
                                    i24 = i11;
                                    break;
                                } else {
                                    zzfd.zza((Object) t3, j2, zzax.zzf(bArr2, i16));
                                    iZza = i16 + 4;
                                    i24 = i11 | i32;
                                    zzayVar4 = zzayVar;
                                    i22 = i13;
                                    i20 = i14;
                                    i23 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                            case 2:
                            case 3:
                                unsafe2 = unsafe4;
                                zzayVar3 = zzayVar;
                                i15 = i23;
                                i16 = iZza2;
                                i11 = i24;
                                if (i28 != 0) {
                                    i13 = i26;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i23 = i15;
                                    i24 = i11;
                                    break;
                                } else {
                                    iZzb = zzax.zzb(bArr, i16, zzayVar3);
                                    T t4 = t3;
                                    unsafe2.putLong(t4, j2, zzayVar3.zzfe);
                                    unsafe3 = unsafe2;
                                    t3 = t4;
                                    i24 = i11 | i32;
                                    i20 = i2;
                                    bArr3 = bArr;
                                    i22 = i26;
                                    i23 = i15;
                                    i21 = -1;
                                    unsafe4 = unsafe3;
                                    iZza2 = iZzb;
                                    zzayVar4 = zzayVar3;
                                }
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i17 = i2;
                                zzayVar2 = zzayVar;
                                i15 = i23;
                                i16 = iZza2;
                                i11 = i24;
                                if (i28 != 0) {
                                    i13 = i26;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i23 = i15;
                                    i24 = i11;
                                    break;
                                } else {
                                    iZza = zzax.zza(bArr2, i16, zzayVar2);
                                    unsafe2.putInt(t3, j2, zzayVar2.zzfd);
                                    i24 = i11 | i32;
                                    i20 = i17;
                                    i22 = i26;
                                    zzayVar4 = zzayVar2;
                                    i23 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                i17 = i2;
                                i11 = i24;
                                zzayVar2 = zzayVar;
                                i15 = i23;
                                if (i28 != 1) {
                                    i16 = i18;
                                    i13 = i26;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i23 = i15;
                                    i24 = i11;
                                    break;
                                } else {
                                    T t5 = t3;
                                    unsafe2.putLong(t5, j2, zzax.zzd(bArr2, i18));
                                    unsafe2 = unsafe2;
                                    t3 = t5;
                                    iZza = i18 + 8;
                                    i24 = i11 | i32;
                                    i20 = i17;
                                    i22 = i26;
                                    zzayVar4 = zzayVar2;
                                    i23 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                i17 = i2;
                                i11 = i24;
                                zzayVar2 = zzayVar;
                                i15 = i23;
                                if (i28 != 5) {
                                    i16 = i18;
                                    i13 = i26;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i23 = i15;
                                    i24 = i11;
                                    break;
                                } else {
                                    unsafe2.putInt(t3, j2, zzax.zzc(bArr2, i18));
                                    iZza = i18 + 4;
                                    i24 = i11 | i32;
                                    i20 = i17;
                                    i22 = i26;
                                    zzayVar4 = zzayVar2;
                                    i23 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                            case 7:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                i17 = i2;
                                i11 = i24;
                                zzayVar2 = zzayVar;
                                i15 = i23;
                                if (i28 != 0) {
                                    i16 = i18;
                                    i13 = i26;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i23 = i15;
                                    i24 = i11;
                                    break;
                                } else {
                                    iZza = zzax.zzb(bArr2, i18, zzayVar2);
                                    zzfd.zza(t3, j2, zzayVar2.zzfe != 0);
                                    i24 = i11 | i32;
                                    i20 = i17;
                                    i22 = i26;
                                    zzayVar4 = zzayVar2;
                                    i23 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                            case 8:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                i17 = i2;
                                i11 = i24;
                                zzayVar2 = zzayVar;
                                i15 = i23;
                                j = j2;
                                if (i28 != 2) {
                                    i16 = i18;
                                    i13 = i26;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i23 = i15;
                                    i24 = i11;
                                    break;
                                } else {
                                    iZza = (i29 & 536870912) == 0 ? zzax.zzc(bArr2, i18, zzayVar2) : zzax.zzd(bArr2, i18, zzayVar2);
                                    objZza = zzayVar2.zzff;
                                    unsafe2.putObject(t3, j, objZza);
                                    i24 = i11 | i32;
                                    i20 = i17;
                                    i22 = i26;
                                    zzayVar4 = zzayVar2;
                                    i23 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                            case 9:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                i17 = i2;
                                i11 = i24;
                                zzayVar2 = zzayVar;
                                i15 = i23;
                                j = j2;
                                if (i28 != 2) {
                                    i16 = i18;
                                    i13 = i26;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i23 = i15;
                                    i24 = i11;
                                    break;
                                } else {
                                    iZza = zza(zzdsVar3.zzad(iZzai), bArr2, i18, i17, zzayVar2);
                                    objZza = (i11 & i32) == 0 ? zzayVar2.zzff : zzci.zza(unsafe2.getObject(t3, j), zzayVar2.zzff);
                                    unsafe2.putObject(t3, j, objZza);
                                    i24 = i11 | i32;
                                    i20 = i17;
                                    i22 = i26;
                                    zzayVar4 = zzayVar2;
                                    i23 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                            case 10:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                i17 = i2;
                                i11 = i24;
                                zzayVar2 = zzayVar;
                                i15 = i23;
                                j = j2;
                                if (i28 != 2) {
                                    i16 = i18;
                                    i13 = i26;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i23 = i15;
                                    i24 = i11;
                                    break;
                                } else {
                                    iZza = zzax.zze(bArr2, i18, zzayVar2);
                                    objZza = zzayVar2.zzff;
                                    unsafe2.putObject(t3, j, objZza);
                                    i24 = i11 | i32;
                                    i20 = i17;
                                    i22 = i26;
                                    zzayVar4 = zzayVar2;
                                    i23 = i15;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                            case 12:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                i17 = i2;
                                i11 = i24;
                                zzayVar2 = zzayVar;
                                i15 = i23;
                                if (i28 != 0) {
                                    i16 = i18;
                                    i13 = i26;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i23 = i15;
                                    i24 = i11;
                                    break;
                                } else {
                                    iZza = zzax.zza(bArr2, i18, zzayVar2);
                                    int i34 = zzayVar2.zzfd;
                                    zzck<?> zzckVarZzaf2 = zzdsVar3.zzaf(iZzai);
                                    if (zzckVarZzaf2 == null || zzckVarZzaf2.zzb(i34) != null) {
                                        unsafe2.putInt(t3, j2, i34);
                                        i24 = i11 | i32;
                                        i20 = i17;
                                        i22 = i26;
                                        zzayVar4 = zzayVar2;
                                        i23 = i15;
                                        unsafe4 = unsafe2;
                                        iZza2 = iZza;
                                        bArr3 = bArr2;
                                        i21 = -1;
                                    } else {
                                        zzn(t3).zzb(i26, Long.valueOf(i34));
                                        i20 = i17;
                                        i22 = i26;
                                        zzayVar4 = zzayVar2;
                                        i23 = i15;
                                        i24 = i11;
                                        unsafe4 = unsafe2;
                                        iZza2 = iZza;
                                        bArr3 = bArr2;
                                        i21 = -1;
                                    }
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                unsafe2 = unsafe4;
                                i18 = iZza2;
                                if (i28 != 0) {
                                    i15 = i23;
                                    i11 = i24;
                                    i16 = i18;
                                    i13 = i26;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i23 = i15;
                                    i24 = i11;
                                    break;
                                } else {
                                    iZza = zzax.zza(bArr2, i18, zzayVar);
                                    unsafe2.putInt(t3, j2, zzbk.zzm(zzayVar.zzfd));
                                    i24 |= i32;
                                    i20 = i2;
                                    i22 = i26;
                                    zzayVar4 = zzayVar;
                                    unsafe4 = unsafe2;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                            case 16:
                                i18 = iZza2;
                                if (i28 != 0) {
                                    unsafe2 = unsafe4;
                                    i15 = i23;
                                    i11 = i24;
                                    i16 = i18;
                                    i13 = i26;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i23 = i15;
                                    i24 = i11;
                                    break;
                                } else {
                                    iZzb = zzax.zzb(bArr, i18, zzayVar);
                                    zzayVar3 = zzayVar;
                                    T t6 = t3;
                                    Unsafe unsafe5 = unsafe4;
                                    unsafe5.putLong(t6, j2, zzbk.zza(zzayVar.zzfe));
                                    unsafe3 = unsafe5;
                                    t3 = t6;
                                    i24 |= i32;
                                    i20 = i2;
                                    bArr3 = bArr;
                                    i22 = i26;
                                    i21 = -1;
                                    unsafe4 = unsafe3;
                                    iZza2 = iZzb;
                                    zzayVar4 = zzayVar3;
                                }
                            case 17:
                                if (i28 != 3) {
                                    unsafe2 = unsafe4;
                                    i15 = i23;
                                    i13 = i26;
                                    i16 = iZza2;
                                    i11 = i24;
                                    i6 = i3;
                                    zzdsVar = zzdsVar3;
                                    unsafe = unsafe2;
                                    i12 = i13;
                                    iZza2 = i16;
                                    i23 = i15;
                                    i24 = i11;
                                    break;
                                } else {
                                    iZza = zza(zzdsVar3.zzad(iZzai), bArr, iZza2, i2, (i27 << 3) | 4, zzayVar);
                                    bArr2 = bArr;
                                    unsafe4.putObject(t3, j2, (i24 & i32) == 0 ? zzayVar.zzff : zzci.zza(unsafe4.getObject(t3, j2), zzayVar.zzff));
                                    i24 |= i32;
                                    i20 = i2;
                                    zzayVar4 = zzayVar;
                                    i22 = i26;
                                    iZza2 = iZza;
                                    bArr3 = bArr2;
                                    i21 = -1;
                                }
                            default:
                                unsafe2 = unsafe4;
                                i15 = i23;
                                i13 = i26;
                                i16 = iZza2;
                                i11 = i24;
                                i6 = i3;
                                zzdsVar = zzdsVar3;
                                unsafe = unsafe2;
                                i12 = i13;
                                iZza2 = i16;
                                i23 = i15;
                                i24 = i11;
                                break;
                        }
                    } else {
                        Unsafe unsafe6 = unsafe4;
                        i5 = -1;
                        int i35 = i20;
                        if (i30 != 27) {
                            iZza2 = iZza2;
                            if (i30 <= 49) {
                                i11 = i24;
                                unsafe = unsafe6;
                                i10 = i23;
                                int iZza4 = zzdsVar3.zza((zzds<T>) t, bArr, iZza2, i2, i26, i27, i28, iZzai, i29, i30, j2, zzayVar);
                                i19 = i26;
                                if (iZza4 == iZza2) {
                                    zzdsVar = this;
                                    i6 = i3;
                                    iZza2 = iZza4;
                                    i12 = i19;
                                    i24 = i11;
                                    i23 = i10;
                                } else {
                                    zzdsVar3 = this;
                                    t3 = t;
                                    bArr3 = bArr;
                                    i20 = i2;
                                    zzayVar4 = zzayVar;
                                    iZza2 = iZza4;
                                    i22 = i19;
                                    unsafe4 = unsafe;
                                    i24 = i11;
                                    i21 = -1;
                                    i23 = i10;
                                }
                            } else {
                                unsafe = unsafe6;
                                i10 = i23;
                                i11 = i24;
                                i19 = i26;
                                if (i30 != 50) {
                                    int iZza5 = zza((zzds<T>) t, bArr, iZza2, i2, i19, i27, i28, i29, i30, j2, iZzai, zzayVar);
                                    zzdsVar = this;
                                    i12 = i19;
                                    if (iZza5 == iZza2) {
                                        i23 = i10;
                                        i6 = i3;
                                        iZza2 = iZza5;
                                        i24 = i11;
                                    } else {
                                        t3 = t;
                                        i23 = i10;
                                        i20 = i2;
                                        i22 = i12;
                                        iZza2 = iZza5;
                                        zzdsVar3 = zzdsVar;
                                        unsafe4 = unsafe;
                                        i24 = i11;
                                        i21 = -1;
                                        bArr3 = bArr;
                                        zzayVar4 = zzayVar;
                                    }
                                } else if (i28 == 2) {
                                    int iZza6 = zza(t, bArr, iZza2, i2, iZzai, i27, j2, zzayVar);
                                    if (iZza6 == iZza2) {
                                        zzdsVar = this;
                                        i6 = i3;
                                        iZza2 = iZza6;
                                        i12 = i19;
                                        i24 = i11;
                                        i23 = i10;
                                    } else {
                                        zzdsVar3 = this;
                                        t3 = t;
                                        bArr3 = bArr;
                                        i20 = i2;
                                        zzayVar4 = zzayVar;
                                        iZza2 = iZza6;
                                        i22 = i19;
                                        unsafe4 = unsafe;
                                        i24 = i11;
                                        i21 = -1;
                                        i23 = i10;
                                    }
                                } else {
                                    zzdsVar = this;
                                    i12 = i19;
                                }
                            }
                        } else if (i28 == 2) {
                            zzcn zzcnVarZzi = (zzcn) unsafe6.getObject(t3, j2);
                            if (!zzcnVarZzi.zzu()) {
                                int size = zzcnVarZzi.size();
                                zzcnVarZzi = zzcnVarZzi.zzi(size == 0 ? 10 : size << 1);
                                unsafe6.putObject(t3, j2, zzcnVarZzi);
                            }
                            zzayVar4 = zzayVar;
                            unsafe4 = unsafe6;
                            i20 = i2;
                            iZza2 = zza((zzef<?>) zzdsVar3.zzad(iZzai), i26, bArr, iZza2, i35, (zzcn<?>) zzcnVarZzi, zzayVar4);
                            i22 = i26;
                            i21 = -1;
                            t3 = t;
                            bArr3 = bArr;
                        } else {
                            zzdsVar = zzdsVar3;
                            i12 = i26;
                            unsafe = unsafe6;
                            i10 = i23;
                            iZza2 = iZza2;
                            i11 = i24;
                        }
                    }
                    if (i12 == i6 || i6 == 0) {
                        int i36 = i12;
                        int iZza7 = zza(i36, bArr, iZza2, i2, t, zzayVar);
                        i22 = i36;
                        t3 = t;
                        zzdsVar3 = zzdsVar;
                        unsafe4 = unsafe;
                        i21 = -1;
                        zzayVar4 = zzayVar;
                        i20 = i2;
                        iZza2 = iZza7;
                        bArr3 = bArr;
                    } else {
                        t2 = t;
                        i4 = i2;
                        i7 = i23;
                        i9 = i24;
                        i8 = i12;
                    }
                } else {
                    zzdsVar = zzdsVar3;
                    unsafe = unsafe4;
                    i10 = i23;
                    i11 = i24;
                    i12 = i26;
                    i5 = -1;
                }
                i23 = i10;
                i6 = i3;
                i24 = i11;
                if (i12 == i6) {
                }
                int i362 = i12;
                int iZza72 = zza(i362, bArr, iZza2, i2, t, zzayVar);
                i22 = i362;
                t3 = t;
                zzdsVar3 = zzdsVar;
                unsafe4 = unsafe;
                i21 = -1;
                zzayVar4 = zzayVar;
                i20 = i2;
                iZza2 = iZza72;
                bArr3 = bArr;
            } else {
                zzdsVar = zzdsVar3;
                t2 = t3;
                i4 = i20;
                unsafe = unsafe4;
                int i37 = i24;
                i5 = -1;
                i6 = i3;
                i7 = i23;
                i8 = i22;
                i9 = i37;
            }
        }
        int i38 = iZza2;
        if (i7 != i5) {
            unsafe.putInt(t2, i7, i9);
        }
        int[] iArr2 = zzdsVar.zzmt;
        if (iArr2 != null) {
            int length = iArr2.length;
            Object objZza2 = null;
            int i39 = 0;
            while (i39 < length) {
                int i40 = iArr2[i39];
                zzex zzexVar = zzdsVar.zzmx;
                int i41 = zzdsVar.zzmi[i40];
                Object objZzo = zzfd.zzo(t2, zzdsVar.zzag(i40) & 1048575);
                if (objZzo == null || (zzckVarZzaf = zzdsVar.zzaf(i40)) == null) {
                    zzdsVar2 = zzdsVar;
                } else {
                    Map mapZzg = zzdsVar.zzmz.zzg(objZzo);
                    zzdsVar2 = zzdsVar;
                    objZza2 = zzdsVar2.zza(i40, i41, mapZzg, zzckVarZzaf, (zzck<?>) objZza2, (zzex<UT, zzck<?>>) zzexVar);
                }
                objZza2 = (zzey) objZza2;
                i39++;
                zzdsVar = zzdsVar2;
            }
            zzds<T> zzdsVar4 = zzdsVar;
            if (objZza2 != null) {
                zzdsVar4.zzmx.zzf(t2, objZza2);
            }
        }
        if (i6 == 0) {
            if (i38 != i4) {
                throw zzco.zzbo();
            }
        } else if (i38 > i4 || i8 != i6) {
            throw zzco.zzbo();
        }
        return i38;
    }

    private static int zza(byte[] bArr, int i, int i2, zzfl zzflVar, Class<?> cls, zzay zzayVar) throws IOException {
        switch (zzdt.zzgq[zzflVar.ordinal()]) {
            case 1:
                int iZzb = zzax.zzb(bArr, i, zzayVar);
                zzayVar.zzff = Boolean.valueOf(zzayVar.zzfe != 0);
                return iZzb;
            case 2:
                return zzax.zze(bArr, i, zzayVar);
            case 3:
                zzayVar.zzff = Double.valueOf(zzax.zze(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzayVar.zzff = Integer.valueOf(zzax.zzc(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzayVar.zzff = Long.valueOf(zzax.zzd(bArr, i));
                return i + 8;
            case 8:
                zzayVar.zzff = Float.valueOf(zzax.zzf(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZza = zzax.zza(bArr, i, zzayVar);
                zzayVar.zzff = Integer.valueOf(zzayVar.zzfd);
                return iZza;
            case 12:
            case 13:
                int iZzb2 = zzax.zzb(bArr, i, zzayVar);
                zzayVar.zzff = Long.valueOf(zzayVar.zzfe);
                return iZzb2;
            case 14:
                return zza((zzef) zzea.zzcm().zze(cls), bArr, i, i2, zzayVar);
            case 15:
                int iZza2 = zzax.zza(bArr, i, zzayVar);
                zzayVar.zzff = Integer.valueOf(zzbk.zzm(zzayVar.zzfd));
                return iZza2;
            case 16:
                int iZzb3 = zzax.zzb(bArr, i, zzayVar);
                zzayVar.zzff = Long.valueOf(zzbk.zza(zzayVar.zzfe));
                return iZzb3;
            case 17:
                return zzax.zzd(bArr, i, zzayVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    static <T> zzds<T> zza(Class<T> cls, zzdm zzdmVar, zzdw zzdwVar, zzcy zzcyVar, zzex<?, ?> zzexVar, zzbu<?> zzbuVar, zzdj zzdjVar) {
        int iZzcu;
        int i;
        int i2;
        int iZza;
        int iZzdg;
        int iZza2;
        if (!(zzdmVar instanceof zzec)) {
            ((zzes) zzdmVar).zzcf();
            throw new NoSuchMethodError();
        }
        zzec zzecVar = (zzec) zzdmVar;
        boolean z = zzecVar.zzcf() == zzcg.zzg.zzkm;
        if (zzecVar.getFieldCount() == 0) {
            iZzcu = 0;
            i = 0;
            i2 = 0;
        } else {
            int iZzcp = zzecVar.zzcp();
            int iZzcq = zzecVar.zzcq();
            iZzcu = zzecVar.zzcu();
            i = iZzcp;
            i2 = iZzcq;
        }
        int[] iArr = new int[iZzcu << 2];
        Object[] objArr = new Object[iZzcu << 1];
        int[] iArr2 = zzecVar.zzcr() > 0 ? new int[zzecVar.zzcr()] : null;
        int[] iArr3 = zzecVar.zzcs() > 0 ? new int[zzecVar.zzcs()] : null;
        zzed zzedVarZzco = zzecVar.zzco();
        if (zzedVarZzco.next()) {
            int iZzcx = zzedVarZzco.zzcx();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (iZzcx >= zzecVar.zzcv() || i3 >= ((iZzcx - i) << 2)) {
                    if (zzedVarZzco.zzda()) {
                        iZza = (int) zzfd.zza(zzedVarZzco.zzdb());
                        iZza2 = (int) zzfd.zza(zzedVarZzco.zzdc());
                        iZzdg = 0;
                    } else {
                        iZza = (int) zzfd.zza(zzedVarZzco.zzdd());
                        if (zzedVarZzco.zzde()) {
                            iZza2 = (int) zzfd.zza(zzedVarZzco.zzdf());
                            iZzdg = zzedVarZzco.zzdg();
                        } else {
                            iZzdg = 0;
                            iZza2 = 0;
                        }
                    }
                    iArr[i3] = zzedVarZzco.zzcx();
                    int i6 = i3 + 1;
                    iArr[i6] = (zzedVarZzco.zzdi() ? 536870912 : 0) | (zzedVarZzco.zzdh() ? DriveFile.MODE_READ_ONLY : 0) | (zzedVarZzco.zzcy() << 20) | iZza;
                    iArr[i3 + 2] = (iZzdg << 20) | iZza2;
                    if (zzedVarZzco.zzdl() != null) {
                        int i7 = (i3 / 4) << 1;
                        objArr[i7] = zzedVarZzco.zzdl();
                        if (zzedVarZzco.zzdj() != null) {
                            objArr[i7 + 1] = zzedVarZzco.zzdj();
                        } else if (zzedVarZzco.zzdk() != null) {
                            objArr[i7 + 1] = zzedVarZzco.zzdk();
                        }
                    } else if (zzedVarZzco.zzdj() != null) {
                        objArr[((i3 / 4) << 1) + 1] = zzedVarZzco.zzdj();
                    } else if (zzedVarZzco.zzdk() != null) {
                        objArr[((i3 / 4) << 1) + 1] = zzedVarZzco.zzdk();
                    }
                    int iZzcy = zzedVarZzco.zzcy();
                    if (iZzcy == zzcb.MAP.ordinal()) {
                        iArr2[i4] = i3;
                        i4++;
                    } else if (iZzcy >= 18 && iZzcy <= 49) {
                        iArr3[i5] = iArr[i6] & 1048575;
                        i5++;
                    }
                    if (!zzedVarZzco.next()) {
                        break;
                    }
                    iZzcx = zzedVarZzco.zzcx();
                } else {
                    for (int i8 = 0; i8 < 4; i8++) {
                        iArr[i3 + i8] = -1;
                    }
                }
                i3 += 4;
            }
        }
        return new zzds<>(iArr, objArr, i, i2, zzecVar.zzcv(), zzecVar.zzch(), z, false, zzecVar.zzct(), iArr2, iArr3, zzdwVar, zzcyVar, zzexVar, zzbuVar, zzdjVar);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzck<?> zzckVar, UB ub, zzex<UT, UB> zzexVar) {
        zzdh<?, ?> zzdhVarZzl = this.zzmz.zzl(zzae(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (zzckVar.zzb(((Integer) next.getValue()).intValue()) == null) {
                if (ub == null) {
                    ub = zzexVar.zzdz();
                }
                zzbg zzbgVarZzk = zzbb.zzk(zzdg.zza(zzdhVarZzl, next.getKey(), next.getValue()));
                try {
                    zzdg.zza(zzbgVarZzk.zzae(), zzdhVarZzl, next.getKey(), next.getValue());
                    zzexVar.zza((zzex<UT, UB>) ub, i2, zzbgVarZzk.zzad());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private static void zza(int i, Object obj, zzfr zzfrVar) throws IOException {
        if (obj instanceof String) {
            zzfrVar.zza(i, (String) obj);
        } else {
            zzfrVar.zza(i, (zzbb) obj);
        }
    }

    private static <UT, UB> void zza(zzex<UT, UB> zzexVar, T t, zzfr zzfrVar) throws IOException {
        zzexVar.zza(zzexVar.zzq(t), zzfrVar);
    }

    private final <K, V> void zza(zzfr zzfrVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzfrVar.zza(i, this.zzmz.zzl(zzae(i2)), this.zzmz.zzh(obj));
        }
    }

    private final void zza(T t, T t2, int i) {
        long jZzag = zzag(i) & 1048575;
        if (zza((zzds<T>) t2, i)) {
            Object objZzo = zzfd.zzo(t, jZzag);
            Object objZzo2 = zzfd.zzo(t2, jZzag);
            if (objZzo != null && objZzo2 != null) {
                objZzo2 = zzci.zza(objZzo, objZzo2);
            } else if (objZzo2 == null) {
                return;
            }
            zzfd.zza(t, jZzag, objZzo2);
            zzb((zzds<T>) t, i);
        }
    }

    private final boolean zza(T t, int i) {
        if (!this.zzmq) {
            int iZzah = zzah(i);
            return (zzfd.zzj(t, (long) (iZzah & 1048575)) & (1 << (iZzah >>> 20))) != 0;
        }
        int iZzag = zzag(i);
        long j = iZzag & 1048575;
        switch ((iZzag & 267386880) >>> 20) {
            case 0:
                return zzfd.zzn(t, j) != 0.0d;
            case 1:
                return zzfd.zzm(t, j) != 0.0f;
            case 2:
                return zzfd.zzk(t, j) != 0;
            case 3:
                return zzfd.zzk(t, j) != 0;
            case 4:
                return zzfd.zzj(t, j) != 0;
            case 5:
                return zzfd.zzk(t, j) != 0;
            case 6:
                return zzfd.zzj(t, j) != 0;
            case 7:
                return zzfd.zzl(t, j);
            case 8:
                Object objZzo = zzfd.zzo(t, j);
                if (objZzo instanceof String) {
                    return !((String) objZzo).isEmpty();
                }
                if (objZzo instanceof zzbb) {
                    return !zzbb.zzfi.equals(objZzo);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzfd.zzo(t, j) != null;
            case 10:
                return !zzbb.zzfi.equals(zzfd.zzo(t, j));
            case 11:
                return zzfd.zzj(t, j) != 0;
            case 12:
                return zzfd.zzj(t, j) != 0;
            case 13:
                return zzfd.zzj(t, j) != 0;
            case 14:
                return zzfd.zzk(t, j) != 0;
            case 15:
                return zzfd.zzj(t, j) != 0;
            case 16:
                return zzfd.zzk(t, j) != 0;
            case 17:
                return zzfd.zzo(t, j) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzfd.zzj(t, (long) (zzah(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        return this.zzmq ? zza((zzds<T>) t, i) : (i2 & i3) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzef zzefVar) {
        return zzefVar.zzo(zzfd.zzo(obj, i & 1048575));
    }

    private final zzef zzad(int i) {
        int i2 = (i / 4) << 1;
        zzef zzefVar = (zzef) this.zzmj[i2];
        if (zzefVar != null) {
            return zzefVar;
        }
        zzef<T> zzefVarZze = zzea.zzcm().zze((Class) this.zzmj[i2 + 1]);
        this.zzmj[i2] = zzefVarZze;
        return zzefVarZze;
    }

    private final Object zzae(int i) {
        return this.zzmj[(i / 4) << 1];
    }

    private final zzck<?> zzaf(int i) {
        return (zzck) this.zzmj[((i / 4) << 1) + 1];
    }

    private final int zzag(int i) {
        return this.zzmi[i + 1];
    }

    private final int zzah(int i) {
        return this.zzmi[i + 2];
    }

    private final int zzai(int i) {
        int i2 = this.zzmk;
        if (i >= i2) {
            int i3 = this.zzmm;
            if (i < i3) {
                int i4 = (i - i2) << 2;
                if (this.zzmi[i4] == i) {
                    return i4;
                }
                return -1;
            }
            if (i <= this.zzml) {
                int i5 = i3 - i2;
                int length = (this.zzmi.length / 4) - 1;
                while (i5 <= length) {
                    int i6 = (length + i5) >>> 1;
                    int i7 = i6 << 2;
                    int i8 = this.zzmi[i7];
                    if (i == i8) {
                        return i7;
                    }
                    if (i < i8) {
                        length = i6 - 1;
                    } else {
                        i5 = i6 + 1;
                    }
                }
            }
        }
        return -1;
    }

    private final void zzb(T t, int i) {
        if (this.zzmq) {
            return;
        }
        int iZzah = zzah(i);
        long j = iZzah & 1048575;
        zzfd.zza((Object) t, j, zzfd.zzj(t, j) | (1 << (iZzah >>> 20)));
    }

    private final void zzb(T t, int i, int i2) {
        zzfd.zza((Object) t, zzah(i2) & 1048575, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzb(T t, zzfr zzfrVar) throws IOException {
        Iterator it;
        Map.Entry<?, ?> entry;
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        int i7;
        List list;
        boolean z6;
        if (this.zzmo) {
            zzby<T> zzbyVarZza = this.zzmy.zza(t);
            if (zzbyVarZza.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = zzbyVarZza.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length = this.zzmi.length;
        Unsafe unsafe = zzmh;
        int i8 = -1;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10 += 4) {
            int iZzag = zzag(i10);
            int[] iArr = this.zzmi;
            int i11 = iArr[i10];
            int i12 = (267386880 & iZzag) >>> 20;
            if (this.zzmq || i12 > 17) {
                i = 0;
            } else {
                int i13 = iArr[i10 + 2];
                int i14 = i13 & 1048575;
                if (i14 != i8) {
                    i9 = unsafe.getInt(t, i14);
                    i8 = i14;
                }
                i = 1 << (i13 >>> 20);
            }
            while (entry != null && this.zzmy.zza(entry) <= i11) {
                this.zzmy.zza(zzfrVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = iZzag & 1048575;
            switch (i12) {
                case 0:
                    if ((i & i9) != 0) {
                        zzfrVar.zza(i11, zzfd.zzn(t, j));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i & i9) != 0) {
                        zzfrVar.zza(i11, zzfd.zzm(t, j));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i & i9) != 0) {
                        zzfrVar.zzi(i11, unsafe.getLong(t, j));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i & i9) != 0) {
                        zzfrVar.zza(i11, unsafe.getLong(t, j));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i & i9) != 0) {
                        zzfrVar.zzc(i11, unsafe.getInt(t, j));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i & i9) != 0) {
                        zzfrVar.zzc(i11, unsafe.getLong(t, j));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i & i9) != 0) {
                        zzfrVar.zzf(i11, unsafe.getInt(t, j));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i & i9) != 0) {
                        zzfrVar.zzb(i11, zzfd.zzl(t, j));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i & i9) != 0) {
                        zza(i11, unsafe.getObject(t, j), zzfrVar);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i & i9) != 0) {
                        zzfrVar.zza(i11, unsafe.getObject(t, j), zzad(i10));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i & i9) != 0) {
                        zzfrVar.zza(i11, (zzbb) unsafe.getObject(t, j));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i & i9) != 0) {
                        zzfrVar.zzd(i11, unsafe.getInt(t, j));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i & i9) != 0) {
                        zzfrVar.zzn(i11, unsafe.getInt(t, j));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i & i9) != 0) {
                        zzfrVar.zzm(i11, unsafe.getInt(t, j));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i & i9) != 0) {
                        zzfrVar.zzj(i11, unsafe.getLong(t, j));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i & i9) != 0) {
                        zzfrVar.zze(i11, unsafe.getInt(t, j));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i & i9) != 0) {
                        zzfrVar.zzb(i11, unsafe.getLong(t, j));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i & i9) != 0) {
                        zzfrVar.zzb(i11, unsafe.getObject(t, j), zzad(i10));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzeh.zza(this.zzmi[i10], (List<Double>) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 19:
                    zzeh.zzb(this.zzmi[i10], (List<Float>) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 20:
                    zzeh.zzc(this.zzmi[i10], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 21:
                    zzeh.zzd(this.zzmi[i10], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 22:
                    zzeh.zzh(this.zzmi[i10], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 23:
                    zzeh.zzf(this.zzmi[i10], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 24:
                    zzeh.zzk(this.zzmi[i10], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 25:
                    zzeh.zzn(this.zzmi[i10], (List) unsafe.getObject(t, j), zzfrVar, false);
                    break;
                case 26:
                    zzeh.zza(this.zzmi[i10], (List<String>) unsafe.getObject(t, j), zzfrVar);
                    break;
                case 27:
                    zzeh.zza(this.zzmi[i10], (List<?>) unsafe.getObject(t, j), zzfrVar, zzad(i10));
                    break;
                case 28:
                    zzeh.zzb(this.zzmi[i10], (List) unsafe.getObject(t, j), zzfrVar);
                    break;
                case 29:
                    z = false;
                    i2 = this.zzmi[i10];
                    zzeh.zzi(i2, (List) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 30:
                    z2 = false;
                    i3 = this.zzmi[i10];
                    zzeh.zzm(i3, (List) unsafe.getObject(t, j), zzfrVar, z2);
                    break;
                case 31:
                    z3 = false;
                    i4 = this.zzmi[i10];
                    zzeh.zzl(i4, (List) unsafe.getObject(t, j), zzfrVar, z3);
                    break;
                case 32:
                    z4 = false;
                    i5 = this.zzmi[i10];
                    zzeh.zzg(i5, (List) unsafe.getObject(t, j), zzfrVar, z4);
                    break;
                case 33:
                    z5 = false;
                    i6 = this.zzmi[i10];
                    zzeh.zzj(i6, (List) unsafe.getObject(t, j), zzfrVar, z5);
                    break;
                case 34:
                    i7 = this.zzmi[i10];
                    list = (List) unsafe.getObject(t, j);
                    z6 = false;
                    zzeh.zze(i7, list, zzfrVar, z6);
                    break;
                case 35:
                    zzeh.zza(this.zzmi[i10], (List<Double>) unsafe.getObject(t, j), zzfrVar, true);
                    break;
                case 36:
                    zzeh.zzb(this.zzmi[i10], (List<Float>) unsafe.getObject(t, j), zzfrVar, true);
                    break;
                case 37:
                    zzeh.zzc(this.zzmi[i10], (List) unsafe.getObject(t, j), zzfrVar, true);
                    break;
                case 38:
                    zzeh.zzd(this.zzmi[i10], (List) unsafe.getObject(t, j), zzfrVar, true);
                    break;
                case 39:
                    zzeh.zzh(this.zzmi[i10], (List) unsafe.getObject(t, j), zzfrVar, true);
                    break;
                case 40:
                    zzeh.zzf(this.zzmi[i10], (List) unsafe.getObject(t, j), zzfrVar, true);
                    break;
                case 41:
                    zzeh.zzk(this.zzmi[i10], (List) unsafe.getObject(t, j), zzfrVar, true);
                    break;
                case 42:
                    zzeh.zzn(this.zzmi[i10], (List) unsafe.getObject(t, j), zzfrVar, true);
                    break;
                case 43:
                    z = true;
                    i2 = this.zzmi[i10];
                    zzeh.zzi(i2, (List) unsafe.getObject(t, j), zzfrVar, z);
                    break;
                case 44:
                    z2 = true;
                    i3 = this.zzmi[i10];
                    zzeh.zzm(i3, (List) unsafe.getObject(t, j), zzfrVar, z2);
                    break;
                case 45:
                    z3 = true;
                    i4 = this.zzmi[i10];
                    zzeh.zzl(i4, (List) unsafe.getObject(t, j), zzfrVar, z3);
                    break;
                case 46:
                    z4 = true;
                    i5 = this.zzmi[i10];
                    zzeh.zzg(i5, (List) unsafe.getObject(t, j), zzfrVar, z4);
                    break;
                case 47:
                    z5 = true;
                    i6 = this.zzmi[i10];
                    zzeh.zzj(i6, (List) unsafe.getObject(t, j), zzfrVar, z5);
                    break;
                case 48:
                    i7 = this.zzmi[i10];
                    list = (List) unsafe.getObject(t, j);
                    z6 = true;
                    zzeh.zze(i7, list, zzfrVar, z6);
                    break;
                case 49:
                    zzeh.zzb(this.zzmi[i10], (List<?>) unsafe.getObject(t, j), zzfrVar, zzad(i10));
                    break;
                case 50:
                    zza(zzfrVar, i11, unsafe.getObject(t, j), i10);
                    break;
                case 51:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zza(i11, zze(t, j));
                    }
                    break;
                case 52:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zza(i11, zzf(t, j));
                    }
                    break;
                case 53:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zzi(i11, zzh(t, j));
                    }
                    break;
                case 54:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zza(i11, zzh(t, j));
                    }
                    break;
                case 55:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zzc(i11, zzg(t, j));
                    }
                    break;
                case 56:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zzc(i11, zzh(t, j));
                    }
                    break;
                case 57:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zzf(i11, zzg(t, j));
                    }
                    break;
                case 58:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zzb(i11, zzi(t, j));
                    }
                    break;
                case 59:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zza(i11, unsafe.getObject(t, j), zzfrVar);
                    }
                    break;
                case 60:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zza(i11, unsafe.getObject(t, j), zzad(i10));
                    }
                    break;
                case 61:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zza(i11, (zzbb) unsafe.getObject(t, j));
                    }
                    break;
                case 62:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zzd(i11, zzg(t, j));
                    }
                    break;
                case 63:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zzn(i11, zzg(t, j));
                    }
                    break;
                case 64:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zzm(i11, zzg(t, j));
                    }
                    break;
                case 65:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zzj(i11, zzh(t, j));
                    }
                    break;
                case 66:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zze(i11, zzg(t, j));
                    }
                    break;
                case 67:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zzb(i11, zzh(t, j));
                    }
                    break;
                case 68:
                    if (zza((zzds<T>) t, i11, i10)) {
                        zzfrVar.zzb(i11, unsafe.getObject(t, j), zzad(i10));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.zzmy.zza(zzfrVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zza(this.zzmx, t, zzfrVar);
    }

    private final void zzb(T t, T t2, int i) {
        int iZzag = zzag(i);
        int i2 = this.zzmi[i];
        long j = iZzag & 1048575;
        if (zza((zzds<T>) t2, i2, i)) {
            Object objZzo = zzfd.zzo(t, j);
            Object objZzo2 = zzfd.zzo(t2, j);
            if (objZzo != null && objZzo2 != null) {
                objZzo2 = zzci.zza(objZzo, objZzo2);
            } else if (objZzo2 == null) {
                return;
            }
            zzfd.zza(t, j, objZzo2);
            zzb((zzds<T>) t, i2, i);
        }
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza((zzds<T>) t, i) == zza((zzds<T>) t2, i);
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzfd.zzo(obj, j);
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zzfd.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zzfd.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zzfd.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zzfd.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zzfd.zzo(t, j)).booleanValue();
    }

    private static zzey zzn(Object obj) {
        zzcg zzcgVar = (zzcg) obj;
        zzey zzeyVar = zzcgVar.zzjp;
        if (zzeyVar != zzey.zzea()) {
            return zzeyVar;
        }
        zzey zzeyVarZzeb = zzey.zzeb();
        zzcgVar.zzjp = zzeyVarZzeb;
        return zzeyVarZzeb;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01a2  */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(T t, T t2) {
        int length = this.zzmi.length;
        int i = 0;
        while (true) {
            boolean zZzd = true;
            if (i >= length) {
                if (!this.zzmx.zzq(t).equals(this.zzmx.zzq(t2))) {
                    return false;
                }
                if (this.zzmo) {
                    return this.zzmy.zza(t).equals(this.zzmy.zza(t2));
                }
                return true;
            }
            int iZzag = zzag(i);
            long j = iZzag & 1048575;
            switch ((iZzag & 267386880) >>> 20) {
                case 0:
                    if (!zzc(t, t2, i) || zzfd.zzk(t, j) != zzfd.zzk(t2, j)) {
                        zZzd = false;
                        break;
                    }
                    break;
                case 1:
                    if (!zzc(t, t2, i) || zzfd.zzj(t, j) != zzfd.zzj(t2, j)) {
                    }
                    break;
                case 2:
                    if (!zzc(t, t2, i) || zzfd.zzk(t, j) != zzfd.zzk(t2, j)) {
                    }
                    break;
                case 3:
                    if (!zzc(t, t2, i) || zzfd.zzk(t, j) != zzfd.zzk(t2, j)) {
                    }
                    break;
                case 4:
                    if (!zzc(t, t2, i) || zzfd.zzj(t, j) != zzfd.zzj(t2, j)) {
                    }
                    break;
                case 5:
                    if (!zzc(t, t2, i) || zzfd.zzk(t, j) != zzfd.zzk(t2, j)) {
                    }
                    break;
                case 6:
                    if (!zzc(t, t2, i) || zzfd.zzj(t, j) != zzfd.zzj(t2, j)) {
                    }
                    break;
                case 7:
                    if (!zzc(t, t2, i) || zzfd.zzl(t, j) != zzfd.zzl(t2, j)) {
                    }
                    break;
                case 8:
                    if (!zzc(t, t2, i) || !zzeh.zzd(zzfd.zzo(t, j), zzfd.zzo(t2, j))) {
                    }
                    break;
                case 9:
                    if (!zzc(t, t2, i) || !zzeh.zzd(zzfd.zzo(t, j), zzfd.zzo(t2, j))) {
                    }
                    break;
                case 10:
                    if (!zzc(t, t2, i) || !zzeh.zzd(zzfd.zzo(t, j), zzfd.zzo(t2, j))) {
                    }
                    break;
                case 11:
                    if (!zzc(t, t2, i) || zzfd.zzj(t, j) != zzfd.zzj(t2, j)) {
                    }
                    break;
                case 12:
                    if (!zzc(t, t2, i) || zzfd.zzj(t, j) != zzfd.zzj(t2, j)) {
                    }
                    break;
                case 13:
                    if (!zzc(t, t2, i) || zzfd.zzj(t, j) != zzfd.zzj(t2, j)) {
                    }
                    break;
                case 14:
                    if (!zzc(t, t2, i) || zzfd.zzk(t, j) != zzfd.zzk(t2, j)) {
                    }
                    break;
                case 15:
                    if (!zzc(t, t2, i) || zzfd.zzj(t, j) != zzfd.zzj(t2, j)) {
                    }
                    break;
                case 16:
                    if (!zzc(t, t2, i) || zzfd.zzk(t, j) != zzfd.zzk(t2, j)) {
                    }
                    break;
                case 17:
                    if (!zzc(t, t2, i) || !zzeh.zzd(zzfd.zzo(t, j), zzfd.zzo(t2, j))) {
                    }
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    zZzd = zzeh.zzd(zzfd.zzo(t, j), zzfd.zzo(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzah = zzah(i) & 1048575;
                    if (zzfd.zzj(t, jZzah) != zzfd.zzj(t2, jZzah) || !zzeh.zzd(zzfd.zzo(t, j), zzfd.zzo(t2, j))) {
                    }
                    break;
            }
            if (!zZzd) {
                return false;
            }
            i += 4;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e2 A[PHI: r3
      0x00e2: PHI (r3v13 java.lang.Object) = (r3v11 java.lang.Object), (r3v14 java.lang.Object) binds: [B:67:0x00e0, B:62:0x00ce] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int hashCode(T t) {
        int i;
        double dZzn;
        float fZzm;
        long jZzk;
        int iZzj;
        boolean zZzl;
        Object objZzo;
        Object objZzo2;
        int length = this.zzmi.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 4) {
            int iZzag = zzag(i3);
            int i4 = this.zzmi[i3];
            long j = 1048575 & iZzag;
            int iHashCode = 37;
            switch ((iZzag & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    dZzn = zzfd.zzn(t, j);
                    jZzk = Double.doubleToLongBits(dZzn);
                    iZzj = zzci.zzl(jZzk);
                    i2 = i + iZzj;
                    break;
                case 1:
                    i = i2 * 53;
                    fZzm = zzfd.zzm(t, j);
                    iZzj = Float.floatToIntBits(fZzm);
                    i2 = i + iZzj;
                    break;
                case 2:
                case 3:
                case 5:
                case 14:
                case 16:
                    i = i2 * 53;
                    jZzk = zzfd.zzk(t, j);
                    iZzj = zzci.zzl(jZzk);
                    i2 = i + iZzj;
                    break;
                case 4:
                case 6:
                case 11:
                case 12:
                case 13:
                case 15:
                    i = i2 * 53;
                    iZzj = zzfd.zzj(t, j);
                    i2 = i + iZzj;
                    break;
                case 7:
                    i = i2 * 53;
                    zZzl = zzfd.zzl(t, j);
                    iZzj = zzci.zzc(zZzl);
                    i2 = i + iZzj;
                    break;
                case 8:
                    i = i2 * 53;
                    iZzj = ((String) zzfd.zzo(t, j)).hashCode();
                    i2 = i + iZzj;
                    break;
                case 9:
                    objZzo = zzfd.zzo(t, j);
                    if (objZzo != null) {
                        iHashCode = objZzo.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    i = i2 * 53;
                    objZzo2 = zzfd.zzo(t, j);
                    iZzj = objZzo2.hashCode();
                    i2 = i + iZzj;
                    break;
                case 17:
                    objZzo = zzfd.zzo(t, j);
                    if (objZzo != null) {
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 51:
                    if (zza((zzds<T>) t, i4, i3)) {
                        i = i2 * 53;
                        dZzn = zze(t, j);
                        jZzk = Double.doubleToLongBits(dZzn);
                        iZzj = zzci.zzl(jZzk);
                        i2 = i + iZzj;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza((zzds<T>) t, i4, i3)) {
                        i = i2 * 53;
                        fZzm = zzf(t, j);
                        iZzj = Float.floatToIntBits(fZzm);
                        i2 = i + iZzj;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    jZzk = zzh(t, j);
                    iZzj = zzci.zzl(jZzk);
                    i2 = i + iZzj;
                    break;
                case 54:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    jZzk = zzh(t, j);
                    iZzj = zzci.zzl(jZzk);
                    i2 = i + iZzj;
                    break;
                case 55:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    iZzj = zzg(t, j);
                    i2 = i + iZzj;
                    break;
                case 56:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    jZzk = zzh(t, j);
                    iZzj = zzci.zzl(jZzk);
                    i2 = i + iZzj;
                    break;
                case 57:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    iZzj = zzg(t, j);
                    i2 = i + iZzj;
                    break;
                case 58:
                    if (zza((zzds<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zZzl = zzi(t, j);
                        iZzj = zzci.zzc(zZzl);
                        i2 = i + iZzj;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    iZzj = ((String) zzfd.zzo(t, j)).hashCode();
                    i2 = i + iZzj;
                    break;
                case 60:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    objZzo2 = zzfd.zzo(t, j);
                    i = i2 * 53;
                    iZzj = objZzo2.hashCode();
                    i2 = i + iZzj;
                    break;
                case 61:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    objZzo2 = zzfd.zzo(t, j);
                    iZzj = objZzo2.hashCode();
                    i2 = i + iZzj;
                    break;
                case 62:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    iZzj = zzg(t, j);
                    i2 = i + iZzj;
                    break;
                case 63:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    iZzj = zzg(t, j);
                    i2 = i + iZzj;
                    break;
                case 64:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    iZzj = zzg(t, j);
                    i2 = i + iZzj;
                    break;
                case 65:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    jZzk = zzh(t, j);
                    iZzj = zzci.zzl(jZzk);
                    i2 = i + iZzj;
                    break;
                case 66:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    iZzj = zzg(t, j);
                    i2 = i + iZzj;
                    break;
                case 67:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    i = i2 * 53;
                    jZzk = zzh(t, j);
                    iZzj = zzci.zzl(jZzk);
                    i2 = i + iZzj;
                    break;
                case 68:
                    if (!zza((zzds<T>) t, i4, i3)) {
                        break;
                    }
                    objZzo2 = zzfd.zzo(t, j);
                    i = i2 * 53;
                    iZzj = objZzo2.hashCode();
                    i2 = i + iZzj;
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzmx.zzq(t).hashCode();
        return this.zzmo ? (iHashCode2 * 53) + this.zzmy.zza(t).hashCode() : iHashCode2;
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final T newInstance() {
        return (T) this.zzmv.newInstance(this.zzmn);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0842  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x08bd  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x08d0  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x08e5  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, zzfr zzfrVar) throws IOException {
        Iterator it;
        Map.Entry<?, ?> entry;
        double dZzn;
        float fZzm;
        long jZzk;
        long jZzk2;
        int iZzj;
        long jZzk3;
        int iZzj2;
        boolean zZzl;
        int iZzj3;
        int iZzj4;
        int iZzj5;
        long jZzk4;
        int iZzj6;
        long jZzk5;
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry2;
        double dZzn2;
        float fZzm2;
        long jZzk6;
        long jZzk7;
        int iZzj7;
        long jZzk8;
        int iZzj8;
        boolean zZzl2;
        int iZzj9;
        int iZzj10;
        int iZzj11;
        long jZzk9;
        int iZzj12;
        long jZzk10;
        if (zzfrVar.zzaj() == zzcg.zzg.zzkp) {
            zza(this.zzmx, t, zzfrVar);
            if (this.zzmo) {
                zzby<T> zzbyVarZza = this.zzmy.zza(t);
                if (zzbyVarZza.isEmpty()) {
                    itDescendingIterator = null;
                    entry2 = null;
                } else {
                    itDescendingIterator = zzbyVarZza.descendingIterator();
                    entry2 = (Map.Entry) itDescendingIterator.next();
                }
            }
            for (int length = this.zzmi.length - 4; length >= 0; length -= 4) {
                int iZzag = zzag(length);
                int i = this.zzmi[length];
                while (entry2 != null && this.zzmy.zza(entry2) > i) {
                    this.zzmy.zza(zzfrVar, entry2);
                    entry2 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
                }
                switch ((iZzag & 267386880) >>> 20) {
                    case 0:
                        if (zza((zzds<T>) t, length)) {
                            dZzn2 = zzfd.zzn(t, iZzag & 1048575);
                            zzfrVar.zza(i, dZzn2);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzds<T>) t, length)) {
                            fZzm2 = zzfd.zzm(t, iZzag & 1048575);
                            zzfrVar.zza(i, fZzm2);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzds<T>) t, length)) {
                            jZzk6 = zzfd.zzk(t, iZzag & 1048575);
                            zzfrVar.zzi(i, jZzk6);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzds<T>) t, length)) {
                            jZzk7 = zzfd.zzk(t, iZzag & 1048575);
                            zzfrVar.zza(i, jZzk7);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzds<T>) t, length)) {
                            iZzj7 = zzfd.zzj(t, iZzag & 1048575);
                            zzfrVar.zzc(i, iZzj7);
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzds<T>) t, length)) {
                            jZzk8 = zzfd.zzk(t, iZzag & 1048575);
                            zzfrVar.zzc(i, jZzk8);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzds<T>) t, length)) {
                            iZzj8 = zzfd.zzj(t, iZzag & 1048575);
                            zzfrVar.zzf(i, iZzj8);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzds<T>) t, length)) {
                            zZzl2 = zzfd.zzl(t, iZzag & 1048575);
                            zzfrVar.zzb(i, zZzl2);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzds<T>) t, length)) {
                            zza(i, zzfd.zzo(t, iZzag & 1048575), zzfrVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzds<T>) t, length)) {
                            zzfrVar.zza(i, zzfd.zzo(t, iZzag & 1048575), zzad(length));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzds<T>) t, length)) {
                            zzfrVar.zza(i, (zzbb) zzfd.zzo(t, iZzag & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzds<T>) t, length)) {
                            iZzj9 = zzfd.zzj(t, iZzag & 1048575);
                            zzfrVar.zzd(i, iZzj9);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzds<T>) t, length)) {
                            iZzj10 = zzfd.zzj(t, iZzag & 1048575);
                            zzfrVar.zzn(i, iZzj10);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzds<T>) t, length)) {
                            iZzj11 = zzfd.zzj(t, iZzag & 1048575);
                            zzfrVar.zzm(i, iZzj11);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzds<T>) t, length)) {
                            jZzk9 = zzfd.zzk(t, iZzag & 1048575);
                            zzfrVar.zzj(i, jZzk9);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzds<T>) t, length)) {
                            iZzj12 = zzfd.zzj(t, iZzag & 1048575);
                            zzfrVar.zze(i, iZzj12);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzds<T>) t, length)) {
                            jZzk10 = zzfd.zzk(t, iZzag & 1048575);
                            zzfrVar.zzb(i, jZzk10);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzds<T>) t, length)) {
                            zzfrVar.zzb(i, zzfd.zzo(t, iZzag & 1048575), zzad(length));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzeh.zza(this.zzmi[length], (List<Double>) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 19:
                        zzeh.zzb(this.zzmi[length], (List<Float>) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 20:
                        zzeh.zzc(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 21:
                        zzeh.zzd(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 22:
                        zzeh.zzh(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 23:
                        zzeh.zzf(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 24:
                        zzeh.zzk(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 25:
                        zzeh.zzn(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 26:
                        zzeh.zza(this.zzmi[length], (List<String>) zzfd.zzo(t, iZzag & 1048575), zzfrVar);
                        break;
                    case 27:
                        zzeh.zza(this.zzmi[length], (List<?>) zzfd.zzo(t, iZzag & 1048575), zzfrVar, zzad(length));
                        break;
                    case 28:
                        zzeh.zzb(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar);
                        break;
                    case 29:
                        zzeh.zzi(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 30:
                        zzeh.zzm(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 31:
                        zzeh.zzl(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 32:
                        zzeh.zzg(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 33:
                        zzeh.zzj(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 34:
                        zzeh.zze(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, false);
                        break;
                    case 35:
                        zzeh.zza(this.zzmi[length], (List<Double>) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 36:
                        zzeh.zzb(this.zzmi[length], (List<Float>) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 37:
                        zzeh.zzc(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 38:
                        zzeh.zzd(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 39:
                        zzeh.zzh(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 40:
                        zzeh.zzf(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 41:
                        zzeh.zzk(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 42:
                        zzeh.zzn(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 43:
                        zzeh.zzi(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 44:
                        zzeh.zzm(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 45:
                        zzeh.zzl(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 46:
                        zzeh.zzg(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 47:
                        zzeh.zzj(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 48:
                        zzeh.zze(this.zzmi[length], (List) zzfd.zzo(t, iZzag & 1048575), zzfrVar, true);
                        break;
                    case 49:
                        zzeh.zzb(this.zzmi[length], (List<?>) zzfd.zzo(t, iZzag & 1048575), zzfrVar, zzad(length));
                        break;
                    case 50:
                        zza(zzfrVar, i, zzfd.zzo(t, iZzag & 1048575), length);
                        break;
                    case 51:
                        if (zza((zzds<T>) t, i, length)) {
                            dZzn2 = zze(t, iZzag & 1048575);
                            zzfrVar.zza(i, dZzn2);
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza((zzds<T>) t, i, length)) {
                            fZzm2 = zzf(t, iZzag & 1048575);
                            zzfrVar.zza(i, fZzm2);
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza((zzds<T>) t, i, length)) {
                            jZzk6 = zzh(t, iZzag & 1048575);
                            zzfrVar.zzi(i, jZzk6);
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza((zzds<T>) t, i, length)) {
                            jZzk7 = zzh(t, iZzag & 1048575);
                            zzfrVar.zza(i, jZzk7);
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza((zzds<T>) t, i, length)) {
                            iZzj7 = zzg(t, iZzag & 1048575);
                            zzfrVar.zzc(i, iZzj7);
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza((zzds<T>) t, i, length)) {
                            jZzk8 = zzh(t, iZzag & 1048575);
                            zzfrVar.zzc(i, jZzk8);
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza((zzds<T>) t, i, length)) {
                            iZzj8 = zzg(t, iZzag & 1048575);
                            zzfrVar.zzf(i, iZzj8);
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza((zzds<T>) t, i, length)) {
                            zZzl2 = zzi(t, iZzag & 1048575);
                            zzfrVar.zzb(i, zZzl2);
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (!zza((zzds<T>) t, i, length)) {
                            break;
                        }
                        break;
                    case 60:
                        if (!zza((zzds<T>) t, i, length)) {
                            break;
                        }
                        break;
                    case 61:
                        if (!zza((zzds<T>) t, i, length)) {
                            break;
                        }
                        break;
                    case 62:
                        if (zza((zzds<T>) t, i, length)) {
                            iZzj9 = zzg(t, iZzag & 1048575);
                            zzfrVar.zzd(i, iZzj9);
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza((zzds<T>) t, i, length)) {
                            iZzj10 = zzg(t, iZzag & 1048575);
                            zzfrVar.zzn(i, iZzj10);
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza((zzds<T>) t, i, length)) {
                            iZzj11 = zzg(t, iZzag & 1048575);
                            zzfrVar.zzm(i, iZzj11);
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza((zzds<T>) t, i, length)) {
                            jZzk9 = zzh(t, iZzag & 1048575);
                            zzfrVar.zzj(i, jZzk9);
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza((zzds<T>) t, i, length)) {
                            iZzj12 = zzg(t, iZzag & 1048575);
                            zzfrVar.zze(i, iZzj12);
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza((zzds<T>) t, i, length)) {
                            jZzk10 = zzh(t, iZzag & 1048575);
                            zzfrVar.zzb(i, jZzk10);
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (!zza((zzds<T>) t, i, length)) {
                            break;
                        }
                        break;
                }
            }
            while (entry2 != null) {
                this.zzmy.zza(zzfrVar, entry2);
                entry2 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            return;
        }
        if (!this.zzmq) {
            zzb((zzds<T>) t, zzfrVar);
            return;
        }
        if (this.zzmo) {
            zzby<T> zzbyVarZza2 = this.zzmy.zza(t);
            if (zzbyVarZza2.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = zzbyVarZza2.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length2 = this.zzmi.length;
        for (int i2 = 0; i2 < length2; i2 += 4) {
            int iZzag2 = zzag(i2);
            int i3 = this.zzmi[i2];
            while (entry != null && this.zzmy.zza(entry) <= i3) {
                this.zzmy.zza(zzfrVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            switch ((iZzag2 & 267386880) >>> 20) {
                case 0:
                    if (zza((zzds<T>) t, i2)) {
                        dZzn = zzfd.zzn(t, iZzag2 & 1048575);
                        zzfrVar.zza(i3, dZzn);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzds<T>) t, i2)) {
                        fZzm = zzfd.zzm(t, iZzag2 & 1048575);
                        zzfrVar.zza(i3, fZzm);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((zzds<T>) t, i2)) {
                        jZzk = zzfd.zzk(t, iZzag2 & 1048575);
                        zzfrVar.zzi(i3, jZzk);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((zzds<T>) t, i2)) {
                        jZzk2 = zzfd.zzk(t, iZzag2 & 1048575);
                        zzfrVar.zza(i3, jZzk2);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((zzds<T>) t, i2)) {
                        iZzj = zzfd.zzj(t, iZzag2 & 1048575);
                        zzfrVar.zzc(i3, iZzj);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((zzds<T>) t, i2)) {
                        jZzk3 = zzfd.zzk(t, iZzag2 & 1048575);
                        zzfrVar.zzc(i3, jZzk3);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzds<T>) t, i2)) {
                        iZzj2 = zzfd.zzj(t, iZzag2 & 1048575);
                        zzfrVar.zzf(i3, iZzj2);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zza((zzds<T>) t, i2)) {
                        zZzl = zzfd.zzl(t, iZzag2 & 1048575);
                        zzfrVar.zzb(i3, zZzl);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zza((zzds<T>) t, i2)) {
                        zza(i3, zzfd.zzo(t, iZzag2 & 1048575), zzfrVar);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (zza((zzds<T>) t, i2)) {
                        zzfrVar.zza(i3, zzfd.zzo(t, iZzag2 & 1048575), zzad(i2));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zza((zzds<T>) t, i2)) {
                        zzfrVar.zza(i3, (zzbb) zzfd.zzo(t, iZzag2 & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zza((zzds<T>) t, i2)) {
                        iZzj3 = zzfd.zzj(t, iZzag2 & 1048575);
                        zzfrVar.zzd(i3, iZzj3);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zza((zzds<T>) t, i2)) {
                        iZzj4 = zzfd.zzj(t, iZzag2 & 1048575);
                        zzfrVar.zzn(i3, iZzj4);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zza((zzds<T>) t, i2)) {
                        iZzj5 = zzfd.zzj(t, iZzag2 & 1048575);
                        zzfrVar.zzm(i3, iZzj5);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zza((zzds<T>) t, i2)) {
                        jZzk4 = zzfd.zzk(t, iZzag2 & 1048575);
                        zzfrVar.zzj(i3, jZzk4);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zza((zzds<T>) t, i2)) {
                        iZzj6 = zzfd.zzj(t, iZzag2 & 1048575);
                        zzfrVar.zze(i3, iZzj6);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zza((zzds<T>) t, i2)) {
                        jZzk5 = zzfd.zzk(t, iZzag2 & 1048575);
                        zzfrVar.zzb(i3, jZzk5);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zza((zzds<T>) t, i2)) {
                        zzfrVar.zzb(i3, zzfd.zzo(t, iZzag2 & 1048575), zzad(i2));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzeh.zza(this.zzmi[i2], (List<Double>) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 19:
                    zzeh.zzb(this.zzmi[i2], (List<Float>) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 20:
                    zzeh.zzc(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 21:
                    zzeh.zzd(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 22:
                    zzeh.zzh(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 23:
                    zzeh.zzf(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 24:
                    zzeh.zzk(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 25:
                    zzeh.zzn(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 26:
                    zzeh.zza(this.zzmi[i2], (List<String>) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar);
                    break;
                case 27:
                    zzeh.zza(this.zzmi[i2], (List<?>) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, zzad(i2));
                    break;
                case 28:
                    zzeh.zzb(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar);
                    break;
                case 29:
                    zzeh.zzi(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 30:
                    zzeh.zzm(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 31:
                    zzeh.zzl(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 32:
                    zzeh.zzg(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 33:
                    zzeh.zzj(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 34:
                    zzeh.zze(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, false);
                    break;
                case 35:
                    zzeh.zza(this.zzmi[i2], (List<Double>) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 36:
                    zzeh.zzb(this.zzmi[i2], (List<Float>) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 37:
                    zzeh.zzc(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 38:
                    zzeh.zzd(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 39:
                    zzeh.zzh(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 40:
                    zzeh.zzf(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 41:
                    zzeh.zzk(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 42:
                    zzeh.zzn(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 43:
                    zzeh.zzi(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 44:
                    zzeh.zzm(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 45:
                    zzeh.zzl(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 46:
                    zzeh.zzg(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 47:
                    zzeh.zzj(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 48:
                    zzeh.zze(this.zzmi[i2], (List) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, true);
                    break;
                case 49:
                    zzeh.zzb(this.zzmi[i2], (List<?>) zzfd.zzo(t, iZzag2 & 1048575), zzfrVar, zzad(i2));
                    break;
                case 50:
                    zza(zzfrVar, i3, zzfd.zzo(t, iZzag2 & 1048575), i2);
                    break;
                case 51:
                    if (zza((zzds<T>) t, i3, i2)) {
                        dZzn = zze(t, iZzag2 & 1048575);
                        zzfrVar.zza(i3, dZzn);
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza((zzds<T>) t, i3, i2)) {
                        fZzm = zzf(t, iZzag2 & 1048575);
                        zzfrVar.zza(i3, fZzm);
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza((zzds<T>) t, i3, i2)) {
                        jZzk = zzh(t, iZzag2 & 1048575);
                        zzfrVar.zzi(i3, jZzk);
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza((zzds<T>) t, i3, i2)) {
                        jZzk2 = zzh(t, iZzag2 & 1048575);
                        zzfrVar.zza(i3, jZzk2);
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza((zzds<T>) t, i3, i2)) {
                        iZzj = zzg(t, iZzag2 & 1048575);
                        zzfrVar.zzc(i3, iZzj);
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza((zzds<T>) t, i3, i2)) {
                        jZzk3 = zzh(t, iZzag2 & 1048575);
                        zzfrVar.zzc(i3, jZzk3);
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza((zzds<T>) t, i3, i2)) {
                        iZzj2 = zzg(t, iZzag2 & 1048575);
                        zzfrVar.zzf(i3, iZzj2);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza((zzds<T>) t, i3, i2)) {
                        zZzl = zzi(t, iZzag2 & 1048575);
                        zzfrVar.zzb(i3, zZzl);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zza((zzds<T>) t, i3, i2)) {
                        break;
                    }
                    break;
                case 60:
                    if (!zza((zzds<T>) t, i3, i2)) {
                        break;
                    }
                    break;
                case 61:
                    if (!zza((zzds<T>) t, i3, i2)) {
                        break;
                    }
                    break;
                case 62:
                    if (zza((zzds<T>) t, i3, i2)) {
                        iZzj3 = zzg(t, iZzag2 & 1048575);
                        zzfrVar.zzd(i3, iZzj3);
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza((zzds<T>) t, i3, i2)) {
                        iZzj4 = zzg(t, iZzag2 & 1048575);
                        zzfrVar.zzn(i3, iZzj4);
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza((zzds<T>) t, i3, i2)) {
                        iZzj5 = zzg(t, iZzag2 & 1048575);
                        zzfrVar.zzm(i3, iZzj5);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza((zzds<T>) t, i3, i2)) {
                        jZzk4 = zzh(t, iZzag2 & 1048575);
                        zzfrVar.zzj(i3, jZzk4);
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza((zzds<T>) t, i3, i2)) {
                        iZzj6 = zzg(t, iZzag2 & 1048575);
                        zzfrVar.zze(i3, iZzj6);
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza((zzds<T>) t, i3, i2)) {
                        jZzk5 = zzh(t, iZzag2 & 1048575);
                        zzfrVar.zzb(i3, jZzk5);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (!zza((zzds<T>) t, i3, i2)) {
                        break;
                    }
                    break;
            }
        }
        while (entry != null) {
            this.zzmy.zza(zzfrVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zza(this.zzmx, t, zzfrVar);
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zza(T t, byte[] bArr, int i, int i2, zzay zzayVar) throws IOException {
        Unsafe unsafe;
        zzay zzayVar2;
        T t2;
        int i3;
        int i4;
        byte[] bArr2;
        int i5;
        int i6;
        int iZza;
        Unsafe unsafe2;
        T t3;
        Object objZza;
        T t4;
        int iZzm;
        zzds<T> zzdsVar = this;
        byte[] bArr3 = bArr;
        int i7 = i2;
        zzay zzayVar3 = zzayVar;
        if (!zzdsVar.zzmq) {
            zza((zzds<T>) t, bArr, i, i7, 0, zzayVar);
            return;
        }
        Unsafe unsafe3 = zzmh;
        int iZza2 = i;
        while (iZza2 < i7) {
            int iZza3 = iZza2 + 1;
            int i8 = bArr3[iZza2];
            if (i8 < 0) {
                iZza3 = zzax.zza(i8, bArr3, iZza3, zzayVar3);
                i8 = zzayVar3.zzfd;
            }
            int i9 = i8;
            int i10 = iZza3;
            int i11 = i9 >>> 3;
            int i12 = i9 & 7;
            int iZzai = zzdsVar.zzai(i11);
            if (iZzai >= 0) {
                int i13 = zzdsVar.zzmi[iZzai + 1];
                int i14 = (267386880 & i13) >>> 20;
                long j = 1048575 & i13;
                if (i14 <= 17) {
                    switch (i14) {
                        case 0:
                            unsafe = unsafe3;
                            if (i12 == 1) {
                                zzfd.zza(t, j, zzax.zze(bArr3, i10));
                                iZza2 = i10 + 8;
                                unsafe3 = unsafe;
                                break;
                            }
                            i6 = i10;
                            t2 = t;
                            bArr2 = bArr;
                            i4 = i6;
                            i5 = i9;
                            i3 = i2;
                            zzayVar2 = zzayVar;
                            iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                            zzdsVar = this;
                            bArr3 = bArr;
                            zzayVar3 = zzayVar;
                            i7 = i3;
                            unsafe3 = unsafe;
                        case 1:
                            unsafe = unsafe3;
                            if (i12 == 5) {
                                zzfd.zza((Object) t, j, zzax.zzf(bArr3, i10));
                                iZza2 = i10 + 4;
                                unsafe3 = unsafe;
                                break;
                            }
                            i6 = i10;
                            t2 = t;
                            bArr2 = bArr;
                            i4 = i6;
                            i5 = i9;
                            i3 = i2;
                            zzayVar2 = zzayVar;
                            iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                            zzdsVar = this;
                            bArr3 = bArr;
                            zzayVar3 = zzayVar;
                            i7 = i3;
                            unsafe3 = unsafe;
                        case 2:
                        case 3:
                            Unsafe unsafe4 = unsafe3;
                            if (i12 != 0) {
                                unsafe = unsafe4;
                                i6 = i10;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                                break;
                            } else {
                                int iZzb = zzax.zzb(bArr3, i10, zzayVar3);
                                unsafe3 = unsafe4;
                                unsafe3.putLong(t, j, zzayVar3.zzfe);
                                iZza2 = iZzb;
                                break;
                            }
                        case 4:
                        case 11:
                            unsafe2 = unsafe3;
                            if (i12 != 0) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                                break;
                            } else {
                                iZza2 = zzax.zza(bArr3, i10, zzayVar3);
                                unsafe2.putInt(t, j, zzayVar3.zzfd);
                                unsafe3 = unsafe2;
                                break;
                            }
                        case 5:
                        case 14:
                            unsafe2 = unsafe3;
                            if (i12 != 1) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                                break;
                            } else {
                                unsafe2.putLong(t, j, zzax.zzd(bArr3, i10));
                                iZza2 = i10 + 8;
                                unsafe3 = unsafe2;
                                break;
                            }
                        case 6:
                        case 13:
                            unsafe2 = unsafe3;
                            if (i12 != 5) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                                break;
                            } else {
                                unsafe2.putInt(t, j, zzax.zzc(bArr3, i10));
                                iZza2 = i10 + 4;
                                unsafe3 = unsafe2;
                                break;
                            }
                        case 7:
                            unsafe2 = unsafe3;
                            if (i12 != 0) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                                break;
                            } else {
                                iZza2 = zzax.zzb(bArr3, i10, zzayVar3);
                                zzfd.zza(t, j, zzayVar3.zzfe != 0);
                                unsafe3 = unsafe2;
                                break;
                            }
                        case 8:
                            unsafe2 = unsafe3;
                            t3 = t;
                            if (i12 != 2) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                                break;
                            } else {
                                iZza2 = (536870912 & i13) == 0 ? zzax.zzc(bArr3, i10, zzayVar3) : zzax.zzd(bArr3, i10, zzayVar3);
                                objZza = zzayVar3.zzff;
                                unsafe2.putObject(t3, j, objZza);
                                unsafe3 = unsafe2;
                                break;
                            }
                        case 9:
                            unsafe2 = unsafe3;
                            t3 = t;
                            if (i12 != 2) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                                break;
                            } else {
                                iZza2 = zza(zzdsVar.zzad(iZzai), bArr3, i10, i7, zzayVar3);
                                Object object = unsafe2.getObject(t3, j);
                                objZza = object == null ? zzayVar3.zzff : zzci.zza(object, zzayVar3.zzff);
                                unsafe2.putObject(t3, j, objZza);
                                unsafe3 = unsafe2;
                                break;
                            }
                        case 10:
                            unsafe2 = unsafe3;
                            t3 = t;
                            if (i12 != 2) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                                break;
                            } else {
                                iZza2 = zzax.zze(bArr3, i10, zzayVar3);
                                objZza = zzayVar3.zzff;
                                unsafe2.putObject(t3, j, objZza);
                                unsafe3 = unsafe2;
                                break;
                            }
                        case 12:
                            unsafe2 = unsafe3;
                            t4 = t;
                            if (i12 != 0) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                                break;
                            } else {
                                iZza2 = zzax.zza(bArr3, i10, zzayVar3);
                                iZzm = zzayVar3.zzfd;
                                unsafe2.putInt(t4, j, iZzm);
                                unsafe3 = unsafe2;
                                break;
                            }
                        case 15:
                            unsafe2 = unsafe3;
                            t4 = t;
                            if (i12 != 0) {
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                                break;
                            } else {
                                iZza2 = zzax.zza(bArr3, i10, zzayVar3);
                                iZzm = zzbk.zzm(zzayVar3.zzfd);
                                unsafe2.putInt(t4, j, iZzm);
                                unsafe3 = unsafe2;
                                break;
                            }
                        case 16:
                            if (i12 != 0) {
                                unsafe2 = unsafe3;
                                i6 = i10;
                                unsafe = unsafe2;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                                unsafe3 = unsafe;
                                break;
                            } else {
                                int iZzb2 = zzax.zzb(bArr3, i10, zzayVar3);
                                unsafe3.putLong(t, j, zzbk.zza(zzayVar3.zzfe));
                                unsafe2 = unsafe3;
                                iZza2 = iZzb2;
                                unsafe3 = unsafe2;
                                break;
                            }
                    }
                } else {
                    unsafe = unsafe3;
                    if (i14 != 27) {
                        if (i14 <= 49) {
                            iZza = zzdsVar.zza((zzds<T>) t, bArr, i10, i2, i9, i11, i12, iZzai, i13, i14, j, zzayVar);
                            if (iZza == i10) {
                                t2 = t;
                                bArr2 = bArr;
                                i3 = i2;
                                zzayVar2 = zzayVar;
                                i4 = iZza;
                                i5 = i9;
                                iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                                zzdsVar = this;
                                bArr3 = bArr;
                                zzayVar3 = zzayVar;
                                i7 = i3;
                            }
                        } else {
                            if (i14 != 50) {
                                iZza = zza((zzds<T>) t, bArr, i10, i2, i9, i11, i12, i13, i14, j, iZzai, zzayVar);
                                if (iZza == i10) {
                                    t2 = t;
                                    bArr2 = bArr;
                                    i3 = i2;
                                    i5 = i9;
                                    i4 = iZza;
                                }
                            } else if (i12 == 2) {
                                int iZza4 = zza(t, bArr, i10, i2, iZzai, i11, j, zzayVar);
                                if (iZza4 == i10) {
                                    t2 = t;
                                    bArr2 = bArr;
                                    i3 = i2;
                                    i4 = iZza4;
                                    i5 = i9;
                                } else {
                                    zzdsVar = this;
                                    bArr3 = bArr;
                                    i7 = i2;
                                    zzayVar3 = zzayVar;
                                    iZza2 = iZza4;
                                }
                            } else {
                                i6 = i10;
                                i9 = i9;
                                t2 = t;
                                bArr2 = bArr;
                                i4 = i6;
                                i5 = i9;
                                i3 = i2;
                            }
                            zzayVar2 = zzayVar;
                            iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                            zzdsVar = this;
                            bArr3 = bArr;
                            zzayVar3 = zzayVar;
                            i7 = i3;
                        }
                        zzdsVar = this;
                        bArr3 = bArr;
                        i7 = i2;
                        zzayVar3 = zzayVar;
                        iZza2 = iZza;
                    } else if (i12 == 2) {
                        zzcn zzcnVarZzi = (zzcn) unsafe.getObject(t, j);
                        if (!zzcnVarZzi.zzu()) {
                            int size = zzcnVarZzi.size();
                            zzcnVarZzi = zzcnVarZzi.zzi(size == 0 ? 10 : size << 1);
                            unsafe.putObject(t, j, zzcnVarZzi);
                        }
                        iZza2 = zza((zzef<?>) zzdsVar.zzad(iZzai), i9, bArr3, i10, i7, (zzcn<?>) zzcnVarZzi, zzayVar3);
                        bArr3 = bArr;
                        i7 = i2;
                        zzayVar3 = zzayVar;
                    } else {
                        i9 = i9;
                        i6 = i10;
                        t2 = t;
                        bArr2 = bArr;
                        i4 = i6;
                        i5 = i9;
                        i3 = i2;
                        zzayVar2 = zzayVar;
                        iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
                        zzdsVar = this;
                        bArr3 = bArr;
                        zzayVar3 = zzayVar;
                        i7 = i3;
                    }
                    unsafe3 = unsafe;
                }
            }
            unsafe = unsafe3;
            i6 = i10;
            t2 = t;
            bArr2 = bArr;
            i4 = i6;
            i5 = i9;
            i3 = i2;
            zzayVar2 = zzayVar;
            iZza2 = zza(i5, bArr2, i4, i3, t2, zzayVar2);
            zzdsVar = this;
            bArr3 = bArr;
            zzayVar3 = zzayVar;
            i7 = i3;
            unsafe3 = unsafe;
        }
        if (iZza2 != i7) {
            throw zzco.zzbo();
        }
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zzc(T t) {
        int[] iArr = this.zzmt;
        if (iArr != null) {
            for (int i : iArr) {
                long jZzag = zzag(i) & 1048575;
                Object objZzo = zzfd.zzo(t, jZzag);
                if (objZzo != null) {
                    zzfd.zza(t, jZzag, this.zzmz.zzj(objZzo));
                }
            }
        }
        int[] iArr2 = this.zzmu;
        if (iArr2 != null) {
            for (int i2 : iArr2) {
                this.zzmw.zza(t, i2);
            }
        }
        this.zzmx.zzc(t);
        if (this.zzmo) {
            this.zzmy.zzc(t);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzc(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.zzmi.length; i += 4) {
            int iZzag = zzag(i);
            long j = 1048575 & iZzag;
            int i2 = this.zzmi[i];
            switch ((iZzag & 267386880) >>> 20) {
                case 0:
                    if (zza((zzds<T>) t2, i)) {
                        zzfd.zza(t, j, zzfd.zzn(t2, j));
                        zzb((zzds<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzds<T>) t2, i)) {
                        zzfd.zza((Object) t, j, zzfd.zzm(t2, j));
                        zzb((zzds<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (!zza((zzds<T>) t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb((zzds<T>) t, i);
                    break;
                case 3:
                    if (!zza((zzds<T>) t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb((zzds<T>) t, i);
                    break;
                case 4:
                    if (!zza((zzds<T>) t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb((zzds<T>) t, i);
                    break;
                case 5:
                    if (!zza((zzds<T>) t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb((zzds<T>) t, i);
                    break;
                case 6:
                    if (!zza((zzds<T>) t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb((zzds<T>) t, i);
                    break;
                case 7:
                    if (zza((zzds<T>) t2, i)) {
                        zzfd.zza(t, j, zzfd.zzl(t2, j));
                        zzb((zzds<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zza((zzds<T>) t2, i)) {
                        break;
                    }
                    zzfd.zza(t, j, zzfd.zzo(t2, j));
                    zzb((zzds<T>) t, i);
                    break;
                case 9:
                case 17:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (!zza((zzds<T>) t2, i)) {
                        break;
                    }
                    zzfd.zza(t, j, zzfd.zzo(t2, j));
                    zzb((zzds<T>) t, i);
                    break;
                case 11:
                    if (!zza((zzds<T>) t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb((zzds<T>) t, i);
                    break;
                case 12:
                    if (!zza((zzds<T>) t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb((zzds<T>) t, i);
                    break;
                case 13:
                    if (!zza((zzds<T>) t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb((zzds<T>) t, i);
                    break;
                case 14:
                    if (!zza((zzds<T>) t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb((zzds<T>) t, i);
                    break;
                case 15:
                    if (!zza((zzds<T>) t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb((zzds<T>) t, i);
                    break;
                case 16:
                    if (!zza((zzds<T>) t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb((zzds<T>) t, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzmw.zza(t, t2, j);
                    break;
                case 50:
                    zzeh.zza(this.zzmz, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zza((zzds<T>) t2, i2, i)) {
                        zzfd.zza(t, j, zzfd.zzo(t2, j));
                        zzb((zzds<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                case 68:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zza((zzds<T>) t2, i2, i)) {
                        break;
                    }
                    break;
            }
        }
        if (this.zzmq) {
            return;
        }
        zzeh.zza(this.zzmx, t, t2);
        if (this.zzmo) {
            zzeh.zza(this.zzmy, t, t2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0419, code lost:
    
        if (zza((com.google.android.gms.internal.clearcut.zzds<T>) r21, r15, r5) != false) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0439, code lost:
    
        if (zza((com.google.android.gms.internal.clearcut.zzds<T>) r21, r15, r5) != false) goto L405;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0441, code lost:
    
        if (zza((com.google.android.gms.internal.clearcut.zzds<T>) r21, r15, r5) != false) goto L408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0461, code lost:
    
        if (zza((com.google.android.gms.internal.clearcut.zzds<T>) r21, r15, r5) != false) goto L420;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0469, code lost:
    
        if (zza((com.google.android.gms.internal.clearcut.zzds<T>) r21, r15, r5) != false) goto L424;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0481, code lost:
    
        if (zza((com.google.android.gms.internal.clearcut.zzds<T>) r21, r15, r5) != false) goto L433;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x06b5, code lost:
    
        if ((r12 & r19) != 0) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x06b7, code lost:
    
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, (com.google.android.gms.internal.clearcut.zzdo) r2.getObject(r21, r13), zzad(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x06e2, code lost:
    
        if ((r12 & r19) != 0) goto L405;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x06e4, code lost:
    
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzh(r15, 0L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x06eb, code lost:
    
        if ((r12 & r19) != 0) goto L408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x06ed, code lost:
    
        r8 = com.google.android.gms.internal.clearcut.zzbn.zzk(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x0710, code lost:
    
        if ((r12 & r19) != 0) goto L420;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x0712, code lost:
    
        r4 = r2.getObject(r21, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x071f, code lost:
    
        if ((r12 & r19) != 0) goto L424;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x0721, code lost:
    
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzc(r15, r2.getObject(r21, r13), zzad(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x0746, code lost:
    
        if ((r12 & r19) != 0) goto L433;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x0748, code lost:
    
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, true);
     */
    /* JADX WARN: Removed duplicated region for block: B:142:0x020f A[PHI: r5
      0x020f: PHI (r5v71 int) = 
      (r5v34 int)
      (r5v37 int)
      (r5v40 int)
      (r5v43 int)
      (r5v46 int)
      (r5v49 int)
      (r5v52 int)
      (r5v55 int)
      (r5v58 int)
      (r5v61 int)
      (r5v64 int)
      (r5v67 int)
      (r5v70 int)
      (r5v75 int)
     binds: [B:141:0x020d, B:136:0x01fc, B:131:0x01eb, B:126:0x01da, B:121:0x01c9, B:116:0x01b8, B:111:0x01a7, B:106:0x0195, B:101:0x0183, B:96:0x0171, B:91:0x015f, B:86:0x014d, B:81:0x013b, B:76:0x0129] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x030c A[PHI: r5
      0x030c: PHI (r5v94 java.lang.Object) = (r5v12 java.lang.Object), (r5v92 java.lang.Object), (r5v96 java.lang.Object) binds: [B:193:0x0333, B:45:0x00ad, B:185:0x0308] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0336 A[PHI: r5
      0x0336: PHI (r5v90 java.lang.Object) = (r5v12 java.lang.Object), (r5v92 java.lang.Object) binds: [B:193:0x0333, B:45:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:373:0x05fd A[PHI: r8
      0x05fd: PHI (r8v69 int) = 
      (r8v32 int)
      (r8v35 int)
      (r8v38 int)
      (r8v41 int)
      (r8v44 int)
      (r8v47 int)
      (r8v50 int)
      (r8v53 int)
      (r8v56 int)
      (r8v59 int)
      (r8v62 int)
      (r8v65 int)
      (r8v68 int)
      (r8v73 int)
     binds: [B:372:0x05fb, B:367:0x05ea, B:362:0x05d9, B:357:0x05c8, B:352:0x05b7, B:347:0x05a6, B:342:0x0595, B:337:0x0583, B:332:0x0571, B:327:0x055f, B:322:0x054d, B:317:0x053b, B:312:0x0529, B:307:0x0517] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0716 A[PHI: r4
      0x0716: PHI (r4v110 java.lang.Object) = (r4v25 java.lang.Object), (r4v106 java.lang.Object), (r4v113 java.lang.Object) binds: [B:428:0x0739, B:276:0x0479, B:420:0x0712] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:430:0x073c A[PHI: r4
      0x073c: PHI (r4v102 java.lang.Object) = (r4v25 java.lang.Object), (r4v106 java.lang.Object) binds: [B:428:0x0739, B:276:0x0479] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzm(T t) {
        int i;
        int i2;
        int iZzd;
        Object object;
        int iZzg;
        int iZzg2;
        int iZzg3;
        long jZzh;
        int iZzw;
        int iZzi;
        int iZzb;
        long jZzk;
        long jZzk2;
        int iZzj;
        Object objZzo;
        int iZzj2;
        int iZzj3;
        int iZzj4;
        long jZzk3;
        int iZzw2;
        int iZzi2;
        int i3 = 267386880;
        if (!this.zzmq) {
            Unsafe unsafe = zzmh;
            int i4 = -1;
            int i5 = 0;
            int iZzb2 = 0;
            int i6 = 0;
            while (i5 < this.zzmi.length) {
                int iZzag = zzag(i5);
                int[] iArr = this.zzmi;
                int i7 = iArr[i5];
                int i8 = (iZzag & 267386880) >>> 20;
                if (i8 <= 17) {
                    i = iArr[i5 + 2];
                    int i9 = i & 1048575;
                    i2 = 1 << (i >>> 20);
                    if (i9 != i4) {
                        i6 = unsafe.getInt(t, i9);
                        i4 = i9;
                    }
                } else {
                    i = (!this.zzmr || i8 < zzcb.DOUBLE_LIST_PACKED.id() || i8 > zzcb.SINT64_LIST_PACKED.id()) ? 0 : this.zzmi[i5 + 2] & 1048575;
                    i2 = 0;
                }
                long j = iZzag & 1048575;
                switch (i8) {
                    case 0:
                        if ((i6 & i2) == 0) {
                            break;
                        } else {
                            iZzb2 += zzbn.zzb(i7, 0.0d);
                            break;
                        }
                    case 1:
                        if ((i6 & i2) != 0) {
                            iZzb2 += zzbn.zzb(i7, 0.0f);
                        }
                        break;
                    case 2:
                        if ((i6 & i2) != 0) {
                            iZzd = zzbn.zzd(i7, unsafe.getLong(t, j));
                            iZzb2 += iZzd;
                        }
                        break;
                    case 3:
                        if ((i6 & i2) != 0) {
                            iZzd = zzbn.zze(i7, unsafe.getLong(t, j));
                            iZzb2 += iZzd;
                        }
                        break;
                    case 4:
                        if ((i6 & i2) != 0) {
                            iZzd = zzbn.zzg(i7, unsafe.getInt(t, j));
                            iZzb2 += iZzd;
                        }
                        break;
                    case 5:
                        if ((i6 & i2) != 0) {
                            iZzd = zzbn.zzg(i7, 0L);
                            iZzb2 += iZzd;
                        }
                        break;
                    case 6:
                        if ((i6 & i2) != 0) {
                            iZzd = zzbn.zzj(i7, 0);
                            iZzb2 += iZzd;
                            break;
                        }
                    case 8:
                        if ((i6 & i2) != 0) {
                            object = unsafe.getObject(t, j);
                            iZzw = object instanceof zzbb ? zzbn.zzc(i7, (zzbb) object) : zzbn.zzb(i7, (String) object);
                            iZzb2 += iZzw;
                        }
                        break;
                    case 11:
                        if ((i6 & i2) != 0) {
                            iZzg = unsafe.getInt(t, j);
                            iZzw = zzbn.zzh(i7, iZzg);
                            iZzb2 += iZzw;
                        }
                        break;
                    case 12:
                        if ((i6 & i2) != 0) {
                            iZzg2 = unsafe.getInt(t, j);
                            iZzw = zzbn.zzl(i7, iZzg2);
                            iZzb2 += iZzw;
                        }
                        break;
                    case 15:
                        if ((i6 & i2) != 0) {
                            iZzg3 = unsafe.getInt(t, j);
                            iZzw = zzbn.zzi(i7, iZzg3);
                            iZzb2 += iZzw;
                        }
                        break;
                    case 16:
                        if ((i6 & i2) != 0) {
                            jZzh = unsafe.getLong(t, j);
                            iZzw = zzbn.zzf(i7, jZzh);
                            iZzb2 += iZzw;
                        }
                        break;
                    case 18:
                    case 23:
                    case 32:
                        iZzw = zzeh.zzw(i7, (List) unsafe.getObject(t, j), false);
                        iZzb2 += iZzw;
                        break;
                    case 19:
                    case 24:
                    case 31:
                        iZzw = zzeh.zzv(i7, (List) unsafe.getObject(t, j), false);
                        iZzb2 += iZzw;
                        break;
                    case 20:
                        iZzw = zzeh.zzo(i7, (List) unsafe.getObject(t, j), false);
                        iZzb2 += iZzw;
                        break;
                    case 21:
                        iZzw = zzeh.zzp(i7, (List) unsafe.getObject(t, j), false);
                        iZzb2 += iZzw;
                        break;
                    case 22:
                        iZzw = zzeh.zzs(i7, (List) unsafe.getObject(t, j), false);
                        iZzb2 += iZzw;
                        break;
                    case 25:
                        iZzw = zzeh.zzx(i7, (List) unsafe.getObject(t, j), false);
                        iZzb2 += iZzw;
                        break;
                    case 26:
                        iZzw = zzeh.zzc(i7, (List) unsafe.getObject(t, j));
                        iZzb2 += iZzw;
                        break;
                    case 27:
                        iZzw = zzeh.zzc(i7, (List<?>) unsafe.getObject(t, j), zzad(i5));
                        iZzb2 += iZzw;
                        break;
                    case 28:
                        iZzw = zzeh.zzd(i7, (List<zzbb>) unsafe.getObject(t, j));
                        iZzb2 += iZzw;
                        break;
                    case 29:
                        iZzw = zzeh.zzt(i7, (List) unsafe.getObject(t, j), false);
                        iZzb2 += iZzw;
                        break;
                    case 30:
                        iZzw = zzeh.zzr(i7, (List) unsafe.getObject(t, j), false);
                        iZzb2 += iZzw;
                        break;
                    case 33:
                        iZzw = zzeh.zzu(i7, (List) unsafe.getObject(t, j), false);
                        iZzb2 += iZzw;
                        break;
                    case 34:
                        iZzw = zzeh.zzq(i7, (List) unsafe.getObject(t, j), false);
                        iZzb2 += iZzw;
                        break;
                    case 35:
                        iZzi = zzeh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                                unsafe.putInt(t, i, iZzi);
                            }
                            iZzw = zzbn.zzr(i7) + zzbn.zzt(iZzi) + iZzi;
                            iZzb2 += iZzw;
                        }
                        break;
                    case 36:
                        iZzi = zzeh.zzh((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzw = zzbn.zzr(i7) + zzbn.zzt(iZzi) + iZzi;
                            iZzb2 += iZzw;
                        }
                        break;
                    case 37:
                        iZzi = zzeh.zza((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzw = zzbn.zzr(i7) + zzbn.zzt(iZzi) + iZzi;
                            iZzb2 += iZzw;
                        }
                        break;
                    case 38:
                        iZzi = zzeh.zzb((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzw = zzbn.zzr(i7) + zzbn.zzt(iZzi) + iZzi;
                            iZzb2 += iZzw;
                        }
                        break;
                    case 39:
                        iZzi = zzeh.zze((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzw = zzbn.zzr(i7) + zzbn.zzt(iZzi) + iZzi;
                            iZzb2 += iZzw;
                        }
                        break;
                    case 40:
                        iZzi = zzeh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzw = zzbn.zzr(i7) + zzbn.zzt(iZzi) + iZzi;
                            iZzb2 += iZzw;
                        }
                        break;
                    case 41:
                        iZzi = zzeh.zzh((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzw = zzbn.zzr(i7) + zzbn.zzt(iZzi) + iZzi;
                            iZzb2 += iZzw;
                        }
                        break;
                    case 42:
                        iZzi = zzeh.zzj((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzw = zzbn.zzr(i7) + zzbn.zzt(iZzi) + iZzi;
                            iZzb2 += iZzw;
                        }
                        break;
                    case 43:
                        iZzi = zzeh.zzf((List<Integer>) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzw = zzbn.zzr(i7) + zzbn.zzt(iZzi) + iZzi;
                            iZzb2 += iZzw;
                        }
                        break;
                    case 44:
                        iZzi = zzeh.zzd((List<Integer>) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzw = zzbn.zzr(i7) + zzbn.zzt(iZzi) + iZzi;
                            iZzb2 += iZzw;
                        }
                        break;
                    case 45:
                        iZzi = zzeh.zzh((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzw = zzbn.zzr(i7) + zzbn.zzt(iZzi) + iZzi;
                            iZzb2 += iZzw;
                        }
                        break;
                    case 46:
                        iZzi = zzeh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzw = zzbn.zzr(i7) + zzbn.zzt(iZzi) + iZzi;
                            iZzb2 += iZzw;
                        }
                        break;
                    case 47:
                        iZzi = zzeh.zzg((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzw = zzbn.zzr(i7) + zzbn.zzt(iZzi) + iZzi;
                            iZzb2 += iZzw;
                        }
                        break;
                    case 48:
                        iZzi = zzeh.zzc((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzmr) {
                            }
                            iZzw = zzbn.zzr(i7) + zzbn.zzt(iZzi) + iZzi;
                            iZzb2 += iZzw;
                        }
                        break;
                    case 49:
                        iZzw = zzeh.zzd(i7, (List) unsafe.getObject(t, j), zzad(i5));
                        iZzb2 += iZzw;
                        break;
                    case 50:
                        iZzw = this.zzmz.zzb(i7, unsafe.getObject(t, j), zzae(i5));
                        iZzb2 += iZzw;
                        break;
                    case 51:
                        if (zza((zzds<T>) t, i7, i5)) {
                            iZzw = zzbn.zzb(i7, 0.0d);
                            iZzb2 += iZzw;
                        }
                        break;
                    case 52:
                        if (zza((zzds<T>) t, i7, i5)) {
                            iZzb = zzbn.zzb(i7, 0.0f);
                            iZzb2 += iZzb;
                        }
                        break;
                    case 53:
                        if (zza((zzds<T>) t, i7, i5)) {
                            iZzw = zzbn.zzd(i7, zzh(t, j));
                            iZzb2 += iZzw;
                        }
                        break;
                    case 54:
                        if (zza((zzds<T>) t, i7, i5)) {
                            iZzw = zzbn.zze(i7, zzh(t, j));
                            iZzb2 += iZzw;
                        }
                        break;
                    case 55:
                        if (zza((zzds<T>) t, i7, i5)) {
                            iZzw = zzbn.zzg(i7, zzg(t, j));
                            iZzb2 += iZzw;
                        }
                        break;
                    case 56:
                        if (zza((zzds<T>) t, i7, i5)) {
                            iZzw = zzbn.zzg(i7, 0L);
                            iZzb2 += iZzw;
                        }
                        break;
                    case 57:
                        if (zza((zzds<T>) t, i7, i5)) {
                            iZzb = zzbn.zzj(i7, 0);
                            iZzb2 += iZzb;
                        }
                        break;
                    case 59:
                        if (zza((zzds<T>) t, i7, i5)) {
                            object = unsafe.getObject(t, j);
                            if (object instanceof zzbb) {
                            }
                            iZzb2 += iZzw;
                        }
                        break;
                    case 62:
                        if (zza((zzds<T>) t, i7, i5)) {
                            iZzg = zzg(t, j);
                            iZzw = zzbn.zzh(i7, iZzg);
                            iZzb2 += iZzw;
                        }
                        break;
                    case 63:
                        if (zza((zzds<T>) t, i7, i5)) {
                            iZzg2 = zzg(t, j);
                            iZzw = zzbn.zzl(i7, iZzg2);
                            iZzb2 += iZzw;
                        }
                        break;
                    case 66:
                        if (zza((zzds<T>) t, i7, i5)) {
                            iZzg3 = zzg(t, j);
                            iZzw = zzbn.zzi(i7, iZzg3);
                            iZzb2 += iZzw;
                        }
                        break;
                    case 67:
                        if (zza((zzds<T>) t, i7, i5)) {
                            jZzh = zzh(t, j);
                            iZzw = zzbn.zzf(i7, jZzh);
                            iZzb2 += iZzw;
                        }
                        break;
                }
                i5 += 4;
            }
            int iZza = iZzb2 + zza(this.zzmx, t);
            return this.zzmo ? iZza + this.zzmy.zza(t).zzas() : iZza;
        }
        Unsafe unsafe2 = zzmh;
        int i10 = 0;
        int i11 = 0;
        while (i10 < this.zzmi.length) {
            int iZzag2 = zzag(i10);
            int i12 = (iZzag2 & i3) >>> 20;
            int i13 = this.zzmi[i10];
            long j2 = iZzag2 & 1048575;
            int i14 = (i12 < zzcb.DOUBLE_LIST_PACKED.id() || i12 > zzcb.SINT64_LIST_PACKED.id()) ? 0 : this.zzmi[i10 + 2] & 1048575;
            switch (i12) {
                case 0:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzb(i13, 0.0d);
                    i11 += iZzw2;
                    break;
                case 1:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzb(i13, 0.0f);
                    i11 += iZzw2;
                    break;
                case 2:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    } else {
                        jZzk = zzfd.zzk(t, j2);
                        iZzw2 = zzbn.zzd(i13, jZzk);
                        i11 += iZzw2;
                        break;
                    }
                case 3:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    } else {
                        jZzk2 = zzfd.zzk(t, j2);
                        iZzw2 = zzbn.zze(i13, jZzk2);
                        i11 += iZzw2;
                        break;
                    }
                case 4:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    } else {
                        iZzj = zzfd.zzj(t, j2);
                        iZzw2 = zzbn.zzg(i13, iZzj);
                        i11 += iZzw2;
                        break;
                    }
                case 5:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzg(i13, 0L);
                    i11 += iZzw2;
                    break;
                case 6:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzj(i13, 0);
                    i11 += iZzw2;
                    break;
                case 7:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzc(i13, true);
                    i11 += iZzw2;
                    break;
                case 8:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    } else {
                        objZzo = zzfd.zzo(t, j2);
                        iZzw2 = objZzo instanceof zzbb ? zzbn.zzc(i13, (zzbb) objZzo) : zzbn.zzb(i13, (String) objZzo);
                        i11 += iZzw2;
                        break;
                    }
                case 9:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    }
                    iZzw2 = zzeh.zzc(i13, zzfd.zzo(t, j2), zzad(i10));
                    i11 += iZzw2;
                    break;
                case 10:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    }
                    objZzo = zzfd.zzo(t, j2);
                    i11 += iZzw2;
                    break;
                case 11:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    } else {
                        iZzj2 = zzfd.zzj(t, j2);
                        iZzw2 = zzbn.zzh(i13, iZzj2);
                        i11 += iZzw2;
                        break;
                    }
                case 12:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    } else {
                        iZzj3 = zzfd.zzj(t, j2);
                        iZzw2 = zzbn.zzl(i13, iZzj3);
                        i11 += iZzw2;
                        break;
                    }
                case 13:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzk(i13, 0);
                    i11 += iZzw2;
                    break;
                case 14:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzh(i13, 0L);
                    i11 += iZzw2;
                    break;
                case 15:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    } else {
                        iZzj4 = zzfd.zzj(t, j2);
                        iZzw2 = zzbn.zzi(i13, iZzj4);
                        i11 += iZzw2;
                        break;
                    }
                case 16:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    } else {
                        jZzk3 = zzfd.zzk(t, j2);
                        iZzw2 = zzbn.zzf(i13, jZzk3);
                        i11 += iZzw2;
                        break;
                    }
                case 17:
                    if (!zza((zzds<T>) t, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzc(i13, (zzdo) zzfd.zzo(t, j2), zzad(i10));
                    i11 += iZzw2;
                    break;
                case 18:
                case 23:
                case 32:
                    iZzw2 = zzeh.zzw(i13, zzd(t, j2), false);
                    i11 += iZzw2;
                    break;
                case 19:
                case 24:
                case 31:
                    iZzw2 = zzeh.zzv(i13, zzd(t, j2), false);
                    i11 += iZzw2;
                    break;
                case 20:
                    iZzw2 = zzeh.zzo(i13, zzd(t, j2), false);
                    i11 += iZzw2;
                    break;
                case 21:
                    iZzw2 = zzeh.zzp(i13, zzd(t, j2), false);
                    i11 += iZzw2;
                    break;
                case 22:
                    iZzw2 = zzeh.zzs(i13, zzd(t, j2), false);
                    i11 += iZzw2;
                    break;
                case 25:
                    iZzw2 = zzeh.zzx(i13, zzd(t, j2), false);
                    i11 += iZzw2;
                    break;
                case 26:
                    iZzw2 = zzeh.zzc(i13, zzd(t, j2));
                    i11 += iZzw2;
                    break;
                case 27:
                    iZzw2 = zzeh.zzc(i13, (List<?>) zzd(t, j2), zzad(i10));
                    i11 += iZzw2;
                    break;
                case 28:
                    iZzw2 = zzeh.zzd(i13, (List<zzbb>) zzd(t, j2));
                    i11 += iZzw2;
                    break;
                case 29:
                    iZzw2 = zzeh.zzt(i13, zzd(t, j2), false);
                    i11 += iZzw2;
                    break;
                case 30:
                    iZzw2 = zzeh.zzr(i13, zzd(t, j2), false);
                    i11 += iZzw2;
                    break;
                case 33:
                    iZzw2 = zzeh.zzu(i13, zzd(t, j2), false);
                    i11 += iZzw2;
                    break;
                case 34:
                    iZzw2 = zzeh.zzq(i13, zzd(t, j2), false);
                    i11 += iZzw2;
                    break;
                case 35:
                    iZzi2 = zzeh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                            unsafe2.putInt(t, i14, iZzi2);
                        }
                        iZzw2 = zzbn.zzr(i13) + zzbn.zzt(iZzi2) + iZzi2;
                        i11 += iZzw2;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    iZzi2 = zzeh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzw2 = zzbn.zzr(i13) + zzbn.zzt(iZzi2) + iZzi2;
                        i11 += iZzw2;
                        break;
                    } else {
                        break;
                    }
                    break;
                case 37:
                    iZzi2 = zzeh.zza((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzw2 = zzbn.zzr(i13) + zzbn.zzt(iZzi2) + iZzi2;
                        i11 += iZzw2;
                        break;
                    } else {
                        break;
                    }
                    break;
                case 38:
                    iZzi2 = zzeh.zzb((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzw2 = zzbn.zzr(i13) + zzbn.zzt(iZzi2) + iZzi2;
                        i11 += iZzw2;
                        break;
                    } else {
                        break;
                    }
                    break;
                case 39:
                    iZzi2 = zzeh.zze((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzw2 = zzbn.zzr(i13) + zzbn.zzt(iZzi2) + iZzi2;
                        i11 += iZzw2;
                        break;
                    } else {
                        break;
                    }
                    break;
                case 40:
                    iZzi2 = zzeh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzw2 = zzbn.zzr(i13) + zzbn.zzt(iZzi2) + iZzi2;
                        i11 += iZzw2;
                        break;
                    } else {
                        break;
                    }
                    break;
                case 41:
                    iZzi2 = zzeh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzw2 = zzbn.zzr(i13) + zzbn.zzt(iZzi2) + iZzi2;
                        i11 += iZzw2;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    iZzi2 = zzeh.zzj((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzw2 = zzbn.zzr(i13) + zzbn.zzt(iZzi2) + iZzi2;
                        i11 += iZzw2;
                        break;
                    } else {
                        break;
                    }
                    break;
                case 43:
                    iZzi2 = zzeh.zzf((List<Integer>) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzw2 = zzbn.zzr(i13) + zzbn.zzt(iZzi2) + iZzi2;
                        i11 += iZzw2;
                        break;
                    } else {
                        break;
                    }
                    break;
                case 44:
                    iZzi2 = zzeh.zzd((List<Integer>) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzw2 = zzbn.zzr(i13) + zzbn.zzt(iZzi2) + iZzi2;
                        i11 += iZzw2;
                        break;
                    } else {
                        break;
                    }
                    break;
                case 45:
                    iZzi2 = zzeh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzw2 = zzbn.zzr(i13) + zzbn.zzt(iZzi2) + iZzi2;
                        i11 += iZzw2;
                        break;
                    } else {
                        break;
                    }
                    break;
                case 46:
                    iZzi2 = zzeh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzw2 = zzbn.zzr(i13) + zzbn.zzt(iZzi2) + iZzi2;
                        i11 += iZzw2;
                        break;
                    } else {
                        break;
                    }
                    break;
                case 47:
                    iZzi2 = zzeh.zzg((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzw2 = zzbn.zzr(i13) + zzbn.zzt(iZzi2) + iZzi2;
                        i11 += iZzw2;
                        break;
                    } else {
                        break;
                    }
                    break;
                case 48:
                    iZzi2 = zzeh.zzc((List) unsafe2.getObject(t, j2));
                    if (iZzi2 > 0) {
                        if (this.zzmr) {
                        }
                        iZzw2 = zzbn.zzr(i13) + zzbn.zzt(iZzi2) + iZzi2;
                        i11 += iZzw2;
                        break;
                    } else {
                        break;
                    }
                    break;
                case 49:
                    iZzw2 = zzeh.zzd(i13, zzd(t, j2), zzad(i10));
                    i11 += iZzw2;
                    break;
                case 50:
                    iZzw2 = this.zzmz.zzb(i13, zzfd.zzo(t, j2), zzae(i10));
                    i11 += iZzw2;
                    break;
                case 51:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzb(i13, 0.0d);
                    i11 += iZzw2;
                    break;
                case 52:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzb(i13, 0.0f);
                    i11 += iZzw2;
                    break;
                case 53:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    } else {
                        jZzk = zzh(t, j2);
                        iZzw2 = zzbn.zzd(i13, jZzk);
                        i11 += iZzw2;
                        break;
                    }
                case 54:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    } else {
                        jZzk2 = zzh(t, j2);
                        iZzw2 = zzbn.zze(i13, jZzk2);
                        i11 += iZzw2;
                        break;
                    }
                case 55:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    } else {
                        iZzj = zzg(t, j2);
                        iZzw2 = zzbn.zzg(i13, iZzj);
                        i11 += iZzw2;
                        break;
                    }
                case 56:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzg(i13, 0L);
                    i11 += iZzw2;
                    break;
                case 57:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzj(i13, 0);
                    i11 += iZzw2;
                    break;
                case 58:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzc(i13, true);
                    i11 += iZzw2;
                    break;
                case 59:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    } else {
                        objZzo = zzfd.zzo(t, j2);
                        if (objZzo instanceof zzbb) {
                        }
                        i11 += iZzw2;
                        break;
                    }
                    break;
                case 60:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    }
                    iZzw2 = zzeh.zzc(i13, zzfd.zzo(t, j2), zzad(i10));
                    i11 += iZzw2;
                    break;
                case 61:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    }
                    objZzo = zzfd.zzo(t, j2);
                    i11 += iZzw2;
                    break;
                case 62:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    } else {
                        iZzj2 = zzg(t, j2);
                        iZzw2 = zzbn.zzh(i13, iZzj2);
                        i11 += iZzw2;
                        break;
                    }
                case 63:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    } else {
                        iZzj3 = zzg(t, j2);
                        iZzw2 = zzbn.zzl(i13, iZzj3);
                        i11 += iZzw2;
                        break;
                    }
                case 64:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzk(i13, 0);
                    i11 += iZzw2;
                    break;
                case 65:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzh(i13, 0L);
                    i11 += iZzw2;
                    break;
                case 66:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    } else {
                        iZzj4 = zzg(t, j2);
                        iZzw2 = zzbn.zzi(i13, iZzj4);
                        i11 += iZzw2;
                        break;
                    }
                case 67:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    } else {
                        jZzk3 = zzh(t, j2);
                        iZzw2 = zzbn.zzf(i13, jZzk3);
                        i11 += iZzw2;
                        break;
                    }
                case 68:
                    if (!zza((zzds<T>) t, i13, i10)) {
                        break;
                    }
                    iZzw2 = zzbn.zzc(i13, (zzdo) zzfd.zzo(t, j2), zzad(i10));
                    i11 += iZzw2;
                    break;
            }
            i10 += 4;
            i3 = 267386880;
        }
        return i11 + zza(this.zzmx, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d7  */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22, types: [com.google.android.gms.internal.clearcut.zzef] */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.google.android.gms.internal.clearcut.zzef] */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzo(T t) {
        int i;
        int i2;
        int[] iArr = this.zzms;
        int i3 = 1;
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        int length = iArr.length;
        int i4 = -1;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = iArr[i5];
            int iZzai = zzai(i7);
            int iZzag = zzag(iZzai);
            if (this.zzmq) {
                i = length;
                i2 = 0;
            } else {
                int i8 = this.zzmi[iZzai + 2];
                int i9 = i8 & 1048575;
                i2 = i3 << (i8 >>> 20);
                if (i9 != i4) {
                    i = length;
                    i6 = zzmh.getInt(t, i9);
                    i4 = i9;
                } else {
                    i = length;
                }
            }
            if ((268435456 & iZzag) != 0 && !zza((zzds<T>) t, iZzai, i6, i2)) {
                return false;
            }
            int i10 = (267386880 & iZzag) >>> 20;
            if (i10 == 9 || i10 == 17) {
                if (zza((zzds<T>) t, iZzai, i6, i2) && !zza(t, iZzag, zzad(iZzai))) {
                    return false;
                }
            } else if (i10 == 27) {
                List list = (List) zzfd.zzo(t, iZzag & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    ?? Zzad = zzad(iZzai);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!Zzad.zzo(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (i10 == 60 || i10 == 68) {
                if (zza((zzds<T>) t, i7, iZzai) && !zza(t, iZzag, zzad(iZzai))) {
                    return false;
                }
            } else if (i10 != 49) {
                if (i10 != 50) {
                    continue;
                } else {
                    Map<?, ?> mapZzh = this.zzmz.zzh(zzfd.zzo(t, iZzag & 1048575));
                    if (mapZzh.isEmpty()) {
                        continue;
                    } else if (this.zzmz.zzl(zzae(iZzai)).zzmd.zzek() == zzfq.MESSAGE) {
                        ?? Zze = 0;
                        for (Object obj : mapZzh.values()) {
                            Zze = Zze;
                            if (Zze == 0) {
                                Zze = zzea.zzcm().zze(obj.getClass());
                            }
                            if (!Zze.zzo(obj)) {
                                return false;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
            i5++;
            length = i;
            i3 = 1;
        }
        return !this.zzmo || this.zzmy.zza(t).isInitialized();
    }
}
