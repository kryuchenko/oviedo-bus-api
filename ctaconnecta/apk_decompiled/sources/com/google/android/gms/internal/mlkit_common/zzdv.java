package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class zzdv implements Serializable, Iterable<Byte> {
    public static final zzdv zza = new zzef(zzfc.zzb);
    private static final zzeb zzb;
    private static final Comparator<zzdv> zzd;
    private int zzc = 0;

    zzdv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzb(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract byte zza(int i);

    public abstract int zza();

    protected abstract int zza(int i, int i2, int i3);

    public abstract zzdv zza(int i, int i2);

    protected abstract String zza(Charset charset);

    abstract void zza(zzdw zzdwVar) throws IOException;

    abstract byte zzb(int i);

    public abstract boolean zzc();

    public static zzdv zza(String str) {
        return new zzef(str.getBytes(zzfc.zza));
    }

    public final String zzb() {
        return zza() == 0 ? "" : zza(zzfc.zza);
    }

    public final int hashCode() {
        int iZza = this.zzc;
        if (iZza == 0) {
            int iZza2 = zza();
            iZza = zza(iZza2, 0, iZza2);
            if (iZza == 0) {
                iZza = 1;
            }
            this.zzc = iZza;
        }
        return iZza;
    }

    static zzed zzc(int i) {
        return new zzed(i, null);
    }

    protected final int zzd() {
        return this.zzc;
    }

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zza()), zza() <= 50 ? zzhm.zza(this) : String.valueOf(zzhm.zza(zza(0, 47))).concat("..."));
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzdy(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        zzdy zzdyVar = null;
        zzb = zzdt.zza() ? new zzei(zzdyVar) : new zzdz(zzdyVar);
        zzd = new zzdx();
    }
}
