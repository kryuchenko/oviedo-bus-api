package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjk;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
/* loaded from: classes3.dex */
final class zzkz<T> implements zzll<T> {
    private final zzkt zza;
    private final zzmf<?, ?> zzb;
    private final boolean zzc;
    private final zziz<?> zzd;

    @Override // com.google.android.gms.internal.measurement.zzll
    public final int zza(T t) {
        zzmf<?, ?> zzmfVar = this.zzb;
        int iZzb = zzmfVar.zzb(zzmfVar.zzd(t));
        return this.zzc ? iZzb + this.zzd.zza(t).zza() : iZzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final int zzb(T t) {
        int iHashCode = this.zzb.zzd(t).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zza(t).hashCode() : iHashCode;
    }

    static <T> zzkz<T> zza(zzmf<?, ?> zzmfVar, zziz<?> zzizVar, zzkt zzktVar) {
        return new zzkz<>(zzmfVar, zzizVar, zzktVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final T zza() {
        zzkt zzktVar = this.zza;
        if (zzktVar instanceof zzjk) {
            return (T) ((zzjk) zzktVar).zzcd();
        }
        return (T) zzktVar.zzch().zzaj();
    }

    private zzkz(zzmf<?, ?> zzmfVar, zziz<?> zzizVar, zzkt zzktVar) {
        this.zzb = zzmfVar;
        this.zzc = zzizVar.zza(zzktVar);
        this.zzd = zzizVar;
        this.zza = zzktVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzc(T t) {
        this.zzb.zzf(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zza(T t, T t2) {
        zzln.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzln.zza(this.zzd, t, t2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[LOOP:0: B:45:0x000c->B:53:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, zzli zzliVar, zzix zzixVar) throws IOException {
        boolean zZzt;
        zzmf<?, ?> zzmfVar = this.zzb;
        zziz<?> zzizVar = this.zzd;
        Object objZzc = zzmfVar.zzc(t);
        zzjd<T> zzjdVarZzb = zzizVar.zzb(t);
        while (zzliVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzliVar.zzd();
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        Object objZza = zzizVar.zza(zzixVar, this.zza, iZzd >>> 3);
                        if (objZza != null) {
                            zzizVar.zza(zzliVar, objZza, zzixVar, zzjdVarZzb);
                        } else {
                            zZzt = zzmfVar.zza((zzmf<?, ?>) objZzc, zzliVar);
                        }
                    } else {
                        zZzt = zzliVar.zzt();
                    }
                    if (zZzt) {
                        return;
                    }
                } else {
                    Object objZza2 = null;
                    zzia zziaVarZzp = null;
                    int iZzj = 0;
                    while (zzliVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzliVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzliVar.zzj();
                            objZza2 = zzizVar.zza(zzixVar, this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (objZza2 != null) {
                                zzizVar.zza(zzliVar, objZza2, zzixVar, zzjdVarZzb);
                            } else {
                                zziaVarZzp = zzliVar.zzp();
                            }
                        } else if (!zzliVar.zzt()) {
                            break;
                        }
                    }
                    if (zzliVar.zzd() != 12) {
                        throw zzjs.zzb();
                    }
                    if (zziaVarZzp != null) {
                        if (objZza2 != null) {
                            zzizVar.zza(zziaVarZzp, objZza2, zzixVar, zzjdVarZzb);
                        } else {
                            zzmfVar.zza((zzmf<?, ?>) objZzc, iZzj, zziaVarZzp);
                        }
                    }
                }
                zZzt = true;
                if (zZzt) {
                }
            } finally {
                zzmfVar.zzb((Object) t, (T) objZzc);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
    
        if (r12 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a3, code lost:
    
        r6.zza((r11 << 3) | 2, r12);
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
    @Override // com.google.android.gms.internal.measurement.zzll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, byte[] bArr, int i, int i2, zzhv zzhvVar) throws IOException {
        int iZzc;
        zzjk zzjkVar = (zzjk) t;
        zzme zzmeVarZzd = zzjkVar.zzb;
        if (zzmeVarZzd == zzme.zzc()) {
            zzmeVarZzd = zzme.zzd();
            zzjkVar.zzb = zzmeVarZzd;
        }
        zzme zzmeVar = zzmeVarZzd;
        ((zzjk.zzd) t).zza();
        zzjk.zzf zzfVar = null;
        while (i < i2) {
            int iZzc2 = zzhw.zzc(bArr, i, zzhvVar);
            int i3 = zzhvVar.zza;
            if (i3 == 11) {
                byte[] bArr2 = bArr;
                int i4 = i2;
                zzhv zzhvVar2 = zzhvVar;
                int i5 = 0;
                zzia zziaVar = null;
                while (true) {
                    if (iZzc2 >= i4) {
                        iZzc = iZzc2;
                        break;
                    }
                    iZzc = zzhw.zzc(bArr2, iZzc2, zzhvVar2);
                    int i6 = zzhvVar2.zza;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 != 2) {
                        if (i7 == 3) {
                            if (zzfVar != null) {
                                zzlh.zza();
                                throw new NoSuchMethodError();
                            }
                            if (i8 == 2) {
                                iZzc2 = zzhw.zza(bArr2, iZzc, zzhvVar2);
                                zziaVar = (zzia) zzhvVar2.zzc;
                            }
                        }
                        if (i6 != 12) {
                            break;
                        } else {
                            iZzc2 = zzhw.zza(i6, bArr2, iZzc, i4, zzhvVar2);
                        }
                    } else if (i8 == 0) {
                        iZzc2 = zzhw.zzc(bArr2, iZzc, zzhvVar2);
                        i5 = zzhvVar2.zza;
                        zzfVar = (zzjk.zzf) this.zzd.zza(zzhvVar2.zzd, this.zza, i5);
                    } else if (i6 != 12) {
                    }
                }
            } else if ((i3 & 7) == 2) {
                zzfVar = (zzjk.zzf) this.zzd.zza(zzhvVar.zzd, this.zza, i3 >>> 3);
                if (zzfVar != null) {
                    zzlh.zza();
                    throw new NoSuchMethodError();
                }
                i = zzhw.zza(i3, bArr, iZzc2, i2, zzmeVar, zzhvVar);
            } else {
                i = zzhw.zza(i3, bArr, iZzc2, i2, zzhvVar);
            }
        }
        if (i != i2) {
            throw zzjs.zzg();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zza(T t, zzna zznaVar) throws IOException {
        Iterator itZzd = this.zzd.zza(t).zzd();
        while (itZzd.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzd.next();
            zzjf zzjfVar = (zzjf) entry.getKey();
            if (zzjfVar.zzc() != zzmx.MESSAGE || zzjfVar.zze() || zzjfVar.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzjw) {
                zznaVar.zza(zzjfVar.zza(), (Object) ((zzjw) entry).zza().zzb());
            } else {
                zznaVar.zza(zzjfVar.zza(), entry.getValue());
            }
        }
        zzmf<?, ?> zzmfVar = this.zzb;
        zzmfVar.zza((zzmf<?, ?>) zzmfVar.zzd(t), zznaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzd(t).equals(this.zzb.zzd(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t).equals(this.zzd.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final boolean zzd(T t) {
        return this.zzd.zza(t).zzg();
    }
}
