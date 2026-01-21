package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzlw<T> implements zzmf<T> {
    private final zzlq zzuh;
    private final boolean zzui;
    private final zzmx<?, ?> zzur;
    private final zzjy<?> zzus;

    private zzlw(zzmx<?, ?> zzmxVar, zzjy<?> zzjyVar, zzlq zzlqVar) {
        this.zzur = zzmxVar;
        this.zzui = zzjyVar.zze(zzlqVar);
        this.zzus = zzjyVar;
        this.zzuh = zzlqVar;
    }

    static <T> zzlw<T> zza(zzmx<?, ?> zzmxVar, zzjy<?> zzjyVar, zzlq zzlqVar) {
        return new zzlw<>(zzmxVar, zzjyVar, zzlqVar);
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final T newInstance() {
        return (T) this.zzuh.zzcz().zzde();
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final boolean equals(T t, T t2) {
        if (!this.zzur.zzr(t).equals(this.zzur.zzr(t2))) {
            return false;
        }
        if (this.zzui) {
            return this.zzus.zzb(t).equals(this.zzus.zzb(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final int hashCode(T t) {
        int iHashCode = this.zzur.zzr(t).hashCode();
        return this.zzui ? (iHashCode * 53) + this.zzus.zzb(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final void zzc(T t, T t2) {
        zzmh.zza(this.zzur, t, t2);
        if (this.zzui) {
            zzmh.zza(this.zzus, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final void zza(T t, zzns zznsVar) throws IOException {
        Iterator it = this.zzus.zzb(t).iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzkd zzkdVar = (zzkd) entry.getKey();
            if (zzkdVar.zzcr() != zznr.MESSAGE || zzkdVar.zzcs() || zzkdVar.zzct()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzkv) {
                zznsVar.zza(zzkdVar.zzcp(), (Object) ((zzkv) entry).zzdq().zzbl());
            } else {
                zznsVar.zza(zzkdVar.zzcp(), entry.getValue());
            }
        }
        zzmx<?, ?> zzmxVar = this.zzur;
        zzmxVar.zzc(zzmxVar.zzr(t), zznsVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
    
        if (r12 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a3, code lost:
    
        r6.zzb((r11 << 3) | 2, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a9, code lost:
    
        r12 = r13;
        r11 = r3;
        r13 = r5;
        r14 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1 A[EDGE_INSN: B:58:0x00a1->B:35:0x00a1 BREAK  A[LOOP:1: B:18:0x0059->B:63:0x0059], SYNTHETIC] */
    @Override // com.google.android.gms.internal.drive.zzmf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, byte[] bArr, int i, int i2, zziz zzizVar) throws IOException {
        int iZza;
        zzkk zzkkVar = (zzkk) t;
        zzmy zzmyVarZzfb = zzkkVar.zzrq;
        if (zzmyVarZzfb == zzmy.zzfa()) {
            zzmyVarZzfb = zzmy.zzfb();
            zzkkVar.zzrq = zzmyVarZzfb;
        }
        zzmy zzmyVar = zzmyVarZzfb;
        ((zzkk.zzc) t).zzdg();
        zzkk.zzd zzdVar = null;
        while (i < i2) {
            int iZza2 = zziy.zza(bArr, i, zzizVar);
            int i3 = zzizVar.zznk;
            if (i3 == 11) {
                byte[] bArr2 = bArr;
                int i4 = i2;
                zziz zzizVar2 = zzizVar;
                int i5 = 0;
                zzjc zzjcVar = null;
                while (true) {
                    if (iZza2 >= i4) {
                        iZza = iZza2;
                        break;
                    }
                    iZza = zziy.zza(bArr2, iZza2, zzizVar2);
                    int i6 = zzizVar2.zznk;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 != 2) {
                        if (i7 == 3) {
                            if (zzdVar != null) {
                                zzmd.zzej();
                                throw new NoSuchMethodError();
                            }
                            if (i8 == 2) {
                                iZza2 = zziy.zze(bArr2, iZza, zzizVar2);
                                zzjcVar = (zzjc) zzizVar2.zznm;
                            }
                        }
                        if (i6 != 12) {
                            break;
                        } else {
                            iZza2 = zziy.zza(i6, bArr2, iZza, i4, zzizVar2);
                        }
                    } else if (i8 == 0) {
                        iZza2 = zziy.zza(bArr2, iZza, zzizVar2);
                        i5 = zzizVar2.zznk;
                        zzdVar = (zzkk.zzd) this.zzus.zza(zzizVar2.zznn, this.zzuh, i5);
                    } else if (i6 != 12) {
                    }
                }
            } else if ((i3 & 7) == 2) {
                zzdVar = (zzkk.zzd) this.zzus.zza(zzizVar.zznn, this.zzuh, i3 >>> 3);
                if (zzdVar != null) {
                    zzmd.zzej();
                    throw new NoSuchMethodError();
                }
                i = zziy.zza(i3, bArr, iZza2, i2, zzmyVar, zzizVar);
            } else {
                i = zziy.zza(i3, bArr, iZza2, i2, zzizVar);
            }
        }
        if (i != i2) {
            throw zzkq.zzdm();
        }
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final void zzd(T t) {
        this.zzur.zzd(t);
        this.zzus.zzd(t);
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final boolean zzp(T t) {
        return this.zzus.zzb(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final int zzn(T t) {
        zzmx<?, ?> zzmxVar = this.zzur;
        int iZzs = zzmxVar.zzs(zzmxVar.zzr(t));
        return this.zzui ? iZzs + this.zzus.zzb(t).zzco() : iZzs;
    }
}
