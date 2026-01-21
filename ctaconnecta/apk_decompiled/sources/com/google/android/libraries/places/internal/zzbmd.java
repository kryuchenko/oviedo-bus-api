package com.google.android.libraries.places.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbmd extends zzbbs {
    private static final Method zzp;
    final zzbdb zzc;
    final List zzd;
    final String zze;
    final String zzf;
    final zzazq zzg;
    final zzazd zzh;
    final long zzi;
    final zzbah zzj;
    final zzbqn zzk;
    final zzbqn zzl;
    private final List zzq;
    private final zzbmc zzr;
    private final zzbmb zzs;
    private static final Logger zzm = Logger.getLogger(zzbmd.class.getName());
    static final long zza = TimeUnit.MINUTES.toMillis(30);
    static final long zzb = TimeUnit.SECONDS.toMillis(1);
    private static final zzbqn zzt = zzbqn.zza(zzbjd.zzp);
    private static final zzazq zzn = zzazq.zzb();
    private static final zzazd zzo = zzazd.zza();

    static {
        Method declaredMethod = null;
        try {
            Class<?> cls = Class.forName("com.google.android.libraries.places.internal.zzbea");
            Class<?> cls2 = Boolean.TYPE;
            declaredMethod = cls.getDeclaredMethod("getClientInterceptor", cls2, cls2, cls2, cls2);
        } catch (ClassNotFoundException e) {
            zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "<clinit>", "Unable to apply census stats", (Throwable) e);
        } catch (NoSuchMethodException e2) {
            zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "<clinit>", "Unable to apply census stats", (Throwable) e2);
        }
        zzp = declaredMethod;
    }

    public zzbmd(String str, @Nullable zzayl zzaylVar, @Nullable zzayf zzayfVar, zzbmc zzbmcVar, @Nullable zzbmb zzbmbVar) {
        zzbqn zzbqnVar = zzt;
        this.zzk = zzbqnVar;
        this.zzl = zzbqnVar;
        this.zzq = new ArrayList();
        this.zzc = zzbdb.zzb();
        this.zzd = new ArrayList();
        this.zzf = "pick_first";
        this.zzg = zzn;
        this.zzh = zzo;
        this.zzi = zza;
        this.zzj = zzbah.zza();
        zzmt.zzc(str, TypedValues.AttributesType.S_TARGET);
        this.zze = str;
        this.zzr = zzbmcVar;
        this.zzs = zzbmbVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbbs
    public final zzbbr zza() {
        zzayp zzaypVar;
        zzbfw zzbfwVarZza = this.zzr.zza();
        zzbij zzbijVar = new zzbij();
        zzbqn zzbqnVarZza = zzbqn.zza(zzbjd.zzp);
        zznc zzncVar = zzbjd.zzr;
        ArrayList arrayList = new ArrayList(this.zzq);
        Method method = zzp;
        zzayp zzaypVar2 = null;
        if (method != null) {
            try {
                zzaypVar = (zzayp) method.invoke(null, true, true, false, true);
            } catch (IllegalAccessException e) {
                zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e);
            } catch (InvocationTargetException e2) {
                zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e2);
            }
        } else {
            zzaypVar = null;
        }
        if (zzaypVar != null) {
            arrayList.add(0, zzaypVar);
        }
        try {
            zzaypVar2 = (zzayp) Class.forName("com.google.android.libraries.places.internal.zzbeb").getDeclaredMethod("getClientInterceptor", null).invoke(null, null);
        } catch (ClassNotFoundException e3) {
            zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e3);
        } catch (IllegalAccessException e4) {
            zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e4);
        } catch (NoSuchMethodException e5) {
            zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e5);
        } catch (InvocationTargetException e6) {
            zzm.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e6);
        }
        if (zzaypVar2 != null) {
            arrayList.add(0, zzaypVar2);
        }
        return new zzbmf(new zzbma(this, zzbfwVarZza, zzbijVar, zzbqnVarZza, zzncVar, arrayList, zzbqt.zza));
    }

    final int zzb() {
        this.zzs.zza();
        return 443;
    }
}
