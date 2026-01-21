package com.google.android.libraries.places.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.primitives.SignedBytes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbtu {
    int zzb;
    private final zzbwd zzf;
    private final List zze = new ArrayList();
    zzbtt[] zza = new zzbtt[8];
    int zzc = 0;
    int zzd = 0;
    private int zzg = 4096;
    private int zzh = 4096;

    zzbtu(int i, int i2, zzbws zzbwsVar) {
        this.zzb = r1.length - 1;
        this.zzf = zzbwh.zzb(zzbwsVar);
    }

    private final int zzf(int i) {
        return this.zzb + 1 + i;
    }

    private final int zzg(int i) {
        int i2;
        int i3 = 0;
        if (i > 0) {
            int length = this.zza.length;
            while (true) {
                length--;
                i2 = this.zzb;
                if (length < i2 || i <= 0) {
                    break;
                }
                int i4 = this.zza[length].zzj;
                i -= i4;
                this.zzd -= i4;
                this.zzc--;
                i3++;
            }
            zzbtt[] zzbttVarArr = this.zza;
            int i5 = i2 + 1;
            System.arraycopy(zzbttVarArr, i5, zzbttVarArr, i5 + i3, this.zzc);
            this.zzb += i3;
        }
        return i3;
    }

    private final int zzh() throws IOException {
        return this.zzf.zzc() & 255;
    }

    private final zzbwf zzi(int i) throws IOException {
        if (zzm(i)) {
            return zzbtw.zzb[i].zzh;
        }
        int length = zzbtw.zzb.length;
        int iZzf = zzf(i - 61);
        if (iZzf >= 0) {
            zzbtt[] zzbttVarArr = this.zza;
            if (iZzf < zzbttVarArr.length) {
                return zzbttVarArr[iZzf].zzh;
            }
        }
        throw new IOException("Header index too large " + (i + 1));
    }

    private final void zzj() {
        int i = this.zzh;
        int i2 = this.zzd;
        if (i < i2) {
            if (i == 0) {
                zzk();
            } else {
                zzg(i2 - i);
            }
        }
    }

    private final void zzk() {
        Arrays.fill(this.zza, (Object) null);
        this.zzb = this.zza.length - 1;
        this.zzc = 0;
        this.zzd = 0;
    }

    private final void zzl(int i, zzbtt zzbttVar) {
        this.zze.add(zzbttVar);
        int i2 = zzbttVar.zzj;
        int i3 = this.zzh;
        if (i2 > i3) {
            zzk();
            return;
        }
        zzg((this.zzd + i2) - i3);
        int i4 = this.zzc + 1;
        zzbtt[] zzbttVarArr = this.zza;
        int length = zzbttVarArr.length;
        if (i4 > length) {
            zzbtt[] zzbttVarArr2 = new zzbtt[length + length];
            System.arraycopy(zzbttVarArr, 0, zzbttVarArr2, length, length);
            this.zzb = this.zza.length - 1;
            this.zza = zzbttVarArr2;
        }
        int i5 = this.zzb;
        this.zzb = i5 - 1;
        this.zza[i5] = zzbttVar;
        this.zzc++;
        this.zzd += i2;
    }

    private static final boolean zzm(int i) {
        if (i < 0) {
            return false;
        }
        int length = zzbtw.zzb.length;
        return i <= 60;
    }

    final int zza(int i, int i2) throws IOException {
        int i3 = i & i2;
        if (i3 < i2) {
            return i3;
        }
        int i4 = 0;
        while (true) {
            int iZzh = zzh();
            if ((iZzh & 128) == 0) {
                return i2 + (iZzh << i4);
            }
            i2 += (iZzh & 127) << i4;
            i4 += 7;
        }
    }

    public final List zzb() {
        ArrayList arrayList = new ArrayList(this.zze);
        this.zze.clear();
        return arrayList;
    }

    final zzbwf zzc() throws IOException {
        int iZzh = zzh();
        int i = iZzh & 128;
        long jZza = zza(iZzh, 127);
        if (i != 128) {
            return this.zzf.zzy(jZza);
        }
        zzbwd zzbwdVar = this.zzf;
        zzbud zzbudVarZza = zzbud.zza();
        zzbwl zzbwlVar = (zzbwl) zzbwdVar;
        zzbwlVar.zzD(jZza);
        byte[] bArrZzb = zzbudVarZza.zzb(zzbwlVar.zzb.zzH(jZza));
        zzbwe zzbweVar = zzbwf.zza;
        return zzbwe.zzb(bArrZzb);
    }

    final void zzd(int i) {
        this.zzg = i;
        this.zzh = i;
        zzj();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0079, code lost:
    
        throw new java.io.IOException("Header index too large " + r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zze() throws IOException {
        int iZza;
        while (true) {
            zzbwl zzbwlVar = (zzbwl) this.zzf;
            if (zzbwlVar.zzc) {
                throw new IllegalStateException("closed");
            }
            zzbwb zzbwbVar = zzbwlVar.zzb;
            if (zzbwbVar.zzG() && zzbwlVar.zza.zza(zzbwbVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return;
            }
            byte bZzc = this.zzf.zzc();
            int i = bZzc & 255;
            if (i == 128) {
                throw new IOException("index == 0");
            }
            if ((bZzc & 128) == 128) {
                int iZza2 = zza(i, 127);
                int i2 = iZza2 - 1;
                if (!zzm(i2)) {
                    int length = zzbtw.zzb.length;
                    int iZzf = zzf(iZza2 - 62);
                    if (iZzf < 0) {
                        break;
                    }
                    zzbtt[] zzbttVarArr = this.zza;
                    if (iZzf > zzbttVarArr.length - 1) {
                        break;
                    } else {
                        this.zze.add(zzbttVarArr[iZzf]);
                    }
                } else {
                    this.zze.add(zzbtw.zzb[i2]);
                }
            } else if (i == 64) {
                zzbwf zzbwfVarZzc = zzc();
                zzbtw.zzc(zzbwfVarZzc);
                zzl(-1, new zzbtt(zzbwfVarZzc, zzc()));
            } else if ((bZzc & SignedBytes.MAX_POWER_OF_TWO) == 64) {
                zzl(-1, new zzbtt(zzi(zza(i, 63) - 1), zzc()));
            } else if ((bZzc & 32) == 32) {
                iZza = zza(i, 31);
                this.zzh = iZza;
                if (iZza < 0 || iZza > this.zzg) {
                    break;
                } else {
                    zzj();
                }
            } else if (i == 16 || i == 0) {
                zzbwf zzbwfVarZzc2 = zzc();
                zzbtw.zzc(zzbwfVarZzc2);
                this.zze.add(new zzbtt(zzbwfVarZzc2, zzc()));
            } else {
                this.zze.add(new zzbtt(zzi(zza(i, 15) - 1), zzc()));
            }
        }
        throw new IOException("Invalid dynamic table size update " + iZza);
    }
}
