package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbbq {
    private static final Logger zza = Logger.getLogger(zzbbq.class.getName());
    private static zzbbq zzb;
    private static final Iterable zzc;
    private final LinkedHashSet zzd = new LinkedHashSet();
    private final LinkedHashMap zze = new LinkedHashMap();

    static {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("com.google.android.libraries.places.internal.zzbnq"));
        } catch (ClassNotFoundException e) {
            zza.logp(Level.WARNING, "io.grpc.LoadBalancerRegistry", "getHardCodedClasses", "Unable to find pick-first LoadBalancer", (Throwable) e);
        }
        try {
            arrayList.add(Class.forName("com.google.android.libraries.places.internal.zzbvo"));
        } catch (ClassNotFoundException e2) {
            zza.logp(Level.FINE, "io.grpc.LoadBalancerRegistry", "getHardCodedClasses", "Unable to find round-robin LoadBalancer", (Throwable) e2);
        }
        zzc = Collections.unmodifiableList(arrayList);
    }

    public static synchronized zzbbq zzb() {
        if (zzb == null) {
            List<zzbbo> listZza = zzbdi.zza(zzbbo.class, zzc, zzbbo.class.getClassLoader(), new zzbbp());
            zzb = new zzbbq();
            for (zzbbo zzbboVar : listZza) {
                zza.logp(Level.FINE, "io.grpc.LoadBalancerRegistry", "getDefaultRegistry", "Service loader found ".concat(String.valueOf(String.valueOf(zzbboVar))));
                zzb.zzc(zzbboVar);
            }
            zzb.zzd();
        }
        return zzb;
    }

    private final synchronized void zzc(zzbbo zzbboVar) {
        zzbboVar.zze();
        this.zzd.add(zzbboVar);
    }

    private final synchronized void zzd() {
        this.zze.clear();
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            zzbbo zzbboVar = (zzbbo) it.next();
            String strZzd = zzbboVar.zzd();
            if (((zzbbo) this.zze.get(strZzd)) != null) {
                zzbboVar.zzb();
            } else {
                this.zze.put(strZzd, zzbboVar);
            }
        }
    }

    @Nullable
    public final synchronized zzbbo zza(String str) {
        return (zzbbo) this.zze.get(str);
    }
}
