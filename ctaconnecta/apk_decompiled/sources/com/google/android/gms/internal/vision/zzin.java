package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzin<T> implements zziw<T> {
    private final zzih zzzn;
    private final boolean zzzo;
    private final zzjo<?, ?> zzzx;
    private final zzgk<?> zzzy;

    private zzin(zzjo<?, ?> zzjoVar, zzgk<?> zzgkVar, zzih zzihVar) {
        this.zzzx = zzjoVar;
        this.zzzo = zzgkVar.zze(zzihVar);
        this.zzzy = zzgkVar;
        this.zzzn = zzihVar;
    }

    static <T> zzin<T> zza(zzjo<?, ?> zzjoVar, zzgk<?> zzgkVar, zzih zzihVar) {
        return new zzin<>(zzjoVar, zzgkVar, zzihVar);
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final T newInstance() {
        return (T) this.zzzn.zzgk().zzgc();
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final boolean equals(T t, T t2) {
        if (!this.zzzx.zzw(t).equals(this.zzzx.zzw(t2))) {
            return false;
        }
        if (this.zzzo) {
            return this.zzzy.zzf(t).equals(this.zzzy.zzf(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final int hashCode(T t) {
        int iHashCode = this.zzzx.zzw(t).hashCode();
        return this.zzzo ? (iHashCode * 53) + this.zzzy.zzf(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final void zzd(T t, T t2) {
        zziy.zza(this.zzzx, t, t2);
        if (this.zzzo) {
            zziy.zza(this.zzzy, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final void zza(T t, zzkl zzklVar) throws IOException {
        Iterator it = this.zzzy.zzf(t).iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzgp zzgpVar = (zzgp) entry.getKey();
            if (zzgpVar.zzfu() != zzki.MESSAGE || zzgpVar.zzfv() || zzgpVar.zzfw()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzhk) {
                zzklVar.zza(zzgpVar.zzah(), (Object) ((zzhk) entry).zzgx().zzdl());
            } else {
                zzklVar.zza(zzgpVar.zzah(), entry.getValue());
            }
        }
        zzjo<?, ?> zzjoVar = this.zzzx;
        zzjoVar.zzc(zzjoVar.zzw(t), zzklVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c2 A[EDGE_INSN: B:61:0x00c2->B:33:0x00c2 BREAK  A[LOOP:1: B:17:0x0069->B:64:0x0069], SYNTHETIC] */
    @Override // com.google.android.gms.internal.vision.zziw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, byte[] bArr, int i, int i2, zzfg zzfgVar) throws IOException {
        int iZza;
        zzgx zzgxVar = (zzgx) t;
        zzjr zzjrVarZzii = zzgxVar.zzws;
        if (zzjrVarZzii == zzjr.zzih()) {
            zzjrVarZzii = zzjr.zzii();
            zzgxVar.zzws = zzjrVarZzii;
        }
        zzjr zzjrVar = zzjrVarZzii;
        zzgn<zzgx.zzd> zzgnVarZzgl = ((zzgx.zze) t).zzgl();
        zzgx.zzg zzgVar = null;
        while (i < i2) {
            int iZza2 = zzfe.zza(bArr, i, zzfgVar);
            int i3 = zzfgVar.zzsd;
            if (i3 == 11) {
                int i4 = i2;
                zzfg zzfgVar2 = zzfgVar;
                int i5 = 0;
                zzfm zzfmVar = null;
                while (true) {
                    if (iZza2 >= i4) {
                        iZza = iZza2;
                        break;
                    }
                    iZza = zzfe.zza(bArr, iZza2, zzfgVar2);
                    int i6 = zzfgVar2.zzsd;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 != 2) {
                        if (i7 == 3) {
                            if (zzgVar != null) {
                                iZza2 = zzfe.zza(zzis.zzhp().zzf(zzgVar.zzxp.getClass()), bArr, iZza, i4, zzfgVar2);
                                zzgnVarZzgl.zza((zzgn<zzgx.zzd>) zzgVar.zzxq, zzfgVar2.zzsf);
                            } else if (i8 == 2) {
                                iZza2 = zzfe.zze(bArr, iZza, zzfgVar2);
                                zzfmVar = (zzfm) zzfgVar2.zzsf;
                            }
                        }
                        if (i6 != 12) {
                            break;
                        } else {
                            iZza2 = zzfe.zza(i6, bArr, iZza, i4, zzfgVar2);
                        }
                    } else if (i8 == 0) {
                        iZza2 = zzfe.zza(bArr, iZza, zzfgVar2);
                        i5 = zzfgVar2.zzsd;
                        zzgVar = (zzgx.zzg) this.zzzy.zza(zzfgVar2.zzcu, this.zzzn, i5);
                    } else if (i6 != 12) {
                    }
                }
                if (zzfmVar != null) {
                    zzjrVar.zzb((i5 << 3) | 2, zzfmVar);
                }
                i = iZza;
                i2 = i4;
                zzfgVar = zzfgVar2;
            } else if ((i3 & 7) == 2) {
                zzgVar = (zzgx.zzg) this.zzzy.zza(zzfgVar.zzcu, this.zzzn, i3 >>> 3);
                if (zzgVar != null) {
                    i = zzfe.zza(zzis.zzhp().zzf(zzgVar.zzxp.getClass()), bArr, iZza2, i2, zzfgVar);
                    zzgnVarZzgl.zza((zzgn<zzgx.zzd>) zzgVar.zzxq, zzfgVar.zzsf);
                } else {
                    i = zzfe.zza(i3, bArr, iZza2, i2, zzjrVar, zzfgVar);
                }
            } else {
                i = zzfe.zza(i3, bArr, iZza2, i2, zzfgVar);
            }
        }
        if (i != i2) {
            throw zzhh.zzgt();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[LOOP:0: B:45:0x000c->B:53:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.vision.zziw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, zzix zzixVar, zzgi zzgiVar) throws IOException {
        boolean zZzdw;
        zzjo<?, ?> zzjoVar = this.zzzx;
        zzgk<?> zzgkVar = this.zzzy;
        Object objZzx = zzjoVar.zzx(t);
        zzgn<T> zzgnVarZzg = zzgkVar.zzg(t);
        while (zzixVar.zzdv() != Integer.MAX_VALUE) {
            try {
                int tag = zzixVar.getTag();
                if (tag != 11) {
                    if ((tag & 7) == 2) {
                        Object objZza = zzgkVar.zza(zzgiVar, this.zzzn, tag >>> 3);
                        if (objZza != null) {
                            zzgkVar.zza(zzixVar, objZza, zzgiVar, zzgnVarZzg);
                        } else {
                            zZzdw = zzjoVar.zza((zzjo<?, ?>) objZzx, zzixVar);
                        }
                    } else {
                        zZzdw = zzixVar.zzdw();
                    }
                    if (zZzdw) {
                        return;
                    }
                } else {
                    Object objZza2 = null;
                    zzfm zzfmVarZzee = null;
                    int iZzef = 0;
                    while (zzixVar.zzdv() != Integer.MAX_VALUE) {
                        int tag2 = zzixVar.getTag();
                        if (tag2 == 16) {
                            iZzef = zzixVar.zzef();
                            objZza2 = zzgkVar.zza(zzgiVar, this.zzzn, iZzef);
                        } else if (tag2 == 26) {
                            if (objZza2 != null) {
                                zzgkVar.zza(zzixVar, objZza2, zzgiVar, zzgnVarZzg);
                            } else {
                                zzfmVarZzee = zzixVar.zzee();
                            }
                        } else if (!zzixVar.zzdw()) {
                            break;
                        }
                    }
                    if (zzixVar.getTag() != 12) {
                        throw zzhh.zzgr();
                    }
                    if (zzfmVarZzee != null) {
                        if (objZza2 != null) {
                            zzgkVar.zza(zzfmVarZzee, objZza2, zzgiVar, zzgnVarZzg);
                        } else {
                            zzjoVar.zza((zzjo<?, ?>) objZzx, iZzef, zzfmVarZzee);
                        }
                    }
                }
                zZzdw = true;
                if (zZzdw) {
                }
            } finally {
                zzjoVar.zzg(t, objZzx);
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final void zzh(T t) {
        this.zzzx.zzh(t);
        this.zzzy.zzh(t);
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final boolean zzu(T t) {
        return this.zzzy.zzf(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final int zzs(T t) {
        zzjo<?, ?> zzjoVar = this.zzzx;
        int iZzy = zzjoVar.zzy(zzjoVar.zzw(t));
        return this.zzzo ? iZzy + this.zzzy.zzf(t).zzfp() : iZzy;
    }
}
