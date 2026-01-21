package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzmt {
    public static int zza(int i, int i2, String str) {
        String strZzb;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strZzb = zznb.zzb("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative size: " + i2);
            }
            strZzb = zznb.zzb("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strZzb);
    }

    public static int zzb(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zzt(i, i2, FirebaseAnalytics.Param.INDEX));
        }
        return i;
    }

    public static Object zzc(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static Object zzd(@CheckForNull Object obj, String str, @CheckForNull Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(zznb.zzb(str, obj2));
    }

    public static void zze(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzf(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void zzg(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalArgumentException(zznb.zzb(str, Character.valueOf(c)));
        }
    }

    public static void zzh(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(zznb.zzb(str, Integer.valueOf(i)));
        }
    }

    public static void zzi(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(zznb.zzb(str, Long.valueOf(j)));
        }
    }

    public static void zzj(boolean z, String str, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(zznb.zzb(str, obj));
        }
    }

    public static void zzk(boolean z, String str, int i, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(zznb.zzb(str, 4800, obj));
        }
    }

    public static void zzl(boolean z, @CheckForNull String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(zznb.zzb(str, obj, obj2));
        }
    }

    public static void zzm(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z) {
            throw new IllegalArgumentException(zznb.zzb(str, obj, obj2, obj3));
        }
    }

    public static void zzn(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException((i < 0 || i > i3) ? zzt(i, i3, "start index") : (i2 < 0 || i2 > i3) ? zzt(i2, i3, "end index") : zznb.zzb("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public static void zzo(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void zzp(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException((String) obj);
        }
    }

    public static void zzq(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalStateException(zznb.zzb(str, Integer.valueOf(i)));
        }
    }

    public static void zzr(boolean z, String str, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(zznb.zzb(str, obj));
        }
    }

    public static void zzs(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z) {
            throw new IllegalStateException(zznb.zzb(str, obj, obj2, obj3));
        }
    }

    private static String zzt(int i, int i2, String str) {
        if (i < 0) {
            return zznb.zzb("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zznb.zzb("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }
}
