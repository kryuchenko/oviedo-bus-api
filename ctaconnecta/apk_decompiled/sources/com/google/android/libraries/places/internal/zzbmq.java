package com.google.android.libraries.places.internal;

import java.io.Closeable;
import java.util.Locale;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbmq implements Closeable, zzbgj, AutoCloseable {
    private zzbmm zza;
    private int zzb;
    private final zzbqo zzc;
    private final zzbqz zzd;
    private zzazo zze;
    private boolean zzg;
    private zzbge zzh;
    private long zzj;
    private int zzm;
    private int zzp = 1;
    private int zzf = 5;
    private zzbge zzi = new zzbge();
    private boolean zzk = false;
    private int zzl = -1;
    private boolean zzn = false;
    private volatile boolean zzo = false;

    public zzbmq(zzbmm zzbmmVar, zzazo zzazoVar, int i, zzbqo zzbqoVar, zzbqz zzbqzVar) {
        this.zza = zzbmmVar;
        this.zze = zzazoVar;
        this.zzb = i;
        this.zzc = zzbqoVar;
        this.zzd = zzbqzVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
    
        if (r3 <= 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        r12.zza.zzE(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006c, code lost:
    
        if (r12.zzp != 2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006e, code lost:
    
        r12.zzc.zzh(r3);
        r12.zzm += r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0079, code lost:
    
        r3 = r12.zzp;
        r4 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        if (r3 == 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
    
        if (r4 == 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        if (r4 == 1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0086, code lost:
    
        if (r3 == 1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0088, code lost:
    
        r0 = "BODY";
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008b, code lost:
    
        r0 = "HEADER";
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a1, code lost:
    
        throw new java.lang.AssertionError("Invalid state: " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a2, code lost:
    
        r12.zzc.zzf(r12.zzl, r12.zzm, -1);
        r12.zzm = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b2, code lost:
    
        if (r12.zzg == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b4, code lost:
    
        r2 = r12.zze;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b8, code lost:
    
        if (r2 == com.google.android.libraries.places.internal.zzaza.zza) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ba, code lost:
    
        r3 = new com.google.android.libraries.places.internal.zzbmp(r2.zza(new com.google.android.libraries.places.internal.zzbnw(r12.zzh)), r12.zzb, r12.zzc);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cf, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d5, code lost:
    
        throw new java.lang.RuntimeException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e3, code lost:
    
        throw new com.google.android.libraries.places.internal.zzbdq(com.google.android.libraries.places.internal.zzbdo.zzo.zzg("Can't decode compressed gRPC message as compression not configured"), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e4, code lost:
    
        r12.zzc.zzg(r12.zzh.zzf());
        r3 = new com.google.android.libraries.places.internal.zzbnw(r12.zzh);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f7, code lost:
    
        r12.zzh = null;
        r12.zza.zzr(new com.google.android.libraries.places.internal.zzbmo(r3, null));
        r12.zzp = 1;
        r12.zzf = 5;
        r12.zzj--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0111, code lost:
    
        r3 = r12.zzh.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0119, code lost:
    
        if ((r3 & org.jmrtd.lds.iso19794.IrisImageInfo.IMAGE_QUAL_UNDEF) != 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x011d, code lost:
    
        if (1 == (r3 & 1)) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x011f, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0121, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0122, code lost:
    
        r12.zzg = r3;
        r3 = r12.zzh;
        r3.zza(4);
        r3 = r3.zze() | (((r3.zze() << 24) | (r3.zze() << 16)) | (r3.zze() << 8));
        r12.zzf = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0145, code lost:
    
        if (r3 < 0) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0149, code lost:
    
        if (r3 > r12.zzb) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x014b, code lost:
    
        r3 = r12.zzl + 1;
        r12.zzl = r3;
        r12.zzc.zze(r3);
        r12.zzd.zzc();
        r12.zzp = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0191, code lost:
    
        throw new com.google.android.libraries.places.internal.zzbdq(com.google.android.libraries.places.internal.zzbdo.zzo.zzg("gRPC frame header malformed: reserved bits not zero"), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0192, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ae, code lost:
    
        if (r12.zzn == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b4, code lost:
    
        if (zzi() == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b6, code lost:
    
        close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bb, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzh() {
        int i;
        if (this.zzk) {
            return;
        }
        this.zzk = true;
        while (true) {
            try {
                if (this.zzj <= 0) {
                    break;
                }
                try {
                    if (this.zzh == null) {
                        this.zzh = new zzbge();
                    }
                    i = 0;
                    while (true) {
                        try {
                            int iZzf = this.zzf - this.zzh.zzf();
                            if (iZzf <= 0) {
                                break;
                            }
                            if (this.zzi.zzf() != 0) {
                                int iMin = Math.min(iZzf, this.zzi.zzf());
                                i += iMin;
                                this.zzh.zzh(this.zzi.zzg(iMin));
                            } else if (i > 0) {
                                this.zza.zzE(i);
                                if (this.zzp == 2) {
                                    this.zzc.zzh(i);
                                    this.zzm += i;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (i > 0) {
                                this.zza.zzE(i);
                                if (this.zzp == 2) {
                                    this.zzc.zzh(i);
                                    this.zzm += i;
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i = 0;
                }
            } finally {
                this.zzk = false;
            }
        }
        throw new zzbdq(zzbdo.zzj.zzg(String.format(Locale.US, "gRPC message exceeds maximum size %d: %d", Integer.valueOf(this.zzb), Integer.valueOf(this.zzf))), null);
    }

    private final boolean zzi() {
        return this.zzi.zzf() == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.google.android.libraries.places.internal.zzbgj
    public final void close() {
        if (zzg()) {
            return;
        }
        zzbge zzbgeVar = this.zzh;
        boolean z = false;
        if (zzbgeVar != null && zzbgeVar.zzf() > 0) {
            z = true;
        }
        try {
            zzbge zzbgeVar2 = this.zzi;
            if (zzbgeVar2 != null) {
                zzbgeVar2.close();
            }
            zzbge zzbgeVar3 = this.zzh;
            if (zzbgeVar3 != null) {
                zzbgeVar3.close();
            }
            this.zzi = null;
            this.zzh = null;
            this.zza.zze(z);
        } catch (Throwable th) {
            this.zzi = null;
            this.zzh = null;
            throw th;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgj
    public final void zza() {
        if (zzg()) {
            return;
        }
        if (zzi()) {
            close();
        } else {
            this.zzn = true;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgj
    public final void zzb(zzbnv zzbnvVar) throws Throwable {
        boolean z = true;
        try {
            if (!zzg() && !this.zzn) {
                this.zzi.zzh(zzbnvVar);
                try {
                    zzh();
                    return;
                } catch (Throwable th) {
                    th = th;
                    z = false;
                    if (z) {
                        zzbnvVar.close();
                    }
                    throw th;
                }
            }
            zzbnvVar.close();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgj
    public final void zzc(int i) {
        if (zzg()) {
            return;
        }
        this.zzj += 2;
        zzh();
    }

    @Override // com.google.android.libraries.places.internal.zzbgj
    public final void zzd(zzazo zzazoVar) {
        this.zze = zzazoVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbgj
    public final void zze(int i) {
        this.zzb = i;
    }

    final void zzf(zzbmm zzbmmVar) {
        this.zza = zzbmmVar;
    }

    public final boolean zzg() {
        return this.zzi == null;
    }
}
