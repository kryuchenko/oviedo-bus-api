package com.google.android.gms.internal.vision;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzgy {
    public static final byte[] zzxr;
    private static final ByteBuffer zzxs;
    private static final zzfy zzxt;
    static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    public static int zzab(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zzm(boolean z) {
        return z ? 1231 : 1237;
    }

    static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzg(byte[] bArr) {
        return zzjx.zzg(bArr);
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int iZza = zza(length, bArr, 0, length);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static boolean zzf(zzih zzihVar) {
        if (!(zzihVar instanceof zzfa)) {
            return false;
        }
        return false;
    }

    static Object zzb(Object obj, Object obj2) {
        return ((zzih) obj).zzgj().zza((zzih) obj2).zzgc();
    }

    static {
        byte[] bArr = new byte[0];
        zzxr = bArr;
        zzxs = ByteBuffer.wrap(bArr);
        zzxt = zzfy.zza(bArr, 0, bArr.length, false);
    }
}
