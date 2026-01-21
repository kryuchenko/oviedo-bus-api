package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import com.google.android.gms.internal.vision.zzgx.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public abstract class zzgx<MessageType extends zzgx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzey<MessageType, BuilderType> {
    private static Map<Object, zzgx<?, ?>> zzwu = new ConcurrentHashMap();
    protected zzjr zzws = zzjr.zzih();
    private int zzwt = -1;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static class zzc<T extends zzgx<T, ?>> extends zzfd<T> {
        private final T zzwp;

        public zzc(T t) {
            this.zzwp = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public enum zzf {
        public static final int zzxa = 1;
        public static final int zzxb = 2;
        public static final int zzxc = 3;
        public static final int zzxd = 4;
        public static final int zzxe = 5;
        public static final int zzxf = 6;
        public static final int zzxg = 7;
        private static final /* synthetic */ int[] zzxh = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzxi = 1;
        public static final int zzxj = 2;
        private static final /* synthetic */ int[] zzxk = {1, 2};
        public static final int zzxl = 1;
        public static final int zzxm = 2;
        private static final /* synthetic */ int[] zzxn = {1, 2};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzxh.clone();
        }
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static abstract class zzb<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzij {
        protected zzb(MessageType messagetype) {
            super(messagetype);
        }

        @Override // com.google.android.gms.internal.vision.zzgx.zza
        protected void zzfz() {
            super.zzfz();
            ((zze) this.zzwq).zzwz = (zzgn) ((zze) this.zzwq).zzwz.clone();
        }

        @Override // com.google.android.gms.internal.vision.zzgx.zza
        /* renamed from: zzga */
        public /* synthetic */ zzgx zzgc() {
            return (zze) zzgc();
        }

        @Override // com.google.android.gms.internal.vision.zzgx.zza, com.google.android.gms.internal.vision.zzig
        public /* synthetic */ zzih zzgc() {
            if (this.zzwr) {
                return (zze) this.zzwq;
            }
            ((zze) this.zzwq).zzwz.zzdq();
            return (zze) super.zzgc();
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static abstract class zze<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgx<MessageType, BuilderType> implements zzij {
        protected zzgn<zzd> zzwz = zzgn.zzfo();

        final zzgn<zzd> zzgl() {
            if (this.zzwz.isImmutable()) {
                this.zzwz = (zzgn) this.zzwz.clone();
            }
            return this.zzwz;
        }

        /* JADX WARN: Type inference failed for: r1v8, types: [Type, java.util.ArrayList, java.util.List] */
        public final <Type> Type zzc(zzgj<MessageType, Type> zzgjVar) {
            zzg zzgVarZza = zzgx.zza(zzgjVar);
            if (zzgVarZza.zzxo != ((zzgx) zzge())) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
            Type type = (Type) this.zzwz.zza((zzgn<zzd>) zzgVarZza.zzxq);
            if (type == null) {
                return zzgVarZza.zzgl;
            }
            if (zzgVarZza.zzxq.zzwx) {
                if (zzgVarZza.zzxq.zzww.zziq() != zzki.ENUM) {
                    return type;
                }
                ?? r1 = (Type) new ArrayList();
                Iterator it = ((List) type).iterator();
                while (it.hasNext()) {
                    r1.add(zzgVarZza.zzj(it.next()));
                }
                return r1;
            }
            return (Type) zzgVarZza.zzj(type);
        }
    }

    public String toString() {
        return zzii.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzrx != 0) {
            return this.zzrx;
        }
        this.zzrx = zzis.zzhp().zzv(this).hashCode(this);
        return this.zzrx;
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    static final class zzd implements zzgp<zzd> {
        final zzkf zzww;
        final zzha<?> zzwv = null;
        final int number = 202056002;
        final boolean zzwx = true;
        final boolean zzwy = false;

        zzd(zzha<?> zzhaVar, int i, zzkf zzkfVar, boolean z, boolean z2) {
            this.zzww = zzkfVar;
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final int zzah() {
            return this.number;
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final zzkf zzft() {
            return this.zzww;
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final zzki zzfu() {
            return this.zzww.zziq();
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final boolean zzfv() {
            return this.zzwx;
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final boolean zzfw() {
            return this.zzwy;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.vision.zzgp
        public final zzig zza(zzig zzigVar, zzih zzihVar) {
            return ((zza) zzigVar).zza((zza) zzihVar);
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final zzim zza(zzim zzimVar, zzim zzimVar2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            return this.number - ((zzd) obj).number;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static abstract class zza<MessageType extends zzgx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzfb<MessageType, BuilderType> {
        private final MessageType zzwp;
        protected MessageType zzwq;
        protected boolean zzwr = false;

        protected zza(MessageType messagetype) {
            this.zzwp = messagetype;
            this.zzwq = (MessageType) messagetype.zza(zzf.zzxd, null, null);
        }

        protected void zzfz() {
            MessageType messagetype = (MessageType) this.zzwq.zza(zzf.zzxd, null, null);
            zza(messagetype, this.zzwq);
            this.zzwq = messagetype;
        }

        @Override // com.google.android.gms.internal.vision.zzij
        public final boolean isInitialized() {
            return zzgx.zza(this.zzwq, false);
        }

        @Override // com.google.android.gms.internal.vision.zzig
        /* renamed from: zzga, reason: merged with bridge method [inline-methods] */
        public MessageType zzgc() {
            if (this.zzwr) {
                return this.zzwq;
            }
            MessageType messagetype = this.zzwq;
            zzis.zzhp().zzv(messagetype).zzh(messagetype);
            this.zzwr = true;
            return this.zzwq;
        }

        @Override // com.google.android.gms.internal.vision.zzig
        /* renamed from: zzgb, reason: merged with bridge method [inline-methods] */
        public final MessageType zzgd() {
            MessageType messagetype = (MessageType) zzgc();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzjp(messagetype);
        }

        @Override // com.google.android.gms.internal.vision.zzfb
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzwr) {
                zzfz();
                this.zzwr = false;
            }
            zza(this.zzwq, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzis.zzhp().zzv(messagetype).zzd(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzgi zzgiVar) throws zzhh {
            if (this.zzwr) {
                zzfz();
                this.zzwr = false;
            }
            try {
                zzis.zzhp().zzv(this.zzwq).zza(this.zzwq, bArr, 0, i2, new zzfg(zzgiVar));
                return this;
            } catch (zzhh e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzhh.zzgn();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.vision.zzfb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final BuilderType zza(zzfy zzfyVar, zzgi zzgiVar) throws IOException {
            if (this.zzwr) {
                zzfz();
                this.zzwr = false;
            }
            try {
                zzis.zzhp().zzv(this.zzwq).zza(this.zzwq, zzgd.zza(zzfyVar), zzgiVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        @Override // com.google.android.gms.internal.vision.zzfb
        public final /* synthetic */ zzfb zza(byte[] bArr, int i, int i2, zzgi zzgiVar) throws zzhh {
            return zzb(bArr, 0, i2, zzgiVar);
        }

        @Override // com.google.android.gms.internal.vision.zzfb
        /* renamed from: zzdo */
        public final /* synthetic */ zzfb clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.vision.zzij
        public final /* synthetic */ zzih zzge() {
            return this.zzwp;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.vision.zzfb
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzwp.zza(zzf.zzxe, null, null);
            zzaVar.zza((zza) zzgc());
            return zzaVar;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static class zzg<ContainingType extends zzih, Type> extends zzgj<ContainingType, Type> {
        final Type zzgl;
        final ContainingType zzxo;
        final zzih zzxp;
        final zzd zzxq;

        zzg(ContainingType containingtype, Type type, zzih zzihVar, zzd zzdVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (zzdVar.zzww == zzkf.zzacl && zzihVar == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.zzxo = containingtype;
            this.zzgl = type;
            this.zzxp = zzihVar;
            this.zzxq = zzdVar;
        }

        final Object zzj(Object obj) {
            return this.zzxq.zzww.zziq() == zzki.ENUM ? this.zzxq.zzwv.zzh(((Integer) obj).intValue()) : obj;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzis.zzhp().zzv(this).equals(this, (zzgx) obj);
        }
        return false;
    }

    protected final <MessageType extends zzgx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzgf() {
        return (BuilderType) zza(zzf.zzxe, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.vision.zzij
    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    @Override // com.google.android.gms.internal.vision.zzey
    final int zzdm() {
        return this.zzwt;
    }

    @Override // com.google.android.gms.internal.vision.zzey
    final void zzae(int i) {
        this.zzwt = i;
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final void zzb(zzgf zzgfVar) throws IOException {
        zzis.zzhp().zzv(this).zza(this, zzgh.zza(zzgfVar));
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final int zzgg() {
        if (this.zzwt == -1) {
            this.zzwt = zzis.zzhp().zzv(this).zzs(this);
        }
        return this.zzwt;
    }

    static <T extends zzgx<?, ?>> T zzd(Class<T> cls) throws ClassNotFoundException {
        T t = (T) zzwu.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) zzwu.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        T t2 = (T) ((zzgx) zzju.zzh(cls)).zza(zzf.zzxf, (Object) null, (Object) null);
        if (t2 == null) {
            throw new IllegalStateException();
        }
        zzwu.put(cls, t2);
        return t2;
    }

    protected static <T extends zzgx<?, ?>> void zza(Class<T> cls, T t) {
        zzwu.put(cls, t);
    }

    protected static Object zza(zzih zzihVar, String str, Object[] objArr) {
        return new zziu(zzihVar, str, objArr);
    }

    public static <ContainingType extends zzih, Type> zzg<ContainingType, Type> zza(ContainingType containingtype, zzih zzihVar, zzha<?> zzhaVar, int i, zzkf zzkfVar, boolean z, Class cls) {
        return new zzg<>(containingtype, Collections.EMPTY_LIST, zzihVar, new zzd(null, 202056002, zzkfVar, true, false), cls);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>, T> zzg<MessageType, T> zza(zzgj<MessageType, T> zzgjVar) {
        return (zzg) zzgjVar;
    }

    protected static final <T extends zzgx<T, ?>> boolean zza(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zzf.zzxa, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzu = zzis.zzhp().zzv(t).zzu(t);
        if (z) {
            t.zza(zzf.zzxb, zZzu ? t : null, null);
        }
        return zZzu;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.zzgz, com.google.android.gms.internal.vision.zzhc] */
    protected static zzhc zzgh() {
        return zzgz.zzgm();
    }

    protected static <E> zzhe<E> zzgi() {
        return zziv.zzhs();
    }

    protected static <E> zzhe<E> zza(zzhe<E> zzheVar) {
        int size = zzheVar.size();
        return zzheVar.zzah(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzgx<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzgi zzgiVar) throws zzhh {
        T t2 = (T) t.zza(zzf.zzxd, null, null);
        try {
            zziw zziwVarZzv = zzis.zzhp().zzv(t2);
            zziwVarZzv.zza(t2, bArr, 0, i2, new zzfg(zzgiVar));
            zziwVarZzv.zzh(t2);
            if (t2.zzrx == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzhh) {
                throw ((zzhh) e.getCause());
            }
            throw new zzhh(e.getMessage()).zzg(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzhh.zzgn().zzg(t2);
        }
    }

    private static <T extends zzgx<T, ?>> T zzb(T t) throws zzhh {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzhh(new zzjp(t).getMessage()).zzg(t);
    }

    protected static <T extends zzgx<T, ?>> T zza(T t, byte[] bArr) throws zzhh {
        return (T) zzb(zza(t, bArr, 0, bArr.length, zzgi.zzfm()));
    }

    protected static <T extends zzgx<T, ?>> T zza(T t, byte[] bArr, zzgi zzgiVar) throws zzhh {
        return (T) zzb(zza(t, bArr, 0, bArr.length, zzgiVar));
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final /* synthetic */ zzig zzgj() {
        zza zzaVar = (zza) zza(zzf.zzxe, (Object) null, (Object) null);
        zzaVar.zza((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final /* synthetic */ zzig zzgk() {
        return (zza) zza(zzf.zzxe, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.vision.zzij
    public final /* synthetic */ zzih zzge() {
        return (zzgx) zza(zzf.zzxf, (Object) null, (Object) null);
    }
}
