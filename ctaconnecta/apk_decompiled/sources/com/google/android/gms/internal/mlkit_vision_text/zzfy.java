package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.internal.mlkit_vision_text.zzfy;
import com.google.android.gms.internal.mlkit_vision_text.zzfy.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class zzfy<MessageType extends zzfy<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzep<MessageType, BuilderType> {
    private static Map<Object, zzfy<?, ?>> zzd = new ConcurrentHashMap();
    protected zzio zzb = zzio.zza();
    private int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static class zzc<T extends zzfy<T, ?>> extends zzeq<T> {
        private final T zza;

        public zzc(T t) {
            this.zza = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    static final class zzd implements zzfs<zzd> {
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfs
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfs
        public final zzjd zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfs
        public final zzjg zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfs
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfs
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfs
        public final zzhj zza(zzhj zzhjVar, zzhg zzhgVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfs
        public final zzhm zza(zzhm zzhmVar, zzhm zzhmVar2) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static abstract class zze<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzfy<MessageType, BuilderType> implements zzhi {
        protected zzfq<zzd> zzc = zzfq.zza();
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
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

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static abstract class zzb<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzhi {
        protected zzb(MessageType messagetype) {
            super(messagetype);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy.zza
        protected void zzc() {
            super.zzc();
            ((zze) this.zza).zzc = (zzfq) ((zze) this.zza).zzc.clone();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy.zza
        /* renamed from: zze */
        public /* synthetic */ zzfy zzg() {
            return (zze) zzg();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy.zza, com.google.android.gms.internal.mlkit_vision_text.zzhj
        public /* synthetic */ zzhg zzg() {
            if (this.zzb) {
                return (zze) this.zza;
            }
            ((zze) this.zza).zzc.zzb();
            return (zze) super.zzg();
        }
    }

    public String toString() {
        return zzhl.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzhs.zza().zza((zzhs) this).zza(this);
        return this.zza;
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static abstract class zza<MessageType extends zzfy<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzeo<MessageType, BuilderType> {
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

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzhi
        public final boolean a_() {
            return zzfy.zza(this.zza, false);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzhj
        /* renamed from: zze, reason: merged with bridge method [inline-methods] */
        public MessageType zzg() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzhs.zza().zza((zzhs) messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzhj
        /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
        public final MessageType zzh() {
            MessageType messagetype = (MessageType) zzg();
            if (messagetype.a_()) {
                return messagetype;
            }
            throw new zzim(messagetype);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzeo
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzc();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzhs.zza().zza((zzhs) messagetype).zzb(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzeo
        /* renamed from: zzb */
        public final /* synthetic */ zzeo clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_text.zzhi
        public final /* synthetic */ zzhg zzi() {
            return this.zzc;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzeo
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
            return zzhs.zza().zza((zzhs) this).zza(this, (zzfy<MessageType, BuilderType>) obj);
        }
        return false;
    }

    protected final <MessageType extends zzfy<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzh() {
        return (BuilderType) zza(zzf.zze, (Object) null, (Object) null);
    }

    protected final <MessageType extends zzfy<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zza(MessageType messagetype) {
        return (BuilderType) zzh().zza((zza) messagetype);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhi
    public final boolean a_() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzep
    final int zzg() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzep
    final void zza(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhg
    public final void zza(zzfl zzflVar) throws IOException {
        zzhs.zza().zza((zzhs) this).zza((zzhx) this, (zzjj) zzfn.zza(zzflVar));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhg
    public final int zzj() {
        if (this.zzc == -1) {
            this.zzc = zzhs.zza().zza((zzhs) this).zzb(this);
        }
        return this.zzc;
    }

    static <T extends zzfy<?, ?>> T zza(Class<T> cls) throws ClassNotFoundException {
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
        T t2 = (T) ((zzfy) zziv.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null);
        if (t2 == null) {
            throw new IllegalStateException();
        }
        zzd.put(cls, t2);
        return t2;
    }

    protected static <T extends zzfy<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzhg zzhgVar, String str, Object[] objArr) {
        return new zzhu(zzhgVar, str, objArr);
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

    protected static final <T extends zzfy<T, ?>> boolean zza(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zzf.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzd = zzhs.zza().zza((zzhs) t).zzd(t);
        if (z) {
            t.zza(zzf.zzb, zZzd ? t : null, null);
        }
        return zZzd;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_text.zzfz, com.google.android.gms.internal.mlkit_vision_text.zzgf] */
    protected static zzgf zzk() {
        return zzfz.zzd();
    }

    protected static <E> zzgh<E> zzl() {
        return zzhv.zzd();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhg
    public final /* synthetic */ zzhj zzm() {
        zza zzaVar = (zza) zza(zzf.zze, (Object) null, (Object) null);
        zzaVar.zza((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhi
    public final /* synthetic */ zzhg zzi() {
        return (zzfy) zza(zzf.zzf, (Object) null, (Object) null);
    }
}
