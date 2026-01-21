package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzez;
import com.google.android.gms.internal.mlkit_common.zzez.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class zzez<MessageType extends zzez<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdq<MessageType, BuilderType> {
    private static Map<Object, zzez<?, ?>> zzd = new ConcurrentHashMap();
    protected zzhp zzb = zzhp.zza();
    private int zzc = -1;

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static class zzc<T extends zzez<T, ?>> extends zzdr<T> {
        private final T zza;

        public zzc(T t) {
            this.zza = t;
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    static final class zzd implements zzet<zzd> {
        @Override // com.google.android.gms.internal.mlkit_common.zzet
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzet
        public final zzie zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzet
        public final zzih zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzet
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzet
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzet
        public final zzgk zza(zzgk zzgkVar, zzgh zzghVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzet
        public final zzgn zza(zzgn zzgnVar, zzgn zzgnVar2) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static abstract class zze<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzez<MessageType, BuilderType> implements zzgj {
        protected zzer<zzd> zzc = zzer.zza();
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public enum zzf {
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

    protected abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static abstract class zzb<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzgj {
        protected zzb(MessageType messagetype) {
            super(messagetype);
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzez.zza
        protected void zzc() {
            super.zzc();
            ((zze) this.zza).zzc = (zzer) ((zze) this.zza).zzc.clone();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzez.zza
        /* renamed from: zze */
        public /* synthetic */ zzez zzg() {
            return (zze) zzg();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzez.zza, com.google.android.gms.internal.mlkit_common.zzgk
        public /* synthetic */ zzgh zzg() {
            if (this.zzb) {
                return (zze) this.zza;
            }
            ((zze) this.zza).zzc.zzb();
            return (zze) super.zzg();
        }
    }

    public String toString() {
        return zzgm.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzgt.zza().zza((zzgt) this).zza(this);
        return this.zza;
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static abstract class zza<MessageType extends zzez<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdp<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        protected zza(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (MessageType) messagetype.zza(zzf.zzd, null, null);
        }

        protected void zzc() {
            MessageType messagetype = (MessageType) this.zza.zza(zzf.zzd, null, null);
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzgj
        public final boolean a_() {
            return zzez.zza(this.zza, false);
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzgk
        /* renamed from: zze, reason: merged with bridge method [inline-methods] */
        public MessageType zzg() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzgt.zza().zza((zzgt) messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzgk
        /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
        public final MessageType zzh() {
            MessageType messagetype = (MessageType) zzg();
            if (messagetype.a_()) {
                return messagetype;
            }
            throw new zzhn(messagetype);
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzdp
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzc();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzgt.zza().zza((zzgt) messagetype).zzb(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzdp
        /* renamed from: zzb */
        public final /* synthetic */ zzdp clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.mlkit_common.zzgj
        public final /* synthetic */ zzgh zzi() {
            return this.zzc;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.mlkit_common.zzdp
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzc.zza(zzf.zze, null, null);
            zzaVar.zza((zza) zzg());
            return zzaVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzgt.zza().zza((zzgt) this).zza(this, (zzez<MessageType, BuilderType>) obj);
        }
        return false;
    }

    protected final <MessageType extends zzez<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzh() {
        return (BuilderType) zza(zzf.zze, (Object) null, (Object) null);
    }

    protected final <MessageType extends zzez<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zza(MessageType messagetype) {
        return (BuilderType) zzh().zza((zza) messagetype);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgj
    public final boolean a_() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzdq
    final int zzg() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzdq
    final void zza(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgh
    public final void zza(zzem zzemVar) throws IOException {
        zzgt.zza().zza((zzgt) this).zza((zzgy) this, (zzik) zzeo.zza(zzemVar));
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgh
    public final int zzj() {
        if (this.zzc == -1) {
            this.zzc = zzgt.zza().zza((zzgt) this).zzb(this);
        }
        return this.zzc;
    }

    static <T extends zzez<?, ?>> T zza(Class<T> cls) throws ClassNotFoundException {
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
        T t2 = (T) ((zzez) zzhw.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null);
        if (t2 == null) {
            throw new IllegalStateException();
        }
        zzd.put(cls, t2);
        return t2;
    }

    protected static <T extends zzez<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzgh zzghVar, String str, Object[] objArr) {
        return new zzgv(zzghVar, str, objArr);
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

    protected static final <T extends zzez<T, ?>> boolean zza(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zzf.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzd = zzgt.zza().zza((zzgt) t).zzd(t);
        if (z) {
            t.zza(zzf.zzb, zZzd ? t : null, null);
        }
        return zZzd;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzfa, com.google.android.gms.internal.mlkit_common.zzfg] */
    protected static zzfg zzk() {
        return zzfa.zzd();
    }

    protected static <E> zzfi<E> zzl() {
        return zzgw.zzd();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgh
    public final /* synthetic */ zzgk zzm() {
        zza zzaVar = (zza) zza(zzf.zze, (Object) null, (Object) null);
        zzaVar.zza((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgj
    public final /* synthetic */ zzgh zzi() {
        return (zzez) zza(zzf.zzf, (Object) null, (Object) null);
    }
}
