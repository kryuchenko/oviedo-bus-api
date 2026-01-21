package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzek;
import com.google.android.gms.internal.mlkit_vision_common.zzek.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class zzek<MessageType extends zzek<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzda<MessageType, BuilderType> {
    private static Map<Object, zzek<?, ?>> zzd = new ConcurrentHashMap();
    protected zzhd zzb = zzhd.zza();
    private int zzc = -1;

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static class zza<T extends zzek<T, ?>> extends zzdf<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType extends zzd<MessageType, BuilderType>> extends zzek<MessageType, BuilderType> implements zzfx {
        protected zzef<zzf> zzc = zzef.zza();
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public enum zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzl = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzh = 1;
        public static final int zzi = 2;
        private static final /* synthetic */ int[] zzm = {1, 2};
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzn = {1, 2};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    static final class zzf implements zzeh<zzf> {
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzeh
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzeh
        public final zzho zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzeh
        public final zzhv zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzeh
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzeh
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzeh
        public final zzfu zza(zzfu zzfuVar, zzfv zzfvVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzeh
        public final zzgb zza(zzgb zzgbVar, zzgb zzgbVar2) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static abstract class zzd<MessageType extends zzc<MessageType, BuilderType>, BuilderType extends zzd<MessageType, BuilderType>> extends zzb<MessageType, BuilderType> implements zzfx {
        protected zzd(MessageType messagetype) {
            super(messagetype);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek.zzb
        protected void zzc() {
            super.zzc();
            ((zzc) this.zza).zzc = (zzef) ((zzc) this.zza).zzc.clone();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek.zzb
        /* renamed from: zzd */
        public /* synthetic */ zzek zzf() {
            return (zzc) zzf();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek.zzb, com.google.android.gms.internal.mlkit_vision_common.zzfu
        public /* synthetic */ zzfv zzf() {
            if (this.zzb) {
                return (zzc) this.zza;
            }
            ((zzc) this.zza).zzc.zzb();
            return (zzc) super.zzf();
        }
    }

    public String toString() {
        return zzfw.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzgh.zza().zza((zzgh) this).zza(this);
        return this.zza;
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static abstract class zzb<MessageType extends zzek<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdd<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        protected zzb(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (MessageType) messagetype.zza(zze.zzd, null, null);
        }

        protected void zzc() {
            MessageType messagetype = (MessageType) this.zza.zza(zze.zzd, null, null);
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzfx
        public final boolean zzi() {
            return zzek.zza(this.zza, false);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzfu
        /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public MessageType zzf() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzgh.zza().zza((zzgh) messagetype).zzb(messagetype);
            this.zzb = true;
            return this.zza;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzfu
        /* renamed from: zze, reason: merged with bridge method [inline-methods] */
        public final MessageType zzg() {
            MessageType messagetype = (MessageType) zzf();
            if (messagetype.zzi()) {
                return messagetype;
            }
            throw new zzhb(messagetype);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdd
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzc();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzgh.zza().zza((zzgh) messagetype).zzb(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdd
        /* renamed from: zzb */
        public final /* synthetic */ zzdd clone() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzfx
        public final /* synthetic */ zzfv zzn() {
            return this.zzc;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdd
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.zzc.zza(zze.zze, null, null);
            zzbVar.zza((zzb) zzf());
            return zzbVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzgh.zza().zza((zzgh) this).zza(this, (zzek<MessageType, BuilderType>) obj);
        }
        return false;
    }

    protected final <MessageType extends zzek<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzh() {
        return (BuilderType) zza(zze.zze, (Object) null, (Object) null);
    }

    protected final <MessageType extends zzek<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zza(MessageType messagetype) {
        return (BuilderType) zzh().zza((zzb) messagetype);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfx
    public final boolean zzi() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzda
    final int zzg() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzda
    final void zza(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfv
    public final void zza(zzdw zzdwVar) throws IOException {
        zzgh.zza().zza((zzgh) this).zza((zzgi) this, (zzhu) zzdz.zza(zzdwVar));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfv
    public final int zzj() {
        if (this.zzc == -1) {
            this.zzc = zzgh.zza().zza((zzgh) this).zzd(this);
        }
        return this.zzc;
    }

    static <T extends zzek<?, ?>> T zza(Class<T> cls) throws ClassNotFoundException {
        T t = (T) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        T t2 = (T) ((zzek) zzhg.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
        if (t2 == null) {
            throw new IllegalStateException();
        }
        zzd.put(cls, t2);
        return t2;
    }

    protected static <T extends zzek<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzfv zzfvVar, String str, Object[] objArr) {
        return new zzgj(zzfvVar, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final <T extends zzek<T, ?>> boolean zza(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zze.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzc = zzgh.zza().zza((zzgh) t).zzc(t);
        if (z) {
            t.zza(zze.zzb, zZzc ? t : null, null);
        }
        return zZzc;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzen, com.google.android.gms.internal.mlkit_vision_common.zzeq] */
    protected static zzeq zzk() {
        return zzen.zzd();
    }

    protected static <E> zzes<E> zzl() {
        return zzgg.zzd();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfv
    public final /* synthetic */ zzfu zzm() {
        zzb zzbVar = (zzb) zza(zze.zze, (Object) null, (Object) null);
        zzbVar.zza((zzb) this);
        return zzbVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfx
    public final /* synthetic */ zzfv zzn() {
        return (zzek) zza(zze.zzf, (Object) null, (Object) null);
    }
}
