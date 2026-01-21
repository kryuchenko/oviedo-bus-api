package com.google.android.libraries.places.internal;

import java.io.IOException;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class zzsi {
    private static final zzsi zza = new zzsf("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final zzsi zzb = new zzsf("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final zzsi zzc = new zzsh("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final zzsi zzd = new zzsh("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final zzsi zze = new zzse("base16()", "0123456789ABCDEF");

    zzsi() {
    }

    public static zzsi zzi() {
        return zze;
    }

    public static zzsi zzj() {
        return zza;
    }

    abstract int zza(byte[] bArr, CharSequence charSequence) throws zzsg;

    abstract void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    abstract int zzd(int i);

    abstract int zze(int i);

    public abstract zzsi zzf();

    CharSequence zzg(CharSequence charSequence) {
        throw null;
    }

    public final String zzk(byte[] bArr, int i, int i2) {
        zzmt.zzn(0, i2, bArr.length);
        StringBuilder sb = new StringBuilder(zze(i2));
        try {
            zzc(sb, bArr, 0, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] zzl(CharSequence charSequence) {
        try {
            CharSequence charSequenceZzg = zzg(charSequence);
            int iZzd = zzd(charSequenceZzg.length());
            byte[] bArr = new byte[iZzd];
            int iZza = zza(bArr, charSequenceZzg);
            if (iZza == iZzd) {
                return bArr;
            }
            byte[] bArr2 = new byte[iZza];
            System.arraycopy(bArr, 0, bArr2, 0, iZza);
            return bArr2;
        } catch (zzsg e) {
            throw new IllegalArgumentException(e);
        }
    }
}
