package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public class zzbgz extends zzayo {
    private static final Logger zza = Logger.getLogger(zzbgz.class.getName());
    private static final zzayo zzb = new zzbgs();

    @Nullable
    private final ScheduledFuture zzc;
    private final Executor zzd;
    private final zzazj zze;
    private volatile boolean zzf;
    private zzayn zzg;
    private zzayo zzh;
    private zzbdo zzi;
    private List zzj = new ArrayList();
    private zzbgy zzk;

    protected zzbgz(Executor executor, ScheduledExecutorService scheduledExecutorService, @Nullable zzazn zzaznVar) {
        ScheduledFuture<?> scheduledFutureSchedule;
        zzmt.zzc(executor, "callExecutor");
        this.zzd = executor;
        zzmt.zzc(scheduledExecutorService, "scheduler");
        this.zze = zzazj.zzb();
        if (zzaznVar == null) {
            scheduledFutureSchedule = null;
        } else {
            long jZzb = zzaznVar.zzb(TimeUnit.NANOSECONDS);
            long jAbs = Math.abs(jZzb) / TimeUnit.SECONDS.toNanos(1L);
            long jAbs2 = Math.abs(jZzb) % TimeUnit.SECONDS.toNanos(1L);
            StringBuilder sb = new StringBuilder();
            if (jZzb < 0) {
                sb.append("ClientCall started after CallOptions deadline was exceeded. Deadline has been exceeded for ");
            } else {
                sb.append("Deadline CallOptions will be exceeded in ");
            }
            sb.append(jAbs);
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
            sb.append("s. ");
            scheduledFutureSchedule = scheduledExecutorService.schedule(new zzbgl(this, sb), jZzb, TimeUnit.NANOSECONDS);
        }
        this.zzc = scheduledFutureSchedule;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl(zzbdo zzbdoVar, boolean z) {
        zzayn zzaynVar;
        boolean z2;
        synchronized (this) {
            if (this.zzh == null) {
                zzo(zzb);
                zzaynVar = this.zzg;
                this.zzi = zzbdoVar;
                z2 = false;
            } else {
                if (z) {
                    return;
                }
                zzaynVar = null;
                z2 = true;
            }
            if (z2) {
                zzm(new zzbgo(this, zzbdoVar));
            } else {
                if (zzaynVar != null) {
                    this.zzd.execute(new zzbgt(this, zzaynVar, zzbdoVar));
                }
                zzn();
            }
            zzk();
        }
    }

    private final void zzm(Runnable runnable) {
        synchronized (this) {
            if (this.zzf) {
                runnable.run();
            } else {
                this.zzj.add(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r0.hasNext() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzn() {
        zzbgy zzbgyVar;
        List list;
        List arrayList = new ArrayList();
        while (true) {
            synchronized (this) {
                if (this.zzj.isEmpty()) {
                    break;
                }
                list = this.zzj;
                this.zzj = arrayList;
            }
            if (zzbgyVar == null) {
                this.zzd.execute(new zzbgm(this, zzbgyVar));
                return;
            }
            return;
            list.clear();
            arrayList = list;
        }
        this.zzj = null;
        this.zzf = true;
        zzbgyVar = this.zzk;
        if (zzbgyVar == null) {
        }
    }

    private final void zzo(zzayo zzayoVar) {
        zzayo zzayoVar2 = this.zzh;
        zzmt.zzr(zzayoVar2 == null, "realCall already set to %s", zzayoVar2);
        ScheduledFuture scheduledFuture = this.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzh = zzayoVar;
    }

    public final String toString() {
        zzmm zzmmVarZzb = zzmn.zzb(this);
        zzmmVarZzb.zzd("realCall", this.zzh);
        return zzmmVarZzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zza(@Nullable String str, @Nullable Throwable th) {
        zzbdo zzbdoVar = zzbdo.zzb;
        zzbdo zzbdoVarZzg = str != null ? zzbdoVar.zzg(str) : zzbdoVar.zzg("Call cancelled without message");
        if (th != null) {
            zzbdoVarZzg = zzbdoVarZzg.zzf(th);
        }
        zzl(zzbdoVarZzg, false);
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zzb() {
        zzm(new zzbgr(this));
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zzc(int i) {
        if (this.zzf) {
            this.zzh.zzc(2);
        } else {
            zzm(new zzbgq(this, 2));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zzd(Object obj) {
        if (this.zzf) {
            this.zzh.zzd(obj);
        } else {
            zzm(new zzbgp(this, obj));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zze(zzayn zzaynVar, zzbcf zzbcfVar) {
        zzbdo zzbdoVar;
        boolean z;
        zzmt.zzp(this.zzg == null, "already started");
        synchronized (this) {
            this.zzg = zzaynVar;
            zzbdoVar = this.zzi;
            z = this.zzf;
            if (!z) {
                zzbgy zzbgyVar = new zzbgy(zzaynVar);
                this.zzk = zzbgyVar;
                zzaynVar = zzbgyVar;
            }
        }
        if (zzbdoVar != null) {
            this.zzd.execute(new zzbgt(this, zzaynVar, zzbdoVar));
        } else if (z) {
            this.zzh.zze(zzaynVar, zzbcfVar);
        } else {
            zzm(new zzbgn(this, zzaynVar, zzbcfVar));
        }
    }

    protected void zzk() {
    }

    public final Runnable zzh(zzayo zzayoVar) {
        synchronized (this) {
            if (this.zzh != null) {
                return null;
            }
            zzo(zzayoVar);
            return new zzbgk(this, this.zze);
        }
    }
}
