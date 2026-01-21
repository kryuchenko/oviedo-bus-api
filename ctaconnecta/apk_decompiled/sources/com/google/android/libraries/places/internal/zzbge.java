package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbge extends zzbeg {
    private static final zzbgc zza = new zzbfx();
    private static final zzbgc zzb = new zzbfy();
    private static final zzbgc zzc = new zzbfz();
    private static final zzbgc zzd = new zzbga();
    private static final zzbgd zze = new zzbgb();
    private final Deque zzf;
    private Deque zzg;
    private int zzh;
    private final Queue zzi;
    private boolean zzj;

    public zzbge() {
        this.zzi = new ArrayDeque(2);
        this.zzf = new ArrayDeque();
    }

    private final int zzm(zzbgd zzbgdVar, int i, Object obj, int i2) throws IOException {
        zza(i);
        if (!this.zzf.isEmpty()) {
            zzp();
        }
        while (i > 0 && !this.zzf.isEmpty()) {
            zzbnv zzbnvVar = (zzbnv) this.zzf.peek();
            int iMin = Math.min(i, zzbnvVar.zzf());
            i2 = zzbgdVar.zza(zzbnvVar, iMin, obj, i2);
            i -= iMin;
            this.zzh -= iMin;
            zzp();
        }
        if (i <= 0) {
            return i2;
        }
        throw new AssertionError("Failed executing read operation");
    }

    private final int zzn(zzbgc zzbgcVar, int i, Object obj, int i2) {
        try {
            return zzm(zzbgcVar, i, obj, i2);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private final void zzo() {
        if (!this.zzj) {
            ((zzbnv) this.zzf.remove()).close();
            return;
        }
        this.zzg.add((zzbnv) this.zzf.remove());
        zzbnv zzbnvVar = (zzbnv) this.zzf.peek();
        if (zzbnvVar != null) {
            zzbnvVar.zzb();
        }
    }

    private final void zzp() {
        if (((zzbnv) this.zzf.peek()).zzf() == 0) {
            zzo();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbeg, com.google.android.libraries.places.internal.zzbnv, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        while (!this.zzf.isEmpty()) {
            ((zzbnv) this.zzf.remove()).close();
        }
        if (this.zzg != null) {
            while (!this.zzg.isEmpty()) {
                ((zzbnv) this.zzg.remove()).close();
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbeg, com.google.android.libraries.places.internal.zzbnv
    public final void zzc() {
        if (!this.zzj) {
            throw new InvalidMarkException();
        }
        zzbnv zzbnvVar = (zzbnv) this.zzf.peek();
        if (zzbnvVar != null) {
            int iZzf = zzbnvVar.zzf();
            zzbnvVar.zzc();
            this.zzh += zzbnvVar.zzf() - iZzf;
        }
        while (true) {
            zzbnv zzbnvVar2 = (zzbnv) this.zzg.pollLast();
            if (zzbnvVar2 == null) {
                return;
            }
            zzbnvVar2.zzc();
            this.zzf.addFirst(zzbnvVar2);
            this.zzh += zzbnvVar2.zzf();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbeg, com.google.android.libraries.places.internal.zzbnv
    public final boolean zzd() {
        Iterator it = this.zzf.iterator();
        while (it.hasNext()) {
            if (!((zzbnv) it.next()).zzd()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final int zze() {
        return zzn(zza, 1, null, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final int zzf() {
        return this.zzh;
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final zzbnv zzg(int i) {
        zzbnv zzbnvVarZzg;
        int i2;
        zzbnv zzbnvVarZzg2;
        if (i <= 0) {
            return zzbny.zza();
        }
        zza(i);
        this.zzh -= i;
        zzbnv zzbnvVar = null;
        zzbge zzbgeVar = null;
        while (true) {
            zzbnv zzbnvVar2 = (zzbnv) this.zzf.peek();
            int iZzf = zzbnvVar2.zzf();
            if (iZzf > i) {
                zzbnvVarZzg2 = zzbnvVar2.zzg(i);
                i2 = 0;
            } else {
                if (this.zzj) {
                    zzbnvVarZzg = zzbnvVar2.zzg(iZzf);
                    zzo();
                } else {
                    zzbnvVarZzg = (zzbnv) this.zzf.poll();
                }
                zzbnv zzbnvVar3 = zzbnvVarZzg;
                i2 = i - iZzf;
                zzbnvVarZzg2 = zzbnvVar3;
            }
            if (zzbnvVar == null) {
                zzbnvVar = zzbnvVarZzg2;
            } else {
                if (zzbgeVar == null) {
                    zzbgeVar = new zzbge(i2 != 0 ? Math.min(this.zzf.size() + 2, 16) : 2);
                    zzbgeVar.zzh(zzbnvVar);
                    zzbnvVar = zzbgeVar;
                }
                zzbgeVar.zzh(zzbnvVarZzg2);
            }
            if (i2 <= 0) {
                return zzbnvVar;
            }
            i = i2;
        }
    }

    public final void zzh(zzbnv zzbnvVar) {
        boolean z = this.zzj && this.zzf.isEmpty();
        if (zzbnvVar instanceof zzbge) {
            zzbge zzbgeVar = (zzbge) zzbnvVar;
            while (!zzbgeVar.zzf.isEmpty()) {
                this.zzf.add((zzbnv) zzbgeVar.zzf.remove());
            }
            this.zzh += zzbgeVar.zzh;
            zzbgeVar.zzh = 0;
            zzbgeVar.close();
        } else {
            this.zzf.add(zzbnvVar);
            this.zzh += zzbnvVar.zzf();
        }
        if (z) {
            ((zzbnv) this.zzf.peek()).zzb();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final void zzi(ByteBuffer byteBuffer) {
        zzn(zzd, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final void zzj(OutputStream outputStream, int i) throws IOException {
        zzm(zze, i, outputStream, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final void zzk(byte[] bArr, int i, int i2) {
        zzn(zzc, i2, bArr, i);
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final void zzl(int i) {
        zzn(zzb, i, null, 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbeg, com.google.android.libraries.places.internal.zzbnv
    public final void zzb() {
        if (this.zzg == null) {
            this.zzg = new ArrayDeque(Math.min(this.zzf.size(), 16));
        }
        while (!this.zzg.isEmpty()) {
            ((zzbnv) this.zzg.remove()).close();
        }
        this.zzj = true;
        zzbnv zzbnvVar = (zzbnv) this.zzf.peek();
        if (zzbnvVar != null) {
            zzbnvVar.zzb();
        }
    }

    public zzbge(int i) {
        this.zzi = new ArrayDeque(2);
        this.zzf = new ArrayDeque(i);
    }
}
