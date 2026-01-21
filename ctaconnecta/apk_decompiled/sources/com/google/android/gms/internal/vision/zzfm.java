package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public abstract class zzfm implements Serializable, Iterable<Byte> {
    public static final zzfm zzsm = new zzfw(zzgy.zzxr);
    private static final zzfs zzsn;
    private static final Comparator<zzfm> zzso;
    private int zzmv = 0;

    zzfm() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zza(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    protected abstract String zza(Charset charset);

    abstract void zza(zzfn zzfnVar) throws IOException;

    protected abstract void zza(byte[] bArr, int i, int i2, int i3);

    public abstract byte zzao(int i);

    abstract byte zzap(int i);

    protected abstract int zzb(int i, int i2, int i3);

    public abstract boolean zzet();

    public abstract zzfm zzg(int i, int i2);

    public static zzfm zza(byte[] bArr, int i, int i2) {
        zzc(i, i + i2, bArr.length);
        return new zzfw(zzsn.zzd(bArr, i, i2));
    }

    static zzfm zzd(byte[] bArr) {
        return new zzfw(bArr);
    }

    static zzfm zzb(byte[] bArr, int i, int i2) {
        return new zzft(bArr, i, i2);
    }

    public static zzfm zzw(String str) {
        return new zzfw(str.getBytes(zzgy.UTF_8));
    }

    public final String zzes() {
        return size() == 0 ? "" : zza(zzgy.UTF_8);
    }

    public final int hashCode() {
        int iZzb = this.zzmv;
        if (iZzb == 0) {
            int size = size();
            iZzb = zzb(size, 0, size);
            if (iZzb == 0) {
                iZzb = 1;
            }
            this.zzmv = iZzb;
        }
        return iZzb;
    }

    static zzfu zzaq(int i) {
        return new zzfu(i, null);
    }

    protected final int zzeu() {
        return this.zzmv;
    }

    static int zzc(int i, int i2, int i3) {
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
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), size() <= 50 ? zzjk.zzd(this) : String.valueOf(zzjk.zzd(zzg(0, 47))).concat("..."));
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzfp(this);
    }

    static {
        zzfp zzfpVar = null;
        zzsn = zzff.zzds() ? new zzfz(zzfpVar) : new zzfq(zzfpVar);
        zzso = new zzfo();
    }
}
