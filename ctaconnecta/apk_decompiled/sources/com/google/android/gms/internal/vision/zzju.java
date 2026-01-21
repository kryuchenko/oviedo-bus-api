package com.google.android.gms.internal.vision;

import com.google.android.libraries.places.api.model.PlaceTypes;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzju {
    private static final Logger logger = Logger.getLogger(zzju.class.getName());
    private static final boolean zzabe;
    private static final boolean zzabf;
    private static final zzd zzabg;
    private static final boolean zzabh;
    private static final long zzabi;
    private static final long zzabj;
    private static final long zzabk;
    private static final long zzabl;
    private static final long zzabm;
    private static final long zzabn;
    private static final long zzabo;
    private static final long zzabp;
    private static final long zzabq;
    private static final long zzabr;
    private static final long zzabs;
    private static final long zzabt;
    private static final long zzabu;
    private static final long zzabv;
    private static final int zzabw;
    static final boolean zzabx;
    private static final Class<?> zzsb;
    private static final boolean zztg;
    private static final Unsafe zzzi;

    private zzju() {
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final byte zzy(Object obj, long j) {
            if (zzju.zzabx) {
                return zzju.zzq(obj, j);
            }
            return zzju.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zzju.zzabx) {
                zzju.zza(obj, j, b);
            } else {
                zzju.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final boolean zzm(Object obj, long j) {
            if (zzju.zzabx) {
                return zzju.zzs(obj, j);
            }
            return zzju.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzju.zzabx) {
                zzju.zzb(obj, j, z);
            } else {
                zzju.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final byte zzy(Object obj, long j) {
            return this.zzaca.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zze(Object obj, long j, byte b) {
            this.zzaca.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final boolean zzm(Object obj, long j) {
            return this.zzaca.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zzaca.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final float zzn(Object obj, long j) {
            return this.zzaca.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, float f) {
            this.zzaca.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final double zzo(Object obj, long j) {
            return this.zzaca.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, double d) {
            this.zzaca.putDouble(obj, j, d);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final byte zzy(Object obj, long j) {
            if (zzju.zzabx) {
                return zzju.zzq(obj, j);
            }
            return zzju.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zzju.zzabx) {
                zzju.zza(obj, j, b);
            } else {
                zzju.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final boolean zzm(Object obj, long j) {
            if (zzju.zzabx) {
                return zzju.zzs(obj, j);
            }
            return zzju.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzju.zzabx) {
                zzju.zzb(obj, j, z);
            } else {
                zzju.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static boolean zzik() {
        return zztg;
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    static abstract class zzd {
        Unsafe zzaca;

        zzd(Unsafe unsafe) {
            this.zzaca = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzaca.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzaca.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzaca.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzaca.putLong(obj, j, j2);
        }
    }

    static boolean zzil() {
        return zzabh;
    }

    static <T> T zzh(Class<T> cls) {
        try {
            return (T) zzzi.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzi(Class<?> cls) {
        if (zztg) {
            return zzabg.zzaca.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzj(Class<?> cls) {
        if (zztg) {
            return zzabg.zzaca.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzabg.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzabg.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzabg.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzabg.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzabg.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzabg.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzabg.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzabg.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzabg.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzabg.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzabg.zzaca.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzabg.zzaca.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzabg.zzy(bArr, zzabi + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzabg.zze(bArr, zzabi + j, b);
    }

    static Unsafe zzim() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzjw());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzin() {
        Unsafe unsafe = zzzi;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzff.zzds()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzio() {
        Unsafe unsafe = zzzi;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzip() == null) {
                return false;
            }
            if (zzff.zzds()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("putLong", cls2, cls2);
            Class<?> cls3 = Long.TYPE;
            cls.getMethod("copyMemory", cls3, cls3, cls3);
            Class<?> cls4 = Long.TYPE;
            cls.getMethod("copyMemory", Object.class, cls4, Object.class, cls4, cls4);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzk(Class<?> cls) {
        if (!zzff.zzds()) {
            return false;
        }
        try {
            Class<?> cls2 = zzsb;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            Class<?> cls3 = Integer.TYPE;
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls3, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field zzip() {
        Field fieldZzb;
        if (zzff.zzds() && (fieldZzb = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldZzb;
        }
        Field fieldZzb2 = zzb(Buffer.class, PlaceTypes.ADDRESS);
        if (fieldZzb2 == null || fieldZzb2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzb2;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, (-4) & j) >>> ((int) ((j & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int iZzk = zzk(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (iZzk & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : (byte) 0);
    }

    static {
        Unsafe unsafeZzim = zzim();
        zzzi = unsafeZzim;
        zzsb = zzff.zzdt();
        boolean zZzk = zzk(Long.TYPE);
        zzabe = zZzk;
        boolean zZzk2 = zzk(Integer.TYPE);
        zzabf = zZzk2;
        zzd zzbVar = null;
        if (unsafeZzim != null) {
            if (!zzff.zzds()) {
                zzbVar = new zzb(unsafeZzim);
            } else if (zZzk) {
                zzbVar = new zzc(unsafeZzim);
            } else if (zZzk2) {
                zzbVar = new zza(unsafeZzim);
            }
        }
        zzabg = zzbVar;
        zzabh = zzio();
        zztg = zzin();
        long jZzi = zzi(byte[].class);
        zzabi = jZzi;
        zzabj = zzi(boolean[].class);
        zzabk = zzj(boolean[].class);
        zzabl = zzi(int[].class);
        zzabm = zzj(int[].class);
        zzabn = zzi(long[].class);
        zzabo = zzj(long[].class);
        zzabp = zzi(float[].class);
        zzabq = zzj(float[].class);
        zzabr = zzi(double[].class);
        zzabs = zzj(double[].class);
        zzabt = zzi(Object[].class);
        zzabu = zzj(Object[].class);
        Field fieldZzip = zzip();
        zzabv = (fieldZzip == null || zzbVar == null) ? -1L : zzbVar.zzaca.objectFieldOffset(fieldZzip);
        zzabw = (int) (jZzi & 7);
        zzabx = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }
}
