package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbse implements Runnable, zzbtq {
    final zzbtr zza;
    final /* synthetic */ zzbsf zzc;
    private final zzbsi zzd = new zzbsi(Level.FINE, zzbsf.class);
    boolean zzb = true;

    zzbse(zzbsf zzbsfVar, zzbtr zzbtrVar) {
        this.zzc = zzbsfVar;
        this.zza = zzbtrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdo zzbdoVarZzg;
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("OkHttpClientTransport");
        while (this.zza.zza(this)) {
            try {
                zzbsf zzbsfVar = this.zzc;
                if (zzbsfVar.zzK != null) {
                    zzbsfVar.zzK.zza();
                }
            } catch (Throwable th) {
                try {
                    this.zzc.zzaa(0, zzbtp.PROTOCOL_ERROR, zzbdo.zzo.zzg("error in frame handler").zzf(th));
                } catch (Throwable th2) {
                    try {
                        this.zza.close();
                    } catch (IOException e) {
                        zzbsf.zzd.logp(Level.INFO, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "run", "Exception closing frame reader", (Throwable) e);
                    } catch (RuntimeException e2) {
                        if (!"bio == null".equals(e2.getMessage())) {
                            throw e2;
                        }
                    }
                    this.zzc.zzl.zze();
                    Thread.currentThread().setName(name);
                    throw th2;
                }
            }
        }
        synchronized (this.zzc.zzo) {
            zzbdoVarZzg = this.zzc.zzz;
        }
        if (zzbdoVarZzg == null) {
            zzbdoVarZzg = zzbdo.zzp.zzg("End of stream or IOException");
        }
        this.zzc.zzaa(0, zzbtp.INTERNAL_ERROR, zzbdoVarZzg);
        try {
            this.zza.close();
        } catch (IOException e3) {
            zzbsf.zzd.logp(Level.INFO, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "run", "Exception closing frame reader", (Throwable) e3);
        } catch (RuntimeException e4) {
            if (!"bio == null".equals(e4.getMessage())) {
                throw e4;
            }
        }
        this.zzc.zzl.zze();
        Thread.currentThread().setName(name);
    }

    @Override // com.google.android.libraries.places.internal.zzbtq
    public final void zza(boolean z, int i, zzbwd zzbwdVar, int i2, int i3) throws IOException {
        zzbwl zzbwlVar = (zzbwl) zzbwdVar;
        this.zzd.zza(1, i, zzbwlVar.zzb, i2, z);
        zzbry zzbryVarZzr = this.zzc.zzr(i);
        if (zzbryVarZzr != null) {
            long j = i2;
            zzbwdVar.zzD(j);
            zzbwb zzbwbVar = new zzbwb();
            zzbwbVar.zzn(zzbwlVar.zzb, j);
            zzbryVarZzr.zzD().zzI();
            int i4 = zzbvr.zza;
            synchronized (this.zzc.zzo) {
                zzbryVarZzr.zzD().zzO(zzbwbVar, z, i3 - i2);
            }
        } else {
            if (!this.zzc.zzU(i)) {
                zzbsf zzbsfVar = this.zzc;
                zzbtp zzbtpVar = zzbtp.PROTOCOL_ERROR;
                zzbsfVar.zzaa(0, zzbtpVar, zzbsf.zzm(zzbtpVar).zzc("Received data for unknown stream: " + i));
                return;
            }
            synchronized (this.zzc.zzo) {
                this.zzc.zzm.zzc(i, zzbtp.STREAM_CLOSED);
            }
            zzbwdVar.zzF(i2);
        }
        this.zzc.zzw += i3;
        zzbsf zzbsfVar2 = this.zzc;
        if (zzbsfVar2.zzw >= zzbsfVar2.zzj * 0.5f) {
            synchronized (zzbsfVar2.zzo) {
                this.zzc.zzm.zzk(0, r9.zzw);
            }
            this.zzc.zzw = 0;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbtq
    public final void zzb(int i, zzbtp zzbtpVar, zzbwf zzbwfVar) {
        this.zzd.zzb(1, i, zzbtpVar, zzbwfVar);
        if (zzbtpVar == zzbtp.ENHANCE_YOUR_CALM) {
            String strZzf = zzbwfVar.zzf();
            zzbsf.zzd.logp(Level.WARNING, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "goAway", String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, strZzf));
            if ("too_many_pings".equals(strZzf)) {
                ((zzbrs) this.zzc.zzL).zza.zza();
            }
        }
        zzbdo zzbdoVarZzc = zzbjb.zza(zzbtpVar.zzs).zzc("Received Goaway");
        if (zzbwfVar.zzc() > 0) {
            zzbdoVarZzc = zzbdoVarZzc.zzc(zzbwfVar.zzf());
        }
        this.zzc.zzaa(i, null, zzbdoVarZzc);
    }

    @Override // com.google.android.libraries.places.internal.zzbtq
    public final void zzc(boolean z, int i, int i2) {
        zzbjh zzbjhVar;
        long j = (i << 32) | (i2 & 4294967295L);
        this.zzd.zzd(1, j);
        if (!z) {
            synchronized (this.zzc.zzo) {
                this.zzc.zzm.zzb(true, i, i2);
            }
            return;
        }
        synchronized (this.zzc.zzo) {
            zzbsf zzbsfVar = this.zzc;
            zzbjhVar = null;
            if (zzbsfVar.zzB == null) {
                zzbsf.zzd.logp(Level.WARNING, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "ping", "Received unexpected ping ack. No ping outstanding");
            } else if (zzbsfVar.zzB.zza() == j) {
                zzbsf zzbsfVar2 = this.zzc;
                zzbjh zzbjhVar2 = zzbsfVar2.zzB;
                zzbsfVar2.zzB = null;
                zzbjhVar = zzbjhVar2;
            } else {
                zzbsf.zzd.logp(Level.WARNING, "io.grpc.okhttp.OkHttpClientTransport$ClientFrameHandler", "ping", String.format(Locale.US, "Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(this.zzc.zzB.zza()), Long.valueOf(j)));
            }
        }
        if (zzbjhVar != null) {
            zzbjhVar.zzc();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbtq
    public final void zzd(int i, int i2, List list) throws IOException {
        this.zzd.zzf(1, i, i2, list);
        synchronized (this.zzc.zzo) {
            this.zzc.zzm.zzc(i, zzbtp.PROTOCOL_ERROR);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbtq
    public final void zze(int i, zzbtp zzbtpVar) {
        this.zzd.zzg(1, i, zzbtpVar);
        zzbdo zzbdoVarZzc = zzbsf.zzm(zzbtpVar).zzc("Rst Stream");
        boolean z = zzbdoVarZzc.zza() == zzbdj.CANCELLED || zzbdoVarZzc.zza() == zzbdj.DEADLINE_EXCEEDED;
        synchronized (this.zzc.zzo) {
            zzbry zzbryVar = (zzbry) this.zzc.zzr.get(Integer.valueOf(i));
            if (zzbryVar != null) {
                zzbryVar.zzD().zzI();
                int i2 = zzbvr.zza;
                this.zzc.zzP(i, zzbdoVarZzc, zzbtpVar == zzbtp.REFUSED_STREAM ? zzbfs.REFUSED : zzbfs.PROCESSED, z, null, null);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbtq
    public final void zzf(boolean z, zzbue zzbueVar) {
        boolean zZzh;
        this.zzd.zzh(1, zzbueVar);
        synchronized (this.zzc.zzo) {
            if (zzbueVar.zzf(4)) {
                this.zzc.zzH = zzbueVar.zza(4);
            }
            if (zzbueVar.zzf(7)) {
                zZzh = this.zzc.zzn.zzh(zzbueVar.zza(7));
            } else {
                zZzh = false;
            }
            if (this.zzb) {
                zzbsf zzbsfVar = this.zzc;
                zzbmk zzbmkVar = zzbsfVar.zzl;
                zzaye zzayeVar = zzbsfVar.zzy;
                zzbmkVar.zza(zzayeVar);
                zzbsfVar.zzy = zzayeVar;
                this.zzc.zzl.zzc();
                this.zzb = false;
            }
            this.zzc.zzm.zza(zzbueVar);
            if (zZzh) {
                this.zzc.zzn.zzg();
            }
            this.zzc.zzad();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.libraries.places.internal.zzbtq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzg(int i, long j) {
        boolean z = true;
        this.zzd.zzj(1, i, j);
        synchronized (this.zzc.zzo) {
            if (i == 0) {
                this.zzc.zzn.zza(null, (int) j);
                return;
            }
            zzbry zzbryVar = (zzbry) this.zzc.zzr.get(Integer.valueOf(i));
            if (zzbryVar == null) {
                if (!this.zzc.zzU(i)) {
                }
                if (z) {
                    return;
                }
                zzbsf zzbsfVar = this.zzc;
                zzbtp zzbtpVar = zzbtp.PROTOCOL_ERROR;
                zzbsfVar.zzaa(0, zzbtpVar, zzbsf.zzm(zzbtpVar).zzc("Received window_update for unknown stream: " + i));
                return;
            }
            this.zzc.zzn.zza(zzbryVar.zzD().zzH(), (int) j);
            z = false;
            if (z) {
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbtq
    public final void zzh(boolean z, boolean z2, int i, int i2, List list, int i3) {
        boolean z3 = true;
        this.zzd.zzc(1, i, list, z2);
        zzbdo zzbdoVarZzg = null;
        if (this.zzc.zzM != Integer.MAX_VALUE) {
            long jZzc = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                zzbtt zzbttVar = (zzbtt) list.get(i4);
                jZzc += zzbttVar.zzh.zzc() + 32 + zzbttVar.zzi.zzc();
            }
            int iMin = (int) Math.min(jZzc, 2147483647L);
            if (iMin > this.zzc.zzM) {
                zzbdoVarZzg = zzbdo.zzj.zzg(String.format(Locale.US, "Response %s metadata larger than %d: %d", true != z2 ? "header" : "trailer", Integer.valueOf(this.zzc.zzM), Integer.valueOf(iMin)));
            }
        }
        synchronized (this.zzc.zzo) {
            zzbry zzbryVar = (zzbry) this.zzc.zzr.get(Integer.valueOf(i));
            if (zzbryVar == null) {
                if (this.zzc.zzU(i)) {
                    this.zzc.zzm.zzc(i, zzbtp.STREAM_CLOSED);
                }
            } else if (zzbdoVarZzg == null) {
                zzbryVar.zzD().zzI();
                int i5 = zzbvr.zza;
                zzbryVar.zzD().zzP(list, z2);
            } else {
                if (!z2) {
                    this.zzc.zzm.zzc(i, zzbtp.CANCEL);
                }
                zzbryVar.zzD().zzj(zzbdoVarZzg, zzbfs.PROCESSED, false, new zzbcf());
            }
            z3 = false;
        }
        if (z3) {
            zzbsf zzbsfVar = this.zzc;
            zzbtp zzbtpVar = zzbtp.PROTOCOL_ERROR;
            zzbsfVar.zzaa(0, zzbtpVar, zzbsf.zzm(zzbtpVar).zzc("Received header for unknown stream: " + i));
        }
    }
}
