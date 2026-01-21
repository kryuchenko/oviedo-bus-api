package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzdu<T> implements zzef<T> {
    private final zzdo zzmn;
    private final boolean zzmo;
    private final zzex<?, ?> zzmx;
    private final zzbu<?> zzmy;

    private zzdu(zzex<?, ?> zzexVar, zzbu<?> zzbuVar, zzdo zzdoVar) {
        this.zzmx = zzexVar;
        this.zzmo = zzbuVar.zze(zzdoVar);
        this.zzmy = zzbuVar;
        this.zzmn = zzdoVar;
    }

    static <T> zzdu<T> zza(zzex<?, ?> zzexVar, zzbu<?> zzbuVar, zzdo zzdoVar) {
        return new zzdu<>(zzexVar, zzbuVar, zzdoVar);
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final boolean equals(T t, T t2) {
        if (!this.zzmx.zzq(t).equals(this.zzmx.zzq(t2))) {
            return false;
        }
        if (this.zzmo) {
            return this.zzmy.zza(t).equals(this.zzmy.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final int hashCode(T t) {
        int iHashCode = this.zzmx.zzq(t).hashCode();
        return this.zzmo ? (iHashCode * 53) + this.zzmy.zza(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final T newInstance() {
        return (T) this.zzmn.zzbd().zzbi();
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zza(T t, zzfr zzfrVar) throws IOException {
        Iterator it = this.zzmy.zza(t).iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzca zzcaVar = (zzca) entry.getKey();
            if (zzcaVar.zzav() != zzfq.MESSAGE || zzcaVar.zzaw() || zzcaVar.zzax()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzfrVar.zza(zzcaVar.zzc(), entry instanceof zzct ? ((zzct) entry).zzbs().zzr() : entry.getValue());
        }
        zzex<?, ?> zzexVar = this.zzmx;
        zzexVar.zzc(zzexVar.zzq(t), zzfrVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0064 A[EDGE_INSN: B:51:0x0064->B:28:0x0064 BREAK  A[LOOP:1: B:14:0x0034->B:54:0x0034], SYNTHETIC] */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, byte[] bArr, int i, int i2, zzay zzayVar) throws IOException {
        int iZza;
        zzcg zzcgVar = (zzcg) t;
        zzey zzeyVarZzeb = zzcgVar.zzjp;
        if (zzeyVarZzeb == zzey.zzea()) {
            zzeyVarZzeb = zzey.zzeb();
            zzcgVar.zzjp = zzeyVarZzeb;
        }
        zzey zzeyVar = zzeyVarZzeb;
        while (i < i2) {
            int iZza2 = zzax.zza(bArr, i, zzayVar);
            int i3 = zzayVar.zzfd;
            if (i3 != 11) {
                byte[] bArr2 = bArr;
                int i4 = i2;
                zzay zzayVar2 = zzayVar;
                i = (i3 & 7) == 2 ? zzax.zza(i3, bArr2, iZza2, i4, zzeyVar, zzayVar2) : zzax.zza(i3, bArr2, iZza2, i4, zzayVar2);
            } else {
                byte[] bArr3 = bArr;
                int i5 = i2;
                zzay zzayVar3 = zzayVar;
                int i6 = 0;
                zzbb zzbbVar = null;
                while (true) {
                    if (iZza2 >= i5) {
                        iZza = iZza2;
                        break;
                    }
                    iZza = zzax.zza(bArr3, iZza2, zzayVar3);
                    int i7 = zzayVar3.zzfd;
                    int i8 = i7 >>> 3;
                    int i9 = i7 & 7;
                    if (i8 != 2) {
                        if (i8 != 3 || i9 != 2) {
                            if (i7 != 12) {
                                break;
                            } else {
                                iZza2 = zzax.zza(i7, bArr3, iZza, i5, zzayVar3);
                            }
                        } else {
                            iZza2 = zzax.zze(bArr3, iZza, zzayVar3);
                            zzbbVar = (zzbb) zzayVar3.zzff;
                        }
                    } else if (i9 == 0) {
                        iZza2 = zzax.zza(bArr3, iZza, zzayVar3);
                        i6 = zzayVar3.zzfd;
                    } else if (i7 != 12) {
                    }
                }
                if (zzbbVar != null) {
                    zzeyVar.zzb((i6 << 3) | 2, zzbbVar);
                }
                i = iZza;
                bArr = bArr3;
                i2 = i5;
                zzayVar = zzayVar3;
            }
        }
        if (i != i2) {
            throw zzco.zzbo();
        }
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zzc(T t) {
        this.zzmx.zzc(t);
        this.zzmy.zzc(t);
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zzc(T t, T t2) {
        zzeh.zza(this.zzmx, t, t2);
        if (this.zzmo) {
            zzeh.zza(this.zzmy, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final int zzm(T t) {
        zzex<?, ?> zzexVar = this.zzmx;
        int iZzr = zzexVar.zzr(zzexVar.zzq(t));
        return this.zzmo ? iZzr + this.zzmy.zza(t).zzat() : iZzr;
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final boolean zzo(T t) {
        return this.zzmy.zza(t).isInitialized();
    }
}
